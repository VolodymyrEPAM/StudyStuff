package cucumber.stepdefinitions;

import cucumber.pagefactorymanager.PageFactoryManager;
import cucumber.pages.BasketPage;
import cucumber.pages.BookPage;
import cucumber.pages.HomePage;
import cucumber.pages.PaymentPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.junit.Assert.assertEquals;

import org.assertj.core.api.SoftAssertions;

public class StepsDefinition {
    private final static long TIME_TO_WAIT = 15;
    private final static String EXPECTED_PRICE = "75.79";
    WebDriver driver;
    PageFactoryManager pageFactoryManager;
    HomePage homePage;
    BasketPage basketPage;
    BookPage bookPage;
    PaymentPage paymentPage;

    @Before
    public void setUp() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @After
    public void tierDown() {
        driver.close();
    }

    @And("I open book page by product code: {}")
    public void openBookPageByProductCode(String productCode) {
        homePage = pageFactoryManager.getHomePage();
        homePage.searchWithProductCode(productCode);
    }

    @And("I add current book to cart")
    public void clickAddToCartButton() {
        bookPage = pageFactoryManager.getBookPagePage();
        bookPage.clickAddToCartButton();
    }

    @And("I see that {string} is correct")
    public void checkExpectedTotalPrice(String expectedTotalPrice) {
        basketPage = pageFactoryManager.getBasketPage();
        assertEquals(expectedTotalPrice, basketPage.getTotalPrice());
    }

    @When("I navigate to payment page and fill in {string} field")
    public void navigationToPaymentPageAndFillInEmailField(String email) {
        basketPage.clickCheckout();
        basketPage.waitForPageLoadComplete(TIME_TO_WAIT);
        paymentPage = pageFactoryManager.getPaymentPage();
        paymentPage.sendKeysToEmailInput(email);
    }

    @Then("I see all prices is correct:")
    public void iVerifyThatBothTotalAndSubtotalIsEqualToExpectedPrice(List<String> priceType) {
        SoftAssertions softly = new SoftAssertions();
        priceType.forEach(typeOfPrice -> softly.assertThat(paymentPage.getPrice(typeOfPrice))
                .describedAs("Verify %s price correctness", typeOfPrice)
                .isEqualTo(EXPECTED_PRICE));
        softly.assertAll();
    }
}
