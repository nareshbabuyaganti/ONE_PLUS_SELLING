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
<table border="2"  class="table"  style="color: green;">
   
   <tr>
       <th style="color:blue;">MODEL-NAME</th>
       <th style="color:blue;">Proccessor</th>
       <th style="color:blue;">Battery</th>
       <th style="color:blue;">Ram</th>
       <th style="color:blue;">Rom</th>
       <th style="color:blue;">Cost</th>
       <th style="color:blue;">ImageFront</th>
       <th style="color:blue;">ImageBack</th>
       <th style="color:blue;">ImageSide</th>
       <th style="color:blue;padding: 20px;text-align: center;">Rating</th>
       <th style="color:blue;">Display</th>
       <th style="color:blue;">FrontCam</th>
        <th style="color:blue;">BackCam</th>
       <th style="color:blue;">Discount</th>
      
   </tr>

       <c:forEach items="${all}" var="mobile">
       <tr>
            <td style="text-align: center;">${mobile.MODEL_NAME} </td>
            <td style="text-align: center;">${mobile.proccessor} </td>
            <td style="text-align: center;">${mobile.batteryCapacity}</td>
            <td style="text-align: center;">${mobile.ram}</td>
            <td style="text-align: center;">${mobile.rom}</td>
            <td style="text-align: center;">${mobile.cost}</td>
            <td> <a href="imagefrontrating" target="_blank"><img width="200"  height="200" alt="" src="${mobile.imageFront}"></a></td> 
            <td><img width="200"  height="200" alt="" src="${mobile.imageBack}"></td>
            <td><img width="200"  height="200" alt="" src="${mobile.imageSide}"></td>
            <td style="text-align: center;">${mobile.overAllRating}</td>
            <td style="text-align: center;">${mobile.display}</td>
            <td style="text-align: center;">${mobile.frontCam}</td>
            <td style="text-align: center;">${mobile.backCam}</td>
            <td style="text-align: center;">${mobile.discount}</td>
       
       </tr>
       
        
       </c:forEach>

    
</table>
              <a href="returntoadmin"><button>Back</button></a> 
              <a href="returntologin"><button>Exit</button></a>
              <br> <br>
              
              
</body>
</html>