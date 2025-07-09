package tests;

import Pages.LoginPage;
import io.qameta.allure.*;
import org.testng.annotations.*;

@Epic("SwagLabs Mobile App")
@Feature("Login Feature")
public class LoginTest extends Base.BaseClass {

    @BeforeTest
    public void setup() {
        loadConfig();
        startServer();
        initializeDriver();
    }

    @Test(description = "Verify successful login with valid credentials")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Valid login flow")
    @Description("Test Description: Login into SwagLabs app using valid credentials")
    public void swaglabsLoginTest() {
        try {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.login(props.getProperty("username"), props.getProperty("password"));
            System.out.println("✅ Login test passed");
        } catch (Exception e) {
            System.out.println("❌ Login test failed");
            e.printStackTrace();
            throw e; // important for TestNG to mark test as failed
        }
    }

    @AfterTest
    public void tearDownAppium() {
        tearDown();
    }
}
