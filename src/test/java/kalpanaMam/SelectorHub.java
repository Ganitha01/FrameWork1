package kalpanaMam;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SelectorHub {
@Test
public void exploreApplication()
{
	WebDriver driver=new ChromeDriver();
	driver.get("https://selectorshub.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	
	//auto test data
	driver.findElement(By.xpath("//h2[@class='elementor-heading-title elementor-size-default']/child::a[.='AutoTestData']")).click();
	driver.findElement(By.xpath("//div[@class='elementor-widget-container']/child::h2[@class='elementor-heading-title elementor-size-default']/descendant::a[text()='AutoTestData']")).click();
	driver.findElement(By.xpath("//div[@data-id='9b49dc4']/following-sibling::div[@data-widget_type='heading.default']/descendant::a[@rel='noopener' and text()='AutoTestData']")).click();
	driver.findElement(By.xpath("//section[@data-id='2130187']/descendant::a[@rel='noopener' and text()='AutoTestData']")).click();
	driver.findElement(By.xpath("//section[@data-id='2130187']/descendant::a[@href='https://autotestdata.com/' and text()='AutoTestData']")).click();
	
	//PropertyName fullname
	
	driver.findElement(By.xpath("//input[@value='full_name']")).sendKeys("anitha");
	driver.findElement(By.xpath("//div[@class='at-frame']/descendant::input[@value='full_name']")).sendKeys("anitha");
	driver.findElement(By.xpath("//div[@class='row pt-row pt-data-row mt-2 mb-4 ui-sortable-handle']/descendant::input[@value='full_name']")).sendKeys("anitha");
	driver.findElement(By.xpath("//div[@class='col at-col-2 mt-auto']/following-sibling::div[@class='col at-col-3 mt-auto dy-ele']/descendant::input[@value='full_name']")).sendKeys("anitha");
	driver.findElement(By.xpath("//input[@class='form-control property-name' and @value='full_name']")).sendKeys("anitha");
	
	
	//all check box
	
	driver.findElement(By.xpath("//div[@class='input-group select-all-checks checked-box-p']")).click();
	driver.findElement(By.xpath("//div[@id='heading']//div[@class='input-group select-all-checks checked-box-p']")).click();
	driver.findElement(By.xpath("//div[@id='property-table']//div[@id='heading']/descendant::div[@class='input-group select-all-checks checked-box-p']")).click();
	driver.findElement(By.xpath("//div[@class='at-frame']/descendant::div[@class='input-group select-all-checks checked-box-p']")).click();
	
	//user table
	
	driver.findElement(By.xpath("//td[.='Jasmine.Morgan']")).getText();
	driver.findElement(By.xpath("//tbody//tr[@class='usr_acn']//td[4][contains(text(),'Jasmine Morgan')]/preceding-sibling::td[2][@class='left']/child::a[@href='https://bit.ly/shub_training_udemy']")).getText();
	driver.findElement(By.xpath("//td[contains(text(),'Jasmine Morgan')]/preceding-sibling::td[2][@class='left']/child::a[@href='https://bit.ly/shub_training_udemy']")).getText();
	driver.findElement(By.xpath("//td[text()='Enabled']/preceding-sibling::td[contains(text(),'Jasmine Morgan')]/preceding-sibling::td[2][@class='left']/child::a[@href='https://bit.ly/shub_training_udemy']")).getText();
	driver.findElement(By.xpath("//td[text()='ESS']/following-sibling::td[contains(text(),'Jasmine Morgan')]/preceding-sibling::td[2][@class='left']/child::a[@href='https://bit.ly/shub_training_udemy']")).getText();
	
	//Employee name
	
	driver.findElement(By.xpath("//a[@href='https://www.youtube.com/c/SelectorsHub?sub_confirmation=1']/parent::td[@class='left']/following-sibling::td[text()='Admin']/following-sibling::td[1]")).getText();
	driver.findElement(By.xpath("//td[text()='Admin']/following-sibling::td[1]")).getText();
	driver.findElement(By.xpath("//td[@class='left']/following-sibling::td[text()='Admin']/following-sibling::td[1]")).getText();
	
	
	
	//principal loan amount
	
	driver.findElement(By.xpath("//*[name()='tspan' and text()='Principal Loan Amount: 46.3%']"));
	driver.findElement(By.xpath("//*[name()='text' and @style='color:#333333;cursor:default;font-size:12px;fill:#333333;']/*[local-name()='tspan' and text()='Principal Loan Amount: 46.3%']"));
	driver.findElement(By.xpath("//*[name()='g' and @transform='translate(135,129)']/*[name()='text' and @style='color:#333333;cursor:default;font-size:12px;fill:#333333;']/*[local-name()='tspan' and text()='Principal Loan Amount: 46.3%']"));
	
	
	//Amazon iphone11 price
	
	driver.findElement(By.xpath("//span[.='53,999']"));
	driver.findElement(By.xpath("//span[contains(text(),'        Apple iPhone 12 (64GB) - Black       ')]/ancestor::div[@id='title_feature_div']/following-sibling::div[@id='apex_desktop']/descendant::span[@class='a-price-whole']"));
	driver.findElement(By.xpath("//div[@id='centerCol']/descendant::span[@class='a-price-whole']"));
	
	
	//money redif
	
	driver.findElement(By.xpath("//span[@class='stockname']/child::a[text()='S&P BSE Sensex']/ancestor::div[@class='indicesdtls dwn']/descendant::span[@class='stock_change']"));
	driver.findElement(By.xpath("//a[text()='S&P BSE Oil & Gas']/ancestor::div[@class='indicesdtls dwn']/descendant::span[@class='stock_change']"));
	driver.findElement(By.xpath("//a[text()='S&P BSE Oil & Gas']/parent::span[@class=\"stockname\"]/following-sibling::span[@class=\"stock_change\"]"));
	
	
	//nse indices
	
	driver.findElement(By.xpath("//div[@id='div_nseindices']/child::div[@class=\"hmtable1\"]/descendant::a[.='NIFTY 50']/parent::li/following-sibling::li[@class=\"alignR\"]")).getText();
	driver.findElement(By.xpath("//a[.='NIFTY 50']/parent::li/following-sibling::li[@class=\"alignR\"]"));
	driver.findElement(By.xpath("//div[@id='div_nseindices']/descendant::a[.='NIFTY 50']/parent::li/following-sibling::li[@class=\"alignR\"]"));
	
	
	//most traded companies
	
	driver.findElement(By.xpath("//b[.='MOST TRADED COMPANIES']/ancestor::div[@class='hmtable2']/descendant::ul[2]/descendant::a[@href='//money.rediff.com/companies/Suzlon-Energy-Ltd/15130070']")).getText();
	driver.findElement(By.xpath("//ancestor::div[@class='hmtable2']/descendant::ul[2]/descendant::a[@href='//money.rediff.com/companies/Suzlon-Energy-Ltd/15130070']")).getText();
	
	//calender date selection
	driver.findElement(By.xpath("//div[@class=\"bui-calendar carousel-extended-dates-calendar-www\"]/descendant::div[contains(text(),\"July\")]/parent::div[@class=\"bui-calendar__wrapper\"]/descendant::span[.='10']"));
	driver.findElement(By.xpath("//div[contains(text(),\"July\")]/parent::div[@class=\"bui-calendar__wrapper\"]/descendant::span[.='10']"));
	driver.findElement(By.xpath("//div[@class=\"bui-calendar carousel-extended-dates-calendar-www\"]/descendant::div[contains(text(),\"July\")]/following-sibling::table[@class=\"bui-calendar__dates\"]/descendant::span[text()='1']"));
	driver.findElement(By.xpath("//span[@aria-label=\"20 August 2024\"]"));
	driver.findElement(By.xpath("//thead[@class=\"bui-calendar__row\"]/following-sibling::tbody/descendant::span[@aria-label=\"12 July 2024\"]"));
	
	
	
	
}
}
