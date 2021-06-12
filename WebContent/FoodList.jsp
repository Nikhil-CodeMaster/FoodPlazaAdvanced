<%@page import="com.pojo.Food"%>
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
<% List<Food> flist=(List<Food>)session.getAttribute("FoodDetails");
String admin=(String)session.getAttribute("Admin");
String customer=(String)session.getAttribute("Customer");
String mesg=(String)session.getAttribute("success");
if(mesg!=null)
{
	out.println(mesg); //printing the message when food added to cart
}
%>

<table border=2 align="center">
<tr>
<th>FoodId</th>
<th>FoodName</th>
<th>Price</th>
<th>Category</th>
</tr>
<%for(int i=0;i<flist.size();i++)
	{ 
				Food f=flist.get(i);
	%>
	<tr>
	<td><%=f.getFoodId()%></td>
	<td><%=f.getFoodName()%></td>
	<td><%=f.getPrice()%></td>
	<td><%=f.getCategory()%></td>
	<%if(admin!=null){ %>
	<td><a href="FoodServlet?operation=edit&fname=<%=f.getFoodName()%>">Edit</a>
	<td><a href="FoodServlet?operation=delete&fid=<%=f.getFoodId()%>">Delete</a></td>
	<%} %>
	<%if(customer!=null){ %>
	<td><a href="CartServlet?operation=addToCart&fid=<%=f.getFoodId()%>">AddToCart</a></td>
	<%} %>
	</tr>
	<%} %>
</table>
</body>
</html>