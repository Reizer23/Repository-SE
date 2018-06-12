package pages;

import org.openqa.selenium.By;
import utils.DriverBrowser;

import java.util.concurrent.TimeUnit;

public class Logout extends DriverBrowser {

    public static void exit(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//ul[1]/li/a")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//label[text()='Email']"));
    }
}
