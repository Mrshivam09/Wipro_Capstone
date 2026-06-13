package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import utilities.ExtentManager;
import utilities.ScreenshotUtil;

public class TestListener implements ITestListener {

    ExtentReports extent = ExtentManager.getReport();
    ExtentTest test;

    @Override
    public void onTestStart(ITestResult result) {

        test = extent.createTest(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        ScreenshotUtil.captureScreenshot(result.getName() + "_PASSED");

        if (test != null) {
            test.pass("Test Passed");
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {

        ScreenshotUtil.captureScreenshot(result.getName() + "_FAILED");

        if (test != null) {
            test.fail(result.getThrowable());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        if (test != null) {
            test.skip("Test Skipped");
        }
    }

    @Override
    public void onFinish(ITestContext context) {

        extent.flush();
    }
}