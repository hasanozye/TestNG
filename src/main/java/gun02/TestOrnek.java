package gun02;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static gun02.Locators.*;

import java.util.List;

public class TestOrnek extends TestOrnekBase {

    WebDriver driver;

    /*
    BeforeSuite
        driver, wait set et
    BeforeTest
        https://opensource-demo.orangehrmlive.com/ git
    Test 1
        login:
    Test 2
    menüden admin'e tikla
    User Role -> Admin seçin
    Search edilecek
    Listelenene kullanıcıların tümünün User Rolunu Admin olduğu Assert Edilecek



    AfterSuite
        TearDown
     */



    @BeforeTest
    public void goToUrl() {
        super.driver.get(url);
    }

    @Test
    public void login() {
        sendKeys(lUserName, "Admin");
        sendKeys(lPassword, "admin123");
        click(lSubmitBtn);
    }

    @Test(dependsOnMethods = {"login"})
    public void test2() {
        click(lAdminButton);
        click(lDropdownRole);
        click(lOptionAdmin);
        click(lSearchButton);
        List<WebElement> list = super.driver.findElements(lTableCell3);
        long num = list.stream().filter(e -> !e.getText().contains("Admin")).count();
        Assert.assertEquals(num, 0);

    }
}
