package Validacao;

import java.time.Duration;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageObjects.GenericPage;

public class GenericValidacao {

    private WebDriver driver;
    private GenericPage genericPage;

    public GenericValidacao(WebDriver driver) {
        this.driver = driver;
        genericPage = new GenericPage(this.driver);
    }

    public void validacaoModal(String textoEsperado) {
        String texto = genericPage.getModalText().getText();
        Assertions.assertTrue(texto.contains(textoEsperado),
                "Mensagem do modal inesperada: " + texto);
    }

    public void aguardarModalFechar() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                ExpectedConditions.invisibilityOfElementLocated(By.id("btnCloseModal")));
    }

    public void validarTexto(WebElement elemento, String textoEsperado) {
        Assertions.assertEquals(textoEsperado, elemento.getText());
    }

    // Converte textos como "R$ 1.000,00" em 1000.00
    public double converterValor(String texto) {
        String numero = texto.replaceAll("[^0-9,]", "").replace(",", ".");
        return Double.parseDouble(numero);
    }
}
