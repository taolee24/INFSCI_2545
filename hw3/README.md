IS2545 - DELIVERABLE 3: Web Testing with BDD
==
e-commerce web testing

TaoLi(tal88)

Summary
=

In this project, I designed 3 user stories. Each story has 3 scenarios. Because different Firefox drivers and Firefox are not compatible, so I choose selenium-java-2.52.0.jar, selenium-server-standalone-2.52.0.jar and Firefox 46.0.1 to run the test.

I met some problems during the project. First, during the login test, I need to test different situations when users input incorrect username or password. But my IP address was blocked many times, so I have to send email to unlock again and again. The second problem is that the register page has some calculations to verify users who register and the calculations problem will change every time you refresh the page. So I do not know how to input the answer according to the changing calculations.

User stories and scenarios

User Story 1

As a user I have to register on the web site so that I can buy products

Scenario 1

Given I am in the register page, http://store.demoqa.com/tools-qa/?action=register
When I input a invalid email address taolee_@.com
Then I should get an error message “The email address isn’t correct”


Scenario 2

Given I am in the register page, http://store.demoqa.com/tools-qa/?action=register and I registered with username taolee and password 13818186731
When I input the taolee to register
Then I should get an error message “This username is already registered. Please chose another one.”

Scenario 3
Given I am in the register page, http://store.demoqa.com/tools-qa/?action=register
When I input a invalid username taolee*&^ and a correct email tal88@pitt.edu
Then I should get an error message “This username is invalid because it uses illegal characters. Please enter a valid username.” 


User Story 2

As a user, one of the most important things is to log in to the web site to buy products

Scenario 1

Given I am in the log in page, http://store.demoqa.com/tools-qa/ 
And I registered with username taolee and password 13818186731
When I input the correct username and password.
Then I can log in the web site.

Scenario 2

Given I am in the log in page, http://store.demoqa.com/tools-qa/ 
And I registered with username taolee and password 13818186731
When I input the correct username taolee and incorrect password 123
Then I should get an error message


Scenario 3
Given I am in the log in page, http://store.demoqa.com/tools-qa/ 
And I registered with username taolee and password 13818186731
When I input the incorrect usrname and password
Then I should get an error message


User Story 3

As a user, I need to get the product information through searching 

Scenario 1

Given I am in the homepage http://store.demoqa.com/
When I input “apple tv” and type “enter”
Then I should see there is only one product information in the search list


Scenario 2
Given I am in the homepage http://store.demoqa.com/
When I input “iphone” and type “enter”
Then I should see all the iphone products information in the search list


Scenario 3
Given I am in the homepage http://store.demoqa.com/
When I input “pineapple” pen and type “enter”
Then I should get a message “Sorry, but nothing matched your search criteria. Please try again with some different keywords.”


