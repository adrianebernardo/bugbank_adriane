package PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement esperar(By by) {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement getSaldoText() {
        return esperar(By.id("textBalance"));
    }

    public WebElement getTransferenciaButton() {
        return esperar(By.id("btn-TRANSFERÊNCIA"));
    }

    public WebElement getExtratoButton() {
        return esperar(By.id("btn-EXTRATO"));
    }
}
