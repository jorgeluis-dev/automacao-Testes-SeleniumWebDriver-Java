package tests;

import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import pages.LoginPage;


public class LoginPageTest {
    private LoginPage loginPage;
    private final String URL = "https://magento.softwaretestingboard.com/customer/account/login/";
    
    @BeforeEach
    void setUp() throws Exception {
        loginPage = new LoginPage();
        //1. Qual é a URL que queremos navegar?
        loginPage.visit(this.URL);
    }

    @AfterEach
    void tearDown() throws Exception {
        //2. Encerrar o driver

        //esta como comentario para nao fechar
       loginPage.quitWebDriver();
    }

    @Test
    void test(){
        //3. Vamos chamar o metodo para fazer o teste

        //WHEN
        loginPage.signin();

        //THEN
        Assertions.assertTrue(this.loginPage.getMyAccountMessage().equals("My Account"));
        Assertions.assertFalse(this.loginPage.getCurrentUrl().equals(this.URL));
        
    }
}
