package gun10.demoblaze;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderPage extends BaseClass {

    @FindBy(xpath = "//button[@data-target='#orderModal']")
    public static WebElement ePlaceOrderBtn;
    @FindBy(id = "name")
    public static WebElement eNameField;
    @FindBy(id = "country")
    public static WebElement eCountryField;
    @FindBy(id = "city")
    public static WebElement eCityField;
    @FindBy(id = "card")
    public static WebElement eCreditCardField;
    @FindBy(id = "month")
    public static WebElement eMonth;
    @FindBy(id = "year")
    public static WebElement eYear;
    @FindBy(xpath = "//button[@onclick='purchaseOrder()']")
    public static WebElement ePurchaseBtn;
    @FindBy(css = ".sa-confirm-button-container")
    public static WebElement eOKBtn;
    @FindBy(id = "cartur")
    public static WebElement eCartHeader;

    public OrderPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void placeTheOrder() {
        click(eCartHeader);
        click(ePlaceOrderBtn);
        sendKeys(eNameField, "Hasan");
        sendKeys(eCountryField, "Guatemala");
        sendKeys(eCityField, "Jalapa");
        sendKeys(eCreditCardField, "111222333");
        sendKeys(eMonth, "March");
        sendKeys(eYear, "2024");
        click(ePurchaseBtn);
        click(eOKBtn);
    }
}
