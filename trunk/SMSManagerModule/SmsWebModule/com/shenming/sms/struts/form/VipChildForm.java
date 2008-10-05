package com.shenming.sms.struts.form;

import org.apache.struts.validator.ValidatorForm;

public class VipChildForm extends ValidatorForm {


	public static final String CREATE = "create";
	public static final String DELETE = "delete";
	public static final String UPDATE = "update";
	
	private String formType = CREATE;

	private int idx;

	private int userId;
	
	private String username;

	private String vipChildName;
	
	private String vipChildSex;

	private String vipChildBirthday;

	public String getFormType() {
		return formType;
	}

	public void setFormType(String string) {
		formType = string;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int i) {
		idx = i;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int i) {
		userId = i;
	}

	public String getVipChildName() {
		return vipChildName;
	}

	public void setVipChildName(String string) {
		vipChildName = string;
	}

	public String getVipChildBirthday() {
		return vipChildBirthday;
	}

	public void setVipChildBirthday(String string) {
		vipChildBirthday = string;
	}

	public VipChildForm() {
		// TODO Auto-generated constructor stub
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getVipChildSex() {
		return vipChildSex;
	}

	public void setVipChildSex(String vipChildSex) {
		this.vipChildSex = vipChildSex;
	}

}
