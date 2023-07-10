package kalpanaMam;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Flipkart {
	@Test
	public void clickOnSamsungS20() throws Exception
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement close=driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']"));
		if(close.isDisplayed())
		{
		close.click();
		}
		else {

		}
		Thread.sleep(2000);
		WebElement searchBar=driver.findElement(By.xpath("//input[@class='_3704LK']"));
		searchBar.sendKeys("samsung s20");
		List<WebElement> element=driver.findElements(By.xpath("//ul[@class='_1sFryS _2x2Mmc _3ofZy1']/descendant::div[@class='YGcVZO _2VHNef']"));
		for(int i=0;i<element.size();i++)
		{
			String name=element.get(i).getText();
			System.out.println(name);
			//if(name.equalsIgnoreCase("samsung s20"));
			//element.get(i).click();
				
		}
		
	//	driver.close();
	}

}
