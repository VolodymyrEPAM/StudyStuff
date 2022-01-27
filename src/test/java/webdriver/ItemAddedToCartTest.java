package webdriver;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ItemAddedToCartTest extends BaseTest {
    private static final String searchValue = "camileo";
    private static final String expectedMessage = "You have 1 item for a total of";

    @Test
    public void verifyItemIsAddedToCart() {
        HomePage homePage = new HomePage(getDriver());
        SearchResultPage searchResultPage = new SearchResultPage(getDriver());
        BasketPage basketPage = new BasketPage(getDriver());

        homePage.search(searchValue);
        searchResultPage.clickAddToCartButtonForTheFirstItem();
        searchResultPage.clickBasketCheckoutButton();
        assertTrue(basketPage.basketMessage.getText().contains(expectedMessage));
        assertEquals(homePage.getBasketIcon().getText(), "1");
    }
}
