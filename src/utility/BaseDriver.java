package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriver {

    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeClass
    public void startingOperations() {

        Logger logger = Logger.getLogger("");
        logger.setLevel(Level.SEVERE);

        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        // driver = new ChromeDriver();

        driver.manage().window().maximize();

        Duration duration = Duration.ofSeconds(30);
        driver.manage().timeouts().pageLoadTimeout(duration);

        driver.manage().timeouts().implicitlyWait(duration);

        wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        loginTest();

    }

    void loginTest() {

        driver.get("https://opencart.abstracta.us/index.php?route=account/login");

        WebElement loginMail = driver.findElement(By.id("input-email"));
        loginMail.sendKeys("test123@testing.com");

        WebElement loginPassword = driver.findElement(By.id("input-password"));
        loginPassword.sendKeys("Password");

        WebElement loginButton = driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
        loginButton.click();

        Assert.assertEquals(driver.getTitle(), "My Account");
    }

    @AfterClass
    public void endingOperations() {

        Tools.wait(5);
        driver.quit();

    }
}
