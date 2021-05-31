package org.quali.automation.Pageobjects;

import static org.quali.automation.utils.ConfigPropertyReader.getProperty;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import org.quali.automation.utils.ConfigPropertyReader;

import static org.testng.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;
import static org.quali.automation.Pageobjects.ObjectFileReader.getELementFromFile;

public class GetPage extends BaseUi {

	protected WebDriver webdriver;
	String pageName;

	public GetPage(WebDriver driver, String pageName) {
		super(driver, pageName);
		this.webdriver = driver;
		this.pageName = pageName;
	}

	protected WebElement element(String elementToken) {
		wait.hardWait(1);
		return element(elementToken, "");
	}

		protected WebElement element(String elementToken, String replacement) throws NoSuchElementException {
		WebElement elem = null;
		try {
			elem = wait.waitForElementToBeVisible(webdriver.findElement(getLocator(elementToken, replacement)));
		} catch (StaleElementReferenceException ex1) {
			wait.hardWait(2);
			elem = wait.waitForElementToBeVisible(webdriver.findElement(getLocator(elementToken, replacement)));
			logMessage("Find Element " + elementToken + " after catching Stale Element Exception");
		} catch (NoSuchElementException excp) {
			fail("FAILED: Element '" + elementToken + "' not found on the " + this.pageName + " !!!");
		}
		return elem;
	}



	protected boolean checkIfElementIsThere(By Locator) {
		Integer timeOut = Integer.parseInt(getProperty("Config.properties", "timeout"));

		boolean flag = false;
		try {
			wait.resetImplicitTimeout(5);
			if (webdriver.findElement(Locator).isDisplayed()) {
				flag = true;
			} else {
				flag = false;
			}
		} catch (NoSuchElementException ex) {
			flag = false;
		} finally {
			wait.resetImplicitTimeout(timeOut);
			wait.resetExplicitTimeout(timeOut);
		}
		return flag;
	}

	protected List<WebElement> elements(String elementToken, String replacement) {
		return wait.waitForElementsToBeVisible(webdriver.findElements(getLocator(elementToken, replacement)));
	}

	protected List<WebElement> elements(String elementToken) {
		return wait.waitForElementsToBeVisible(webdriver.findElements(getLocator(elementToken)));
	}
	public String convertRGBAToHexa(String color) {
		String[] hexValue = color.replace("rgba(", "").replace(")", "").split(",");
		int hexValue1 = Integer.parseInt(hexValue[0]);
		hexValue[1] = hexValue[1].trim();
		int hexValue2 = Integer.parseInt(hexValue[1]);
		hexValue[2] = hexValue[2].trim();
		int hexValue3 = Integer.parseInt(hexValue[2]);
		String actualColor = String.format("#%02x%02x%02x", hexValue1, hexValue2, hexValue3);
		return actualColor;
	}


	

	protected void waitForElementToAppear(String elementToken) {
		wait.waitForElementToAppear(element(elementToken));

	}

	protected void _waitForElementToDisappear(String elementToken, String replacement) {
		int i = 0;
		int initTimeout = wait.getTimeout();
		wait.resetImplicitTimeout(30);
		int count;
		while (i <= 30) {
			if (replacement.isEmpty())
				count = driver.findElements(getLocator(elementToken)).size();
			else
				count = driver.findElements(getLocator(elementToken, replacement)).size();
			if (count == 0)
				break;
			wait.hardWait(1);
			i += 1;
		}
		wait.resetImplicitTimeout(initTimeout);
	}
	
	
	protected By getLocator(String elementToken, String replacement) {
		String[] locator = getELementFromFile(this.pageName, elementToken);
		locator[2] = locator[2].replaceAll("\\$\\{.+\\}", replacement);
		return getBy(locator[1].trim(), locator[2].trim());
	}
	protected By getLocator(String elementToken) {
		return getLocator(elementToken, "");
	}

	protected void waitForElementToDisappear(String elementToken) {
		_waitForElementToDisappear(elementToken, "");
	}

	protected void waitForElementToDisappear(String elementToken, String replacement) {
		_waitForElementToDisappear(elementToken, replacement);
	}


	protected boolean isElementDisplayed(String elementName, String elementTextReplace) {
		wait.waitForElementToBeVisible(element(elementName, elementTextReplace));
		boolean result = element(elementName, elementTextReplace).isDisplayed();
		assertTrue(result, "ASSERTION FAILED: element '" + elementName + "with text " + elementTextReplace
				+ "' is not displayed.");
		logMessage("ASSERTION PASSED: element " + elementName + " with text " + elementTextReplace + " is displayed.");
		return result;
	}

	protected void verifyElementText(String elementName, String expectedText) {
		wait.waitForElementToBeVisible(element(elementName));
		assertEquals(element(elementName).getText().trim(), expectedText,
				"ASSERTION FAILED: element '" + elementName + "' Text is not as expected: ");
		logMessage("ASSERTION PASSED: element " + elementName + " is visible and Text is " + expectedText);
	}


	protected boolean isElementDisplayed(String elementName) {
		wait.waitForElementToBeVisible(element(elementName));
		boolean result = element(elementName).isDisplayed();
		assertTrue(result, "ASSERTION FAILED: element '" + elementName + "' is not displayed.");
		logMessage("ASSERTION PASSED: element " + elementName + " is displayed.");
		return result;
	}



	public String getTextOfAnElement(WebElement element) {
		wait.waitForElementToBeVisible(element);
		String value = element.getText();
		logMessage("Get text  " + value + " value of an element " + element);
		return value;
	}

	public String getTextOfAnElement(String token) {
		WebElement e = element(token);
		wait.waitForElementToBeVisible(element(token));
		String value = e.getText();
		logMessage("Get text  " + value + " value of an element " + e);
		return value;
	}

	

	private By getBy(String locatorType, String locatorValue) {
		switch (Locators.valueOf(locatorType)) {
		case id:
			return By.id(locatorValue);
		case xpath:
			return By.xpath(locatorValue);
		case css:
			return By.cssSelector(locatorValue);
		case name:
			return By.name(locatorValue);
		case classname:
			return By.className(locatorValue);
		case linktext:
			return By.linkText(locatorValue);
		case partialLinkText:
			return By.partialLinkText(locatorValue);
		default:
			return By.id(locatorValue);
		}
	}

}
