package Pages;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class LoginPage { 
	
	    AppiumDriver driver;

	     /**
	     * Constructor to initialize the Appium driver.
	     * 
	     * @param driver The Appium driver instance.
	     */
	    public LoginPage(AppiumDriver driver) {
	        this.driver = driver;
	    }

	    public WebElement getUsernameField() {
	        return driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Username\")"));
	    }

	    public WebElement getPasswordField() {
	        return driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Password\")"));
	    }

	    public WebElement getLoginButton() {
	        return driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"LOGIN\")"));
	    }

	    public void login(String username, String password) {
	        getUsernameField().click();
	        getUsernameField().sendKeys(username);
	        getPasswordField().click();
	        getPasswordField().sendKeys(password);
	        getLoginButton().click();
	    }
	}


