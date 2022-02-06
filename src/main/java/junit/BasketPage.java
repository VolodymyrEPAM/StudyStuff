package junit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webdriver.BasePage;

public class BasketPage extends BasePage {
    private final static long TIME_TO_WAIT = 15;
    @FindBy(xpath = "//a[@class='checkout-btn btn original-bucket']")
    WebElement checkoutButton;

    public BasketPage(WebDriver driver) {
        super(driver);
    }

    public void clickCheckout() {
        checkoutButton.click();
        waitForPageLoadComplete(TIME_TO_WAIT);
    }
}
