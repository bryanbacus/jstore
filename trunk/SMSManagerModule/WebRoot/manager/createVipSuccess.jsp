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
<title>會員資料建檔</title>
</head>
<body>
<logic:notPresent parameter="type">

<%if(!"show".equalsIgnoreCase(request.getParameter("act"))){ %>
<jsp:include page="${web}/common/page-title.jsp?title=會員資料建檔"/>
<p align="center">
<font style="color:red;">會員資料建立完成!</font> <br/>
<%}else { %>
<jsp:include page="${web}/common/page-title.jsp?title=會員資料列表"/>
<p align="center">
<%} %>
<input type=button value="建立客戶孩童資料" 
	onclick="document.location='<c:out value="${WEB }"/>/main.jsp?fo=manager&page=createVipChild&name=<bean:write name="createdVip" property="username"/>'"/>
</p>
<br/>
<br/>
</logic:notPresent>

<logic:present name="createdVip">
<div style="font-size: large;font-weight: bold;text-align: center;">
	<bean:write name="createdVip" property="vipChtName"/>
	(ID:<bean:write name="createdVip" property="userId"/>) 基本資料
</div>
<table border="1" width="98%" align="center"
		style="border: thin inset black; border-collapse: collapse"
		cellpadding="3" cellspacing="3">
	<tr>
		<td width="200">會員代號</td>
		<td><bean:write name="createdVip" property="userId"/></td>
	</tr>
	<tr>
		<td width="200">會員帳號</td>
		<td><bean:write name="createdVip" property="username"/></td>
	</tr>
	<tr>
		<td>中文名稱</td>
		<td><bean:write name="createdVip" property="vipChtName"/></td>
	</tr>
	<tr>
		<td>英文名稱</td>
		<td><bean:write name="createdVip" property="vipEngName"/></td>
	</tr>
	<tr>
		<td>生日</td>
		<td><bean:write name="createdVip" property="birthday" format="yyyy-MM-dd"/> (年-月-日)</td>
	</tr>
	<tr>
		<td>性別</td>
		<td>
			<bean:write name="createdVip" property="sex"/>
			(<c:out value="${createdVip.sex=='M'?'男':'女'}"/>)
		</td>
	</tr>
	<!-- 
	<tr>
		<td>血型</td>
		<td><bean:write name="createdVip" property="blood"/></td>
	</tr>
	<tr>
		<td>婚姻</td>
		<td><bean:write name="createdVip" property="marrage"/></td>
	</tr>
	-->
	<tr>
		<td>地址</td>
		<td><bean:write name="createdVip" property="address"/></td>
	</tr>
	<tr>
		<td>電話</td>
		<td><bean:write name="createdVip" property="phone"/></td>
	</tr>
	<tr>
		<td>行動電話</td>
		<td><bean:write name="createdVip" property="mobile"/></td>
	</tr>
	<tr>
		<td>電子郵件</td>
		<td><bean:write name="createdVip" property="mailAddr"/></td>
	</tr>
	<!-- 
	<tr>
		<td>興趣</td>
		<td><bean:write name="createdVip" property="fovarite"/></td>
	</tr>
	 -->
	<tr>
		<td>職業</td>
		<td><bean:write name="createdVip" property="job"/></td>
	</tr>
	<tr>
		<td>建檔日期</td>
		<td><bean:write name="createdVip" property="crDate"/></td>
	</tr>
	<tr>
		<td>購買總金額</td>
		<td><bean:write name="createdVip" property="buySum"/></td>
	</tr>
	<tr>
		<td>VIP狀態</td>
		<td>
			<bean:write name="createdVip" property="isValidVip"/>
			(<c:out value="${createdVip.isValidVip == 'Y'?'會員':'非會員'}"/>)
		</td>
	</tr>
	<tr>
		<td>身分證號</td>
		<td><bean:write name="createdVip" property="sid"/></td>
	</tr>
	<tr>
		<td>門市</td>
		<td><bean:write name="createdVip" property="store"/></td>
	</tr>
	<tr>
		<td>專櫃小姐</td>
		<td><bean:write name="createdVip" property="storeEmployeeName"/></td>
	</tr>
	<tr>
		<td>用戶等級</td>
		<td><bean:write name="createdVip" property="vipLevel"/> 級客戶</td>
	</tr>
	<tr>
		<td>帳號狀態</td>
		<td>
			<bean:write name="createdVip" property="isAccountActive"/>
			(<c:out value="${createdVip.isAccountActive == 'Y'?'可用':'鎖定'}"/>)
		</td>
	</tr>
	<tr>
		<td>登入錯誤次數</td>
		<td><bean:write name="createdVip" property="errorCnt"/></td>
	</tr>
	<tr>
		<td>帳號隸屬</td>
		<td>
			<c:out value="${createdVip.smTbVipAccount.vipChtName}"/>(<c:out value="${createdVip.smTbVipAccount.username}"/>)
		</td>
	</tr>
</table>
</logic:present>
<br/>
</body>
</html>