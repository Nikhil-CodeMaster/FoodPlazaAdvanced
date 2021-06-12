<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="templatemo_style.css" rel="stylesheet" type="text/css" />
<title>Search</title>
</head>
<body>

<form  action="FoodServlet"  method="post"  > 
<input type="hidden" name="operation" value="Search">
<br> 
<input type="text" placeholder="Search Food" name="FoodName" required> 
<input type="submit" value="Search"><br><br>
</form>
</body>
</html>