$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("VERIFYLOGINFLOWINTWITTER/VerifyTweets.feature");
formatter.feature({
  "line": 1,
  "name": "Profile Page Validation",
  "description": "",
  "id": "profile-page-validation",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 3,
  "name": "Validate the login flow for twitter Website",
  "description": "",
  "id": "profile-page-validation;validate-the-login-flow-for-twitter-website",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 2,
      "name": "@VerifyTweets"
    },
    {
      "line": 2,
      "name": "@Desktop"
    }
  ]
});
formatter.step({
  "line": 4,
  "name": "User navigates to Twitter.com website",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "user gives \"\u003cusername\u003e\" and \"\u003cpassword\u003e\" and click to signIn",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "verify whether user navigated to twitter home page or not",
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "user click on Explore Tab",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "Navigate to search tab and give the \"\u003cSearchText\u003e\"",
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "fetch all the tweets that was updated before 2 Hrs",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "split the log tweets in to set of 50 Charactor",
  "keyword": "And "
});
formatter.examples({
  "line": 14,
  "name": "",
  "description": "",
  "id": "profile-page-validation;validate-the-login-flow-for-twitter-website;",
  "rows": [
    {
      "cells": [
        "Comment",
        "username",
        "password",
        "SearchText"
      ],
      "line": 15,
      "id": "profile-page-validation;validate-the-login-flow-for-twitter-website;;1"
    },
    {
      "cells": [
        "Login to Twitter",
        "Automat20126668",
        "Automation@123",
        "@timesofindia"
      ],
      "line": 16,
      "id": "profile-page-validation;validate-the-login-flow-for-twitter-website;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 5635222300,
  "status": "passed"
});
formatter.scenario({
  "line": 16,
  "name": "Validate the login flow for twitter Website",
  "description": "",
  "id": "profile-page-validation;validate-the-login-flow-for-twitter-website;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 2,
      "name": "@VerifyTweets"
    },
    {
      "line": 2,
      "name": "@Desktop"
    }
  ]
});
formatter.step({
  "line": 4,
  "name": "User navigates to Twitter.com website",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "user gives \"Automat20126668\" and \"Automation@123\" and click to signIn",
  "matchedColumns": [
    1,
    2
  ],
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "verify whether user navigated to twitter home page or not",
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "user click on Explore Tab",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "Navigate to search tab and give the \"@timesofindia\"",
  "matchedColumns": [
    3
  ],
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "fetch all the tweets that was updated before 2 Hrs",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "split the log tweets in to set of 50 Charactor",
  "keyword": "And "
});
formatter.match({
  "location": "TwitterSteps.user_navigates_to_Twitter_com_website()"
});
formatter.result({
  "duration": 20454877200,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Automat20126668",
      "offset": 12
    },
    {
      "val": "Automation@123",
      "offset": 34
    }
  ],
  "location": "TwitterSteps.user_gives_and_and_click_to_signIn(String,String)"
});
formatter.result({
  "duration": 7639588400,
  "status": "passed"
});
formatter.match({
  "location": "TwitterSteps.verify_whether_user_navigated_to_twitter_home_page_or_not()"
});
formatter.result({
  "duration": 913315900,
  "status": "passed"
});
formatter.match({
  "location": "TweetsValidationSteps.user_click_on_Explore_Tab()"
});
formatter.result({
  "duration": 424357400,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "@timesofindia",
      "offset": 37
    }
  ],
  "location": "TweetsValidationSteps.navigate_to_search_tab_and_give_the(String)"
});
formatter.result({
  "duration": 5981312100,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "2",
      "offset": 45
    }
  ],
  "location": "TweetsValidationSteps.fetch_all_the_tweets_that_was_updated_before_Hrs(int)"
});
formatter.result({
  "duration": 9263925000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "50",
      "offset": 34
    }
  ],
  "location": "TweetsValidationSteps.split_the_log_tweets_in_to_set_of_Charactor(int)"
});
formatter.result({
  "duration": 137700,
  "status": "passed"
});
formatter.embedding("image/png", "embedded0.png");
formatter.after({
  "duration": 933060200,
  "status": "passed"
});
});