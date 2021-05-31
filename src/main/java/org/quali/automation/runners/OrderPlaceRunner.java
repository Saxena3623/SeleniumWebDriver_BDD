package org.quali.automation.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/test/resources/featurefiles/Order_Tshirt.feature", glue = "org.quali.automation.stepDefs", plugin = {
		"pretty" ,"html:target/cucumber-html-report-order_place", "json:target/cucumber-report-order_place.json" })

public class OrderPlaceRunner extends AbstractTestNGCucumberTests {

}
