import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.chrome.ChromeOptions as ChromeOptions
import org.openqa.selenium.firefox.FirefoxOptions as FirefoxOptions
import org.openqa.selenium.firefox.ProfilesIni as ProfilesIni
import org.testng.Assert as Assert
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.webui.driver.WebUIDriverType as WebUIDriverType
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

WebUI.openBrowser('')

WebUI.navigateToUrl(localUrl)

WebUI.maximizeWindow()

CustomKeywords.'com.GenericKeywords.loadProperties'()

List<String> listOfaccountsnamewithAsc = CustomKeywords.'com.GenericKeywords.gettingAllElementsValueWithPagination'()

// Check List of record is Ascending Order or Not?
boolean isAscendingOrder = CustomKeywords.'com.GenericKeywords.checkListAscendingOrder'(listOfaccountsnamewithAsc)

Assert.assertTrue(isAscendingOrder)

WebUI.click(findTestObject('AccountsListingPageLocators/AccountsNameColumnLink'))

List<String> listOfaccountsnameDesc = CustomKeywords.'com.GenericKeywords.gettingAllElementsValueWithPagination'()

// Check List of record is Descending Order or Not?
boolean isDescendingOrder = CustomKeywords.'com.GenericKeywords.checkListDescendingOrder'(listOfaccountsnamewithAsc, listOfaccountsnameDesc)

Assert.assertTrue(isDescendingOrder)

WebUI.closeBrowser()

