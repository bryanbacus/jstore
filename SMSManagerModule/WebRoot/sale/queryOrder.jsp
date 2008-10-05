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
<title>訂購單查詢</title>
<script language="JavaScript1.3" src="<c:out value="${WEB}"/>/js/datetimepicker.js"></script>
</head>
<body>
<table width="100%" border="0">
	<tr>
		<td>
		<font style="color: cornflowerblue; font-size: x-large; font-weight: bold; text-align: left"/>
			訂購單查詢
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

<html:form action="/sale/queryOrderAction" focus="formType">
	<table align="center" style="width:450pt">
		<html:hidden property="formType"/>
		<tr>
			<th align="right">銷售人員:</th>
			<td>
				<html:select property="saleId">
					<html:option value=""></html:option>
					<html:optionsCollection property="vipMap" value="value" label="key"/>
				</html:select>
			</td>
			<th align="right">客戶:</th>
			<td>
				<html:select property="vipId">
					<html:option value=""></html:option>
					<html:optionsCollection property="vipMap" value="value" label="key"/>
				</html:select>
			</td>
			<th align="right">銷售總額:</th>
			<td>
				<html:text property="saleTotalMin" size="10"/>~<html:text property="saleTotalMax" size="10"/>
			</td>
		</tr>
		<tr>
			<th align="right">銷售時間:</th>
			<td colspan="4">
				<table>
				<tr>
				<td><html:text property="saleDateStart" size="16" onclick="javascript:NewCal('saleDateStart','ddmmyyyy',true,24)"/></td>
				<td><img src="<c:out value="${WEB }"/>/images/icon-calendar.gif" width="28" 
					onclick="javascript:NewCal('saleDateStart','ddmmyyyy',true,24)"/></td>
				<td>~</td>
				<td><html:text property="saleDateEnd" size="16" onclick="javascript:NewCal('saleDateEnd','ddmmyyyy',true,24)"/></td>
				<td><img src="<c:out value="${WEB }"/>/images/icon-calendar.gif" width="28" 
					onclick="javascript:NewCal('saleDateEnd','ddmmyyyy',true,24)"/></td>
				</tr>
				</table>
			</td>
			<td>
				<html:submit value="查詢" onclick="queryOrderForm.formType.value='query'"/>
				<html:submit value="列出全部" onclick="queryOrderForm.formType.value='queryAll'"/>
			</td>
		</tr>
	</table>
	
</html:form>

<logic:present name="queryOrderForm" property="saleRecords">
<table border="1" width="100%"
		style="border: thin inset black; border-collapse: collapse"
		cellpadding="3" cellspacing="0">
	<tr align="center">
		<td>銷售代號</td>
		<td>銷售人員</td>
		<td>客戶姓名</td>
		<td>銷售總金額</td>
		<td>銷售日期</td>
		<td>項目數</td>
		<td>詳細資訊</td>
	</tr>
	<logic:iterate id="saleRecord" name="queryOrderForm" property="saleRecords">
	<tr align="center" onmouseover="this.style.background='#CCCCCC'" onmouseout="this.style.background=''">
		<td><bean:write name="saleRecord" property="saleSeq"/></td>
		<td><c:out value="${saleRecord.smTbVipAccount1.username}"/>&nbsp;</td>
		<td><c:out value="${saleRecord.smTbVipAccount2.username}"/>&nbsp;</td>
		<td><bean:write name="saleRecord" property="saleTotal"/></td>
		<td><bean:write name="saleRecord" property="saleDate" format="M/d/yyyy h:mm a z"/></td>
		<td><c:out value="${saleRecord.smTbSaleItemsSize}"/>
			<c:if test="${!saleRecord.allClose}"><font style="color:red;">*</font></c:if>
		</td>
		<td>
			<input type="image" alt="購物詳細資訊" src="<c:out value="${WEB }"/>/images/icon-info.gif" 
				onclick="document.location='<c:out value="${WEB }"/>/sale/queryOrderAction.do?formType=queryDetail&saleSeq=<bean:write name="saleRecord" property="saleSeq"/>'">

		</td>
		</tr>
	</logic:iterate>
</table>
</logic:present>
</body>
</html>