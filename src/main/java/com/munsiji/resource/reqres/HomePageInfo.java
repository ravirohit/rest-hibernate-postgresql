package com.munsiji.resource.reqres;

public class HomePageInfo extends SuccessInfoResponse{
	String fname;
	String loginId;
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	
}
