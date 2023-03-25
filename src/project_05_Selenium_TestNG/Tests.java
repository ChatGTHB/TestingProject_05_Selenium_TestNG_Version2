package project_05_Selenium_TestNG;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.BaseDriver;

public class Tests extends BaseDriver {
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

    @Test(dependsOnMethods = {"loginTest"})
    void checkLeftNavMenu() {

        TestsElements te = new TestsElements(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        for (int i = 1; i < te.navMenu.size(); i++) {
            wait.until(ExpectedConditions.visibilityOfAllElements(te.navMenu));
            js.executeScript("arguments[0].scrollIntoView(true);", te.navMenu.get(i));
            System.out.println("te.navMenu.get(i) = " + te.navMenu.get(i).getText());
            te.navMenu.get(i).click();
            Assert.assertTrue(te.navAltMenu.get(0).isEnabled());
            System.out.println("te.navAltMenu.get(0) = " + te.navAltMenu.get(0).getText());
            Assert.assertTrue(te.navAltMenu.get(0).isDisplayed());
        }
    }
}
