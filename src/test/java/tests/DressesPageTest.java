package tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pages.DressesPage;

public class DressesPageTest {
    private DressesPage dressesPage;
    private final String URL = "https://ultimateqa.com/";

    @BeforeEach
    void setUp() throws Exception {
        //1.Instancia a Classe
        this.dressesPage = new DressesPage();
        this.dressesPage.visit(this.URL);

    }

    @AfterEach
    void tearDown() throws Exception {
        //2. para fechar a pagina
        this.dressesPage.quitWebDriver();
    }

    @Test
    void test(){
        //3.Agora testando
        
        //when
        this.dressesPage.viewCasualDressesPage();

        //then
        String expected = "MASTER TEST AUTOMATION, FASTER.";
        Assertions.assertEquals(expected, this.dressesPage.getTittlePage());
    }
}
