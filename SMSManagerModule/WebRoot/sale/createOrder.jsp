<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>建立訂單</title>
<script type="text/javascript">
<!--
function checkForm(){
	if(orderForm.vipId.value == '0' || orderForm.vipId.value == null){
		alert("請輸入客戶代號");
		return false;
	}
	return true;
}
//-->
</script>
</head>
<body>

<table width="100%" border="0">
	<tr>
		<td>
		<font style="color: cornflowerblue; font-size: x-large; font-weight: bold; text-align: left"/>
			銷售資料登錄
		</td>
		<td align="right">
			<table width="100%">
			<tr>
			<td align="right">
			<input type="image" border=0 alt="搜尋產品"
					onclick="document.location='<c:out value="${WEB}"/>/main.jsp?fo=manager&page=queryProduct'" 
					src="<c:out value="${WEB}"/>/images/icon-search.gif">
			<input type="image" border=0 alt="回上一頁"
					onclick="history.go(-1)" 
					src="<c:out value="${WEB}"/>/images/icon-back.gif">
			</td>
			</tr>
			</table>
		</td>
	</tr>
</table>

<html:form action="/sale/manageOrderAction" focus="prdId">
	<table align="center" border="0" style="width:450pt">
		<html:hidden property="formType"/>
		<html:hidden property="isClosed" value="N"/>
		<tr>
			<th align="right">客戶代號:</th>
			<td><html:text property="vipId" readonly="<%=!(session.getAttribute("items")==null) %>" /></td>
		
			<th align="right">產品:</th>
			<td>
				<html:select property="prdGrpId" onchange="orderForm.formType.value='query';orderForm.prdId.value=0;orderForm.submit();">
					<html:option value=""></html:option>
					<html:optionsCollection property="prdGrpMap" value="key" label="value"/>
				</html:select>
				<logic:present property="prdId" name="orderForm">
				<html:select property="prdId" onchange="orderForm.formType.value='query';orderForm.submit();">
					<html:option value=""></html:option>
					<html:optionsCollection property="prdMap" value="key" label="value"/>
				</html:select>
				</logic:present>
			</td>
			
			<th align="right">件數:</th>
			<td>
				<table>
				<tr>
					<td valign="middle"><html:text property="count" value="1" size="5"/></td>
					<td valign="middle"><img src="<c:out value="${WEB }"/>/images/icon-add.gif" onclick="orderForm.count.value= parseInt(orderForm.count.value)+ parseInt('1')"></>
					<td valign="middle"><img src="<c:out value="${WEB }"/>/images/icon-minus.gif" onclick=" if(parseInt(orderForm.count.value) > 0){orderForm.count.value= parseInt(orderForm.count.value)- parseInt('1')}"></>
				</tr>
				</table>
			</td>
		</tr>
		<tr>
			<th align="right">單價:</th>
			<td>
				<bean:write property="unitPrice" name="orderForm"/>
				<html:hidden property="unitPrice"/>
			</td>
			<th align="right">優惠價:</th>
			<td>
				<html:text property="discountPrice"/>
			</td>
		</tr>
		
		<tr>
			<th align="right">附註:</th>
			<td colspan="5">
			<table>
				<tr>
				<td>
				<html:text property="logString" size="70"/>
				</td>
				<td>
				<input type="image" src="<c:out value="${WEB }"/>/images/icon-cart.gif" alt="放至購物車" 
					onclick="orderForm.formType.value='keep_session';checkForm();"/>
				<input type="image" src="<c:out value="${WEB }"/>/images/icon-trash-can.gif" alt="清空購物車" onclick="orderForm.formType.value='delete_session_all';" />
				</td>
				</tr>
			</table>
			</td>
		</tr>
	</table>

</html:form>

<p align="center" style="color:red;">
<c:out value="${message}"/>
</p>

<logic:present name="items">
<table border="1" width="100%"
		style="border: thin inset black; border-collapse: collapse"
		cellpadding="3" cellspacing="0">
	<tr>
		<td align=center>臨時序號</td>
		<td align=center>產品名稱</td>
		<td align=center>單價</td>
		<td align=center>優惠價</td>
		<td align=center>數量</td>
		<td align=center width="250">附註</td>
		<td align=center width="40">刪除</td>
	</tr>
	<logic:iterate id="item" name="items">
	<tr onmouseover="this.style.background='#CCCCCC'" onmouseout="this.style.background=''">
		<td align=center><bean:write name="item" property="itemSeq"/></td>
		<td align=center><c:out value="${item.smTbProduct.name}"/></td>
		<td align=center><bean:write name="item" property="prdUnitPrice"/></td>
		<td align=center><bean:write name="item" property="prdDiscountPrice"/></td>
		<td align=center><bean:write name="item" property="count"/></td>
		<td align=left><bean:write name="item" property="log"/></td>
		<td align=center><img src="<c:out value="${WEB }"/>/images/icon-trash-can.gif" 
				alt="從購物車中移除本商品" 
				onclick="orderForm.formType.value='delete_session';document.location='<c:out value="${WEB }"/>/sale/manageOrderAction.do?type=delete_session&idx=<bean:write name="item" property="itemSeq"/>';" /></td>
	</tr>
	</logic:iterate>
	<tr>
		<td colspan="8" align="center" valign="middle">
			<img src="<c:out value="${WEB }"/>/images/icon-package.gif" 
				alt="送出購物單" 
				onclick="orderForm.formType.value='create';document.location='<c:out value="${WEB }"/>/sale/manageOrderAction.do?type=create&vipId='+ orderForm.vipId.value;" />
		</td>
	</tr>
</table>
</logic:present>


</body>
</html>