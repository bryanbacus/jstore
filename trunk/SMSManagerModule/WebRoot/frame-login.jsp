<%@ page contentType="text/html; charset=big5" language="java"
	import="java.sql.*" errorPage=""%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<table border="1" cellspacing="0" cellpadding="0" style="width:100%">
	<tr>
		<td background="<c:out value="${WEB}"/>/images/toolbar-header-bg.jpg"
			height="35">
		<div align="center" style="margin: 10pt 0 0 0"><h1>登錄系統</h1></div>
		</td>
	</tr>
	<tr>
		<td align="center">

		<table cellspacing="2" cellpadding="2" style="width:100%; text-align: center;border:none;">
			<c:choose>
				<c:when test="${!managerLoginForm.valiedUser}">
					<html:form action="/manager/loginAction" focus="username">
						<tr>
							<td style="text-align:center;font-weight: bold">帳號:<html:text property="username" style="width: 100pt"/></td>
						</tr>
						<tr>
							<td style="text-align:center;font-weight: bold">密碼:<html:password property="password" style="width:100pt"/></td>
						</tr>
						<html:hidden property="userType" value="manager" />
						<tr>
							<td colspan="1" style="text-align:center"><html:submit value="登入" /> <input
								type="button" value="註冊" /></td>
						</tr>
					</html:form>
				</c:when>

				<c:otherwise>
					<tr>
						<td style="text-align:center;font-size:small"><c:out value="${managerLoginForm.username}" />，歡迎光臨!</td>
					</tr>
					<tr>
						<td style="text-align:center;"><input type="button" value="登出"
							onclick="document.location='<c:out value="${WEB }"/>/manager/loginAction.do?type=logout'" />
						</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</table>
		</td>
	</tr>
</table>
