package junit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webdriver.BasePage;

import static org.openqa.selenium.Keys.ENTER;

public class HomePage extends BasePage {
    private final static long TIME_TO_WAIT = 15;

    @FindBy(xpath = "//input[@type='text']")
    private WebElement searchField;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void search(String searchItem){
        searchField.click();
        searchField.sendKeys(searchItem,ENTER);
        waitForPageLoadComplete(TIME_TO_WAIT);
    }
}
