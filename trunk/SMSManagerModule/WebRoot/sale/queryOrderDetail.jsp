<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>

<%@ page import="com.shenming.sms.dc.manager.*, 
	com.shenming.sms.struts.form.*,
	com.shenming.sms.module.hibernateOrm.*" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Insert title here</title>
</head>
<body>
<%
	QueryOrderForm queryOrderForm = (QueryOrderForm)request.getAttribute("queryOrderForm");
	SmTbSaleRecord saleRecord = queryOrderForm.getSaleRecord();
	request.setAttribute("saleRecord",saleRecord);
%>

<table width="100%" border="0">
	<tr>
		<td>
		<font style="color: cornflowerblue; font-size: x-large; font-weight: bold; text-align: left"/>
			�q�ʳ�[�渹�G<%=saleRecord.getSaleSeq() %>]
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


<table width="100%" border="0">
	<tr>
		<td align="center">
		<font style="color: cornflowerblue; font-size: x-large; font-weight: bold;"/>
			�q����
		</td>
	</tr>
</table>

<table border="1" width="100%"
		style="border: thin inset black; border-collapse: collapse"
		cellpadding="3" cellspacing="0">
<tr align="center">
	<td>�P��N��</td>
	<td>�P��H��</td>
	<td>�Ȥ�m�W</td>
	<td>�P���`���B</td>
	<td>�P����</td>
</tr>
<tr align="center">
	<td><c:out value="${saleRecord.saleSeq}"/></td>
	<td><c:out value="${saleRecord.smTbVipAccount1.username}"/></td>
	<td><c:out value="${saleRecord.smTbVipAccount2.username}"/></td>
	<td><c:out value="${saleRecord.saleTotal}"/></td>
	<td><c:out value="${saleRecord.saleDate}"/></td>
</tr>
<tr>
	<td colspan="5" align="center" valign="middle">
		<input type="image" border=0 alt="�妸��s���ت��A-����"
			onclick="document.location='<c:out value="${WEB}"/>/sale/manageOrderAction.do?type=<%=OrderForm.UPDATE_STATUS %>&status=Y&updtype=saleRecord&seq=<%=saleRecord.getSaleSeq() %>'" 
			src="<c:out value="${WEB}"/>/images/icon-calculate.gif">
	</td>
</tr>
</table>

<p align="center" style="color:red">
	<c:out value="${message}"/>
</p>


<table width="100%" border="0">
	<tr>
		<td align="center">
		<font style="color: cornflowerblue; font-size: x-large; font-weight: bold;"/>
			�ԲӶ���
		</td>
	</tr>
</table>

<table border="1" width="100%"
		style="border: thin inset black; border-collapse: collapse"
		cellpadding="3" cellspacing="0">
<tr align="center">
	<td>���إN��</td>
	<td>���~</td>
	<td>���</td>
	<td>�|����</td>
	<td>�P��H��</td>
	<td>VIP�m�W</td>
	<td>��s�ɶ�</td>
	<td>���A</td>
	<td>��s���A</td>
</tr>
<c:forEach items="${saleRecord.smTbSaleItems}" var="item">
<tr align="center" onmouseover="this.style.background='#CCCCCC'" onmouseout="this.style.background=''">
	<td><c:out value="${item.itemSeq}"/></td>
	<td><c:out value="${item.smTbProduct.name}"/></td>
	<td><c:out value="${item.prdUnitPrice}"/></td>
	<td><c:out value="${item.prdDiscountPrice}"/></td>
	<td><c:out value="${item.smTbVipAccount1.username}"/></td>
	<td><c:out value="${item.smTbVipAccount2.username}"/></td>
	<td><c:out value="${item.updDate}"/></td>
	<td><c:out value="${item.isClose}"/></td>
	<td>
		<input type="image" border=0 alt="��s���ت��A-����"
			onclick="document.location='<c:out value="${WEB}"/>/sale/manageOrderAction.do?type=<%=OrderForm.UPDATE_STATUS %>&status=<%=OrderManager.ORDER_STATUS_CLOSE %>&updtype=saleItem&seq=<c:out value="${item.itemSeq}"/>'" 
			src="<c:out value="${WEB}"/>/images/icon-calculate-Y.gif">
		<input type="image" border=0 alt="��s���ت��A-�|������"
			onclick="document.location='<c:out value="${WEB}"/>/sale/manageOrderAction.do?type=<%=OrderForm.UPDATE_STATUS %>&status=<%=OrderManager.ORDER_STATUS_NOT_CLOSE %>&updtype=saleItem&seq=<c:out value="${item.itemSeq}"/>'" 
			src="<c:out value="${WEB}"/>/images/icon-calculate-N.gif">
		<input type="image" border=0 alt="��s���ت��A-�����q��"
			onclick="document.location='<c:out value="${WEB}"/>/sale/manageOrderAction.do?type=<%=OrderForm.UPDATE_STATUS %>&status=<%=OrderManager.ORDER_STATUS_CANCEL %>&updtype=saleItem&seq=<c:out value="${item.itemSeq}"/>'" 
			src="<c:out value="${WEB}"/>/images/icon-calculate-C.gif">
		<input type="image" border=0 alt="��s���ت��A-�ݳf��"
			onclick="document.location='<c:out value="${WEB}"/>/sale/manageOrderAction.do?type=<%=OrderForm.UPDATE_STATUS %>&status=<%=OrderManager.ORDER_STATUS_SUSPEND %>&updtype=saleItem&seq=<c:out value="${item.itemSeq}"/>'" 
			src="<c:out value="${WEB}"/>/images/icon-calculate-S.gif">
	</td>
</tr>
</c:forEach>
</table>
<p align="center" style="color:red">(���ت��A�GY ����; N �|������; C �����q��; S �ݳf��)</p>
</body>
</html>