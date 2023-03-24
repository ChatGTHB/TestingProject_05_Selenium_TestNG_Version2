package project_05_Selenium_TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


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



}
