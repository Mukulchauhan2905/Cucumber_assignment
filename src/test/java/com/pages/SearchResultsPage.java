package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.baseclass.BaseClass;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class SearchResultsPage {

    WebDriver driver;

    @FindBy(xpath = "(//span[@class= 'a-size-medium a-color-base a-text-normal'])[3]")
    private WebElement firstProduct;

    @FindBy(xpath = "//span[contains(@class, 'a-size-base-plus')]")
    private List<WebElement> searchResults;

    @FindBy(xpath = "//span[contains(@class, 'a-size-base') and contains(text(), 'Samsung')]")
    private WebElement brandFilter;

    @FindBy(xpath = "//section[@aria-label='4 Stars & Up']")
    private WebElement customerReviewFilter;

    @FindBy(xpath = "//span[contains(@class, 'a-icon-alt') and number(translate(text(), ' out of 5 stars', '')) >= 4.0]")
    private WebElement ratingElement;

    public SearchResultsPage() {
        this.driver = BaseClass.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void selectProduct() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(firstProduct));

        firstProduct.click();
        handleNewTab();
    }

    private void handleNewTab() {
        String mainWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();

        if (allWindowHandles.size() > 1) {
            for (String windowHandle : allWindowHandles) {
                if (!windowHandle.equals(mainWindowHandle)) {
                    driver.switchTo().window(windowHandle);
                    break;
                }
            }
        }
    }

    public List<WebElement> getSearchResults() {
        return searchResults;
    }

    public void applyBrandFilter() {
        brandFilter.click();
    }

    public void applyCustomerReviewFilter() {
        customerReviewFilter.click();
    }

    public void applyFilters() {
        applyBrandFilter();
        applyCustomerReviewFilter();
    }
}