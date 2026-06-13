package dataproviders;

import org.testng.annotations.DataProvider;

import utilities.ExcelUtil;

public class BookingDataProvider {

    @DataProvider(name = "bookingData")
    public static Object[][] getBookingData() {

        return ExcelUtil.getExcelData();
    }
}