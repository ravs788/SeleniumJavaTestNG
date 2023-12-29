package com.saucedemo.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;



public class ExcelUtility {

    @DataProvider(name="data")
    public static Object[][] ReadExcelData(Method method) throws IOException
    {
        String fileName = null;
        String sheetName = null;
        if(method.getName().equals("loginSU"))
        {
            fileName = "testData_su.xlsx";
            sheetName = "testData";
        }
        else if(method.getName().equals("testStandardUser"))
        {
            fileName = "testData_su.xlsx";
            sheetName = "testData";
        }
        else if(method.getName().equals("loginPU"))
        {
            fileName = "testData_pu.xlsx";
            sheetName = "testData";
        }
        else if(method.getName().equals("testProblemUser"))
        {
            fileName = "testData_pu.xlsx";
            sheetName = "testData";
        }
        else
        {
            return new Object[][] {{"No Test Data Present"}, {"No Test Data Present"}};
        }

        // /Users/ravishankar/Desktop/Learning/Testing/SeleniumJavaTestNG/testsolution/src/test/java/data/testData_pu.xlsx
        String excelPath = System.getProperty("user.dir")+"//src//test//java//data//"+fileName;

        File file = new File(excelPath);
        FileInputStream inputStream = new FileInputStream(file);

        Workbook workbook = null;
        workbook = new XSSFWorkbook(inputStream);

        Sheet sheet = workbook.getSheet(sheetName);
        int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();
        int columnCount = sheet.getRow(0).getLastCellNum();
        Object[][] data = new Object[rowCount][columnCount];
        for(int iCounter=0; iCounter<rowCount; iCounter++)
        {
            Row row = sheet.getRow(iCounter+1);
            for(int jCounter=0; jCounter<columnCount; jCounter++)
            {
            	Cell cell = row.getCell(jCounter);
            	CellType cellType = cell.getCellType();
            	
            	if(cellType == CellType.STRING)
            		data[iCounter][jCounter] = cell.getStringCellValue();
            	else if(cellType == CellType.NUMERIC)
            		data[iCounter][jCounter] = Integer.toString((int)(cell.getNumericCellValue()));
            	else if(cellType == CellType.BOOLEAN)
            		data[iCounter][jCounter] = cell.getBooleanCellValue();
            		
            }

        }
        workbook.close();
        
        return data;
    }
}
