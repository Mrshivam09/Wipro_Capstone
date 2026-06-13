package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    By departureCity =
            By.name("fromPort");

    By destinationCity =
            By.name("toPort");

    By findFlightsBtn =
            By.cssSelector("input[type='submit']");

    public void selectDeparture(String city) {

        Select dep =
                new Select(driver.findElement(departureCity));

        dep.selectByVisibleText(city);
    }

    public void selectDestination(String city) {

        Select dest =
                new Select(driver.findElement(destinationCity));

        dest.selectByVisibleText(city);
    }

    public void clickFindFlights() {

        driver.findElement(findFlightsBtn).click();
    }
}