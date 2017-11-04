package com.munsiji.daoImp;

import com.munsiji.resource.UserDetail;
import com.munsiji.resource.reqres.LoginReq;

public interface UserProcessDao {

	String LoginValidate(LoginReq loginReq);

	String register(UserDetail user);

}
