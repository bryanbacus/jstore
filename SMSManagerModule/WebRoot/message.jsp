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
	
	<html:form action="/manager/manageVipAction" focus="userId"
		 onsubmit="compileBirthday();return checkForm();">
		 <input type="hidden" name="forceCreate" value="false"/>
		<span align="center">
		<table border="1" align="center" style="border-collapse: collapse; width: 500pt">
			<html:hidden property="formType"/>
			<tr>
				<th align="right" width="100">�|���Ǹ�:</th>
				<td>
					<html:text property="userId" readonly="${vipAccountForm.formType == 'update'?'true':'false'}"/>
				<font color="red">* (�ж�g�j��s���Ʀr���A)</font></td>
			</tr>
			<tr>
				<th align="right">�b��:</th>
				<td>
					<html:text property="username"/>
					<font color="red">* (�ж�gVIP�b���W�١AEX: simon)</font>	</td>
			</tr>
			<tr>
				<th align="right">�K�X:</th>
				<td>
					<html:password property="password" value="123456"/>
					<font color="red">* (�ж�gVIP�K�X�A�w�]��123456)</font>
				</td>
			</tr>
			<tr>
				<th align="right">����m�W:</th>
				<td>
					<html:text property="vipChtName"/>
					<font color="red">* (�ж�gVIP����W�١AEX:�L�p��)</font>
					<input type="button" value="�ˬd����" 
						onclick="window.open('/sms/manager/manageVipAction.do?type=checkVipChtName&id=' + document.vipAccountForm.vipChtName.value)">
				</td>
			</tr>
			<tr>
				<th align="right">�^��m�W:</th>
				<td>
					<html:text property="vipEngName"/>
					<input type="button" value="�ˬd����" 
						onclick="window.open('/sms/manager/manageVipAction.do?type=checkVipEngName&id=' + document.vipAccountForm.vipEngName.value)">
				</td>
			</tr>
			<tr>
				<th align="right">�����Ҹ�:</th>
				<td>
					<html:text property="sid"/>
					<font color="red">* (�ж�gVIP�������Ҹ�)</font>
					<input type="button" value="�ˬd����" 
						onclick="window.open('/sms/manager/manageVipAction.do?type=checkSid&id=' + document.vipAccountForm.sid.value)">
				</td>
			</tr>
			<tr>
				<th align="right">�a�}:</th>
				<td>
					<table style="width:230pt">
						<tr>
							<td valign="middle">
								<html:text property="address" size="50"/></td>
							<td valign="middle">
								<img 
									src="<c:out value="${WEB }"/>/images/icon-address.gif" 
									width="20" alt="(�I��ڨӿ�������P�ϰ�)"
									onclick="window.open('<c:out value="${WEB }"/>/utils/zipcode.jsp','�a�}���','toolbar=no,scrollbars=no,directories=no,alwaysRaised=yes,titlebar=no,width=500,height=300,status=no');"/>
							</td>
							<td>
								<input type="button" value="�ˬd����" 
									onclick="window.open('/sms/manager/manageVipAction.do?type=checkAddress&id=' + document.vipAccountForm.address.value)">
							</td>
						</tr>
					</table>
					</td>
			</tr>
			<tr>
				<th align="right">�ͤ�:</th>
				<td>
					<table><tr><td>
					<select id="year">
						<script language="Javascript">
						getYear();
						</script>
					</select>
					<select id="month">
						<script language="Javascript">
						getMonth();
						</script>
					</select>
					<select id="day">
						<script language="Javascript">
						getDay();
						</script>
					</select>
					
					<html:hidden property="birthday"/>
					</td>
					<td>
					<!-- 
					<img src="<c:out value="${WEB }"/>/images/icon-calendar.gif" width="28" 
						onclick="javascript:NewCal('vipChildBirthday','ddmmyyyy',true,24)"/> -->
					</td>
					</tr></table>
					<!-- 
					<table style="width:330pt"><tr>
					<td><html:text property="birthday" size="30"/></td>
					<td><img src="<c:out value="${WEB }"/>/images/icon-calendar.gif" width="28" 
						onclick="javascript:NewCal('birthday','ddmmyyyy',true,24)"/></td>
					<td>(�d��: 2007�~6��10�� 23�I46�� = 10-06-2007 23:46:34)</td>
					</tr></table>
					-->
				</td>
			</tr>
			<!-- 
			<tr>
				<th align="right">�嫬:</th>
				<td>
					<html:select property="blood">
						<html:option value="A">A��</html:option>
						<html:option value="B">B��</html:option>
						<html:option value="AB">AB��</html:option>
						<html:option value="O">O��</html:option>
					</html:select>
				</td>
			</tr>
			<tr>
				<th align="right" valign="top">�ݦn:</th>
				<td>
					<html:textarea property="fovarite" cols="50" rows="2"/>
				</td>
			</tr>
			 -->
			<tr>
				<th align="right">¾�~:</th>
				<td>
					<html:text property="job"/>
				</td>
			</tr>
			<tr>
				<th align="right">�q�l�l��:</th>
				<td>
					<html:text property="mailAddr" size="30"/>
					<input type="button" value="�ˬd����" 
						onclick="window.open('/sms/manager/manageVipAction.do?type=checkMailAddr&id=' + document.vipAccountForm.mailAddr.value)">
				</td>
			</tr>
			<!-- 
			<tr>
				<th align="right">���B:</th>
				<td>
					<html:select property="marrage">
						<html:option value="Y">�w�B</html:option>
						<html:option value="N">���B</html:option>
					</html:select>
				</td>
			</tr>
			 -->
			<tr>
				<th align="right">�q��:</th>
				<td>
					<html:text property="phone"/>
				</td>
			</tr>
			<tr>
				<th align="right">��ʹq��:</th>
				<td>
					<html:text property="mobile"/>
				</td>
			</tr>
			<tr>
				<th align="right">�ʧO:</th>
				<td>
					<html:select property="sex">
						<html:option value="M">�k��</html:option>
						<html:option value="F">�k��</html:option>
					</html:select>
				</td>
			</tr>
			<tr>
				<th align="right">�ʶR�`���B:</th>
				<td>
					<html:text property="buySum"/>
				</td>
			</tr>
			<tr>
				<th align="right">�b�����A:</th>
				<td>
					<html:select property="isAccountActive">
						<html:option value="Y">�i��</html:option>
						<html:option value="N">����</html:option>
					</html:select>
				</td>
			</tr>
			<tr>
				<th align="right">VIP���A:</th>
				<td>
					<html:select property="isValidVip">
						<html:option value="N">�DVIP�Τ�</html:option>
						<html:option value="Y">VIP�Τ�</html:option>
					</html:select>
				</td>
			</tr>
			<tr>
				<th align="right">���~����:</th>
				<td>
					0<html:hidden property="errorCnt"/>
				</td>
			</tr>
			<tr>
				<th align="right">�إߤ��:</th>
				<td>
					<%=com.shenming.sms.util.DateUtil.convertDateToString(new java.util.Date(), "yyyy-MM-dd HH:mm:ss") %>
					<html:hidden property="crDate"/><font color="red">(yyyy-MM-dd HH:mm:ss)</font>
				</td>
			</tr>
			<tr>
				<th align="right">�b������(����):</th>
				<td><html:select property="owner" onchange="vipAccountForm.store.value=this.value">
						<html:option value=""></html:option>
						<html:optionsCollection 
							property="vipMap" value="value" label="key"/>	
					</html:select>
					<font color="red">*</font>
					&nbsp;�����N��:<html:text property="store" style="border:none;" readonly="true"/>
				</td>
			</tr>
			<tr>
				<th align="right">�b�����O:</th>
				<td>
					<html:select property="accountType">
						<html:option value="VIP">�|��</html:option>
						<html:option value="MANAGER">�޲z��</html:option>
						<html:option value="ADMIN">�t�κ޲z��</html:option>
					</html:select>
					<font color="red">*</font>
				</td>
			</tr>
			
			<tr>
				<th align="right">�M�d�H��:</th>
				<td>
					<html:text property="storeEmployeeName"/>
				</td>
			</tr>
			<tr>
				<th align="right">�Ȥᵥ��:</th>
				<td>
					<html:select property="vipLevel" >
						<html:option value="C">C</html:option>
						<html:option value="B">B</html:option>
						<html:option value="A">A</html:option>
					</html:select>
				</td>
			</tr>
			<tr>
				<th align="right">���ɻ���:</th>
				<td>
					<html:textarea property="description" cols="50" rows="2" />
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center" style="text-align:center;">
				<c:if test="${vipAccountForm.formType == 'create'}">
					<html:submit value="�إ߷|��"/>
				</c:if>
				<c:if test="${vipAccountForm.formType == 'update'}">
					<html:submit value="�ק�|��"/>
				</c:if>
				</td>
			</tr>
		</table>
		<br/>
		<p align="center" style="color:red">(*���O�̬��������)</p>
		</span> 
	</html:form>
	
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
			<display:column media="html" title="MSG" style="color:red">
				${item.username == vipAccountForm.username ? "[username����]":""}
				${item.mobile == vipAccountForm.mobile ? "[��ʹq�ܭ���]":""}
				${item.userId == vipAccountForm.userId ? "[�b������]":""}
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