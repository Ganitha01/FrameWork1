package jdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.cj.jdbc.Driver;

public class InsertDataIntoMysqlDatabase {

	public static void main(String[] args) throws SQLException {
		Connection connection=null;
	try {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/anitha","root","root");
		Statement statement=connection.createStatement();
		String query="insert into student values(004,'madhu',12345678)";
		int result=statement.executeUpdate(query);
		if (result==1)
		{
			System.out.println("data inserted successfully");
		}
	} 
	
	finally {
		
		connection.close();
	}
		
		
		

	}

}
