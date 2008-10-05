<%@ page contentType="text/html; charset=big5" 
	language="java" import="java.sql.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.shenming.sms.manager.FormManager" %>
<html>
<head>
	<jsp:include page="inc/common.jsp"/>
	<meta http-equiv="Content-Type" content="text/html; charset=big5" />
	<title>
	</title>
<style type="text/css">
<!--
body {
	margin-left: 0px;
	margin-top: 0px;
	margin-right: 0px;
	margin-bottom: 0px;
}
-->
</style>
<script type="text/javascript" src=" http://shots.snap.com/snap_shots.js?ap=1&amp;key=cc8506d9f805dbde707e1f1df4d8b93d&amp;sb=1&amp;th=silver&amp;cl=1&amp;si=0&amp;po=0&amp;df=0&amp;oi=0&amp;link_icon=on&amp;shots_trigger=both&amp;size=large&amp;lang=en-us&amp;domain=www.alexmak.org&amp;as=1"></script >
</head>

<%
	if(session.getAttribute("WEB") == null || "".equalsIgnoreCase((String)session.getAttribute("WEB"))){
		String WEB = request.getContextPath();
		session.setAttribute("WEB", WEB);
	}
%>
<body>

<table cellspacing="0" cellpadding="0" style="width:100%; border:0pt; ">
  <tr>
    <td></td>
    <td background="<c:out value="${WEB}"/>images/header-bg.jpg"><img src="<c:out value="${WEB}"/>/images/header.jpg" /></td>
    <td></td>
  </tr>
  <tr>
    <td></td>
    <td height=300>
		<table border="0" cellspacing="0" cellpadding="0" style="width:100%;height:100%">
		  <tr>
			<td width="244" height="36" valign=top background="<c:out value="${WEB}"/>/images/menu-top.jpg">&nbsp;</td>
			<td style="background-image:url('<c:out value="${WEB}"/>/images/top-menu-bg.jpg');background-repeat: repeat;" height="36" valign="center">
				<table cellpadding="0" cellspacing="0" style="width:450px;">
				<tr>
				<td>&nbsp;</td>
				<td>
				<!-- Tool Bar Start -->
				<jsp:include page="menu.jsp"/>
				<!-- Tool Bar End -->
				</td>
				</tr>
				</table>
			</td>
		  </tr>
		  <tr>
		    <td rowspan="3" width="244" height="26" align="center" valign=top 
		    	style="background-image:url('<c:out value="${WEB}"/>/images/menu-bg.jpg');background-repeat: repeat;">
		    	<!-- Left Menu Start -->
		    	<table border="0" align="left" cellpadding="0" cellspacing="0" width="244">
		    	<tr height="26"><td>
		    		<img src="<c:out value="${WEB}"/>/images/menu-top-02.jpg" width="244" height="26" /></td></tr>
		    	<tr height="31"><td>
		    		<img src="<c:out value="${WEB}"/>/images/toolbar-header.jpg" width="244" height="31" /></td></tr>
				<tr height="100%">
				<td valign="top" align="center">
					<jsp:include page="frame-login.jsp"/>
					<jsp:include page="frame-left.jsp"/>
				</td>
				</tr>
				</table>
				<!-- Left Menu End -->
			</td>
			<td rowspan="3" background="<c:out value="${WEB}"/>/images/space.jpg" height="100%" valign="top">
				<!-- Main Context Start -->
				<table border="0" align="left" cellpadding="8" cellspacing="8" width="100%" height="100%">
				<tr>
				<td valign="top">
				<%if(FormManager.currentFormPage(request)!=null){%>
				<jsp:include page="<%=FormManager.currentFormPage(request) %>"/>
				<%} else {%>
				<jsp:include page="default.jsp"/>
				<%} %>
				</td>
				</tr>
				</table>
				<!-- Main Context End -->			
			</td>
		  </tr>
		 
		</table>

	</td>
    <td></td>
  </tr>
  <tr>
    <td></td>
    <td height=42 
    	style="background-repeat: repeat; text-align:center; "
    	background="<c:out value="${WEB}"/>/images/footer-bg.jpg" valign="middle" align="center">
    	<!-- Foorter Start --><br/>
		＠版權所有 Copyright C By. 三壘手童裝. 本站最佳解析度為1024X768 IE5.0以上流覽
		<!-- Footer End -->
	</td>
    <td></td>
  </tr>
  <tr>
    <td></td>
    <td height="10"></td>
    <td></td>
  </tr>
</table>
</body>
</html>