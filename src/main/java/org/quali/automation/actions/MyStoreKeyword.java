package org.quali.automation.actions;

import java.text.ParseException;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.net.ssl.HostnameVerifier;

import org.eclipse.persistence.internal.sessions.PropertiesHandler;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.quali.automation.Pageobjects.GetPage;
import org.testng.Assert;
import org.quali.automation.utils.PropFileHandler;
import org.quali.automation.utils.TestDataEncrypter;
import org.quali.automation.utils.YamlReader;

public class MyStoreKeyword extends GetPage{
	
	public MyStoreKeyword(WebDriver driver) {
		super(driver, "MyStore");
	}

	

	public void verifyClickAddItemToCart() {
		List<WebElement> element = elements("list_container");
		Random rand = new Random();
		int random = rand.nextInt(element.size());
		scrollDown(element.get(random));
        hover(element.get(random));
        List<WebElement> btn = elements("btn_addToCart");
		scrollDown(btn.get(random));
         click(btn.get(random));
         logMessage("info", "User added item to Cart");
		
	}

	public void verifyClickCheckOutButton() {
		wait.waitForElementToAppear(element("modal_cart"));
		String title= getTextOfAnElement(element("title_product"));
		PropFileHandler.writeToFile("item_selected", title);
		click(element("btn_proceed"));
		logMessage("User clicked on Checkout button");
		
	}

	public String verifyTab(String tab) {
        String color = element("checkout_tabs",tab).getCssValue("border-top-color");
        String colorHex=convertRGBAToHexa(color);
		return colorHex;
	}



	public void verifyClickCheckOutButtonProceed(String txt) {
		click(element("btn_cartProceedCheckOut",txt));
		logMessage("pass", "Proceed to Checkout clicked");
	}



	public void verifyAcceptTermsAndCheckout() {
		verifyTab("Shipping");
		executeJavascript("document.getElementById(\"cgv\").click();");
        logMessage("info","User has clicked on I Agree button");
		
	}


	public void selectPaymentMode(String method) {
		 click(element("option_payment",method));
	      logMessage("info","User has selected payment mode: "+method);		
	}



	String orderRefNum=null;
	public String  verifyOrderIsPlacedSuccessfully() {
		String orderRef= getTextOfAnElement(element("orderDetails"));
		System.out.println("orderRef is"+orderRef);
		Pattern order = Pattern.compile("order reference (\\w+) in the subject of your bank wire.");
		Matcher string =order.matcher(orderRef);
		string.find();
		orderRefNum=string.group(1);
		System.out.println("Order ref no is "+orderRef);
		PropFileHandler.writeToFile("OrderReferenceNumber", orderRefNum);
		return getTextOfAnElement(element("txtConfirm"));
		
	}



	public boolean verifyOrderIsPresentUnderMyOrders() {
		   clickMyOrders();
		   clickOnOrderHistoryAndDetails();
		   verifyRecentlyPacedOrderIsPresentInOrderHistory(PropFileHandler.readProperty("OrderReferenceNumber"));
		   return true;
  }
		    
	
	private boolean verifyRecentlyPacedOrderIsPresentInOrderHistory(String orderNumber) {
		logMessage("Refrence id is "+orderNumber);
		boolean flag=false;
		List<WebElement> list= elements("details_order");
		 for (WebElement element : list) {
			 if(element.getText().contains(orderNumber)) {
				flag= true;
			 }
			 else {
				 flag= false;
			 }
			 
		 }
		return flag;
		
	}






	private void clickOnOrderHistoryAndDetails() {
	        click(element("btn_myOrders"));
	        logMessage("info","User has clicked on Orders History and Details button");
	        wait.waitForPageTitleToContain(YamlReader.getYamlValue("headers.history"));
	        logMessage("pass","User is on Order History page");		
	}



	public void clickMyOrders()
	 {
	        clickOnMyAccountHeaderButton();
	  }
	
	public void clickOnMyAccountHeaderButton()
    {
		click(element("account_name"));
        logMessage("info","User has clicked on Account info button");
        wait.waitForPageTitleToContain(YamlReader.getYamlValue("headers.account"));
        logMessage("pass","User is on My Account page");
    }



	public String verifyOrderIsPlacedverifyAccountInfoUpdatedSuccessfully() {
		isElementDisplayed("msg_success");
		return getTextOfAnElement(element("msg_success"));
	}

	
	
	

}
