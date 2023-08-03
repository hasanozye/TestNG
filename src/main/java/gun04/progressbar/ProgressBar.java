package gun04.progressbar;

import gun04.listener.TestListenerClass;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.Driver;

import java.time.Duration;

import static gun04.progressbar.ProgressBarLocators.*;

@Listeners(TestListenerClass.class)
public class ProgressBar extends ProgressBarBase {


    @BeforeTest
    public void setup() {
        driver = Driver.getDriver();
        driver.manage().window().maximize();
        //wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofMillis(100));
    }

    @AfterTest
    public void afterTest() {
        Driver.quitDriver();
    }


    @Test(priority = 100)
    public void gotoUrl() {
        driver.get(url);
        wait.until(ExpectedConditions.titleIs("DEMOQA"));
    }


    @Test(priority = -10, dependsOnMethods = {"gotoUrl"})
    public void barProcess() {
        click(lButton);
        while (true) {
            String text = driver.findElement(lProgressBar).getText();
            int percent = text.length() > 0 ? Integer.parseInt(text.replaceAll("[^0-9]", "")) : 0;
            if (percent >= 60) {
                click(lButton);
                getScreenShot("Test1");
                break;
            }
        }
    }


    @Test(priority = -100, dependsOnMethods = {"gotoUrl", "barProcess"})
    public void barProcess2() {
        click(lButton);
        By lProgresbar80 = By.xpath("//div[@role='progressbar' and text()='80%']");
        new WebDriverWait(driver, Duration.ofSeconds(20), Duration.ofMillis(10))
                .until(ExpectedConditions.visibilityOfElementLocated(lProgresbar80));
        click(lButton);
        getScreenShot("Test2");
    }
}
