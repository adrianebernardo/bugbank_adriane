package Tasks;

import org.openqa.selenium.WebDriver;

import PageObjects.GenericPage;
import PageObjects.HomePage;
import PageObjects.TransferenciaPage;
import Validacao.GenericValidacao;
import Validacao.TransferenciaValidacao;

public class TransferenciaTask {

    private WebDriver driver;
    private HomePage homePage;
    private TransferenciaPage transferenciaPage;
    private GenericPage genericPage;
    private GenericValidacao genericValidacao;
    private TransferenciaValidacao transferenciaValidacao;

    public TransferenciaTask(WebDriver driver) {
        this.driver = driver;
        homePage = new HomePage(this.driver);
        transferenciaPage = new TransferenciaPage(this.driver);
        genericPage = new GenericPage(this.driver);
        genericValidacao = new GenericValidacao(this.driver);
        transferenciaValidacao = new TransferenciaValidacao(this.driver);
    }

    public void realizarTransferencia(String[] contaDestino, double valor, String descricao) {
        homePage.getTransferenciaButton().click();

        transferenciaPage.getContaInput().sendKeys(contaDestino[0]);
        transferenciaPage.getDigitoInput().sendKeys(contaDestino[1]);
        transferenciaPage.getValorInput().sendKeys(String.valueOf(valor));
        transferenciaPage.getDescricaoInput().sendKeys(descricao);
        transferenciaPage.getTransferirButton().click();

        transferenciaValidacao.validationSucessoTransferencia();
        genericPage.getModalCloseButton().click();
        genericValidacao.aguardarModalFechar();
        genericPage.getBackButton().click();
    }
}
