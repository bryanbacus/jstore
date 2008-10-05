<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="java.util.*,
	com.shenming.sms.dc.manager.SmsVipManager" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>會員資料查詢</title>

<%
/*
<link rel="STYLESHEET" type="text/css" href="${WEB }/js/dhtmlx/codebase/dhtmlxgrid.css">
<script  src="${WEB }/js/dhtmlx/codebase/dhtmlxcommon.js"></script>
<script  src="${WEB }/js/dhtmlx/codebase/dhtmlxgrid.js"></script>		
<script  src="${WEB }/js/dhtmlx/codebase/dhtmlxgridcell.js"></script>	
<script  src="${WEB }/js/dhtmlx/codebase/ext/dhtmlxgrid_start.js"></script>
*/ 
SmsVipManager.initialize();
Map vipMap = SmsVipManager.retrieveAllUserMap();
request.setAttribute("vipMap",vipMap);
%>
</head>
<body>

<jsp:include page="${web}/common/page-title.jsp?title=會員資料查詢"/>

<p align="center">
	<html:form action="/manager/queryVipAction" focus="birthday">
		<table align="center" style="width:400pt">
			<tr><td colspan="4" align="left" style="font-weight: bold;height:15pt;vertical-align: middle;">使用VIP資料查詢:</td></tr>
			<tr>
				<td align="right">中文名稱:</td>
				<td>
					<html:text property="vipChtName"/>
				</td>
				<td align="right">會員ID:</td>
				<td>
					<html:text property="userId"/>
				</td>
			</tr>
			<tr>
				<td align="right">店名:</td>
				<td>
					<html:select property="owner">
						<html:option value="-1">全部</html:option>
						<html:optionsCollection property="ownerMap" value="value" label="key"/>
					</html:select>
				</td>
				<td align="right">VIP身分證號:</td>
				<td>
					<html:text property="sid"/>
				</td>
			</tr>
			<tr>
				<td align="right">顧客等級:</td>
				<td>
					<html:select property="vipLevel">
						<html:option value="">全部</html:option>
						<html:option value="A">A級客戶</html:option>
						<html:option value="B">B級客戶</html:option>
						<html:option value="C">C級客戶</html:option>
						<html:option value="D">D級客戶</html:option>
					</html:select>
				</td>
				<td align="right">是否為有效VIP:</td>
				<td>
					<html:select property="isValidVip">
						<html:option value="">全部</html:option>
						<html:option value="Y">VIP用戶</html:option>
						<html:option value="N">非VIP用戶</html:option>
					</html:select>
				</td>
			</tr>
			
			<tr>
				
				<td align="right">VIP生日月份:</td>
				<td>
					<html:select property="birthday">
						<html:option value="">全部</html:option>
						<html:option value="1">一月</html:option>
						<html:option value="2">二月</html:option>
						<html:option value="3">三月</html:option>
						<html:option value="4">四月</html:option>
						<html:option value="5">五月</html:option>
						<html:option value="6">六月</html:option>
						<html:option value="7">七月</html:option>
						<html:option value="8">八月</html:option>
						<html:option value="9">九月</html:option>
						<html:option value="10">十月</html:option>
						<html:option value="11">十一月</html:option>
						<html:option value="12">十二月</html:option>
					</html:select>
				</td>
			</tr>
			<tr><td colspan="4" align="left" style="font-weight: bold;height:15pt;vertical-align: middle;">使用孩童資料查詢:</td></tr>
			<tr>
				
				<td align="right">孩童性別:</td>
				<td>
					<html:select property="childSex">
						<html:option value="">全部</html:option>
						<html:option value="M">男</html:option>
						<html:option value="F">女</html:option>
					</html:select>
				</td>
				<td align="right">孩童生日月份:</td>
				<td>
					<html:select property="childBirthday">
						<html:option value="">全部</html:option>
						<html:option value="1">一月</html:option>
						<html:option value="2">二月</html:option>
						<html:option value="3">三月</html:option>
						<html:option value="4">四月</html:option>
						<html:option value="5">五月</html:option>
						<html:option value="6">六月</html:option>
						<html:option value="7">七月</html:option>
						<html:option value="8">八月</html:option>
						<html:option value="9">九月</html:option>
						<html:option value="10">十月</html:option>
						<html:option value="11">十一月</html:option>
						<html:option value="12">十二月</html:option>
					</html:select>
				</td>
			</tr>
			<tr>
				<td colspan="4" style="text-align:center">
					<html:submit value="查詢VIP"/>
					<input type=button value="全部列出" 
						onclick="document.location='/sms/manager/queryVipAction.do?qt=all'"/>
				</td>
			</tr>
			
		</table>
		
	</html:form>
	<br/>
	<div style="color: red;text-align: center;">PS:VIP生日月份與孩童生日月份有一成立，則會被系統取出。</div>
