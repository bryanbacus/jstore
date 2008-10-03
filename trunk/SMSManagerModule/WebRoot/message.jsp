<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="/WEB-INF/tld/displaytag.tld" prefix="display" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<jsp:include page="inc/common.jsp"/>
<title>MESSAGE</title>
	</head>
<body>
<br/>
<div align="center" style="">
	<h2>MESSAGE</h2>
	<font color="red"><c:out value="${message}"/></font>
	<c:if test="${messageList != null}">
	<table style="border:1px;border-style: solid;">
		<tr style = "background-color: orange;">
			<th>���~�T���W��</th>
			<th>���~��]</th>
			<th>�T��</th>
			<th>�ɶ�</th>
		</tr>
		<c:forEach items="${messageList}" var="msgList">
			<%-- workshop:varType="com.shenming.sms.bean.Message" --%>
			<tr>
				<td><c:out value="${msgList.msgName}"/></td>
				<td><c:out value="${msgList.cause}"/></td>
				<td><c:out value="${msgList.message}"/></td>
				<td><c:out value="${msgList.time}"/></td>
			</tr>
		</c:forEach>
	</table>
	<br/>
	</c:if>
	
	<c:if test="${isShowDuplicateList}">
	<c:if test="${duplicateList != null && messageList ==null}">
	<display:table id="item" name="${sessionScope.duplicateList}" 
			style="border:1px;"
			pagesize="15" defaultorder="descending" sort="list" 
			cellpadding="1" cellspacing="1" export="true"> 
			<!-- Export Config -->
		    <display:setProperty name="export.rtf.filename" value="export.rtf"/>
		    <display:setProperty name="export.xml.filename" value="export.xml"/>
	 	    <display:setProperty name="export.pdf" value="true" />
			<display:column title="#" sortable="true">
		    	<c:out value="${item_rowNum}"/>
		    </display:column>
		    <display:column media="html" title="�b���W��" sortable="true" style="text-align:center;">
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
			<display:column media="html csv excel xml rtf pdf" title="�a�}">
				${item.address}
			</display:column>
			<display:column media="html" title="�H�c">
				<a href=mailto:${item.mailAddr }>
					<c:if test="${item.mailAddr !=null && item.mailAddr != ''}">
						<img border=0 src="${WEB }/images/icon-mail.gif">
					</c:if>
				</a>
			</display:column>
			<display:column media="csv excel xml rtf pdf" title="�H�c">
				${item.mailAddr}
			</display:column>
	</display:table>
	</c:if>
	</c:if>
	
	<table style="width:100px">
	<tr>
		<td>
		<c:if test="${isShowClose}">
			<input type="button" value="����" onclick="window.close();"/>
		</c:if>
		<c:if test="${!isShowClose}">
			<input type="button" value="�^�W�@��" onclick="javasctipt:history.go(-1);"/>
		</c:if>
		</td>
		<c:if test="${isShowTryCreate}">
		<td>
		<html:form action="/manager/manageVipAction">
			<input type="hidden" name="forceCreate" value="true"/>
			<html:hidden property="accountType"/>
			<html:hidden property="address"/>
			<html:hidden property="birthday"/>
			<html:hidden property="blood"/>
			<html:hidden property="buySum"/>
			<html:hidden property="crDate"/>
			<html:hidden property="description"/>
			<html:hidden property="errorCnt"/>
			<html:hidden property="formType" value="create"/>
			<html:hidden property="fovarite"/>
			<html:hidden property="isAccountActive"/>
			<html:hidden property="isValidVip"/>
			<html:hidden property="job"/>
			<html:hidden property="mailAddr"/>
			<html:hidden property="marrage"/>
			<html:hidden property="mobile"/>
			<html:hidden property="owner"/>
			<html:hidden property="password"/>
			<html:hidden property="phone"/>
			<html:hidden property="sex"/>
			<html:hidden property="sid"/>
			<html:hidden property="store"/>
			<html:hidden property="storeEmployeeName"/>
			<html:hidden property="userId"/>
			<html:hidden property="username"/>
			<html:hidden property="vipChtName"/>
			<html:hidden property="vipEngName"/>
			<html:hidden property="vipLevel"/>
			<html:submit value="���իإ�"/>
		</html:form>	
		</td>
		</c:if>
	</tr>
	</table>
</div>
</body>
</html>