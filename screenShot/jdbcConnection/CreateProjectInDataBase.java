package jdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.mysql.cj.jdbc.Driver;

public class CreateProjectInDataBase {

	public static void main(String[] args) throws SQLException {
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-Origins=*");
		WebDriver driver=new ChromeDriver(option);
		Connection connection=null;
		Random r=new Random();
		int num=r.nextInt(50);
		String pname="SMS"+num;
		System.out.println(pname);
	try {
		Driver driver1=new Driver();
		DriverManager.registerDriver(driver1);
		connection=DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
		Statement statement=connection.createStatement();
		
		String query="insert into project values('TY_PROJ_80+"+num+"','Anitha','13/01/2023','"+pname+"','On Going',5)";
		int result=statement.executeUpdate(query);
		if (result==1)
		{
			System.out.println("data inserted successfully");
		}
	} 
	
	finally {
		
		connection.close();
	}
	
	driver.get("http://rmgtestingserver:8084/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//login to application
	driver.findElement(By.xpath("//input[@id='usernmae']")).sendKeys("rmgyantra");
	driver.findElement(By.xpath("//input[@id='inputPassword']")).sendKeys("rmgy@9999");
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	//create new project
	driver.findElement(By.xpath("//a[.='Projects']")).click();
	WebElement element=driver.findElement(By.xpath("//div[@class='container']/descendant::td[.='"+pname+"']"));
	String projectname=element.getText();
			if(projectname.equalsIgnoreCase(pname))
			{
				System.out.println("data inserted successfully");
			}
			else
			{
				System.out.println("data not inserted");
			}
	}

}
