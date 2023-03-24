package project_05_Selenium_TestNG;


import org.testng.annotations.Test;
import utility.BaseDriverParameter;

public class Tests extends BaseDriverParameter {

// 1. POM kullanınız.
// 2. Paralel testler koşturunuz (Chrome,Firefox).
// 3. Test Case’lerinizi xml file dan çalistiriniz.
// 4. Url: https://admin-demo.nopcommerce.com/login?
// 5. username: admin@yourstore.com, password: admin
//
//
//    Test Case 1: Login Test
//➢ https://admin-demo.nopcommerce.com/login? sitesine gidiniz.
// ➢ Geçerli Username,password giriniz.
//➢ Login butonuna tıklayınız.
//➢ Login olduğunuzu doğrulayınız.

    @Test
    void loginTest(){

        driver.get("https://admin-demo.nopcommerce.com/login?");

    }






}
