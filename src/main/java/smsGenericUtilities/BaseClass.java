package smsGenericUtilities;

import java.sql.SQLException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import com.edu.ObjectRepository.AdminDashBoardPreviewPage;
import com.edu.ObjectRepository.LoginPage;

public class BaseClass {
	public WebDriver driver=null;
	public static WebDriver sdriver;
DataBaseUtility dutil=new DataBaseUtility();
PropertyUtility putil=new PropertyUtility();
ExcelUtility eutil=new ExcelUtility();
WebDriverutility wutil=new WebDriverutility();
	@BeforeSuite(alwaysRun = true)
	public void configure_BS() throws SQLException
	{
//		Connection connection=dutil.openDataBaseConnection();
//		Statement statement=connection.createStatement();
//		ResultSet data=statement.executeQuery("select * from anitha");
		System.out.println("---dataBase connected successully---");
	}
	//@BeforeTest(alwaysRun = true)
	//@Parameters("BROWSER")
	@BeforeClass(alwaysRun = true)
	public void Configure_BC(/*String Browser*/) throws Throwable
	{	
		String Browser=putil.fetchDataFromPropertiesFile("browser");
		
		if(Browser.equalsIgnoreCase("chrome"))
		{
			//WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(Browser.equalsIgnoreCase("FireFox"))
		{
			//WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(Browser.equalsIgnoreCase("Edge"))
		{
			//WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else
		{
			//WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		sdriver=driver;
		System.out.println("Browser launched successfully");
	}
	@BeforeMethod(alwaysRun = true)
	public void configure_BM() throws Throwable
	{	String URL=putil.fetchDataFromPropertiesFile("url");
		String PASSWORD=putil.fetchDataFromPropertiesFile("password");
		String ADMINUSERNAME=putil.fetchDataFromPropertiesFile("adminusername");
		driver.get(URL);
		driver.manage().window().maximize();
		wutil.waitTillPageGetLoad(driver);
		LoginPage lpage=new LoginPage(driver);
		lpage.loginToApplication(ADMINUSERNAME,PASSWORD);
		String url=driver.getCurrentUrl();
		if(url.contains("dashboard"))
		{
			System.out.println("Admin Dash board page displayed successfully");
		}
		else
		{
			System.out.println("Admin Dash board page not displayed");
		}
		}
	@AfterMethod(alwaysRun = true)
	public void configure_AM() throws Throwable
	{Thread.sleep(3000);
		AdminDashBoardPreviewPage  adpPage=new AdminDashBoardPreviewPage(driver);                                                                              
		adpPage.signOutAdminLogin(wutil,driver); 
		System.out.println("logout the application successfully");
	}
	//@AfterTest(alwaysRun = true)
	@AfterClass(alwaysRun = true)
	public void configure_AC()
	{
		driver.quit();
		System.out.println("Browser closed successfully");
		
	}
	@AfterSuite(alwaysRun = true)
	public void configure_AS()
	{
		System.out.println("data Base connection close successfully");
	}	
}
