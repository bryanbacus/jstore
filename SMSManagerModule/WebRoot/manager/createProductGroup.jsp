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
<jsp:include page="${web}/common/page-title.jsp?title=���~���O��ƫ���"/>

<div align="center">
	<html:form action="/manager/manageProductGrpAction" focus="formType">
		<table style="width:300pt;border: 1pt;">
			<html:hidden property="formType"/>
			<tr>
				<th align="right">���O�N��:</th>
				<td>
					<html:text property="prdGroupId"/>
				</td>
				<th align="right">���O�W��:</th>
				<td>
					<html:text property="prdGroupName"/>
				</td>
			</tr>
			<tr>
				<th align="right">���O�馩:</th>
				<td>
					<html:select property="prdGroupDiscount">
						<html:option value="1">�L�馩</html:option>
						<html:option value="0.95">�E����</html:option>
						<html:option value="0.9">�E��</html:option>
						<html:option value="0.85">�K����</html:option>
						<html:option value="0.8">�K��</html:option>
						<html:option value="0.75">�C����</html:option>
						<html:option value="0.7">�C��</html:option>
					</html:select>
				</td>
				<th align="right">���O���A:</th>
				<td>
					<html:select property="typeStatus">
						<html:option value="Y">���������</html:option>
						<html:option value="Y">�������</html:option>
					</html:select>
				</td>
			</tr>
			<tr>
				<th align="right">���ݩ���:</th>
				<td>
					<html:select property="ownerId">
						<html:optionsCollection property="vipMap" value="value" label="key"/>
					</html:select>
				</td>
			</tr>
			<tr>
				<th align="right">���O�y�z:</th>
				<td colspan="3">
					<html:textarea property="prdGroupDesc" 
						style="height: 3cm; width: 98%;"/>
				</td>
			</tr>
		</table>
		<c:if test="${actionType == 'CREATE'}">
		<html:submit value="�إ߲��~" onclick="document.manageProductGrpForm.formType.value='CREATE'"/>
		</c:if>
		<c:if test="${actionType == 'UPDATE'}">
		<html:submit value="�R�����~" onclick="document.manageProductGrpForm.formType.value='DELETE'"/>
		</c:if>
		<c:if test="${actionType == 'UPDATE'}">
		<html:submit value="��s���~" onclick="document.manageProductGrpForm.formType.value='UPDATE'"/>
		</c:if>
	</html:form>
	<div style="color:red;" align="center">
		<br/>
		(���ɻ����G���~���O�N���ݬ��Ʀr�榡�A�åB���i�P��L���O�N�����ơC)
	</div>
</div>
</body>
</html>