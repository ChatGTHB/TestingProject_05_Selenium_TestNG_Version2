package project_05_Selenium_TestNG;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.BaseDriver;
import utility.BaseDriver2;
import utility.BaseDriverParameter;

public class TestsElements {
    public TestsElements() {
        PageFactory.initElements(BaseDriver2.driver, this);
    }

    @FindBy(xpath="//input[@id='Email']")
    public WebElement eMail;

    @FindBy(xpath="//input[@id='Password']")
    public WebElement password;

    @FindBy(xpath="//button[text()='Log in']")
    public WebElement loginButton;



}
