package excelfile;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class rough {

	public static void main(String[] args) throws Exception {
		FileInputStream fis=new FileInputStream(".//src/test/resources/TestData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("Sheet1");
		int row=sh.getLastRowNum();
		
		System.out.println(row);

	}

}
