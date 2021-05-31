package org.quali.automation.actions;

import java.util.Random;

import org.openqa.selenium.WebDriver;

import org.quali.automation.Pageobjects.GetPage;
import org.quali.automation.utils.TestDataEncrypter;
import org.quali.automation.utils.YamlReader;

public class HomePageKeyword extends GetPage{
	
	public HomePageKeyword(WebDriver driver) {
		super(driver, "HomePage");
	}

	

	public boolean verifyUserClicksOnLink(String link) {
        wait.waitForElementToBeVisible(element("lnk_generic",link));
        logMessage("pass"," User is on Sign in page");
         click(element("lnk_generic",link));
         return true;
		
	}
	
	public boolean verifyUserClicksOnTab(String link) {
        wait.waitForElementToBeVisible(element("nav_tab",link));
         click(element("nav_tab",link));
         return true;
		
	}
	
	

	public boolean verifyUserEnterLoginDetails(String email, String pswd) {
		String password=TestDataEncrypter.decrypt(pswd);
		element("text_email").sendKeys(email);
        logMessage("info","User entered Email address");
        element("text_password").sendKeys(password);
        logMessage("info","User entered password");
		return true;       
		
	}
	
	public boolean verifyUserPassword(String password) {
		String oldpassword=TestDataEncrypter.decrypt(password);
		wait.hardWait(2);
		 element("text_password").sendKeys(oldpassword.trim());
	        logMessage("info","User entered password");
			return true; 
	}

	public boolean verifyUserClicksOnSignInButton() {
        element("btn_submit","").click();
        logMessage("info","User has clicked on Submit button");
        return true;
		
	}


	public String verifyloginIsSuccessful() {
		wait.waitForPageToLoadCompletely();
        return getPageTitle();
				
	}

	public void click(String opt) {
		click(element("lnkspan_generic",opt));
		
	}

	public void updateFirstName(String data) {
		element("txt_firstname").clear();
		String firstNameUpdated=data+generateRandomString();
		element("txt_firstname").sendKeys(firstNameUpdated);
		
	}

    
    public String generateRandomString(){
    	String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder sb = new StringBuilder();

        // create an object of Random class
        Random random = new Random();
    int length = 10;
    String alphaString = upperAlphabet + lowerAlphabet;

    for(int i = 0; i < 5; i++) {
      int index = random.nextInt(alphaString.length());
      char randomChar = alphaString.charAt(index);
      sb.append(randomChar);
    }
    String randomString = sb.toString();
	return randomString;

  }

	public void clickOnSaveBtn() {
		click(element("btn_submitUpdate"));
		
	}
	
	

}
