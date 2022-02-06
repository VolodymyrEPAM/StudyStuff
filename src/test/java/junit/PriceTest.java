package junit;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PriceTest extends BaseTest {
    private static final String BOOK = "java";
    private static final Double EXPECTED_SUBTOTAL_PRICE = 32.42;
    private static final String EMAIL_INPUT = "test@user.com";

    @Test
    public void verifySubtotalAndTotalPrice() {
        HomePage homePage = new HomePage(getDriver());
        SearchResultPage searchResultPage = new SearchResultPage(getDriver());
        BasketPage basketPage = new BasketPage(getDriver());
        PaymentPage paymentPage = new PaymentPage(getDriver());

        homePage.search(BOOK);
        searchResultPage.clickAddToCartButtonForTheFirstItem();
        searchResultPage.clickBasketCheckoutButton();
        basketPage.clickCheckout();
        paymentPage.sendKeysToEmailInput(EMAIL_INPUT);

        assertEquals(EXPECTED_SUBTOTAL_PRICE, paymentPage.getSubTotalPrice());
    }
}
