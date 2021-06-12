<%@page import="com.pojo.Order"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%List<Order> orderlist=(List<Order>) session.getAttribute("OrderList"); %>
<table border=2>
<tr>
<th>Order Id</th>
<th>Customer Email Id</th>
<th>Total Bill</th>
<th>Order Date</th>
</tr>
<%for(int i=0;i<orderlist.size();i++)
	{
		Order o=orderlist.get(i);%>
<tr>
<td><%=o.getOrderId()%></td>
<td><%=o.getEmailId() %></td>
<td><%=o.getTotalBill() %></td>
<td><%=o.getOrderDate() %></td></tr>
<%} %>
</table>
</body>
</html>