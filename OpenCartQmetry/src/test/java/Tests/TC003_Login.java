package Tests;

import java.util.Map;

import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.Test;

import com.qmetry.qaf.automation.data.MetaData;
import com.qmetry.qaf.automation.testng.dataprovider.QAFDataProvider;
import com.qmetry.qaf.automation.ui.WebDriverTestCase;

import CommonSteps.StepsLibrary;

@MetaData("{'Story': 'Testing OpenCart Application'}")
public class TC003_Login extends StepsLibrary {
	
	WebDriverTestCase Driver = new WebDriverTestCase();
	
	//Creating Constructor
		public TC003_Login() {
			DOMConfigurator.configure("Logger\\Log4j.xml");
		}
		
		
		/****************************************************************************
		'* NAME				: testLogin
		'* SYNOPSIS			: Function used to Login Successfully
		'* CREATED BY		: Venkatraman Ganesan
		'* CREATED DATE		: 21-06-2021
		'***************************************************************************/

		@MetaData("{'Author': 'Venkat'}")	
		@QAFDataProvider(dataFile="resources/TestInput.xls", sheetName="RegisterAccount")
		@Test
		public void testLogin(Map<String, String> data) throws InterruptedException {
			Driver.getDriver().manage().window().maximize();
			get("/");
			click("clickMyAccount");
			click("clickLogin");
			sendKeys(data.get("Email"), "inputEmailAddress");
			sendKeys(data.get("Password"), "inputPassword");
			click("clickLoginButton");
			Thread.sleep(3000);
		}


}
