package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperContact extends HelperBase {

    public HelperContact(WebDriver wd) {
        super(wd);
    }

    public void openContactForm() {
        click(By.xpath("//a[@href='/add']"));
    }

    public void fillContactForm(String name,String lastName,String phone, String email, String address, String description) {

        type(By.xpath("//input[1]"),name);
        type(By.xpath("//input[2]"),lastName);
        type(By.xpath("//input[3]"),phone);
        type(By.xpath("//input[4]"),email);
        type(By.xpath("//input[5]"),address);
        type(By.xpath("//input[6]"),description);

    }

    public void submitContact(){
//        click(By.xpath("//b[text()='Save']"));
        click(By.xpath("//div[@class='add_form__2rsm2']//button"));
    }
}
