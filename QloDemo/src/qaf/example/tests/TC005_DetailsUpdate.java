package qaf.example.tests;

import static com.qmetry.qaf.automation.step.CommonStep.assertText;
import static com.qmetry.qaf.automation.step.CommonStep.clear;
import static com.qmetry.qaf.automation.step.CommonStep.click;
import static com.qmetry.qaf.automation.step.CommonStep.get;
import static com.qmetry.qaf.automation.step.CommonStep.getText;
import static com.qmetry.qaf.automation.step.CommonStep.sendKeys;

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
public class TC005_DetailsUpdate extends WebDriverTestCase {

	WebDriverTestCase Driver = new WebDriverTestCase();
	
	//Creating Constructor
	public TC005_DetailsUpdate() {
		DOMConfigurator.configure("Logger\\Log4j.xml");
	}
		
		
	/*********************************************************************************
	'* NAME				: testPersonalDetailsUpdate	
	'* SYNOPSIS			: Function used to Test Personal Details Updated Successfully
	'* CREATED BY		: Venkatraman Ganesan
	'* CREATED DATE		: 10-06-2021
	'*********************************************************************************/
	@MetaData("{'Author': 'Venkat'}")	
	@QAFDataProvider(dataFile="resources/TestInput.xls", sheetName="RegisterAccount")
	@Test
	public void testPersonalDetailsUpdate(Map<String, String> data) throws InterruptedException {
		getDriver().manage().window().maximize();
		get("/");
		click("click.signin");
		clear("input.emailadd");
		sendKeys(data.get("Email"), "input.emailadd");
		clear("input.passadd");
		sendKeys(data.get("Password"), "input.passadd");
		click("click.login");
		click("click.personalinfo");
		clear("input.firstnameup");
		sendKeys(data.get("FirstNameUp"), "input.firstnameup");
		sendKeys(String.valueOf(data.get("DayUp")), "input.days");
		sendKeys(data.get("MonthUp"), "input.months");
		sendKeys(String.valueOf(data.get("YearUp")), "input.years");
		sendKeys(data.get("Password"), "input.currentpass");
		click("click.saveup");
		getDriver().manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		Reporter.logWithScreenShot("TC005-01-UpdateMessage");
		String getText = getText("get.updatemessage");
		assertText("get.updatemessage", "Your personal information has been successfully updated.");
		Log.info(getText);
	}
}
