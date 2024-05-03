Feature: Amazon.in iPhone Purchase Flow

	Scenario Outline: Search for iPhone, select, view product details, and store price.

    Given User is on the Amazon.in homepage
    When User searches for "<phone>"
    And User selects an iPhone from the search results
    And User stores the price of the selected iPhone in a variable
    
    Examples: 
    |phone|
		|iphone 11|
		|iphone 13|
		|iphone 15|

