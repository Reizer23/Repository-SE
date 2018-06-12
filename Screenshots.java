package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Screenshots extends TestListenerAdapter {

    public static String takeScreenshot(WebDriver driver, String fileName) throws IOException {
        fileName = fileName + "-practice" + ReadFile.dataFile.get(1) +".png";
        Path currentRelativePath = Paths.get("");
        String pathToDriver = currentRelativePath.toAbsolutePath().toString() +
                File.separator + "ScreenShots" + File.separator;
        String directory = pathToDriver;
        File sourceFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(sourceFile, new File(directory + fileName));
        String destination = directory + fileName;
        return destination;
    }

}