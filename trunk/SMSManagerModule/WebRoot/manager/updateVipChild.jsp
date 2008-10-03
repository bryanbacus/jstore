<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@ page import="com.shenming.sms.module.hibernateOrm.*,
		com.shenming.sms.dc.manager.*,
		com.shenming.sms.util.*,
		com.shenming.sms.struts.form.VipChildForm" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Insert title here</title>
</head>
<body>

<%
	String username = (String)request.getParameter("name"); //VIP username
	int idx = new Integer(request.getParameter("idx")).intValue(); //VIP child's index
	SmTbVipAccount ac = SmsVipManager.retrieveUserByName(username);
	if(ac == null || ac.getUserId() == 0 ){
		request.setAttribute("message","無username="+username+"之資料，請重新確認");
%>
<jsp:forward page="/main.jsp?page=message"/>
<%
	}
	//Prepare account information
	SmTbVipAccountDetail child = SmsVipManager.retrieveChildByUsernameAndChildIdx(username, idx);
	VipChildForm vipChildForm = new VipChildForm();
	if(VipChildForm.DELETE.equalsIgnoreCase(request.getParameter("type"))){
		SmsVipManager.deleteChildByUserIdAndChildIdx(ac.getUserId(), idx);
		//Reset to CREATE
		vipChildForm.setFormType(VipChildForm.CREATE);
	} else {
		vipChildForm.setFormType(VipChildForm.UPDATE);
		vipChildForm.setIdx(child.getIdx());
		vipChildForm.setVipChildName(child.getVipChildName());
		vipChildForm.setVipChildBirthday(DateUtil.convertDateToString(child.getVipChildBirthday(),DateUtil.DATE_FORMAT_DAY_MONTH_YEAR_TIME_DASH));
		vipChildForm.setVipChildSex(child.getVipChildSex());
		vipChildForm.setUsername(username);
	} 
	
	request.setAttribute("vipChildForm", vipChildForm);
%>
<jsp:forward page="/main.jsp?fo=manager&page=createVipChild&name=<%=username %>"/>
</body>
</html>