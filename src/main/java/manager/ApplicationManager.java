package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;

public class ApplicationManager {

    WebDriver wd;
    HelperUser user;
    HelperContact contact;

    public HelperUser getUser() {
        return user;
    }

    public HelperContact getContact() {
        return contact;
    }

    public void init(){
        wd=new ChromeDriver();
        wd.navigate().to("https://telranedu.web.app/home");
        user = new HelperUser(wd);
        contact = new HelperContact(wd);

    }

    public void stop() {
//        wd.quit();
    }

}
