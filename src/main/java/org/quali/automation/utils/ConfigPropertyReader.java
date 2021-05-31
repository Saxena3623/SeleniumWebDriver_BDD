package org.quali.automation.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.quali.automation.Pageobjects.Tiers;

/**
 * This is the utility class for data read write
 *
 * @author rishusaxena
 *
 */
public class ConfigPropertyReader {

	private static String defaultConfigFile = "./Config.properties";
	public static String tier;
	public static String browser;
	public static String seleniumserver;
	public static String seleniumserverhost;
	public static HashMap<String, String> sessionConfig = null;

	/**
	 * construtor of this class
	 */
	public ConfigPropertyReader() {
		tier = setTier();
		browser = setBrowser();
		seleniumserver = setSeleniumServer();
		
	}

	{
		sessionConfig = (HashMap) _getSessionConfig();
	}

	private Map<String, String> _getSessionConfig() {
		String[] configKeys = { "tier", "browser", "seleniumserver", "seleniumserverhost",
				"timeout", "hiddenFieldTimeOut", "driverPathChrome","driverPathGecko"};
		Map<String, String> config = new HashMap<String, String>();
		for (String string : configKeys) {
			config.put(string, getProperty("./Config.properties", string));
		}
		return config;
	}

	public static  String getProperty(String propFile,String property) {
		
		Properties prop = new Properties();
		String value = null;
			try {
				File file = new File(propFile);
				FileReader fr = new FileReader(file);

				prop.load(fr);
				value = prop.getProperty(property);
			}
			catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		return value;
	}
	
	public static String setTier() {
		Tiers tierProp = null;
		if (!checkIfValueIsNull(System.getProperty("env"))) {
			tierProp = Tiers.valueOf(System.getProperty("env"));
		} else {
			tierProp = Tiers.valueOf(sessionConfig.get("tier"));
		}
		switch (tierProp) {
		case production:
		case PROD:
		case PRODUCTION:
		case Production:
		case prod:
			tier = "prod";
			break;
		case STAGE:
		case stage:
		case Stage:
		case STAGING:
		case staging:
			tier = "stage";
			break;
		case QA:
		case q:
		case qa:
		case Qa:
			tier = "qa";
			break;
		}
		return tier;
	}

	public static String getTier() {
		return tier;
	}

	public static String getTierInFirstLatterCaps() {
		String str = new String();
		switch (tier) {
		case "prod":
			str = "Prod";
			break;
		case "stage":
			str = "Stage";
			break;
		case "qa":
			str = "QA";
			break;
		}
		return str;
	}

	public static String setBrowser() {
		if (!checkIfValueIsNull(System.getProperty("browser")))
			browser = System.getProperty("browser");
		else
			browser = sessionConfig.get("browser");
		System.out.println("Browser : " + browser);
		return browser;
	}

	public static String getBrowser() {
		return browser;
	}


	
	private static String setSeleniumServer() {
		if (!checkIfValueIsNull(System.getProperty("seleniumserver")))
			seleniumserver = System.getProperty("seleniumserver");
		else
			seleniumserver = sessionConfig.get("seleniumserver");
		System.out.println("SeleniumServer : " + seleniumserver);
		return seleniumserver;
	}

	

	public static String getSeleniumServer() {
		return seleniumserver;
	}

	private static String setSeleniumServerHost() {
		if (!checkIfValueIsNull(System.getProperty("seleniumserverhost")))
			seleniumserverhost = System.getProperty("seleniumserverhost");
		else
			seleniumserverhost = sessionConfig.get("seleniumserverhost");
		return seleniumserverhost;
	}

	public static String getSeleniumServerHost() {
		return seleniumserverhost;
	}



	public static String getChromeDriverPath() {
		return sessionConfig.get("driverPathChrome");
	}

	
	public static boolean checkIfValueIsNull(String value) {
		try {
			value.isEmpty();
			return false;
		} catch (NullPointerException ex) {
			return true;
		}
	}

	public static String getGeckoDriverPath() {
		return sessionConfig.get("driverPathGecko");
	}
	
	public static String getProperty(String property) {
		return getProperty(defaultConfigFile, property);
	}


}
