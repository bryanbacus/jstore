<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.shenming.sms.module.hibernateOrm.*,
		com.shenming.sms.dc.manager.*,
		com.shenming.sms.struts.form.VipAccountForm" %>
		
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Insert title here</title>
</head>
<body>
<%
String idx = (String)request.getParameter("idx"); 
String act = (String)request.getParameter("act"); 
if(idx != null && !"".equalsIgnoreCase(idx)){
	SmTbVipAccount account = SmsVipManager.retrieveUserById(new Integer(idx).intValue());
	request.setAttribute("createdVip", account);
	
	if(account != null){
		if("show".equalsIgnoreCase(act)){
			//getServletContext().getRequestDispatcher("/sms/main.jsp?fo=manager&page=showVipDetail");
%>
			<jsp:forward page="/main.jsp?fo=manager&page=createVipSuccess"/>	
<%
		}else if("tag".equalsIgnoreCase(act)){
%>
			<jsp:forward page="/manager/showVipTag.jsp"/>	
<%
		}else{
%>
			<jsp:forward page="/main.jsp?fo=manager&page=createVipSuccess"/>	
<%
		}
		
		//<jsp:forward page="/main.jsp?fo=manager&page=createVipSuccess"/>	
	} else {
		request.setAttribute("message", "查詢使用者[id=" + idx + "]錯誤，請重新輸入");
%>
<jsp:forward page="/main.jsp?page=message"/>
<%
	}
} else {
	request.setAttribute("message", "查詢使用者[id=" + idx + "]錯誤，請重新輸入");
%>
<jsp:forward page="/main.jsp?page=message"/>
<%} %>

</body>
</html>