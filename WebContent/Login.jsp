<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="LoginServlet" method="post">
<table>
<tr>
<th>Enter type:-</th>
<td><input type="radio" name="type" value="Customer">Customer</td>
<td><input type="radio" name="type" value="Admin">Admin</td>
</tr>
<tr><th>UserName</th>
<td><input type="text" name="uname"></td>
</tr>
<tr>
<th>Password</th>
<td><input type="password" name="pass"></td>
</tr>
<tr>
<td><input type="submit" value="Login">
<input type="reset" value="clear">
</td>
</table>
</form>
</body>
</html>