package com.sjp.life.insurance.initial.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.cj.Session;
import com.sjp.life.insurance.initial.dao.ClientDao;
import com.sjp.life.insurance.initial.dto.ClientDto;
import com.sjp.life.insurance.initial.dto.MobileDto;
import com.sjp.life.insurance.initial.service.ClientService;

@RestController
public class ClientAndLoginController {

	@Autowired
	private ClientDao cd;
	@Autowired
	private ClientService cs;

	@RequestMapping("register")
	public ModelAndView getRegister() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("clientdto", new ClientDto());
		mv.setViewName("initialregister.jsp");
		return mv;
	}

	@RequestMapping("registerclient")
	public ModelAndView saveClient(@ModelAttribute ClientDto c1, HttpServletRequest req) {

		String disResult = cs.saveClient(c1);

		HttpSession hs = req.getSession();
		hs.setAttribute("disResult", disResult);
		ModelAndView mv = new ModelAndView();
		mv.addObject("clientdto", new ClientDto());
		mv.setViewName("verificationregister.jsp");
		return mv;
	}

	@RequestMapping("forgotpassword")
	public ModelAndView forgotPassword1() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("clientdto", new ClientDto());
		mv.setViewName("forgotpasswordjsp.jsp");
		return mv;
	}

	@RequestMapping("forgotpasswordclass")
	public ModelAndView forgotpassword2(@ModelAttribute ClientDto cdt, HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		String result = cs.forgotPasswordService(cdt.getUserName(), cdt.getCreatePassword());
		if (result.equals("true")) {
			HttpSession hs = req.getSession();
			hs.setAttribute("username", cdt.getUserName());
			mv.addObject("clientdto", new ClientDto());
			mv.setViewName("setforgotpassword.jsp");
		} else {
			HttpSession hs = req.getSession();
			hs.setAttribute("mismatchusr", result);
			mv.setViewName("mismatchusr.jsp");
		}

		return mv;
	}

	@RequestMapping("settingforgotpassword")
	public ModelAndView settingForgotPassword(@ModelAttribute ClientDto cdt, HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		String username = (String) req.getSession().getAttribute("username");
		String result1 = cs.crtNewPwdCnfPwdEqualCheck(cdt.getCreatePassword(), cdt.getConfirmPassword());
		if (result1.equals("true")) {

			String password = cdt.getConfirmPassword();
//		    	   HttpSession hs  =req.getSession();
//		    	   hs.setAttribute("result", result);
			System.out.println("8888888888888888DONE88888888888888888888888888888888888888888888888");
			String result2 = cs.setNewpasswordToUsername(username, password);
			System.out.println(username);
			System.out.println(password);
			HttpSession hs = req.getSession();
			hs.setAttribute("successresult", result2);
			mv.setViewName("successforgotpassword.jsp");
		} else {
			HttpSession hs = req.getSession();
			hs.setAttribute("mismatchpwd", result1);
			mv.setViewName("mismatchpwd.jsp");
		}
		return mv;
	}

	@RequestMapping("addmobile")
	public ModelAndView mobileAttributes() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("mobiledto", new MobileDto());
		mv.setViewName("givingmobileattributes.jsp");
		return mv;
	}

	@RequestMapping("addedmobileattributes")
	public ModelAndView addedMobileAttributes(@ModelAttribute MobileDto mobile, HttpServletRequest req,
			HttpServletResponse res) throws ServletException, IOException {
		if (req.getParameter("frontImage") == null) {
			String result = cs.addMobileAttributesToDB(mobile, req);
			System.out.println("main***********************************************************");
			if (result == "improper data given") {
				req.getSession().setAttribute("data", result);
				ModelAndView mv = new ModelAndView();
				mv.addObject("mobiledto", new MobileDto());
				mv.setViewName("givingmobileattributes.jsp");
				return mv;
			}
			ModelAndView mv = new ModelAndView();
			mv.setViewName("addedmobile.jsp");
			return mv;
		} else if (!req.getParameter("frontImage").isEmpty()) {
			MobileDto mobileLokal = new MobileDto();
			String frontImage = req.getParameter("frontImage");
			String backImage = req.getParameter("backImage");
			String sideImage = req.getParameter("sideImage");
			String modelNAME = req.getParameter("modelNAME");
			String proccessor = req.getParameter("proccessor");
			int batteryCap = Integer.parseInt(req.getParameter("batteryCap"));
			int ram = Integer.parseInt(req.getParameter("ram"));
			int rom = Integer.parseInt(req.getParameter("rom"));
			int cost = Integer.parseInt(req.getParameter("cost"));
			int frontCam = Integer.parseInt(req.getParameter("frontCam"));
			int backCam = Integer.parseInt(req.getParameter("backCam"));
			double display = Double.parseDouble(req.getParameter("display"));
			double discount = Double.parseDouble(req.getParameter("discount"));
			mobileLokal.setImageFront(frontImage);
			mobileLokal.setImageBack(backImage);
			mobileLokal.setImageSide(sideImage);
			mobileLokal.setMODEL_NAME(modelNAME);
			mobileLokal.setProccessor(proccessor);
			mobileLokal.setBatteryCapacity(batteryCap);
			mobileLokal.setRam(ram);
			mobileLokal.setRom(rom);
			mobileLokal.setCost(cost);
			mobileLokal.setFrontCam(frontCam);
			mobileLokal.setBackCam(backCam);
			mobileLokal.setDisplay(display);
			mobileLokal.setDiscount(discount);
			String result = cs.addMobileAttributesToDB(mobileLokal, req);
			if (result == "improper data given") {
				req.getSession().setAttribute("mobileUpdate", mobileLokal);
				req.getSession().setAttribute("Error", "Invalid data entered please check bro");
				RequestDispatcher reqdis = req.getRequestDispatcher("iphone11proUpdate.jsp");
				reqdis.forward(req, res);
				/*
				 * req.getSession().setAttribute("data", result); ModelAndView mv=new
				 * ModelAndView(); mv.addObject("mobiledto",new MobileDto());
				 * mv.setViewName("givingmobileattributes.jsp"); return mv;
				 */
//		    	ModelAndView mv=new ModelAndView();
//				mv.setViewName("iphone11proUpdate.jsp");
//				return mv;
			}

			ModelAndView mv = new ModelAndView();
			mv.setViewName("addedmobile.jsp");
			return mv;

		}
		ModelAndView mv = new ModelAndView();
		mv.setViewName("addedmobile.jsp");
		return mv;
	}

	@RequestMapping("displaymobiles")
	public ModelAndView allMobiles() {
		System.out.println("[][][][][]{}{}{}{}{}{}{}{}{}{}{}{}{}[][][][][][][][][][][][][][][][]");
		ModelAndView mv = new ModelAndView();
		List<MobileDto> l1 = cs.allMobiles();
		System.out.println("{}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}");
		System.out.println(l1.size() + "***********************************************************");

		mv.addObject("all", l1);
		mv.setViewName("displaymobiles.jsp");

		return mv;
	}

	@RequestMapping("displaymobiles2")
	public ModelAndView mobileFeaturePage() {

		ModelAndView mv = new ModelAndView();
		List<MobileDto> l1 = cs.allMobiles();

		mv.addObject("all", l1);
		mv.setViewName("displaymobiles2.jsp");
		return mv;

	}

	@RequestMapping("rama")
	public ModelAndView expriment(HttpServletRequest req) {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("addedmobile.jsp");
		String st = req.getParameter("mail=");
		System.out.println("********************************************************\n"
				+ "********************************************************\\n"
				+ "********************************************************\\n"
				+ "********************************************************\\n"
				+ "********************************************************\\n" + st);
		HttpSession sn = req.getSession();
		sn.setAttribute("ex", st);

		return mv;

	}

	// all alone mobiles

	@RequestMapping("iphone11pro")
	public ModelAndView iphone11pro(HttpServletRequest req) {

		String st = "iphone11pro";
		MobileDto m = null;
		String result = (String) req.getAttribute("request");

		String result1 = req.getParameter("request");
		System.out.println("***********\n***********\n************\n" + result);
		// take all mobiles from db and take need mobile details and send .
		System.out.println("***********\n***********\n************\n" + result1);
		List<MobileDto> ml = cd.allMobiles();
		for (MobileDto mbl : ml) {
			if (st.equals(mbl.getMODEL_NAME())) {
				m = mbl;
				break;

			}
		}
		ModelAndView mv = new ModelAndView();
		req.getSession().setAttribute("mobile", m);

		mv.addObject("mobile", m);
		mv.setViewName("iphone11pro.jsp");
		return mv;

	}

	/*
	 * @RequestMapping("iphone11proUpdate") public ModelAndView
	 * iphone11proUpdate(HttpServletRequest req,HttpServletResponse res) {
	 * 
	 * String st="iphone11pro"; MobileDto m=null;
	 * 
	 * String result = (String)req.getAttribute("request");
	 * 
	 * String result1 = req.getParameter("request");
	 * System.out.println("***********\n***********\n************\n"+result); //take
	 * all mobiles from db and take need mobile details and send .
	 * System.out.println("***********\n***********\n************\n"+result1);
	 * 
	 * //take all mobiles from db and take need mobile details and send .
	 * List<MobileDto> ml=cd.allMobiles(); for(MobileDto mbl: ml) {
	 * if(st.equals(mbl.getMODEL_NAME())){ m=mbl; break; } } ModelAndView mv = new
	 * ModelAndView(); req.getSession().setAttribute("mobile", m);
	 * 
	 * mv.addObject("mobile",m); mv.setViewName("iphone11pro.jsp"); return mv;
	 * 
	 * }
	 */

	// back purpose
	@RequestMapping("returntoadmin")
	public ModelAndView returnToAdminPage() {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin.jsp");
		return mv;

	}

	@RequestMapping("returntologin")
	public ModelAndView returnToLoginPage() {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("menu2.jsp");
		return mv;

	}

}
