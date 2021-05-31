package org.quali.automation.stepDefs;


import static org.quali.automation.stepDefs.Step_Def_Base.test;

import org.quali.automation.utils.PropFileHandler;
import org.quali.automation.utils.YamlReader;

import static org.quali.automation.Pageobjects.BaseUi.logMessage;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class Step_Def_Ordering {

	@Given("^User is able to launch shopping website$")
	public void verifyLaunchShoppingWebsite() {

		test.launchApplication(YamlReader.getData("url"));
	}
	
	@When("^User clicks on '(.*)' link$")
	public void verifyUserClicksOnLink(String link) {
		Assert.assertTrue(test.homepage.verifyUserClicksOnLink(link),"User was not able to click on link");
		logMessage("User clicked on "+link);
	}
	
	@And("^User clicks on '(.*)' tab$")
	public void verifyUserClicksOnTab(String link) {
		Assert.assertTrue(test.homepage.verifyUserClicksOnTab(link),"User was not able to click on link");
		logMessage("User clicked on "+link);
	}
	
	@And("^User enters login details$")
	public void verifyUserEnterLoginDetails() {
		Assert.assertTrue(test.homepage.verifyUserEnterLoginDetails(YamlReader.getData("emailAddress"),
				YamlReader.getData("password")),"User is not able to enter credentials");
		logMessage("User entered credentials");       

	}
	
	@And("^User enters password$")
	public void verifyEnterPassword() {
	Assert.assertTrue(test.homepage.verifyUserPassword(YamlReader.getData("password")),"User is not able to enter credentials");
	logMessage("User entered password");       

}
	
	@When("^User clicks on 'Save' button$")
	public void clickSaveBtn() {
		test.homepage.clickOnSaveBtn();
	}
    
	@And("^User clicks on 'Sign In' button$")
    public void verifyUserClicksOnSignInButton() {
		Assert.assertTrue(test.homepage.verifyUserClicksOnSignInButton(),"Sign in button was not clicked");
		logMessage("User clicked on sign in button");
	}
    
	@Then("^User is able to login successfully$")
    public void verifyloginIsSuccessful() {
		Assert.assertTrue(test.homepage.verifyloginIsSuccessful().contains(YamlReader.getYamlValue("headers.account")),"Log in was not successful");
		logMessage("User is able to login successfully");
	}
	
	@Given("^User clicks on '(.*)' option$")
	public void verifyUserClickOnOption(String opt) {
		test.homepage.click(opt);
		logMessage("User clicked on"+opt);
		
	}
	
	@And("^User updates the first name details$")
	public void verifyUserUpdatesDetails()
	{
		test.homepage.updateFirstName(YamlReader.getData("updatedFirstName"));
	}
	
	
	@And("^User selects item to adds to cart$")
	public void verifyClickAddItemToCart() {
		test.myStore.verifyClickAddItemToCart();
	}
	
	@When("^User clicks on checkout button$")
	public void verifyClickCheckOutButton() {
		test.myStore.verifyClickCheckOutButton();
	}
	
	@And("^User is on '(.*)' Tab and clicks on 'Proceed to checkout'$")
	public void verifyTabAndClickCheckout(String tab) {
		Assert.assertEquals(test.myStore.verifyTab(tab), "#73ca77");
		test.myStore.verifyClickCheckOutButtonProceed("Proceed to checkout");
		
	}
	
	@And("^User checkout after selecting Terms and Services$")
	public void verifyAcceptTermsAndCheckout() {
		test.myStore.verifyAcceptTermsAndCheckout();
		test.myStore.verifyClickCheckOutButtonProceed("Proceed to checkout");		
	}
	
	@And("^User selects payment method '(.*)' on payment tab$")
	public void verifyselectPaymentMethod(String method) {
		Assert.assertEquals(test.myStore.verifyTab("Payment"), "#73ca77");
        test.myStore.selectPaymentMode(method);
        }
	
	@And("^User clicks on 'I confirm my order'$")
	public void clickButtonToconfirmOrder()
	{
		test.myStore.verifyClickCheckOutButtonProceed("I confirm my order");
	}
	
	@Then("^User verifies order is successful$")
	public void VerifyOrderIsPlacedSuccessfully()
    {
		Assert.assertEquals(test.myStore.verifyTab("Payment"), "#73ca77");
		Assert.assertTrue(test.myStore.verifyOrderIsPlacedSuccessfully().contains(YamlReader.getData("orderConfirmation_text")));
		logMessage("Order is placed uccessfully");
    }
	
	@And("^User verifies recent order in history$")
	public void verifyOrderIsPresentUnderMyOrders() {
		Assert.assertTrue(test.myStore.verifyOrderIsPresentUnderMyOrders());
		logMessage("Order is present in history");;
		
	}
	
	@Then("^User verifies account information is updated$")
	public void verifyAccountInfoUpdated() {
		Assert.assertTrue(test.myStore.verifyOrderIsPlacedverifyAccountInfoUpdatedSuccessfully().contains(YamlReader.getData("update_infoText")));
		logMessage("Account info is updated");

	}

}
