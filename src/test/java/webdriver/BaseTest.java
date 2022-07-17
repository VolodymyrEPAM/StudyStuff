package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class BaseTest {
    private WebDriver driver;
    private static final String BOOKDEPOSITORY_URL = "https://www.bookdepository.com/";

//    @BeforeTest
//    public void profileSetup() {
//        chromedriver().setup();
//    }
//
//    @BeforeMethod
//    public void testSetup() {
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.get(BOOKDEPOSITORY_URL);
//    }

    @AfterMethod
    public void tierDown() {
        driver.close();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
