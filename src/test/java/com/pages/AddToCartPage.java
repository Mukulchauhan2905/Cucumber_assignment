package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.baseclass.BaseClass;

import java.time.Duration;

public class AddToCartPage {

    private WebDriver driver;

    @FindBy(xpath = "//span[@class='a-price aok-align-center reinventPricePriceToPayMargin priceToPay']//span[@aria-hidden='true']")
    private WebElement productPrice;

    @FindBy(xpath = "//*[@id=\"a-autoid-1-announce\"]")
    private WebElement addToCartButton;

    @FindBy(xpath = "//*[@id=\"nav-cart\"]")
    private WebElement shoppingCart;
    
    @FindBy(xpath = "//*[@id=\"nav-xshop\"]/a[14]")
    private WebElement giftIdeasButton;
    
    @FindBy(xpath = "//*[@id=\"reactApp\"]/div/div/div[1]/h1")
    private WebElement confirmationText;

    public void amazonGiftIdeasButton() {
    	giftIdeasButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(confirmationText));
    }

    public boolean isUserDirectedToAmazonGiftIdeas() {
        return confirmationText.getText().contains("Find the perfect gift");
    }

    public AddToCartPage() {
        this.driver = BaseClass.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void addProductToCart() {
        addToCartButton.click();
    }

    public void amazonShoppingCart() {
    	shoppingCart.click();
    }
}