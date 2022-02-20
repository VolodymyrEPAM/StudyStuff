package cucumber.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webdriver.BasePage;

public class BasketPage extends BasePage {
    private final static long TIME_TO_WAIT = 15;
    @FindBy(xpath = "//a[@class='checkout-btn btn original-bucket']")
    WebElement checkoutButton;
    @FindBy(xpath = "//dl[@class='total']//dd")
    WebElement totalPrice;

    public BasketPage(WebDriver driver) {
        super(driver);
    }

    public void clickCheckout() {
        checkoutButton.click();
        waitForPageLoadComplete(TIME_TO_WAIT);
    }

    public String getTotalPrice() {
        return (totalPrice.getText()
                .replace(",", ".")
                .replace("€", ""))
                .trim();
    }
}
