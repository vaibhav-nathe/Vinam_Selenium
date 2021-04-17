package io.vinam;

import io.vinam.base.TestBase;
import io.vinam.webpages.ExcelUtils;
import io.vinam.webpages.ScreenShotUtility;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class LoginTest extends TestBase {

    @DataProvider(name = "loginDetails")
    public Object[][] getLoginDetails() throws Exception {
        return ExcelUtils.readExcelData("AutomationCreation", "Sheet2");
    }

    @Test(dataProvider = "loginDetails")
    public void login(String userName, String password) throws InterruptedException {
        login.enterEmail(userName);
        ScreenShotUtility.takeScreenShot(driver);
        log.info("Email id  entered");
        login.enterPassword(password);
        ScreenShotUtility.takeScreenShot(driver);
        log.info("Password entered");
        login.clickLoginButton();
        ScreenShotUtility.takeScreenShot(driver);
        log.info("Successfully clicked on login button");
        //board.verifyPageName();
        ScreenShotUtility.takeScreenShot(driver);
    }

}
