package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FlightSelectionPage {

    WebDriver driver;

    public FlightSelectionPage(WebDriver driver) {
        this.driver = driver;
    }

    By flightsTable =
            By.xpath("//table");

    public boolean flightsDisplayed() {

        return driver.findElement(flightsTable)
                .isDisplayed();
    }

    public void chooseFlight(int flightIndex)
            throws InterruptedException {

        driver.findElement(
                By.xpath("(//input[@value='Choose This Flight'])[" 
                + flightIndex + "]"))
                .click();

        Thread.sleep(2000);
    }
}