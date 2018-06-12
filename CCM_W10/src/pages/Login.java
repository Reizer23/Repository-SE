package pages;

import org.openqa.selenium.By;
import utils.DriverBrowser;

import java.util.concurrent.TimeUnit;

public class Login extends DriverBrowser {

    public static void login(String strUserID, String strPasswd) {

        //Username
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys(strUserID+"@pouncecorp.com");

        //Password
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys(strPasswd);

        //Log In Button
        driver.findElement(By.xpath("//input[@value='Log In']")).click();

    }
}


