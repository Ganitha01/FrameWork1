package dataProviderPractice;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import smsGenericUtilities.IPathconstants;

public class Practice {
	@Test(dataProviderClass =DataProviderSample.class,dataProvider = "data4" )
	public void readDataFrom4x4(String fruit,String colour,int price,String qty)
	{
		System.out.println(fruit+"\t"+colour+"\t"+price+"\t"+qty);
	}
	
	@Test(dataProviderClass =DataProviderSample.class,dataProvider = "data5" )
	public void readDataFrom4x5(String Phone,String model,String colour,String price,String discout)
	{
		System.out.println(Phone+"\t"+model+"\t"+colour+"\t"+price+"\t"+discout);
	}

	
	
	@DataProvider
	public Object[][] readDataFromExcel1() throws Throwable
	{
		FileInputStream fis=new FileInputStream(IPathconstants.excelFilePath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("dataProvider");
		int lastRow=sh.getLastRowNum();
		int lastCell=sh.getRow(lastRow).getLastCellNum();
		System.out.println(lastRow+" "+lastCell);
		Object[][] arr=new Object[lastRow+1][lastCell];
		DataFormatter df=new DataFormatter();
		
	for(int i=0;i<=lastRow;i++)
	{
		for(int j=0;j<lastCell;j++)
		{
			Cell cell=sh.getRow(i).getCell(j);
			arr[i][j]=df.formatCellValue(cell);
		}
	}
	
	return arr;
		
	}
	
}
