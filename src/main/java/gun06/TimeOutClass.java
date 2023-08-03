package gun06;

import org.testng.annotations.Test;

public class TimeOutClass {


    @Test
    public void test1(){
        count();
    }

    @Test (timeOut = 1000) //test 1000 ms içinde bitmez ise hata return eder.
    public void test2(){
        count();
    }
    
    public void count(){
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
