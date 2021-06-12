<%@page import="com.pojo.Cart"%>
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
<%List<Cart>clist=(List<Cart>)session.getAttribute("cartlist"); %>
<form action="CartServlet" method="post">
<table border=2>
<tr>
<th>FoodName</th>
<th>FoodPrice</th>
<th>Quantity</th>
</tr>
<%for(int i=0;i<clist.size();i++)
	{
	     Cart c=clist.get(i);
	%>
	<tr>
	<td><%=c.getFoodName()%></td>
	<td><%=c.getPrice() %></td>
	<input type="hidden" name="foodprice" value=<%=c.getPrice()%>>
	<td><input type="number" name="qty" value=1></td>
	</tr>
	<%} %>
	<tr>
	<td colspan=3 align="center"><input type="submit" value="PlaceOrder"></td>
	</tr>
</table>
</form>
</body>
</html>