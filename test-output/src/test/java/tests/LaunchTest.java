package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Base.BaseClass;

@Listeners(listeners.TestListener.class)
public class LaunchTest extends BaseClass {

    @BeforeMethod
    public void launchBrowser() {

        setup();
    }

    @Test
    public void verifyApplicationLaunch() throws InterruptedException {

        Thread.sleep(2000);

        String actualTitle = driver.getTitle();

        Assert.assertEquals(
                actualTitle,
                "BlazeDemo");

        System.out.println(
                "Application launched successfully");

        Thread.sleep(2000);
    }

    @AfterMethod
    public void closeBrowser() {

        tearDown();
    }
}
