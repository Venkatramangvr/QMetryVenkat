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
public class TC006_ContactUs extends WebDriverTestCase {
	
	
	WebDriverTestCase Driver = new WebDriverTestCase();
	
	//Creating Constructor
	public TC006_ContactUs() {
		DOMConfigurator.configure("Logger\\Log4j.xml");		
	}	
		
	/****************************************************************************
 	'* NAME				: testContactUs
	'* SYNOPSIS			: Function used to Test Customer Service
	'* CREATED BY		: Venkatraman Ganesan
	'* CREATED DATE		: 10-06-2021
	'***************************************************************************/
	@MetaData("{'Author': 'Venkat'}")	
	@QAFDataProvider(dataFile="resources/TestInput.xls", sheetName="RegisterAccount")
	@Test
	public void testContactUs(Map<String, String> data) throws InterruptedException {
		getDriver().manage().window().maximize();
		get("/");
		click("click.menu");
		click("click.contact");
		click("select.subject");
		click("click.cusservice");
		clear("input.emailcon");
		sendKeys(data.get("Email"), "input.emailcon");
		sendKeys(data.get("Message"), "input.message");
		click("click.sendmessage");
		getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Reporter.logWithScreenShot("TC006-01-Contact Us");
		String getText = getText("get.successsendmes");
		Log.info(getText);
		assertText("get.successsendmes", "Your message has been successfully sent to our team.");
		getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		click("click.logout");
	}
}
