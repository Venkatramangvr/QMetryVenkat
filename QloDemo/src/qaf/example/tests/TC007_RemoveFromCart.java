package qaf.example.tests;

import static com.qmetry.qaf.automation.step.CommonStep.assertText;
import static com.qmetry.qaf.automation.step.CommonStep.click;
import static com.qmetry.qaf.automation.step.CommonStep.get;
import static com.qmetry.qaf.automation.step.CommonStep.getText;
import static com.qmetry.qaf.automation.step.CommonStep.sendKeys;
import static com.qmetry.qaf.automation.step.CommonStep.mouseOver;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import com.qmetry.qaf.automation.data.MetaData;
import com.qmetry.qaf.automation.testng.dataprovider.QAFDataProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.qmetry.qaf.automation.util.Reporter;

import Logs.Log;

@MetaData("{'Story': 'Testing Qlo Application'}")
public class TC007_RemoveFromCart extends WebDriverTestCase {
	
	WebDriverTestCase Driver = new WebDriverTestCase();
	
	
	/****************************************************************************
	'* NAME				: testRemoveFromCart
	'* SYNOPSIS			: Function used to Test Remove from Cart Successfully
	'* CREATED BY		: Venkatraman Ganesan
	'* CREATED DATE		: 10-06-2021
	'***************************************************************************/
	@MetaData("{'Author': 'Venkat'}")	
	@QAFDataProvider(dataFile="resources/TestInput.xls", sheetName="RegisterAccount")
	@Test
	public void testRemoveFromCart(Map<String, String> data) throws InterruptedException {
		getDriver().manage().window().maximize();
		get("/");
		click("click.menu");
		click("click.roomsmenu");
		click("click.cross");
		Thread.sleep(3000);
		sendKeys(data.get("Location"), "input.location");
		click("click.hotelopt");
		click("select.prime");
		click("click.checkindate");
		click("click.checkindate1");
		click("click.checkoutdate");
		click("click.checkoutdate1");
		click("click.searchnow");
		click("click.booknow");
		getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		click("click.checkout");
		mouseOver("mouseover.orderbasket");
		Thread.sleep(2000);
		click("click.removeroom");
		Thread.sleep(5000);
		Reporter.logWithScreenShot("TC007-01-RemoveCart");
		String getText = getText("get.cancelmessage");
		Log.info(getText);
		assertText("get.cancelmessage", "Till now you did not added any room in your cart.");
		getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		click("click.logout");
	}
}
