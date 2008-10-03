<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Insert title here</title>
</head>
<body>
<%
	String actionType = request.getParameter("actionType");
	pageContext.setAttribute("actionType",actionType);
%>
<jsp:include page="${web}/common/page-title.jsp?title=產品類別資料建檔"/>

<div align="center">
	<html:form action="/manager/manageProductGrpAction" focus="formType">
		<table style="width:300pt;border: 1pt;">
			<html:hidden property="formType"/>
			<tr>
				<th align="right">類別代號:</th>
				<td>
					<html:text property="prdGroupId"/>
				</td>
				<th align="right">類別名稱:</th>
				<td>
					<html:text property="prdGroupName"/>
				</td>
			</tr>
			<tr>
				<th align="right">類別折扣:</th>
				<td>
					<html:select property="prdGroupDiscount">
						<html:option value="1">無折扣</html:option>
						<html:option value="0.95">九五折</html:option>
						<html:option value="0.9">九折</html:option>
						<html:option value="0.85">八五折</html:option>
						<html:option value="0.8">八折</html:option>
						<html:option value="0.75">七五折</html:option>
						<html:option value="0.7">七折</html:option>
					</html:select>
				</td>
				<th align="right">類別狀態:</th>
				<td>
					<html:select property="typeStatus">
						<html:option value="Y">持續供應中</html:option>
						<html:option value="Y">停止供應</html:option>
					</html:select>
				</td>
			</tr>
			<tr>
				<th align="right">所屬店面:</th>
				<td>
					<html:select property="ownerId">
						<html:optionsCollection property="vipMap" value="value" label="key"/>
					</html:select>
				</td>
			</tr>
			<tr>
				<th align="right">類別描述:</th>
				<td colspan="3">
					<html:textarea property="prdGroupDesc" 
						style="height: 3cm; width: 98%;"/>
				</td>
			</tr>
		</table>
		<c:if test="${actionType == 'CREATE'}">
		<html:submit value="建立產品" onclick="document.manageProductGrpForm.formType.value='CREATE'"/>
		</c:if>
		<c:if test="${actionType == 'UPDATE'}">
		<html:submit value="刪除產品" onclick="document.manageProductGrpForm.formType.value='DELETE'"/>
		</c:if>
		<c:if test="${actionType == 'UPDATE'}">
		<html:submit value="更新產品" onclick="document.manageProductGrpForm.formType.value='UPDATE'"/>
		</c:if>
	</html:form>
	<div style="color:red;" align="center">
		<br/>
		(建檔說明：產品類別代號需為數字格式，並且不可與其他類別代號重複。)
	</div>
</div>
</body>
</html>