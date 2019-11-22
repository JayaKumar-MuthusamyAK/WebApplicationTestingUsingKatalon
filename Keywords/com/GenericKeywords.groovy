package com

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import java.text.SimpleDateFormat

import javax.imageio.ImageIO

import org.apache.commons.lang.RandomStringUtils
import org.openqa.selenium.By
import org.openqa.selenium.Cookie
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.testng.Assert

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.logging.KeywordLogger
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable
import ru.yandex.qatools.ashot.AShot
import ru.yandex.qatools.ashot.Screenshot

public class GenericKeywords {

	WebDriver driver = DriverFactory.getWebDriver();

	FileWriter filewriter = new FileWriter(System.getProperty("user.dir")+"\\TestOutput\\brokenLinkUrl.txt",true);

	BufferedWriter bw = new BufferedWriter(filewriter);

	FileInputStream fileinput = null;

	Properties prop = new Properties();

	@Keyword
	public void loadProperties(){

		fileinput =  new FileInputStream(System.getProperty("user.dir")+"\\console.properties");
		prop.load(fileinput);
	}

	// Used to Verify the Page Title:
	@Keyword
	public void verifyTitle(String titleText){

		Assert.assertEquals(titleText, driver.getTitle());
	}


	// Used to Swicthing the Frame:
	@Keyword
	public void switchToFrame(TestObject testObject){


		/*List<WebElement> listOfiFrame = driver.findElements(By.tagName("iframe"));
		 println listOfiFrame.size();*/

		// Our application only 1 Frame..
		driver.switchTo().frame(0);
		WebElement element = WebUiCommonHelper.findWebElement(testObject, 10);
		printLog("Element name is : "+element.getText());
		element.click()
	}

	// Used to Swicthing the Main Window:
	@Keyword
	public void switchToDefaultWindow(){

		driver.switchTo().defaultContent();

	}


	// Using to check password field is encrypted or not?
	@Keyword
	public void passwordFieldEncrypedChecker(TestObject testObjects){

		WebElement element = WebUiCommonHelper.findWebElement(testObjects, 10);
		String encryptedPasswordText = element.getAttribute(prop.getProperty("typeattribute"));

		if(encryptedPasswordText.equalsIgnoreCase(prop.getProperty("passwordattribute"))){
			Assert.assertEquals(encryptedPasswordText, prop.getProperty("passwordattribute"));
		}
		else{
			Assert.assertEquals(encryptedPasswordText, prop.getProperty("passwordattribute"))
		}
	}


	// Log section:
	@Keyword
	public void printLog(String data){

		KeywordUtil.logInfo(data);
		println data;
	}


	// Used to get cookies domain.
	@Keyword
	public String getCookiesValue(){

		Set<Cookie> cookies = driver.manage().getCookies();

		String domainname;

		for(Cookie cookie : cookies){
			printLog(cookie.getName()+"--"+cookie.getValue()+"--"+cookie.getDomain());

			domainname = cookie.getDomain();
		}

		return domainname;
	}


	// Used to delete the cookies:

	@Keyword
	public void deleteAllCookies(){

		driver.manage().deleteAllCookies();

	}


	// For registering purpose we need this method. Used to get the random phone no
	@Keyword
	public String randomPhoneNumberGenerator(){

		String phoneNo = null;

		String temp = RandomStringUtils.random(0, "12345678901234567890");

		String numbers = temp.substring(9, temp.length());

		phoneNo=9+numbers;

		printLog(phoneNo);

		return phoneNo;
	}


	// For registering purpose we need this method. Used to get the random Email
	@Keyword
	public String randomEmailIDGenerator(){

		String emailID = null;

		String tempemail =  RandomStringUtils.random(0,"abcdefghijklmnopqrstuvwxyz")

		String email = tempemail.substring(12, tempemail.length());

		return email+"@yopmail.com"
	}

	// Used to get the Title of the page:
	@Keyword
	public String getTitle(){

		return driver.getTitle();
	}

	// Used to get the list of elements in the given object
	@Keyword
	public List<WebElement> findElements(TestObject testObject){

		return WebUiCommonHelper.findWebElements(testObject, 20);
	}


	// used to get the web element in given object
	@Keyword
	public WebElement findElement(TestObject testObject){

		return WebUiCommonHelper.findWebElement(testObject, 20);
	}

	@Keyword
	public boolean checkListAscendingOrder(List<String> listOfString){

		List<String> tempString = new ArrayList<String>(listOfString);

		Collections.sort(tempString);

		return tempString.equals(listOfString);

	}

