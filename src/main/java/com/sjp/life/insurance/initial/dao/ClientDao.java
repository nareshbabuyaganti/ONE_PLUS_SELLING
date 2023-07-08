package com.sjp.life.insurance.initial.dao;

import java.util.LinkedHashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sjp.life.insurance.initial.dto.ClientDto;
import com.sjp.life.insurance.initial.dto.MobileDto;

@Repository
public class ClientDao {

	@Autowired 
    private	EntityManager em;
	@Autowired
	private EntityTransaction et;
	
	
	public ClientDto saveClient(ClientDto c1) {
		
		et.begin();
		em.persist(c1);
		et.commit();
		return  c1;
		
	}
	public ClientDto updateClientDto(ClientDto c1) {
		
		et.begin();
		em.merge(c1);
		et.commit();
		return c1;
	}
	public LinkedHashMap<String,String >  existCheckingOfRegister(String emailEC,String userNameEC ,long phoneEC) {
		LinkedHashMap<String ,String> m1=new LinkedHashMap();
		String MDPhone=""+phoneEC;
		et.begin();
		Query q=em.createQuery("select c from ClientDto c");
		et.commit();
		System.out.println("*************************************************");
		System.out.println(em +" em*********************************");
		System.out.println(em+" ***************em1");
		List<ClientDto> l1=q.getResultList();
		for(ClientDto c1:l1) {
			String DBPhone=""+c1.getPhoneNumber();
			
			if(c1.getEmailId().equalsIgnoreCase(emailEC)) {
				m1.put("emailEC","Exist");
				break;
			}
			if(c1.getUserName().equalsIgnoreCase(userNameEC)) {
				m1.put("userNameEC", "Exist");
				break;
			}
			 if(DBPhone.equals(MDPhone)) {
				m1.put("phoneEC", "Exist");
				break;
			}
			
		}
		if(m1.size()>=1) {
			return m1;
		}
		m1.put("emailEC","NotExist");
		m1.put("userNameEC","NotExist");
		m1.put("phoneEC","NotExist");
		return m1;
		
	}
	
	public List<ClientDto> existCheckingLogIn(String userName,String password,HttpServletRequest req) {
		
		EntityManagerFactory emf1=Persistence.createEntityManagerFactory("vikas");
		EntityManager em1=emf1.createEntityManager();
		EntityTransaction et1 =em1.getTransaction();
		et1.begin();
		Query q=em1.createQuery("select c from ClientDto c");
		
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		System.out.println(em1);
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		System.out.println(em+" em");
		System.out.println(et+" et");
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		List<ClientDto> l1=q.getResultList();
		System.out.println(l1.size()+" ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		return l1;
		
	}
	

	public List<ClientDto> listOfClients() {
		
		EntityManagerFactory emf1=Persistence.createEntityManagerFactory("vikas");
		EntityManager em1=emf1.createEntityManager();
		EntityTransaction et1 =em1.getTransaction();
		et1.begin();
		Query q=em1.createQuery("select c from ClientDto c");
		
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		System.out.println(em1);
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		System.out.println(em+" em");
		System.out.println(et+" et");
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		List<ClientDto> l1=q.getResultList();
		System.out.println(l1.size()+" ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
		return l1;
		
	}
	public MobileDto addMobileToDB(MobileDto mobile) {
		
		et.begin();
		em.persist(mobile);
		et.commit();
		return mobile;
		
	}
	public MobileDto updateMobileToDB(MobileDto mobile) {
		et.begin();
		em.merge(mobile);
		et.commit();
		return mobile;
		
	}
	public List<MobileDto> allMobiles() {
		Query q=em.createQuery("select m from MobileDto m");
		List<MobileDto> l1 =q.getResultList();
		return l1;
		
	}

}
