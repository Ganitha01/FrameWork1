package jdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class FetchDataFromMysqldatabase {

	public static void main(String[] args) throws SQLException {
		Connection connection=null;
		try {
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/anitha","root","root");
			Statement statement=connection.createStatement();
			ResultSet result=statement.executeQuery("select * from student");
			while(result.next())
			{
				String data=result.getString(1)+"\t"+result.getString(2)+"\t"+result.getString(3);
				System.out.println(data);
			}
			
		} finally {
			connection.close();
		}
		

	}

}
