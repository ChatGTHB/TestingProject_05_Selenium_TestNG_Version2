package project_05_Selenium_TestNG;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.BaseDriverParameter;

public class Tests extends BaseDriverParameter {
    @Test()
    void loginTest() {

        TestsElements te = new TestsElements(driver);
        te.eMail.clear();
        te.eMail.sendKeys("admin@yourstore.com");
        te.password.clear();
        te.password.sendKeys("admin");
        te.loginButton.click();

        Assert.assertTrue(te.logoutLink.isDisplayed());
    }

    //              Test Case 2: Check LeftNaw Menu
//            ➢ Dashboardun altındaki menülere tek tek tıklatın.
//            ➢ Menülerin açılıp açılmadığını doğrulayın.
//            ➢ Açılan menünün altındaki elemanların olduğunu doğrulayın.
    @Test(dependsOnMethods = {"loginTest"})
    void checkLeftNavMenu() {

        TestsElements te = new TestsElements(driver);

        for (int i = 1; i < te.navMenu.size(); i++) {
            wait.until(ExpectedConditions.elementToBeClickable(te.navMenu.get(i)));
            te.navMenu.get(i).click();
            wait.until(ExpectedConditions.visibilityOf(te.navAltMenu.get(0)));
            Assert.assertTrue(te.navAltMenu.get(0).isDisplayed());
        }

    }
}
