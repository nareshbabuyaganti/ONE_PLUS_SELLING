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
<%
String st=(String)session.getAttribute("username");

%>
<h1><%=st %></h1>
     <form:form action="settingforgotpassword" modelAttribute="clientdto">
     <form:label path="createPassword" >newpassword</form:label> <br>
     <form:input cssClass="karna" path="createPassword" /> <br>
     <form:label path="confirmPassword">confirmpassword</form:label> <br>
     <form:input cssClass="karna" path="confirmPassword"/> <br>
     <input type="submit">
    
     </form:form>
    
</body>
</html>