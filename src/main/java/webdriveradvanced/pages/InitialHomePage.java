package webdriveradvanced.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.Keys.ENTER;

@Getter
public class InitialHomePage extends BasePage {
    private final String PAGE_URL = "https://www.bookdepository.com/";
    @FindBy(xpath = "//input[@placeholder='Search for books by keyword / title / author / ISBN']")
    private WebElement searchBar;

    public InitialHomePage(WebDriver driver) {
        super(driver);
    }

    public void searchItem(String item) {
        searchBar.sendKeys(item, ENTER);
    }

    @Override
    public String getPAGE_URL() {
        return PAGE_URL;
    }
}
