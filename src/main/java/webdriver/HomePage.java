package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.Keys.ENTER;

public class HomePage extends BasePage{
    private final static long TIME_TO_WAIT = 15;

    @FindBy(xpath = "//a[@class='brand-link']")
    private WebElement logo;
    @FindBy(xpath = "//div[@class='user-nav']//li[contains(.,'Sign in/Join')]")
    private WebElement signIn;
    @FindBy(xpath = "//input[@type='text']")
    private WebElement searchField;
    @FindBy(xpath = "//div[@class='secondary-header'][contains(.,'Shop by category')]")
    private WebElement navigationMenu;
    @FindBy(xpath = "//div[@class='block-wrap promo twoThird noHead no-heading']")
    private WebElement banner;
    @FindBy(xpath = "//div[@class='right-section']//a[@class='basket-btn']")
    private WebElement basketIcon;

    public WebElement getBasketIcon() {
        return basketIcon;
    }

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public Boolean isAllElementsOnHomePageVisible(){
        waitForPageLoadComplete(TIME_TO_WAIT);
        List<WebElement> listOfPageElements = new ArrayList<WebElement>() {{
   add(logo);
   add(signIn);
   add(searchField);
   add(navigationMenu);
   add(banner);
   add(basketIcon);
        }};
        return listOfPageElements.stream().allMatch(WebElement::isDisplayed);
    }

    public void search(String searchItem){
        searchField.click();
        searchField.sendKeys(searchItem,ENTER);
        waitForPageLoadComplete(TIME_TO_WAIT);
    }
}
