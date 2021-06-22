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
public class TC005_SelectProduct extends StepsLibrary {
	
	WebDriverTestCase Driver = new WebDriverTestCase();
	
	//Creating Constructor
		public TC005_SelectProduct() {
			DOMConfigurator.configure("Logger\\Log4j.xml");
		}
			
			
		/****************************************************************************
		'* NAME				: SelectProduct
		'* SYNOPSIS			: Function used to SelectProduct Successfully
		'* CREATED BY		: Venkatraman Ganesan
		'* CREATED DATE		: 21-06-2021
		'***************************************************************************/

		@MetaData("{'Author': 'Venkat'}")	
		@QAFDataProvider(dataFile="resources/TestInput.xls", sheetName="RegisterAccount")
		@Test
		public void verifyTitle(Map<String, String> data) throws InterruptedException {
			Driver.getDriver().manage().window().maximize();
			get("/");
			click("clickMyAccount");
			click("clickLogin");
			sendKeys(data.get("Email"), "inputEmailAddress");
			sendKeys(data.get("Password"), "inputPassword");
			click("clickLoginButton");
			mouseOver("clickDesktop");
			click("clickMac");
			click("clickAddtoCart");
			Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			Reporter.logWithScreenShot("TC005-01-ProductAdded");
			String getText = getText("getSuccessMessage");
			Log.info(getText);
			try{
				assertText("getSuccessMessage", data.get("SuccessMessage"));
				System.out.println("<------Assertion Done------>");
				System.out.println("Text Matched Successfully");
			}catch(Exception e) {
				e.getStackTrace();
			}
				tearDownDriver();
		}
	}
