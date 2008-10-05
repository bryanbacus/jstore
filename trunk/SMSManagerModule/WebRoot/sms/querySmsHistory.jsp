<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@ page import="com.shenming.sms.dc.manager.*,com.shenming.sms.module.hibernateOrm.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Insert title here</title>
<script language="JavaScript1.3" src="<c:out value="${WEB}"/>/js/datetimepicker.js"></script>
</head>
<body>
<%
SmsVipManager.initialize();
java.util.TreeMap userMap = SmsVipManager.retrieveAllUserMapIdNamePair();
%>
<table width="100%" border="0">
	<tr>
		<td>
		<font style="color: cornflowerblue; font-size: x-large; font-weight: bold; text-align: left"/>
			簡訊記錄查詢
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

<html:form action="/sms/querySmsHistory" focus="formType">
	<table align="center" style="width:430pt">
		<html:hidden property="formType"/>
		<tr align="left">
			<th>會員</th>
			<td>
				<html:select property="vipId">
					<html:option value="">請選擇</html:option>
					<html:optionsCollection property="vipMap" value="value" label="key"/>
				</html:select>
			</td>
			<th>發送號碼</th>
			<td>
				<html:text property="mobileNbr"/>
			</td>
		</tr>
		<tr align="left">
			<th>簡訊標題</th>
			<td>
				<html:text property="msgTitle"/>
			</td>
			<th>狀態</th>
			<td><!-- I:Initial/初始; P:Processing/傳送中; S:Success/成功; F:Fail/失敗 -->
				<html:select property="status">
					<html:option value="">請選擇</html:option>
					<html:option value="I">初始</html:option>
					<html:option value="P">傳送中</html:option>
					<html:option value="S">成功</html:option>
					<html:option value="F">失敗</html:option>
				</html:select>
			</td>
		</tr>
		<tr align="left">
			<th>發送時間區段</th>
			<td colspan="3">
			<table style="width:200pt">
			<tr>
				<td>
				<html:text property="createTimeStart"/></td>
				<td><img src="<c:out value="${WEB }"/>/images/icon-calendar.gif" width="28" 
						onclick="javascript:NewCal('createTimeStart','ddmmyyyy',true,24)"/></td>
				<td>~</td>
				<td><html:text property="createTimeEnd"/></td>
				<td><img src="<c:out value="${WEB }"/>/images/icon-calendar.gif" width="28" 
						onclick="javascript:NewCal('createTimeEnd','ddmmyyyy',true,24)"/></td>
			</tr>
			</table>
			</td>
		</tr>
		<tr align="left">
			<th>傳送時間區段</th>
			<td colspan="3">
			<table style="width:300pt">
			<tr>
				<td>
				<html:text property="sentDateStart"/></td>
				<td><img src="<c:out value="${WEB }"/>/images/icon-calendar.gif" width="28" 
						onclick="javascript:NewCal('sentDateStart','ddmmyyyy',true,24)"/></td>
				<td>~</td>
				<td><html:text property="sentDateEnd"/></td>
				<td><img src="<c:out value="${WEB }"/>/images/icon-calendar.gif" width="28" 
						onclick="javascript:NewCal('sentDateEnd','ddmmyyyy',true,24)"/></td>
				<td>&nbsp;</td>
				<td><html:submit value="送出查詢"/></td>
			</tr>
			</table>
			</td>
		</tr>
	</table>
</html:form>

<logic:present name="querySmsHistoryForm" property="smTbMessageQueues">
<table border="1" width="100%"
		style="border: thin inset black; border-collapse: collapse"
		cellpadding="3" cellspacing="0">
<tr style="text-align:center;">
	<td>傳送序號</td>
	<td>接收人代號</td>
	<td>傳送者代號</td>
	<td>簡訊標題</td>
	<td>傳送日期</td>
	<td>狀態</td>
</tr>
<logic:iterate name="querySmsHistoryForm" property="smTbMessageQueues" id="item">

<tr onmouseover="this.style.background='#CCCCCC'" onmouseout="this.style.background=''">
	<td align="center">
		<a href="<c:out value="${WEB }"/>/main.jsp?fo=sms&page=renderSmsDetail&idx=<bean:write name="item" property="idx"/>">
		<bean:write name="item" property="idx"/>
		</a></td>
	<td>
		<a href="<c:out value="${WEB }"/>/manager/renderUserById.jsp?type=show&idx=<bean:write name="item" property="recipientId"/>">
		<%=userMap.get(((SmTbMessageQueue)item).getRecipientId()) %>(<bean:write name="item" property="recipientId"/>)
		</a></td>
	<td>
		<a href="<c:out value="${WEB }"/>/manager/renderUserById.jsp?type=show&idx=<bean:write name="item" property="smTbMessageContext.createUserId"/>">
		<%=userMap.get(((SmTbMessageQueue)item).getSmTbMessageContext().getCreateUserId()) %>(<bean:write name="item" property="smTbMessageContext.createUserId"/>)
		</a></td>
	<td><bean:write name="item" property="smTbMessageContext.smsTitle"/></td>
	<td><bean:write name="item" property="sendDate"/></td>
	<td align="center"><bean:write name="item" property="status"/></td>
</tr>

</logic:iterate>
</table>
<p align="center" style="color:red;">簡訊代號  I:Initial/初始; P:Processing/傳送中; S:Success/成功; F:Fail/失敗</p>
</logic:present>

</body>
</html>