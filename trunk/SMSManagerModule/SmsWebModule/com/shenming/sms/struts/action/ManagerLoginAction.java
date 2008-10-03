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
			request.setAttribute("message", "謝謝光臨!");
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
			request.setAttribute("message", "您的帳號不具備管理者權限，請與系統管理者確認!");
			return mapping.findForward(MESSAGE);
		}
		
		request.setAttribute("message", "登入錯誤，請重新登入!");
		return mapping.findForward(MESSAGE);
	}

}
