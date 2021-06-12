package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.pojo.Customer;
import com.utility.DBUtility;

public class CustomerDao {

	String sql;
	PreparedStatement ps;
	ResultSet rs;
	int x;
	Connection c=DBUtility.makeConnection();
	public boolean addCustomer(Customer cust)
	{
		try
		{
			sql="insert into customer(customerName,emailid,password,address,contactno)values(?,?,?,?,?)";
			ps=c.prepareStatement(sql);
			ps.setString(1, cust.getCustomerName());
			ps.setString(2, cust.getEmailId());
			ps.setString(3, cust.getPassword());
			ps.setString(4, cust.getAddress());
			ps.setString(5, cust.getContactNo());
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
	
	public List<Customer> getallcustomer() 
	{
		List <Customer> cl=new ArrayList<Customer>();
		try
		{
		
			sql="Select * from customer";
			ps=c.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Customer f=new Customer();
				f.setCustId(rs.getInt("CustId"));
				f.setCustomerName(rs.getString("customerName"));
				f.setEmailId(rs.getString("emailid"));
				f.setPassword(rs.getString("password"));
				f.setContactNo(rs.getString("contactno"));
				f.setAddress(rs.getString("address"));
				cl.add(f);
			}
			return cl;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
}
