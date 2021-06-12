package com.utility;

import java.sql.*;

public class DBUtility {

	public static Connection makeConnection(){
		Connection c=null;
		try
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		c=DriverManager.getConnection("jdbc:mysql://localhost:3306/foodplazajdbc", "root", "root");
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return c;
		
	}
}
