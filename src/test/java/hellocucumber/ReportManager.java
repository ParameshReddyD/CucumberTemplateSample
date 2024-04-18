package hellocucumber;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ReportManager {

    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static Map<Long, ExtentTest> testMap = new HashMap<>();
    public static Map<String, ExtentTest> extentMap = new HashMap<>();

    public static void startReport() {

        if (htmlReporter == null) {
            String timeStamp = new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss").format(new Date());
            String dateStamp = new SimpleDateFormat("dd.MM.yyyy").format(new Date());
            htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/Reports/CucumberReports/SeleniumCucumberReport.html");
            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
            extent.setSystemInfo("Host Name", "Q-Matrix");
            extent.setSystemInfo("Environment", "Q-Matrix");
            extent.setSystemInfo("User Name", "Q-Matrix");

            htmlReporter.config().setDocumentTitle("Vtiger Application");

            htmlReporter.config().setReportName("Vtiger Application");
            htmlReporter.config().enableTimeline(true);
            // htmlReporter.config().setAutoCreateRelativePathMedia(true);

            htmlReporter.config().setTheme(Theme.DARK);

        }

    }

    public static void startTest(String testName, String categories) {

        ExtentTest test = extent.createTest(testName);
        test.assignCategory(categories);
        testMap.put(Thread.currentThread().getId(), test);
        extentMap.put(testName, test);
        System.out.print("Current Test Started");

    }


    public static void logPass(String message) {

        getCurrentTest().log(Status.PASS, message);

    }
    public static void logFail(String message) {
        getCurrentTest().log(Status.FAIL, message);
    }

    public static void logInfo(String message) {
        getCurrentTest().log(Status.INFO, message);

    }

    public static void endCurrentTest() {
        getCurrentTest().getExtent().flush();
        System.out.print("Current Test Ended");

        testMap.remove(Thread.currentThread().getId());
    }

    public static ExtentTest getCurrentTest() {
        return testMap.get(Thread.currentThread().getId());

    }

    public static void endReport() {

        extent.flush();
    }

}
