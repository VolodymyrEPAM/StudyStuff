package webdriveradvanced.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class BasketPage extends BasePage {
    private final long TIME = 15;
    @FindBy(xpath = "//dl[@class='delivery-text']//dd")
    private WebElement deliveryCost;
    @FindBy(xpath = "//dl[@class='total']//dd")
    private WebElement total;
    @FindBy(xpath = "//div[@class='basketHeaderButtons']//a[@class='checkout-btn btn original-bucket']")
    private WebElement checkoutButton;
    @FindBy(xpath = "//input[@name='emailAddress']")
    private WebElement newCustomerEmailInput;
    @FindAll(@FindBy(xpath = "//div[@class='wrapper']//dd"))
    private List<WebElement> prices;
    @FindBy(xpath = "//button[@id='delivery-manualEntryDeliveryAddress']")
    private WebElement enterAddressManuallyButton;
    @FindBy(xpath = "//input[@name='delivery-fullName']")
    private WebElement nameInput;
    @FindBy(xpath = "//input[@name='delivery-addressLine1']")
    private WebElement addressLine1;
    @FindBy(xpath = "//input[@name='delivery-addressLine2']")
    private WebElement addressLine2;
    @FindBy(xpath = "//input[@name='delivery-city']")
    private WebElement deliveryCity;
    @FindBy(xpath = "//input[@name='delivery-county']")
    private WebElement deliveryCounty;
    @FindBy(xpath = "//input[@name='delivery-postCode']")
    private WebElement postCode;
    @FindBy(xpath = "//iframe[@name='braintree-hosted-field-number']")
    private WebElement cardNumberIFrame;
    @FindBy(xpath = "//input[@class='number']")
    private WebElement cardNumberInput;
    @FindBy(xpath = "//input[@class='expirationDate']")
    private WebElement expirationDateInput;
    @FindBy(xpath = "//iframe[@name='braintree-hosted-field-expirationDate']")
    private WebElement expirationDateIFrame;
    @FindBy(xpath = "//iframe[@name='braintree-hosted-field-cvv']")
    private WebElement cvvIFrame;
    @FindBy(xpath = "//input[@class='cvv']")
    private WebElement cvvInput;


    public String getTextOfDeliveryCost() {
        return deliveryCost.getText();
    }

    public String getTextOfTotalPrice() {
        return total.getText();
    }

    public void clickCheckoutButton() {
        checkoutButton.click();
        waitForPageLoadComplete(TIME);
    }

    public void fillInNewCustomerEmail(String email) {
        newCustomerEmailInput.sendKeys(email);
    }

    public List<String> getPricesText() {
        return prices.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    public void clickEnterAddressManuallyButton() {
        clickOnHardClickableElement(enterAddressManuallyButton);
        waitForElementToBeVisible(TIME, addressLine1);
    }

    public void selectDeliveryCountry(String country) {
        Select deliveryCountry = new Select(driver.findElement(By.xpath("//select[@id='delivery-CountryDropdown']")));
        deliveryCountry.selectByVisibleText(country);
    }

    public void fillInName(String name) {
        nameInput.sendKeys(name);
    }

    public void fillInAddressLine1(String address) {
        addressLine1.sendKeys(address);
    }

    public void fillInAddressLine2(String address) {
        addressLine2.sendKeys(address);
    }

    public void fillInDeliveryCity(String city) {
        deliveryCity.sendKeys(city);
    }

    public void fillInDeliveryCounty(String county) {
        deliveryCounty.sendKeys(county);
    }

    public void fillInPostCode(String code) {
        if (null == code) {
            code = "";
        }
        postCode.sendKeys(code);
    }

    public void fillInCardNumber(String cardNumber) {
        switchToCardNumberFrame();
        cardNumberInput.sendKeys(cardNumber);
        switchOut();
    }

    public void fillInCardExpirationDate(String expirationDate) {
        switchToExpirationDateFrame();
        expirationDateInput.sendKeys(expirationDate);
        switchOut();
    }

    public void fillInCvv(String cvv) {
        switchToCvvFrame();
        cvvInput.sendKeys(cvv);
        switchOut();
    }

    private BasketPage switchToCardNumberFrame() {
        return new BasketPage(driver.switchTo().frame(cardNumberIFrame));
    }

    private BasketPage switchToExpirationDateFrame() {
        return new BasketPage(driver.switchTo().frame(expirationDateIFrame));
    }

    private BasketPage switchToCvvFrame() {
        return new BasketPage(driver.switchTo().frame(cvvIFrame));
    }

    private BasketPage switchOut() {
        return new BasketPage(driver.switchTo().defaultContent());
    }

    public BasketPage(WebDriver driver) {
        super(driver);
    }
}
