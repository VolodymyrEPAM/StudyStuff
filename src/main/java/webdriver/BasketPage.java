package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasketPage extends BasePage{
    @FindBy(xpath = "//div[@class='basket-msg']")
    WebElement basketMessage;

    public BasketPage(WebDriver driver) {
        super(driver);
    }
}
