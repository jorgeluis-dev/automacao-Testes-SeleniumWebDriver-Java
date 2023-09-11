package pages;

import org.openqa.selenium.By;

//FILHA de BasePage
public class LoginPage extends BasePage {
        //1. Vamos iniciar os Locators
        private By emailAddressLocator = By.id("email");
        private By passwordLocator = By.id("pass");
        private By submitBtnLocator = By.xpath("//*[@id=\"send2\"]");        
        private By TagMyAccountLocator = By.tagName("h1");

        public void signin(){
                //2. Verificar se existem elementos na tela
                if(super.isDisplayed(emailAddressLocator)){
                        //3.inserir valores nos campos ->
                        super.type("jorgeluis.geek@gmail.com", emailAddressLocator);
                        super.type("xN5MiPmMQyQw.j.", passwordLocator);
                        super.click(submitBtnLocator);
                }else {
                        System.out.println("Textbox was not present");
                }
        }

        //4.verificacao se o login foi realizado
        public String getMyAccountMessage(){
                return super.getText(TagMyAccountLocator);
        }
}
