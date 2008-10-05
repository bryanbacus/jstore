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
			�妸�W�h²�T�o�e
		</td>
		<td align="right">
			<table width="100%">
			<tr>
			<td align="right">
			<input type="image" border=0 alt="�j�M�q��"
					onclick="document.location='<c:out value="${WEB}"/>/main.jsp?fo=sale&page=queryOrder'" 
					src="<c:out value="${WEB}"/>/images/icon-search-order.gif">
			<input type="image" border=0 alt="�^�W�@��"
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
		<tr><th align="right">²�T���D:</th>
			<td><html:text property="msgTitle"/></td>
		</tr>
		<tr>
			<th align="right">²�T�w�p�o�e�ɶ�:</th>
			<td>
				<table>
				<tr><td><html:text property="sendTime"
					onclick="javascript:NewCal('sendTime','ddmmyyyy',true,24)"/></td>
				<td><img src="<c:out value="${WEB }"/>/images/icon-calendar.gif" width="28" 
					onclick="javascript:NewCal('sendTime','ddmmyyyy',true,24)"/></td>
				<td>(�d��: 10-06-2007 23:46:34)</td>
				</tr></table>
			</td>
		</tr>
		<tr>
			<th align="right" valign="top">²�T���e:</th>
			<td colspan="3"><html:textarea property="msgContext" cols="60" rows="5"/></td>
		</tr>
		<tr>
			<td colspan="4" align="center"><html:submit value="�إߧ妸�ǰe" onclick="smsSenderForm.formType.value='batchSmsConfig'"/></td>
		</tr>
	</table>
</logic:equal>
<!-- �إ�²�T�o�e�H�� -->
<logic:equal name="smsSenderForm" property="formType" 
	value="batchSmsConfigDetails">
	²�T���D�G<c:out value="${smsSenderForm.msgTitle}"/><br/>
	²�T���e�G<c:out value="${smsSenderForm.msgContext}"/><br/>
	²�T�o�e�ɶ��G<c:out value="${smsSenderForm.sendTime}"/><hr/>
	<table border="1" align="center" style="width:400pt;border-collapse: collapse;">
		<html:hidden property="formType"/>
		<tr>
			<th align="center">�o�e�W�h: &nbsp;
				<html:select property="ruleId" onchange="smsSenderForm.formType.value = 'changeOption';smsSenderForm.submit();">
					<html:option value="">�п��</html:option>
					<html:option value="insertMessageByVipChildSex">�̩m�O�o�e²�T</html:option>
					<html:option value="insertMessageByVipOwner">�̱b�����ݵo�e²�T</html:option>
					<html:option value="insertMessageAllVip">�o�e�����Τ�</html:option>
				</html:select>
			
			<c:if test="${opt != null}">
			����G
			
			<c:if test="${opt == 'insertMessageByVipChildSex'}">
			<!-- �̩m�O�o�e²�T  -->
				<html:select property="option">
					<html:option value="M">�p�k��</html:option>
					<html:option value="F">�p�k��</html:option>
				</html:select>
			</c:if>
			
			<c:if test="${opt == 'insertMessageByVipOwner'}">
			<!-- �̱b�����ݵo�e²�T -->
				<html:select property="option">
					<html:optionsCollection property="vipMap" value="value" label="key"/>
				</html:select>
			</c:if>
			
			<c:if test="${opt == 'insertMessageAllVip'}">
			<!-- �o�e�����Τ� -->
				<font style="color:red;">�o�e���Ҧ��|��</font>
			</c:if>
			</td>
			</c:if> <!-- End of opt != null -->
		</tr>
		<tr>
			<td colspan="3" align="center">
			<!-- ���s�϶� -->

			<html:submit value="�إ߶ǰe�W��" />
			<html:submit value="���s�إ�²�T" onclick="smsSenderForm.formType.value='reset2Batch'"/>
			<logic:present name="smsSenderForm" property="smTbMessageQueues">
				<html:submit value="�e�X²�T" onclick="smsSenderForm.formType.value='batchSmsSave'"/>
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