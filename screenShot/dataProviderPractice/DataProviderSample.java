package dataProviderPractice;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
public class DataProviderSample {
	//data provider with 2x2
	@Test(dataProvider = "data")
	public void getData(String src,String dst )
	{
		System.out.println(src+"------"+dst);
	}

	@DataProvider
	public Object[][] data()
	{
		Object[][] arr=new Object[2][2];
		arr[0][0]="SQL";
		arr[0][1]="VENKAT SIR";
		
		arr[1][0]="MANUAL";
		arr[1][1]="PRADEEP SIR";
		return arr;
		
	}
	//data provider with 3x2
	@Test(dataProvider = "data1")
	public void getDatafrom3x2(String src,String dst)
	{
		System.out.println(src+"------"+dst);
	}
	@DataProvider
	public Object[][] data1()
	{
		Object[][] arr=new Object[3][2];
		arr[0][0]="SQL";
		arr[0][1]="VENKAT SIR";
		
		arr[1][0]="MANUAL";
		arr[1][1]="PRADEEP SIR";
		
		arr[2][0]="JAVA";
		arr[2][1]="AMIRE SIR";
		
	
		return arr;
	}
	//data provider with 4x5
	@Test(dataProvider = "data2")
	public void getDatafrom4x5(String studentName,String studentId,String grade,String address,String phno)
	{
		System.out.println(studentName+"\t"+studentId+"\t"+grade+"\t"+address+"\t"+phno);
	}
	@DataProvider
	public Object[][] data2()
	{
		Object[][] arr=new Object[4][5];
		arr[0][0]="Raja";
		arr[0][1]="001";
		arr[0][2]="1st class";
		arr[0][3]="Hyderabad";
		arr[0][4]="123-456-7891";
		
		
		arr[1][0]="Rani";
		arr[1][1]="002";
		arr[1][2]="1st class";
		arr[1][3]="Vijayawada";
		arr[1][4]="111-111-1111";
		
		arr[2][0]="Ravi";
		arr[2][1]="003";
		arr[2][2]="1st class";
		arr[2][3]="Bangalore";
		arr[2][4]="999-999-9991";
		
		arr[3][0]="vishnu";
		arr[3][1]="004";
		arr[3][2]="1st class";
		arr[3][3]="Siva Kasi";
		arr[3][4]="888-888-8888";
		
	
		return arr;
	}
	
	
	@Test(dataProvider = "data3")
	public void getDatafrom3x3(String from,String to,String transportation)
	{
		System.out.println(from+"\t"+to+"\t"+transportation);
	}
	@DataProvider
	public Object[][] data3()
	{
		 Object[][] arr={{"From Bangolore","To mysore","By Bus"},{"From Bangolore","To vijayawada","By train"},{"From Vijayawada","To Hyderabad","By Bus"}};
		 return arr;
			
		}
	
	@DataProvider
	public Object[][] data4()
	{
		Object[][] arr=new Object[4][4];
		arr[0][0]="Apple";
		arr[0][1]="Red";
		arr[0][2]=25;
		arr[0][3]="1kg";
		
		arr[1][0]="Banana";
		arr[1][1]="yellow";
		arr[1][2]=40;
		arr[1][3]="12piece";
		
		arr[2][0]="straberry";
		arr[2][1]="pink";
		arr[2][2]=100;
		arr[2][3]="1/2kg";
		
		arr[3][0]="mango";
		arr[3][1]="yellow";
		arr[3][2]=90;
		arr[3][3]="1kg";
		
	
		return arr;
	}
	
	@DataProvider
	public Object[][] data5()
	{
		Object[][] arr=new Object[4][5];
		arr[0][0]="iphone";
		arr[0][1]="10";
		arr[0][2]="black";
		arr[0][3]="30,000";
		arr[0][4]="5%";
		
		arr[1][0]="Oppo";
		arr[1][1]="f17";
		arr[1][2]="oragne";
		arr[1][3]="18,000";
		arr[0][3]="10%";
		
		
		arr[2][0]="samsung";
		arr[2][1]="galaxy";
		arr[2][2]="white";
		arr[2][3]="45,000";
		arr[0][3]="7%";
		
		arr[3][0]="Real Me";
		arr[3][1]="s8";
		arr[3][2]="Blue";
		arr[3][3]="15,000";
		arr[0][3]="10%";
		
	
		return arr;
	}
	
	
	}
	
