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

<logic:present name="createdVip">
<table border="1" style="width:8.8cm;height:3.6cm" align="center"
		style="border: thin inset black; border-collapse: collapse"
		cellpadding="3" cellspacing="3">
	<tr>
		<td>
		<table border="0">
		<td>&nbsp;</td>
		<td style="font-size: 14pt">
			<%
				String addr = ((SmTbVipAccount)request.getAttribute("createdVip")).getAddress();
				String subStr = addr.length()>3?addr.substring(0,3):"";
				try{
					new Integer(subStr);
					out.println(subStr + "<br/>");
				} catch(Exception e){
					out.println("<br/>");
					System.err.println("[帳號:"+((SmTbVipAccount)request.getAttribute("createdVip")).getUsername()+"]地址格式錯誤，請檢查郵遞區號");
				}
				out.println(addr.length()>3?addr.substring(3):"" + "<br/>");
			%>
			<bean:write name="createdVip" property="vipChtName"/><br/>
			<bean:write name="createdVip" property="userId"/><br/>
		</td>
		<td>&nbsp;</td>
		</table>
		</td>
	</tr>
</table>
</logic:present>

</body>
</html>