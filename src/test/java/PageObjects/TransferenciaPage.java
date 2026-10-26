package PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TransferenciaPage {

    private WebDriver driver;

    public TransferenciaPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement esperar(By by) {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement getContaInput() {
        return esperar(By.name("accountNumber"));
    }

    public WebElement getDigitoInput() {
        return esperar(By.name("digit"));
    }

    public WebElement getValorInput() {
        return esperar(By.name("transferValue"));
    }

    public WebElement getDescricaoInput() {
        return esperar(By.name("description"));
    }

    public WebElement getTransferirButton() {
        return esperar(By.xpath("//button[normalize-space()='Transferir agora']"));
    }
}
