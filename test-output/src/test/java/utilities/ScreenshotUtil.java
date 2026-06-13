package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import Base.BaseClass;

public class ScreenshotUtil extends BaseClass {

    public static void captureScreenshot(String testName) {

        try {

            if (driver == null) {

                System.out.println(
                        "Driver is null. Screenshot skipped.");

                return;
            }

            TakesScreenshot ts =
                    (TakesScreenshot) driver;

            File source =
                    ts.getScreenshotAs(OutputType.FILE);

            String timeStamp =
                    new SimpleDateFormat("yyyyMMdd_HHmmss")
                            .format(new Date());

            File destination =
                    new File("./Screenshots/"
                            + testName + "_"
                            + timeStamp + ".png");

            FileUtils.copyFile(source, destination);

            System.out.println(
                    "Screenshot saved successfully.");

        } catch (IOException e) {

            e.printStackTrace();

        } catch (Exception e) {

            System.out.println(
                    "Screenshot capture failed: "
                            + e.getMessage());
        }
    }
}