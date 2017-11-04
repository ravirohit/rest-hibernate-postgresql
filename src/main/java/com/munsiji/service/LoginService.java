package com.munsiji.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.munsiji.daoImp.UserProcessDao;
import com.munsiji.daoImp.UserProcessDaoImp;
import com.munsiji.resource.reqres.HomePageInfo;
import com.munsiji.resource.reqres.LoginReq;
import com.munsiji.resource.reqres.ServerResponse;
import com.munsiji.resource.reqres.SuccessInfoResponse;

@Component
public class LoginService {
	
	@Autowired
	UserProcessDao userProcessDao;			
	public ServerResponse processReq(LoginReq loginReq){
		System.out.println("entered to processReq:"+userProcessDao);
		ServerResponse serverResponse=new ServerResponse();
		SuccessInfoResponse successInfoResponse=null;
		HomePageInfo homePageInfo=new HomePageInfo();
		// if() login use is true
		//get user req info from  DB and set to response obj
		//
		userProcessDao.LoginValidate(loginReq);
			
		homePageInfo.setFname("Rohit");
		homePageInfo.setLoginId("1234567891");
		
		serverResponse.setSuccess(true);
		serverResponse.setErroInfo(null);
		serverResponse.setSuccessInfo(homePageInfo);
        return serverResponse;
		
	}

}
