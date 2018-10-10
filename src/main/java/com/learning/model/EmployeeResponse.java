package com.learning.model;

public class EmployeeResponse {
	
	String responseCode;
	String codeDesc;
	
	
	
	/**
	 * @param responseCode
	 * @param codeDesc
	 */
	public EmployeeResponse(String responseCode, String codeDesc) {
		super();
		this.responseCode = responseCode;
		this.codeDesc = codeDesc;
	}
	public String getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}
	public String getCodeDesc() {
		return codeDesc;
	}
	public void setCodeDesc(String codeDesc) {
		this.codeDesc = codeDesc;
	}
	

}
