<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Query Product Group</title>
</head>
<body>
<jsp:include page="${web}/common/page-title.jsp?title=���~���O��Ƭd��"/>
<div align="center">
<html:form action="/manager/queryProductGrpAction" focus="formType">
	<table style="width: 400pt;border: 1pt">
		<html:hidden property="formType" value="QUERY"/>
		<tr>
			<th align="right">���~���O�N��:</th>
			<td>
				<html:text property="prdGroupId"/>
			</td>
			<th align="right">���~���O�W��:</th>
			<td>
				<html:text property="prdGroupName"/>
			</td>
		</tr>
		<tr>
			<th align="right">���~���O����:</th>
			<td>
				<html:select property="ownerId">
					<html:option value="">����</html:option>
					<html:optionsCollection property="vipMap" value="value" label="key"/>
				</html:select>
			</td>
			<th align="right">���~���O�馩:</th>
			<td>
				<html:select property="prdGroupDiscount">
					<html:option value="">����</html:option>
					<html:option value="1">�L�馩</html:option>
					<html:option value="0.95">�E����</html:option>
					<html:option value="0.9">�E��</html:option>
					<html:option value="0.85">�K����</html:option>
					<html:option value="0.8">�K��</html:option>
					<html:option value="0.75">�C����</html:option>
					<html:option value="0.7">�C��</html:option>
				</html:select>
			</td>
		</tr>
		<tr>
			<th align="right">���O���A:</th>
			<td>
				<html:select property="typeStatus">
					<html:option value="">����</html:option>
					<html:option value="Y">���������</html:option>
					<html:option value="Y">�������</html:option>
				</html:select>
			</td>
		</tr>
	</table>
	<html:submit value="�e�X�d��"/>
</html:form>
</div>
<br/>
<div align="center" style="width: 95%">
<table width="100%" border="1"
	cellpadding="2" cellspacing="2" 
	style="border-collapse: collapse;border: 1pt">
	<tr>
		<th>���~���O�N��</th>
		<th>���~���O�W��</th>
		<th>���~���O�馩</th>
		<th>���O���A</th>
		<th>���~���O�y�z</th>
	</tr>
	<logic:notEmpty name="prdGrpsList">
	<logic:iterate id="vo" 
		name="prdGrpsList" 
		type="com.shenming.sms.module.hibernateOrm.SmTbProductGroup">
		<tr>
			<td>
				<a href="/sms/manager/manageProductGrpAction.do?formType=RENDER&idx=<c:out value="${vo.prdGroupId}"/>">
					<c:out value="${vo.prdGroupId}"/>
				</a>
			</td>
			<td><c:out value="${vo.prdGroupName}"/></td>
			<td><fmt:formatNumber value="${vo.prdGroupDiscount * 100}"/>%</td>
			<td><c:out value="${vo.typeStatus == 'Y'?'���������':'�Ȱ�����'}"/></td>
			<td><c:out value="${vo.prdGroupDesc}"/></td>
		</tr>
	</logic:iterate>
	</logic:notEmpty>
	<logic:empty name="prdGrpsList">
	<tr>
	<td colspan="5" 
		style="color:gray;text-align: center;height:25pt;vertical-align: middle;">No data to display!</td></tr>
	</logic:empty>
</table>
</div>
</body>
</html>