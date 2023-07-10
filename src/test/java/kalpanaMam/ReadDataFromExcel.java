package kalpanaMam;

import java.io.FileInputStream;
import java.util.LinkedHashSet;
import org.apache.poi.EncryptedDocumentException;
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
		LinkedHashSet<String> set=new LinkedHashSet<String>();
		for(int i=0;i<=lastRowNum;i++)
		{
		String data=wb.getSheet("Sheet1").getRow(i).getCell(0).getStringCellValue();
		set.add(data);
		}
		
		java.util.Iterator<String> itr=set.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
	}

}
