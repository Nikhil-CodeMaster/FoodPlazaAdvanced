package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.utility.DBUtility;

public class LoginDao {
	String sql;
	PreparedStatement ps;
	ResultSet rs;
	int x;
	Connection c=DBUtility.makeConnection();

	public boolean customerLogin(String username,String password)
	{
		try
		{
			sql="select emailid,password from customer where emailid=? and password=?";
			ps=c.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			rs=ps.executeQuery();
			if(rs.next())
			{
				return true;
			}
			else
			{
				return false;
			}
					
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
}
