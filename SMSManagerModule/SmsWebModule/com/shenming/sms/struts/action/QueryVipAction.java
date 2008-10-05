package com.shenming.sms.struts.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.shenming.sms.dc.manager.SmsVipManager;
import com.shenming.sms.module.hibernateOrm.SmTbVipAccount;
import com.shenming.sms.struts.form.QueryVipForm;
import com.shenming.sms.util.Tool;

public class QueryVipAction extends Action {

	/* forward name="success" path="/manager/queryVipUser.jsp" */
	private final static String SUCCESS = "success";

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		QueryVipForm queryForm = (QueryVipForm)form;
		queryForm.setVipChtName(Tool.encodeISO88591ToBig5(queryForm.getVipChtName()));
		List<SmTbVipAccount> accounts = new ArrayList<SmTbVipAccount>();
		SmsVipManager.initialize();
		if("all".equalsIgnoreCase(request.getParameter("qt"))){
			accounts = SmsVipManager.retrieveAllUser();
			log("List All: "+accounts, 3);
		} else {
			accounts = SmsVipManager.retrieveUserByQueryForm(queryForm);
			log("Query by queryForm: "+accounts, 3);
		}
		
		request.getSession().setAttribute("vipAccounts", accounts);
		
		return mapping.findForward(SUCCESS);
	}
	
	private void log(String msg, int level){
		//Tool.logDebug("[QueryVipAction]"+msg, level);
	}
}
