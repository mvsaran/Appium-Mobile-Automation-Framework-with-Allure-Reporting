package Pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Collections;

public class CheckOutPage {

    private AppiumDriver driver;
    private WebDriverWait wait;

    public CheckOutPage(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterFirstName(String firstName) {
        WebElement firstNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(
            AppiumBy.xpath("//*[@text='First Name']")));
        firstNameField.sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        WebElement lastNameField = wait.until(ExpectedConditions.visibilityOfElementLocated(
            AppiumBy.xpath("//*[@text='Last Name']")));
        lastNameField.sendKeys(lastName);
    }

    public void enterPostalCode(String postalCode) {
        WebElement postalCodeField = wait.until(ExpectedConditions.visibilityOfElementLocated(
            AppiumBy.xpath("//*[@content-desc=\"test-Zip/Postal Code\"]")));
        postalCodeField.sendKeys(postalCode);
    }

    public void clickContinueButton() {
        WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(
            AppiumBy.xpath("//*[@text='CONTINUE']")));
        continueButton.click();
    }

    public void swipeUpUntilFinishVisible() {
        int maxSwipes = 5;
        int swipes = 0;

        while (swipes < maxSwipes) {
            try {
                WebElement finish = driver.findElement(AppiumBy.accessibilityId("test-FINISH"));
                if (finish.isDisplayed()) {
                    wait.until(ExpectedConditions.elementToBeClickable(finish)).click();
                    System.out.println("✅ Clicked on FINISH button after swiping.");
                    return;
                }
            } catch (Exception e) {
                swipeUp();
                swipes++;
            }
        }

        System.out.println("❌ FINISH button not found after " + maxSwipes + " swipes.");
    }

    private void swipeUp() {
        int height = driver.manage().window().getSize().height;
        int width = driver.manage().window().getSize().width;

        int startX = width / 2;
        int startY = (int) (height * 0.8);
        int endY = (int) (height * 0.3);

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);

        swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(700), PointerInput.Origin.viewport(), startX, endY));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(swipe));
    }

    public boolean isCheckoutComplete() {
        try {
            WebElement checkoutCompleteText = wait.until(ExpectedConditions.visibilityOfElementLocated(
                AppiumBy.xpath("//*[@text=\"THANK YOU FOR YOU ORDER\"]")));
            return checkoutCompleteText.isDisplayed();
        } catch (Exception e) {
            System.out.println("❌ Checkout not complete");
            return false;
        }
    }
}
