package Base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseClass {

    public static AppiumDriver driver;
    public static WebDriverWait wait;
    public static AppiumDriverLocalService service;
    public static Properties props;

    public void loadConfig() {
        props = new Properties();
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
            props.load(fis);
        } catch (IOException e) {
            System.out.println("❌ Failed to load config.properties");
            e.printStackTrace();
        }
    }

    public void startServer() {
        System.out.println("🔁 Starting Appium Server");

        service = new AppiumServiceBuilder()
                .withAppiumJS(new File(props.getProperty("appiumJSPath")))
                .withIPAddress(props.getProperty("ipAddress"))
                .usingPort(Integer.parseInt(props.getProperty("port")))
                .withTimeout(Duration.ofSeconds(60))
                .build();
        service.start();
    }

    public void initializeDriver() {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName(props.getProperty("platformName"));
        options.setDeviceName(props.getProperty("deviceName"));
        options.setAutomationName(props.getProperty("automationName"));
        options.setAppPackage(props.getProperty("appPackage"));
        options.setAppActivity(props.getProperty("appActivity"));
        options.setNoReset(Boolean.parseBoolean(props.getProperty("noReset")));

        driver = new AndroidDriver(service.getUrl(), options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        System.out.println("✅ Appium session started");
    }

    //wait for the app to load
    public void waitForAppToLoad() {
		try {
			Thread.sleep(5000); // Adjust the sleep time as needed
		} catch (InterruptedException e) {
			System.out.println("❌ Error while waiting for app to load");
			e.printStackTrace();
		}
	}
    
    //webdriver wait for elements to be visible
    public void waitForElementToBeVisible(WebElement element) {
		wait.until(driver -> element.isDisplayed());
	}
    
    public void tearDown() {
        if (driver != null) driver.quit();
        if (service != null) service.stop();
        System.out.println("🛑 Appium Server Stopped");
    }
}
