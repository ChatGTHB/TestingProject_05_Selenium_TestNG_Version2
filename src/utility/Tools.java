package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class Tools {


    public static void wait(int sn) {
        try {
            Thread.sleep(1000L * sn); // ms beklediği
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void successMessageValidation() {
        WebElement messageLabel = BaseDriver.driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']"));
        Assert.assertTrue(messageLabel.getText().toLowerCase().contains("success"));
    }

    public static int RandomGenerator(int max) {
        return (int) (Math.random() * max);
    }

    public static void listContainsString(List<WebElement> list, String searchedText) {

        boolean found = false;
        for (WebElement element : list) {
            if (element.getText().toLowerCase().contains(searchedText.toLowerCase())) {
                found = true;
                break;
            }
        }
        if (!found) {
            Assert.fail();
        }
    }

}
