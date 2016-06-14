import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import java.io.FileInputStream;

/**
 * Created by nako on 14/06/2016.
 */
public class ExcelUtils {

    public static void setExcelFile(String Path,String SheetName) throws Exception {
        FileInputStream ExcelFile = new FileInputStream(Path);
        Workbook excelWBook = Workbook.getWorkbook(ExcelFile);
        Sheet excelWSheet = excelWBook.getSheet(SheetName);
    }

    public static String getCellData(Sheet excelWSheet, int RowNum, int ColNum) throws Exception{
        Cell sheetCell = excelWSheet.getCell(RowNum, ColNum);
        return sheetCell.getContents();
    }
}
