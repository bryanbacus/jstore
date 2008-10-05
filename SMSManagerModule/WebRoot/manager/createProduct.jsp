<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html><c:import url="" context=""/>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Create Product</title>
</head>
<body>
<table width="100%">
	<tr>
		<td>
		<font style="color: cornflowerblue; font-size: x-large; font-weight: bold; text-align: left"/>
			產品資料建檔</td>
		<td align="right"></td>
	</tr>
</table>

<html:form action="/manager/manageProductAction" focus="formType">
	<table align="center" border="1" style="border-collapse: collapse; width:400pt">
		<html:hidden property="formType"/>
		<tr>
			<th align="right">產品序號:</th>
			<td>
				<font color="red">由系統自動產生</font>
				<html:hidden property="prdId"/>
			</td>
		</tr>
		<tr>
			<th align="right">產品群組:</th>
			<td>
				<html:select property="prdGroupId">
					<html:option value=""></html:option>
					<html:optionsCollection 
						property="prdGrpMap" label="value" value="key"/>	
				</html:select>
			</td>
		</tr>
		<tr>
			<th align="right">產品名稱:</th>
			<td>
				<html:text property="name"/>
			</td>
		</tr>
		<tr>
			<th align="right">產品詳細描述:</th>
			<td>
				<html:text property="detailDesc" size="50"/>
			</td>
		</tr>
		<tr>
			<th align="right">產品規格描述:</th>
			<td>
				<html:text property="formatDesc" size="50"/>
			</td>
		</tr>
		<tr>
			<th align="right">價格:</th>
			<td>
				<html:text property="price"/>
			</td>
		</tr>
		<tr>
			<th align="right">VIP價格:</th>
			<td>
				<html:text property="priceVip"/>
			</td>
		</tr>
		<tr>
			<th align="right">供應狀態:</th>
			<td>
				<html:select property="suplyStatus">
				<html:option value="Y">持續供應中</html:option>
				<html:option value="N">停止供應</html:option>
				</html:select>
			</td>
		</tr>
		<tr>
			<th align="right">送貨地點:</th>
			<td>
				<html:text property="sendArea" size="50"/>
			</td>
		</tr>
		<tr>
			<th align="right">送貨描述:</th>
			<td>
				<html:text property="sendDesc" size="50"/>
			</td>
		</tr>
		<tr>
			<th align="right">產品照片擋:</th>
			<td>
				<html:text property="prdPicFile"/>
			</td>
		</tr>
		<tr>
			<th align="right">產品隸屬:</th>
			<td>
				<html:select property="owner">
					<html:option value=""></html:option>
					<html:optionsCollection 
						property="ownerMap" value="value" label="key"/>	
				</html:select>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<c:if test="${productForm.formType == 'update'}">
					<html:submit value="更新產品"/>
				</c:if>
				<c:if test="${productForm.formType != 'update'}">
					<html:submit value="建立產品"/>
				</c:if>
			</td>
		</tr>
	</table>
	
</html:form>

</body>
</html>