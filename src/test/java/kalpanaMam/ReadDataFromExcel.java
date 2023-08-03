package kalpanaMam;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.LinkedHashSet;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ReadDataFromExcel {
	@Test
	public void printing() throws EncryptedDocumentException, Exception
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		int lastRowNum=wb.getSheet("Sheet1").getLastRowNum();
		int lastCellNum=wb.getSheet("Sheet1").getRow(0).getLastCellNum();
		LinkedHashSet<String> set=new LinkedHashSet<String>();
		DataFormatter df=new DataFormatter();
		for(int i=0;i<=lastRowNum;i++)
		{
			for (int j = 0; j < lastCellNum; j++) {
		Cell cel=wb.getSheet("Sheet1").getRow(i).getCell(j);
				String data=df.formatCellValue(cel);
		System.out.println(data);
		}
		}
		
//		java.util.Iterator<String> itr=set.iterator();
//		while(itr.hasNext())
//		{
//			System.out.println(itr.next());
//		}
	}

}
