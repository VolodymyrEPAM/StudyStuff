package junit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends BasePage {
    @FindBy(xpath = "//div[@class='wrapper']//dl[contains(.,'Sub-total')]//dd")
    private WebElement subTotalPrice;
    @FindBy(xpath = "//input[@type='text']")
    private WebElement emailInput;

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public Double getSubTotalPrice() {
        return Double.parseDouble(subTotalPrice.getText()
                .replace(",", ".")
                .replace("€", ""));
    }

    public void sendKeysToEmailInput(String input) {
        emailInput.click();
        emailInput.sendKeys(input);
    }
}
