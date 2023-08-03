package gun04.listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/*
    TestNG listener olusturmak icin
    1.  Bir class ITestListener'i implement eder
    2.  Generate -> Implement methods ile istenilen methodlar eklenir.
    3.  onStart         -> test basladiginda
        onTestStart     -> test methodu basladiginda
        onTestSuccess   -> test methodu basarili oldugunda
        onTestFailure   -> test methodu basarisiz oldugunda
        onTestSkipped   -> test methodu skip oldugunda
        onFinish        -> test tamamlandiginda     calisirlar

 */

public class TestListenerClass implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("test basladi");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Basarili, " + result.getName() + ", " + result.getStatus());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Basarisiz, " + result.getName() + ", " + result.getStatus());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Pas gecildi, " + result.getName() + ", " + result.getStatus());
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Basladi, " + context.getName());

    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Bitti, " + context.getName());
    }
}
