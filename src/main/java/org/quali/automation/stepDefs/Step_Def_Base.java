package org.quali.automation.stepDefs;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Reporter;

import org.quali.automation.Session.TestSessionInitiator;

import cucumber.api.*;
import cucumber.api.java.After;
import cucumber.api.java.Before;


public class Step_Def_Base {

	public static org.quali.automation.Session.TestSessionInitiator test;
	public static String timeStamp = new SimpleDateFormat("yyMMddHHmmss").format(new Date());


	@Before(order = 0)
	public void initialSetUp(Scenario scenario) {
		Reporter.log("********************************************************");
		Reporter.log("Scenario: " + scenario.getName());
		Reporter.log("********************************************************");
	}

	@Before(value = "@First", order = 1)
	public void initialSetUp() {
		test = new TestSessionInitiator(this.getClass().getSimpleName());
	}

	@After
	public void screenShotAndConsoleLog(Scenario result) {
		screenShot(result);	}

	@After("@Close")
	public void close_browser(Scenario result) {
		if (test.getDriver() != null) {
			test.getDriver().quit();
		}

	}

	private void screenShot(Scenario result) {
		test.takescreenshot.takeScreenShotOnException(result);
	}

}
