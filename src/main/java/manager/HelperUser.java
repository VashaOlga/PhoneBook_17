package manager;

import models.User;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperUser extends HelperBase {

    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void submitLogin() {
        click(By.xpath("//button[1]"));
    }

    public void submitRegistration() {
        click(By.xpath("//button[2]"));
    }

    public boolean isLogged(){
        return isElementPresent(By.xpath("//a[@href='/add']"));
    }

    public void logout(){
        click(By.xpath("//button"));
    }

    public void openLoginRegistrationForm(){
        click(By.xpath("//a[text()='LOGIN']"));
    }

//    public void fillLoginRegistrationForm(String email, String password){
//        type(By.xpath("//input[1]"),email);
//        type(By.xpath("//input[2]"),password);
//    }

//    HW8
    public void fillLoginRegistrationForm(User data){
        type(By.xpath("//input[1]"),data.getEmail());
        type(By.xpath("//input[2]"), data.getPassword());
    }

    public boolean isAlertPresent() {
        Alert alert = new WebDriverWait(wd, 10).until(ExpectedConditions.alertIsPresent());
        if(alert==null) {
            return false;
        }else {
            wd.switchTo().alert();
//            System.out.println(alert.getText());
            alert.accept();
            return true;
        }
    }

    public boolean isErrorMessageInFormat(String errorMessage){
        Alert alert = new WebDriverWait(wd, 10).until(ExpectedConditions.alertIsPresent());
//        String errorMessage = "Wrong email or password";
        return alert.getText().contains(errorMessage);
    }
}
