package gun02;

import org.openqa.selenium.By;

public class Locators {
    public static final String url = "https://opensource-demo.orangehrmlive.com/";
    public static final By lUserName = By.cssSelector("input[name='username']");
    public static final By lPassword = By.cssSelector("input[name='password']");
    public static final By lSubmitBtn = By.cssSelector("button[type='submit']");
    public static final By lAdminButton = By.xpath("//*[text()='Admin']");
    public static final By lDropdownRole = By.xpath(".//label[.='User Role']/ancestor::div[contains(@class,'oxd-grid-item')]");
    public static final By lOptionAdmin = By.xpath(".//div[@role='option' and .='Admin']");
    public static final By lSearchButton = By.cssSelector("button[type='submit']");
    public static final By lTableCell3 = By.xpath("//div[@role='table']//div[contains(@class,'oxd-table-cell')][3]");
    public static final By lInvalidAccess = By.xpath("//p[text()='Invalid credentials']");
    public static final By lLoginMainPage = By.xpath("//h5[text()='Login']");
}
