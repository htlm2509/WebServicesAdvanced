package cucumber.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:src/target/cucumber-reports"},
        monochrome = true,
        tags = "@ApiTest",
        glue = {"cucumber.steps.api", "cucumber.hooks"},
        features = "src/test/resources/features"
)
public class TestRunner {
}
