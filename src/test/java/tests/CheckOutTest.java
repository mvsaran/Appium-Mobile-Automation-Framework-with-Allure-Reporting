package tests;
import org.testng.annotations.Test;
import Pages.CheckOutPage;
import Pages.ProductPage;
import io.qameta.allure.*;
import org.testng.annotations.Test;

@Epic("SwagLabs Mobile App")
@Feature("Checkout")
public class CheckOutTest extends Base.BaseClass {

		@Test(description = "Verify checkout with valid information", dependsOnMethods = "productPageTest")
	    @Severity(SeverityLevel.BLOCKER)
	    @Story("Complete checkout after adding item to cart")
	    @Description("Ensure user can input details and complete checkout successfully")
	public void checkOutTest() {
		try {
			CheckOutPage checkOutPage = new CheckOutPage(driver);

			// Enter First Name
			checkOutPage.enterFirstName("John");
			System.out.println("✅ Entered First Name");

			// Enter Last Name
			checkOutPage.enterLastName("Doe");
			System.out.println("✅ Entered Last Name");
            //wait for the page to load before entering postal code
			Thread.sleep(2000); // Adjust the sleep time as necessary
			// Enter Postal Code
			checkOutPage.enterPostalCode("12345");
			System.out.println("✅ Entered Postal Code");

			// Click Continue Button
			checkOutPage.clickContinueButton();
			System.out.println("✅ Clicked 'CONTINUE' button");
			
						
			//Finish the Checkout
					    // Click Finish Button
		   	checkOutPage.swipeUpUntilFinishVisible();
			System.out.println("✅ Clicked 'FINISH' button");
			// Verify Checkout Completion
			if (checkOutPage.isCheckoutComplete()) {
				System.out.println("✅ Checkout completed successfully");
			} else {
				System.out.println("❌ Checkout not completed");
			}

		} catch (Exception e) {
			System.out.println("❌ Checkout test failed");
			e.printStackTrace();
		}
	}

}
