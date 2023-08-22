package gun10;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class TestGroup {


    int i;

    @Test(groups = {"A"})
    public void test1() {
        Assert.assertEquals(1, 1, "Message Test1");

    }

    @Test(groups = {"B"})
    public void test2() {
        Assert.assertEquals(2, 2, "Message Test2");
        i++;
    }

    @Test(groups = {"A", "B"})
    public void test3() {
        Assert.assertEquals(3, 3, "Message Test3");
    }

    @Test(groups = {"B"})
    public void test4() {
        Assert.assertEquals(4, 4, "Message Test3");
    }

    @Test(groups = {"A"})
    public void test5() {
        Assert.assertEquals(5, 5, "Message Test5");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("int i = " + i);
    }
}
