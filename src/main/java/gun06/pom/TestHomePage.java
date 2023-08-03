package gun06.pom;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import utils.Driver;

public class TestHomePage {

//    WebDriver driver;

    HomePage homePage;

    @Test
    public void testSearch() {
        homePage = new HomePage();
        homePage.goToUrl();
        homePage.search("mac");
        homePage.clickSearchButton();
        int num = homePage.getNumberOfListedProducts();
        System.out.println(num);

    }

    @AfterTest
    public void tearDown() {
        Driver.quitDriver();
    }


}
