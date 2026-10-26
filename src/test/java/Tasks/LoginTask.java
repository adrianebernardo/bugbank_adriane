package Tasks;

import org.openqa.selenium.WebDriver;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import Validacao.HomeValidacao;

public class LoginTask {

    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;
    private HomeValidacao homeValidacao;

    public LoginTask(WebDriver driver) {
        this.driver = driver;
        loginPage = new LoginPage(this.driver);
        homePage = new HomePage(this.driver);
        homeValidacao = new HomeValidacao(this.driver);
    }

    public void efetuarLogin(String email, String senha, double saldoEsperado) {
        loginPage.getEmailInput().sendKeys(email);
        loginPage.getPasswordInput().sendKeys(senha);
        loginPage.getLoginButton().click();
        homePage.getSaldoText();
        homeValidacao.validationSaldoHome(saldoEsperado);
    }
}
