package com.db.Pages.TwitterPage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.db.common.BaseUtil;
import com.db.common.Utilities;

public class TwitterPage extends BaseUtil {

	private BaseUtil base;
	Utilities utility;
	WebDriverWait w;

	public TwitterPage(WebDriver driver, BaseUtil base) {
		PageFactory.initElements(driver, this);
		this.base = base;
		utility = new Utilities(driver);
	}

	@FindBy(how = How.XPATH, using = "//span[text()='Log in']")
	public WebElement btnLogIn;

	@FindBy(how = How.XPATH, using = "(//input[@name='session[username_or_email]'])[1]")
	public WebElement signInuserName;

	@FindBy(how = How.XPATH, using = "(//input[@name='session[password]'])[1]")
	public WebElement signInPassword;

	@FindBy(how = How.XPATH, using = "//span[text()='Home']")
	public WebElement iconHome;

	public void navigatetoTwitterHomePage() throws InterruptedException, IOException {

		try {
			String URL = BaseUtil.getTheEnvURL();
			base.Driver.navigate().to(URL);
			if (base.executionMode.equalsIgnoreCase("Android Mobile")) {
				Thread.sleep(10000);

			}
		} catch (Exception e) {
			System.out.println("Catch Block : We are not able to navigated to the given URL ");
			e.printStackTrace();

		}

	}

	/**
	 * Login to the Twitter Application using the userName, password and email
	 * address provided
	 * 
	 * @param UserName User Name
	 * @param Password Password
	 * @throws InterruptedException
	 */
	public void logIn(String UserName, String Password) {

		try {
			utility.isElementDisplayed(btnLogIn);
			Thread.sleep(5000);
			// utility.checkPageIsReady();
			btnLogIn.click();
			signInuserName.clear();
			signInuserName.sendKeys(UserName);
			System.out.println("UserName has been given");
			signInPassword.clear();
			signInPassword.sendKeys(Password);
			System.out.println("Password has been given");
			btnLogIn.click();
			System.out.println("Clicked on login button ");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void verifyTwitterHomePageTitle() {

		WebDriverWait wait = new WebDriverWait(base.Driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(iconHome));
		String TitleOfPage = base.Driver.getTitle();
		if (TitleOfPage.contains("Home / Twitter")) {
			System.out.println("TitleOfPage==>" + TitleOfPage);
		} else {
			System.out.println("TitleOfPage==>" + TitleOfPage);
			Assert.fail("Titles of the website do not match");
		}
	}
}
