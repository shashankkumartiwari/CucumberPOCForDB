package com.db.StepDefinitions.TwitterSteps;

import java.awt.AWTException;

import org.openqa.selenium.JavascriptExecutor;

import com.db.Pages.TwitterPage.TweetsValidationPage;
import com.db.Pages.TwitterPage.TwitterProfilePage;
import com.db.common.BaseUtil;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TweetsValidationSteps {

	JavascriptExecutor jse;
	private BaseUtil base;
	private TweetsValidationPage page;

	public TweetsValidationSteps(BaseUtil base) {
		this.base = base;
		page = new TweetsValidationPage(base.Driver, base);
		jse = (JavascriptExecutor) base.Driver;
	}

	@When("^user click on Explore Tab$")
	public void user_click_on_Explore_Tab() throws Throwable {
		page.clickToExploreTab();
	}

	@When("^Navigate to search tab and give the \"([^\"]*)\"$")
	public void navigate_to_search_tab_and_give_the(String SearchText) throws Throwable {
		page.clickToSearchBar(SearchText);
	}

	@When("^fetch all the tweets that was updated before (\\d+) Hrs$")
	public void fetch_all_the_tweets_that_was_updated_before_Hrs(int arg1) throws Throwable {
		page.fetchTwoHrsTweets();
	}

	@When("^split the log tweets in to set of (\\d+) Charactor$")
	public void split_the_log_tweets_in_to_set_of_Charactor(int arg1) throws Throwable {

	}

}
