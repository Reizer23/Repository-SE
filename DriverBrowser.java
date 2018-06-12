package utils;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class DriverBrowser {

    protected static WebDriver driver;
    protected static String baseUrl;
    public static ExtentReports report;
    public static ExtentTest test;

    public static void driverBrowser(String browserType) throws FileNotFoundException, IOException{

        String osName = (System.getProperty("os.name").toLowerCase().contains("mac") ? "mac" : "windows");
        if (browserType.equals("chrome")) {
            Path currentRelativePath = Paths.get("");
            String pathToDriver = currentRelativePath.toAbsolutePath().toString() +
                    File.separator + "DriverEXE" + File.separator;
            if (osName.equals("windows")) {
                System.setProperty("webdriver.chrome.driver", pathToDriver + "chromedriver.exe");
            } else {
                System.setProperty("webdriver.chrome.driver", pathToDriver + "chromedriver");
            }
            driver = new ChromeDriver();
        }

        baseUrl = "https://ccmmoduletest.pouncecorp.com/";

        Path currentRelativePath = Paths.get("");
        String pathToReports = currentRelativePath.toAbsolutePath().toString() +
                File.separator + "Logs" + File.separator;
        String Path = pathToReports+"CCM_W10_Test.html";
        report = new ExtentReports(Path, false);
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

    }
}
