package org.quali.automation.Session;

import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.quali.automation.utils.ConfigPropertyReader;
import org.quali.automation.utils.YamlReader;
import static org.quali.automation.utils.YamlReader.setYamlFilePath;
import static org.quali.automation.utils.ConfigPropertyReader.getProperty;

import org.quali.automation.actions.HomePageKeyword;
import org.quali.automation.actions.MyStoreKeyword;
import org.quali.automation.utils.*;

import org.testng.Reporter;


public class TestSessionInitiator {

	protected WebDriver driver;
	public WebDriverFactory wdFactory;
	String browser;
	String seleniumserver;
	String seleniumserverhost;
	String appbaseurl;
	String applicationpath;
	String chromedriverpath;
	static int timeout;
	Map<String, Object> chromeOptions = null;
	DesiredCapabilities capabilities;
	public static Map<String, String> configSettings = new HashMap<String, String>();

	/*
	 * Initiating the page objects
	 */

	public HomePageKeyword homepage;
	public MyStoreKeyword myStore;

	public TakeScreenshot takescreenshot;
	private String testname;

	public WebDriver getDriver() {
		return this.driver;
	}

	private void _initPage() {
		homepage = new HomePageKeyword(driver);
		myStore= new MyStoreKeyword(driver);
	}

	/*
	 * Page object Initiation done
	 */

	private void testInitiator(String testname) {
		setYamlFilePath();
		_configureBrowser();
		_initPage();
		takescreenshot = new TakeScreenshot(testname, this.driver);
	}

	private void _configureBrowser() {
		driver = wdFactory.getDriver();
		System.out.println("+++++++++++++++++driver" + driver);
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(getProperty("timeout")), TimeUnit.SECONDS);
	}

	public TestSessionInitiator(String testname) {
		new ConfigPropertyReader();
		wdFactory = new WebDriverFactory();
		testInitiator(testname);
		this.testname = testname;

	}

	public void openUrl(String url) {
		driver.get(url);
	}

	public void closeBrowserSession() {
		Reporter.log("[INFO]: The Test: " + this.testname.toUpperCase() + " COMPLETED!" + "\n", true);
		driver.quit();
	}

	public void closeTestSession() {
		closeBrowserSession();
	}

	public String getCurrentURL() {
		return driver.getCurrentUrl();
	}

	public void launchApplication(String data) {
		driver.manage().window().maximize();
		driver.get(data);
	}

}
