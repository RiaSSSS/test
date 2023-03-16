package StepDefinations;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Feature",
glue={"StepDefinations"},
monochrome=true,
publish = true,
tags="@RegressionTest",
//plugin = {"json:target/cucumber.json"}
plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}

)
public class TestRunner {

}
