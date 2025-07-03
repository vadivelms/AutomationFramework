Feature: SauceDemo E2E Add to Cart and Checkout
  As a SauceDemo user
  I want to add the first item to the cart and complete the checkout process
  So that I can validate the end-to-end purchase flow

  Scenario: Add first item to cart and complete checkout
    Given user is on the SauceDemo login page
    When user logs in with username "standard_user" and password "secret_sauce"
    And user is on the inventory page
    And user adds the first item to the cart and captures its name
    And user navigates to the cart page
    Then the captured item should be present in the cart
    When user proceeds to checkout
    And user enters valid checkout information
    And user completes the purchase
    Then the order should be completed successfully
