package utility;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import project_05_Selenium_TestNG.TestsElements;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriverParameter {
    public WebDriver driver;
    public static WebDriverWait wait;

    @BeforeClass
    @Parameters("browserType")
    public void startingOperations(String browser) {

        Logger logger = Logger.getLogger("");
        logger.setLevel(Level.SEVERE); //

        switch (browser.toLowerCase()) {
            case "firefox":
                System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            default:
                System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");

                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(options);
                // driver = new ChromeDriver();
                break;
        }

        driver.manage().window().maximize();

        Duration duration = Duration.ofSeconds(30);
        driver.manage().timeouts().pageLoadTimeout(duration);

        driver.manage().timeouts().implicitlyWait(duration);

        wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        loginTest();

    }

    void loginTest() {
        driver.get("https://admin-demo.nopcommerce.com/login?");

        TestsElements te = new TestsElements(driver);

        te.eMail.clear();
        te.eMail.sendKeys("admin@yourstore.com");
        te.password.clear();
        te.password.sendKeys("admin");
        te.loginButton.click();
        Assert.assertTrue(te.logoutLink.isDisplayed());

    }

    @AfterClass
    public void endingOperations() {

        Tools.wait(5);
        driver.quit();

    }
}
