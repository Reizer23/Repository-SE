package pages;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.DriverBrowser;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Billing extends DriverBrowser {

    public static void reportType(String reportType) throws InterruptedException {

        Thread.sleep(3000);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement element = driver.findElement(By.xpath("//select[@name='type']"));
        List<WebElement> results = element.findElements(By.tagName("option"));

        Thread.sleep(1000);
        for (WebElement result : results) {
            if (result.getText().contains(reportType)) {
                result.click();
            }
        }
        driver.findElement(By.linkText("Generate Report")).click();
    }

    public static void enrolledPatient() throws InterruptedException {

        Thread.sleep(10000);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.linkText("Test Test")).click();

        Thread.sleep(16000);
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.findElement(By.linkText("View Care Plan")).click();
        Thread.sleep(17000);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//div[@class='well info-bar']/div")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Download Careplan For Patient')]")).click();
        test.log(LogStatus.PASS, "Care plan Downloaded");
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@class='well info-bar']/div")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Download Careplan For Practice')]")).click();
        test.log(LogStatus.PASS, "Care plan Downloaded");
    }
}