package gun03;

import gun02.TestOrnekBase;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static gun02.Locators.*;

public class TestLoginWithDataProvider extends TestOrnekBase {

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
        if (pass) {
            waitUntilVisible(lUserDropDown);
            click(lUserDropDown);
            waitUntilVisible(lUserDropDownLogout);
            click(lUserDropDownLogout);
            System.out.printf("Username: %s --> Password: %s --> %b\n", username, password, true);
        } else {
            waitUntilVisible(lInvalidAccess);
            System.out.printf("Username: %s --> Password: %s --> %b\n", username, password, false);
        }

    }
}
