package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.pojo.Cart;
import com.pojo.Order;
import com.utility.DBUtility;

public class CartDao {

	String sql;
	PreparedStatement ps;
	ResultSet rs;
	int x;
	Connection c=DBUtility.makeConnection();
	
	public boolean addCart(Cart ct)
	{
		try
		{
			sql="insert into Cart(emailid,foodid)values(?,?)";
			ps=c.prepareStatement(sql);
			ps.setString(1, ct.getEmailId());
			ps.setInt(2, ct.getFoodId());
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
	public List<Cart> showCart(String emailId)
	{
		List<Cart> clist= new ArrayList<Cart>();
		try
		{
			sql="select foodname,foodprice,cartid from Cart c inner join Food f where c.foodid= f.fid and c.emailid=?";
			ps=c.prepareStatement(sql);
			ps.setString(1, emailId);
			rs=ps.executeQuery();
			while(rs.next())
			{
				Cart c= new Cart();
				c.setFoodName(rs.getString("foodname"));
				c.setPrice(rs.getDouble("foodprice"));
				c.setCartId(rs.getInt("cartid"));
				clist.add(c);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return clist;
		
	}
	public int placeOrder(String emailId,double total_Bill)
	{
		try
		{
		int order_Id=0;
		String order_Date=new Date().toString();
		sql="insert into foodorder(emailid,totalbill,orderdate) values(?,?,?)";
		ps=c.prepareStatement(sql);
		ps.setString(1, emailId);
		ps.setDouble(2, total_Bill);
		ps.setString(3,order_Date );
		
		int x=ps.executeUpdate();
		if(x>0)
		{
			sql="Select orderid from foodorder where emailid=? and orderdate=?";
			ps=c.prepareStatement(sql);
			ps.setString(1, emailId);
			ps.setString(2, order_Date);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				order_Id=rs.getInt("orderid");
			}
			return order_Id;
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	
	return 0;

}
	
	public boolean clearCart(String emailid)
	{
		try
		{
			
			sql="delete from cart where emailid=?";
			ps=c.prepareStatement(sql);
			ps.setString(1,emailid);
			int x=ps.executeUpdate();
			if(x>0)
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
	
	public List<Order> displayallorder() 
	{
		List<Order> ol=new ArrayList<Order>();
		
		try
		{
			sql="Select * from foodorder";
			 ps=c.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Order  o=new Order();
				o.setOrderId(rs.getInt("orderid"));
				o.setEmailId(rs.getString("emailid"));
				o.setTotalBill(rs.getDouble("totalbill"));
				o.setOrderDate(rs.getString("orderdate"));
				ol.add(o);
			}
			return ol;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return null;
	}
}
