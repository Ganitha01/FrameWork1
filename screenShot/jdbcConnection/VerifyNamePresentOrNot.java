package jdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class VerifyNamePresentOrNot {

	public static void main(String[] args) throws SQLException {
		Connection connection=null;
		try {
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/anitha","root","root");
			Statement statement=connection.createStatement();
			ResultSet result=statement.executeQuery("select * from student");
			String name="anitha";
			boolean flag=false;
			while(result.next())
			{
				String data=result.getString(1)+"\t"+result.getString(2)+"\t"+result.getString(3);
				//System.out.println(data);
				if(data.contains(name))
				{
					System.out.println("data is present");
					flag=true;
					break;
				}
			}
			if(!flag)
			{
				System.out.println("data is not present");
			}
			
		} finally {
			connection.close();
		}

	}

}
