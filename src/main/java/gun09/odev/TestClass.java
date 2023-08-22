package gun09.odev;


import org.testng.annotations.Test;

public class TestClass extends TestClassBase {

    BellatrixHomePage bella;
    @Test
    public void test1(){
        bella = new BellatrixHomePage(driver);
        bella.goToUrl();
        bella.clickHomeHeader();
        bella.clickFirstProduct();

    }
}
