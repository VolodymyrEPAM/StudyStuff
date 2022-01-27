package webdriver;

import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class TestVisibilityOfHomePageElements extends BaseTest{

    @Test
    public void verifyVisibilityOfElementsOnHomePage(){
        HomePage homePage = new HomePage(getDriver());
       assertTrue(homePage.isAllElementsOnHomePageVisible());
    }
}
