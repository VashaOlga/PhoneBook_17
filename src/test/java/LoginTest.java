import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class LoginTest extends TestBase {
    WebDriver wd;

    @BeforeMethod
    public void init() {
//        wd = new ChromeDriver();
//        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/home");
    }

    @Test
    public void loginPositiveTest() {
//        //open log/reg form
//        WebElement loginBtn = wd.findElement(By.xpath("//a[text()='LOGIN']"));
//        loginBtn.click();
//
//        //fill log/reg form
////        WebElement email = wd.findElement(By.xpath("//input[@placeholder='Email']"));
//        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys("TestOlga@mail.co");
//
//        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
//        passInput.click();
//        passInput.clear();
//        passInput.sendKeys("12345Qwert-");
//
//        //click Login button
//        wd.findElement(By.xpath("//button[1]")).click();

//        HW
        String email = "TestOlga@mail.co";
        String password = "12345Qwert-";
        openLoginRegistrationForm();
        fillLoginRegistrationForm(email, password);
        submitLogin();

        //Assert
        pause(5);
        Assert.assertTrue(wd.findElement(By.xpath("//a[@href='/add']")) != null);
    }

    @AfterMethod
    public void tearDown() {
//        wd.quit();
    }
}
