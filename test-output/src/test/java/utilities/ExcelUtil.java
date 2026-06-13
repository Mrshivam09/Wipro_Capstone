package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

    private static final String EXCEL_PATH =
            "src/test/resources/PassengerData.xlsx";

    public static Object[][] getExcelData() {

        Object[][] data = null;

        try {

            FileInputStream fis =
                    new FileInputStream(EXCEL_PATH);

            XSSFWorkbook workbook =
                    new XSSFWorkbook(fis);

            XSSFSheet sheet =
                    workbook.getSheetAt(0);

            DataFormatter formatter =
                    new DataFormatter();

            int rowCount =
                    sheet.getLastRowNum();

            int colCount =
                    sheet.getRow(0).getLastCellNum();

            data = new Object[rowCount][colCount];

            for (int i = 1; i <= rowCount; i++) {

                for (int j = 0; j < colCount; j++) {

                    data[i - 1][j] =
                            formatter.formatCellValue(
                                    sheet.getRow(i).getCell(j));
                }
            }

            workbook.close();
            fis.close();

        } catch (IOException e) {

            e.printStackTrace();
        }

        return data;
    }
}