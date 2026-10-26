package Tasks;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import PageObjects.CadastroPage;
import PageObjects.GenericPage;
import PageObjects.LoginPage;
import Validacao.CadastroValidacao;
import Validacao.GenericValidacao;

public class CadastroTask {

    private WebDriver driver;
    private LoginPage loginPage;
    private CadastroPage cadastroPage;
    private GenericPage genericPage;
    private GenericValidacao genericValidacao;
    private CadastroValidacao cadastroValidacao;

    public CadastroTask(WebDriver driver) {
        this.driver = driver;
        loginPage = new LoginPage(this.driver);
        cadastroPage = new CadastroPage(this.driver);
        genericPage = new GenericPage(this.driver);
        genericValidacao = new GenericValidacao(this.driver);
        cadastroValidacao = new CadastroValidacao(this.driver);
    }

    // Cadastra uma conta COM saldo e devolve {numeroConta, digito}
    public String[] cadastrarContaComSaldo(String email, String nome, String senha) {
        loginPage.getRegistrarButton().click();

        cadastroPage.getEmailInput().sendKeys(email);
        cadastroPage.getNomeInput().sendKeys(nome);
        cadastroPage.getPasswordInput().sendKeys(senha);
        cadastroPage.getPasswordConfirmationInput().sendKeys(senha);

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", cadastroPage.getSaldoToggle());
        cadastroPage.getCadastrarButton().click();

        cadastroValidacao.validationContaCriada();
        String[] conta = cadastroValidacao.obterNumeroConta();

        genericPage.getModalCloseButton().click();
        genericValidacao.aguardarModalFechar();
        voltarParaLogin();
        return conta;
    }

    // Se a tela de cadastro continuar aberta depois do modal, volta para o login
    private void voltarParaLogin() {
        List<WebElement> voltar = driver.findElements(By.xpath("//a[normalize-space()='Voltar ao login']"));
        if (!voltar.isEmpty() && voltar.get(0).isDisplayed()) {
            voltar.get(0).click();
        }
    }
}
