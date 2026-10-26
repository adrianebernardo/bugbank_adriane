package Framework;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import Framework.Browser.DriverManager;
import Framework.Browser.TypeBrowser;

public class TestBase extends DriverManager {

    private static WebDriver driver;
    private static String URL = "https://bugbank.netlify.app/";

    public static WebDriver getDriverManager() {
        if (driver == null) {
            driver = getManagerDrive(TypeBrowser.CHROME);
        }
        return driver;
    }

    @BeforeEach
    public void setUp() {
        getDriverManager().get(URL);
    }

    @AfterEach
    public void finish() {
        fecharDriver();
        driver = null;
    }
}