package com.sjp.life.insurance.initial.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.sjp.life.insurance.initial.dao.ClientDao;
import com.sjp.life.insurance.initial.dto.ClientDto;
import com.sjp.life.insurance.initial.dto.MobileDto;

@Service
public class ClientService {
	@Autowired
	private ClientDao cd;
	
	@Autowired
	 MmailService mailService;
	
	
	public String saveClient(ClientDto cl1) {
		String checkingNullResult=null;
		try {
			if(cl1.getConfirmPassword()==null||cl1.getCreatePassword()==null||cl1.getEmailId()==null||cl1.getPhoneNumber()==0||cl1.getUserName()==null) {
				checkingNullResult="some fields are not entered";
				return checkingNullResult;
			}
		} catch (Throwable e) {
		return	checkingNullResult="Something Went wrong";
		}
	
	String phnLength=""+cl1.getPhoneNumber();
	if(!((cl1.getCreatePassword().equals(cl1.getConfirmPassword())))||phnLength.length()!=10) {
		
		if((cl1.getCreatePassword().equals(cl1.getConfirmPassword()))==false&&phnLength.length()==10) {
			checkingNullResult="Password Not Matched";
			return checkingNullResult;
			
		}
		else if((cl1.getCreatePassword().equals(cl1.getConfirmPassword()))==true&&phnLength.length()!=10)
		{
			checkingNullResult="Phone Number Length Incurrect";
			return checkingNullResult;
		}
		else {
			checkingNullResult="Password Not Matched "+" Phone Number Length Incurrect";
			return checkingNullResult;
		}
		
	}
	String cEmail	 =cl1.getEmailId();
	//long   cPhone    =cl1.getPhoneNumber();
	String cPassword =cl1.getConfirmPassword();
	String emailLengthResult=null;
	String passwordLengthResult=null;
	    passwordLengthResult=passwordLengthChecking(cPassword);
	if(cEmail!=null) {
		char ch[]=cEmail.toCharArray();
		String tail="@gmail.com";
		char cht[]=tail.toCharArray();
		
		int count=0;
		int autoCount=0;
		
		int emailK=0;
		
		boolean b=false;
		
		for(int i=0;i<ch.length;i++) {
			
				for(int j=0;j<ch.length;j++) {
					if(count==1) {
						b=true;
					}
					if(cht[i]==ch[j]) {
						count+=1;
						i++;
					}
					if(b) {
						autoCount+=1;       
					}
					if(autoCount==9) {
						emailK=j;
						
						break;
					}
				}
				if(autoCount==9&&count==10&&emailK==ch.length-1) {
					emailLengthResult="true";
				}
				else {
					emailLengthResult="Your email must contain @gmail.com properly";
				}
				break;
		}
		
	}
	if(!(emailLengthResult.equals("true")&&passwordLengthResult.equals("true"))) {
		
		if(!(emailLengthResult.equals("true"))) {
			return emailLengthResult;
			
		}
		return passwordLengthResult;
		
	}
		
		LinkedHashMap<String, String> m1=cd.existCheckingOfRegister(cl1.getEmailId(), cl1.getUserName(), cl1.getPhoneNumber());
		String finalECResult="";
		String emailECResult=null;
		String userNameECResult=null;
		String phoneECResult=null;
		
		for(Map.Entry<String,String> e1 :m1.entrySet()) {
			String temp1=e1.getKey();
			String temp2=e1.getValue();
			System.out.println(m1.size());
			if(temp1.equals("emailEC")&&temp2.equals("Exist")) {
				emailECResult="change email entered email already exist.";
				finalECResult+=emailECResult;
				
			}
			else if(temp1.equals("userNameEC")&&temp2.equals("Exist")) {
				userNameECResult="change username entered username already taken. ";
				finalECResult+=userNameECResult;
			}
			else if(temp1.equals("phoneEC")&&temp2.equals("Exist")) {
				phoneECResult="change phone number entered phone number already registered.";
				finalECResult+=phoneECResult;
			}
			else {
			}
		}
		if(emailECResult!=null||userNameECResult!=null||phoneECResult!=null) {
			return finalECResult;
		}
		ClientDto cl2=cd.saveClient(cl1);
		System.out.println(cl2.getUserName());
		System.out.println(cl2.getConfirmPassword());
		System.out.println(cl2.getPhoneNumber());
		if(cl2!=null) {
			
			//mailService.sendingMail(cl2.getEmailId(),"it is body jhscbjhsbdjvnkjndkjvvvvvvssssjasnkjcnaskdnkjsndkjnskjdvnkjskjsb" ," Hiiiii it  bkuhkjlojkpk;olkhjis subject" );
			return "Registration Successfully Completed mister... "+cl2.getUserName();
		}
		return "Something went wrong";
		
		
	}
	public String crtNewPwdCnfPwdEqualCheck(String createPwd,String confirmPwd) {
		String resultObject=null;
		if(createPwd.equals(confirmPwd)) {
		String pwdResult= passwordLengthChecking(confirmPwd);
		if(pwdResult.equals("true"))
		 return	resultObject=pwdResult;
		else
		 return	resultObject=pwdResult;
		}else
		 return	resultObject="password not matched";
	}
	public String passwordLengthChecking(String cPassword) {
		String result=null;
		if(cPassword!=null) {
			char ch[]=cPassword.toCharArray();
			int small=0;
			int capital=0;
			int special=0;
			int numbers=0;
			for(int i=0;i<ch.length;i++) {
				
				
				if(ch[i]>='a'&&ch[i]<='z') {
					small+=1;	
				}
				else if(ch[i]>='A'&&ch[i]<='Z') {
					capital+=1;	
				}
				else if(ch[i]>='0'&&ch[i]<='9') {
					numbers+=1;
				} 
				else if(ch[i]=='!'||ch[i]=='@'||ch[i]=='#'||ch[i]=='$'||ch[i]=='%'||ch[i]=='^'||ch[i]=='&'||ch[i]=='*'){
					special+=1;	
				}
			}
			if(small>=1&&capital>=1&&special>=1&&numbers>=1&&small+capital+special+numbers>=8) {
				result="true";
			}
			else {
				result="Your password must needs to include both lower and upper case characters"
						+ " atleast one number and special character"
						+ " and length must be 8 characters (:";
			}
				
		}
		return result;
		
	}
	public ModelAndView loginClient(String userName,String password,HttpServletRequest req) {
		
		ClientDao cd1=new ClientDao();
		List<ClientDto> l1=cd1.existCheckingLogIn(userName,password,req);
		for(ClientDto cdt1:l1) {
			if((userName.equals("Krishna") || userName.equals("VengalRao")) && (password.equals("Krishna@232") || password.equals("Vengalrao@123"))) {
				ModelAndView mv1= new ModelAndView();
				mv1.addObject("userName",userName);
				mv1.setViewName("admin.jsp");
				return mv1;
			}
			else if(userName.equals(cdt1.getUserName())&&password.equals(cdt1.getConfirmPassword())) {
				ModelAndView mv2= new ModelAndView();
				mv2.addObject("userName",userName);
				mv2.setViewName("customer.jsp");
				return mv2;
			}
		}
		ModelAndView mv3= new ModelAndView();
		String st1="Credentials Not Found Please Register";
		mv3.addObject("message",st1);
		mv3.setViewName("menu2.jsp");
		HttpSession hs=req.getSession();
		hs.setAttribute("message", st1);
		return mv3;
		
		
	}
	public String forgotPasswordService(String userName1,String userName2) {
		String resultObject=null;
		if(userName1.equals(userName2)) {
			List<ClientDto> l1=cd.listOfClients();
			for(ClientDto c1:l1) {
				if(c1.getUserName().equals(userName1)) {
					return	resultObject="true";
				}
			}
			return  resultObject="not found user";
		}
		else
			return resultObject="username not mached";
		
		
	}
	public String setNewpasswordToUsername(String username,String password) {
		String resultObject=null;
		List<ClientDto> l1  =cd.listOfClients();
		for(ClientDto c1:l1) {
			if(username.equals(c1.getUserName())) {
				c1.setConfirmPassword(password);
				c1.setCreatePassword(password);
				cd.updateClientDto(c1);
				resultObject="password changed successfully";
			}
		}
		return resultObject;
	}
	public String addMobileAttributesToDB(MobileDto mobile ,HttpServletRequest req) {
		if(req.getSession().getAttribute("request")==null) {
			System.out.println("&&&&&&&&&&&&&&&\n%%%%%%%%%%%%%%%%%\n%%%%%%%%%%%%%%%%%%\n");
				String resultObject=null;
				if((mobile.getMODEL_NAME().equals("")||mobile.getProccessor().equals("")||mobile.getBatteryCapacity()<3000||mobile.getRam()<1||mobile.getRom()<16||mobile.getCost()<10000||mobile.getImageBack().equals("")||mobile.getImageFront().equals("")||mobile.getImageSide().equals("")||mobile.getDisplay()<10||mobile.getFrontCam()<5||mobile.getBackCam()<5||mobile.getDiscount()<0)) {
					System.out.println(mobile.getMODEL_NAME()+"******************************************************");
					return "improper data given";
				}
				
				System.out.println(mobile.getMODEL_NAME());
				System.out.println("2nd************************************************************************************");
				cd.addMobileToDB(mobile);
				return "added successfully";
		
		}
		else if(req.getSession().getAttribute("request").equals("Update")) {
			String resultObject=null;
			if((mobile.getMODEL_NAME().equals("")||mobile.getProccessor().equals("")||mobile.getBatteryCapacity()<3000||mobile.getRam()<1||mobile.getRom()<16||mobile.getCost()<10000||mobile.getImageBack().equals("")||mobile.getImageFront().equals("")||mobile.getImageSide().equals("")||mobile.getDisplay()<10||mobile.getFrontCam()<5||mobile.getBackCam()<5||mobile.getDiscount()<0)) {
				System.out.println(mobile.getMODEL_NAME()+"******************************************************");
				return "improper data given";
			}
			
			
		}
		System.out.println(mobile.getMODEL_NAME());
		System.out.println("____________________**"+req.getSession().getAttribute("request"));
		System.out.println("2nd2************************************************************************************");
		cd.updateMobileToDB(mobile);
		return "added successfully";
	}
	public List<MobileDto> allMobiles(){
		List<MobileDto> l1=cd.allMobiles();
		return  l1;
		
	}
	

}
