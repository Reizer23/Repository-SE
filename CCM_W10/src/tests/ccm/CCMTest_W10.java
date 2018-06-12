package tests.ccm;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.Billing;
import pages.Login;
import utils.DriverBrowser;
import utils.ReadFile;
import utils.Screenshots;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CCMTest_W10 extends DriverBrowser {

    @Test(description = "Workflow 9")
    private void CCM_W9() throws Exception{

        System.out.println("Running CCM Test");
        String className = CCMTest_W10.class.getSimpleName();
        DriverBrowser.driverBrowser("chrome"); //Start App

        String pathToCountFile = "C:\\svn\\pe_connequity\\automation-workspace\\CCM\\CCM_CountFile\\count.txt";

        //Read File (New Account Count, Email, Password, Current User Count)
        ReadFile.readFile(pathToCountFile,className);

        test.log(LogStatus.INFO, "Web Application Opened");
        //Login.login(ReadFile.dataFile.get(2)+ReadFile.dataFile.get(1), ReadFile.dataFile.get(3));
        Login.login("cristina.aguiar+practice8","Password1");

        billingPage();
        test.log(LogStatus.PASS, "Billing page completed");
        patientsPage();
        test.log(LogStatus.PASS, "Workflow 10 completed");
    }

    private void billingPage() throws InterruptedException {

        test.log(LogStatus.INFO, "Billing page");
        Thread.sleep(11000);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.linkText("Billing")).click();
        Billing.reportType("Summary");
        test.log(LogStatus.INFO, "Summary Report completed");
        Billing.reportType("Details");
        test.log(LogStatus.INFO, "Details Report completed");

    }

    private void patientsPage() throws InterruptedException {
        Thread.sleep(11000);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//span[text()='Patients']")).click();
        Billing.enrolledPatient();
    }

    @AfterMethod
    public void tearDown(ITestResult testResult) throws IOException, InterruptedException {
        if(testResult.getStatus() == ITestResult.FAILURE){
            String path = Screenshots.takeScreenshot(driver, testResult.getName());
            String imagePath = test.addScreenCapture(path);
            test.log(LogStatus.FAIL, "Verify Img, Test Failed", imagePath);
        }
        Thread.sleep(3500);
        driver.quit();
        report.endTest(test);
        report.flush();
    }

    @AfterClass
    public void afterClass() {
        System.out.println("End of the Test");
    }
}
