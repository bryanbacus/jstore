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
<jsp:include page="${web}/common/page-title.jsp?title=產品類別資料查詢"/>
<div align="center">
<html:form action="/manager/queryProductGrpAction" focus="formType">
	<table style="width: 400pt;border: 1pt">
		<html:hidden property="formType" value="QUERY"/>
		<tr>
			<th align="right">產品類別代號:</th>
			<td>
				<html:text property="prdGroupId"/>
			</td>
			<th align="right">產品類別名稱:</th>
			<td>
				<html:text property="prdGroupName"/>
			</td>
		</tr>
		<tr>
			<th align="right">產品類別隸屬:</th>
			<td>
				<html:select property="ownerId">
					<html:option value="">全部</html:option>
					<html:optionsCollection property="vipMap" value="value" label="key"/>
				</html:select>
			</td>
			<th align="right">產品類別折扣:</th>
			<td>
				<html:select property="prdGroupDiscount">
					<html:option value="">全部</html:option>
					<html:option value="1">無折扣</html:option>
					<html:option value="0.95">九五折</html:option>
					<html:option value="0.9">九折</html:option>
					<html:option value="0.85">八五折</html:option>
					<html:option value="0.8">八折</html:option>
					<html:option value="0.75">七五折</html:option>
					<html:option value="0.7">七折</html:option>
				</html:select>
			</td>
		</tr>
		<tr>
			<th align="right">類別狀態:</th>
			<td>
				<html:select property="typeStatus">
					<html:option value="">全部</html:option>
					<html:option value="Y">持續供應中</html:option>
					<html:option value="Y">停止供應</html:option>
				</html:select>
			</td>
		</tr>
	</table>
	<html:submit value="送出查詢"/>
</html:form>
</div>
<br/>
<div align="center" style="width: 95%">
<table width="100%" border="1"
	cellpadding="2" cellspacing="2" 
	style="border-collapse: collapse;border: 1pt">
	<tr>
		<th>產品類別代號</th>
		<th>產品類別名稱</th>
		<th>產品類別折扣</th>
		<th>類別狀態</th>
		<th>產品類別描述</th>
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
			<td><c:out value="${vo.typeStatus == 'Y'?'持續供應中':'暫停供應'}"/></td>
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