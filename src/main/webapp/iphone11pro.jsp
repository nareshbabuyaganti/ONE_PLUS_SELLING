<%@page import="com.sjp.life.insurance.initial.dto.MobileDto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
 ul{
 column-count: 2;
 column-fill: auto;
 }

</style>
</head>
<body> 
        <%
        MobileDto  m=(MobileDto)session.getAttribute("mobile");
        String frontImage=m.getImageFront();
        String backImage=m.getImageBack();
        String sideImage=m.getImageSide();
        String  modelNAME=m.getMODEL_NAME();
        String proccessor =m.getProccessor();
        int batteryCap=m.getBatteryCapacity();
        int ram=m.getRam();
        int rom = m.getRom();
        int cost=m.getCost();
        int frontCam=m.getFrontCam();
        int backCam=m.getBackCam();
        double overAllRating=m.getOverAllRating();
        double display =m.getDisplay();
        double discount=m.getDiscount();
        
        %>
        
        <div>
        
        
        <img style="width: 300px;height: 300px;"   alt="" src="<%=frontImage%>">
        <img style="width: 300px;height: 300px;"   alt="" src="<%=backImage%>">
        <img style="width: 300px;height: 300px;"   alt="" src="<%=sideImage%>">
  
<p style="text-decoration: underline;color: blue;">iphone11pro Features:</p>


  <ul>
 <li>Cost1: <%=cost %></li>
  <li>ModelName: <%=modelNAME %> </li>
  <li>Proccessor: <%= proccessor%></li>
  <li>BatteryCapacity: <%= batteryCap%></li>
  <li>Ram:  <%=ram %></li>
 
  <li>Rom:  <%= rom%></li>
  <li>FrontCamera:  <%=frontCam %></li>
  <li>BackCamera: <%= backCam%></li>
  
  <li>OverAllRating: <%= overAllRating%></li>
  <li>Display:  <%=display %></li>
  <li>Discount:  <%=discount %></li>
</ul>





        
        </div>
  
</body>
</html>