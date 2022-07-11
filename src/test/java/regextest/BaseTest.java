package regextest;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

public class BaseTest {
    private WebDriver driver;
    private static final String HOME_TASK_URL = "https://www.epam.com/about/who-we-are/contact";

    @BeforeClass
    public static void profileSetup() {
        chromedriver().setup();
    }

    @Before
    public void testSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(HOME_TASK_URL);
    }

    @After
    public void tierDown() {
        driver.close();
    }

    public WebDriver getDriver() {
        return driver;
    }
}