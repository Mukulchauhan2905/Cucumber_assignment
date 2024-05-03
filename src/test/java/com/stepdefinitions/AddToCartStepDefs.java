package com.stepdefinitions;

import org.junit.Assert;

import com.pages.AddToCartPage;
import com.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddToCartStepDefs {

    HomePage homepage = new HomePage();
    AddToCartPage addToCartPage = new AddToCartPage();
    
    @When("User clicks on Amazon gift ideas page")
    public void user_clicks_on_amazon_gift_ideas_page() {
        addToCartPage.amazonGiftIdeasButton();;
    }

    @Then("User navigates to Amazon gift ideas")
    public void user_navigates_to_amazon_gift_ideas() {
        Assert.assertTrue(addToCartPage.isUserDirectedToAmazonGiftIdeas());
    }


    @And("User click on add to cart")
    public void user_click_on_add_to_cart() {
        addToCartPage.addProductToCart();
    }

    @Then("User navigated to Amazon shopping cart")
    public void user_navigated_to_amazon_shopping_cart() {
    	addToCartPage.amazonShoppingCart();
    }
}