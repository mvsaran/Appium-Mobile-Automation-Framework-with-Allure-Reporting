package Pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {
    private AppiumDriver driver;
    private WebDriverWait wait;

    public ProductPage(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isProductsTextDisplayed() {
        return driver.findElement(AppiumBy.xpath("//*[@text='PRODUCTS']")).isDisplayed();
    }

    public void selectProduct(String productName) {
        WebElement product = driver.findElement(AppiumBy.xpath("//*[@content-desc='test-Item title' and @text='" + productName + "']"));
        product.click();
    }

    public void waitForAddToCartAndClick() {
        WebElement addToCartBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("(//*[@text='ADD TO CART'])[1]")));
        addToCartBtn.click();
    }
    
    public void clickCartIcon() {
        WebElement cartBtn = wait.until(ExpectedConditions.elementToBeClickable(
        		AppiumBy.xpath("(//*[@text='1'])")));
        cartBtn.click();
    }
    // Locator for "Sauce Labs Backpack" in cart
    private String addedProductXPath = "//*[@text='Sauce Labs Backpack']";

    public boolean isSauceLabsBackpackInCart() {
        try {
            WebElement product = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    AppiumBy.xpath(addedProductXPath)
            ));
            return product.isDisplayed();
        } catch (Exception e) {
            System.out.println("❌ 'Sauce Labs Backpack' not found in cart.");
            return false;
        }
    }
        //Check Out
        public void clickCheckoutButton() {
        				WebElement checkoutButton = wait.until(ExpectedConditions.elementToBeClickable(
					AppiumBy.xpath("//*[@text='CHECKOUT']")));
			checkoutButton.click();		
        }
    
//    public void scrollToAddToCart() {
//        driver.findElement(AppiumBy.androidUIAutomator(
//            "new UiScrollable(new UiSelector().scrollable(true))" +
//            ".scrollIntoView(new UiSelector().text(\"ADD TO CART\"))"
//        ));
//            }
//  
    
    // Optional: handle multiple 'Add to Cart' buttons if needed
//    public void clickAllAddToCartButtons() {
//        for (WebElement button : driver.findElements(AppiumBy.xpath("//*[@text='ADD TO CART']"))) {
//            wait.until(ExpectedConditions.visibilityOf(button)).click();
//        }
//    }
}
