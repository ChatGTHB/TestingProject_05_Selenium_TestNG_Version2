package project_05_Selenium_TestNG;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.BaseDriver;
import utility.BaseDriverParameter;
import utility.Tools;

public class Tests extends BaseDriverParameter {

    String randomMail;

    @Test(priority = 1)
    void loginTest() {

//        TestsElements te = new TestsElements(driver);
//
//        te.eMail.clear();
//        te.eMail.sendKeys("admin@yourstore.com");
//        te.password.clear();
//        te.password.sendKeys("admin");
//        te.loginButton.click();
//        Assert.assertTrue(te.logoutLink.isDisplayed());
    }

    @Test(priority = 2)
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

    @Test(priority = 3)
    void createCustomer() {

        TestsElements te = new TestsElements(driver);
        Actions actions = new Actions(driver);
        randomMail = "eMail" + (int) (Math.random() * 10000) + "@email.com";


        wait.until(ExpectedConditions.visibilityOfAllElements(te.navMenu));
        te.navMenu.get(3).click();
        wait.until(ExpectedConditions.visibilityOfAllElements(te.navAltMenu));
        te.navAltMenu.get(0).click();
        te.addButton.click();
        Action action = actions.click(te.customerCreateInputs.get(0))
                .sendKeys(randomMail)
                .sendKeys(Keys.TAB)
                .sendKeys("password")
                .sendKeys(Keys.TAB)
                .sendKeys("First name")
                .sendKeys(Keys.TAB)
                .sendKeys("Last name").build();
        action.perform();
        te.customerCreateGenders.get(0).click();

        action = actions.click(te.customerCreateBirthdayCalender)
                .sendKeys("01.01.2000")
                .sendKeys(Keys.TAB)
                .sendKeys("Company name").build();
        action.perform();
        te.customerCreateTaxInput.click();
        te.customerCreateInputs.get(8).click();
        te.customerCreateNewsletters.get(0).click();


        action = actions.click(te.customerCreateInputs.get(10))
                .sendKeys("Vendor 1")
                .click()
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("Admin comment").build();
        action.perform();
        te.saveButton.click();

        Assert.assertTrue(te.successMessage.isDisplayed());
    }

    @Test(priority = 4, dependsOnMethods = "createCustomer")
    void editCustomer() {

        TestsElements te = new TestsElements(driver);
        Actions actions = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        actions.click(te.customersSearchEmail)
                .sendKeys(randomMail)
                .sendKeys(Keys.TAB)
                .sendKeys("First name")
                .sendKeys(Keys.TAB)
                .sendKeys("Last name")
                .build().perform();

        te.customerSearchButton.click();

        js.executeScript("arguments[0].scrollIntoView(true);", te.searchCustomerMailList);
        wait.until(ExpectedConditions.visibilityOf(te.searchCustomerMailList));
        Assert.assertEquals(randomMail, te.searchCustomerMailList.getText());

        js.executeScript("arguments[0].scrollIntoView(true);", te.customerEditButton);
        js.executeScript("arguments[0].click();", te.customerEditButton);

        actions.click(te.customerCreateInputs.get(0))
                .sendKeys("edit").build().perform();

        te.saveButton.click();

        Assert.assertTrue(te.successMessage.isDisplayed());
    }

    @Test(priority = 5, dependsOnMethods = {"createCustomer", "editCustomer"})
    void deleteCustomer() {

        TestsElements te = new TestsElements(driver);
        Actions actions = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        actions.click(te.customersSearchEmail)
                .sendKeys(randomMail + "edit")
                .sendKeys(Keys.TAB)
                .sendKeys("First name")
                .sendKeys(Keys.TAB)
                .sendKeys("Last name").build().perform();

        te.customerSearchButton.click();

        js.executeScript("arguments[0].scrollIntoView(true);", te.customerEditButton);
        js.executeScript("arguments[0].click();", te.customerEditButton);

        te.deleteButton.click();
        // wait.until(ExpectedConditions.elementToBeClickable(te.deleteConfirm));
        js.executeScript("arguments[0].click();", te.deleteConfirm);

        Assert.assertTrue(te.successMessage.isDisplayed());
    }

    @Test(priority = 6)
    void searchTest() {

        TestsElements te = new TestsElements(driver);
        Actions actions = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        te.searchBox.sendKeys("Shipments");

        te.searchShipments.click();

        Assert.assertTrue(te.shipmentsTextConfirm.isDisplayed());

    }
}
