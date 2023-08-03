package gun06;

import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GroupsClass {


    @Test(groups = {"A"})
    public void test1(){
        System.out.println("Test1, group A");
    }

    @Test(groups = {"B"})
    public void test2(){
        System.out.println("Test2, group B");
    }

    @Test(groups = {"A"})
    public void test3(){
        System.out.println("Test3, group A");
    }


    @BeforeTest
    public void setup1(){
        System.out.println("Setup 1");
    }


    @BeforeGroups({"A"})
    public void beforeGroupA(){
        System.out.println("Before Group A");
    }

    @BeforeGroups({"B"})
    public void beforeGroupB(){
        System.out.println("Before Group B");
    }
}