package kalpanaMam;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Amazon {
	@Test
	
	public void getIphonePrices() throws Throwable, IOException
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 WebElement  searchBar=driver.findElement(By.xpath("//input[@placeholder='Search Amazon.in']"));
		 searchBar.sendKeys("Iphone13");
		 searchBar.submit();
		 List<WebElement> phoneNames=driver.findElements(By.xpath("//span[contains(text(),'Apple iPhone 13')]"));
		 for(int i=0;i<phoneNames.size();i++)
		 { WebElement  name=phoneNames.get(i);
		 name.click();
			
		 }
		 String parentId=driver.getWindowHandle();
		 System.out.println(parentId);
		 
		 List<WebElement> PhoneProces=driver.findElements(By.xpath("//span[contains(text(),'Apple iPhone 13')]/ancestor::div[@class='a-section a-spacing-none puis-padding-right-small s-title-instructions-style']/following-sibling::div[@class='sg-row']/descendant::span[@class='a-price-whole']"));
		 
		 //Sent the data to excel
		 
		 FileInputStream fis=new FileInputStream("./src/test/resources/TestData.xlsx");
		 
		 Workbook wb=WorkbookFactory.create(fis);
		 
		 Sheet sh=wb.getSheet("Iphone Prices");
		 
		 for(int i=0;i<phoneNames.size();i++)
		 { String name=phoneNames.get(i).getText();
			// System.out.println(name);
			 sh.createRow(i).createCell(0).setCellValue(name);
			  String price=PhoneProces.get(i).getText();
			  sh.createRow(i).createCell(1).setCellValue(price);
		 }
		 
		 FileOutputStream fos=new FileOutputStream("./src/test/resources/TestData.xlsx");
		 wb.write(fos);
		 wb.close();
		 
		 driver.close();
		 
	}

}
