package utils;

import com.relevantcodes.extentreports.LogStatus;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFile extends DriverBrowser {

    public static List<String> dataFile = new ArrayList<String>();

    public static void readFile(String file, String className) throws FileNotFoundException, IOException {
        String data;
        FileReader f = new FileReader(file);
        BufferedReader b = new BufferedReader(f);
        while((data = b.readLine())!=null) {
            //System.out.println(data);
            dataFile.add(data);
        }
        test = report.startTest(className + " Suite - " + ReadFile.dataFile.get(1));
        b.close();
    }

    public static boolean writeFile(String file) throws IOException {
        int NewAccountCount = Integer.parseInt(ReadFile.dataFile.get(0));
        int ActualUserCount = Integer.parseInt(ReadFile.dataFile.get(1));

        if(ActualUserCount<=NewAccountCount-1) {
            String testCount = String.valueOf(ActualUserCount+1);
            dataFile.set(1, testCount);
        }else {
            test.log(LogStatus.WARNING, "You Must Create New User");
            return false;
        }

        FileWriter f = new FileWriter(file);
        PrintWriter pw = new PrintWriter(f);
        try{
            for(String x: dataFile)
                pw.println(x);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != f)
                    f.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return true;

    }

}