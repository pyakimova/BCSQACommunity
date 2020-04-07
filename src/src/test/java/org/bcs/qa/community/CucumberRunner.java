package bcs.qa.community;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "test/resources/features",
        glue = "bcs.qa.community"
)
public class CucumberRunner {
}
