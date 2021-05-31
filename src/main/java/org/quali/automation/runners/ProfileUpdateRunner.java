package org.quali.automation.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/test/resources/featurefiles/Update_Profile.feature", glue = "org.quali.automation.stepDefs", plugin = {
		"pretty" ,"html:target/cucumber-html-report-profile_update", "json:target/cucumber-profile_update.json" })

public class ProfileUpdateRunner extends AbstractTestNGCucumberTests {

}
