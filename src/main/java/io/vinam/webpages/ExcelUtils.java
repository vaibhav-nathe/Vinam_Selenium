package io.vinam.webpages;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class ExcelUtils {

    private ExcelUtils() {
        //Non-Instantiating the Objects
    }

    private static XSSFSheet ExcelWSheet;
    private static XSSFWorkbook ExcelWBook;

    private static FileInputStream excelFile;
    private final static String DEFAULT_FILE_PATH = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources"
            + File.separator + "excel" + File.separator;

    public static Object[][] readExcelData(String fileName, String sheetName) throws Exception {
        if (!fileName.endsWith(".xlsx")) {
            fileName += ".xlsx";
        }
        final int firstRowNumber = 0;
        String[][] arrayExcelData;
        String filepath = DEFAULT_FILE_PATH + fileName;
        excelFile = new FileInputStream(filepath);
        ExcelWBook = new XSSFWorkbook(excelFile);
        ExcelWSheet = ExcelWBook.getSheet(sheetName);
        System.out.println(fileName);
        System.out.println(sheetName);
        int rowNumber = ExcelWSheet.getLastRowNum();
        int colNumber = ExcelWSheet.getRow(firstRowNumber).getLastCellNum();
        System.out.printf("rows, %d; columns, %d%n", rowNumber, colNumber);
        arrayExcelData = new String[rowNumber][colNumber];
        for (int i = 0; i < rowNumber; i++) {
            for (int j = 0; j < colNumber; j++) {
                arrayExcelData[i][j] = ExcelWSheet.getRow(i + 1).getCell(j).getStringCellValue();
            }
        }
        return arrayExcelData;
    }

}