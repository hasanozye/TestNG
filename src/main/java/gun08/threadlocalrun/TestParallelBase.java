package gun08.threadlocalrun;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import utils.Browsers;
import utils.Driver;

public class TestParallelBase {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @Parameters("browser")
    @BeforeTest
    public void beforeTest(String browser) {
        driver = Driver.getDriver(Browsers.valueOf(browser));
        driver.manage().window().maximize();

    }

    @AfterTest
    public void afterTest() {
        Driver.getDriver().quit();
    }


}
