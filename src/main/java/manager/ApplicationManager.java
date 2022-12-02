package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;

public class ApplicationManager {

    WebDriver wd;
    HelperUser user;

    public HelperUser getUser() {
        return user;
    }

    public void init(){
        wd=new ChromeDriver();
        wd.navigate().to("https://telranedu.web.app/home");
        user = new HelperUser(wd);

    }

    public void stop() {
//        wd.quit();
    }

}
