package project_05_Selenium_TestNG;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utility.BaseDriver;

public class TestsElements {
    public TestsElements() {
        PageFactory.initElements(BaseDriver.driver, this);
    }

    @FindBy(xpath="//input[@id='Email']")
    public WebElement eMail;

    @FindBy(xpath="//input[@id='Email']")
    public WebElement password;

    @FindBy(xpath="//button[text()='Log in']")
    public WebElement loginButton;

}
