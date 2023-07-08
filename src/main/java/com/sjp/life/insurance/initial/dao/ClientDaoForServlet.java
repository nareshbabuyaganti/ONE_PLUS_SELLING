package com.sjp.life.insurance.initial.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.sjp.life.insurance.initial.dto.MobileDto;

public class ClientDaoForServlet {
	
	public  List<MobileDto> AllMobiles(){
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("vikas");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		Query q=em.createQuery("select m from MobileDto m");
		List<MobileDto> mobileList=q.getResultList();
		return mobileList;
		
		
	}

}
