package gun05.odev1;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import static gun05.odev1.Locators.*;

public class TestOdev1 extends BaseOdev1 {
    String newUsername;
    String newPassword;

    @Test
    public void gotoURL() {
        driver.get(url);
        wait.until(ExpectedConditions.titleIs(siteTitle));
    }

    @Test(dependsOnMethods = {"gotoURL"})
    public void testLogin() {
        sendKeys(xpath(INPUT, "Username"), myUsername);
        sendKeys(xpath(INPUT, "Password"), myPassword);
        click(xpath(BUTTON, "Login"));

        /*  Aciklama -> sendKeys(xpath(INPUT, "Username"), myUsername);
         *  xpath methodu INPUT xpath stringinde %s yerine Username yazar ve By.xpath olarak return eder
         *  sendKeys methodu xpath(INPUT, "Username") methodundan aldigi xpath'in belirttigi element
         *  precense (exist) oluncaya kadar bekler ve bu elementi parametresi element olan
         *  ikinci sendkeys methoduna gönderir ve o elemente send keys yapilmasi saglanir.
         *  Overload sendKeys ve click methodlari, ihtiyac durumunda
         *  hem locator ile hem de element ile kullanilmak icin yazilmistir.
         */
    }

    @Test(dependsOnMethods = {"testLogin"}, priority = 1)
    public void addUser() {

        click(xpath(MENU_LINK, "Admin"));

        click(xpath(BUTTON, "Add"));

        click(xpath(DROPDOWN, "User Role"));
        click(xpath(DROPDOWN_OPTION, "ESS"));

        click(xpath(DROPDOWN, "Status"));
        click(xpath(DROPDOWN_OPTION, "Enabled"));

        sendKeys(xpath(INPUT, "Employee Name"), "cecil");
        click(xpath(DROPDOWN_OPTION, "Cecil"));

        newUsername = "Ahmet" + RandomStringUtils.randomAlphabetic(3);
        newPassword = "Aa123." + RandomStringUtils.randomAlphabetic(5);

        sendKeys(xpath(INPUT, "Username"), newUsername);
        sendKeys(xpath(INPUT, "Password"), newPassword);
        sendKeys(xpath(INPUT, "Confirm Password"), newPassword);

        wait.until(ExpectedConditions.numberOfElementsToBe(erroMessages, 0));
        click(xpath(BUTTON, "Save"));
        notificationIsShownWithText("Successfull");
    }

    @Test(dependsOnMethods = {"addUser"}, priority = 2)
    public void updateUser() {
        click(xpath(MENU_LINK, "Admin"));
        sendKeys(xpath(INPUT, "Username"), newUsername);
        click(xpath(BUTTON, "Search"));
        click(xpath(TABLE_EDIT_BUTTON, newUsername));
        valueToBe(xpath(INPUT, "Username"), newUsername);
        newUsername+="1";
        sendKeys(xpath(INPUT, "Username"), "1");
        sleep(1000);
        click(xpath(BUTTON, "Save"));
        notificationIsShownWithText("Successfull");
    }

    @Test(dependsOnMethods = {"addUser"}, priority = 3)
    public void deleteUser() {
        click(xpath(MENU_LINK, "Admin"));
        sendKeys(xpath(INPUT, "Username"), newUsername);
        click(xpath(BUTTON, "Search"));
        click(xpath(TABLE_DELETE_BUTTON, newUsername));
        click(xpath(BUTTON, "No, Cancel"));
        click(xpath(TABLE_DELETE_BUTTON, newUsername));
        click(xpath(BUTTON, "Yes, Delete"));
        notificationIsShownWithText("Successfull");
    }


}
