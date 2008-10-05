package com.shenming.sms.struts.form;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts.validator.ValidatorForm;

import com.shenming.sms.dc.manager.SmsVipManager;
import com.shenming.sms.module.hibernateOrm.SmTbMessageQueue;
import com.shenming.sms.module.hibernateOrm.SmTbVipAccount;

public class QuerySmsHistoryForm extends ValidatorForm {

	public QuerySmsHistoryForm() {
		// TODO Auto-generated constructor stub
	}
	
	private String formType;
	
	private int vipId;
	
	private String mobileNbr;
	
	private String msgTitle;

	private String msgContext;

	private String createTimeStart;
	
	private String createTimeEnd;
	
	private String status;
	
	private String sentDateStart;
	
	private String sentDateEnd;
	
	private List<SmTbMessageQueue> smTbMessageQueues;
	
	private Map vipMap = SmsVipManager.retrieveAllUserMap();

	public String getFormType() {
		return formType;
	}

	public void setFormType(String formType) {
		this.formType = formType;
	}

	public String getMobileNbr() {
		return mobileNbr;
	}

	public void setMobileNbr(String mobileNbr) {
		this.mobileNbr = mobileNbr;
	}

	public String getMsgContext() {
		return msgContext;
	}

	public void setMsgContext(String msgContext) {
		this.msgContext = msgContext;
	}

	public String getMsgTitle() {
		return msgTitle;
	}

	public void setMsgTitle(String msgTitle) {
		this.msgTitle = msgTitle;
	}

	public List<SmTbMessageQueue> getSmTbMessageQueues() {
		return smTbMessageQueues;
	}

	public void setSmTbMessageQueues(List<SmTbMessageQueue> smTbMessageQueues) {
		this.smTbMessageQueues = smTbMessageQueues;
	}

	public int getVipId() {
		return vipId;
	}

	public void setVipId(int vipId) {
		this.vipId = vipId;
	}

	public Map getVipMap() {
		return vipMap;
	}

	public void setVipMap(Map vipMap) {
		this.vipMap = vipMap;
	}

	public String getCreateTimeEnd() {
		return createTimeEnd;
	}

	public void setCreateTimeEnd(String createTimeEnd) {
		this.createTimeEnd = createTimeEnd;
	}

	public String getCreateTimeStart() {
		return createTimeStart;
	}

	public void setCreateTimeStart(String createTimeStart) {
		this.createTimeStart = createTimeStart;
	}

	public String getSentDateEnd() {
		return sentDateEnd;
	}

	public void setSentDateEnd(String sentDateEnd) {
		this.sentDateEnd = sentDateEnd;
	}

	public String getSentDateStart() {
		return sentDateStart;
	}

	public void setSentDateStart(String sentDateStart) {
		this.sentDateStart = sentDateStart;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
