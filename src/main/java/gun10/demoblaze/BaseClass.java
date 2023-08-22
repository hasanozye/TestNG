package gun10.demoblaze;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

/**
 * BaseClass provides basic functionality and common methods for test classes in the Demoblaze project.
 */
public class BaseClass {

    String url = "https://demoblaze.com/";

    protected WebDriver driver;
    protected WebDriverWait wait;

    /**
     * Initializes the WebDriver instance before each test.
     */
    @BeforeTest
    public void beforeTest(){
        DriverConfig.startmaximized = true;
        driver = DriverDemo.getDriver();
    }

    /**
     * Quits the WebDriver instance after each test.
     */
    @AfterTest
    public void tearDown() {
        if (driver != null) {
            DriverDemo.getDriver().quit();
        }
    }


    /**
     * Clicks on a WebElement after ensuring it is visible.
     *
     * @param element The WebElement to be clicked.
     */
    public void click(WebElement element) {
        waitUntilVisible(element).click();
    }


    /**
     * Enters text into a WebElement after ensuring it is clickable and clearing its contents.
     *
     * @param element The WebElement to which text will be entered.
     * @param text The text to be entered into the element.
     */
    public void sendKeys(WebElement element, String text) {
        WebElement element1 = waitUntilClickable(element);
        element1.clear();
        element1.sendKeys(text);
    }


    /**
     * Waits until a WebElement is visible on the page.
     *
     * @param element The WebElement to wait for.
     * @return The WebElement that became visible.
     */
    public WebElement waitUntilVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }


    /**
     * Waits until a WebElement is clickable on the page.
     *
     * @param element The WebElement to wait for.
     * @return The WebElement that became clickable.
     */
    public WebElement waitUntilClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Waits until an alert is present and accepts it.
     */
    public void waitUntilAlertAccept(){
        wait.until(ExpectedConditions.alertIsPresent())
                .accept();
    }
}
