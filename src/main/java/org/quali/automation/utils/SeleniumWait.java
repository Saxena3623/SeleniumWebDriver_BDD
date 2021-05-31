package org.quali.automation.utils;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWait {

	WebDriver driver;
	WebDriverWait wait;

	public static int timeout;

	public SeleniumWait(WebDriver driver, int timeout) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, timeout);
	}

	/**
	 * Returns webElement found by the locator if element is visible
	 *
	 * @param locator
	 * @return
	 */
	public WebElement getWhenVisible(By locator) {
		return (WebElement) wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void waitForChangingText(WebElement el, String initialText) {
		for (int i = 0; i <= 300; i++) {
			if (!(el.getText().equals(initialText))) {
				break;
			}
		}
	}

	public WebElement getWhenClickable(By locator) {
		return (WebElement) wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public boolean waitForPageTitleToBeExact(String expectedPagetitle) {
		return wait.until(ExpectedConditions.titleIs(expectedPagetitle)) != null;
	}

	public boolean waitForPageTitleToContain(String expectedPagetitle) {
		return wait.until(ExpectedConditions.titleContains(expectedPagetitle)) != null;
	}

	public WebElement waitForElementToBeVisible(WebElement e) {
		return (WebElement) wait.until(ExpectedConditions.visibilityOf(e));
	}

	public void waitForFrameToBeAvailableAndSwitchToIt(By locator) {
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
	}

	public List<WebElement> waitForElementsToBeVisible(List<WebElement> es) {
		return (List<WebElement>) wait.until(ExpectedConditions.visibilityOfAllElements(es));
	}

	public boolean waitForElementToBeInVisible(By locator) {
		return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator)) != null;
	}

	public void changeimpliciteTimeout(int sec) {
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
	}

	public WebElement waitForElementToBeClickable(WebElement e) {
		return (WebElement) wait.until(ExpectedConditions.elementToBeClickable(e));
	}
	 public boolean waitUntilNewWindowIsOpen(int numOfWindows) {
			return wait.until(ExpectedConditions.numberOfWindowsToBe(numOfWindows));
		}
	 public int getTimeout() {
	    	return timeout;
	    }
	 
	 
	 public void waitForElementToAppear(WebElement element) {
		 int i = 0;
	        System.out.println("waiting For Element To Appear");
	        System.out.println("element.isDisplayed()==="+ element.isDisplayed());
	        resetImplicitTimeout(2);
//	        hardWait(1);
	        try {
	        	System.out.println("try");
	            while (!(element.isDisplayed()) && i <= timeout) {
	            	System.out.println("while");
	                hardWait(1);                
	                i++;
	                System.out.println(i + " Seconds");
	            }
	        } catch (StaleElementReferenceException e) {
	        	System.out.println("exception thrown");
	        }
	        System.out.println("exitig loop");
	        resetImplicitTimeout(timeout);   
	        System.out.println("exiting function");
	}
	public void waitforElementToBeVisibleAndClickable(WebElement e) {
		waitForElementToBeVisible(e);
		waitForElementToBeClickable(e);
	}

	public void waitForElementToDisappear(WebElement element) {
		int i = 0;
		resetImplicitTimeout(15);
		try {
			while (element.isDisplayed() && i <= timeout) {
				hardWait(1);
				++i;
			}
		} catch (Exception e) {
		}
		resetImplicitTimeout(timeout);
	}

	public void resetImplicitTimeout(int newTimeOut) {
		try {
			driver.manage().timeouts().implicitlyWait(newTimeOut, TimeUnit.SECONDS);
		} catch (Exception e) {
		}
	}

	public void resetExplicitTimeout(int newTimeOut) {
		try {
			this.wait = new WebDriverWait(driver, newTimeOut);
		} catch (Exception e) {
		}
	}

	public WebElement waitForElementToBePresent(By locator) {
		return (WebElement) wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	// TODO Implement Wait for page load for page synchronizations
	public void waitForPageToLoadCompletely() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*")));
	}

	public WebElement checkPresenceOfElementInDom(By loc) {
		return wait.until(ExpectedConditions.presenceOfElementLocated(loc));
	}

	public WebElement checkPresenceOfElementInDom(WebElement e) {
		return (WebElement) wait.until(ExpectedConditions.visibilityOf(e));
	}
	public List<WebElement> checkPresenceOfElementsInDom(By loc) {
		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(loc));
	}

	public void hardWait(int seconds) {
		try {
			Thread.sleep(1000 * seconds);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}
}
