package regextestpages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import webdriver.BasePage;

@Getter
public class HomeTaskPage extends BasePage {

  @FindBy(xpath = "(//span[@class='source-sans'])[1]")
  private WebElement address;

  public String getTextOfAddress(){
      return address.getText();
  }

    public HomeTaskPage(WebDriver driver) {
        super(driver);
    }

}
