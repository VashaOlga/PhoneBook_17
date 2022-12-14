import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest extends TestBase {
//    WebDriver wd;
//
    @BeforeMethod
    public void preCondition(){
        if(app.getUser().isLogged()){
            app.getUser().logout();
        }
    }

    @Test
    public void registrationPositiveTest() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String email = "zxc" + i + "@mail.com";
        String password = "14253Asd@";
        User data = new User().withEmail(email).withPassword(password);

        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(data);
        app.getUser().submitRegistration();

        app.getUser().pause(5);
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//button")));

    }

    @Test
    public void registrationWrongEmailWithoutStrudel() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String email = "zxc" + i + "mail.com";
        String password = "14253Asd@";
        User data = new User().withEmail(email).withPassword(password);

        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(data);
        app.getUser().submitRegistration();

        app.getUser().pause(3);
//        Assert.assertFalse(app.getUser().isElementPresent(By.xpath("//button")));
        Assert.assertTrue(app.getUser().isErrorMessageInFormat("Wrong email or password"));
        Assert.assertTrue(app.getUser().isAlertPresent());
    }

    @Test
    public void registrationWrongEmailWithoutPoint() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String email = "zxc" + i + "@mailcom";
        String password = "14253Asd@";
        User data = new User().withEmail(email).withPassword(password);

        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(data);
        app.getUser().submitRegistration();

        app.getUser().pause(3);
//        Assert.assertFalse(app.getUser().isElementPresent(By.xpath("//button")));
        Assert.assertTrue(app.getUser().isErrorMessageInFormat("Wrong email or password"));
        Assert.assertTrue(app.getUser().isAlertPresent());
    }

    @Test
    public void registrationUserAlreadyExist() {
        User data = new User().withEmail("0612test@mail.com").withPassword("14253Asd@");

        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(data);
        app.getUser().submitRegistration();

        app.getUser().pause(3);
//        Assert.assertFalse(app.getUser().isElementPresent(By.xpath("//button")));
        Assert.assertTrue(app.getUser().isErrorMessageInFormat("User already exist"));
        Assert.assertTrue(app.getUser().isAlertPresent());
    }

    @Test
    public void registrationWrongPasswordWithoutDigits() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String email = "zxc" + i + "@mail.com";
        String password = "Asd@";
        User data = new User().withEmail(email).withPassword(password);

        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(data);
        app.getUser().submitRegistration();

        app.getUser().pause(3);
//        Assert.assertFalse(app.getUser().isElementPresent(By.xpath("//button")));
        Assert.assertTrue(app.getUser().isErrorMessageInFormat("Wrong email or password"));
        Assert.assertTrue(app.getUser().isAlertPresent());
    }

    @Test
    public void registrationWrongPasswordOnlyLowercaseLetters() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String email = "zxc" + i + "@mail.com";
        String password = "12345asd@";
        User data = new User().withEmail(email).withPassword(password);

        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(data);
        app.getUser().submitRegistration();

        app.getUser().pause(3);
//        Assert.assertFalse(app.getUser().isElementPresent(By.xpath("//button")));
        Assert.assertTrue(app.getUser().isErrorMessageInFormat("Wrong email or password"));
        Assert.assertTrue(app.getUser().isAlertPresent());
    }

    @Test
    public void registrationWrongPasswordOnlyUppercaseLetters() {
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String email = "zxc" + i + "@mail.com";
        String password = "12345ASDF@";
        User data = new User().withEmail(email).withPassword(password);

        app.getUser().openLoginRegistrationForm();
        app.getUser().fillLoginRegistrationForm(data);
        app.getUser().submitRegistration();

        app.getUser().pause(3);
//        Assert.assertFalse(app.getUser().isElementPresent(By.xpath("//button")));
        Assert.assertTrue(app.getUser().isErrorMessageInFormat("Wrong email or password"));
        Assert.assertTrue(app.getUser().isAlertPresent());
    }

//    @AfterMethod
//    public void tearDown(){
////        wd.quit();
//    }
}
