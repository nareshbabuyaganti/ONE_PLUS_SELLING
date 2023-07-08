package com.sjp.life.insurance.initial.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.sjp.life.insurance.initial.dao.ClientDao;
import com.sjp.life.insurance.initial.dao.ClientDaoForServlet;
import com.sjp.life.insurance.initial.dto.MobileDto;

@WebServlet("/iphone11proUpdate")
public class iphone11proUpdateServlet extends HttpServlet {
	
	ClientDao cd=new ClientDao();
	ClientDaoForServlet cdforServlet=new ClientDaoForServlet();
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String st="iphone11pro";
		MobileDto mobile=null;
		List<MobileDto> mobileList=cdforServlet.AllMobiles();
		
		for(MobileDto m:mobileList) {
			if(st.equals(m.getMODEL_NAME())) {
				mobile=m;
				break;
				
			}
		}
		req.getSession().setAttribute("mobileUpdate", mobile);
		RequestDispatcher reqdis=req.getRequestDispatcher("iphone11proUpdate.jsp");
		reqdis.forward(req, res);
	}

}
