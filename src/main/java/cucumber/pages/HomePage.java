package cucumber.pages;

import org.openqa.selenium.WebDriver;
import webdriver.BasePage;


public class HomePage extends BasePage {
    private static final String BOOKDEPOSITORY_URL = "https://www.bookdepository.com/";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void searchWithProductCode(String productCode) {
        driver.get(BOOKDEPOSITORY_URL + "search?searchTerm=" + productCode);
    }
}