</p>
<div align="center">
	<display:table id="item" name="${sessionScope.vipAccounts}" 
		style="border:1px;"
		pagesize="15" defaultorder="descending" sort="list" 
		cellpadding="1" cellspacing="1" export="true"> 
		<!-- Export Config -->
	    <display:setProperty name="export.rtf.filename" value="export.rtf"/>
	    <display:setProperty name="export.xml.filename" value="export.xml"/>
	    <display:setProperty name="export.csv.filename" value="export.cvs"/>
 	    <display:setProperty name="export.pdf" value="true" />
		<display:column title="#" sortable="true">
	    	<c:out value="${item_rowNum}"/>
	    </display:column>
	    <display:column media="html" title="帳號名稱" sortable="true" style="text-align:center;">
			<a href="renderShowEmpDetail.jsp?idx=${empItem.empId}"><c:out value="${empItem.empId}"/></a>
			<a href="${WEB }/main.jsp?fo=manager&page=renderUserById&act=show&idx=${item.userId}">
				${item.userId}
			</a>
		</display:column>
		<display:column media="csv excel xml rtf pdf" title="帳號名稱" sortable="true" style="text-align:center;">
				${item.userId}
		</display:column>
		<display:column property="vipChtName" title="中文名稱" style="text-align:center;"/>
		<display:column title="生日" sortable="true" >
			<fmt:formatDate value="${item.birthday}" type="date" dateStyle="short"/>	
		</display:column>
		<display:column title="消費金額累計" style="text-align:center;">
			NT$<c:out value="${item.buySum}"/>
		</display:column>
		<display:column title="會員" style="text-align:center;">
			<c:out value="${item.isValidVip == 'Y'? '會員':'非會員'}"/>
		</display:column>
		<display:column title="性別" style="text-align:center;">
			<c:out value="${item.sex == 'M'? '男':'女'}"/>
		</display:column>
		<display:column property="phone" title="電話"/>
		<display:column property="mobile" title="行動電話"/>
		<display:column title="分店" sortable="true">
			${item.smTbVipAccount.vipChtName}
		</display:column>
		<display:column media="html" title="信箱">
			<a href=mailto:${item.mailAddr }>
				<c:if test="${item.mailAddr !=null && item.mailAddr != ''}">
					<img border=0 src="${WEB }/images/icon-mail.gif">
				</c:if>
			</a>
		</display:column>
		<display:column media="html" title="地址">
			${item.smTbVipAccount.address}
		</display:column>
		<display:column media="csv excel xml rtf pdf" title="信箱">
			${item.mailAddr}
		</display:column>
		<display:column media="csv excel xml rtf pdf" title="地址">${item.address}</display:column>
		<display:column media="html" title="標籤" >
			<img border=0 
				onclick="window.open('<c:out value="${WEB}"/>/manager/renderUserById.jsp?idx=${item.userId}&act=tag')" 
				src="${WEB}/images/icon-tag.gif">
		</display:column>
		<display:column media="html" title="修改" >
			<img border=0 
				onclick="document.location='${WEB }/manager/updateVipUser.jsp?id=${item.userId }'" 
				src="${WEB }/images/icon-edit.gif">
		</display:column>
		<display:column media="html" title="孩童" style="text-align:center">
			<img border=0
				onclick="document.location='${WEB }/main.jsp?fo=manager&page=createVipChild&name=${item.username }'" 
				src="${WEB}/images/icon-create.gif" style="text-align:center">
		</display:column>
		<display:column media="html" title="刪除" style="text-align:center">
			<img border=0
				onclick="document.location='${WEB }/manager/manageVipAction.do?type=delete&idx=${item.userId}'" 
				src="${WEB}/images/icon-create.gif" style="text-align:center">
		</display:column>
	</display:table>
</div>	
	
	<logic:present name="vipAccounts">
	
	</logic:present>

</body>
</html>