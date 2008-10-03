<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>

<%@ page import="com.shenming.sms.struts.form.*" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>²�T�浧�o�e</title>
<script language="JavaScript1.3" src="<c:out value="${WEB}"/>/js/datetimepicker.js"></script>
</head>
<body>
<table width="100%" border="0">
	<tr>
		<td>
		<font style="color: cornflowerblue; font-size: x-large; font-weight: bold; text-align: left"/>
			²�T�浧�o�e
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

<html:form action="/sms/singleSmsSenderAction" focus="formType">
	<table align="center">
		<html:hidden property="formType"/>
		<tr>
			<th align="left">�|��:</th>
			<td>
				<html:select property="vipId" onchange="smsSenderForm.formType.value='queryMobile';smsSenderForm.submit();">
					<html:option value=""></html:option>
					<html:optionsCollection property="vipList" value="userId" label="username"/>
				</html:select>
			</td>
			<td colspan="2">
				<logic:present name="smsSenderForm" property="mobileNbr">
				<table>
					<tr>
						<td>&nbsp;²�T�o�e�q�ܡG</td>
						<td><html:text property="mobileNbr" readonly="true" style="border: none"/></td>
					</tr>
				</table>
				</logic:present>
			</td>
		</tr>
		<tr>
			<th align="left">²�T���D�G</th>
			<td colspan="3"><html:text property="msgTitle"/>
				<font style="color:red; font-size:small">(���������e���]�t��²�T��)</font></td>
		</tr>
		<tr>
			<th colspan="4" align="left">²�T���e�G</th>
		</tr>
		<tr>
			<td colspan="4"><html:textarea property="msgContext" cols="55" rows="10"></html:textarea> </td>
		</tr>
		<tr>
			<td colspan="4" align="center">
				<html:submit value="�e�X²�T" onclick="smsSenderForm.formType.value='sendSingleSms'"/>
				<html:reset value="�M�����e"/>
			</td>
		</tr>
	</table>
	
</html:form>

</body>
</html>