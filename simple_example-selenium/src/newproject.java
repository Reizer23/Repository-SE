import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class newproject {

    public static ExtentReports report;
    public static ExtentTest test;

        public static void main(String[] args) {

            System.setProperty("webdriver.chrome.driver","chromedriver.exe");
            WebDriver driver = new ChromeDriver();

            String baseUrl = "http://demo.guru99.com/test/newtours/";
            String Path = "CCM_W10_Test.html";
            report = new ExtentReports();
            String expectedTitle = "Welcome: Mercury Tours";
            String actualTitle = "";

            driver.get(baseUrl);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            actualTitle = driver.getTitle();

            if (actualTitle.contentEquals(expectedTitle)){
                System.out.println("Test Passed!");
            } else {
                System.out.println("Test Failed");
            }

            driver.close();
        }
    }
