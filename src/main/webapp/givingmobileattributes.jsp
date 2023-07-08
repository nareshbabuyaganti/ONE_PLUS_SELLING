<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.container{
max-width:100%;
 
   margin: auto;

}

.form{
max-width:40%;
 
   margin: auto;
  border: orange;
  border-width: 5px;
  border-style: solid;
  padding: 15px;

}

</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
  String st1=(String)session.getAttribute("data");
  if(st1=="improper data given"){
	  response.getWriter().write("<p style=color:red;align-content:space-between;margin-left:300px;>improper data given</p>");
  }
%>
<div class="container" style="background-image: url('https://assets.mspimages.in/wp-content/uploads/2022/01/OnePlus-10-Pro.jpg');padding: 10px;">
    <div class="form">
          <form:form action="addedmobileattributes" modelAttribute="mobiledto">
             <form:label path="MODEL_NAME">ModelName :</form:label> 
             <input name="MODEL_NAME" type="text" style="align-content:space-between;margin-left:3ex;"> <br> <br>
             <form:label path="proccessor">Proccessor :</form:label>
             <input name="proccessor" style="align-content:space-between;margin-left:4.6ex;" > <br> <br>
             <form:label path="batteryCapacity">BatteryCapacity :</form:label>
             <input name="batteryCapacity" style="align-content:space-between;margin-left:2ex;" placeholder="mah" type="number" value="3001"> <br> <br>
             <form:label path="ram">Ram :</form:label>
             <input type="number" name="ram" style="align-content:space-between;margin-left:10ex;" placeholder="GB" value="2"> <br> <br>
             <form:label path="rom">Rom :</form:label>
             <input type="number" name="rom" style="align-content:space-between;margin-left:10ex;" placeholder="GB" value="32"> <br> <br>
             <form:label path="cost">Cost :</form:label>
             <input type="number" name="cost" style="align-content:space-between;margin-left:10ex;" placeholder="Rupees" value="10001"> <br> <br>
             <form:label path="imageFront">FrontImage :</form:label>
             <input type="text" name="imageFront" style="align-content:space-between;margin-left:3ex;" > <br> <br>
             <form:label path="imageBack">BackImage :</form:label>
            <input type="text" name="imageBack" style="align-content:space-between;margin-left:3.3ex;"> <br> <br>
             <form:label path="imageSide">SideImage :</form:label>
             <input type="text" name=imageSide style="align-content:space-between;margin-left:3.9ex;"> <br> <br>
             <form:label path="display">DisplayMeasurment :</form:label>
             <input type="number" name="display" placeholder="inches" value="11"> <br> <br>
             <form:label path="frontCam">FrontCamera :</form:label>
            <input type="number" name="frontCam"  style="align-content:space-between;margin-left:2ex;" placeholder="mp" value="6"> <br> <br>
            <form:label path="backCam">BackCamera :</form:label>
            <input type="number" name="backCam" style="align-content:space-between;margin-left:2ex;" placeholder="mp" value="6"> <br> <br>
            <form:label path="discount">Discount :</form:label>
            <input type="number" name="discount" style="align-content:space-between;margin-left:5.5ex;" placeholder="%" value="1"> <br> <br>
            <form:label path="" >Search :</form:label>
            <a href="https://www.google.com/" target="_blank" style="align-content:space-between;margin-left:7.5ex;" ><input  type="search"></a> <br> <br>
             <input type="submit" style="color:black; background-color: green; align-content: space-between;margin-left: 150px;">
          </form:form>
          </div>
         </div>
</body>
</html>