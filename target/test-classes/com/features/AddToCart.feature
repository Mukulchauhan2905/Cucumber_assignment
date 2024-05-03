Feature: Amazon Gift ideas and AddToCart

	Background:
		Given User is on the Amazon.in homepage
	
	@regression	
  Scenario: User navigating to Amazon gift page
    When User clicks on Amazon gift ideas page
    Then User navigates to Amazon gift ideas
  
  @regression  
  Scenario: Adding Item to Amazon Cart Page
  	When User searches for "Iphone 15"
    And User click on add to cart
    Then User navigated to Amazon shopping cart