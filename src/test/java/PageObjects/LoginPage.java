package PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement esperar(By by) {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement getEmailInput() {
        return esperar(By.cssSelector(".card__login input[name='email']"));
    }

    public WebElement getPasswordInput() {
        return esperar(By.cssSelector(".card__login input[name='password']"));
    }

    public WebElement getLoginButton() {
        return esperar(By.xpath("//button[normalize-space()='Acessar']"));
    }

    public WebElement getRegistrarButton() {
        return esperar(By.xpath("//button[normalize-space()='Registrar']"));
    }
}
