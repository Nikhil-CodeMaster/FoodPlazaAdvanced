
<%@page import="com.pojo.Customer"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<title>Update Customer List</title>
</head>
<body>

<h2 align="center">Customer List</h2>
<%List<Customer> custlist=(List<Customer>) session.getAttribute("custlist"); %>
<table border=2>
<tr>
<th>Customer Id</th>
<th>Customer Name</th>
<th>Customer Email Id</th>
<th>Password</th>
<th>Phone Number</th>
<th>Address</th>
</tr>
<%for(int i=0;i<custlist.size();i++)
	{
		Customer c=custlist.get(i);%>
<tr>
<td><%=c.getCustId()%></td>
<td><%=c.getCustomerName()%></td>
<td><%=c.getEmailId() %></td>
<td><%=c.getPassword() %></td>
<td><%=c.getContactNo()%></td>
<td><%=c.getAddress()%></td>

</tr>
<%} %>
</table>





</body>
</html>