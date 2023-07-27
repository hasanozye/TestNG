package gun03;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Scanner;

public class TestDataProvider {

    @Test(dataProvider = "myData")
    public void test1(int num) {
        System.out.println(num);

    }


    // Dataprovider --> test methodları için data kaynağıdır
    // return Object[][]
    @DataProvider(name = "myData")
    public Object[][] getData() {
        return new Object[][]{
                {1},
                {2},
                {3}
        };
    }

    @Test(dataProvider = "getUsers")
    public void test2(String username, String password, boolean pass) {
        if (pass) {
            System.out.println(username + ", " + password + "--- PASS");
        } else {
            System.out.println(username + ", " + password + "--- FAIL");
        }

    }

    @DataProvider
    public Object[][] getUsers() {
        return new Object[][]
                {
                        {"Admin", "admin124", false},
                        {"Admin1", "admin12412", false},
                        {"Admin2", "admin124234", false},
                        {"Admin", "admin123", true},

                };
    }
}
