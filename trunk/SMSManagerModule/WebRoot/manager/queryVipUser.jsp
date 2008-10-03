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
<title>�|����Ƭd��</title>

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

<jsp:include page="${web}/common/page-title.jsp?title=�|����Ƭd��"/>

<p align="center">
	<html:form action="/manager/queryVipAction" focus="birthday">
		<table align="center" style="width:400pt">
			<tr><td colspan="4" align="left" style="font-weight: bold;height:15pt;vertical-align: middle;">�ϥ�VIP��Ƭd��:</td></tr>
			<tr>
				<td align="right">����W��:</td>
				<td>
					<html:text property="vipChtName"/>
				</td>
				<td align="right">�|��ID:</td>
				<td>
					<html:text property="userId"/>
				</td>
			</tr>
			<tr>
				<td align="right">���W:</td>
				<td>
					<html:select property="owner">
						<html:option value="-1">����</html:option>
						<html:optionsCollection property="ownerMap" value="value" label="key"/>
					</html:select>
				</td>
				<td align="right">VIP�����Ҹ�:</td>
				<td>
					<html:text property="sid"/>
				</td>
			</tr>
			<tr>
				<td align="right">�U�ȵ���:</td>
				<td>
					<html:select property="vipLevel">
						<html:option value="">����</html:option>
						<html:option value="A">A�ūȤ�</html:option>
						<html:option value="B">B�ūȤ�</html:option>
						<html:option value="C">C�ūȤ�</html:option>
						<html:option value="D">D�ūȤ�</html:option>
					</html:select>
				</td>
				<td align="right">�O�_������VIP:</td>
				<td>
					<html:select property="isValidVip">
						<html:option value="">����</html:option>
						<html:option value="Y">VIP�Τ�</html:option>
						<html:option value="N">�DVIP�Τ�</html:option>
					</html:select>
				</td>
			</tr>
			
			<tr>
				
				<td align="right">VIP�ͤ���:</td>
				<td>
					<html:select property="birthday">
						<html:option value="">����</html:option>
						<html:option value="1">�@��</html:option>
						<html:option value="2">�G��</html:option>
						<html:option value="3">�T��</html:option>
						<html:option value="4">�|��</html:option>
						<html:option value="5">����</html:option>
						<html:option value="6">����</html:option>
						<html:option value="7">�C��</html:option>
						<html:option value="8">�K��</html:option>
						<html:option value="9">�E��</html:option>
						<html:option value="10">�Q��</html:option>
						<html:option value="11">�Q�@��</html:option>
						<html:option value="12">�Q�G��</html:option>
					</html:select>
				</td>
			</tr>
			<tr><td colspan="4" align="left" style="font-weight: bold;height:15pt;vertical-align: middle;">�ϥΫĵ���Ƭd��:</td></tr>
			<tr>
				
				<td align="right">�ĵ��ʧO:</td>
				<td>
					<html:select property="childSex">
						<html:option value="">����</html:option>
						<html:option value="M">�k</html:option>
						<html:option value="F">�k</html:option>
					</html:select>
				</td>
				<td align="right">�ĵ��ͤ���:</td>
				<td>
					<html:select property="childBirthday">
						<html:option value="">����</html:option>
						<html:option value="1">�@��</html:option>
						<html:option value="2">�G��</html:option>
						<html:option value="3">�T��</html:option>
						<html:option value="4">�|��</html:option>
						<html:option value="5">����</html:option>
						<html:option value="6">����</html:option>
						<html:option value="7">�C��</html:option>
						<html:option value="8">�K��</html:option>
						<html:option value="9">�E��</html:option>
						<html:option value="10">�Q��</html:option>
						<html:option value="11">�Q�@��</html:option>
						<html:option value="12">�Q�G��</html:option>
					</html:select>
				</td>
			</tr>
			<tr>
				<td colspan="4" style="text-align:center">
					<html:submit value="�d��VIP"/>
					<input type=button value="�����C�X" 
						onclick="document.location='/sms/manager/queryVipAction.do?qt=all'"/>
				</td>
			</tr>
			
		</table>
		
	</html:form>
	<br/>
	<div style="color: red;text-align: center;">PS:VIP�ͤ����P�ĵ��ͤ������@���ߡA�h�|�Q�t�Ψ��X�C</div>
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
	    <display:column media="html" title="�b���W��" sortable="true" style="text-align:center;">
			<a href="renderShowEmpDetail.jsp?idx=${empItem.empId}"><c:out value="${empItem.empId}"/></a>
			<a href="${WEB }/main.jsp?fo=manager&page=renderUserById&act=show&idx=${item.userId}">
				${item.userId}
			</a>
		</display:column>
		<display:column media="csv excel xml rtf pdf" title="�b���W��" sortable="true" style="text-align:center;">
				${item.userId}
		</display:column>
		<display:column property="vipChtName" title="����W��" style="text-align:center;"/>
		<display:column title="�ͤ�" sortable="true" >
			<fmt:formatDate value="${item.birthday}" type="date" dateStyle="short"/>	
		</display:column>
		<display:column title="���O���B�֭p" style="text-align:center;">
			NT$<c:out value="${item.buySum}"/>
		</display:column>
		<display:column title="�|��" style="text-align:center;">
			<c:out value="${item.isValidVip == 'Y'? '�|��':'�D�|��'}"/>
		</display:column>
		<display:column title="�ʧO" style="text-align:center;">
			<c:out value="${item.sex == 'M'? '�k':'�k'}"/>
		</display:column>
		<display:column property="phone" title="�q��"/>
		<display:column property="mobile" title="��ʹq��"/>
		<display:column title="����" sortable="true">
			${item.smTbVipAccount.vipChtName}
		</display:column>
		<display:column media="html" title="�H�c">
			<a href=mailto:${item.mailAddr }>
				<c:if test="${item.mailAddr !=null && item.mailAddr != ''}">
					<img border=0 src="${WEB }/images/icon-mail.gif">
				</c:if>
			</a>
		</display:column>
		<display:column media="html" title="�a�}">
			${item.smTbVipAccount.address}
		</display:column>
		<display:column media="csv excel xml rtf pdf" title="�H�c">
			${item.mailAddr}
		</display:column>
		<display:column media="csv excel xml rtf pdf" title="�a�}">${item.address}</display:column>
		<display:column media="html" title="����" >
			<img border=0 
				onclick="window.open('<c:out value="${WEB}"/>/manager/renderUserById.jsp?idx=${item.userId}&act=tag')" 
				src="${WEB}/images/icon-tag.gif">
		</display:column>
		<display:column media="html" title="�ק�" >
			<img border=0 
				onclick="document.location='${WEB }/manager/updateVipUser.jsp?id=${item.userId }'" 
				src="${WEB }/images/icon-edit.gif">
		</display:column>
		<display:column media="html" title="�ĵ�" style="text-align:center">
			<img border=0
				onclick="document.location='${WEB }/main.jsp?fo=manager&page=createVipChild&name=${item.username }'" 
				src="${WEB}/images/icon-create.gif" style="text-align:center">
		</display:column>
		<display:column media="html" title="�R��" style="text-align:center">
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