package junit;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PriceTest extends BaseTest {
    private static final String PRODUCT_CODE = "9780131872486";
    private static final Double EXPECTED_SUBTOTAL_PRICE = 75.08;
    private static final Double EXPECTED_TOTAL_PRICE = 75.08;
    private static final Double EXPECTED_VAT_PRICE = 0.00;
    private static final String EMAIL_INPUT = "test@user.com";
    private static final String SUBTOTAL_PRICE = "Sub-total";
    private static final String VAT_PRICE = "VAT";
    private static final String TOTAL_PRICE = "Total";

    @Test
    public void verifySubtotalAndTotalPrice() {
        HomePage homePage = new HomePage(getDriver());
        BookPage bookPage = new BookPage(getDriver());
        BasketPage basketPage = new BasketPage(getDriver());
        PaymentPage paymentPage = new PaymentPage(getDriver());

        homePage.searchWithProductCode(PRODUCT_CODE);
        bookPage.clickAddToCartButton();
        bookPage.clickBasketCheckoutButton();
        assertEquals(EXPECTED_TOTAL_PRICE, basketPage.getTotalPrice());

        basketPage.clickCheckout();
        paymentPage.sendKeysToEmailInput(EMAIL_INPUT);

        assertEquals(EXPECTED_SUBTOTAL_PRICE, paymentPage.getPrice(SUBTOTAL_PRICE));
        assertEquals(EXPECTED_TOTAL_PRICE, paymentPage.getPrice(TOTAL_PRICE));
        assertEquals(EXPECTED_VAT_PRICE, paymentPage.getPrice(VAT_PRICE));
    }
}
