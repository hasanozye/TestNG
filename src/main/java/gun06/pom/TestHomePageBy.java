package gun06.pom;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import utils.Driver;

public class TestHomePageBy {


    @Test
    public void search() {
        HomePageBy homePageBy;
        homePageBy = new HomePageBy();
        homePageBy.goToUrl();
        homePageBy.search("mac");
        homePageBy.clickSearchButton();
        int num = homePageBy.getNumberOfListedProducts();
        System.out.println(num);
    }

    @Test
    public void search1() {
        HomePageBy homePageBy1 = PageFactory.initElements(Driver.getDriver(), HomePageBy.class);

        homePageBy1.goToUrl();
        homePageBy1.searchBox.sendKeys("mac");
        homePageBy1.searchButton.click();
        int num = homePageBy1.searchedProducts.size();
        System.out.println(num);
        Driver.quitDriver();
    }

    @AfterTest
    public void tearDown() {
        Driver.quitDriver();
    }
}
