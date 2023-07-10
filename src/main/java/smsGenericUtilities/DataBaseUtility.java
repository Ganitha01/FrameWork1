package smsGenericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {
	
	Connection connection;
	
	/**
	 * this methode is used to open the data base
	 * @return
	 * @throws SQLException
	 */
	public Connection openDataBaseConnection() throws SQLException
	{
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/anitha","root","root");
		return connection;
	}
	/**
	 * his method is used for closing the dataBase connection
	 * @param connection
	 * @throws SQLException
	 */
	public void closeDataBaseConnection(Connection connection) throws SQLException
	{
		connection.close();
	}

}
