package utils;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ExcelUtils {
    static HSSFWorkbook workbook;
    static HSSFSheet sheet;

    public ExcelUtils(String excelPath,String sheetName){

        try {
            InputStream file= new FileInputStream(excelPath);
            workbook=new HSSFWorkbook(file);
            sheet= workbook.getSheet(sheetName);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void getCellData(int rowNum,int colNum){
            DataFormatter formatter=new DataFormatter();
            Object value=formatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum));
            System.out.println(value);
    }

    public static void getRowCount(){
            int rowCount=sheet.getPhysicalNumberOfRows();
            System.out.println("No of Rows: "+rowCount);
    }


}
