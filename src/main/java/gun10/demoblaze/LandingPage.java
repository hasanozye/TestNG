package gun10.demoblaze;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class LandingPage extends BaseClass {


    String id = "hasanbaba10004";
    String password = "hasan0605";
    @FindBy(xpath = "//a[@data-target='#signInModal']")
    public static WebElement eSignup;
    @FindBy(css = "#sign-username")
    public static WebElement eUsername;
    @FindBy(css = "#sign-password")
    public static WebElement ePassword;
    @FindBy(xpath = "//button[@onclick='register()']")
    public static WebElement eSignUpBtn;
    @FindBy(id = "login2")
    public static WebElement eLogin;
    @FindBy(id = "loginusername")
    public static WebElement eUsernameField;
    @FindBy(id = "loginpassword")
    public static WebElement ePasswordField;
    @FindBy(xpath = "//button[@onclick='logIn()']")
    public static WebElement eLoginBtn;
    @FindBy(xpath = "//a[text()='Phones']")
    public static WebElement ePhonesMenu;
    @FindBy(xpath = "//a[text()='Samsung galaxy s6']")
    public static WebElement eSamsungProd;


    public LandingPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }


    public void loginToPage() {
        driver.get(url);
    }

    public void signUp() {
        click(eSignup);
        sendKeys(eUsername, id);
        sendKeys(ePassword, password);
        click(eSignUpBtn);
        waitUntilAlertAccept();
    }

    public void logIn() {
        click(eLogin);
        sendKeys(eUsernameField, id);
        sendKeys(ePasswordField, password);
        click(eLoginBtn);

    }

    public void clickPhoneMenu() {
        click(ePhonesMenu);
    }

    public void clickSamsungProd() {
        click(eSamsungProd);
    }


}
