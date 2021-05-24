Feature: Profile Page Validation 
@VerifyTweets @Desktop 
Scenario Outline: Validate the login flow for twitter Website 
	Given User navigates to Twitter.com website 
	When user gives "<username>" and "<password>" and click to signIn
	Then verify whether user navigated to twitter home page or not
	When user click on Explore Tab
	And Navigate to search tab and give the "<SearchText>"
	And fetch all the tweets that was updated before 2 Hrs
	And split the log tweets in to set of 50 Charactor
	 
	
	
Examples: 
		| Comment     	    | username            | password        | SearchText 	|
		| Login to Twitter  | Automat20126668 	  |Automation@123   | @timesofindia |
		
