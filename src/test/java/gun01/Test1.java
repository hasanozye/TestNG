package gun01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Test1 {

    WebDriver driver;
    WebDriverWait wait;
    String url = "https://demowebshop.tricentis.com/";
    String myUsername = "abc123@aa.com";
    String myPassword = "123456";
    By lLoginFormUsername = By.id("Email");
    By lLoginFormPassword = By.id("Password");
    By lLoginFormSubmitButton = By.xpath("//input[@value='Log in']");
    By lLogout = By.xpath("//a[text()='Log out']");
    By lLogin = By.xpath("//a[text()='Log in']");

    @BeforeTest
    public void driverSetUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterTest
    public void driverQuit() {
        driver.quit();
    }


    @Test(priority = 1)
    public void gotoUrl() {
        driver.get(url);
    }


    @Test(priority = 2)
    public void clickLogin() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lLogin));
        driver.findElement(lLogin).click();

    }

    @Test(priority = 3)
    public void fullfillLoginForm() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lLoginFormUsername));
        driver.findElement(lLoginFormUsername).sendKeys(myUsername);
        driver.findElement(lLoginFormPassword).sendKeys(myPassword);
    }

    @Test(priority = 4)
    public void loginSubmitClick() {
        driver.findElement(lLoginFormSubmitButton).click();
    }

    @Test(priority = 5)
    public void loginAssert() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(lLogout));
        Assert.assertTrue(driver.findElement(lLogout).getText().contains("Log out"));

    }
}
