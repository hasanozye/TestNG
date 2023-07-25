package gun01;

import org.testng.annotations.Test;

public class Test2Attribute {

    @Test(description = "Ilk siradaki Test", testName = "test0", priority = 1)
    public void test3() {
        System.out.println("Test3");
    }

    @Test(priority = 0, enabled = false)
    public void test1() {
        System.out.println("Test1");
    }

    @Test(priority = -3)
    public void test2() {
        System.out.println("Test2");
    }
}
