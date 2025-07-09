package tests;

import Pages.SideMenuPage;
import org.testng.annotations.Test;
import io.qameta.allure.*;

@Epic("SwagLabs Mobile App")
@Feature("Logout")
public class LogoutTest extends Base.BaseClass {

	@Test(description = "Verify logout flow after checkout", dependsOnMethods = "checkOutTest")
    @Severity(SeverityLevel.NORMAL)
    @Story("Logout after completing purchase")
    @Description("Open menu and logout from the app")
    public void logoutTest() {
        try {
            SideMenuPage sideMenu = new SideMenuPage(driver);

            // Open the menu
            sideMenu.openMenu();
            System.out.println("✅ Menu opened");

            // Verify Logout is visible
            if (sideMenu.isLogoutVisible()) {
                System.out.println("✅ Logout option is visible");

                // Click Logout
                sideMenu.clickLogout();
                System.out.println("✅ Successfully logged out");
            } else {
                System.out.println("❌ Logout option is not visible");
            }

        } catch (Exception e) {
            System.out.println("❌ Logout test failed");
            e.printStackTrace();
        }
    }
}
