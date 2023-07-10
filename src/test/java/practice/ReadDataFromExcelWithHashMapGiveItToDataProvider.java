package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import smsGenericUtilities.IPathconstants;

public class ReadDataFromExcelWithHashMapGiveItToDataProvider {

	@Test(dataProvider = "readData")
	public void displayData(HashMap<Object, Object> data)
	{
		System.out.println(data.get("UserName")+" "+data.get("LastName")+" "+data.get("Password"));
		
	
	}
	@DataProvider
	public Object[][] readData() throws Exception
	{
		FileInputStream fis=new  FileInputStream(IPathconstants.excelFilePath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("username");
		int lastRow=sh.getLastRowNum();//5(0-5)
		System.out.println(lastRow);//3(1-3)
		int lastcell=sh.getRow(lastRow).getLastCellNum();
		System.out.println(lastcell);
		HashMap<Object, Object> map=new HashMap<Object, Object>();
		DataFormatter df=new DataFormatter();
		Object[][] arr=new Object[lastRow-1][1];
		for(int i=1;i<lastRow;i++)
		{
			for(int j=0;j<lastcell;j++)
			{
				String key=df.formatCellValue(sh.getRow(0).getCell(j));//0,0 -0,1 -0,2 // 
				String value=df.formatCellValue(sh.getRow(i).getCell(j));//1,0 -1,1 -1,2 // 2,0  -2,1  -2,2
				map.put(key, value);
				//System.out.println(map);
		
			}
			arr[i-1][0]=map;
			System.out.println(arr[i-1][0]);
		}
		
		for(int i=0;i<=lastRow;i++)
		{
			for(int j=0;j<1;j++)
			{
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		
		
		
		
		
		return arr;
		
		
	}
	
	

}
