<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="FoodServlet">
<table>
<tr>
<th>Foodname:</th>
<td><input type="text" name="fname">
</td>
</tr>

<tr>
<th>FoodPrice:</th>
<td><input type="text" name="price">
</td>
</tr>
<tr>

<th>Category:</th>
<td><input type="text" name="category">
</td>
</tr>

<tr>
<td><input type="submit" value="Add"></td>
<td><input type="reset" value="clear"></td>
</table>
</form>
</body>
</html>