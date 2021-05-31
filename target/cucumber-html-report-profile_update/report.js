$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/featurefiles/Update_Profile.feature");
formatter.feature({
  "line": 1,
  "name": "Update Profile Information",
  "description": "",
  "id": "update-profile-information",
  "keyword": "Feature"
});
formatter.before({
  "duration": 54701,
  "status": "passed"
});
formatter.before({
  "duration": 3037421399,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "Verify User is able to successfully log in the website",
  "description": "",
  "id": "update-profile-information;verify-user-is-able-to-successfully-log-in-the-website",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@First"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "User is able to launch shopping website",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "User clicks on \u0027Sign in\u0027 link",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "User enters login details",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "User clicks on \u0027Sign In\u0027 button",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "User is able to login successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "Step_Def_Ordering.verifyLaunchShoppingWebsite()"
});
formatter.result({
  "duration": 22983497600,
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
  "duration": 8053491100,
  "status": "passed"
});
formatter.match({
  "location": "Step_Def_Ordering.verifyUserEnterLoginDetails()"
});
formatter.result({
  "duration": 2434074899,
  "status": "passed"
});
formatter.match({
  "location": "Step_Def_Ordering.verifyUserClicksOnSignInButton()"
});
formatter.result({
  "duration": 3617486499,
  "status": "passed"
});
formatter.match({
  "location": "Step_Def_Ordering.verifyloginIsSuccessful()"
});
formatter.result({
  "duration": 102377600,
  "status": "passed"
});
formatter.after({
  "duration": 1464200,
  "status": "passed"
});
formatter.before({
  "duration": 101500,
  "status": "passed"
});
formatter.scenario({
  "line": 11,
  "name": "User is able to update Account Information",
  "description": "",
  "id": "update-profile-information;user-is-able-to-update-account-information",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 12,
  "name": "User clicks on \u0027My personal information\u0027 option",
  "keyword": "Given "
});
formatter.step({
  "line": 13,
  "name": "User updates the first name details",
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "User enters password",
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "User clicks on \u0027Save\u0027 button",
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "User verifies account information is updated",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "My personal information",
      "offset": 16
    }
  ],
  "location": "Step_Def_Ordering.verifyUserClickOnOption(String)"
});
formatter.result({
  "duration": 1950508800,
  "status": "passed"
});
formatter.match({
  "location": "Step_Def_Ordering.verifyUserUpdatesDetails()"
});
formatter.result({
  "duration": 2434823300,
  "status": "passed"
});
formatter.match({
  "location": "Step_Def_Ordering.verifyEnterPassword()"
});
formatter.result({
  "duration": 6210355001,
  "status": "passed"
});
formatter.match({
  "location": "Step_Def_Ordering.clickSaveBtn()"
});
formatter.result({
  "duration": 6106025400,
  "status": "passed"
});
formatter.match({
  "location": "Step_Def_Ordering.verifyAccountInfoUpdated()"
});
formatter.result({
  "duration": 14307035400,
  "status": "passed"
});
formatter.after({
  "duration": 973299,
  "status": "passed"
});
});