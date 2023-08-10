package gun05.odev1My;

import org.testng.annotations.Test;

import static gun05.odev1My.Odev1Locators.*;

public class TestOdev01 extends BaseOdev01 {

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
