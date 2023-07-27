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

    private static WebDriver driver;

    public static WebDriver getDriver() {
        return getDriver(Browsers.CHROME);
    }

    public static WebDriver getDriver(Browsers browser) {

        if (driver == null) {
            switch (browser) {
                case EDGE -> {
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                }
                case FIREFOX -> {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                }
                case SAFARI -> {
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
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
                    driver = new ChromeDriver(options);
                }

            }
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            Driver.getDriver().quit();
            driver = null;
        }
    }


}
