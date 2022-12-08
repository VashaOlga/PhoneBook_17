package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
}
