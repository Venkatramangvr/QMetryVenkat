package Tests;

import java.util.Map;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.Test;

import com.qmetry.qaf.automation.data.MetaData;
import com.qmetry.qaf.automation.testng.dataprovider.QAFDataProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;

import CommonSteps.StepsLibrary;
import Logs.Log;

@MetaData("{'Story': 'Testing OpenCart Application'}")
public class TC004_VerifyTitle extends StepsLibrary {
	
WebDriverTestCase Driver = new WebDriverTestCase();
	
	//Creating Constructor
		public TC004_VerifyTitle() {
			DOMConfigurator.configure("Logger\\Log4j.xml");
		}
		
		
		/****************************************************************************
		'* NAME				: VerifyTitle
		'* SYNOPSIS			: Function used to VerifyTitle Successfully
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
			String getTitle = Driver.getDriver().getTitle();
			Log.info(getTitle);
			try{
				if(getTitle.compareTo(data.get("Title")) == 0) {
					System.out.println("<------Verification Done------>");
					System.out.println("Title Verified Successfully");
				}
			}catch(Exception e) {
				e.getStackTrace();
			}
		}
}
