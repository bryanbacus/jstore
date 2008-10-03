package com.shenming.sms.struts.form;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.struts.validator.ValidatorForm;

import com.shenming.sms.dc.manager.SmsVipManager;
import com.shenming.sms.util.DateUtil;

public class QueryVipForm extends ValidatorForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public QueryVipForm() {
		SmsVipManager.initialize();
		ownerMap = SmsVipManager.retrieveManagerUserMap();
	}
	
	private String userId;
	private String address;
	private String birthday ;
	private String blood;
	private long buySum;
	private String crDate ;
	private Integer errorCnt;
	private String fovarite;
	private String isAccountActive;
	private String isValidVip;
	private String job;
	private String mailAddr;
	private String marrage;
	private String mobile;
	private String password;
	private String phone;
	private String sex;
	private String username;
	private String vipChtName;
	private String vipEngName;
	private Integer owner;
	
	private String childBirthday;
	private String vipLevel;
	private String childSex;
	private Map ownerMap;
	private String sid;
	
	/**
	 * Extra Info of ADMIN | MANAGER | VIP
	 */
	private String accountType;
	/**
	 * Extra Info of description
	 */
	private String description;
	
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public Integer getOwner() {
		return owner;
	}
	public void setOwner(Integer owner) {
		this.owner = owner;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getBlood() {
		return blood;
	}
	public void setBlood(String blood) {
		this.blood = blood;
	}
	public long getBuySum() {
		return buySum;
	}
	public void setBuySum(long buySum) {
		this.buySum = buySum;
	}
	public Integer getErrorCnt() {
		return errorCnt;
	}
	public void setErrorCnt(Integer errorCnt) {
		this.errorCnt = errorCnt;
	}
	public String getFovarite() {
		return fovarite;
	}
	public void setFovarite(String fovarite) {
		this.fovarite = fovarite;
	}
	public String getIsAccountActive() {
		return isAccountActive;
	}
	public void setIsAccountActive(String isAccountActive) {
		this.isAccountActive = isAccountActive;
	}
	public String getIsValidVip() {
		return isValidVip;
	}
	public void setIsValidVip(String isValidVip) {
		this.isValidVip = isValidVip;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getMailAddr() {
		return mailAddr;
	}
	public void setMailAddr(String mailAddr) {
		this.mailAddr = mailAddr;
	}
	public String getMarrage() {
		return marrage;
	}
	public void setMarrage(String marrage) {
		this.marrage = marrage;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getVipChtName() {
		return vipChtName;
	}
	public void setVipChtName(String vipChtName) {
		this.vipChtName = vipChtName;
	}
	public String getVipEngName() {
		return vipEngName;
	}
	public void setVipEngName(String vipEngName) {
		this.vipEngName = vipEngName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getCrDate() {
		return crDate;
	}
	public void setCrDate(String crDate) {
		this.crDate = crDate;
	}
	public String getChildBirthday() {
		return childBirthday;
	}
	public void setChildBirthday(String childBirthday) {
		this.childBirthday = childBirthday;
	}
	public String getChildSex() {
		return childSex;
	}
	public void setChildSex(String childSex) {
		this.childSex = childSex;
	}
	public String getVipLevel() {
		return vipLevel;
	}
	public void setVipLevel(String vipLevel) {
		this.vipLevel = vipLevel;
	}
	public Map getOwnerMap() {
		return ownerMap;
	}
	public void setOwnerMap(Map ownerMap) {
		this.ownerMap = ownerMap;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}

}
