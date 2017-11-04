package com.munsiji.resource.reqres;

public class ServerResponse {

	boolean isSuccess;
	ErrorInfo erroInfo;
	SuccessInfoResponse successInfo;
	public boolean isSuccess() {
		return isSuccess;
	}
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	public ErrorInfo getErroInfo() {
		return erroInfo;
	}
	public void setErroInfo(ErrorInfo erroInfo) {
		this.erroInfo = erroInfo;
	}
	public SuccessInfoResponse getSuccessInfo() {
		return successInfo;
	}
	public void setSuccessInfo(SuccessInfoResponse successInfo) {
		this.successInfo = successInfo;
	}
	
}
