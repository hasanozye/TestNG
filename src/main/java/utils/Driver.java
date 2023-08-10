package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Driver {
    public static void main(String[] args) {
        System.out.println(System.getProperty("user.home"));
    }

    //    private static WebDriver driver;
    private static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return getDriver(Browsers.CHROME);
    }

    public static WebDriver getDriver(Browsers browser) {

//        if (driver == null) {
        if (drivers.get() == null) {
            switch (browser) {
                case EDGE -> {
                    WebDriverManager.edgedriver().setup();
                    drivers.set(new EdgeDriver());
                }
                case FIREFOX -> {
                    WebDriverManager.firefoxdriver().setup();
                    drivers.set(new FirefoxDriver());
                }
                case SAFARI -> {
                    WebDriverManager.safaridriver().setup();
                    drivers.set(new SafariDriver());
                }
                default -> {
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--remote-allow-origins=*"); //version 11 socket hatası için
                    options.addArguments("--start-maximized"); // ilk açılışta maximized açılır
//                    options.addArguments("--headless"); // arka planda çalışır
//                    options.addArguments("--remote-debugging-port=9222");
//                    options.addArguments("--user-data-dir=" + System.getProperty("user.home") + "\\Desktop\\User Data");
//                    options.addArguments("--profile-directory=Profile 1");
                    drivers.set(new ChromeDriver());
                }

            }
        }
        return drivers.get();
    }

    public static void quitDriver() {
        if (drivers.get() != null) {
            Driver.getDriver().quit();
            drivers.set(null);
        }
    }


}
