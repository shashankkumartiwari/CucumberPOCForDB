package com.db.Pages.TwitterPage;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.db.common.BaseUtil;
import com.db.common.Utilities;

public class TweetsValidationPage extends BaseUtil {

	private BaseUtil base;
	Utilities utility;

	public TweetsValidationPage(WebDriver driver, BaseUtil base) {
		// TODO Auto-generated constructor stub

		PageFactory.initElements(driver, this);
		this.base = base;
		utility = new Utilities(driver);
	}

	// @FindBy(how = How.XPATH, using = "//div[@data-testid='tweet']/div/div[2]")
	@FindBy(how = How.XPATH, using = "//div[@lang='en']")
	private List<WebElement> tweets;

	@FindBy(how = How.XPATH, using = "//*[@data-testid='AppTabBar_Explore_Link']")
	private WebElement exploreTab;

	@FindBy(how = How.XPATH, using = "//*[@data-testid='SearchBox_Search_Input']")
	private WebElement searchBar;

	@FindBy(how = How.XPATH, using = "(//*[@data-testid='TypeaheadUser'])[1]")
	private WebElement firstSearchElement;

	@FindBy(how = How.XPATH, using = "//a[contains(@aria-label,'minutes ago') or contains(@aria-label, '1 hour ago') or contains(@aria-label, '2 hour ago')]")
	private List<WebElement> timeFramedetails;

	@FindBy(how = How.XPATH, using = "//*[contains(@aria-label, '2 hours ago')]")
	private WebElement twoHoursLimit;

	public void clickToExploreTab() throws InterruptedException {
		Thread.sleep(000);
		exploreTab.click();
		System.out.println("Clicked on Explored Tab  ");
	}

	public void clickToSearchBar(String SearchText) throws InterruptedException {
		base.Driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		searchBar.click();
		System.out.println("Clicked on Search Bar");
		searchBar.sendKeys(SearchText);
		base.Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(5000);
		base.Driver.findElement(By.xpath("//span[text()='Go to " + SearchText + "']")).click();
		;

		System.out.println("Clicked on first element that we have searched from search bar");
	}

	public void fetchTwoHrsTweets() throws InterruptedException {
		base.Driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		JavascriptExecutor je = (JavascriptExecutor) base.Driver;
		int CountOfTweetsTill2Hrs = timeFramedetails.size();
		System.out.println("CountOfTweetsTill2Hrs ==>" + CountOfTweetsTill2Hrs);
		System.out.println("==================================================================");
		for (WebElement TimeFrame : timeFramedetails) {
			try {
				if (TimeFrame.isDisplayed()) {
					for (WebElement tweetsUntill2Hrs : tweets) {
						try {
							je.executeScript("window.scrollBy(0,300)");
							System.out.println("Tweets are == > " + tweetsUntill2Hrs.getText());
							int TweetCharCount = tweetsUntill2Hrs.getText().length();
							System.out.println("TweetCharCount == >" + TweetCharCount);
							if (TweetCharCount > 50) {
								int lengthForIteration = TweetCharCount / 50;
								int maxcount = 50;
								int initialcount = 0;
								for (int i = 0; i < lengthForIteration; i++) {

									System.out.println("Tweet Part =>" + (i + 1) + "of the tweet======>"
											+ tweetsUntill2Hrs.getText().substring(initialcount, maxcount));
									initialcount = maxcount + 1;
									maxcount = maxcount + 50;

								}
							
							}
							System.out.println("==================================================================");
						} catch (Exception e) {
							je.executeScript("window.scrollBy(0,300)");
							System.out.println("Tweets are == > " + tweetsUntill2Hrs.getText());
							System.out.println("==================================================================");
						}
					}
				}
			} catch (Exception e) {
				System.out.println("We have fetched all the tweets within a 2 Hrs ");
			}
		}
	}
}
