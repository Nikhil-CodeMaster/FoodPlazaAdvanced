<%@page import="com.pojo.Food"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%Food f=(Food)session.getAttribute("Food"); %>
<form method="post" action="FoodServlet">
<input type="hidden" name="operation" value="update">
<table>
<tr>
<th>FoodId</th>
<td><input type="text" name="foodId" value=<%=f.getFoodId()%> readonly>
</tr>
<tr>
<th>Foodname:</th>
<td><input type="text" name="fname" value=<%=f.getFoodName() %>>
</td>
</tr>

<tr>
<th>FoodPrice:</th>
<td><input type="text" name="price" value=<%=f.getPrice() %>>
</td>
</tr>
<tr>

<th>Category:</th>
<td><input type="text" name="category" value=<%=f.getCategory()%>>
</td>
</tr>

<tr>
<td><input type="submit" value="Update"></td>
<td><input type="reset" value="clear"></td>
</table>
</form>
</body>
</html>