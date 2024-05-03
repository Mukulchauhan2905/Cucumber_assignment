package com.stepdefinitions;

import com.pages.HomePage;
import com.pages.ProductDetailsPage;
import com.pages.SearchResultsPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PurchaseFlowStepDef {

    HomePage homepage = new HomePage();
    SearchResultsPage searchResultsPage = new SearchResultsPage();
    ProductDetailsPage productDetailsPage = new ProductDetailsPage();
    String productPrice;

    @Given("User is on the Amazon.in homepage")
    public void user_is_on_the_amazon_homepage() {
        homepage.openHomePage("https://www.amazon.in/");
    }

    @When("User searches for {string}")
    public void user_searches_for_iphone(String phone) {
        homepage.searchProduct(phone);
    }

    @And("User selects an iPhone from the search results")
    public void user_selects_an_iPhone_from_the_search_results() {
        searchResultsPage.selectProduct();
    }

    @Then("User stores the price of the selected iPhone in a variable")
    public void user_stores_the_price_of_the_selected_iPhone_in_a_variable() {
        productPrice = productDetailsPage.storeProductPrice();
        System.out.println("Product Price: " + productPrice);
    }

}