<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="com.shenming.sms.module.hibernateOrm.*,
		com.shenming.sms.dc.manager.*,
		com.shenming.sms.util.*,
		com.shenming.sms.struts.form.*" %>
		
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Insert title here</title>
</head>
<body>
<table width="100%" border="0">
	<tr>
		<td>
		<font style="color: cornflowerblue; font-size: x-large; font-weight: bold; text-align: left"/>
		<%if("info".equalsIgnoreCase(request.getParameter("type"))){ %>
			產品資訊
		<%} else { %>
			新增產品完成
		<%} %>
		</font>
		</td>
		<td align="right">
			<table width="100%">
			<tr>
			<td align="right">
			<input type="image" border=0 alt="修改"
					onclick="document.location='<c:out value="${WEB}"/>/manager/updateProduct.jsp?type=<%=ProductForm.UPDATE %>&idx=<bean:write name="productForm" property="prdId"/>'" 
					src="<c:out value="${WEB}"/>/images/icon-edit.gif">
			<input type="image" border=0 alt="搜尋"
					onclick="document.location='<c:out value="${WEB}"/>/main.jsp?fo=manager&page=queryProduct'" 
					src="<c:out value="${WEB}"/>/images/icon-search.gif">
			<input type="image" border=0 alt="上傳照片"
					onclick="document.location='<c:out value="${WEB}"/>/main.jsp?fo=manager&page=uploadPicture&idx=<bean:write name="productForm" property="prdId"/>'" 
					src="<c:out value="${WEB}"/>/images/icon-upload.gif">
			<input type="image" border=0 alt="回上一頁"
					onclick="history.go(-1)" 
					src="<c:out value="${WEB}"/>/images/icon-back.gif">
			</td>
			</tr>
			</table>
		</td>
	</tr>
</table>
	<table align="left" style="width:200pt">
		<tr>
			<td>
			<c:choose>
			<c:when test="${productForm.prdPicFile != null && productForm.prdPicFile != ''}">
				<img width=250 
					src="<c:out value="${WEB}"/>/uploadPics/<bean:write name="productForm" property="prdPicFile"/>"/>
			</c:when>
			<c:otherwise>
				<img width=250 
					src="<c:out value="${WEB}"/>/uploadPics/default.jpg"/>
			</c:otherwise>
			</c:choose>
			</td>
		</tr>
	</table><br/><br/><br/>
	<table border="1" 
		style="border: thin inset black; border-collapse: collapse; width: 400pt"
		cellpadding="3" cellspacing="3">
		<tr>
			<th style="width:100px" align="left">產品代號</th>
			<td>
				<bean:write name="productForm" property="prdId"/>
			</td>
		</tr>
		<tr>
			<th align="left">群組</th>
			<td>
				${productForm.product.smTbProductGroup.prdGroupName }(<bean:write name="productForm" property="prdGroupId"/>)
			</td>
		</tr>
		<tr>
			<th align="left">品名</th>
			<td>
				${productForm.product.name }
			</td>
		</tr>
		<tr>
			<th align="left">格式說明</th>
			<td>
				${productForm.product.formatDesc}
			</td>
		</tr>
		<tr>
			<th align="left">詳細描述</th>
			<td>
				${productForm.product.detailDesc}
			</td>
		</tr>
		<tr>
			<th align="left">供應狀態</th>
			<td>
				<bean:write name="productForm" property="suplyStatus"/>
			</td>
		</tr>
		<tr>
			<th align="left">價格</th>
			<td>
				NT$ <bean:write name="productForm" property="price"/>
			</td>
		</tr>
		<tr>
			<th align="left">VIP優惠價</th>
			<td>
				NT$ <bean:write name="productForm" property="priceVip"/>
			</td>
		</tr>
		<tr>
			<th align="left">寄送地區</th>
			<td>
				${productForm.product.sendArea}
			</td>
		</tr>
		<tr>
			<th align="left">寄送說明</th>
			<td>
				${productForm.product.sendDesc}
			</td>
		</tr>
		<tr>
			<th align="left">產品隸屬</th>
			<td>
				${productForm.product.smTbVipAccount.vipChtName}(<bean:write name="productForm" property="owner"/>)
			</td>
		</tr>
	</table>

</body>
</html>