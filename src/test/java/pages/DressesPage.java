package pages;

import org.openqa.selenium.By;

public class DressesPage extends BasePage {
    // Locators
    private By menuDressesLocator = By.cssSelector("#menu-home-page-menu > li.et_pb_menu_page_id-217437.menu-item.menu-item-type-post_type.menu-item-object-page.menu-item-has-children.menu-item-217440 > a");
    private By submenuCasualDressesLocator = By.cssSelector("#menu-home-page-menu > li.et_pb_menu_page_id-217437.menu-item.menu-item-type-post_type.menu-item-object-page.menu-item-has-children.menu-item-217440 > ul > li.et_pb_menu_page_id-216153.menu-item.menu-item-type-custom.menu-item-object-custom.menu-item-216153 > a");
    
    private By titlePageCasualDressesLocator = By.xpath("//*[@id=\"post-217173\"]/div/div[1]/div/div[1]/div/div/div[1]/div/h1/span");

    public void viewCasualDressesPage() {
       if(super.isDisplayed(menuDressesLocator)){
            super.actionMoveToElementPerform(menuDressesLocator);
            super.actionMoveToElementPerformClickPerform(submenuCasualDressesLocator);

       }else {
        System.out.println("Menu dresses was not found");
       }
    }

    // Vamos fazer a verificaçao o titulo H1 da pagina que esta dentro de um span
    public String getTittlePage() {
        return super.getText(titlePageCasualDressesLocator);
    }

}
