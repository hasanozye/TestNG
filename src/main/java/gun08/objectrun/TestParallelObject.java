package gun08.objectrun;

import gun08.threadlocalrun.HomePage33;
import gun08.threadlocalrun.TestParallelBase;
import org.testng.annotations.Test;

public class TestParallelObject extends TestParallelBase {

    HomePage66 hp;

    @Test
    public void test1() {
        hp = new HomePage66(driver);
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
