<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>

<html:html locale="true">
<head>
<title><bean:message key="welcome.title"/></title>
<html:base/>
</head>
<body bgcolor="white">


<logic:notPresent name="org.apache.struts.action.MESSAGE" scope="application">
  <font color="red">
    ERROR:  Application resources not loaded -- check servlet container
    logs for error messages.
  </font>
</logic:notPresent>
<!-- 
<h3>�z�n�A<bean:message key="welcome.heading"/></h3>
<p>�z�w�g���\�n�J²�T�޲z���x�A</p>
-->
<jsp:include page="default.jsp"/>


</body>
</html:html>
