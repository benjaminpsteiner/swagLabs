
@smoke
Feature: Checkout Flow
  I want to use this template for my feature file

 Scenario: Add to checkout
 When the user logins with standard credentials
 And adds the backpack to the cart
 And clicks on the checkout button
 Then verify the cart url
 
 Scenario: Sort function
  When the user logins with standard credentials
  And sorts the items from lowest to highest
  Then we verify the lowest to highest

 
