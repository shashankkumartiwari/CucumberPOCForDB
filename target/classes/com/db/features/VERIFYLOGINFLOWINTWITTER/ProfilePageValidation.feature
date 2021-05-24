Feature: Profile Page Validation 
@ProfilePage @Desktop 
Scenario Outline: Validate of user profile page in twitter Website 
	Given User navigates to Twitter.com website 
	When user gives "<username>" and "<password>" and click to signIn
	Then verify whether user navigated to twitter home page or not
	When User navigates profile page of logged user and upload a profile picture
	And User Updates BIO field in profile section as "<BIO Desc>"
	And update "<location>" on the Twitter profile page
	And update WebSite site fild as "<WebSiteField>"
	Then Verify BIO field "<BIO Desc>",location "<location>" and website "<WebSiteField>" on the profile page.
	
Examples: 
		| Comment     	    | username            | password        | BIO Desc 					| location		| WebSiteField|
		| Login to Twitter  | Automat20126668 	  |Automation@123   | Selenium Automation user	| Pune ( India) | twitter.com |
		
