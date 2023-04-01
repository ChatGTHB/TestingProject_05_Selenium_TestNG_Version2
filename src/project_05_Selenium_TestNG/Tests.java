package project_05_Selenium_TestNG;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.BaseDriverParameter;


public class Tests extends BaseDriverParameter {

    String randomMail;

    @Test(priority = 1)
    void loginTest() {

    }

    @Test(priority = 2)
    void checkLeftNavMenu() {

        TestsElements te = new TestsElements(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        for (int i = 1; i < te.navMenu.size(); i++) {
            wait.until(ExpectedConditions.visibilityOfAllElements(te.navMenu));
            js.executeScript("arguments[0].scrollIntoView(true);", te.navMenu.get(i));
            te.navMenu.get(i).click();
            Assert.assertTrue(te.navAltMenu.get(0).isEnabled());
            Assert.assertTrue(te.navAltMenu.get(0).isDisplayed());
        }
    }

    @Test(priority = 3)
    void createCustomer() {

        TestsElements te = new TestsElements(driver);
        Actions actions = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        randomMail = "testing" + (int) (Math.random() * 10000) + "@email.com";

        wait.until(ExpectedConditions.visibilityOfAllElements(te.navMenu));
        te.navMenu.get(3).click();

        wait.until(ExpectedConditions.visibilityOfAllElements(te.navAltMenu));
        js.executeScript("arguments[0].scrollIntoView(false);", te.navAltMenu.get(0));
        te.navAltMenu.get(0).click();

        wait.until(ExpectedConditions.elementToBeClickable(te.addButton));
        js.executeScript("arguments[0].scrollIntoView(false);", te.addButton);
        js.executeScript("arguments[0].click();", te.addButton);



        Action action = actions.click(wait.until(ExpectedConditions.elementToBeClickable(te.customerCreateInputs.get(0))))
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

        wait.until(ExpectedConditions.elementToBeClickable(te.customerCreateTaxInput));
        te.customerCreateTaxInput.click();
        wait.until(ExpectedConditions.elementToBeClickable(te.customerCreateInputs.get(8)));
        te.customerCreateInputs.get(8).click();
        wait.until(ExpectedConditions.elementToBeClickable(te.customerCreateNewsletters.get(0)));
        te.customerCreateNewsletters.get(0).click();

        action = actions.click(te.customerCreateInputs.get(10))
                .sendKeys("Vendor 1")
                .click()
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("Admin comment").build();
        action.perform();

        te.saveButton.click();

        Assert.assertTrue(te.successMessage.getText().contains("success"));
    }

    @Test(priority = 4, dependsOnMethods = "createCustomer")
    void editCustomer() {

        TestsElements te = new TestsElements(driver);
        Actions actions = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        wait.until(ExpectedConditions.visibilityOfAllElements(te.navMenu));

        wait.until(ExpectedConditions.elementToBeClickable(te.customersSearchEmail));
        js.executeScript("arguments[0].scrollIntoView(false);", te.customersSearchEmail);

        actions.click(te.customersSearchEmail)
                .sendKeys(randomMail)
                .sendKeys(Keys.TAB)
                .sendKeys("First name")
                .sendKeys(Keys.TAB)
                .sendKeys("Last name")
                .build().perform();

        wait.until(ExpectedConditions.elementToBeClickable(te.customerSearchButton)).click();

        js.executeScript("arguments[0].scrollIntoView(true);", te.searchCustomerMailList.get(0));
        Assert.assertTrue(te.searchCustomerMailList.size() != 0);

        js.executeScript("arguments[0].scrollIntoView(true);", te.customerEditButton);
        js.executeScript("arguments[0].click();", te.customerEditButton);

        actions.click(te.customerCreateInputs.get(0))
                .sendKeys(".tr").build().perform();

        wait.until(ExpectedConditions.elementToBeClickable(te.saveButton));
        te.saveButton.click();

        wait.until(ExpectedConditions.visibilityOf(te.successMessage));
        Assert.assertTrue(te.successMessage.getText().contains("success"));
    }

    @Test(priority = 5, dependsOnMethods = {"createCustomer", "editCustomer"})
    void deleteCustomer() {

        TestsElements te = new TestsElements(driver);
        Actions actions = new Actions(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        actions.click(te.customersSearchEmail)
                .sendKeys(randomMail + ".tr")
                .sendKeys(Keys.TAB)
                .sendKeys("First name")
                .sendKeys(Keys.TAB)
                .sendKeys("Last name").build().perform();

        te.customerSearchButton.click();
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("(//a[@class='btn btn-default'])[1]"),1));

        js.executeScript("arguments[0].scrollIntoView(false);", wait.until(ExpectedConditions.elementToBeClickable(te.customerEditButton)));
        te.customerEditButton.click();

        js.executeScript("arguments[0].scrollIntoView(false);", wait.until(ExpectedConditions.elementToBeClickable(te.deleteButton)));
        js.executeScript("arguments[0].click();", te.deleteButton);

        js.executeScript("arguments[0].scrollIntoView(false);", te.deleteConfirm);
        js.executeScript("arguments[0].click();", te.deleteConfirm);

        Assert.assertTrue(te.successMessage.getText().contains("success"));
    }

    @Test(priority = 6)
    void searchTest() {

        TestsElements te = new TestsElements(driver);

        te.searchBox.sendKeys("Shipments");

        te.searchShipments.click();

        Assert.assertEquals(te.shipmentsTextConfirm.getText(), "Shipments");
    }
}
