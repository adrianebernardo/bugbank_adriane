package PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExtratoPage {

    private WebDriver driver;

    public ExtratoPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement esperar(By by) {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement getSaldoDisponivelText() {
        return esperar(By.id("textBalanceAvailable"));
    }
}
