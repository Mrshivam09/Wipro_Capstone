package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Base.BaseClass;
import Pages.ConfirmationPage;
import Pages.FlightSelectionPage;
import Pages.HomePage;
import Pages.PurchasePage;
import dataproviders.BookingDataProvider;

@Listeners(listeners.TestListener.class)
public class FlightBookingTest extends BaseClass {

    HomePage home;
    FlightSelectionPage flight;
    PurchasePage purchase;
    ConfirmationPage confirmation;

    @BeforeMethod
    public void launchBrowser() {

        setup();
    }

    @Test(
            dataProvider = "bookingData",
            dataProviderClass = BookingDataProvider.class
    )
    public void verifyFlightBooking(

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

        // Home Page

        home = new HomePage(driver);

        home.selectDeparture(departure);
        Thread.sleep(2000);

        home.selectDestination(destination);
        Thread.sleep(2000);

        home.clickFindFlights();
        Thread.sleep(3000);

        // Flight Selection Page

        flight = new FlightSelectionPage(driver);

        Assert.assertTrue(
                flight.flightsDisplayed(),
                "Flights are not displayed");

        Thread.sleep(2000);

        flight.chooseFlight(Integer.parseInt(flightIndex));
        Thread.sleep(3000);

        // Purchase Page

        purchase = new PurchasePage(driver);

        Assert.assertTrue(
                purchase.verifyCostDisplayed(),
                "Purchase page is not displayed");

        Thread.sleep(2000);

        purchase.enterPassengerDetails(
                passengerName,
                address,
                city,
                state,
                zip,
                cardType,
                cardNumber,
                month,
                year,
                nameOnCard);

        Thread.sleep(3000);

        purchase.clickPurchaseFlight();
        Thread.sleep(5000);

        // Confirmation Page

        confirmation = new ConfirmationPage(driver);

        String actualMessage =
                confirmation.getConfirmationMessage();

        Assert.assertEquals(
                actualMessage,
                "Thank you for your purchase today!");

        Thread.sleep(2000);

        System.out.println(
                "Flight Booking Completed Successfully");

        Thread.sleep(2000);
    }

    @AfterMethod
    public void closeBrowser() {

        tearDown();
    }
}