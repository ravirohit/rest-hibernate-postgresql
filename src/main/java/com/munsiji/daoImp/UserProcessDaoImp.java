package com.munsiji.daoImp;

import org.springframework.stereotype.Repository;

import com.munsiji.resource.UserDetail;
import com.munsiji.resource.reqres.LoginReq;

@Repository
public class UserProcessDaoImp extends HibernateUtil implements UserProcessDao{

	
	
	public String LoginValidate(LoginReq loginReq){
		String result=null;		
		System.out.println("getSession:"+getSession());		
		return result;
	}
	
	public String register(UserDetail user){
        String result=null;		
		System.out.println("getSession:"+getSession());	
		getSession().save(user);
		return result;
	}
}
