package regextest;

import org.junit.Test;
import regextestpages.HomeTaskPage;
import utils.RegexPatterns;

import static org.junit.Assert.assertEquals;

public class HomeTaskTest extends BaseTest {
    private static final String STREET_NUMBER = "41";
    private static final String STREET_NAME = "University Drive";
    private static final String SUIT_NUMBER = "202";
    private static final String STATE = "Newtown";
    private static final String POSTAL_CODE = "PA 18940";
    private static final String COUNTRY = "USA";

    @Test
    public void verifyCorrectAddressValues() {
        HomeTaskPage homeTaskPage = new HomeTaskPage(getDriver());
        String address = homeTaskPage.getTextOfAddress();

        assertEquals(STREET_NUMBER, RegexPatterns.getStreetNumber(address));
        assertEquals(STREET_NAME, RegexPatterns.getStreetName(address));
        assertEquals(SUIT_NUMBER, RegexPatterns.getSuiteNumber(address));
        assertEquals(STATE, RegexPatterns.getStateName(address));
        assertEquals(POSTAL_CODE, RegexPatterns.getPostalCode(address));
        assertEquals(COUNTRY, RegexPatterns.getCountry(address));
    }
}
