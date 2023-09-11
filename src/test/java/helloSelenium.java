import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class helloSelenium {
    private WebDriver driver;
    
    @Test
    public void helloSelenium() {

        //1. Inicie o WebDriver
        System.getProperty("webdriver.gecko.driver", "drivers\firefoxdriver.exe");

        //2. Referencia do Objeto
        driver = new FirefoxDriver();

        driver.manage().window().maximize();

        //3. Qual a URL vai abrir?
        driver.get("https://magento.softwaretestingboard.com/what-is-new.html");

        //5. Vamos fazer um Acertiva (true or false)

        //6. Qual URL voce ta abrindo?
        String currentURL = driver.getCurrentUrl();
        String expected = "https://magento.softwaretestingboard.com/what-is-new.html";

        //7. Agora o Assert()
        Assertions.assertEquals(expected, currentURL);

        //4. Selenium, agora feche
        driver.quit();

    }
}
