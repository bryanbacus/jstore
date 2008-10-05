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
<title>簡訊單筆發送</title>
<script language="JavaScript1.3" src="<c:out value="${WEB}"/>/js/datetimepicker.js"></script>
</head>
<body>
<table width="100%" border="0">
	<tr>
		<td>
		<font style="color: cornflowerblue; font-size: x-large; font-weight: bold; text-align: left"/>
			簡訊單筆發送
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

<html:form action="/sms/singleSmsSenderAction" focus="formType">
	<table align="center">
		<html:hidden property="formType"/>
		<tr>
			<th align="left">會員:</th>
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
						<td>&nbsp;簡訊發送電話：</td>
						<td><html:text property="mobileNbr" readonly="true" style="border: none"/></td>
					</tr>
				</table>
				</logic:present>
			</td>
		</tr>
		<tr>
			<th align="left">簡訊標題：</th>
			<td colspan="3"><html:text property="msgTitle"/>
				<font style="color:red; font-size:small">(此部分內容不包含於簡訊中)</font></td>
		</tr>
		<tr>
			<th colspan="4" align="left">簡訊內容：</th>
		</tr>
		<tr>
			<td colspan="4"><html:textarea property="msgContext" cols="55" rows="10"></html:textarea> </td>
		</tr>
		<tr>
			<td colspan="4" align="center">
				<html:submit value="送出簡訊" onclick="smsSenderForm.formType.value='sendSingleSms'"/>
				<html:reset value="清除內容"/>
			</td>
		</tr>
	</table>
	
</html:form>

</body>
</html>