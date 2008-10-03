package com.shenming.sms.manager;

import javax.servlet.http.HttpServletRequest;

import com.shenming.sms.dc.manager.SmsVipManager;
import com.shenming.sms.struts.form.ManagerLoginForm;

public class AccountManager {
	/**
	 * Get the account type from session scope
	 * @param request
	 * @return
	 */
	public static synchronized String accountType(HttpServletRequest request) {
		ManagerLoginForm m = (ManagerLoginForm)request.getSession().getAttribute("managerLoginForm");
		if(m != null ){
			return m.getUserType();
		}
		
		return null;
	}
	
	public static synchronized String currentUser(HttpServletRequest request) {
		ManagerLoginForm m = (ManagerLoginForm)request.getSession().getAttribute("managerLoginForm");
		if(m != null ){
			return m.getUsername();
		}
		
		return null;
	}
	
	/**
	 * Check the user from session scope and return true if user is manager, and vice versa.
	 * @param request
	 * @return
	 */
	public static synchronized boolean isManager(HttpServletRequest request){
		if(SmsVipManager.MANAGER_ID.equalsIgnoreCase(AccountManager.accountType(request)))
			return true;
		
		return false;
	}
	
	public static synchronized String getMyName(HttpServletRequest request){
		ManagerLoginForm m = (ManagerLoginForm)request.getSession().getAttribute("managerLoginForm");
		if(m != null ){
			return m.getUsername();
		}
		return null;
	} 
	
	public static synchronized int getMyVipId(HttpServletRequest request){
		ManagerLoginForm m = (ManagerLoginForm)request.getSession().getAttribute("managerLoginForm");
		if(m != null ){
			return SmsVipManager.retrieveUserIdByName(m.getUsername());
		}
		return 0;
	} 
	
	//public static synchronized boolean isManager(HttpServletRequest request){
}
