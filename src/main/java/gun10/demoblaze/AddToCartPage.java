package gun10.demoblaze;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AddToCartPage extends BaseClass {

    @FindBy(xpath = "//a[@onClick='addToCart(1)']")
    public static WebElement eAddToCart;

    public AddToCartPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void addToCart() {
        click(eAddToCart);
        waitUntilAlertAccept();
    }
}
