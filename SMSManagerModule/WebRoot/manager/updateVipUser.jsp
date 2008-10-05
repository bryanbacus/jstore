<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@ page import="com.shenming.sms.module.hibernateOrm.*,
		com.shenming.sms.dc.manager.*,
		com.shenming.sms.struts.form.VipAccountForm,
		com.shenming.sms.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Insert title here</title>
</head>
<body>
<%
	int id = new Integer(request.getParameter("id")).intValue();
	//Prepare account information
	SmTbVipAccount ac = SmsVipManager.retrieveUserById(id);
	if(ac == null || ac.getUserId() == 0 ){
		request.setAttribute("message","無USER_ID="+id+"之資料或您指定的USER_ID為系統管理者(USER_ID=0)，請重新確認");
%>
<jsp:forward page="/main.jsp?page=message"/>
<%
	}
		
	VipAccountForm vo = VipAccountForm.beanToVipAccountForm(ac);
	vo.setFormType(VipAccountForm.UPDATE);
	
	//Prepare group information
	SmTbAccountGroup group = SmsVipManager.retrieveAccountGroupByUserId(new Integer(id));
	vo.setAccountType(group.getRoleType());
	vo.setDescription(Tool.encodeISO88591ToBig5(group.getDescription()));
	
	request.setAttribute("vipAccountForm", vo);
%>
<jsp:forward page="/main.jsp?fo=manager&page=createVipUser"/>
</body>
</html>