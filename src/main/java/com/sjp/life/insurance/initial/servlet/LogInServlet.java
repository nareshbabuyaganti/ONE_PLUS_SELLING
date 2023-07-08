package com.sjp.life.insurance.initial.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;

import com.sjp.life.insurance.initial.controller.ClientAndLoginController;
import com.sjp.life.insurance.initial.service.ClientService;

@WebServlet("/login")
public class LogInServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		   System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		   String st3;
		   String st4;
		   String st6;
		   
		   if(true) {
			    String st1=req.getParameter("userName");
			    st3=st1;
				String st2=req.getParameter("password");
				st4=st2;
				String st5=req.getParameter("request");
				System.out.println(st5+"777777777777777777777777777777777\n7777777777777");
				st6=st5;
				
				
		   }
		
		HttpSession session=req.getSession();
		session.setAttribute("userName", st3);
		session.setAttribute("password", st4);
		session.setAttribute("request", st6);
		System.out.println(st3+" &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		System.out.println(st4+" &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		ClientService cs1=new ClientService();
		ModelAndView mv=cs1.loginClient(st3, st4,req);
//		ClientAndLoginController con=new ClientAndLoginController();
//		ModelAndView mv1=con.loginClient(mv);
	    String result= mv.getViewName();
	    System.out.println(result+" #################################################");
		RequestDispatcher r=req.getRequestDispatcher(result);
		r.forward(req, resp);
		
	}

}
