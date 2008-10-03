package com.shenming.sms.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.shenming.sms.dc.manager.SmsVipManager;
import com.shenming.sms.struts.form.ManagerLoginForm;

public class ManagerLoginAction extends Action {

	/* forward name="success" path="/main.jsp?page=welcome" */
	private final static String SUCCESS = "success";

	/* forward name="message" path="/message.jsp" */
	private final static String MESSAGE = "message";

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		/**
		 * Logout will remove the managerLoginForm in session
		 */
		if("logout".equalsIgnoreCase(request.getParameter("type"))){
			request.getSession().removeAttribute("managerLoginForm");
			request.setAttribute("message", "���¥��{!");
			return mapping.findForward(MESSAGE);
		}
		
		/**
		 * Manager's session will set:
		 * 1. managerLoginForm != null
		 * 2. managerLoginForm.getUserType() = SmsVipManager.MANAGER_ID
		 */
		ManagerLoginForm loginForm = (ManagerLoginForm)form;
		if(SmsVipManager.isAdmin(loginForm.getUsername(), loginForm.getPassword())){
			ManagerLoginForm m = (ManagerLoginForm)request.getSession().getAttribute("managerLoginForm");
			m.setUserType(SmsVipManager.ADMIN_ID);
			m.setValiedUser(true);
			request.getSession().setAttribute("managerLoginForm", m);
			return mapping.findForward(SUCCESS);
		} else if(SmsVipManager.isManager(loginForm.getUsername(), loginForm.getPassword())){
			ManagerLoginForm m = (ManagerLoginForm)request.getSession().getAttribute("managerLoginForm");
			m.setUserType(SmsVipManager.MANAGER_ID);
			m.setValiedUser(true);
			request.getSession().setAttribute("managerLoginForm", m);
			return mapping.findForward(SUCCESS);
		} else if(SmsVipManager.isValiedUser(loginForm.getUsername(), loginForm.getPassword())){
			request.setAttribute("message", "�z���b������ƺ޲z���v���A�лP�t�κ޲z�̽T�{!");
			return mapping.findForward(MESSAGE);
		}
		
		request.setAttribute("message", "�n�J���~�A�Э��s�n�J!");
		return mapping.findForward(MESSAGE);
	}

}
