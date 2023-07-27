package gun03;

import gun02.TestOrnekBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.Driver;

import static gun02.Locators.*;

import java.time.Duration;

public class TestDataProvider2 extends TestOrnekBase {

    @DataProvider
    public Object[][] getUsers() {
        return new Object[][]
                {
                        {"Admin", "admin124", false},
                        {"Admin1", "admin12412", false},
                        {"Admin", "admin123", true},
                        {"Admin2", "admin124234", false}
                };
    }

    @Test
    public void login() {
        driver.get(url);
    }

    @Test(dependsOnMethods = {"login"}, dataProvider = "getUsers")
    public void test01(String username, String password, boolean pass) {
        sendKeys(lUserName, username);
        sendKeys(lPassword, password);
        click(lSubmitBtn);
        if (waitUntilVisible(lInvalidAccess).isDisplayed()) {
            System.out.println(username + ", " + password + ", " + pass);
        } else {
            System.out.println(username + ", " + password + ", " + !pass);
            waitUntilVisible(lAdminButton);
            new Actions(driver)
                    .keyDown(Keys.LEFT_ALT)
                    .sendKeys(Keys.ARROW_LEFT)
                    .keyUp(Keys.ALT)
                    .perform();
            waitUntilVisible(lLoginMainPage);
        }

    }
}
