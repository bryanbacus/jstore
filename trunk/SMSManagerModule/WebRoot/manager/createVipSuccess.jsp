<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.shenming.sms.dc.manager.*,
				com.shenming.sms.module.hibernateOrm.*" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>�|����ƫ���</title>
</head>
<body>
<logic:notPresent parameter="type">

<%if(!"show".equalsIgnoreCase(request.getParameter("act"))){ %>
<jsp:include page="${web}/common/page-title.jsp?title=�|����ƫ���"/>
<p align="center">
<font style="color:red;">�|����ƫإߧ���!</font> <br/>
<%}else { %>
<jsp:include page="${web}/common/page-title.jsp?title=�|����ƦC��"/>
<p align="center">
<%} %>
<input type=button value="�إ߫Ȥ�ĵ����" 
	onclick="document.location='<c:out value="${WEB }"/>/main.jsp?fo=manager&page=createVipChild&name=<bean:write name="createdVip" property="username"/>'"/>
</p>
<br/>
<br/>
</logic:notPresent>

<logic:present name="createdVip">
<div style="font-size: large;font-weight: bold;text-align: center;">
	<bean:write name="createdVip" property="vipChtName"/>
	(ID:<bean:write name="createdVip" property="userId"/>) �򥻸��
</div>
<table border="1" width="98%" align="center"
		style="border: thin inset black; border-collapse: collapse"
		cellpadding="3" cellspacing="3">
	<tr>
		<td width="200">�|���N��</td>
		<td><bean:write name="createdVip" property="userId"/></td>
	</tr>
	<tr>
		<td width="200">�|���b��</td>
		<td><bean:write name="createdVip" property="username"/></td>
	</tr>
	<tr>
		<td>����W��</td>
		<td><bean:write name="createdVip" property="vipChtName"/></td>
	</tr>
	<tr>
		<td>�^��W��</td>
		<td><bean:write name="createdVip" property="vipEngName"/></td>
	</tr>
	<tr>
		<td>�ͤ�</td>
		<td><bean:write name="createdVip" property="birthday" format="yyyy-MM-dd"/> (�~-��-��)</td>
	</tr>
	<tr>
		<td>�ʧO</td>
		<td>
			<bean:write name="createdVip" property="sex"/>
			(<c:out value="${createdVip.sex=='M'?'�k':'�k'}"/>)
		</td>
	</tr>
	<!-- 
	<tr>
		<td>�嫬</td>
		<td><bean:write name="createdVip" property="blood"/></td>
	</tr>
	<tr>
		<td>�B��</td>
		<td><bean:write name="createdVip" property="marrage"/></td>
	</tr>
	-->
	<tr>
		<td>�a�}</td>
		<td><bean:write name="createdVip" property="address"/></td>
	</tr>
	<tr>
		<td>�q��</td>
		<td><bean:write name="createdVip" property="phone"/></td>
	</tr>
	<tr>
		<td>��ʹq��</td>
		<td><bean:write name="createdVip" property="mobile"/></td>
	</tr>
	<tr>
		<td>�q�l�l��</td>
		<td><bean:write name="createdVip" property="mailAddr"/></td>
	</tr>
	<!-- 
	<tr>
		<td>����</td>
		<td><bean:write name="createdVip" property="fovarite"/></td>
	</tr>
	 -->
	<tr>
		<td>¾�~</td>
		<td><bean:write name="createdVip" property="job"/></td>
	</tr>
	<tr>
		<td>���ɤ��</td>
		<td><bean:write name="createdVip" property="crDate"/></td>
	</tr>
	<tr>
		<td>�ʶR�`���B</td>
		<td><bean:write name="createdVip" property="buySum"/></td>
	</tr>
	<tr>
		<td>VIP���A</td>
		<td>
			<bean:write name="createdVip" property="isValidVip"/>
			(<c:out value="${createdVip.isValidVip == 'Y'?'�|��':'�D�|��'}"/>)
		</td>
	</tr>
	<tr>
		<td>�����Ҹ�</td>
		<td><bean:write name="createdVip" property="sid"/></td>
	</tr>
	<tr>
		<td>����</td>
		<td><bean:write name="createdVip" property="store"/></td>
	</tr>
	<tr>
		<td>�M�d�p�j</td>
		<td><bean:write name="createdVip" property="storeEmployeeName"/></td>
	</tr>
	<tr>
		<td>�Τᵥ��</td>
		<td><bean:write name="createdVip" property="vipLevel"/> �ūȤ�</td>
	</tr>
	<tr>
		<td>�b�����A</td>
		<td>
			<bean:write name="createdVip" property="isAccountActive"/>
			(<c:out value="${createdVip.isAccountActive == 'Y'?'�i��':'��w'}"/>)
		</td>
	</tr>
	<tr>
		<td>�n�J���~����</td>
		<td><bean:write name="createdVip" property="errorCnt"/></td>
	</tr>
	<tr>
		<td>�b������</td>
		<td>
			<c:out value="${createdVip.smTbVipAccount.vipChtName}"/>(<c:out value="${createdVip.smTbVipAccount.username}"/>)
		</td>
	</tr>
</table>
</logic:present>
<br/>
</body>
</html>