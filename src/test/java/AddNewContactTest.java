import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewContactTest extends TestBase {

    @BeforeMethod
    public void preCondition() {


        if(!app.getUser().isLogged()){

            String email = "0612test@mail.com";
            String password = "14253Asd@";
            User data = new User().withEmail(email).withPassword(password);
            app.getUser().openLoginRegistrationForm();
            app.getUser().fillLoginRegistrationForm(data);
            app.getUser().submitLogin();

        }

    }

    @Test
    public void addNewContactPositiveTest() {
//        app.getContact().openContactForm();

        app.getContact().pause(3);
//        app.getContact().click(By.xpath("//a[@href='/add']"));
        app.getContact().openContactForm();

        int i = (int) (System.currentTimeMillis() / 1000) % 3600;

        String name = "Tom" + i;
        String lastName = "Tomson" + i;
        String phone = "05" + i + "6789";
        String email = "zxc" + i + "@mail.com";
        String address = "Haifa";
        String description = "friend";
        app.getContact().fillContactForm(name, lastName, phone, email, address, description);
        app.getContact().submitContact();

//      contact-item_card__2SOIM
        Assert.assertTrue(app.getContact().getText(By.xpath("//div[@class='contact-item_card__2SOIM'][last()]//h3")).equals(phone));
    }

    @AfterMethod
    public void tearDown() {

    }
}
