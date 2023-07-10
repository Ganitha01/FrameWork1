package smsGenericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


/**
 * this class consists ofexcel related methods which are used to fetch the data and insert the data,get row num etc.
 * @author ANITHA
 *
 */
public class ExcelUtility {
	/**
	 * this method will insert the data into the excel sheet
	 * @param driver
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param data
	 * @throws IOException
	 */
	public void insertDataIntoExcel(String sheetName,int rowNum,int cellNum,String data) throws IOException
	{ FileInputStream fileInputStream=new FileInputStream(IPathconstants.excelFilePath);
	
	Workbook workbook=WorkbookFactory.create(fileInputStream);
	Sheet sheet=workbook.getSheet(sheetName);
	Row row=sheet.createRow(rowNum);
	Cell cell=row.createCell(cellNum);
	cell.setCellValue(data);
	FileOutputStream fileOutputStream=new FileOutputStream(IPathconstants.excelFilePath);
	workbook.write(fileOutputStream);
	workbook.close();
	}
	/**
	 * this method is used to fetch the data from the excel file
	 * @param driver
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @throws IOException 
	 * @throws EncryptedDocumentException 
	 */
	public String fetchDataFromExcel(String sheetName,int rowNum,int cellNum) throws IOException
	{ FileInputStream fileInputStream=new FileInputStream(IPathconstants.excelFilePath);
	Workbook workbook=WorkbookFactory.create(fileInputStream);
	Sheet sheet=workbook.getSheet(sheetName);
	Row row=sheet.getRow(rowNum);
	Cell cell=row.getCell(cellNum);
	DataFormatter dataFormatter=new DataFormatter();
			String	data=dataFormatter.formatCellValue(cell);
			return data;
		}
	/**
	 * 
	 * @param driver
	 * @throws IOException 
	 */
	public int getRowNumber(String sheetName) throws IOException
	{	FileInputStream fileInputStream=new FileInputStream(IPathconstants.excelFilePath);
	Workbook workbook=WorkbookFactory.create(fileInputStream);
	Sheet sheet=workbook.getSheet(sheetName);
	int row =sheet.getLastRowNum();
	return row;
	
		
	}
	/**
	 * this method is used to read the data from excel and give it to DataProvider method
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	public Object[][] fetchDataFromExcelGiveItToDataProvider(String sheetName) throws Throwable
	{

		FileInputStream fis=new FileInputStream(IPathconstants.excelFilePath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetName);
		int lastRow=sh.getLastRowNum();
		int lastCell=sh.getRow(lastRow).getLastCellNum();
		Object[][] arr=new Object[lastRow][lastCell];
		DataFormatter df=new DataFormatter();
		
	for(int i=0;i<lastRow;i++)
	{
		for(int j=0;j<lastCell;j++)
		{
			Cell cell=sh.getRow(i+1).getCell(j);
			arr[i][j]=df.formatCellValue(cell);
		}
	}
	
	return arr;
	}
	/**
	 * this methos is used to read the data in Key and value pair and return HashMap;
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	public HashMap<String,String> getMultipleData(String sheetName) throws Throwable
	{
		FileInputStream fis=new FileInputStream(IPathconstants.excelFilePath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetName);
		int count=sh.getLastRowNum();
		
		HashMap<String, String> map=new HashMap<String, String>();
		for(int i=0;i<=count;i++)
		{
			String key=sh.getRow(i).getCell(0).getStringCellValue();
			String value=sh.getRow(i).getCell(1).getStringCellValue();
			map.put(key, value);
		}
		
		return map;
		
	}


}
