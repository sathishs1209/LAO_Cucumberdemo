package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions (features=".//Features/customers.feature",
				glue="stepDefinitions",
				dryRun = false,
				monochrome = true,
				plugin = {"json:target/cucumber.json"}
				)
public class TestRunner {

}
