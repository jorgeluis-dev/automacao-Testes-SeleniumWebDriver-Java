package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pages.RegisterPage;

public class RegisterPageTest {
    private RegisterPage registerPage;
    private final String URL = "http://www.automationpractice.pl/index.php?controller=authentication&back=my-account";
    
    @BeforeEach
    void setUp() throws Exception {
        this.registerPage = new RegisterPage();
        this.registerPage.visit(this.URL);
    }

    @AfterEach
    void tearDown() throws Exception {
        //this.registerPage.quitWebDriver();

    }

    @Test
    void test(){
        //1. Test do RegisterPage -> Insert email e click button. Assertiva depois do email

        //When
        this.registerPage.insertEmailToRegister();

        //then (assertiva)
        String expected = "emailjorgeteste2@gmail.com";
        String actual = this.registerPage.getEmailNewAccount();
        Assertions.assertEquals(expected, actual);

    }

    //Teste realizado com registro de formulario
    @Test
    void testWithForms(){
        //When
        this.registerPage.fillOutForm();

        //then(assertiva)
        String expected = "Welcome to your account. Here you can manage all of your personal information and orders.";
        String actual = this.registerPage.getWelcomeMessage();
        Assertions.assertEquals(expected, actual);

        String actualUrl = this.registerPage.getCurrentUrl();
        Assertions.assertFalse(this.URL.equals(actualUrl));
    }
}
