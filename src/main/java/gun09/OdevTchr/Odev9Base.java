package gun09.OdevTchr;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utils.Browsers;
import utils.Driver;

import java.time.Duration;

public class Odev9Base {

    WebDriver driver;

    @BeforeTest
    @Parameters({"browser", "size"})
    public void beforeTest(@Optional("CHROME") String browser, @Optional("max") String size) {
        driver = Driver.getDriver(Browsers.valueOf(browser.toUpperCase()));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        if (size.equalsIgnoreCase("max")) {
            driver.manage().window().maximize();
        } else {
            driver.manage().window().setSize(new Dimension(600, 600));
        }
    }


    @AfterTest
    public void afterTest() {
        Driver.quitDriver();
    }
}
