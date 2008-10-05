package com.shenming.sms.struts.form;

import org.apache.struts.validator.ValidatorForm;

public class ManagerLoginForm extends ValidatorForm {

	private boolean isValiedUser;
	
	private String username;

	private String password;

	private String userType;
	
	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String string) {
		username = string;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String string) {
		password = string;
	}

	public ManagerLoginForm() {
		// TODO Auto-generated constructor stub
	}

	public boolean isValiedUser() {
		return isValiedUser;
	}

	public void setValiedUser(boolean isValiedUser) {
		this.isValiedUser = isValiedUser;
	}

}
