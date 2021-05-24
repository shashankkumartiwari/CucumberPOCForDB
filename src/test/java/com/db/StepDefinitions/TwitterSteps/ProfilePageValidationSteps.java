package com.db.StepDefinitions.TwitterSteps;

import java.awt.AWTException;

import org.openqa.selenium.JavascriptExecutor;

import com.db.Pages.TwitterPage.TwitterProfilePage;
import com.db.common.BaseUtil;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ProfilePageValidationSteps {

	JavascriptExecutor jse;
	private BaseUtil base;
	private TwitterProfilePage page;

	public ProfilePageValidationSteps(BaseUtil base) {
		this.base = base;
		page = new TwitterProfilePage(base.Driver, base);
		jse = (JavascriptExecutor) base.Driver;
	}
	
	@When("^User navigates profile page of logged user and upload a profile picture$")
	public void user_navigates_profile_page_of_logged_user_and_upload_a_profile_picture() throws AWTException, InterruptedException {

		page.uploadProfilePic();
		
		}

	@When("^User Updates BIO field in profile section as \"([^\"]*)\"$")
	public void user_Updates_BIO_field_in_profile_section_as(String bio)  {
	   
		page.updateBIOField(bio);
	}

	@When("^update \"([^\"]*)\" on the Twitter profile page$")
	public void update_on_the_Twitter_profile_page(String location) {
	  
		page.updateTheLocation(location);
	}

	@When("^update WebSite site fild as \"([^\"]*)\"$")
	public void update_WebSite_site_fild_as(String WebSite)  {
	 
		page.updateTheWebSite(WebSite);
	}

	@Then("^Verify BIO field \"([^\"]*)\",location \"([^\"]*)\" and website \"([^\"]*)\" on the profile page\\.$")
	public void verify_BIO_field_location_and_website_on_the_profile_page(String bio, String location, String website)  {
	   
		page.verifyTheProfilePageupdation(bio, location, website);
		
		
	}
	
	
	
}
