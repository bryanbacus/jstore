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
<title>�q�ʳ�d��</title>
<script language="JavaScript1.3" src="<c:out value="${WEB}"/>/js/datetimepicker.js"></script>
</head>
<body>
<table width="100%" border="0">
	<tr>
		<td>
		<font style="color: cornflowerblue; font-size: x-large; font-weight: bold; text-align: left"/>
			�q�ʳ�d��
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

<html:form action="/sale/queryOrderAction" focus="formType">
	<table align="center" style="width:450pt">
		<html:hidden property="formType"/>
		<tr>
			<th align="right">�P��H��:</th>
			<td>
				<html:select property="saleId">
					<html:option value=""></html:option>
					<html:optionsCollection property="vipMap" value="value" label="key"/>
				</html:select>
			</td>
			<th align="right">�Ȥ�:</th>
			<td>
				<html:select property="vipId">
					<html:option value=""></html:option>
					<html:optionsCollection property="vipMap" value="value" label="key"/>
				</html:select>
			</td>
			<th align="right">�P���`�B:</th>
			<td>
				<html:text property="saleTotalMin" size="10"/>~<html:text property="saleTotalMax" size="10"/>
			</td>
		</tr>
		<tr>
			<th align="right">�P��ɶ�:</th>
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
				<html:submit value="�d��" onclick="queryOrderForm.formType.value='query'"/>
				<html:submit value="�C�X����" onclick="queryOrderForm.formType.value='queryAll'"/>
			</td>
		</tr>
	</table>
	
</html:form>

<logic:present name="queryOrderForm" property="saleRecords">
<table border="1" width="100%"
		style="border: thin inset black; border-collapse: collapse"
		cellpadding="3" cellspacing="0">
	<tr align="center">
		<td>�P��N��</td>
		<td>�P��H��</td>
		<td>�Ȥ�m�W</td>
		<td>�P���`���B</td>
		<td>�P����</td>
		<td>���ؼ�</td>
		<td>�ԲӸ�T</td>
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
			<input type="image" alt="�ʪ��ԲӸ�T" src="<c:out value="${WEB }"/>/images/icon-info.gif" 
				onclick="document.location='<c:out value="${WEB }"/>/sale/queryOrderAction.do?formType=queryDetail&saleSeq=<bean:write name="saleRecord" property="saleSeq"/>'">

		</td>
		</tr>
	</logic:iterate>
</table>
</logic:present>
</body>
</html>