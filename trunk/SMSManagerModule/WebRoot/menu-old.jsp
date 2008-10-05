<%@ page contentType="text/html; charset=big5" language="java"
	import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.shenming.sms.manager.FormManager"%>



<!-- Tool Bar Start -->

<table border="0" cellspacing="1" cellpadding="0">
	<tr align="left">
		<td>&nbsp;&nbsp;&nbsp;</td>
		
		<td valign="middle"><input type="image" border=0 alt="首頁"
			onclick="document.location='<c:out value="${WEB}"/>/main.jsp'"
			src="<c:out value="${WEB}"/>/images/icon-main.gif"></td>
		<td valign="middle"><input type="image" border=0 alt="首頁"
			onclick="document.location='<c:out value="${WEB}"/>/main.jsp'"
			src="<c:out value="${WEB}"/>/images/menu-main.gif" onmouseover="this.height = this.height+1;" onmouseout="this.height = this.height-1;"></td>

		<td valign="middle"><input type="image" border=0 alt="會員資料登錄"
			onclick="document.location='<c:out value="${WEB}"/>/main.jsp?fo=manager&page=createVipUser'"
			src="<c:out value="${WEB}"/>/images/icon-vip.gif"></td>
		<td valign="middle"><input type="image" border=0 alt="會員資料登錄"
			onclick="document.location='<c:out value="${WEB}"/>/main.jsp?fo=manager&page=createVipUser'"
			src="<c:out value="${WEB}"/>/images/menu-createVip.gif" onmouseover="this.height = this.height+1;" onmouseout="this.height = this.height-1;"></td>

		<td><input type="image" border=0 alt="會員資料查詢"
			onclick="document.location='<c:out value="${WEB}"/>/main.jsp?fo=manager&page=queryVipUser'"
			src="<c:out value="${WEB}"/>/images/icon-search-vip.gif"></td>
		<td><input type="image" border=0 alt="會員資料查詢"
			onclick="document.location='<c:out value="${WEB}"/>/main.jsp?fo=manager&page=queryVipUser'"
			src="<c:out value="${WEB}"/>/images/menu-queryVip.gif" onmouseover="this.height = this.height+1;" onmouseout="this.height = this.height-1;"></td>

		<td><input type="image" border=0 alt="產品建檔"
			onclick="document.location='<c:out value="${WEB}"/>/main.jsp?fo=manager&page=createProduct'"
			src="<c:out value="${WEB}"/>/images/icon-clothes.gif"></td>
		<td><input type="image" border=0 alt="產品建檔"
			onclick="document.location='<c:out value="${WEB}"/>/main.jsp?fo=manager&page=createProduct'"
			src="<c:out value="${WEB}"/>/images/menu-createPrd.gif" onmouseover="this.height = this.height+1;" onmouseout="this.height = this.height-1;"></td>

		<td><input type="image" border=0 alt="產品查詢"
			onclick="document.location='<c:out value="${WEB}"/>/main.jsp?fo=manager&page=queryProduct'"
			src="<c:out value="${WEB}"/>/images/icon-search-clothes.gif"></td>
		<td><input type="image" border=0 alt="產品查詢"
			onclick="document.location='<c:out value="${WEB}"/>/main.jsp?fo=manager&page=queryProduct'"
			src="<c:out value="${WEB}"/>/images/menu-queryPrd.gif" onmouseover="this.height = this.height+1;" onmouseout="this.height = this.height-1;"></td>
		
		<td><input type="image" border=0 alt="銷售資料登錄"
			onclick="document.location='<c:out value="${WEB}"/>/main.jsp?fo=sale&page=createOrder'"
			src="<c:out value="${WEB}"/>/images/icon-order.gif"></td>
		<td><input type="image" border=0 alt="銷售資料登錄"
			onclick="document.location='<c:out value="${WEB}"/>/main.jsp?fo=sale&page=createOrder'"
			src="<c:out value="${WEB}"/>/images/menu-createOrder.gif" onmouseover="this.height = this.height+1;" onmouseout="this.height = this.height-1;"></td>
		
		<td><input type="image" border=0 alt="銷售資料查詢"
			onclick="document.location='<c:out value="${WEB}"/>/main.jsp?fo=sale&page=queryOrder'"
			src="<c:out value="${WEB}"/>/images/icon-search-order.gif"></td>
		<td><input type="image" border=0 alt="銷售資料查詢"
			onclick="document.location='<c:out value="${WEB}"/>/main.jsp?fo=sale&page=queryOrder'"
			src="<c:out value="${WEB}"/>/images/menu-queryOrder.gif" onmouseover="this.height = this.height+1;" onmouseout="this.height = this.height-1;"></td>
		
		<td><input type="image" border=0 alt="單筆簡訊發送設定"
			onclick="document.location='<c:out value="${WEB}"/>/main.jsp?fo=sms&page=singleSmsSender&isDefault=true'"
			src="<c:out value="${WEB}"/>/images/icon-sms.gif"></td>
		<td><input type="image" border=0 alt="單筆簡訊發送設定"
			onclick="document.location='<c:out value="${WEB}"/>/main.jsp?fo=sms&page=singleSmsConfig&isDefault=true'"
			src="<c:out value="${WEB}"/>/images/menu-singleSms.gif" onmouseover="this.height = this.height+1;" onmouseout="this.height = this.height-1;"></td>
		
		<td><input type="image" border=0 alt="批次簡訊發送設定"
			onclick="document.location='<c:out value="${WEB}"/>/main.jsp?fo=sms&page=batchSmsConfig&isDefault=true'"
			src="<c:out value="${WEB}"/>/images/icon-sms.gif"></td>
		<td><input type="image" border=0 alt="批次簡訊發送設定"
			onclick="document.location='<c:out value="${WEB}"/>/main.jsp?fo=sms&page=batchSmsConfig&isDefault=true'"
			src="<c:out value="${WEB}"/>/images/menu-batchSms.gif" onmouseover="this.height = this.height+1;" onmouseout="this.height = this.height-1;"></td>
		
		<td><input type="image" border=0 alt="簡訊記錄查詢"
			onclick="document.location='<c:out value="${WEB}"/>/main.jsp?fo=sms&page=querySmsHistory'"
			src="<c:out value="${WEB}"/>/images/icon-sms.gif"></td>
		<td><input type="image" border=0 alt="簡訊記錄查詢"
			onclick="document.location='<c:out value="${WEB}"/>/main.jsp?fo=sms&page=querySmsHistory'"
			src="<c:out value="${WEB}"/>/images/menu-querySmsHistory.gif" onmouseover="this.height = this.height+1;" onmouseout="this.height = this.height-1;"></td>
		
	</tr>
</table>
