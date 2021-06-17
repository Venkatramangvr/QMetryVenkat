package qaf.example.tests;

import static com.qmetry.qaf.automation.step.CommonStep.assertText;
import static com.qmetry.qaf.automation.step.CommonStep.click;
import static com.qmetry.qaf.automation.step.CommonStep.get;
import static com.qmetry.qaf.automation.step.CommonStep.getText;
import static com.qmetry.qaf.automation.step.CommonStep.sendKeys;

import java.util.ArrayList;
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
public class TC003_BookingRoom extends WebDriverTestCase {
	
	//Creating Constructor
	public TC003_BookingRoom() {
		DOMConfigurator.configure("Logger\\Log4j.xml");
	}
	
	WebDriverTestCase Driver = new WebDriverTestCase();

	/****************************************************************************
	'* NAME				: testBookingRoom
	'* SYNOPSIS			: Function used to Test Room Successfully
	'* CREATED BY		: Venkatraman Ganesan
	'* CREATED DATE		: 10-06-2021
	'***************************************************************************/
	@MetaData("{'Author': 'Venkat'}")	
	@QAFDataProvider(dataFile="resources/TestInput.xls", sheetName="RegisterAccount")
	@Test
	public void testBookingRoom(Map<String, String> data) throws InterruptedException {
		getDriver().manage().window().maximize();
		get("/");
		click("click.menu");
		click("click.roomsmenu");
		click("click.cross");
		Thread.sleep(5000);
		click("click.booknowroom");
		Thread.sleep(5000);
		ArrayList<String> tabs2 = new ArrayList<String> (getDriver().getWindowHandles());
	    getDriver().switchTo().window(tabs2.get(1));
	    Thread.sleep(5000);
		click("click.checkindateroom");
		click("click.checkindateroom1");
		Thread.sleep(5000);
		click("click.checkoutdateroom");
		click("click.checkoutdateroom1");
		click("click.booknw");
		Thread.sleep(5000);
		click("click.proceedtocheckout");
		click("click.proceed");
		click("click.loginnow");
		sendKeys(data.get("Email"), "input.loginemail");
		sendKeys(data.get("Password"), "input.loginpass");
		click("click.loginsignin");
		click("click.loginproceed");
		click("click.checkbox");
		click("click.paybankwire");
		click("click.confirmorder");
		Thread.sleep(5000);
		Reporter.logWithScreenShot("TC003-01-ConfirmMessage");
		String getText = getText("get.confirmmessage");
		System.out.println(getText);
		Log.info(getText);
		assertText("get.confirmmessage", "Your order on Qlo Reservation System is complete.");
		getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		click("click.logout");
	}
}
