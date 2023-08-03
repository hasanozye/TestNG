package gun05.odev1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.Driver;

import static gun05.odev1.Odev1Locators.*;

import java.time.Duration;

public class TestOdev1 extends BaseOdev01 {

    @Test
    public void login() {
        driver.get(url);
    }

    @Test (dependsOnMethods = {"login"})
    public void test01() {
        waitUntilVisible(lUsername);
        sendKeys(lUsername, "Admin");
        sendKeys(lPassword, "admin123");
        click(lSubmitButton);
        click(lAdminButton);

    }

}
