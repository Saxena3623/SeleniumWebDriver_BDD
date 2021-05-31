$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/featurefiles/Order_Tshirt.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#Author: Rishu Saxena"
    }
  ],
  "line": 2,
  "name": "Ordering new T-shirt",
  "description": "",
  "id": "ordering-new-t-shirt",
  "keyword": "Feature"
});
formatter.before({
  "duration": 42289499,
  "status": "passed"
});
formatter.before({
  "duration": 4532121700,
  "status": "passed"
});
formatter.scenario({
  "line": 5,
  "name": "Verify User is able to successfully log in the website",
  "description": "",
  "id": "ordering-new-t-shirt;verify-user-is-able-to-successfully-log-in-the-website",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 4,
      "name": "@First"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "User is able to launch shopping website",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "User clicks on \u0027Sign in\u0027 link",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "User enters login details",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "User clicks on \u0027Sign In\u0027 button",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "User is able to login successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "Step_Def_Ordering.verifyLaunchShoppingWebsite()"
});
formatter.result({
  "duration": 16008153999,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Sign in",
      "offset": 16
    }
  ],
  "location": "Step_Def_Ordering.verifyUserClicksOnLink(String)"
});
formatter.result({
  "duration": 5552027700,
  "status": "passed"
});
formatter.match({
  "location": "Step_Def_Ordering.verifyUserEnterLoginDetails()"
});
formatter.result({
  "duration": 2575175400,
  "status": "passed"
});
formatter.match({
  "location": "Step_Def_Ordering.verifyUserClicksOnSignInButton()"
});
formatter.result({
  "duration": 10908582301,
  "status": "passed"
});
formatter.match({
  "location": "Step_Def_Ordering.verifyloginIsSuccessful()"
});
formatter.result({
  "duration": 107496700,
  "status": "passed"
});
formatter.after({
  "duration": 1638799,
  "status": "passed"
});
formatter.before({
  "duration": 165700,
  "status": "passed"
});
formatter.scenario({
  "line": 12,
  "name": "User places an order of T-shirt",
  "description": "",
  "id": "ordering-new-t-shirt;user-places-an-order-of-t-shirt",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 13,
  "name": "User clicks on \u0027T-shirts\u0027 tab",
  "keyword": "When "
});
formatter.step({
  "line": 14,
  "name": "User selects item to adds to cart",
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "User clicks on checkout button",
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "User is on \u0027Summary\u0027 Tab and clicks on \u0027Proceed to checkout\u0027",
  "keyword": "And "
});
formatter.step({
  "line": 17,
  "name": "User is on \u0027Address\u0027 Tab and clicks on \u0027Proceed to checkout\u0027",
  "keyword": "And "
});
formatter.step({
  "line": 18,
  "name": "User checkout after selecting Terms and Services",
  "keyword": "And "
});
formatter.step({
  "line": 19,
  "name": "User selects payment method \u0027bankwire\u0027 on payment tab",
  "keyword": "And "
});
formatter.step({
  "line": 20,
  "name": "User clicks on \u0027I confirm my order\u0027",
  "keyword": "And "
});
formatter.step({
  "line": 21,
  "name": "User verifies order is successful",
  "keyword": "Then "
});
formatter.step({
  "line": 22,
  "name": "User verifies recent order in history",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "T-shirts",
      "offset": 16
    }
  ],
  "location": "Step_Def_Ordering.verifyUserClicksOnTab(String)"
});
formatter.result({
  "duration": 8928616300,
  "status": "passed"
});
formatter.match({
  "location": "Step_Def_Ordering.verifyClickAddItemToCart()"
});
formatter.result({
  "duration": 681628000,
  "status": "passed"
});
formatter.match({
  "location": "Step_Def_Ordering.verifyClickCheckOutButton()"
});
formatter.result({
  "duration": 14545229799,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Summary",
      "offset": 12
    }
  ],
  "location": "Step_Def_Ordering.verifyTabAndClickCheckout(String)"
});
formatter.result({
  "duration": 5957639300,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Address",
      "offset": 12
    }
  ],
  "location": "Step_Def_Ordering.verifyTabAndClickCheckout(String)"
});
formatter.result({
  "duration": 5832464700,
  "status": "passed"
});
formatter.match({
  "location": "Step_Def_Ordering.verifyAcceptTermsAndCheckout()"
});
formatter.result({
  "duration": 5322539000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "bankwire",
      "offset": 29
    }
  ],
  "location": "Step_Def_Ordering.verifyselectPaymentMethod(String)"
});
formatter.result({
  "duration": 8021473399,
  "status": "passed"
});
formatter.match({
  "location": "Step_Def_Ordering.clickButtonToconfirmOrder()"
});
formatter.result({
  "duration": 3082594200,
  "status": "passed"
});
formatter.match({
  "location": "Step_Def_Ordering.VerifyOrderIsPlacedSuccessfully()"
});
formatter.result({
  "duration": 2362838200,
  "status": "passed"
});
formatter.match({
  "location": "Step_Def_Ordering.verifyOrderIsPresentUnderMyOrders()"
});
formatter.result({
  "duration": 11785649200,
  "status": "passed"
});
formatter.after({
  "duration": 1025901,
  "status": "passed"
});
});