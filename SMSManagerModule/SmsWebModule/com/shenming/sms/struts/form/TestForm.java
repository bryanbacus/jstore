package com.shenming.sms.struts.form;

import org.apache.struts.validator.ValidatorForm;

public class TestForm extends ValidatorForm {

	private String username;

	private String password;

	private String parameters[];

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

	public String[] getParameters() {
		return parameters;
	}

	public void setParameters(String[] string) {
		parameters = string;
	}

	public TestForm() {
		// TODO Auto-generated constructor stub
	}

}
