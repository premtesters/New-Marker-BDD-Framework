##Scenario 6
 Feature: Home page functionality
 Scenario: Verify item count after adding and removing items
    When I add "5" items to the cart
    And I remove "2" items from the cart
    Then the cart should contain "3" items
    
#Scenario 7
Scenario: move to checkout and remove item
When Navigate to checkout
Then Remove items in checkout

#Scenario 8
Scenario: checkout items selected
When click on checkout button
And Enter firstname, lastname and zipcode
And Click on Continue button
And Click finish button
Then a message should appear as "Thank you for your order!"