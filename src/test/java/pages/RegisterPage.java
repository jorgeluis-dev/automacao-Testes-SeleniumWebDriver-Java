package pages;
 
import org.openqa.selenium.By;

public class RegisterPage extends BasePage {
    //LOCATORS
    private By emailAddressLocator = By.id("email_create");
    private By submitBtnLocator = By.id("SubmitCreate");
    
    private By alertAdditionalInformationLocator = By.xpath("//*[@id=\"account-creation_form\"]/div[1]/div[5]/span");

    //LOCATORS YOUR PERSONAL INFORMATION
    private By genderMaleLocator = By.id("id_gender1");
    private By firstNameLocator = By.id("customer_firstname");
    private By lastNameLocator = By.id("customer_lastname");
    private By  emailLocator = By.id("email");
    private By passwordLocator = By.id("passwd");
    //DATE
    private By daysLocator = By.id("days");
    private By monthLocator = By.id("months");
    private By yearLocator = By.id("years");

    private By newletterLocator = By.id("newsletter");
    private By registerBtnLocator = By.id("submitAccount");

    //WELCOME MENSAGE LOCATOR
    private By welcomeMessageLocator = By.cssSelector("#center_column > p.info-account");



    //1. Funcao para verificar se o email existe na tela e clicar no botao.
    public void insertEmailToRegister(){
        if(super.isDisplayed(emailAddressLocator)){
            type("emailjorgeteste2@gmail.com", emailAddressLocator);
            click(submitBtnLocator);
        } else {
            System.out.println("Email text box was not present in page");
        }
    }

    //2. Assertiva do email
    // -> Criamos a funcao : getTextByAttribute
    public String getEmailNewAccount(){
        //espere a pagina carregar, para pegar o elemento
        super.waitVisibilityOfElementLocated(alertAdditionalInformationLocator);
        return super.getTextByAttribute(this.emailLocator, "value");
        
    }

    // Metodo para preenchimento formulario
    public void fillOutForm(){
        this.insertEmailToRegister();
        super.waitVisibilityOfElementLocated(alertAdditionalInformationLocator);
        //Agora vamos completar o formulario
        if(super.isDisplayed(genderMaleLocator)){
            super.click(genderMaleLocator);
            super.type("Jorge", firstNameLocator);
            super.type("Luis", lastNameLocator);
            super.type("teste", passwordLocator);
            //data com select
            selectByValue(daysLocator, "4");
            selectByValue(monthLocator, "6");
            selectByValue(yearLocator, "1994");
            click(newletterLocator);
            click(registerBtnLocator);

        } else {
            System.out.println("message was not found.");
        }
    }

    //metodo para verificar assertiva do registro
    public String getWelcomeMessage(){
        super.waitVisibilityOfElementLocated(welcomeMessageLocator);
        return super.getText(welcomeMessageLocator);
    }
}
