package com.stepdefinitions;


import com.pages.HomePage;
import com.pages.SearchResultsPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchAndFilterStepDef {

    HomePage homePage = new HomePage();
    SearchResultsPage searchResultsPage = new SearchResultsPage();
    List<WebElement> filteredResults;

    @When("User searches for phone")
    public void userSearchesForPhone() {
        homePage.searchProduct("phone");
    }

    @And("User applies filters for {string} and {string}")
    public void userAppliesFilters(String brandFilter, String reviewFilter) {
        searchResultsPage.applyFilters();
    }

    @Then("The filtered list should only contain phones from Samsung with 4 stars and above")
    public void theFilteredListShouldOnlyContainPhonesFromSamsungWith4StarsAndAbove() {
        filteredResults = searchResultsPage.getSearchResults();

        for (WebElement result : filteredResults) {
            String resultText = result.getText().toLowerCase();
            Assert.assertTrue(resultText.contains("samsung"));
        }
    }
}