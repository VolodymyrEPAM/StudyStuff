package webdriveradvanced;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import webdriveradvanced.pagefactory.PageFactoryManager;
import webdriveradvanced.pages.BasketPage;
import webdriveradvanced.pages.InitialHomePage;
import webdriveradvanced.pages.SearchPage;

import java.util.*;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.assertj.core.api.Assertions.assertThat;
import static webdriveradvanced.Constants.*;

public class StepDefs {
    WebDriver driver;
    InitialHomePage initialHomePage;
    SearchPage searchPage;
    BasketPage basketPage;
    PageFactoryManager pageFactoryManager;

    @Before
    public void setUp() {
        chromedriver().setup();
    }

    @After
    public void tierDown() {
        driver.close();
    }

    @Given("I am an anonymous customer with clear cookies")
    public void incognitoModeWithClearCookies() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        driver = new ChromeDriver(capabilities);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @When("I open the {}")
    public void openSpecifiedPage(String pageName) {
        openPage(pageName);
    }

    @When("I search for {}")
    public void search(String searchItem) {
        initialHomePage = pageFactoryManager.getInitialHomePage();
        initialHomePage.searchItem(searchItem);
    }

    @When("I am redirected to a {}")
    public void redirectionTo(String pageRedirectTo) {
        redirection(pageRedirectTo);
    }

    @When("I apply the following search filters")
    public void chooseFilters(Map<String, String> filters) {
        for (Map.Entry<String, String> map : filters.entrySet()) {
            searchPage.clickSpecifiedFilterMode(map.getKey(), map.getValue());
        }
    }

    @When("I click Add to basket button for product with name {}")
    public void clickAddToBasketForCurrentBook(String bookName) {
        searchPage.clickAddToCartButtonForSpecifiedBook(bookName);
    }

    @When("^I select Basket/Checkout in basket pop-up")
    public void clickCheckoutButtonInBasketPopup() {
        searchPage.clickCheckoutButtonInPopup();
    }

    @When("I click Checkout button on Basket page")
    public void clickCheckoutButtonOnBasketPage() {
        basketPage.clickCheckoutButton();
    }

    @When("I checkout as a new customer with email {}")
    public void fillInEmailAsNewCustomer(String email) {
        basketPage.fillInNewCustomerEmail(email);
    }

    @When("I fill delivery address information manually:")
    public void fillAddressInfoManually(DataTable table) {
        basketPage.fillInName(table.cells().get(1).get(0));
        basketPage.selectDeliveryCountry(table.cells().get(1).get(1));
        basketPage.clickEnterAddressManuallyButton();
        basketPage.fillInAddressLine1(table.cells().get(1).get(2));
        basketPage.fillInAddressLine2(table.cells().get(1).get(3));
        basketPage.fillInDeliveryCity(table.cells().get(1).get(4));
        basketPage.fillInDeliveryCounty(table.cells().get(1).get(5));
        basketPage.fillInPostCode(table.cells().get(1).get(6));
    }

    @When("I enter my card details")
    public void enterCardDetails(DataTable table) {
        String expirationDate = table.cells().get(2).get(1) + table.cells().get(1).get(1);
        basketPage.fillInCardNumber(table.cells().get(0).get(1));
        basketPage.fillInCardExpirationDate(expirationDate);
        basketPage.fillInCvv(table.cells().get(3).get(1));
    }

    @Then("Search results contain the following products")
    public void checkSearchResultsAreExist(List<String> expected) {
        SoftAssertions softAssertions = new SoftAssertions();
        expected.forEach(item -> softAssertions.assertThat(searchPage.isBookWithSuchTitleExist(item))
                .describedAs("Verify if book with title %s is exist", item)
                .isTrue());
        softAssertions.assertAll();
    }

    @Then("Search results contain only the following products")
    public void checkSearchResultCorrectness(List<String> expected) {
        searchPage.clickRefineResultsButton();
        assertThat(searchPage.getBookTitles()).isEqualTo(expected);
    }

    @Then("Basket order summary is as following:")
    public void checkOrderCorrectness(DataTable table) {
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(table.cells().get(1).get(0))
                .isEqualTo(basketPage.getTextOfDeliveryCost());
        softAssertions.assertThat(table.cells().get(1).get(1))
                .isEqualTo(basketPage.getTextOfTotalPrice());
        softAssertions.assertAll();
    }

    @Then("Checkout order summary is as following:")
    public void checkFullOrder(DataTable table) {
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(table.cells().get(1).get(0))
                .isEqualTo(basketPage.getPricesText().get(1));
        softAssertions.assertThat(table.cells().get(1).get(1))
                .isEqualTo(basketPage.getPricesText().get(2));
        softAssertions.assertThat(table.cells().get(1).get(2))
                .isEqualTo(basketPage.getPricesText().get(3));
        softAssertions.assertThat(table.cells().get(1).get(3))
                .isEqualTo(basketPage.getPricesText().get(4));
        softAssertions.assertAll();
    }

    private void openPage(String pageName) {
        if (pageName.equals(INITIAL_HOME_PAGE_NAME)) {
            initialHomePage = pageFactoryManager.getInitialHomePage();
            driver.get(initialHomePage.getPAGE_URL());
        }
    }

    private void redirection(String pageName) {

        if (pageName.equals(SEARCH_PAGE_NAME)) {
            searchPage = pageFactoryManager.getSearchPage();
        }

        if (pageName.equals(INITIAL_HOME_PAGE_NAME)) {
            initialHomePage = pageFactoryManager.getInitialHomePage();
        }

        if (pageName.equals(BASKET_PAGE_NAME)) {
            basketPage = pageFactoryManager.getBasketPage();
        }
    }
}
