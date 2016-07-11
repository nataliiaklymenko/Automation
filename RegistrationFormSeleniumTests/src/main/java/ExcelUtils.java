import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by nako on 14/06/2016.
 */
public class ExcelUtils {

    public static HSSFSheet getExcelSheet(String Path, String SheetName) throws Exception {
        FileInputStream ExcelFile = new FileInputStream(Path);
        HSSFWorkbook excelWBook = new HSSFWorkbook(ExcelFile);
        return excelWBook.getSheet(SheetName);
    }

    public static String getCellData(HSSFSheet excelWSheet, int RowNum, int ColNum) {
        HSSFCell sheetCell = excelWSheet.getRow(RowNum).getCell(ColNum);
        if (sheetCell == null) return "";
        else return String.valueOf(sheetCell);
    }

    public static int getRowCount(String path, String sheetName) {
        int rowsNumbers = 0;
        try {
            HSSFSheet sheet = getExcelSheet(path, sheetName);
            rowsNumbers = sheet.getPhysicalNumberOfRows();
        } catch (Exception e) {
            Log.error(e.getMessage());
            BaseTest.bResult = false;
        }
        return rowsNumbers;
    }

    public static int getRowContains(String sTestCaseName, int colNum, String path, String sheetName) {
        int i = 0;
        try {
            HSSFSheet sheet = getExcelSheet(path, sheetName);
            int rowCount = sheet.getPhysicalNumberOfRows();
            for (i = 0; i < rowCount; i++) {
                if (ExcelUtils.getCellData(sheet, i, colNum).equalsIgnoreCase(sTestCaseName)) {
                    break;
                }
            }
        } catch (Exception e) {
            Log.error(e.getMessage());
            BaseTest.bResult = false;
        }
        return i;
    }

    public static int getTestStepsCount(String path, String sheetName, String sTestCaseID, int iTestCaseStart) {
        try {
            HSSFSheet sheet = getExcelSheet(path, sheetName);
            for (int i = iTestCaseStart; i < getRowCount(path, sheetName); i++) {
                if (!sTestCaseID.equals(ExcelUtils.getCellData(sheet, i, Constants.Col_TestCaseID))) {
                    return i;
                }
            }
            return getRowCount(path, sheetName) - 1;
        } catch (Exception e) {
            Log.error(e.getMessage());
            BaseTest.bResult = false;
            return 0;
        }
    }

    public static void setCellData(String path, String sheetName, String result, int rowNum, int colNum) throws Exception {
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            HSSFWorkbook hssfWorkbook = new HSSFWorkbook(fileInputStream);
            HSSFSheet hssfSheet = hssfWorkbook.getSheet(sheetName);
            Row row = hssfSheet.getRow(rowNum);
            Cell cell = hssfSheet.getRow(rowNum).getCell(colNum);
            if (cell == null)
                cell = row.createCell(colNum);
            cell.setCellType(Cell.CELL_TYPE_STRING);
            cell.setCellValue(result);
            FileOutputStream fileOutputStream = new FileOutputStream(new File(path));
            hssfWorkbook.write(fileOutputStream);
            fileInputStream.close();
        } catch (Exception e) {
            BaseTest.bResult = false;
        }
    }
}
