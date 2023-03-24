package project_05_Selenium_TestNG;

import org.testng.Assert;
import org.testng.annotations.Test;
import utility.BaseDriverParameter;


public class Tests extends BaseDriverParameter {

//➢ Login olduğunuzu doğrulayınız.

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
}
