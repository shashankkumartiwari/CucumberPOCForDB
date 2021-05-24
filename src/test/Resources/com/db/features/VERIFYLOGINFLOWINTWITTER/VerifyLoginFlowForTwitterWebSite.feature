Feature: VerifyLoginFlowForTwitterWebSite 

@Login @Desktop 
Scenario Outline: Validate the login flow for twitter Website 
	Given User navigates to Twitter.com website 
	When user gives "<username>" and "<password>" and click to signIn
	Then verify whether user navigated to twitter home page or not
	
Examples: 
		| Comment     	      | username            | password         | 
		| Login to Twitter    | Automat20126668  	|Automation@123    | 