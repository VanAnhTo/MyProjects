package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/material/", glue = { "step_definitions.material" }, tags = {
		"~@wip,@hoangnl,@vananh" }, format = { "pretty", "html:target/cucumber", "json:target/cucumber-report.json" })
public class RunCakeTest {

}
