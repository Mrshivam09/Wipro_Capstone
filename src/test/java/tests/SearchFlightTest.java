package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Base.BaseClass;
import Pages.FlightSelectionPage;
import Pages.HomePage;
import dataproviders.BookingDataProvider;

@Listeners(listeners.TestListener.class)
public class SearchFlightTest extends BaseClass {

    HomePage home;
    FlightSelectionPage flight;

    @BeforeMethod
    public void launchBrowser() {

        setup();
    }

    @Test(
            dataProvider = "bookingData",
            dataProviderClass = BookingDataProvider.class
    )
    public void verifyFlightSearch(

            String departure,
            String destination,
            String passengerName,
            String address,
            String city,
            String state,
            String zip,
            String cardType,
            String cardNumber,
            String month,
            String year,
            String nameOnCard,
            String flightIndex)

            throws InterruptedException {

        home = new HomePage(driver);

        home.selectDeparture(departure);
        Thread.sleep(2000);

        home.selectDestination(destination);
        Thread.sleep(2000);

        home.clickFindFlights();
        Thread.sleep(3000);

        flight = new FlightSelectionPage(driver);

        Assert.assertTrue(
                flight.flightsDisplayed(),
                "Flights are not displayed");

        System.out.println(
                "Flight search completed successfully");

        Thread.sleep(2000);
    }

    @AfterMethod
    public void closeBrowser() {

        tearDown();
    }
}