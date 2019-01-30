package com.rbs.irs.helpers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class OracleHelper {
				
	        @SuppressWarnings("finally")
			public static Connection getConnection()
	        {
	//0. Read Property file
			ResourceBundle rb=ResourceBundle.getBundle("com/rbs/irs/resources/oracledb");
			String drivername=rb.getString("driver");
			String username=rb.getString("user");
			String password=rb.getString("password");
			String url=rb.getString("url");
			Connection conn=null;
			Statement statement=null;
			ResultSet resultset=null;
			
			//1.Load the driver
			try
			{
				Class.forName(drivername);
			System.out.println("Driver Loaded");
			
			//2 Create Connection
			conn=DriverManager.getConnection(url,username,password);
			System.out.println("connection created");
}catch(ClassNotFoundException e)
			{
	System.out.println(e.getMessage());
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}finally
{
	return conn;
}
}}