	@Keyword
	public boolean checkListDescendingOrder(List<String> listOfString, List<String> listOfStringWithDesc){
		
		List<String> tempString = new ArrayList<String>(listOfStringWithDesc);

		Collections.sort(listOfString, Collections.reverseOrder());
		
		return tempString.equals(listOfString);
	}

	@Keyword
	public List<String> gettingAllElementsValueWithPagination(){

		String textOfTotalCount = driver.findElement(By.xpath("//div[@id='example_info']")).getText();
		
		int totalCount = Integer.parseInt(textOfTotalCount.split("of")[1].split("entries")[0].trim());
		
		WebElement nextbutton = driver.findElement(By.xpath("//a[@class='paginate_button next']"));
		
		List<WebElement> listOfNames = driver.findElements(By.xpath("//table[@class='display dataTable no-footer']/tbody/tr/td[1]"));
	
		int initialCount = listOfNames.size();
		
		List<String> listOfStringValue = new ArrayList<String>();
		
		
		while(initialCount!=totalCount){
			
			nextbutton = driver.findElement(By.xpath("//a[@class='paginate_button next']"));
		
			for(WebElement element: listOfNames){
				
				println element.getText();
				
				listOfStringValue.add(element.getText());
				
			}
			
			nextbutton.click();
			
			Thread.sleep(500);
			
			listOfNames = driver.findElements(By.xpath("//table[@class='display dataTable no-footer']/tbody/tr/td[1]"));
			
			initialCount += listOfNames.size();
			
			println initialCount;
			
		}
		
		for(WebElement element: listOfNames){
			
			println element.getText();
			
			listOfStringValue.add(element.getText());
			
		}
		
		println listOfStringValue.size();
		
		return listOfStringValue;
	}
	// Used to Take a Screen shot with respective folder
	@Keyword
	public void takeScreenShot(){

		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat simpleformat = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");

		printLog("Report folder name is : "+RunConfiguration.getReportFolder());

		Screenshot  screen =new AShot().takeScreenshot(driver);
		ImageIO.write(screen.getImage(), "PNG", new File(System.getProperty("user.dir")+"\\Screenshots\\"+simpleformat.format(calendar.getTime())));

		/*ImageDiffer imagediffer = new ImageDiffer();
		 ImageDiff imagediff = imagediffer.makeDiff(screen, screen)*/
	}


	// Used to get the broken link for website
	@Keyword
	public boolean isBrokenLinkchecker(URL url){

		HttpURLConnection conn = (HttpURLConnection) url.openConnection();

		boolean isHasBrokenlink = false;

		Thread.sleep(300);

		try{
			//File file = new File("C:\\Users\\Dell\\Katalon Studio\\SampleTestProject\\TestData\\BrokenlinksWithStatus.txt");

			conn.connect();

			// Here Will check Given URL (links) Status code is 200 or not?
			if(conn.getResponseCode()==500){

				printLog("--------------------------------------------------------------------------");
				//println "The URL is : "+url+ " and the message is : "+message+" Status Code is : "+conn.getResponseCode();
				printLog("The URL is : "+url+ " and the message is : "+conn.getResponseMessage()+" Status Code is : "+conn.getResponseCode());
				bw.write("The URL is : "+url+ " and the message is : "+conn.getResponseMessage()+" Status Code is : "+conn.getResponseCode());
				bw.newLine();
				bw.write("--------------------------------------------------------------------------");
				bw.newLine();

				isHasBrokenlink = true;

			}
			else {

				printLog("The URL is : "+url+ " and the message is : "+conn.getResponseMessage()+" Status Code is : "+conn.getResponseCode());
				bw.write("The URL is : "+url+ " and the message is : "+conn.getResponseMessage()+" Status Code is : "+conn.getResponseCode());
				bw.newLine();
				bw.write("--------------------------------------------------------------------------");
				bw.newLine();
			}
			printLog("--------------------------------------------------------------------------");

			conn.disconnect();
		}
		catch(Exception e){

			printLog(e.getMessage());
		}

		return isHasBrokenlink;

	}

	@Keyword
	public boolean getURLsForCurrrentPage(){

		List<WebElement> listOfATags = driver.findElements(By.tagName('a'));
		boolean isBrokenLnk = false;

		listOfATags.addAll(driver.findElements(By.tagName('img')));

		for (WebElement element : listOfATags) {
			if (element.getAttribute('href') != null) {
				if (element.getAttribute('href').contains('https://') || element.getAttribute('href').contains('http://')) {
					println(element.getAttribute('href'));
					isBrokenLnk = isBrokenLinkchecker(new URL(element.getAttribute('href')));
				}
			}
		}

		bw.flush();
		bw.close();

		if(isBrokenLnk==false)
			return false;
		else
			return true;

	}
}
