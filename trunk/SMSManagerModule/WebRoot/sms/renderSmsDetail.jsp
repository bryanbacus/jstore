<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="com.shenming.sms.dc.manager.*,
	com.shenming.sms.module.hibernateOrm.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Insert title here</title>
</head>
<body>
<% 
String idxStr = (String)request.getParameter("idx");
SmTbMessageQueue vo = null;
if(idxStr != null && !"".equalsIgnoreCase(idxStr)){
	vo = SenderManager.retrieveMessageQueueById(new Integer(idxStr).intValue());
	request.setAttribute("vo", vo);
}
%>
<p style="font-size: large; font-weight: bold; text-align: center">²�T�ԲӤ��e</p>
<table width="500" align="center" cellpadding="2" cellspacing="3" style="border: dotted">
<tr><th width="110" align="left">�ǰe�Ǹ�</th><td><c:out value="${vo.idx}"/></td></tr>
<tr><th align="left">�����ݹq��</th><td><c:out value="${vo.mobile}"/><td></tr>
<tr><th align="left">�����̥N��</th><td><a href="main.jsp?fo=manager&page=renderUserById&type=show&idx=<c:out value="${vo.recipientId}"/>"><c:out value="${vo.recipientId}"/></a></td></tr>
<tr><th align="left">�ǰe���e</th><td><c:out value="${vo.smTbMessageContext.smsContext}"/><td></tr>
<tr><th align="left" valign="top">��������</th>
	<td>
		<c:forEach items="<%= vo.getSmTbMessageLogs() %>" var="log">
			[<c:out value="${log.createDate}"/>]<c:out value="${log.log}"/><br/>
		</c:forEach>
	<td></tr>
<tr><th align="left">�ǰe�H���N��</td><td><a href="main.jsp?fo=manager&page=renderUserById&type=show&idx=<c:out value="${vo.createUserId}"/>"><c:out value="${vo.createUserId}"/></a></td></tr>
<tr><th align="left">�w�p�ǰe���</th><td><bean:write name="vo" property="sendDate" format="M/d/yyyy h:mm a z"/><td></tr>
<tr><th align="left" width="100">�إߤ��</th><td><bean:write name="vo" property="createDate" format="M/d/yyyy h:mm a z"/></td></tr>
</table>
<p align="center">
	<input type="button" value="�^��W��" onclick="history.go(-1)">
</p>
</body>
</html>