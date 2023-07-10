package kalpanaMam;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class CosmoCode {
	@Test
	public void launchApplication() throws Throwable
	{
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://cosmocode.io/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notificaions=*");
		driver.findElement(By.xpath("//div[@class='inside-navigation']/descendant::a[.='More']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='inside-navigation']/descendant::a[.='More']/following-sibling::ul[@class='mega-sub-menu']/child::li[.='Automation Practice | WebTable']")).click();
		List<WebElement> countries=driver.findElements(By.xpath("//td[contains(text(),'Dollar')]/following-sibling::td[contains(text(),'English')]/preceding-sibling::td[@style='width: 134.667px;']/child::strong"));
		
		for(int i=0;i<countries.size();i++)
		{
			System.out.println(countries.get(i).getText());
		}
	}

}
