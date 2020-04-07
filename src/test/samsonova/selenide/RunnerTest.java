package samsonova.selenide;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/samsonova/selenide/features",
        glue = "src/test/samsonova/selenide/steps",
        tags = "@all",
        dryRun = false,
        strict = false,
        snippets = CucumberOptions.SnippetType.UNDERSCORE
//        name = "^Успешное|Успешная.*"
)
public class RunnerTest {
}