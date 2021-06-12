<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%String admin=(String)session.getAttribute("Admin");
String customer=(String)session.getAttribute("Customer");
String success=(String)session.getAttribute("success");
%>
<%if(success!=null){ %>
<h2 style=color:red><%=success%></h2>
<%} %>
<ul>
<li><a href="Login.jsp">Login</a></li>
<li><a href="Register.jsp">Register</a></li>
<li><a href="Search.jsp">Search</a></li>
<li><a href="contact_us.jsp">ContactUs</a></li>
<li><a href="FoodServlet">FoodMenu</a></li>
<%if(admin!=null || customer !=null){ %>
<li><a href="LoginServlet">Logout</a></li><%}%>
<%if(admin !=null){ %>
<li><a href="CartServlet?operation=displayorder">Show Orders</a></li>
<li><a href="CustomerServlet">Show Customers</a></li>
<%} %>
<%if(customer!=null){%>
<li><a href="CartServlet">Show Cart</a></li>
<%}%>
</ul>
</body>
</html>