package tests;
import Pages.ProductPage;
import io.qameta.allure.*;
import Pages.ProductPage;
import org.testng.annotations.Test;

@Epic("SwagLabs Mobile App")
@Feature("Product Page")
public class ProductTest extends Base.BaseClass {
	 	
		@Test(description = "Verify adding a product to cart", dependsOnMethods = "swaglabsLoginTest")
	    @Severity(SeverityLevel.CRITICAL)
	    @Story("Add Sauce Labs Backpack to cart")
	    @Description("Verify user can add 'Sauce Labs Backpack' to cart and proceed to checkout")
    
    public void productPageTest() {
        try {
            ProductPage productPage = new ProductPage(driver);

            // Verify PRODUCTS screen
            assert productPage.isProductsTextDisplayed() : "❌ PRODUCTS text not displayed";
            System.out.println("✅ PRODUCTS screen is displayed");

            // Select "Sauce Labs Backpack"
            // Add to Cart
            productPage.waitForAddToCartAndClick();
            System.out.println("✅ Clicked 'ADD TO CART'");

            productPage.clickCartIcon();
            System.out.println("🛒 Opened Cart");
         // Go to Cart
            productPage.isSauceLabsBackpackInCart();
            System.out.println("✅ 'Sauce Labs Backpack' is in the cart");
            
           // Click Checkout Button
			productPage.clickCheckoutButton();
			System.out.println("✅ Clicked 'CHECKOUT' button");

			// Additional assertions can be added here to verify the checkout process
            

        } catch (Exception e) {
            System.out.println("❌ Product test failed");
            e.printStackTrace();
        }
    }
}
