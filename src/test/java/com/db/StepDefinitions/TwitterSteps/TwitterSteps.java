package com.db.StepDefinitions.TwitterSteps;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;

import com.db.Pages.TwitterPage.TwitterPage;
import com.db.common.BaseUtil;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TwitterSteps {

	JavascriptExecutor jse;
	private BaseUtil base;
	private TwitterPage page;

	public TwitterSteps(BaseUtil base) {
		this.base = base;
		page = new TwitterPage(base.Driver, base);
		jse = (JavascriptExecutor) base.Driver;
	}

	@Given("^User navigates to Twitter\\.com website$")
	public void user_navigates_to_Twitter_com_website() throws InterruptedException, IOException  {

		page.navigatetoTwitterHomePage();
	}

	
	@When("^user gives \"([^\"]*)\" and \"([^\"]*)\" and click to signIn$")
	public void user_gives_and_and_click_to_signIn(String UserName, String Password) throws InterruptedException  {
		page.logIn(UserName, Password);
	}

	
	
	@Then("^verify whether user navigated to twitter home page or not$")
	public void verify_whether_user_navigated_to_twitter_home_page_or_not()  {

		page.verifyTwitterHomePageTitle();
	}
}
