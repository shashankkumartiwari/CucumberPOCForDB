package com.db.common;

import java.util.Random;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Utilities {

	private WebDriverWait smallWait;
	private WebDriverWait mediumWait;
	private WebDriverWait longWait;
	private static WebDriver driver;
	private static WebDriverWait w = null;
	private static JavascriptExecutor js;

	/*
	 * Method Name : Parameterized Constructor Method Description : loads and
	 * initializes the web driver Input Parameters : Output Parameters :
	 */
	public Utilities(WebDriver driver) {
		Utilities.driver = driver;
		js = (JavascriptExecutor) getDriver();
	}

	/*
	 * Setters for the encapsulated variables
	 */
	public void setSmallWait(WebDriverWait smallWait) {
		this.smallWait = smallWait;
	}

	public void setMediumWait(WebDriverWait mediumWait) {
		this.mediumWait = mediumWait;
	}

	public void setLongWait(WebDriverWait longWait) {
		this.longWait = longWait;
	}

	/*
	 * Getters for the encapsulated variables
	 */
	public WebDriverWait getSmallWait() {
		return smallWait;
	}

	public WebDriverWait getMediumWait() {
		return mediumWait;
	}

	public WebDriverWait getLongWait() {
		return longWait;
	}

	public static WebDriver getDriver() {
		return driver;
	}

	/*
	 * Method Name : getDriverWait Method Description : returns the web-driver wait
	 * object with required time period stamp Input Parameters : time period in
	 * string format ; small/medium/large Output Parameters : web-driver wait object
	 */
	public static WebDriverWait getDriverWait(String timePeriod) {
		switch (timePeriod.toLowerCase().trim()) {
		case "small":
			w = new WebDriverWait(getDriver(), 10); // need to implement through the properties file.
			break;
		case "medium":
			w = new WebDriverWait(getDriver(), 20);
			break;
		case "large":
			w = new WebDriverWait(getDriver(), 30);
			break;
		}
		return w;
	}

	/*
	 * Method Name : waitForElementVisibility Method Description : waits for the
	 * visibility of the element Input Parameters : WebElement element Output
	 * Parameters :
	 */
	public void waitForElementVisibility(WebElement element) {
		int counter = 0;
		boolean foundFlag = false;
		int timePeriodForWait = 20; // drive from medium wait through properties file
		String locatorName = getLocatorTechniqueFromWebElement(element).trim();
		String locatorValue = getLocatorValueFromWebElement(element).trim();
		By ele = locatorTechnique(locatorName, locatorValue);
		while (counter < timePeriodForWait) {
			try {
				Thread.sleep(1000);
				if (isElementDisplayed(element)) {
					foundFlag = true;
					break;
				} else
					counter += 1;
			} catch (Exception e) {
				counter += 1;
			} catch (Error err) {
				counter += 1;
			} catch (Throwable t) {
				counter += 1;
			}

		}
		if (!foundFlag)
			Assert.fail("The required element " + element + ", was not visible after a " + "wait of "
					+ timePeriodForWait + " seconds");

	}

	/*
	 * Method Name : locatorTechnique Method Description : return the By element
	 * form the web element Input Parameters : locator name and locator value Output
	 * Parameters : By element
	 */
	public By locatorTechnique(String locatorName, String locatorValue) {
		By ele = null;
		switch (locatorName.toLowerCase().trim()) {
		case "xpath":
			ele = By.xpath(locatorValue);
			break;
		case "css":
			ele = By.cssSelector(locatorValue);
			break;
		case "name":
			ele = By.name(locatorValue);
			break;
		case "id":
			ele = By.id(locatorValue);
			break;
		case "tagname":
			ele = By.tagName(locatorValue);
			break;
		case "linktext":
			ele = By.linkText(locatorValue);
			break;
		case "partiallinktext":
			ele = By.partialLinkText(locatorValue);
			break;
		case "classname":
			ele = By.className(locatorValue);
			break;
		}
		return ele;
	}

	/*
	 * Method Name : getLocatorTechniqueFromWebElement Method Description : extracts
	 * the locator technique name used from the web element Input Parameters :
	 * WebElement element Output Parameters : String locator name
	 */
	private String getLocatorTechniqueFromWebElement(WebElement element) {
		String a = element.toString().substring((element.toString().indexOf("->") + 2)).split(":")[0];
		return a;
	}

	/*
	 * Method Name : getLocatorValueFromWebElement Method Description : extracts the
	 * locator technique value used from the web element Input Parameters :
	 * WebElement element Output Parameters : String value
	 */
	public String getLocatorValueFromWebElement(WebElement element) {
		String a = element.toString().substring((element.toString().lastIndexOf(":") + 1));
		return a;
	}

	/*
	 * Method Name : isElementDisplayed Method Description : returns the boolean
	 * value of the element visibility status Input Parameters : By element Output
	 * Parameters : true/false
	 */
	public boolean isElementDisplayed(By element) {
		setMediumWait(getDriverWait("medium"));
		getMediumWait().until(ExpectedConditions.visibilityOfElementLocated(element));
		return driver.findElement(element).isDisplayed();
	}

	/*
	 * Method Name : isElementDisplayed Method Description : returns the boolean
	 * value of the element visibility status Input Parameters : WebElement element
	 * Output Parameters : true/false
	 */
	public boolean isElementDisplayed(WebElement element) {
		setMediumWait(getDriverWait("medium"));
		try {
			if (element.isDisplayed())
				return true;
			else
				return false;
		} catch (Exception e) {
			return false;
		}
	}

	/*
	 * Method Name : waitForScreenLoad Method Description : to wait for 2 seconds
	 * Input Parameters : Output Parameters :
	 */
	public void waitForScreenLoad() {
		try {
			Thread.sleep(4000);
		} catch (Exception e) {
		}
	}

	/*
	 * Method Name : clickElement Method Description : clicks on the desired element
	 * Input Parameters : WebElement object Output Parameters :
	 */
	public void clickElement(WebElement element) {
		if (isElementDisplayed(element))
			element.click();
		else
			Assert.fail("Element not visible " + element.toString());
	}

	/*
	 * Method Name : scrollToTopOfThePage Method Description : to scroll to top of
	 * the page using javascript executor Input Parameters : Output Parameters :
	 */
	public void scrollToTopOfThePage() {
		js.executeScript("window.scrollTo(document.body.scrollHeight, 0)");
	}

	/*
	 * Method Name : scrollToBottomOfThePage Method Description : to scroll to
	 * bottom of the page using javascript executor Input Parameters : Output
	 * Parameters :
	 */
	public void scrollToBottomOfThePage() {
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}

	/*
	 * Method Name : singleScrollDown Method Description : to scroll down a single
	 * time Input Parameters : Output Parameters :
	 */
	public void singleScrollDown() {
		js.executeScript("window.scrollBy(0,250)", "");
	}

	/*
	 * Method Name : halfScrollDown Method Description : to scroll down a half of
	 * the time Input Parameters : Output Parameters :
	 */
	public void halfScrollDown() {
		js.executeScript("window.scrollBy(0,150)", "");
	}

	/*
	 * Method Name : singleScrollUp Method Description : to scroll up a single time
	 * Input Parameters : Output Parameters :
	 */
	public void singleScrollUp() {
		js.executeScript("window.scrollBy(0,-250)", "");
	}

	/*
	 * Method Name : halfScrollUp Method Description : to scroll up a half time
	 * Input Parameters : Output Parameters :
	 */
	public void halfScrollUp() {
		js.executeScript("window.scrollBy(0,-150)", "");
	}

	/*
	 * Method Name : keyBoardEvent Method Description : to use the keyboard events
	 * Input Parameters : webelement, key to use Output Parameters :
	 */
	public void keyBoardEvent(WebElement element, String keyToUse) {
		switch (keyToUse.toLowerCase().trim()) {
		case "tab":
			element.sendKeys(Keys.TAB);
			break;
		case "arrow up":
			element.sendKeys(Keys.ARROW_UP);
			break;
		case "arrow down":
			element.sendKeys(Keys.ARROW_DOWN);
			break;
		case "arrow left":
			element.sendKeys(Keys.ARROW_LEFT);
			break;
		case "arrow right":
			element.sendKeys(Keys.ARROW_RIGHT);
			break;
		case "enter":
			element.sendKeys(Keys.ENTER);
			break;
		case "control-delete":
			element.sendKeys(Keys.CONTROL + "a");
			element.sendKeys(Keys.DELETE);
			break;
		case "escape":
			element.sendKeys(Keys.ESCAPE);
			break;
		case "page down":
			element.sendKeys(Keys.PAGE_DOWN);
			break;
		case "page up":
			element.sendKeys(Keys.PAGE_UP);
			break;
		case "refresh":
			element.sendKeys(Keys.F5);
		}
	}

	/*
	 * Method Name : getCurrentURL Method Description : to get the current URL Input
	 * Parameters : driver Output Parameters : URL as string
	 */
	public String getCurrentURL() {
		String url = getDriver().getCurrentUrl();
		return url;
	}

	/*
	 * Method Name : checkPageIsReady Method Description : to wait for the page load
	 * to happen Input Parameters : Output Parameters :
	 */
	public void checkPageIsReady() {
		if (js.executeScript("return document.readyState").toString().equals("complete")) {
			return;
		}
		for (int i = 0; i < 25; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			if (js.executeScript("return document.readyState").toString().equals("complete"))
				break;
		}
	}

}
