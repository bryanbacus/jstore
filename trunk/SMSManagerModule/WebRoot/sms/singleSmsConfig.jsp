<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Insert title here</title>
<script language="JavaScript1.3" src="<c:out value="${WEB}"/>/js/datetimepicker.js"></script>
</head>
<body>
<%
if("true".equalsIgnoreCase(request.getParameter("isDefault"))){
	System.out.println("SmsConfigAction set smsSenderForm to default.");
	request.getSession().removeAttribute("smsSenderForm");
}
%>
<table width="100%" border="0">
	<tr>
		<td>
		<font style="color: cornflowerblue; font-size: x-large; font-weight: bold; text-align: left"/>
			批次簡訊發送
		</td>
		<td align="right">
			<table width="100%">
			<tr>
			<td align="right">
			<input type="image" border=0 alt="搜尋訂單"
					onclick="document.location='<c:out value="${WEB}"/>/main.jsp?fo=sale&page=queryOrder'" 
					src="<c:out value="${WEB}"/>/images/icon-search-order.gif">
			<input type="image" border=0 alt="回上一頁"
					onclick="history.go(-1)" 
					src="<c:out value="${WEB}"/>/images/icon-back.gif">
			</td>
			</tr>
			</table>
		</td>
	</tr>
</table>

<html:form action="/sms/smsConfigAction">
<logic:equal name="smsSenderForm" property="formType" value="default">
	
	<table border="1" align="center" style="width:420pt;border-collapse: collapse;">
		<html:hidden property="formType"/>
		<tr><th align="right">簡訊標題:</th>
			<td><html:text property="msgTitle"/></td>
		</tr>
		<tr>
			<th align="right">簡訊預計發送時間:</th>
			<td>
				<table>
				<tr><td><html:text property="sendTime"
					onclick="javascript:NewCal('sendTime','ddmmyyyy',true,24)"/></td>
				<td><img src="<c:out value="${WEB }"/>/images/icon-calendar.gif" width="28" 
					onclick="javascript:NewCal('sendTime','ddmmyyyy',true,24)"/></td>
				<td>(範例: 10-06-2007 23:46:34)</td>
				</tr></table>
			</td>
		</tr>
		<tr>
			<th align="right" valign="top">簡訊內容:</th>
			<td colspan="3"><html:textarea property="msgContext" cols="60" rows="5"/></td>
		</tr>
		<tr>
			<td colspan="4" align="center"><html:submit value="建立批次傳送" onclick="smsSenderForm.formType.value='singleSmsConfig'"/></td>
		</tr>
	</table>
</logic:equal>
<logic:equal name="smsSenderForm" property="formType" 
	value="singleSmsConfigDetails">
<!-- html:form action="/sms/singleSmsSenderAction" focus="formType" -->
	<table><html:hidden property="formType"/>
		<tr>
			<th align="right">Vip Id:</th>
			<td>
				<html:select property="vipId">
					<html:optionsCollection property="vipMap" value="value" label="key"/>
				</html:select>
			</td>
			<th align="right">Send Time:</th>
			<td>
				<html:text property="sendTime"/>
			</td>
			<td align="center"><html:submit value="建立傳送名單" />
				<html:submit value="重新建立簡訊" onclick="smsSenderForm.formType.value='reset'"/>
				<logic:present name="smsSenderForm" property="smTbMessageQueues">
					<html:submit value="送出簡訊" onclick="smsSenderForm.formType.value='singleSmsSave'"/>
				</logic:present></td>
		</tr>
	</table>

<logic:present name="smsSenderForm" property="smTbMessageQueues">
	簡訊標題：<bean:write name="smsSenderForm" property="msgTitle"/><br/>
	簡訊內容：<bean:write name="smsSenderForm" property="msgContext"/><hr/>
	<logic:iterate id="queueItem" name="smsSenderForm" property="smTbMessageQueues">
		VIP:<bean:write name="queueItem" property="recipientId"/> | 
		Mobile:<bean:write name="queueItem" property="mobile"/> |
		Send Date:<bean:write name="queueItem" property="sendDate"/> |
		Status:<bean:write name="queueItem" property="status"/> |
		Create User:<bean:write name="queueItem" property="createUserId"/> <br/>
	</logic:iterate>
</logic:present>
</logic:equal>
</html:form>
</body>
</html>