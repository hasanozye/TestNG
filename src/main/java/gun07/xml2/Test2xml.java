package gun07.xml2;

import org.testng.annotations.*;

public class Test2xml {
    @Parameters("version")
    @BeforeSuite
    public void beforeSuite(String browser){
        System.out.println(browser);
    }

    @Parameters({"browser"})
    @BeforeTest
    public void beforeTest(@Optional("edge") String browser1) {
        System.out.println(browser1);
    }

    @BeforeClass
    public void beforeClass() {

    }


    @Test
    public void test1() {
        System.out.println("Test1");
    }

    @Test
    public void test2() {
        System.out.println("Test2");
    }

    @Test
    public void test3() {
        System.out.println("Test3");
    }

    @Test
    public void test4() {
        System.out.println("Test4");
    }
}
