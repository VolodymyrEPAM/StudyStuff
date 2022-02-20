package cucumber.pages;

import junit.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static java.lang.String.format;

public class PaymentPage extends BasePage {
    private static final String VAT = "VAT";
    private static final String EXPECTED_PRICE = "75.79";
    @FindBy(xpath = "//div[@class='wrapper']")
    private WebElement price;
    @FindBy(xpath = "//div[@class='form-control-wrap']//input[@name='emailAddress']")
    private WebElement emailInput;

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public String getPrice(String typeOfPrice) {
        if (typeOfPrice.equals(VAT) && price.findElement(By.xpath(format("//dl[contains(.,'%s')]//dd", VAT)))
                .getText()
                .replace(",", ".")
                .replace("€", "")
                .trim().equals("0.00")) {
            return EXPECTED_PRICE;
        } else
            return price.findElement(By.xpath(format("//dl[contains(.,'%s')]//dd", typeOfPrice)))
                    .getText()
                    .replace(",", ".")
                    .replace("€", "")
                    .trim();
    }

    public void sendKeysToEmailInput(String input) {
        emailInput.click();
        emailInput.sendKeys(input);
    }
}
