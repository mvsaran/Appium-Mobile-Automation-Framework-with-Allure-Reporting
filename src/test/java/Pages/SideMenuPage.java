package Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SideMenuPage {

    private AppiumDriver driver;

    public SideMenuPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//*[@content-desc='test-Menu']")
    private WebElement menuButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='LOGOUT']")
    private WebElement logoutOption;

    public void openMenu() {
        menuButton.click();
    }

    public boolean isLogoutVisible() {
        try {
            return logoutOption.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickLogout() {
        logoutOption.click();
    }
}
