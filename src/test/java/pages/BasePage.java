package pages;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

//Nao pode ser instanciada
public abstract class BasePage {
    private WebDriver driver;
    private Actions action;
    private WebDriverWait wait; //Espere um pouco selenium, vamos com calma, esta carregando a pagina
    private Select select;

    //1. Construtor
    public BasePage(){
        System.getProperty("webdriver.gecko.driver", "drivers\\firefoxdriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    //2. Encapsular o metodo get do driver
    public void visit(String url){
        this.driver.get(url);
    }

    //3.Encapsular a URL atual do Driver
    public String getCurrentUrl(){
        return this.driver.getCurrentUrl();
    }

    //4. metodo de fechar a comunicacao
    public void quitWebDriver(){
        this.driver.quit();
    }

    //5. Organizar os by elemento find por tags
    public WebElement findElement(By locator){
        return this.driver.findElement(locator);
    }

    //6.SendKeys ->
    public void type(String input, By locator){
        this.driver.findElement(locator).sendKeys(input);
    }

    //7. Criar um metodo para realizar a verificacao, se o elemento esta visivel na pagina
    public Boolean isDisplayed(By locator){
        try {
            return this.driver.findElement(locator).isDisplayed();
        }catch(NoSuchElementException e){
            return false;
        }
    }

    //8. Encapsular o metodo de click do botao
    public void click(By locator){
        this.driver.findElement(locator).click();
    }

    //9. Vamos recuperar o GetText de um elemento Tag
    public String getText(By locator){
        return this.driver.findElement(locator).getText();
    }

    //Metodos da Classe Actions -> Dresses
    public void actionMoveToElementPerform(By locator){
        //2.1 verificar se e null ou nao
        if(this.action == null){
            this.action = new Actions(this.driver);
        }

        //2.2 Agora vamos fazer o Movimento do MoveToElement
        WebElement element = this.driver.findElement(locator);
        action.moveToElement(element).perform();
    }

    //metodo-02
    public void actionMoveToElementPerformClickPerform(By locator){
        //2.1 verificar se e null ou nao
        if(this.action == null){
            this.action = new Actions(this.driver);
        }

        //2.2 Agora vamos fazer o Movimento do MoveToElement
        WebElement element = this.driver.findElement(locator);
        action.moveToElement(element).click().build().perform();
    }


    //Essa parte abaixo tem haver com o RegisterPage.java
    public String getTextByAttribute(By locator, String attributename){
        return this.driver.findElement(locator).getAttribute(attributename);
    }

    //Criar um metodo para aguardar o carregamento da Pagina
    public WebElement waitVisibilityOfElementLocated(By locator, Duration time){
        wait = new WebDriverWait(driver, time);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitVisibilityOfElementLocated(By locator){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    //Metodo para identificar se esta aparecendo uma mensagem na pagina(metodo simples)
    public boolean isContainedInPageSource(String message){
        return driver.getPageSource().contains(message);
    }

    //(Metodo Select) -> Selecionar
    public void selectByValue(By Locator, String value){
        select = new Select(findElement(Locator));
        select.selectByValue(value);
    }

    //Metodo para limpeza dos Campos textbox
    public void clear(By locator){
        findElement(locator).clear();
    }
}
