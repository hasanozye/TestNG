package gun09.odev;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;


public class BellatrixHomePage extends TestClassBase {

    private WebDriver driver;

    String url = "https://demos.bellatrix.solutions/";

    @FindBy(xpath = "(//a[text()='Home'])[1]")
    public WebElement eHomeHeader;
    @FindBy(xpath = "//h2[text()='Falcon 9']")
    public WebElement eFirstElement;
    @FindBy(xpath = "//h1[text()='Falcon 9']")
    public WebElement eVerifyFirstElementHeader;

    public BellatrixHomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);

    }

    public void goToUrl() {
        driver.get(url);
    }

    public void clickHomeHeader() {
        click(eHomeHeader);
    }

    public void clickFirstProduct() {
        click(eFirstElement);
        Assert.assertEquals(eVerifyFirstElementHeader.getText(), "Falcon 9");

    }


}
