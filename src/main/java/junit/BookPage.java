package junit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webdriver.BasePage;

public class BookPage extends BasePage {
    private final static long TIME_TO_WAIT = 15;

    @FindBy(xpath = "//a[@class='btn btn-primary add-to-basket']")
    WebElement addToCartButton;
    @FindBy(xpath = "//a[@data-localizer-string-id='bd_js_basket_checkout']")
    WebElement checkCartPupUpButton;

    public BookPage(WebDriver driver) {
        super(driver);
    }

    public void clickAddToCartButton() {
        addToCartButton.click();
        waitVisibilityOfElement(TIME_TO_WAIT, checkCartPupUpButton);
    }

    public void clickBasketCheckoutButton() {
        checkCartPupUpButton.click();
        waitForPageLoadComplete(TIME_TO_WAIT);
    }
}
