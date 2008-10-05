package com.shenming.sms.struts.form;

import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.TreeMap;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConversionException;
import org.apache.struts.validator.ValidatorForm;

import com.shenming.sms.dc.manager.SmsVipManager;
import com.shenming.sms.module.hibernateOrm.SmTbVipAccount;
import com.shenming.sms.util.DateUtil;
import com.shenming.sms.util.SystemParametersManager;
import com.shenming.sms.util.Tool;

public class VipAccountForm extends ValidatorForm{

	public static final String CREATE = "create";
	public static final String UPDATE = "update";
	public static final String DELETE = "delete";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String CHECK = "check";
	public static final String CHECK_VIP_CHT_NAME = "checkVipChtName";
	public static final String CHECK_VIP_ENG_NAME = "checkVipEngName";
	public static final String CHECK_VIP_MAI¢Ú_ADDR = "checkMailAddr";
	public static final String CHECK_VIP_ADDRESS = "checkAddress";
	public static final String CHECK_SID = "checkSid";

	public VipAccountForm() {
		// TODO Auto-generated constructor stub
	}
	private String formType = CREATE; //Using for create, update and default create
	private Integer userId;
	private String address;
	private String birthday = DateUtil.convertDateToString(new Date(), SystemParametersManager.pattern);
	private String blood;
	private long buySum;
	private String crDate = DateUtil.convertDateToString(new Date(), SystemParametersManager.pattern);
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
	private String sid;
	private String store;
	private String storeEmployeeName;
	private String vipLevel;
	/**
	 * Extra Info of ADMIN | MANAGER | VIP
	 */
	private String accountType;
	/**
	 * Extra Info of description
	 */
	private String description;
	
	private TreeMap<String, Integer> vipMap = SmsVipManager.retrieveManagerUserMap();
	
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
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
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
	public TreeMap<String, Integer> getVipMap() {
		return vipMap;
	}
	public void setVipMap(TreeMap<String, Integer> vipMap) {
		this.vipMap = vipMap;
	}
	public String getFormType() {
		return formType;
	}
	public void setFormType(String formType) {
		this.formType = formType;
	}

	public static SmTbVipAccount formToSmTbVipAccount(VipAccountForm vipForm){
		HashMap vipMap;
		SmTbVipAccount vo = null;
		try {
			vipMap = (HashMap) BeanUtils.describe(vipForm);
			//vipMap.remove(vipForm.getUserId()); //Not sync the primary key
			Tool.logDebug("Form to Map: "+ vipMap , 3);
			vo = new SmTbVipAccount();
			
			vipMap.put("birthday", convert2Timestamp(vipMap, "birthday"));
			vipMap.put("crDate", convert2Timestamp(vipMap, "crDate"));
			
			BeanUtils.populate(vo, Tool.encodeMapISO88591ToBig5(vipMap));
//			vo.setVipChtName(Tool.encodeISO88591ToBig5((String)vipMap.get("vipChtName")));
//			vo.setAddress(Tool.encodeISO88591ToBig5((String)vipMap.get("address")));
//			vo.setFovarite(Tool.encodeISO88591ToBig5((String)vipMap.get("fovarite")));
//			vo.setJob(Tool.encodeISO88591ToBig5((String)vipMap.get("job")));
//			vo.setStore(Tool.encodeISO88591ToBig5((String)vipMap.get("store")));
//			vo.setStoreEmployeeName(Tool.encodeISO88591ToBig5((String)vipMap.get("storeEmployeeName")));
//			vo.setUsername(Tool.encodeISO88591ToBig5((String)vipMap.get("username")));
			
			if(vipMap.get("username") instanceof String){
				System.out.println(">>>>>>>>>username is a String...");
			} else {
				System.out.println(">>>>>>>>>username is NOT a String...");
			}
			if(vipMap.get("birthday") instanceof String){
				System.out.println(">>>>>>>>>birthday is a String...");
			} else {
				System.out.println(">>>>>>>>>birthday is NOT a String...");
			}
//			vo.setBirthday(birthday);
//			vo.setCrDate(crDate);
			
			if(vipForm.getOwner() > 0 && vo.getUserId() > 0){
				SmTbVipAccount smTbVipAccount = SmsVipManager.retrieveUserById(vo.getUserId());
				vo.setSmTbVipAccount(smTbVipAccount);
			}
			Tool.logDebug("After populate: "+ vo.getUserId() + "," +
					vo.getUsername()+","+vo.getVipChtName()+","+vo.getVipEngName(), 3);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ConversionException e) {
//			 TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return vo;
	}
	
	private static java.sql.Timestamp convert2Timestamp(HashMap hm, String column){
		/*Convert to dd-MM-yyyy HH:mm:ss*/
		return new Timestamp(
				DateUtil.getDateFromString(
						(String)hm.get(column),
						DateUtil.DATE_FORMAT_DAY_MONTH_YEAR_TIME_DASH).getTime());
	}
	
	public static VipAccountForm beanToVipAccountForm( SmTbVipAccount bean){
		HashMap vipMap;
		VipAccountForm vo = null;
		try {
			vipMap = (HashMap) BeanUtils.describe(bean);
			Tool.logDebug("Form to Map: "+ vipMap , 3);
			vo = new VipAccountForm();
			BeanUtils.populate(vo, vipMap);
			if(bean.getSmTbVipAccount()!=null &&  
					bean.getSmTbVipAccount()!=null && 
					bean.getSmTbVipAccount().getUserId() > 0 ){
				vo.setOwner(bean.getSmTbVipAccount().getUserId());
			}
				
			Tool.logDebug("After populate: "+ 
					vo.getUsername()+","+vo.getVipChtName()+","+vo.getVipEngName(), 3);
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InvocationTargetException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (NoSuchMethodException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return vo;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getStore() {
		return store;
	}
	public void setStore(String store) {
		this.store = store;
	}
	public String getStoreEmployeeName() {
		return storeEmployeeName;
	}
	public void setStoreEmployeeName(String storeEmployeeName) {
		this.storeEmployeeName = storeEmployeeName;
	}
	public String getVipLevel() {
		return vipLevel;
	}
	public void setVipLevel(String vipLevel) {
		this.vipLevel = vipLevel;
	}
}
