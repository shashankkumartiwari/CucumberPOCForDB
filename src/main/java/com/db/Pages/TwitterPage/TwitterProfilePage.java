package com.db.Pages.TwitterPage;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
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

public class TwitterProfilePage extends BaseUtil {

	private BaseUtil base;
	Utilities utility;

	public TwitterProfilePage(WebDriver driver, BaseUtil base) {
		PageFactory.initElements(driver, this);
		this.base = base;
		utility = new Utilities(driver);
	}

	@FindBy(how = How.XPATH, using = "//span[text()='Profile']")
	public WebElement menuProfile;

	@FindBy(how = How.XPATH, using = "//span[text()='Edit profile']")
	public WebElement editProfile;

	@FindBy(how = How.XPATH, using = "//div[@aria-label='Add avatar photo']")
	public WebElement editProfilePhoto;

	@FindBy(how = How.XPATH, using = "//span[text()='Apply']")
	public WebElement btnApply;

	@FindBy(how = How.XPATH, using = "//span[text()='Save']")
	public WebElement btnSave;

	@FindBy(how = How.XPATH, using = "//textarea[@name='description']")
	public WebElement textBio;

	@FindBy(how = How.XPATH, using = "//input[@name='location']")
	public WebElement textLocation;

	@FindBy(how = How.XPATH, using = "//input[@name='url']")
	public WebElement textWebsite;

	@FindBy(how = How.XPATH, using = "//div[@data-testid='UserDescription']")
	public WebElement userDescription;

	@FindBy(how = How.XPATH, using = "(//span[@dir='ltr'])[1]")
	public WebElement userlocation;

	@FindBy(how = How.XPATH, using = "(//a[@dir='ltr'])[1]")
	public WebElement userWebsite;

	public void clickonProfileMenu() {
		menuProfile.click();
	}

	public void clickonEditProfile() {

		utility.waitForElementVisibility(menuProfile);
		clickonProfileMenu();
		System.out.println("Clicked on Profile Menu");
		utility.waitForElementVisibility(editProfile);
		editProfile.click();
		System.out.println("Clicked on Edit Profile");

	}

	public void uploadProfilePic() throws AWTException, InterruptedException {

		clickonEditProfile();
		utility.waitForElementVisibility(editProfilePhoto);
		String parent = base.Driver.getWindowHandle(); // It will return the parent window name as a String
		Set<String> s = base.Driver.getWindowHandles();
		// open upload window
		editProfilePhoto.click();
		try {
			Runtime.getRuntime().exec(
					"C:\\Users\\shashank.k.tiwari\\Desktop\\Tech Talk Demo\\ShashankTiwariAutomationArchitect\\Assignment Deutsche Bank\\TestFiles\\UploadUtility.exe");
		} catch (IOException e) {
			System.out.println("AutoIt Utility is not working ");
			e.printStackTrace();
		}
		base.Driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		btnApply.click();
		System.out.println("Updating the profile Pic ");
		btnSave.click();

	}

	public void updateBIOField(String bio) {

		clickonEditProfile();
		utility.waitForElementVisibility(textBio);
		textBio.clear();
		textBio.sendKeys(bio);
		System.out.println("Updated BIO Details as a == >" + bio);
		btnSave.click();

	}

	public void updateTheLocation(String location) {

		clickonEditProfile();
		utility.waitForElementVisibility(textLocation);
		textLocation.clear();
		textLocation.sendKeys(location);
		System.out.println("Updated BIO Details as a == >" + location);
		btnSave.click();

	}

	public void updateTheWebSite(String webSite) {

		clickonEditProfile();
		utility.waitForElementVisibility(textWebsite);
		textWebsite.clear();
		textWebsite.sendKeys(webSite);
		System.out.println("Updated BIO Details as a == >" + webSite);
		btnSave.click();

	}

	public void verifyTheProfilePageupdation(String bio, String location, String website) {

		String ActualBio = userDescription.getText();
		String ActualWebsite = userWebsite.getText();
		String ActualUserLocation = userlocation.getText();

		if (ActualBio.equalsIgnoreCase(bio) && (ActualWebsite.equalsIgnoreCase(website))
				&& (ActualUserLocation.equalsIgnoreCase(location))) {
			System.out.println("bio details==>" + ActualBio + ", the website details ==>" + ActualWebsite
					+ " And the User location ==> " + ActualUserLocation + " are the expected one ");
		} else {
			Assert.fail("bio details==>" + ActualBio + ", the website details ==>" + ActualWebsite
					+ " And the User location ==> " + ActualUserLocation + " are NOT the expected one ");
		}
	}

}
