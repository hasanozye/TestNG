package gun02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.Driver;

import java.time.Duration;

public class TestMail {

    WebDriver driver;
    WebDriverWait wait;
    By lEmail = By.cssSelector("#identifierId");

    @Test
    public void loginToMail() {
        driver.get("https://www.gmail.com");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(lEmail)).sendKeys("hasanlareli@gmail.com",Keys.ENTER);
    }

    @BeforeTest
    public void setupDriver() {
        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }



}
