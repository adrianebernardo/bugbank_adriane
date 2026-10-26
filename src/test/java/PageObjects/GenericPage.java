package PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericPage {

    private WebDriver driver;

    public GenericPage(WebDriver driver) {
        this.driver = driver;
    }

    private WebElement esperar(By by) {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement getModalText() {
        return esperar(By.id("modalText"));
    }

    public WebElement getModalCloseButton() {
        return esperar(By.id("btnCloseModal"));
    }

    public WebElement getBackButton() {
        return esperar(By.id("btnBack"));
    }

    public WebElement getExitButton() {
        return esperar(By.id("btnExit"));
    }

    public WebElement getBody() {
        return driver.findElement(By.tagName("body"));
    }
}
