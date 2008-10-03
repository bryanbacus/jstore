package com.shenming.sms.struts.form;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.ValidatorForm;

import com.shenming.sms.dc.manager.SmsVipManager;
import com.shenming.sms.module.hibernateOrm.SmTbMessageQueue;
import com.shenming.sms.module.hibernateOrm.SmTbVipAccount;

public class SmsSenderForm extends ValidatorForm {

	public static final String DEFAULT = "default";
	public static final String RESET = "reset";
	public static final String RESET_2_BATCH = "reset2Batch";
	public static final String QUERY_MOBILE = "queryMobile";
	public static final String SEND_SINGLE_SMS = "sendSingleSms";
	
	public static final String SINGLE_SMS_CONFIG = "singleSmsConfig";
	public static final String SINGLE_SMS_CONFIG_DETAILS = "singleSmsConfigDetails";
	public static final String SINGLE_SMS_SAVE = "singleSmsSave";
	
	public static final String BATCH_SMS_CONFIG = "batchSmsConfig";
	public static final String BATCH_SMS_CONFIG_DETAILS = "batchSmsConfigDetails";
	public static final String BATCH_SMS_SAVE = "batchSmsSave";
	
	
	public static final String CHANGE_OPTION = "changeOption";
	
	private String formType = DEFAULT;
	
	private String ruleId ;
	
	private String option;
	
	private int vipId;
	
	private String mobileNbr;
	
	private Map vipMap = SmsVipManager.retrieveAllUserMap();
	
	private List<SmTbVipAccount> vipList = SmsVipManager.retrieveAllUser();
	
	private SmTbMessageQueue smTbMessageQueue;
	
	private List<SmTbMessageQueue> smTbMessageQueues;

	private String msgTitle;

	private String msgContext;

	private String sendTime;

	private Date createTime = new Date();

	public int getVipId() {
		return vipId;
	}

	public void setVipId(int i) {
		vipId = i;
	}

	public String getMsgTitle() {
		return msgTitle;
	}

	public void setMsgTitle(String string) {
		msgTitle = string;
	}

	public String getMsgContext() {
		return msgContext;
	}

	public void setMsgContext(String string) {
		msgContext = string;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date date) {
		createTime = date;
	}

	public SmsSenderForm() {
		// TODO Auto-generated constructor stub
	}

	public String getFormType() {
		return formType;
	}

	public void setFormType(String formType) {
		this.formType = formType;
	}

	public List<SmTbVipAccount> getVipList() {
		return vipList;
	}

	public void setVipList(List<SmTbVipAccount> vipList) {
		this.vipList = vipList;
	}

	public String getMobileNbr() {
		return mobileNbr;
	}

	public void setMobileNbr(String mobileNbr) {
		this.mobileNbr = mobileNbr;
	}

	public SmTbMessageQueue getSmTbMessageQueue() {
		return smTbMessageQueue;
	}

	public void setSmTbMessageQueue(SmTbMessageQueue smTbMessageQueue) {
		this.smTbMessageQueue = smTbMessageQueue;
	}

	public List<SmTbMessageQueue> getSmTbMessageQueues() {
		return smTbMessageQueues;
	}

	public void setSmTbMessageQueues(List<SmTbMessageQueue> smTbMessageQueues) {
		this.smTbMessageQueues = smTbMessageQueues;
	}

	public String getSendTime() {
		return sendTime;
	}

	public void setSendTime(String sendTime) {
		this.sendTime = sendTime;
	}

	public Map getVipMap() {
		return vipMap;
	}

	public void setVipMap(Map vipMap) {
		this.vipMap = vipMap;
	}

	public String getRuleId() {
		return ruleId;
	}

	public void setRuleId(String ruleId) {
		this.ruleId = ruleId;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}
}
