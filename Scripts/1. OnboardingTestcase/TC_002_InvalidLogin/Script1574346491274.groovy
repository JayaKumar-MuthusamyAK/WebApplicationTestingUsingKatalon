import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
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

CustomKeywords.'com.GenericKeywords.switchToFrame'(findTestObject('OnbordingLocators/AcceptCokkiesBtn'))

CustomKeywords.'com.GenericKeywords.switchToDefaultWindow'()

CustomKeywords.'com.GenericKeywords.verifyTitle'(GlobalVariable.Title)

WebUI.sendKeys(findTestObject('OnbordingLocators/EmailTextbox'), user_email)

WebUI.sendKeys(findTestObject('OnbordingLocators/PasswordTextBox'), user_password)

WebUI.click(findTestObject('OnbordingLocators/Login_Btn'))

CustomKeywords.'com.ApplicationDependedKeyword.invalidErrorMessageCheckingMethod'(findTestObject("OnbordingLocators/Err_Message_Invalid Email Format"),
	 findTestObject('OnbordingLocators/Err_Message_Invalid Password'), findTestObject('OnbordingLocators/Err_Message_Wrong email or password'), 
	 errMessage);