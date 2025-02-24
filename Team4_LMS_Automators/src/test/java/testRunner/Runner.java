package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)


@CucumberOptions(features={"src/test/resources/Features"},
//tags = " ",

publish=true,
glue= {"stepDefinition","Hooks"},
plugin={"pretty","html:target/CucumberReports/CucumberReport.html",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
//dryRun=true, // checks mapping between scenario steps and step definition methods

		)
public class Runner {

}
