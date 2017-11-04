package com.munsiji.daoImp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HibernateUtil {
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		Session session=sessionFactory.openSession();
		System.out.println("sessionFactory:"+sessionFactory);
		System.out.println("Session :"+sessionFactory.openSession());
		
		return session;
	}
}
