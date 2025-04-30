
@regression
Feature: Checkout Flow
  I want to use this template for my feature file

 Scenario: Add to checkout
 When the user logins with standard credentials
 And adds the backpack to the cart
 And clicks on the cart button
 Then verify the cart url
 
 Scenario: Sort function
  When the user logins with standard credentials
  And sorts the items from lowest to highest
  Then we verify the lowest to highest

@smoke
 Scenario: Full Checkout
 When the user logins with standard credentials
 And adds the backpack to the cart
 And clicks on the cart button
 And clicks on the checkout button
 And fills out the checkout overview form
 And clicks on the finish button
 Then we verify with Thank you for your order!
 