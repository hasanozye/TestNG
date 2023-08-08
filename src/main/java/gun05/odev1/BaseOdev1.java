package gun05.odev1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import utils.Browsers;
import utils.Driver;

import java.time.Duration;

import static gun05.odev1.Locators.NOTIFICATION;


public class BaseOdev1 {
    protected WebDriver driver;       // base ve child class'da kullanilacak driver
    protected WebDriverWait wait;     // base ve child class'da kullanilacak wait


    /**
     * driver ve wait set ediliyor
     */
    @Parameters("browser")
    @BeforeTest
    public void setup(@Optional("chrome") String browser) {
        driver = Driver.getDriver(Browsers.valueOf(browser.toUpperCase()));
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    /**
     * driver quit ediliyor
     */
    @AfterTest
    public void tearDown() {
        Driver.quitDriver();
    }

    /**
     * locator exist oluncaya kadar bekler ve alttaki click methoduna gönderir
     *
     * @param locator : locator
     */
    public void click(By locator) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        click(element);
    }

    /**
     * gelen element clickable olana kadar bekler ve tiklar
     *
     * @param element element
     */
    public void click(WebElement element) {
        WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(element));
        element1.click();
    }

    public void clickByAction(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        clickByAction(element);
    }

    public void clickByAction(WebElement element) {
        new Actions(driver).moveToElement(element).click().perform();
    }

    /**
     * gelen locator exit olunca diger sendkeys methoduna gönderir
     * CharSequence olmasi varargs olarak birden fazla string ve Keys gönderebilmek icin
     *
     * @param locator element locator
     * @param text    CharSequence olarak chars
     */
    public void sendKeys(By locator, CharSequence... text) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        sendKeys(element, text);
    }

    /**
     * yukaridaki sendkeys methodundan gelen element CharSequence'i send eder
     *
     * @param element element
     * @param text    send edilecek textler
     */
    public void sendKeys(WebElement element, CharSequence... text) {
        WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(element));
        element1.sendKeys(text);
    }

    /**
     * test icinde element ihtiyaci olursa locator'i element olrak return etmesi icin
     *
     * @param locator locator
     * @return element
     */
    public WebElement element(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    /**
     * String formatinda yazilan degiskenli xpath'lerde text degisikligi yapar
     * ve xpath olarak return eder
     *
     * @param xpathStr xpath stringi
     * @param label    element label'i
     * @return xpath
     */
    public By xpath(String xpathStr, String label) {
        return By.xpath(String.format(xpathStr, label));
    }

    /**
     * notification'da gecen texte göre vizibilitisini bekler
     *
     * @param text notification'da olmasi beklenen text
     */
    public void notificationIsShownWithText(String text) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath(NOTIFICATION, text)));
    }

    /**
     * button'in value'sunu bekler
     *
     * @param locator element locator
     * @param value   button value text
     */
    public void valueToBe(By locator, String value) {
        wait.until(ExpectedConditions.attributeToBe(locator, "value", value));
    }

    /**
     * yukaridaki method'un element almis hali
     *
     * @param element element
     * @param text    button value text
     */
    public void valueToBe(WebElement element, String text) {
        wait.until(ExpectedConditions.attributeToBe(element, "value", text));
    }

    /**
     * element'in text'ini bekler
     *
     * @param locator element locator
     * @param text    element text
     */
    public void textToBe(By locator, String text) {
        wait.until(ExpectedConditions.attributeToBe(locator, "value", text));
    }

    /**
     * yukaridaki method'un element almis hali
     *
     * @param element element
     * @param text    element text
     */
    public void textToBe(WebElement element, String text) {
        wait.until(ExpectedConditions.attributeToBe(element, "value", text));
    }

    /**
     * standart java beklemesi
     *
     * @param milis miliseconds
     */
    public void sleep(long milis) {
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
