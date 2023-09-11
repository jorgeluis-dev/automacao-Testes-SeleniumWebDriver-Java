

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginTest {
    private WebDriver driver;
    
    @BeforeEach
    void setUp() throws Exception {
        System.getProperty("webdriver.gecko.driver", "drivers\\firefoxdriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://magento.softwaretestingboard.com/customer/account/login/");

    }

    @AfterEach
    void tearDown() throws Exception {
        driver.quit();
    }

    @Test
    void test(){
        // Aqui fazemos o teste

        //1. Driver encontre os elementos [Email]
        WebElement emailAddressElement = driver.findElement(By.id("email"));
        //2. inserir um valor
        emailAddressElement.sendKeys("jorgeluis.geek@gmail.com");

        //------------------------------

        //3. Driver encontrar [Password]
        WebElement passwordElement = driver.findElement(By.id("pass"));
        passwordElement.sendKeys("xN5MiPmMQyQw.j.");


        //4. Agora encontrar o botao e o evento de clique[action] -> (vamos pesquisar por XPATH)
        WebElement submitBtnElement = driver.findElement(By.xpath("//*[@id=\"send2\"]"));
        submitBtnElement.click();

        //5. Agora vamos criar a Assertiva
        WebElement tagMyAccount = driver.findElement(By.tagName("h1"));

        //6. Quero saber qual o texto tem no H1
        String textTagH1 = tagMyAccount.getText();

        Assertions.assertTrue(textTagH1.equals("My Account"));

    }
}
