package qaf.example.tests;

import static com.qmetry.qaf.automation.step.CommonStep.click;
import static com.qmetry.qaf.automation.step.CommonStep.get;
import static com.qmetry.qaf.automation.step.CommonStep.sendKeys;
import static com.qmetry.qaf.automation.step.CommonStep.getText;
import static com.qmetry.qaf.automation.step.CommonStep.assertText;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.Test;

import com.qmetry.qaf.automation.data.MetaData;
import com.qmetry.qaf.automation.testng.dataprovider.QAFDataProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.util.Reporter;

import Logs.Log;


@MetaData("{'Story': 'Testing Qlo Application'}")
public class TC001_RegisterAccount extends WebDriverTestCase {
	
	WebDriverTestCase Driver = new WebDriverTestCase();
	
	
	//Creating Constructor
	public TC001_RegisterAccount() {
		DOMConfigurator.configure("Logger\\Log4j.xml");
	}
	
	
	/****************************************************************************
	'* NAME				: testRegisterAccount
	'* SYNOPSIS			: Function used to Test Account Registered Successfully
	'* CREATED BY		: Venkatraman Ganesan
	'* CREATED DATE		: 10-06-2021
	'***************************************************************************/

	@MetaData("{'Author': 'Venkat'}")	
	@QAFDataProvider(dataFile="resources/TestInput.xls", sheetName="RegisterAccount")
	@Test
	public void testRegisterAccount(Map<String, String> data) throws InterruptedException {
		getDriver().manage().window().maximize();
		get("/");
		click("click.signin");
		sendKeys(data.get("Email"), "input.email");
		click("click.createacc");
		click("select.title");
		sendKeys(data.get("FirstName"), "input.firstname");
		sendKeys(data.get("LastName"), "input.lastname");
		sendKeys(data.get("Password"), "input.password");
		sendKeys(String.valueOf(data.get("Day")), "input.days");
		sendKeys(data.get("Month"), "input.months");
		sendKeys(String.valueOf(data.get("Year")), "input.years");
		click("click.submit");
		getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Reporter.logWithScreenShot("TC001-01-SuccessMessage");
		String getText = getText("get.sucmessage");
		Log.info(getText);
		assertText("get.sucmessage", "Your account has been created.");
		click("click.profile");
		getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		click("click.logout");
	}	

}
