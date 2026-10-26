package Tasks;

import org.openqa.selenium.WebDriver;

import PageObjects.GenericPage;
import PageObjects.HomePage;
import Validacao.ExtratoValidacao;
import Validacao.LoginValidacao;

public class ExtratoTask {

    private WebDriver driver;
    private HomePage homePage;
    private GenericPage genericPage;
    private ExtratoValidacao extratoValidacao;
    private LoginValidacao loginValidacao;

    public ExtratoTask(WebDriver driver) {
        this.driver = driver;
        homePage = new HomePage(this.driver);
        genericPage = new GenericPage(this.driver);
        extratoValidacao = new ExtratoValidacao(this.driver);
        loginValidacao = new LoginValidacao(this.driver);
    }

    // Abre o extrato, valida saldo e a transferência, e faz logout
    public void validarExtrato(double saldoEsperado, String descricao) {
        homePage.getExtratoButton().click();
        extratoValidacao.validationSaldoExtrato(saldoEsperado);
        extratoValidacao.validationTransferenciaNoExtrato(descricao);
        genericPage.getBackButton().click();
        genericPage.getExitButton().click();
        loginValidacao.loginValidation();
    }
}
