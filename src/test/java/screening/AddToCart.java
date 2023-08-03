package screening;

import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AddToCart {
	@Test
	public void addTocart() throws InterruptedException
	{
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement searchBar=driver.findElement(By.xpath("//input[@placeholder=\"Search Amazon.in\"]"));
		searchBar.sendKeys("iphone 11");
		searchBar.submit();
		driver.findElement(By.xpath("//div[@data-asin=\"B08L5VJYV7\"]/descendant::a[@class=\"a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal\"]")).click();

		Thread.sleep(3000);
		Set<String> windows=driver.getWindowHandles();
		
		for(String win:windows)
		{
			
			String title=driver.switchTo().window(win).getTitle();
			System.out.println(title);
			if(title.contains("Apple iPhone 12"))
			break;
		}
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value=\"Add to Cart\"]")).click();
	}

}
