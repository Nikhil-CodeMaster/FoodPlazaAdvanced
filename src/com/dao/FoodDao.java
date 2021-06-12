package com.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.pojo.Food;
import com.utility.DBUtility;

public class FoodDao {

	String sql;
	PreparedStatement ps;
	ResultSet rs;
	int x;
	Connection c=DBUtility.makeConnection();
////////////////////////////////////////////////////////////////////////////////////////////////////////


	public boolean addFood(Food f)
	{
		try
		{
	
		sql="insert into Food(foodname,category,foodprice)values(?,?,?)";
		System.out.println(ps);
		ps=c.prepareStatement(sql);
		ps.setString(1, f.getFoodName());
		ps.setString(2,f.getCategory());
		ps.setDouble(3, f.getPrice());
		System.out.println(ps);
		x=ps.executeUpdate();
		if(x > 0)
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
////////////////////////////////////////////////////////////////////////////////////////////////////////

	public boolean updateFood(Food f)
	{
		try
		{
			sql="update Food set foodname=?,foodprice=?,category=? where fid=?";
			ps=c.prepareStatement(sql);
			ps.setString(1, f.getFoodName());
			ps.setDouble(2,f.getPrice());
			ps.setString(3, f.getCategory());
			ps.setInt(4, f.getFoodId());
			
			x=ps.executeUpdate();
			if(x > 0)
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
////////////////////////////////////////////////////////////////////////////////////////////////////////

	public List<Food> displayFood()
	{
		List<Food>flist= new ArrayList<Food>();
		try
		{
			sql="select * from Food";
			ps=c.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next())
			{
				Food f= new Food();
				f.setFoodId(rs.getInt("fid"));
				f.setFoodName(rs.getString("foodname"));
				f.setPrice(rs.getDouble("foodprice"));
				f.setCategory(rs.getString("category"));
				flist.add(f);
			}
			return flist;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	public boolean deleteFood(int id)
	{
		try
		{
			c=DBUtility.makeConnection();
			sql="delete from food where fid=?";
			ps=c.prepareStatement(sql);
			ps.setInt(1, id);
			x=ps.executeUpdate();
			if(x > 0)
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
////////////////////////////////////////////////////////////////////////////////////////////////////////
public Food searchFood(String fname)
{
	Food f= new Food();
	try
	{
		
		sql="select * from Food where foodname=?";
		ps=c.prepareStatement(sql);
		ps.setString(1, fname);
		rs=ps.executeQuery();
		if(rs.next())
		{
			f.setFoodId(rs.getInt("fid"));
			f.setFoodName(rs.getString("foodname"));
			f.setPrice(rs.getDouble("foodprice"));
			f.setCategory(rs.getString("category"));
		}
		return f;
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
	return null;
}
////////////////////////////////////////////////////////////////////////////////////////////////////////

public List<Food> getFoodByName(String foodName) 
{
	try
	{
		
	
	ArrayList<Food> fl=new ArrayList<Food>();
	sql="select * from food where foodname Like ?";
	ps=c.prepareStatement(sql);
	ps.setString(1,'%'+foodName+'%');
	System.out.println(ps);
	ResultSet rs=ps.executeQuery();
	while(rs.next())
	{
		Food f=new Food();
		f.setFoodId(rs.getInt("fid"));
		f.setFoodName(rs.getString("foodname"));
		f.setPrice(rs.getDouble("foodprice"));
		f.setCategory(rs.getString("category"));
		fl.add(f);
	}
	return fl;
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
	return null;
}

}