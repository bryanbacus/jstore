package com.shenming.sms.struts.action;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.shenming.sms.module.hibernateOrm.SmTbVipAccount;
import com.shenming.sms.sender.impl.SMSSocketSender;
import com.shenming.sms.struts.form.SmsSenderForm;
import com.shenming.sms.util.Tool;

public class SingleSmsSenderAction extends Action {

	/* forward name="success" path="/sms/singleSmsSender.jsp" */
	private final static String SUCCESS = "success";
	private static final String MESSAGE = "message";
	private SmsSenderForm senderForm;
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		senderForm = (SmsSenderForm)form;
		if(SmsSenderForm.QUERY_MOBILE.equalsIgnoreCase(senderForm.getFormType())){
			return doQueryMobile(mapping, form, request, response);
		} else if(SmsSenderForm.SEND_SINGLE_SMS.equalsIgnoreCase(senderForm.getFormType())){
			return doSingleSend(mapping, form, request, response);
		}
		
		return mapping.findForward(SUCCESS);
	}

	private ActionForward doSingleSend(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		String mobile = senderForm.getMobileNbr();
		String msg = senderForm.getMsgContext();
		String rsp = "";
		if(Tool.isNotEmpty(mobile) && Tool.isNotEmpty(msg)){
			SMSSocketSender sender = new SMSSocketSender();
			sender.initial();
			rsp = sender.sendMessage(mobile, msg);
		}
		Tool.logDebug("SMS: "+ rsp, 3);
		request.setAttribute("message", rsp);
		return mapping.findForward(MESSAGE);
	}

	private ActionForward doQueryMobile(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		Iterator iter = senderForm.getVipList().iterator();
		while(iter.hasNext()){
			SmTbVipAccount account = (SmTbVipAccount)iter.next();
			if(senderForm.getVipId() == account.getUserId() &&
					Tool.isNotEmpty(account.getMobile())){
				senderForm.setMobileNbr(account.getMobile());
				request.setAttribute("smsSenderForm", senderForm);
				return mapping.findForward(SUCCESS);
			}
		}
		
		request.setAttribute("message", "無法查得該VIP或VIP之行動電話!請重新確認!");
		return mapping.findForward(MESSAGE);
	}

}
