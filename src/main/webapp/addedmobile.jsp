<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <%
    
    String st=(String)session.getAttribute("ex");
    
    if(st!=null){
    	response.getWriter().write("<p style=color:red;align-content:space-between;margin-left:400px;>"+st+"</p>");
    	
    }
    
    %>
  <p style="color: green;">mobile added successfully</p>
  <h1> st</h1>
</body>
</html>