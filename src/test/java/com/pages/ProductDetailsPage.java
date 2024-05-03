package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.baseclass.BaseClass;

public class ProductDetailsPage {

    private WebDriver driver;

    @FindBy(xpath = "//span[@class='a-price aok-align-center reinventPricePriceToPayMargin priceToPay']//span[@aria-hidden='true']")
    private WebElement productPrice;

    @FindBy(xpath = "//*[@id=\"add-to-cart-button\"]")
    private WebElement addToCartButton;

    @FindBy(xpath = "//*[@id=\"nav-cart\"]")
    private WebElement shoppingCart;
    
    @FindBy(xpath = "//*[@id=\"sc-active-cart\"]/div/div[1]/div/h1")
    private WebElement confirmationText;

    public ProductDetailsPage() {
        this.driver = BaseClass.getDriver();
        PageFactory.initElements(driver, this);
    }

    public String storeProductPrice() {
        String price = productPrice.getText();
        return price;
    }
}