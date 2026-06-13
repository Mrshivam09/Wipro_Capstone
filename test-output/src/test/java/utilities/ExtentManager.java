package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getReport() {

        if (extent == null) {

            ExtentSparkReporter spark =
                    new ExtentSparkReporter("Reports/ExtentReport.html");

            spark.config().setReportName("BlazeDemo Flight Booking Report");
            spark.config().setDocumentTitle("Automation Report");

            extent = new ExtentReports();
            extent.attachReporter(spark);

            extent.setSystemInfo("Project", "BlazeDemo Flight Booking");
            extent.setSystemInfo("Tester", "Shivam Pal");
            extent.setSystemInfo("Framework", "Selenium + TestNG");
        }

        return extent;
    }
}