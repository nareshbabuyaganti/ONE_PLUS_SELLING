<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.table{

border: solid;


}


</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
String st="Update";

%>
<table border="2"  class="table"  style="color: green;">
   
   <tr >
       
       <th style="color:blue;">ImageFront</th> 
       <th style="color:blue;">ModelName</th> 
        <th style="color:blue;">Edit</th> 
       <th style="color:blue;width: 1000px; text-align: left;">Cost</th> 
      
   </tr>

       <c:forEach items="${all}" var="mobile">
       <tr  >
            
           <td > <a style="text-decoration: none;" href="${mobile.MODEL_NAME}" target="_blank"><img width="200"  height="200" alt="" src="${mobile.imageFront}">  </a></td>
           <td style="text-align: center;">${mobile.MODEL_NAME} </td>
           <td> <a style="text-decoration: none;" href="${mobile.MODEL_NAME}<%=st %>" target="_blank">  Edit <input type="text" name="request" placeholder="GB" value="<%=st %>"> </a> </td>
           <td style="text-align:left; width: 1000px; "><a style="text-decoration: none;" href="${mobile.MODEL_NAME}" target="_blank" name="model"  >   ${mobile.cost} ...seemoredetails </a></td>
              
       </tr>
        
       </c:forEach>
       
             
    
</table> <br>
              <input  > 
              <a href="returntoadmin" style="align-content: space-between;margin-left: 100px;"><button style=" border-color:silver;  background-color: green;">Back</button></a> 
              <a href="returntologin" style="align-content: space-between;margin-left: 900px;"><button style=" border-color:silver;  background-color: green;">Exit</button></a>
              <br> <br>
              
              
</body>
</html>