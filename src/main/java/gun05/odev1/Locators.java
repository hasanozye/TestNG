package gun05.odev1;

import org.openqa.selenium.By;

public class Locators {
    /**
     *  Bu class'da kullanilacak locator'lar mevcuttur
     *  Büyük harfle belirlenenler genel locatorlar'dir
     *  String.format ile %s yerine text yerlertirilir ve xpath'e cevrilir
     *  örnek : site icinde inputlarin yerleri standart görünüyor.
     *      INPUT xpath'i sadece %s degisikligi ile cogunlugunu kapsamaktadir.
     */

    public static final String url = "https://opensource-demo.orangehrmlive.com/";
    public static final String siteTitle = "OrangeHRM";
    public static final String myUsername = "admin";
    public static final String myPassword = "admin123";
    public static final By erroMessages = By.cssSelector(".oxd-input-field-error-message");
    public static final String INPUT = "//label[contains(text(),'%s')]/ancestor::div[starts-with(@class,'oxd-input-group')]//input";
    public static final String DROPDOWN = "//label[contains(text(),'%s')]/ancestor::div[starts-with(@class,'oxd-grid-item')]//div[@class='oxd-select-wrapper']";
    public static final String DROPDOWN_OPTION = "//div[@role='option' and .//*[contains(.,'%s')]]";
    public static final String BUTTON = "//button[contains(., '%s')]";
    public static final String MENU_LINK = "//aside//a[contains(., '%s')]";
    public static final String NOTIFICATION = "//div[contains(@class,'oxd-toast-container') and ./*[contains(.,'%s')]]";
    public static final String TABLE_DELETE_BUTTON = "//div[@class='oxd-table-card' and .//div[contains(@class,'oxd-table-cell') and contains(., '%s')]]//button[1]";
    public static final String TABLE_EDIT_BUTTON = "//div[@class='oxd-table-card' and .//div[contains(@class,'oxd-table-cell') and contains(., '%s')]]//button[2]";

}
