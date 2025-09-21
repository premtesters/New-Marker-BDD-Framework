package testScriptRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.*;


@RunWith(Cucumber.class)

@CucumberOptions(
features = {"src/test/resources/features/01LoginFeatures.feature",
"src/test/resources/features/02HomeFeatures.feature"},
glue= "stepDefinitions",
stepNotifications =true,

plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

public class scriptRunner {

}