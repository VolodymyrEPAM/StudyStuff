package junit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static java.lang.String.format;

public class PaymentPage extends BasePage {
    @FindBy(xpath = "//div[@class='wrapper']")
    private WebElement price;
    @FindBy(xpath = "//div[@class='form-control-wrap']//input[@name='emailAddress']")
    private WebElement emailInput;

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public Double getPrice(String typeOfPrice) {
        return Double.parseDouble(price.findElement(By.xpath(format("//dl[contains(.,'%s')]//dd", typeOfPrice)))
                .getText()
                .replace(",", ".")
                .replace("€", ""));
    }

    public void sendKeysToEmailInput(String input) {
        emailInput.click();
        emailInput.sendKeys(input);
    }
}
