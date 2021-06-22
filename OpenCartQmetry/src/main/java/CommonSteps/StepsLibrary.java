package CommonSteps;

import static com.qmetry.qaf.automation.ui.webdriver.ElementFactory.$;

import com.qmetry.qaf.automation.core.TestBaseProvider;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;

public class StepsLibrary {
	
	/**
	 * Opens an URL in the browser. This accepts both relative and absolute
	 * URLs. The "get" command waits for the page to load before proceeding, *
	 * <p>
	 * Example:<br/>
	 * <code>
	 * get 'http://www.infostretch.com'<br/>
	 * get '/'<br/>
	 * get '/Resources/case-studies.php'<br/>
	 * </code>
	 * 
	 * @param url
	 *            : {0} : the URL to open; may be relative or absolute
	 */
	@QAFTestStep(description = "get {url}")
	public static void get(String url) {
		new WebDriverTestBase().getDriver().get(url);
	}
	
	/**
	 * Clicks on a link, button, checkbox or radio button. If the click action
	 * causes a new page to load (like a link usually does), call
	 * waitForPageToLoad.
	 * <p>
	 * Example:
	 * <p>
	 * BDD
	 * </p>
	 * <code>
	 * click on 'my.ele.loc'<br/>
	 * </code>
	 * <p>
	 * KWD
	 * </p>
	 * 
	 * @param loc
	 *            : {0} : an element locator, can be direct locator value or a
	 *            locator key stored in locator repository
	 */
	@QAFTestStep(description = "click on {loc}")
	public static void click(String loc) {
		$(loc).click();
	}
	
	/**
	 * Insert text in the given locator
	 * <p>
	 * Example:<br/>
	 * <code>
	 * sendKeys 'infostretch' into 'my.ele.loc'<br/>
	 * <br/>
	 * </code>
	 * 
	 * @param text
	 *            : {0} : String to be insert
	 * @param loc
	 *            : {1} : an element locator, can be direct locator value or a
	 *            locator key stored in locator repository
	 */
	@QAFTestStep(description = "sendKeys {text} into {loc}")
	public static void sendKeys(String text, String loc) {
		$(loc).sendKeys(text);
	}
	
	/**
	 * Verify the text of an element. This works for any element that contains
	 * text. This command uses either the textContent or the innerText of the
	 * element, which is the rendered text shown to the user.
	 * <p>
	 * Example:
	 * <p>
	 * BDD
	 * </p>
	 * <code>
	 * assert 'my.ele.loc' text is 'infostretch'<br/>
	 * </code>
	 * <p>
	 * KWD
	 * </p>
	 * 
	 * @param loc
	 *            : {0} : an element locator, can be direct locator value or a
	 *            locator key stored in locator repository
	 * @param text
	 *            : {1} : The text of element locator
	 */
	@QAFTestStep(description = "assert {loc} text is {text}")
	public static void assertText(String loc, String text) {
		$(loc).assertText(text);
	}
	
	/**
	 * Retrieve the value for specified element.
	 * <p>
	 * Example:
	 * <p>
	 * BDD
	 * </p>
	 * <code>
	 * get text of 'my.ele.loc'<br/>
	 * </code>
	 * <p>
	 * KWD
	 * </p>
	 * 
	 * @param loc
	 *            : {0} : an element locator, can be direct locator value or a
	 *            locator key stored in locator repository
	 * @return The text contains by the specified locator
	 */
	@QAFTestStep(description = "get text of {loc}")
	public static String getText(String loc) {
		return $(loc).getText();
	}
	
	@QAFTestStep(description = "mouse move on {loc}")
	public static void mouseOver(String loc) {
		new WebDriverTestBase().getDriver().getMouse().mouseMove(((QAFExtendedWebElement) $(loc)).getCoordinates());
	}
	
	/**
	 * This step will tear down driver. It will quite and end current browser
	 * session.
	 */
	@QAFTestStep(description = "tear down driver")
	public static void tearDownDriver() {
		TestBaseProvider.instance().get().tearDown();
	}
}
