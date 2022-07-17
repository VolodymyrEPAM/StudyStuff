package webdriveradvanced.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;

public class SearchPage extends BasePage {
    private final long TIME = 15;
    @FindBy(xpath = "//div[@class='book-item']")
    private WebElement book;
    @FindAll(@FindBy(xpath = "//div[@class='book-item']"))
    private List<WebElement> books;
    @FindBy(xpath = "//div[@class='form-group']")
    private WebElement filter;
    @FindBy(xpath = "//button[contains(.,'Refine results')]")
    private WebElement refineResultsButton;
    @FindAll(@FindBy(xpath = "//div[@class='book-item']//div/h3[@class='title']//a"))
    private List<WebElement> bookTitles;
    @FindBy(xpath = "//div[@class='modal-body']//a[@data-localizer-string-id='bd_js_basket_checkout']")
    private WebElement popupCheckoutButton;


    public Boolean isBookWithSuchTitleExist(String bookTitle) {
        return book.findElement(By.xpath(format("//meta[@content='%s']", bookTitle))).isEnabled();
    }

    public void clickSpecifiedFilterMode(String filterMode, String modeValue) {
        filter.findElement(By.xpath(format("//label[text()='%s']", filterMode))).click();
        waitForPageLoadComplete(TIME);
        filter.findElement(By.xpath(format("//option[@label='%s']", modeValue))).click();
    }

    public void clickRefineResultsButton() {
        refineResultsButton.click();
    }

    public List<String> getBookTitles() {
        return bookTitles.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public void clickCheckoutButtonInPopup() {
        waitForElementToBeVisible(TIME, popupCheckoutButton);
        popupCheckoutButton.click();
    }

    public void clickAddToCartButtonForSpecifiedBook(String bookTitle) {
        books.stream()
                .filter(book -> book.findElement(By.xpath(format("//meta[@content='%s']", bookTitle))).isEnabled())
                .collect(Collectors.toList())
                .get(0).findElement(By.xpath("//following-sibling::div[@class='item-actions']")).click();
    }

    public SearchPage(WebDriver driver) {
        super(driver);
    }
}
