package com.shenming.sms.manager;

import javax.servlet.http.HttpServletRequest;

import com.shenming.sms.util.Tool;

public class FormManager {
	public static synchronized String currentFormPage(HttpServletRequest request){
		String fn = request.getParameter("fn")!=null?request.getParameter("fn"):"jsp";
		String fo = request.getParameter("fo")!=null?(request.getParameter("fo")+"/"):"";
		String paramPage = (String)(request.getParameter("page")!=null?request.getParameter("page"):"");
		String requestPage = (String)(request.getAttribute("page")!=null?request.getAttribute("page"):"");
		String sessionPage = (String)(request.getSession().getAttribute("page")!=null?request.getSession().getAttribute("page"):"");
//		System.out.println("==>Param:"+paramPage+"::Request:"+requestPage+"::Session:"+sessionPage);
		if(isNotEmpty(paramPage)){
			Tool.logDebug("Using param page: "+ paramPage, 3);
			return fo + paramPage + "." + fn;
		} else if (isNotEmpty(requestPage)){
			Tool.logDebug("Using request page: "+ requestPage, 3);
			return fo + requestPage + "." + fn;
		} else if (isNotEmpty(sessionPage)){
			Tool.logDebug("Using session page: "+ sessionPage, 3);
			return fo + sessionPage + "." + fn;
		}
		
		return null;
	}
	
	private static boolean isNotEmpty(String str){
		if(str != null && !"".equalsIgnoreCase(str))
			return true;
		return false;
	}
}
