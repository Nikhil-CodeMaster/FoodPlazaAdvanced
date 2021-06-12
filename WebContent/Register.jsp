<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="CustomerServlet" method="post">
<table>
<tr>
<th>CustomerName</th>
<td><input type="text" name="cname"></td>
</tr>

<tr>
<th>Address</th>
<td><input type="text" name="address"></td>
</tr>

<tr>
<th>ContactNo</th>
<td><input type="text" name="contactno"></td>
</tr>

<tr>
<th>EmailId</th>
<td><input type="text" name="emailid"></td>
</tr>

<tr>
<th>Password</th>
<td><input type="text" name="password"></td>
</tr>
<tr>
<td><input type="submit" value="Register"></td>
<td><input type="reset" value="clear"></td>
</tr>
</table>
</form>
</body>
</html>