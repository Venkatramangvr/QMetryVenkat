package Tests;


import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.Test;

import com.qmetry.qaf.automation.data.MetaData;
import com.qmetry.qaf.automation.testng.dataprovider.QAFDataProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.util.Reporter;

import CommonSteps.StepsLibrary;
import Logs.Log;

@MetaData("{'Story': 'Testing OpenCart Application'}")
public class TC001_RegisterAccount extends StepsLibrary {
	
	WebDriverTestCase Driver = new WebDriverTestCase();
	
	
	//Creating Constructor
	public TC001_RegisterAccount() {
		DOMConfigurator.configure("Logger\\Log4j.xml");
	}
	
	
	/****************************************************************************
	'* NAME				: testRegisterAccount
	'* SYNOPSIS			: Function used to Test Account Registered Successfully
	'* CREATED BY		: Venkatraman Ganesan
	'* CREATED DATE		: 21-06-2021
	'***************************************************************************/

	@MetaData("{'Author': 'Venkat'}")	
	@QAFDataProvider(dataFile="resources/TestInput.xls", sheetName="RegisterAccount")
	@Test
	public void testRegisterAccount(Map<String, String> data) throws InterruptedException {
		Driver.getDriver().manage().window().maximize();
		get("/");
		click("clickMyAccount");
		click("clickRegister");
		sendKeys(data.get("FirstName"), "inputFirstName");
		sendKeys(data.get("LastName"), "inputLastName");
		sendKeys(data.get("Email"), "inputEmail");
		sendKeys(String.valueOf(data.get("FirstName")), "inputTelephone");
		sendKeys(data.get("FirstName"), "inputPassword");
		sendKeys(data.get("FirstName"), "inputPasswordConfirm");
		click("clickPrivacyPolicy");
		click("clickContinue");
		Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Reporter.logWithScreenShot("TC001-01-AccountCreationMessage");
		String getText = getText("getAccountCreationMessage");
		Log.info(getText);
		try{
			assertText("getAccountCreationMessage", data.get("AccountCreatedMessage"));
			System.out.println("<------Assertion Done------>");
			System.out.println("Text Matched Successfully");
		}catch(Exception e) {
			e.getStackTrace();
		}
		click("clickContinue-1");
		Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Reporter.logWithScreenShot("TC001-02-AccountCreated");
	}
}