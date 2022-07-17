package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/main/resources/webdriveradvancedhomework.feature",
        glue = "webdriveradvanced"
)
public class HomeworkTestRunner {
}
