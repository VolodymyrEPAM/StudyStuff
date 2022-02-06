package junit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webdriver.BasePage;

public class SearchResultPage extends BasePage {
    private final static long TIME_TO_WAIT = 15;

    @FindBy(xpath = "(//div[@class='book-item']//div[@class='btn-wrap'])[1]")
    WebElement firstBookAddToCartButton;
    @FindBy(xpath = "//div[@class='modal-content']//a[@href]")
    WebElement checkCartPupUpButton;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public void clickAddToCartButtonForTheFirstItem() {
        firstBookAddToCartButton.click();
        waitVisibilityOfElement(TIME_TO_WAIT, checkCartPupUpButton);
    }

    public void clickBasketCheckoutButton() {
        checkCartPupUpButton.click();
        waitForPageLoadComplete(TIME_TO_WAIT);
    }
}
