import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import org.junit.After as After
import org.testng.Assert

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.URL)

WebUI.maximizeWindow()

CustomKeywords.'com.GenericKeywords.loadProperties'();

WebUI.waitForElementPresent(findTestObject('OnbordingLocators/LoginHeaderText'), 20)

CustomKeywords.'com.GenericKeywords.verifyTitle'(GlobalVariable.Title)

/*-------------------------------------------------------------------------------------------*/

// Step1 : Before Accepting the Cookies Validate Cookies empty or Not? Here Validating Only Domain name
String domainname = CustomKeywords.'com.GenericKeywords.getCookiesValue'()

//Assert.assertEquals(domainname, ""); //Because Initally should be empty.

/*-------------------------------------------------------------------------------------------*/

// Step2 : Switch to the frame and Accepting the cookies!
CustomKeywords.'com.GenericKeywords.switchToFrame'(findTestObject('OnbordingLocators/AcceptCokkiesBtn'))

CustomKeywords.'com.GenericKeywords.switchToDefaultWindow'()

//Validating the cookies domain name after accepting the cookies
String domainname1 =  CustomKeywords.'com.GenericKeywords.getCookiesValue'()

Assert.assertEquals(domainname1, "gsm-sandbox.auth0.com"); //After Accepting the cookies check the domain name.

/*-------------------------------------------------------------------------------------------*/

//Step 3 : Finally Delete all the cookies
CustomKeywords.'com.GenericKeywords.deleteAllCookies'();

WebUI.refresh()

//Check Cookies are really deleted or not?
String domainname2 = CustomKeywords.'com.GenericKeywords.getCookiesValue'()

Assert.assertEquals(domainname2, ""); //After Deleted the Cookies It should be Empty.

WebUI.closeBrowser()

