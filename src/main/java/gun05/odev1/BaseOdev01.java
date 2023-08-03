package gun05.odev1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import utils.Driver;

import java.time.Duration;

public class BaseOdev01 {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeTest
    public void setup() {
        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void sendKeys(By locator, String text) {
        waitUntilVisible(locator);
        WebElement element = driver.findElement(locator);
        sendKeys(element, text);

    }

    public void sendKeys(WebElement element, String text) {
        element.sendKeys(text);
    }

    public void click(By locator) {
        click(waitUntilClickable(locator));
    }

    public void click(WebElement element) {
        element.click();
    }

    public WebElement waitUntilVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitUntilClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

}
