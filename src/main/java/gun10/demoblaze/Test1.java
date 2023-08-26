package gun10.demoblaze;

import org.testng.annotations.Test;

public class Test1 extends BaseClass {

    LandingPage landingPage;
    AddToCartPage addToCartPage;
    OrderPage orderPage;

    @Test
    public void loginPage() {
        landingPage = new LandingPage(driver);
        landingPage.loginToPage();
    }

    @Test(dependsOnMethods = {"loginPage"})
    public void signUp() {
        landingPage.signUp();
    }

    @Test(dependsOnMethods = {"signUp"})
    public void logIn() {
        landingPage.logIn();
    }

    @Test(dependsOnMethods = {"logIn"})
    public void firstProduct() {
        try{
            driver.navigate().refresh();
            landingPage.clickPhoneMenu();
        }catch(Exception ignored){

        }
        landingPage.clickSamsungProd();
    }

    @Test(dependsOnMethods = {"firstProduct"})
    public void addToCart() throws InterruptedException {
        addToCartPage = new AddToCartPage(driver);
        addToCartPage.addToCart();
    }

    @Test(dependsOnMethods = {"addToCart"})
    public void orderPage() {
        orderPage = new OrderPage(driver);
        orderPage.placeTheOrder();

    }


}
