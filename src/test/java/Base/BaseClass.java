package Base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

    public static WebDriver driver;

    public static void setup(String browser) {

        System.out.println("Launching Browser : " + browser);

        // Read execution mode from Maven command
        String executionMode = System.getProperty("executionMode", "local");
        boolean isHeadless = executionMode.equalsIgnoreCase("jenkins");

        if (browser.equalsIgnoreCase("chrome")) {

            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();

            if (isHeadless) {
                options.addArguments("--headless=new");
                options.addArguments("--disable-gpu");
                options.addArguments("--window-size=1920,1080");
            }

            driver = new ChromeDriver(options);

        } else if (browser.equalsIgnoreCase("firefox")) {

            WebDriverManager.firefoxdriver().setup();

            FirefoxOptions options = new FirefoxOptions();

            if (isHeadless) {
                options.addArguments("-headless");
            }

            driver = new FirefoxDriver(options);

        } else {

            throw new RuntimeException("Invalid Browser : " + browser);
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://blazedemo.com/");
    }

    public static void setup() {
        setup("chrome");
    }

    public static void tearDown() {

        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
