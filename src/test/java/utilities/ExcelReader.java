package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	ConfigReader reader = new ConfigReader();

        @SuppressWarnings("resource")
		public String getTestData(String sheetName, String testCase,String Entry) throws IOException {
            XSSFWorkbook wb;
            String cellValue = "";
            File file = new File(reader.getProperty("excelFilePath")); // Update path if necessary
            FileInputStream fis = new FileInputStream(file); // obtaining bytes from the file
            XSSFWorkbook workbook;
        	FileInputStream fileInputStream = new FileInputStream(reader.getProperty("excelFilePath"));
			workbook = new XSSFWorkbook(fileInputStream);
			XSSFSheet sheet = workbook.getSheet(sheetName);
            for (Row row : sheet) {
                Cell firstCell = row.getCell(0);
                if(firstCell.getStringCellValue().equalsIgnoreCase("TestCase"))
                	continue;
                if (null!= firstCell && firstCell.getStringCellValue().equalsIgnoreCase(testCase)) {
                	if(Entry== "username")
                	{
                		if(null !=row.getCell(1))
                			cellValue= row.getCell(1).getStringCellValue();
                		else
                			cellValue = "";
                				
                	}
                	  
                	else if(Entry== "password")
                	{
                		if(null !=row.getCell(2))
                			cellValue= row.getCell(2).getStringCellValue();
                		else
                			cellValue = "";
                	}
                	else if(Entry== "ErrorMessage")
                	{
                		if(null !=row.getCell(3))
                			cellValue= row.getCell(3).getStringCellValue();
                		else
                			cellValue = "";
                	}
                	
            }
                if (null!= firstCell && firstCell.getStringCellValue().equalsIgnoreCase(testCase)) {
                	if(Entry== "batchName")
                	{
                		if(null !=row.getCell(1))
                			cellValue= row.getCell(1).getStringCellValue();
                		else
                			cellValue = "";
                				
                	}
                	  
                	else if(Entry== "classTopic")
                	{
                		if(null !=row.getCell(2))
                			cellValue= row.getCell(2).getStringCellValue();
                		else
                			cellValue = "";
                	}
                	else if(Entry== "classDescription")
                	{
                		if(null !=row.getCell(3))
                			cellValue= row.getCell(3).getStringCellValue();
                		else
                			cellValue = "";
                	}
                	else if(Entry== "noOfClasses")
                	{
                		if(null !=row.getCell(4))
                			cellValue= row.getCell(4).getStringCellValue();
                		else
                			cellValue = "";
                	}
                	else if(Entry== "comments")
                	{
                		if(null !=row.getCell(5))
                			cellValue= row.getCell(5).getStringCellValue();
                		else
                			cellValue = "";
                	}
                	else if(Entry== "notes")
                	{
                		if(null !=row.getCell(6))
                			cellValue= row.getCell(6).getStringCellValue();
                		else
                			cellValue = "";
                	}
                	else if(Entry== "recording")
                	{
                		if(null !=row.getCell(7))
                			cellValue= row.getCell(7).getStringCellValue();
                		else
                			cellValue = "";
                	}
                	
                	else if(Entry== "ErrorMessage")
                	{
                		if(null !=row.getCell(3))
                			cellValue= row.getCell(3).getStringCellValue();
                		else
                			cellValue = "";
                	}
                	
            }
            workbook.close(); // Close the workbook
            fis.close(); // Close the FileInputStream
            //return cellValue; // Return the found value
        }
			return cellValue;
}
}
