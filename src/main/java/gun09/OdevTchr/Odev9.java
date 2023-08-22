package gun09.OdevTchr;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.lang.invoke.StringConcatFactory;
import java.util.stream.Collectors;

public class Odev9 extends Odev9Base {

    String url ="https://demos.bellatrix.solutions/";

    /*public static By lHome = By.xpath("(//a[contains(.,'Home')])[1]");
    public static By lfirstProduct = By.xpath("//h2[text()='Falcon 9']");
    public static By lConfirm = By.xpath("//h1[text()='Falcon 9']");*/

    @Test
    public void goToURL() {
        driver.get(url);
    }

    @Test (dependsOnMethods = "goToURL")
    public void Test1(){
        clickMenu("Home");
        clickMenu("Blog");
        clickMenu("Cart");
        clickMenu("Checkout");
        clickMenu("Contact Form");
    }

    public void clickMenu(String text) {
        By menuToggleButton = By.cssSelector("#site-navigation-menu-toggle");
        By locator = By.xpath("//a[text()='" + text + "']");
        if (driver.findElements(menuToggleButton).size() > 0 && driver.findElement(menuToggleButton).isDisplayed()) {
            driver.findElement(menuToggleButton).click();
        }
        driver.findElements(locator).stream().filter(WebElement::isDisplayed)
                .toList()
                .get(0)
                .click();
    }
}
