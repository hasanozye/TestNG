package gun06.odev;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import utils.Driver;

import static gun06.odev.LoginPage.*;

public class TestLogin {

    LoginPage loginPage = new LoginPage();
    @Test
    public void openUrl(){
        loginPage.goToUrl();
    }

    @Test (dependsOnMethods = {"openUrl"})
    public void login(){
        loginPage.click(eMyAccount);
        loginPage.click(eLogin);
        loginPage.sendKeys(eMailAddress,"deneme@deneme.com");
        loginPage.sendKeys(ePassword,"deneme");
        loginPage.click(eLoginButton);
        loginPage.waitUntilVisible(eMyAccountText);

    }

    @AfterTest
    public void tearDown(){
        Driver.quitDriver();
    }
}
