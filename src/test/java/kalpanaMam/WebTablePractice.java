package kalpanaMam;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WebTablePractice {
	@Test
	public void getText()
	{
		WebDriver driver=new ChromeDriver();
		
		driver.get("http://www.techlistic.com/2017/02/automate-demo-web-table-with-selenium.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String data=driver.findElement(By.xpath("(//table[@class='tsc_table_s13']/descendant::tr[@style='margin:0;padding:0'])[1]")).getText();
		System.out.println(data);
		
	}

}
