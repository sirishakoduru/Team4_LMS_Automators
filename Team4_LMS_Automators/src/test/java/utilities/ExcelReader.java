package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	public static int totalRow;
    public List<Map<String, String>> getData(String excelFilePath, String sheetName) throws EncryptedDocumentException, IOException {
        Workbook workbook = WorkbookFactory.create(new File(excelFilePath));
        Sheet sheet = workbook.getSheet(sheetName);
        workbook.close();
        return readSheet(sheet);
    }
    private List<Map<String, String>> readSheet(Sheet sheet) {
        Row row;
        Cell cell;
        totalRow = sheet.getLastRowNum();
        List<Map<String, String>> excelRows = new ArrayList<Map<String, String>>();
        for (int currentRow = 1; currentRow <= totalRow; currentRow++) {
            row = sheet.getRow(currentRow);
            int totalColumn = row.getLastCellNum();
            LinkedHashMap<String, String> columnMapdata = new LinkedHashMap<String, String>();
            for (int currentColumn = 0; currentColumn < totalColumn; currentColumn++) {
                cell = row.getCell(currentColumn);
                String columnHeaderName = sheet.getRow(sheet.getFirstRowNum()).getCell(currentColumn)
                        .getStringCellValue();
                columnMapdata.put(columnHeaderName, cell.getStringCellValue());
            }
            excelRows.add(columnMapdata);
        }
        return excelRows;
    }
    public int countRow() {
        return totalRow;
    }
        @SuppressWarnings("resource")
		public String getTestData(String sheetName, String testCase,String Entry) throws IOException {
            XSSFWorkbook wb;
            String cellValue = "";
            File file = new File("src/test/resources/TestData/LMS_TestData.xlsx"); // Update path if necessary
            FileInputStream fis = new FileInputStream(file); // obtaining bytes from the file
            wb = new XSSFWorkbook(fis); // creating Workbook instance that refers to .xlsx file
            XSSFSheet sheet = wb.getSheet(sheetName);
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
            wb.close(); // Close the workbook
            fis.close(); // Close the FileInputStream
            //return cellValue; // Return the found value
        }
			return cellValue;
}
}
