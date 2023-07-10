package excelfile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WriteDateToexcel {

	public static void main(String[] args) throws IOException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//coping all links to excel sheet
		List<WebElement> links=driver.findElements(By.xpath("//a"));
		FileInputStream fis=new FileInputStream(".//src/test/resources/TestData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet("Sheet1");

		for(int i=0;i<links.size();i++)
		{Row row=sh.createRow(i);
			Cell cell=row.createCell(0);
			cell.setCellValue(links.get(i).getAttribute("href"));
		}
		
		FileOutputStream fos=new FileOutputStream(".//src/test/resources/TestData.xlsx");
		wb.write(fos);
		wb.close();
		
		//display all links to console from excel
		
		for(int i=0;i<links.size();i++)
		{
		Row row=sh.getRow(i);
		Cell cell=row.getCell(0);
		String data=cell.getStringCellValue();
		System.out.println(data);
		DataFormatter df=new DataFormatter();
		String data1=df.formatCellValue(cell);
		System.out.println(data1);
		}
		

	}

}
