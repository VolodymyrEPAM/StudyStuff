package cucumber.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webdriver.BasePage;

@Getter
public class BookPage extends BasePage {

    @FindBy(xpath = "//a[@class='btn btn-primary add-to-basket']")
    private WebElement addToCartButton;

    public BookPage(WebDriver driver) {
        super(driver);
    }

    public void clickAddToCartButton() {
        addToCartButton.click();
    }
}