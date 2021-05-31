/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.quali.automation.Session;


import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.quali.automation.utils.ConfigPropertyReader;

public class WebDriverFactory {

	private static String browser;
	private static String seleniumserver;
	private static String seleniumserverhost;

	static String downloadFilePath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
			+ File.separator + "resources" + File.separator + "Downloads";
	private static final DesiredCapabilities capabilities = new DesiredCapabilities();

	public WebDriver getDriver() {
		browser = ConfigPropertyReader.getBrowser();
		seleniumserver = ConfigPropertyReader.getSeleniumServer();
		seleniumserverhost = ConfigPropertyReader.getSeleniumServerHost();
		if (seleniumserver.equalsIgnoreCase("local")) {
			if (browser.equalsIgnoreCase("firefox"))
				return getFirefoxDriver(ConfigPropertyReader.getGeckoDriverPath());
			else if (browser.equalsIgnoreCase("chrome")) {
					return getChromeDriver(ConfigPropertyReader.getChromeDriverPath());
					
			}
			}
		if (seleniumserver.equalsIgnoreCase("remote")) {
			System.out.println("Inside remote test machine!!!");
			return setRemoteDriver();
		}
	        return new FirefoxDriver();

	}

	private WebDriver setRemoteDriver() {
		DesiredCapabilities cap = null;
		if (browser.equalsIgnoreCase("firefox")) {
			cap = DesiredCapabilities.firefox();
		} else if (browser.equalsIgnoreCase("chrome")) {
			final ChromeOptions chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("--disable-extensions");
			cap = DesiredCapabilities.chrome();
			cap.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
		}
		String seleniuhubaddress = seleniumserverhost;
		URL selserverhost = null;
		try {
			selserverhost = new URL(seleniuhubaddress);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		cap.setJavascriptEnabled(true);
		return new RemoteWebDriver(selserverhost, cap);
	}

	
	private static WebDriver getFirefoxDriver(String driverpath) {
		System.setProperty("webdriver.gecko.driver", driverpath);
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("acceptInsecureCerts", true);
		return new FirefoxDriver(dc);
	}

	

	private static WebDriver getChromeDriver(String driverpath) {
		System.setProperty("webdriver.chrome.driver", driverpath);
		ChromeOptions options = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_settings.popups", 0);
		prefs.put("download.prompt_for_download", false);
		prefs.put("download.default_directory", System.getProperty("user.dir") + File.separator + "Temp");
		options.setExperimentalOption("prefs", prefs);
		options.addArguments("--test-type");
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		options.addArguments("--disable-extensions");
		cap.setCapability(ChromeOptions.CAPABILITY, options);
		return new ChromeDriver(cap);
	}

	
}
