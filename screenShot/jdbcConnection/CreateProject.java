package jdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Duration;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import com.mysql.jdbc.Driver;
public class CreateProject {

	public static void main(String[] args) throws Exception {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-Origins=*");
		WebDriver driver=new ChromeDriver(option);
		driver.get("http://rmgtestingserver:8084/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	//login to application
		driver.findElement(By.xpath("//input[@id='usernmae']")).sendKeys("rmgyantra");
		driver.findElement(By.xpath("//input[@id='inputPassword']")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		//create new project
		driver.findElement(By.xpath("//a[.='Projects']")).click();
		driver.findElement(By.xpath("//span[.='Create Project']")).click();
		Random r=new Random();
		int num=r.nextInt(50);
		String pname="SMS"+num;
		//enter project name,project manager
		driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys(pname);
		driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("RAVI");
		WebElement element=driver.findElement(By.xpath("//div[@class='ReactModal__Content ReactModal__Content--after-open']/descendant::select[@name='status']"));
		Select s=new Select(element);
		s.selectByVisibleText("On Gogin");
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();
		
		//check data is created 
		Connection connection=null;
		try {
			Driver driver1=new Driver();
			DriverManager.registerDriver(driver1);
			connection=DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
			Statement statement=connection.createStatement();
			ResultSet result=statement.executeQuery("select * from project");
			boolean flag=false;
			while(result.next())
			{
				String data=result.getString(4);
				System.out.println(data);
				if(data.contains(pname))
				{
					System.out.println("project created successfully");
					flag=true;
				}
				
			}
			if(!flag)
			{
				System.out.println("project not created");
			}
			
			
		} finally {
			connection.close();
		}
		
		

	}

}
