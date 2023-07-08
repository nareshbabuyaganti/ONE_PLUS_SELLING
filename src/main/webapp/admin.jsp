<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <h1 style="color:green;">admin</h1>
	<form action="experiment">
	<% String st=(String)session.getAttribute("request");
	if(st!=null){
		response.getWriter().write("<p style=color:red;align-content:space-between;margin-left:400px;>"+st+"</p>");
	}
	
	%>
	 <button style="color: blue;"><a href="addmobile" style="color: blue;">AddMobileToBusiness</a></button>  <br> <br>  
	 <button><a href="displaymobiles2" style="color: blue;">ViewAllMobilesInBusiness</a></button> <br> <br>
	 <button><a href="returntologin">Backfromform</a></button>
	</form>
	<a href="returntologin"><button>Back</button></a>
	<a href="returntologin"><button>Exit</button></a>
	 
</body>
</html>