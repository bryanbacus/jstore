<%@ page contentType="text/html; charset=big5"%>
<%@ page language="java"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<title>上傳照片</title>
		
</head>
<body topmargin="0" leftmargin="0" rightmargin="0" bottommargin="0"
	marginwidth="0" marginheight="0">
<p align="center" 
	style="height:50px;vertical-align: middle;font-size: xx-large;font-weight: bold;">
		上傳個人照片
</p>
<TABLE align=center>
	<tr>
		<td>
		<table border=0 width=517px align=center>
			<tr align=left>
				<td>為避免上傳之照片變形，上傳之照片請修改為寬120pix，長150pix大小之JPG格式，如您上傳之圖片無法正常顯示，請重新整理頁面，以清除瀏覽器之暫存圖片檔案，謝謝！</td>
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
			<input type="submit" value="送出" name="B1" style="height:20px"></p>
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
		如無法檢視新上傳照片，請按：
		<input type="button" value="重新整理"
			onClick="window.location.reload()">
</logic:present>
</p>
</body>
</html>
