package gun02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.Driver;

import java.time.Duration;

public class Test1DriverCall {

    WebDriver driver;
    WebDriverWait wait;

    By lUsername = By.cssSelector("input[name='username']");
    By lPassword = By.cssSelector("input[name='password']");
    By lSubmitButton = By.cssSelector("button[type='submit']");
    By lSidePanel = By.cssSelector(".oxd-sidepanel");

    @Test
    public void goToUrl() {
        driver.get("https://opensource-demo.orangehrmlive.com/");
        wait.until(ExpectedConditions.titleIs("OrangeHRM"));

    }

    @Test(dependsOnMethods = {"goToUrl"})
    public void login() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lUsername)).sendKeys("Admin");
        driver.findElement(lPassword).sendKeys("admin123");
        driver.findElement(lSubmitButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(lSidePanel));
    }

    @BeforeClass
    public void setup() {
        driver = Driver.getDriver();
//        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
