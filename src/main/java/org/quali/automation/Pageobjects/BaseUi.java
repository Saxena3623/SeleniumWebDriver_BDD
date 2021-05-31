package org.quali.automation.Pageobjects;

import static org.quali.automation.utils.ConfigPropertyReader.getProperty;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;


import org.quali.automation.utils.SeleniumWait;
import org.testng.Reporter;
import org.quali.automation.utils.ReportMsg;
/**
 *
 * @author rishusaxena
 * 
 */

public class BaseUi {

	protected WebDriver driver;
	protected SeleniumWait wait;
	private String pageName;

	protected BaseUi(WebDriver driver, String pageName) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.pageName = pageName;
		this.wait = new SeleniumWait(driver, Integer.parseInt(getProperty("Config.properties", "timeout")));
	}

	protected String getPageTitle() {
		return driver.getTitle();
	}

	public void logMessage(String msgType, String message) {
		ReportMsg.log(msgType, message);
	}
	public static void logMessage(String message) {
		Reporter.log(message, true);
	}
	protected void scrollDown(WebElement element) {
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView(true);", element);
	}

	protected String getCurrentURL() {
		return driver.getCurrentUrl();
	}
	
	protected void click(WebElement element) {
		wait.waitForPageToLoadCompletely();
		try {
			wait.waitForElementToBeVisible(element);
			element.click();
			logMessage("Clicked on " + element);
		} catch (StaleElementReferenceException ex1) {
			wait.hardWait(3);
			wait.waitForElementToBeVisible(element);
//			scrollDown(element);
			element.click();
			logMessage("Clicked Element " + element + " after catching Stale Element Exception");
		} catch (Exception ex2) {
			logMessage("Element " + element + " could not be clicked! " + ex2.getMessage());
		}
	}
	protected void hover(WebElement element) {
		Actions hoverOver = new Actions(driver);
		hoverOver.moveToElement(element).build().perform();
	}
	protected Object executeJavascript(String script) {
		return ((JavascriptExecutor) driver).executeScript(script);
	}


	
}
