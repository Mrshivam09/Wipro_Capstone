package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class PurchasePage {

    WebDriver driver;

    public PurchasePage(WebDriver driver) {
        this.driver = driver;
    }

    By totalCost =
            By.xpath("//p[contains(text(),'Price')]");

    By name =
            By.id("inputName");

    By address =
            By.id("address");

    By city =
            By.id("city");

    By state =
            By.id("state");

    By zipCode =
            By.id("zipCode");

    By cardType =
            By.id("cardType");

    By cardNumber =
            By.id("creditCardNumber");

    By month =
            By.id("creditCardMonth");

    By year =
            By.id("creditCardYear");

    By nameOnCard =
            By.id("nameOnCard");

    By purchaseBtn =
            By.cssSelector("input[type='submit']");

    public boolean verifyCostDisplayed() {

        return driver.findElement(totalCost)
                .isDisplayed();
    }

    public void enterPassengerDetails(
            String passengerName,
            String passengerAddress,
            String passengerCity,
            String passengerState,
            String passengerZip,
            String cardTypeValue,
            String cardNo,
            String monthValue,
            String yearValue,
            String cardHolderName)
            throws InterruptedException {

        driver.findElement(name)
                .sendKeys(passengerName);
        Thread.sleep(2000);

        driver.findElement(address)
                .sendKeys(passengerAddress);
        Thread.sleep(2000);

        driver.findElement(city)
                .sendKeys(passengerCity);
        Thread.sleep(2000);

        driver.findElement(state)
                .sendKeys(passengerState);
        Thread.sleep(2000);

        driver.findElement(zipCode)
                .sendKeys(passengerZip);
        Thread.sleep(2000);

        Select select =
                new Select(driver.findElement(cardType));

        select.selectByVisibleText(cardTypeValue);
        Thread.sleep(2000);

        driver.findElement(cardNumber)
                .sendKeys(cardNo);
        Thread.sleep(2000);

        driver.findElement(month)
                .clear();
        Thread.sleep(1000);

        driver.findElement(month)
                .sendKeys(monthValue);
        Thread.sleep(2000);

        driver.findElement(year)
                .clear();
        Thread.sleep(1000);

        driver.findElement(year)
                .sendKeys(yearValue);
        Thread.sleep(2000);

        driver.findElement(nameOnCard)
                .sendKeys(cardHolderName);
        Thread.sleep(2000);
    }

    public void clickPurchaseFlight() {

        driver.findElement(purchaseBtn)
                .click();
    }
}