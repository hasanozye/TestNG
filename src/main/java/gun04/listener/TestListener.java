package gun04.listener;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(TestListenerClass.class)
public class TestListener {

    /*
        Listener, testlerin yürütülmesi esnasinda test baslama, bitis, success, pass ya da skip
        durumlarinin yakalanmasi ve istenilen islemin ya da raporun hazirlanmasi icin kullanilir
        @Before... ve @After... annotations ile önce ve sonra yapilacak islemler yapilabilir
        ancak test sonuclari ya da durumu ile ilgili bilgi edinilemez.
        Test durumlarinin yakalanmasi icin listener'a ihtiyac duyulur.
     */

    @Test(priority = 1)
    public void test1(){
        Assert.assertEquals(1,1);
    }

    @Test(priority = 2)
    public void test2(){
        Assert.assertEquals(1,2);
    }

    @Test(priority = 3, dependsOnMethods = {"test2"})
    public void test3(){
        Assert.assertEquals(1,1);
    }

    @Test(priority = 4)
    public void test4(){
        Assert.assertEquals(1,1);
    }

}
