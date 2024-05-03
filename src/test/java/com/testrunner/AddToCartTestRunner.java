package com.testrunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/com/features/AddToCart.feature",
        glue = {"com.stepdefinitions" , "com.hooks"},
		plugin = {"pretty", "html:target/results.html"},
		tags = "@regression"
)
public class AddToCartTestRunner {
}