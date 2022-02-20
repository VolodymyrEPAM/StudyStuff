package cucumber.pagefactorymanager;

import cucumber.pages.*;
import org.openqa.selenium.WebDriver;

public class PageFactoryManager {
    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        return new HomePage(driver);
    }

    public BookPage getBookPagePage() {
        return new BookPage(driver);
    }

    public PaymentPage getPaymentPage() {
        return new PaymentPage(driver);
    }

    public BasketPage getBasketPage() {
        return new BasketPage(driver);
    }
}
