<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@ page import="com.shenming.sms.dc.manager.*,com.shenming.sms.module.hibernateOrm.*" %>
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
SmsVipManager.initialize();
java.util.TreeMap userMap = SmsVipManager.retrieveAllUserMapIdNamePair();
%>
<table width="100%" border="0">
	<tr>
		<td>
		<font style="color: cornflowerblue; font-size: x-large; font-weight: bold; text-align: left"/>
			批次規則簡訊發送
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

<html:form action="/sms/smsBatchConfigAction">
<logic:equal name="smsSenderForm" property="formType"
	 value="default">
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
			<td colspan="4" align="center"><html:submit value="建立批次傳送" onclick="smsSenderForm.formType.value='batchSmsConfig'"/></td>
		</tr>
	</table>
</logic:equal>
<!-- 建立簡訊發送人員 -->
<logic:equal name="smsSenderForm" property="formType" 
	value="batchSmsConfigDetails">
	簡訊標題：<c:out value="${smsSenderForm.msgTitle}"/><br/>
	簡訊內容：<c:out value="${smsSenderForm.msgContext}"/><br/>
	簡訊發送時間：<c:out value="${smsSenderForm.sendTime}"/><hr/>
	<table border="1" align="center" style="width:400pt;border-collapse: collapse;">
		<html:hidden property="formType"/>
		<tr>
			<th align="center">發送規則: &nbsp;
				<html:select property="ruleId" onchange="smsSenderForm.formType.value = 'changeOption';smsSenderForm.submit();">
					<html:option value="">請選擇</html:option>
					<html:option value="insertMessageByVipChildSex">依姓別發送簡訊</html:option>
					<html:option value="insertMessageByVipOwner">依帳號隸屬發送簡訊</html:option>
					<html:option value="insertMessageAllVip">發送全部用戶</html:option>
				</html:select>
			
			<c:if test="${opt != null}">
			條件：
			
			<c:if test="${opt == 'insertMessageByVipChildSex'}">
			<!-- 依姓別發送簡訊  -->
				<html:select property="option">
					<html:option value="M">小男生</html:option>
					<html:option value="F">小女生</html:option>
				</html:select>
			</c:if>
			
			<c:if test="${opt == 'insertMessageByVipOwner'}">
			<!-- 依帳號隸屬發送簡訊 -->
				<html:select property="option">
					<html:optionsCollection property="vipMap" value="value" label="key"/>
				</html:select>
			</c:if>
			
			<c:if test="${opt == 'insertMessageAllVip'}">
			<!-- 發送全部用戶 -->
				<font style="color:red;">發送給所有會員</font>
			</c:if>
			</td>
			</c:if> <!-- End of opt != null -->
		</tr>
		<tr>
			<td colspan="3" align="center">
			<!-- 按鈕區塊 -->

			<html:submit value="建立傳送名單" />
			<html:submit value="重新建立簡訊" onclick="smsSenderForm.formType.value='reset2Batch'"/>
			<logic:present name="smsSenderForm" property="smTbMessageQueues">
				<html:submit value="送出簡訊" onclick="smsSenderForm.formType.value='batchSmsSave'"/>
			</logic:present>
			</td>
		</tr>
	</table>
<hr/>
<p align="center">
<logic:present name="smsSenderForm" property="smTbMessageQueues">
<table border="1" align="center"
		style="border: thin inset black; border-collapse: collapse"
		cellpadding="3" cellspacing="0">
<tr>
	<td>VIP</td>
	<td>Mobile</td>
	<td>Send Date</td>
	<td>Status</td>
	<td>Create User</td>
</tr>
	<logic:iterate id="queueItem" name="smsSenderForm" property="smTbMessageQueues">
	<tr onmouseover="this.style.background='#CCCCCC'" onmouseout="this.style.background=''">
		<td>
			<%=userMap.get(((SmTbMessageQueue)queueItem).getRecipientId())%>
			(<bean:write name="queueItem" property="recipientId"/>)
		</td>
		<td><bean:write name="queueItem" property="mobile"/></td>
		<td><bean:write name="queueItem" property="sendDate" format="yyyy/M/d h:mm a z"/></td>
		<td>
			<c:if test="${queueItem.status == 'I'}">Initialize</c:if>
			(<bean:write name="queueItem" property="status"/>)
		</td>
		<td>
			<%=userMap.get(((SmTbMessageQueue)queueItem).getCreateUserId())%>
			(<bean:write name="queueItem" property="createUserId"/>)</td>
	</tr>
	</logic:iterate>
</table>
</logic:present>
</p>
</logic:equal>
</html:form>
</body>
</html>