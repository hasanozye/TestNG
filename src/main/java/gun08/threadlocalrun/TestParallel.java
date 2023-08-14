package gun08.threadlocalrun;

import org.testng.annotations.Test;

public class TestParallel extends TestParallelBase {

    HomePage33 hp;

    @Test
    public void test1() {
        hp = new HomePage33(driver);
        hp.goToUrl();
    }

    @Test(dependsOnMethods = {"test1"})
    public void test2() {
        hp.login();
    }

    @Test(dependsOnMethods = {"test2"})
    public void test3() {
        hp.logout();
    }
}
