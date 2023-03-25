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

    @FindBy(xpath="//input[@id='Email']")
    public WebElement eMail;

    @FindBy(xpath="//input[@id='Password']")
    public WebElement password;

    @FindBy(xpath="//button[text()='Log in']")
    public WebElement loginButton;

    @FindBy(xpath="//a[text()='Logout']")
    public WebElement logoutLink;


    @FindBy(xpath="//ul[@class='nav nav-pills nav-sidebar flex-column nav-legacy']/li")
    public List <WebElement>navMenu;

//    @FindBy(xpath="//ul[@class='nav nav-treeview']")
    @FindBy(xpath="//li[@class='nav-item has-treeview menu-is-opening menu-open']//li")
    public List <WebElement>navAltMenu;



}
