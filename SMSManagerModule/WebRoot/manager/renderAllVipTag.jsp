<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.shenming.sms.module.hibernateOrm.*,
		com.shenming.sms.dc.manager.*,
		com.shenming.sms.struts.form.VipAccountForm,
		java.util.*" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Tag Print Module</title>
</head>
<body style="margin-left: 0;margin-top: 0; margin-top: 0;margin-bottom: 0">
<%
double top = new Double(request.getParameter("top")!=null?request.getParameter("top"):"0").doubleValue();
double interval = new Double(request.getParameter("interval")!=null?request.getParameter("interval"):"0").doubleValue();
double left = new Double(request.getParameter("left")!=null?request.getParameter("left"):"0").doubleValue();
double right = new Double(request.getParameter("right")!=null?request.getParameter("right"):"0").doubleValue();
double width = new Double(request.getParameter("width")!=null?request.getParameter("width"):"8.8").doubleValue();
double height = new Double(request.getParameter("height")!=null?request.getParameter("height"):"3.6").doubleValue();
Integer startIdx = new Integer(request.getParameter("startIdx")!=null?request.getParameter("startIdx"):"0");
Integer endIdx = new Integer(request.getParameter("endIdx")!=null?request.getParameter("endIdx"):"0");
String border = "true".equalsIgnoreCase(request.getParameter("border"))?"border: thin inset black;":"";

List<SmTbVipAccount> allVip = 
	(endIdx.intValue() - startIdx.intValue() < 0)?
			SmsVipManager.retrieveAllUser():SmsVipManager.retrieveUserBetween(startIdx, endIdx, "userId", false);

System.out.println("Get vip total: " + allVip.size());
			
//pageContext.setAttribute("allVip", allVip);
request.setAttribute("allVip", allVip);
if(allVip != null){
%>
<div style="height: <%=top %>cm"></div>
<table border="0" 
	cellpadding="0" 
	cellspacing="0">
	<logic:iterate id="vip" name="allVip" type="com.shenming.sms.module.hibernateOrm.SmTbVipAccount">
		<tr>
			<td style="width:<%=left +"cm" %>"></td>
			<td style="width:<%=width +"cm" %>">
			<table style="border-collapse: collapse; width:<%=width +"cm"%>;height:<%=height +"cm"%>;<%=border %> " 
				align="center"
				cellpadding="3" cellspacing="3">
				<tr>
					<td>
						<%
							String addr = "";
							String subStr = "";
							try{
								addr = vip!=null?(((SmTbVipAccount)vip).getAddress()):null;
								subStr = addr!=null?(addr.length()>3?addr.substring(0,3):""):"";
								if(subStr != null && !"".equalsIgnoreCase(subStr)){
									new Integer(subStr);
									out.println(subStr + "<br/>");
									out.println(addr!=null?(addr.length()>3?addr.substring(3):"" + "<br/>"):"");
								}
							} catch(Exception e){
								out.println("<font color=red>[帳號:"+((SmTbVipAccount)vip).getUsername()+"]地址格式錯誤，請檢查郵遞區號</font><br/>");
//								System.err.println("[帳號:"+((SmTbVipAccount)request.getAttribute("createdVip")).getUsername()+"]地址格式錯誤，請檢查郵遞區號");
							}
						%>
						<br/>
						<bean:write name="vip" property="vipChtName"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;君收<br/>
						<bean:write name="vip" property="userId"/><br/>
					</td>
				</tr>
			</table>
			</td>
			<td style="width:<%=right +"cm"%>"></td>
		</tr>
		<tr>
			<td colspan="3" style="height:<%=interval +"cm"%>"></td>
		</tr>
	</logic:iterate>
</table>


<%
} else {
	request.setAttribute("message", "列舉VIP錯誤，請確認系統中已經有VIP帳號!");
%>
<jsp:forward page="/main.jsp?page=message"/>
<%
}
%>

</body>
</html>