<%@ page contentType="text/html; charset=big5"%>
<%@ page language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<title>�W�ǷӤ�</title>
		
</head>
<body topmargin="0" leftmargin="0" rightmargin="0" bottommargin="0"
	marginwidth="0" marginheight="0">
<p align="center" 
	style="height:50px;vertical-align: middle;font-size: xx-large;font-weight: bold;">
		�W�ǭӤH�Ӥ�
</p>
<TABLE align=center>
	<tr>
		<td>
		<table border=0 width=517px align=center>
			<tr align=left>
				<td>���קK�W�Ǥ��Ӥ��ܧΡA�W�Ǥ��Ӥ��Эקאּ�e120pix�A��150pix�j�p��JPG�榡�A�p�z�W�Ǥ��Ϥ��L�k���`��ܡA�Э��s��z�����A�H�M���s�������Ȧs�Ϥ��ɮסA���¡I</td>
			</tr>
		</table>
		</td>
	</tr>
	<tr>
		<td align=center>
		<form name="uploadPictureForm"
			action="<c:out value="${WEB }"/>/manager/uploadPictureAction.do" method="POST"
			enctype="multipart/form-data">
		<p> 
			<input type="hidden" name="idx" value="<%=request.getParameter("idx") %>"/>
			<input type="file" name="pic" size="20">
			<input type="submit" value="�e�X" name="B1" style="height:20px"></p>
		</form>
		</td>
	</tr>
</TABLE>
<p align="center">
<logic:present name="filename">
	<font color="red"><bean:write name="message" /></font>
	<br />
	<br />
	<img border="0" border="1"
		src="<c:out value="${WEB}"/>/uploadPics/<bean:write name="filename"/>" width="120"
		height="150">
	<br />
	<br />
		�p�L�k�˵��s�W�ǷӤ��A�Ы��G
		<input type="button" value="���s��z"
			onClick="window.location.reload()">
</logic:present>
</p>
</body>
</html>
