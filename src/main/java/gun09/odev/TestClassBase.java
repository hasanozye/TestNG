package gun09.odev;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utils.Browsers;
import utils.Driver;

import java.time.Duration;

public class TestClassBase {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeTest
    @Parameters("browser")
    public void setupDriver(@Optional("chrome") String browser) {
        driver = Driver.getDriver(Browsers.valueOf(browser.toUpperCase()));
        driver.manage().window().maximize();
    }

    @AfterTest
    public void tearDown() {
        Driver.quitDriver();
    }


    public void click(WebElement element) {
        waitUntilClickable(element).click();
    }

    public void sendKeys(WebElement element, String text) {
        WebElement element1 = waitUntilClickable(element);
        element1.clear();
        element1.sendKeys(text);
    }

    public WebElement waitUntilVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitUntilClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
