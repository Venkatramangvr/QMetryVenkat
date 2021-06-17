package qaf.example.tests;

import static com.qmetry.qaf.automation.step.CommonStep.click;
import static com.qmetry.qaf.automation.step.CommonStep.get;
import static com.qmetry.qaf.automation.step.CommonStep.getText;
import static com.qmetry.qaf.automation.step.CommonStep.sendKeys;
import static com.qmetry.qaf.automation.step.CommonStep.assertText;
import static com.qmetry.qaf.automation.step.CommonStep.clear;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.qmetry.qaf.automation.data.MetaData;
import com.qmetry.qaf.automation.testng.dataprovider.QAFDataProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.util.Reporter;

import Logs.Log;

@MetaData("{'Story': 'Testing Qlo Application'}")
public class TC002_AddingAddress extends WebDriverTestCase {
	
	WebDriverTestCase Driver = new WebDriverTestCase();
	
	/****************************************************************************
	'* NAME				: testAddingAddress
	'* SYNOPSIS			: Function used to Test Address get added Successfully
	'* CREATED BY		: Venkatraman Ganesan
	'* CREATED DATE		: 10-06-2021
	'***************************************************************************/
	@MetaData("{'Author': 'Venkat'}")	
	@QAFDataProvider(dataFile="resources/TestInput.xls", sheetName="RegisterAccount")
	@Test
	public void testAddingAddress(Map<String, String> data) throws InterruptedException {
		getDriver().manage().window().maximize();
		get("/");
		click("click.signin");
		clear("input.emailadd");
		sendKeys(data.get("Email"), "input.emailadd");
		clear("input.passadd");
		sendKeys(data.get("Password"), "input.passadd");
		click("click.login");
		click("click.firstadd");
		sendKeys(data.get("Company"), "input.company");
		sendKeys(data.get("Address"), "input.address");
		sendKeys(data.get("Address1"), "input.address1");
		sendKeys(data.get("City"), "input.city");
		sendKeys(data.get("State"), "select.state");
		sendKeys(String.valueOf(data.get("ZipCode")), "input.zipcode");
		sendKeys(String.valueOf(data.get("HomePhone")), "input.hphone");
		sendKeys(String.valueOf(data.get("Telephone")), "input.mphone");
		sendKeys(data.get("Addinfo"), "input.addinfo");
		click("click.subadd");
		getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Reporter.logWithScreenShot("TC002-01-Address");
		String getText = getText("get.messageadd");
		Log.info(getText);
		assertText("get.messageadd", "Your addresses are listed below.");
		click("click.bhome");
		getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

}
