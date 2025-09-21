Feature: Login fuctionality 
Scenario: verify element present in login page
Given Open login page
Then check title of the page
Then check placeholder message for username field
Then check placeholder message for password field
Then check login button in the login page

Scenario: Verify user is able to enter only the username
When the user enters only the username
And leaves the password field empty
And clicks the Login button
Then a message "Epic sadface: Password is required" should appear

#Scenario 3
#Scenario: Verify user is able to enter only the password
#When the user enters only the password
#And leaves the username field empty
#And clicks the Login button
#Then A message "Epic sadface: Username is required" should appear

##Scenario 4
Scenario: Verify username and password do not match
When enter valid username 
And enter invalid password
Then a message should be "Epic sadface: Username and password do not match any user in this service"

##Scenario 5
Scenario: Verify user able to log into valid credentials
When enter valid username
When enter valid password
And clicks the Login button
Then user able to log into application

