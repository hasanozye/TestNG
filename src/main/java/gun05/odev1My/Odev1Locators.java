package gun05.odev1My;

import org.openqa.selenium.By;

public class Odev1Locators {
    public static String url = "https://opensource-demo.orangehrmlive.com/";
    public static By lUsername = By.xpath("//input[@name ='username']");
    public static By lPassword = By.xpath("//input[@name ='password']");
    public static By lSubmitButton = By.xpath("//button[@type='submit']");
    public static By lAdminButton = By.xpath("//span[text()='Admin']");
    public static By lAddButton =By.xpath("//button[contains(., ' Add ')]");


}
