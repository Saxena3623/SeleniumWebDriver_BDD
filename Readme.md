**Java Selenium BDD Web Test Solution**


This Test Automation Framework serves the purpose of automating the test cases and getting the tests results. Please refer the below mentioned guidelines/prerequisites for the same.

**System Requirement:**


JDK 1.8 or above
Maven 3.1 or above
Intellij or IDE of choice in case there is need to update the script. (optional)


Checkout the code from github
Open terminal and navigate to the checkout directory
git clone https://github.com/Saxena3623/SeleniumWebDriver_BDD
Checkout the master branch


Config.properties file contains all the required configurations to trigger the scripts with  specified  pre-requisites

**Execution Steps**
Please follow the instructions to execute the tests on local:

The framework comprises of following folders:

In folder src/java/test:

We have following packages used in automation:

org.quali.automation.Session : Contains classes to initialize a test session.

org.quali.automation.Pageobjects : Contains BaseUi, GetPage Classes which comprises of commonly used methods. It also has enum classes which define locator strategy. Contains one utility class which reads from files and initialize correct data files (QA /Stage or Prod).


org.quali.automation.utils : Contains various utility classes.

com.qait.automation.action : Contains Action classes for each test, the Action methods use elements declared in the spec file and those element are then fed to different actions defined in BaseUi and GetPage libs.

org.quali.automation.runners: Contains the runner files for the feature files of suite.


com.qait.automation.mts.stepDefs : This is the ultimate layer, which contains the Step definitions for the test steps written in BDD format in feature files.

In folder src/java/resources:

We have,

featurefiles: Contains feature files for test scenarios


PageObjectRepository: Contains the tie specific files that consists of locators stored with .spec extension

Selenium-webdrivers: contains the selenium webdrivers

test-data: Contains the runtime data created through automation scripts and static data is stored in file with .yaml extension. This file is also stored in teir specific folder.

test-xml: Contains the xml files for the test suites.


**Result Files:**
Test Results - target/cucumber-html-report-featureFilename
Test Results - Scenario__User_is_able_to_update_Account_Information.html
