package com.shenming.sms.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.shenming.sms.util.Tool;

public abstract class AbsSmsAction extends Action {
	
	public void log(String msg){
		Tool.logDebug(msg,3);
	}
	
	public ActionForward doForward(
			ActionMapping mapping,
			HttpServletRequest request,
			String forward,
			String msg) {
		request.setAttribute("message", msg);
		return mapping.findForward(forward);
	}

}
