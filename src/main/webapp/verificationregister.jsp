<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
#my1{
background-color: silver;
color: white;

}
.karna{
background-color: silver;
color: white;
}
.sub{
background-color: green;
color: black;
}

</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String st=(String)session.getAttribute("disResult");
    if(st!=null)
    
%>

<table>
         <tr >
               <th style="text-decoration: underline;">fields need to fill</th>
         </tr>
         <tr>
              <th style="color: red;"><%=st%></th>
         </tr>
</table>
<form:form  action="registerclient"  modelAttribute="clientdto" >
 <form:label path="userName" >username</form:label> <br>
 <form:input id="my1" path="userName" /> <br>
 <form:label path="createPassword" >createpassword</form:label> <br>
 <form:input cssClass="karna" path="createPassword" /> <br>
 <form:label path="confirmPassword">confirmpassword</form:label> <br>
 <form:input cssClass="karna" path="confirmPassword"/> <br>
 <form:label path="emailId">emailId</form:label> <br>
 <form:input cssClass="karna" path="emailId" /> <br>
 <form:label path="phoneNumber">phonenumber</form:label> <br>
 <form:input cssClass="karna"  path="phoneNumber"/> <br> <br>
 <input class="sub" type="submit">

</form:form>


</body>
</html>