package gun06.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

import java.util.List;

public class HomePageBy {
    WebDriver driver;

    String url = "https://opencart.abstracta.us/";

    @FindBy(css = "#search input")
    public WebElement searchBox;

    @FindBy(how = How.CSS, using = "#search button")
    public WebElement searchButton;

    @FindBy(css = ".product-layout")
    public List<WebElement> searchedProducts;

    public HomePageBy() {
        driver = Driver.getDriver();
        // @FindBy tanılı elementleri intilialize eder.
        PageFactory.initElements(driver, this);
    }

    public void goToUrl() {
        driver.get(url);
    }

    public void search(String text) {
        searchBox.sendKeys(text);
    }

    public void clickSearchButton() {
        searchButton.click();
    }

    public int getNumberOfListedProducts() {
        return searchedProducts.size();
    }

}
