package project_05_Selenium_TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class TestsElements {
    public TestsElements(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='Email']")
    public WebElement eMail;

    @FindBy(xpath = "//input[@id='Password']")
    public WebElement password;

    @FindBy(xpath = "//button[text()='Log in']")
    public WebElement loginButton;

    @FindBy(xpath = "//a[text()='Logout']")
    public WebElement logoutLink;

    @FindBy(xpath = "//ul[@class='nav nav-pills nav-sidebar flex-column nav-legacy']/li")
    public List<WebElement> navMenu;

    @FindBy(xpath = "//li[@class='nav-item has-treeview menu-is-opening menu-open']//li")
    public List<WebElement> navAltMenu;

    @FindBy(xpath = "//a[text()='Logout']")
    public WebElement customersMenu;

    @FindBy(xpath = "//a[@class='btn btn-primary']")
    public WebElement addButton;

    @FindBy(xpath = "//div[@class='col-md-9']")
    public List<WebElement> customerCreateInputs;

    @FindBy(xpath = "(//div[@class='col-md-9'])[5]//input")
    public List<WebElement> customerCreateGenders;

    @FindBy(xpath = "//span[@class='k-icon k-i-calendar']")
    public WebElement customerCreateBirthdayCalender;

    @FindBy(xpath = "(//div[@class='col-md-9'])[8]/input")
    public WebElement customerCreateTaxInput;

    @FindBy(css = "#SelectedNewsletterSubscriptionStoreIds_listbox>li")
    public List<WebElement> customerCreateNewsletters;

    @FindBy(xpath = "//button[@name='save']")
    public WebElement saveButton;

    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissable']")
    public WebElement successMessage;

    @FindBy(id = "SearchEmail")
    public WebElement customersSearchEmail;

    @FindBy(xpath = "//td[text()='email12345@email.com']")
    public WebElement confirmCreateCustomer;

    @FindBy(xpath = "(//table)[2]/tbody/tr/td[2]")
    public WebElement searchCustomerMailList;

    @FindBy(xpath = "//a[@class='btn btn-default']")
    public WebElement customerEditButton;

    @FindBy(id = "customer-delete")
    public WebElement deleteButton;

    @FindBy(xpath = "//button[@class='btn btn-danger float-right']")
    public WebElement deleteConfirm;

    @FindBy(id = "search-customers")
    public WebElement customerSearchButton;

    @FindBy(xpath = "//input[@placeholder='Search']")
    public WebElement searchBox;

    @FindBy(xpath = "//strong[text()='Shipments']")
    public WebElement searchShipments;

    @FindBy(className = "float-left")
    public WebElement shipmentsTextConfirm;

}
