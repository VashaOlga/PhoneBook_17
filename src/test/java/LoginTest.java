import models.User;
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
//    WebDriver wd;

    @BeforeMethod
    public void preCondition(){
        if(app.getUser().isLogged()){
            app.getUser().logout();
        }
    }

    @Test
//    public void loginPositiveTest() {
////        //open log/reg form
////        WebElement loginBtn = wd.findElement(By.xpath("//a[text()='LOGIN']"));
////        loginBtn.click();
////
////        //fill log/reg form
//////        WebElement email = wd.findElement(By.xpath("//input[@placeholder='Email']"));
////        WebElement emailInput = wd.findElement(By.xpath("//input[1]"));
////        emailInput.click();
////        emailInput.clear();
////        emailInput.sendKeys("TestOlga@mail.co");
////
////        WebElement passInput = wd.findElement(By.xpath("//input[2]"));
////        passInput.click();
////        passInput.clear();
////        passInput.sendKeys("12345Qwert-");
////
////        //click Login button
////        wd.findElement(By.xpath("//button[1]")).click();
//
////        HW7
//        String email = "0612test@mail.com";
//        String password = "14253Asd@";
//        app.getUser().openLoginRegistrationForm();
//        app.getUser().fillLoginRegistrationForm(email, password);
//        app.getUser().submitLogin();
//
//        //Assert
//        app.getUser().pause(5);
//        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//a[@href='/add']")));
//    }

//      HW8
    public void loginPositiveTest() {
        User data = new User().withEmail("0612test@mail.com").withPassword("14253Asd@");
        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(data);
        app.getUser().submitLogin();

        app.getUser().pause(5);
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//a[@href='/add']")));
    }

    @AfterMethod
    public void tearDown() {
//        wd.quit();
    }
}
