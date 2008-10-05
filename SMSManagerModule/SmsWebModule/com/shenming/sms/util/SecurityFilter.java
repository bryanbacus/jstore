package com.shenming.sms.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shenming.sms.manager.AccountManager;

public class SecurityFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(
			ServletRequest request, 
			ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		String currentPath = ((HttpServletRequest) request).getServletPath();
		String queryString = ((HttpServletRequest) request).getQueryString();
//		log("=====>"+queryString);
		String accountType = AccountManager.accountType((HttpServletRequest)request);
		
		log("[Filter]Current Path: " + currentPath + "\tQueryString:" + queryString );
		log("[Filter]Server Path: " + ((HttpServletRequest) request).getLocalName() + 
				"\tAccount Type: " + accountType);
		log("[Filter]Referer Path: " + ((HttpServletRequest) request).getHeader("referer"));
		
		if("admin".equalsIgnoreCase(accountType) || "manager".equalsIgnoreCase(accountType) ){
			chain.doFilter(request, response);
		} else {
			((HttpServletRequest)request).setAttribute("message", "尚未登入系統，請重新確認，謝謝!");
			if(this.isNormalPath(currentPath) && this.isNormalQueryString(queryString)){
				chain.doFilter(request, response);
			} else {
				((HttpServletResponse) response).sendRedirect(
				          ((HttpServletRequest) request).getContextPath() + "/main.jsp?page=message");
			}
		}
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
	private void log(String msg){
		Tool.logDebug(msg, 3);
	}

	private boolean isNormalPath(String path){
		if(path.equalsIgnoreCase("/main.jsp") || 
				path.equalsIgnoreCase("/index.jsp") ||
				path.equalsIgnoreCase("/manager/loginAction.do"))
			return true;
		else
			return false;
	}
	
	private boolean isNormalQueryString(String queryString){
		if(queryString == null)
			return true;
		else if(queryString != null && "page=message".equalsIgnoreCase(queryString))
			return true;
		
		return false;
	}
}
