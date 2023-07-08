<%@page import="com.sjp.life.insurance.initial.dto.MobileDto"%>
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
		MobileDto  m=(MobileDto)session.getAttribute("mobileUpdate");
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
		        String use="You can search here";
		        request.getSession().setAttribute("request", "Update");
    %>
    <%
    
    String error =(String)request.getSession().getAttribute("Error");
    if(error!=null&&error.equalsIgnoreCase("Invalid data entered please check bro")){
    	//response.getWriter().write("<html><body><h1 style=color: red;>namasthey</h1></body></html>");
    	response.getWriter().write("<p style=color:red;align-content:space-between;margin-left:400px;>"+error+"</p>");
     }
    %>
<form action="addedmobileattributes">

FrontImage <input type="text" style="width: 300px;" name="frontImage" value="<%=frontImage %>"> <br> <br>
BackImage <input type="text" style="width: 300px;" name="backImage" value="<%=backImage %>"> <br> <br>
SideImage <input type="text" style="width: 300px;" name="sideImage" value="<%=sideImage %>"> <br> <br>
<input type="text" name="modelNAME" value="<%= modelNAME%>"> <br> <br>
Proccessor <input type="text" name="proccessor" value="<%=proccessor %>"> <br> <br>
BatteryCapacity <input type="text" name="batteryCap" value="<%=batteryCap %>"> <br> <br>
Ram <input type="text" name="ram" value="<%= ram%>"> <br> <br>
Rom <input type="text" name="rom" value="<%= rom%>"> <br> <br>
Cost <input type="text" name="cost" value="<%= cost%>"> <br> <br>
FrontCamera <input type="text" name="frontCam" value="<%=frontCam %>"> <br> <br>
BackCamera <input type="text" name="backCam" value="<%= backCam%>"> <br> <br>
<%-- OverAllRating<input type="text" name="overAllRating" value="<%= overAllRating%>"> --%>
Display <input type="text" name="display" value="<%= display%>"> <br> <br>
Discount <input type="text" name="discount" value="<%= discount%>"> <br> <br>
Search  <a href="https://www.google.com/" target="_blank"><input type="text" name="use" value="<%=use %>"></a> <br> <br>
<input type="submit" value="submit"> <br> <br>

</form>



</body>
</html>