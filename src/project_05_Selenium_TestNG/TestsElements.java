package project_05_Selenium_TestNG;

import org.openqa.selenium.support.PageFactory;
import utility.BaseDriver;

public class TestsElements {
    public TestsElements() {
        PageFactory.initElements(BaseDriver.driver, this);
    }

}
