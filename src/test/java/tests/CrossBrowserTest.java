package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Base.BaseClass;

@Listeners(listeners.TestListener.class)
public class CrossBrowserTest extends BaseClass {

    @Parameters("browser")
    @BeforeMethod
    public void launchBrowser(String browser) {

        setup(browser);
    }

    @Test
    public void verifyApplicationOnDifferentBrowsers()
            throws InterruptedException {

        Thread.sleep(3000);

        Assert.assertEquals(driver.getTitle(), "BlazeDemo");

        System.out.println("Application launched successfully");

        Thread.sleep(2000);
    }

    @AfterMethod
    public void closeBrowser() {

        tearDown();
    }
}