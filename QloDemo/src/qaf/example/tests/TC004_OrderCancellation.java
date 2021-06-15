package qaf.example.tests;

import static com.qmetry.qaf.automation.step.CommonStep.clear;
import static com.qmetry.qaf.automation.step.CommonStep.click;
import static com.qmetry.qaf.automation.step.CommonStep.get;
import static com.qmetry.qaf.automation.step.CommonStep.sendKeys;

import java.util.Map;

import org.testng.annotations.Test;

import com.qmetry.qaf.automation.data.MetaData;
import com.qmetry.qaf.automation.testng.dataprovider.QAFDataProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;


@MetaData("{'Story': 'Testing Qlo Application'}")
public class TC004_OrderCancellation extends WebDriverTestCase {
	
	
	WebDriverTestCase Driver = new WebDriverTestCase();
	
	
	/*********************************************************************************
	'* NAME				: testOrderCancellation	
	'* SYNOPSIS			: Function used to Test Order Cancelled Successfully
	'* CREATED BY		: Venkatraman Ganesan
	'* CREATED DATE		: 10-06-2021
	'*********************************************************************************/
	@MetaData("{'Author': 'Venkat'}")	
	@QAFDataProvider(dataFile="resources/TestInput.xls", sheetName="RegisterAccount")
	@Test
	public void testOrderCancellation(Map<String, String> data) throws InterruptedException {
		getDriver().manage().window().maximize();
		get("/");
		click("click.signin");
		clear("input.emailadd");
		sendKeys(data.get("Email"), "input.emailadd");
		clear("input.passadd");
		sendKeys(data.get("Password"), "input.passadd");
		click("click.login");
		Thread.sleep(2000);
		click("click.orderhistory");
		click("click.orderdetails");
		Thread.sleep(2000);
		click("click.cancelbookings");
		Thread.sleep(2000);
		click("click.checkboxcancel");
		click("click.submitcancel");
		Thread.sleep(2000);
		sendKeys(data.get("CancelMessage"), "input.cancelreason");
		click("click.submitreason");
		Thread.sleep(5000);
		click("click.logout");
		Thread.sleep(7000);
	}
}
