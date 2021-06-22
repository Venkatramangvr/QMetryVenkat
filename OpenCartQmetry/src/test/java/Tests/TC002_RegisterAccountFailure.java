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
public class TC002_RegisterAccountFailure extends StepsLibrary {
	
WebDriverTestCase Driver = new WebDriverTestCase();
	
	
	//Creating Constructor
	public TC002_RegisterAccountFailure() {
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
		sendKeys(data.get("FirstName"), "inputPassword");
		sendKeys(data.get("FirstName"), "inputPasswordConfirm");
		click("clickPrivacyPolicy");
		click("clickContinue");
		Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Reporter.logWithScreenShot("TC002-01-ErrorMessage");
		String getText = getText("getErrorMessage");
		Log.info(getText);
	}	
}
