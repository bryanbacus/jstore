package com.shenming.sms.struts.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.shenming.sms.dc.manager.SenderManager;
import com.shenming.sms.dc.manager.SmsManager;
import com.shenming.sms.dc.manager.SmsVipManager;
import com.shenming.sms.manager.AccountManager;
import com.shenming.sms.module.hibernateOrm.SmTbMessageQueue;
import com.shenming.sms.module.hibernateOrm.SmTbVipAccount;
import com.shenming.sms.struts.form.SmsSenderForm;
import com.shenming.sms.util.DateUtil;

public class SmsConfigAction extends Action {
	private String SINGLE_SMS_CONFIG = "singleSmsConfig";
	private String BATCH_SMS_CONFIG = "batchSmsConfig";
	private String MESSAGE= "message";
	SmsSenderForm senderForm;
	int myId = 0;
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		myId = AccountManager.getMyVipId(request);
		senderForm = (SmsSenderForm)form;
		String formType = senderForm.getFormType();
		request.setAttribute("smsSenderForm", senderForm);
//		System.out.println("==>Current Queue List: "+senderForm.getSmTbMessageQueues());
		//Setting the SMS config parameters
		//Single Sms Configure
		if(SmsSenderForm.SINGLE_SMS_CONFIG.equalsIgnoreCase(formType)){
			return doSingleSmsConfig(mapping, form, request, response);
		} else if(SmsSenderForm.SINGLE_SMS_CONFIG_DETAILS.equalsIgnoreCase(formType)){
			return doSingleSmsConfigDetails(mapping, form, request, response);
		} else if (SmsSenderForm.SINGLE_SMS_SAVE.equalsIgnoreCase(formType)){
			return doSave(mapping, form, request, response);
		} else if (SmsSenderForm.BATCH_SMS_CONFIG.equalsIgnoreCase(formType)){
			return doBatchSmsConfig(mapping, form, request, response);
		} else if (SmsSenderForm.BATCH_SMS_CONFIG_DETAILS.equalsIgnoreCase(formType)){
			return doBatchSmsConfigDetails(mapping, form, request, response);
		} else if(SmsSenderForm.CHANGE_OPTION.equalsIgnoreCase(formType)){
			return doChangeBatchOption(mapping, form, request, response);
		} else if (SmsSenderForm.BATCH_SMS_SAVE.equalsIgnoreCase(formType)){
			return doBatchSmsSave(mapping, form, request, response);
		} else if(SmsSenderForm.RESET.equalsIgnoreCase(formType)){
			return doReset(mapping, form, request, response);
		} else if(SmsSenderForm.RESET_2_BATCH.equalsIgnoreCase(formType)){
			return doReset2Batch(mapping, form, request, response);
		} 
		//Batch Sms Configure
		else if (SmsSenderForm.BATCH_SMS_CONFIG.equalsIgnoreCase(formType)){
			return doBatchSmsConfig(mapping, form, request, response);
		} else { //Just transfer data
			request.setAttribute("smsSenderForm", senderForm);
			return mapping.findForward(SINGLE_SMS_CONFIG);
		}
			
	}

	
	private ActionForward doSave(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		boolean isSuccess = 
			SenderManager.doCreateMessageContext(
				senderForm.getMsgTitle(), senderForm.getMsgContext(),
				new java.sql.Date(new java.util.Date().getTime()), myId, 
				senderForm.getSmTbMessageQueues());
		
		request.getSession().removeAttribute("smsSenderForm");
		senderForm.setFormType(SmsSenderForm.DEFAULT);
		request.setAttribute("message", "簡訊建立結果：" + (isSuccess?"成功":"失敗"));
		return mapping.findForward(MESSAGE);
	}

	private ActionForward doReset(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		request.getSession().removeAttribute("smsSenderForm");
		senderForm.setFormType(SmsSenderForm.DEFAULT);
		return mapping.findForward(SINGLE_SMS_CONFIG);
	}
	
	private ActionForward doReset2Batch(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		request.getSession().removeAttribute("smsSenderForm");
		senderForm.setFormType(SmsSenderForm.DEFAULT);
		return mapping.findForward(BATCH_SMS_CONFIG);
	}

	private ActionForward doSingleSmsConfigDetails(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		senderForm.setFormType(SmsSenderForm.SINGLE_SMS_CONFIG_DETAILS); //Let go to create next send dist
		
		SmTbVipAccount vip = SmsVipManager.retrieveUserById(senderForm.getVipId());
		senderForm.getSendTime();
		
		List queueList = 
			((SmsSenderForm)request.getSession().getAttribute("smsSenderForm"))!= null &&
			((SmsSenderForm)request.getSession().getAttribute("smsSenderForm")).getSmTbMessageQueues() != null ? 
					senderForm.getSmTbMessageQueues() : new ArrayList();
					
		SmTbMessageQueue vo = new SmTbMessageQueue();
		vo.setIdx(senderForm.getVipId()); //Set the default index the same with vip id, and this will auto generate by MySQL
		vo.setMobile(vip.getMobile());
		vo.setSendDate(DateUtil.getSqlTimestampFromString(senderForm.getSendTime(), DateUtil.DATE_FORMAT_DAY_MONTH_YEAR_TIME_DASH));
		vo.setRecipientId(senderForm.getVipId());
		vo.setCreateDate(new java.sql.Timestamp(new java.util.Date().getTime()));
		vo.setCreateUserId(myId);
		vo.setStatus("I");
		queueList.add(vo);
		
		senderForm.setSmTbMessageQueues(queueList);
		
		return mapping.findForward(SINGLE_SMS_CONFIG);
	}

	private ActionForward doSingleSmsConfig(ActionMapping mapping, ActionForm form, 
			HttpServletRequest request, HttpServletResponse response) {
		senderForm.setFormType(SmsSenderForm.SINGLE_SMS_CONFIG_DETAILS);
		
		return mapping.findForward(SINGLE_SMS_CONFIG);
	}
	
	private ActionForward doBatchSmsConfig(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		senderForm.setFormType(SmsSenderForm.BATCH_SMS_CONFIG_DETAILS);
		
		return mapping.findForward(BATCH_SMS_CONFIG);
	}
	
	private ActionForward doBatchSmsConfigDetails(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		String option = senderForm.getOption();
		List<SmTbMessageQueue> list = null;
		java.sql.Date currentSqlDate = new java.sql.Date(DateUtil.getDateLongFromString(senderForm.getSendTime(),DateUtil.DATE_FORMAT_DAY_MONTH_YEAR_TIME_DASH));
		System.out.println("Get option:"+option + ";sql date:"+ currentSqlDate);
		if("insertMessageByVipChildSex".equalsIgnoreCase(senderForm.getRuleId())){
			list = SenderManager.convertSmTbMessageQueueByVipChildSex(
					option, myId, senderForm.getMsgContext(), currentSqlDate);
			
		} else if("insertMessageByVipOwner".equalsIgnoreCase(senderForm.getRuleId())){
			list = SenderManager.convertSmTbMessageQueueByVipGroup(
					new Integer(option).intValue(), myId, senderForm.getMsgContext(), currentSqlDate);
			
		} else if("insertMessageAllVip".equalsIgnoreCase(senderForm.getRuleId())){
			list = SenderManager.convertSmTbMessageQueueByAllVip(
					myId, senderForm.getMsgContext(), currentSqlDate);
			
		} //else if("insertMessageByDate".equalsIgnoreCase(senderForm.getRuleId())){
//			list = SenderManager.convertSmTbMessageQueueByVipChildSex(
//					option, myId, senderForm.getMsgContext(), currentSqlDate);
//		} 
		
		senderForm.setSmTbMessageQueues(list);
		return mapping.findForward(BATCH_SMS_CONFIG);
	}
	
	private ActionForward doChangeBatchOption(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		senderForm.setFormType(SmsSenderForm.BATCH_SMS_CONFIG_DETAILS);
		request.setAttribute("opt", senderForm.getRuleId());
		
		return mapping.findForward(BATCH_SMS_CONFIG);
	}
	
	private ActionForward doBatchSmsSave(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		boolean isSuccess = false;
		SenderManager.initialize();
//		SmTbVipAccount vip = SmsVipManager.retrieveUserById(senderForm.getVipId());
		String option = senderForm.getOption();
		
		if("insertMessageByVipChildSex".equalsIgnoreCase(senderForm.getRuleId())){
			isSuccess = SenderManager.doCreateMessageContext(
					"Batch insert order for sex:"+ option, 
					senderForm.getMsgContext(), DateUtil.getSystemSqlDate(), 
					myId, senderForm.getSmTbMessageQueues());
		} else if("insertMessageByVipOwner".equalsIgnoreCase(senderForm.getRuleId())){
			isSuccess = SenderManager.doCreateMessageContext(
					"Batch insert order for group by owner:"+ option, 
					senderForm.getMsgContext(), DateUtil.getSystemSqlDate(), 
					myId, senderForm.getSmTbMessageQueues());
		} //else if("insertMessageByDate".equalsIgnoreCase(senderForm.getRuleId())){
//			isSuccess = SenderManager.doCreateMessageContext(
//					"Batch insert order by date:"+ option, 
//					senderForm.getMsgContext(), DateUtil.getSystemSqlDate(), 
//					myId, senderForm.getSmTbMessageQueues());
//		} 
		
		request.getSession().removeAttribute("smsSenderForm");
		request.setAttribute("message", "簡訊建立結果：" + (isSuccess?"成功":"失敗"));
		return mapping.findForward(MESSAGE);
	}

}
