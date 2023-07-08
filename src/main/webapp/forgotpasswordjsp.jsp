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
   <form:form  action="forgotpasswordclass" modelAttribute="clientdto">
    <form:label path="userName" >username</form:label> <br>
      <form:input id="my1" path="userName" /> <br>
    <form:label path="createPassword" >confirm username</form:label> <br>
      <form:input cssClass="karna" path="createPassword" /> <br>
   <input type="submit">
   
   
   </form:form>

</body>
</html>