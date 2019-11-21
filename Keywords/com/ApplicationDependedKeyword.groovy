package com

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.stringtemplate.v4.compiler.STParser.element_return
import org.testng.Assert

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class ApplicationDependedKeyword {


	WebDriver driver = DriverFactory.getWebDriver();
	GenericKeywords generickey = new GenericKeywords();

	@Keyword
	public void invalidErrorMessageCheckingMethod(TestObject testobject1, TestObject testobject2, TestObject testobject3,
			String errorMessage){


		List<WebElement> element = WebUiCommonHelper.findWebElements(testobject1, 10);
		List<WebElement> element1 = WebUiCommonHelper.findWebElements(testobject2, 10);
		List<WebElement> element2 = WebUiCommonHelper.findWebElements(testobject3, 10);


		if(element.size()!=0){

			generickey.printLog("Verified text is : "+element.get(0).getText());

			Assert.assertEquals(element.get(0).getText(), errorMessage);
		}
		else if(element1.size()!=0){

			generickey.printLog("Verified text is : "+element1.get(0).getText());

			Assert.assertEquals(element1.get(0).getText(), errorMessage);
		}
		else if(element2.size()!=0){

			generickey.printLog("Verified text is : "+element2.get(0).getText());
			println "Verified text is : "+element2.get(0).getText();
			if(errorMessage.equalsIgnoreCase(element2.get(0).getText())){

				Assert.assertEquals(element2.get(0).getText(), errorMessage);
			}
			else if(errorMessage.equalsIgnoreCase(element2.get(0).getText())){

				Assert.assertEquals(element2.get(0).getText(), errorMessage);
			}
		}
	}
}
