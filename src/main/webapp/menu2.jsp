<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<style type="text/css">
.container{
  max-width:400px;
 
   margin: auto;
}

</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
     <% 
       String st1=(String)session.getAttribute("message");
     if(st1=="Credentials Not Found Please Register"){
    	//response.getWriter().write("<html><body><h1 style=color: red;>namasthey</h1></body></html>");
    	response.getWriter().write("<p style=color:red;align-content:space-between;margin-left:400px;>Credentials Not Found Please Register</p>");
     }
     %>
    
    <div class="container">
	     <h2 style="text-decoration: none; color: blue; line-height: 0;">Login form </h2>
	
	     <form action="login" method="post">
	          <table style="width: 35%">	
	          <tr>
	              <h1>  <td  style="align-content:space-between;margin-left:50px; color: orange;">username:</td> </h1>
	                <td ><input  spellcheck="true" type="text" name="userName" style=" color: white; background-color:silver;"></td>
	          </tr>
	          <tr>
	                <td style="color: green;">password:</td>
	                <td ><input type="password" name="password" style=" color: white; background-color:silver;"></td>
	          </tr>
	          <tr> 
	                   <!--  <td>  <input type="hidden" name="request" placeholder="GB" value="New">  </td> -->
	          </tr>
	          
	          </table> <br>
	     <input type="submit" value="Login" style=" align-content:space-between;margin-left:75px; color:black; background-color: green; border-color: gray; "  >
	     <button style="align-content: space-between;margin-left: 50px; border-color:gray;  background-color: green;"><a href="register" style="text-decoration:none;color: black; ">Register</a></button> <br> <br>
	     <button style="align-content: space-between;margin-left: 90px; border-color:silver; background-color: green;"> <a href="forgotpassword" style="text-decoration: none;color: black;">Forgot Password</a></button>
	     </form>
     </div>
</body>
</html>