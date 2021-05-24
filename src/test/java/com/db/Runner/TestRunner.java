package com.db.Runner;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

//@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-pretty", "json:target/Cucumber.json"},
        features = {"src/test/Resources/com/db/features/"},
        glue = {"com/db/StepDefinitions"},
        tags = {"@VerifyTweets"},
        monochrome = true
		)

public class TestRunner extends AbstractTestNGCucumberTests {
}

