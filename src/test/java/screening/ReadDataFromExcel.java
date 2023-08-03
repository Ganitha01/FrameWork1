package screening;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ReadDataFromExcel {
	@Test
	public void readDataFromExcel() throws IOException
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/TestData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		int lastRow=wb.getSheet("Sheet1").getLastRowNum();
		DataFormatter df=new DataFormatter();
		for(int i=0;i<=lastRow;i++)
		{
			String data=df.formatCellValue(wb.getSheet("Sheet1").getRow(i).getCell(0));
			System.out.println(data);
		}
	}

}
