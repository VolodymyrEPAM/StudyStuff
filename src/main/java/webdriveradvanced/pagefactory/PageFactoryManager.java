package webdriveradvanced.pagefactory;


import org.openqa.selenium.WebDriver;
import webdriveradvanced.pages.BasketPage;
import webdriveradvanced.pages.InitialHomePage;
import webdriveradvanced.pages.SearchPage;

public class PageFactoryManager {
    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }


    public InitialHomePage getInitialHomePage() {
        return new InitialHomePage(driver);
    }

    public SearchPage getSearchPage() {
        return new SearchPage(driver);
    }

    public BasketPage getBasketPage() {
        return new BasketPage(driver);
    }
}
