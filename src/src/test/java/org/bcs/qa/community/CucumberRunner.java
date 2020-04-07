package org.bcs.qa.community;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "org.bcs.qa.community",
        strict = true
)
public class CucumberRunner {
}
