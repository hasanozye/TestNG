package gun02;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import utils.Driver;

import java.time.Duration;

public class TestOrnekBase {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeSuite
    public void setupDriver() {
        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    @AfterSuite
    public void tearDown(){
        driver.quit();
    }



    public void click(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        click(element);
    }

    public void click(WebElement element) {
        element.click();
    }

    public void sendKeys(By locator, String text) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        sendKeys(element, text);
    }

    public void sendKeys(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }

    public WebElement waitUntilVisible(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }


}
