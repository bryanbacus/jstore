<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="com.shenming.sms.struts.form.*" %>
<%@ taglib uri="/WEB-INF/tld/displaytag.tld" prefix="display" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Query Products</title>
</head>
<body>
<table width="100%">
	<tr>
		<td>
		<font style="color: cornflowerblue; font-size: x-large; font-weight: bold; text-align: left"/>
			產品資料查詢</td>
		<td align="right"></td>
	</tr>
</table>

<html:form action="/manager/queryProduct" focus="name">
	<html:hidden property="formType"/>
	<table align="center" style="width:500pt">
		<tr>
			<td align="right">群組名稱:</td>
			<td>
				<html:select property="prdGroupId" 
					onchange="queryProductForm.formType.value='queryGrpPrd';queryProductForm.submit()">
					<html:option value=""></html:option>
					<html:optionsCollection property="prdGroupMap" value="key" label="value"/>	
				</html:select>
			</td>
			<td align="right">產品名稱:</td>
			<td>
				<html:select property="name" style="width: 10em">
					<html:option value=""></html:option>
					<html:optionsCollection property="prdMap" label="value" value="key"/>	
				</html:select>
			</td>
			<td align="right">價錢:</td>
			<td>
				<html:text property="priceMin" size="6"/>
			</td>
			<td align="right">~</td>
			<td>
				<html:text property="priceMax" size="6"/>
			</td>
			<td align="right">供應狀態:</td>
			<td>
				<html:select property="suplyStatus">
					<html:option value=""></html:option>
					<html:option value="Y">持續供應中</html:option>
					<html:option value="N">停止供應</html:option>
				</html:select>
			</td>
		</tr>
		<tr>
			<td colspan="10" align="center" style="text-align: center;">
				<html:submit value="查詢"
					onclick="queryProductForm.formType.value = 'query'"/>
				<html:submit value="列出全部" 
					onclick="queryProductForm.formType.value = 'queryAll'"/>
			</td>
		</tr>
	</table>
</html:form>


<logic:present name="queryProductForm" property="products">
<table border="1" width="100%"
		style="border: thin inset black; border-collapse: collapse"
		cellpadding="3" cellspacing="0">
		<tr>
			<td align="center">品號</td>
			<td align="center">產品名稱</td>
			<td align="center">群組名稱</td>
			<td align="center">價格</td>
			<td align="center">VIP優惠價</td>
			<td align="center">供應狀態</td>
			<td align="center">產品隸屬</td>
			<td align="center">其他資訊</td>
		</tr>
	<logic:iterate id="product" name="queryProductForm" property="products">
	<tr onmouseover="this.style.background='#CCCCCC'" onmouseout="this.style.background=''">
		<td align="center"><bean:write name="product" property="prdId"/></td>
		<td align="center"><bean:write name="product" property="name"/></td>
		<td align="center"><bean:write name="product" property="smTbProductGroup.prdGroupName"/></td>
		<td align="center"><bean:write name="product" property="price"/></td>
		<td align="center"><bean:write name="product" property="priceVip"/></td>
		<td align="center"><bean:write name="product" property="suplyStatus"/></td>
		<td align="center"><bean:write name="product" property="smTbVipAccount.vipChtName"/>(<bean:write name="product" property="smTbVipAccount.username"/>)</td>
		<td align="center">
			<input type="image" alt="詳細資訊"
				src="<c:out value="${WEB}"/>/images/icon-info.gif"
				onclick="document.location='<c:out value="${WEB }"/>/manager/updateProduct.jsp?type=info&idx=<bean:write name="product" property="prdId"/>'"/>
			<input type="image" alt="修改資料"
				src="<c:out value="${WEB}"/>/images/icon-edit.gif"
				onclick="document.location='<c:out value="${WEB }"/>/manager/updateProduct.jsp?type=<%=ProductForm.UPDATE %>&idx=<bean:write name="product" property="prdId"/>'"/>

		</td>
	</tr>
	</logic:iterate>
</table>
</logic:present>
</body>
</html>