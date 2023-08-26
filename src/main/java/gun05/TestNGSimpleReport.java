package gun05;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGSimpleReport {

    /*
        Basit emailable report olusturmak icin
        1.  Menüden Run -> Edit Configuration secilir
        2.  Acilan pencerenin sol bölümünde bu classin ismi secilir
        3.  Ortada bulunan Listeners linkine tiklanir
        4.  + butonu tiklanir ve acilan pencerede report aratilir
        5.  liste icinde EmailableReport projeye eklenir.
        6.  Class run edilince "test-output/emailable-report.html" olusur
     */

    @Test
    public void test1(){
        Assert.assertEquals(1,1);
    }

    @Test
    public void test2(){
        Assert.assertEquals(1,2);
    }

    @Test
    public void test3(){
        Assert.assertEquals(1,1);
    }

}
