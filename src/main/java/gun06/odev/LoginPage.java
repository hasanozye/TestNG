package gun06.odev;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Driver;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;
    String url = "https://opencart.abstracta.us/";

    @FindBy(xpath = "//a[@title='My Account']")
    public static WebElement eMyAccount;
    @FindBy(xpath = "//ul[contains(.,'Login') and contains(@class,'dropdown-menu')]")
    public static WebElement eLogin;
    @FindBy(css = "#input-email")
    public static WebElement eMailAddress;
    @FindBy(css = "#input-password")
    public static WebElement ePassword;
    @FindBy(css = "input[value='Login']")
    public static WebElement eLoginButton;
    @FindBy(xpath = "//h2[text()='My Account']")
    public static WebElement eMyAccountText;

    public void waitUntilVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public LoginPage() {
        driver = Driver.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void goToUrl() {
        driver.get(url);
    }


    public void click(WebElement element) {
        waitUntilVisible(element);
        element.click();
    }

    public void sendKeys(WebElement element, String text) {
        waitUntilVisible(element);
        element.clear();
        element.sendKeys(text);
    }


}
