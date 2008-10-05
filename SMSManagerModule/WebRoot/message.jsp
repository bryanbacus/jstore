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
			<th>錯誤訊息名稱</th>
			<th>錯誤原因</th>
			<th>訊息</th>
			<th>時間</th>
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
				<th align="right" width="100">會員序號:</th>
				<td>
					<html:text property="userId" readonly="${vipAccountForm.formType == 'update'?'true':'false'}"/>
				<font color="red">* (請填寫大於零的數字型態)</font></td>
			</tr>
			<tr>
				<th align="right">帳號:</th>
				<td>
					<html:text property="username"/>
					<font color="red">* (請填寫VIP帳號名稱，EX: simon)</font>	</td>
			</tr>
			<tr>
				<th align="right">密碼:</th>
				<td>
					<html:password property="password" value="123456"/>
					<font color="red">* (請填寫VIP密碼，預設為123456)</font>
				</td>
			</tr>
			<tr>
				<th align="right">中文姓名:</th>
				<td>
					<html:text property="vipChtName"/>
					<font color="red">* (請填寫VIP中文名稱，EX:林小明)</font>
					<input type="button" value="檢查重複" 
						onclick="window.open('/sms/manager/manageVipAction.do?type=checkVipChtName&id=' + document.vipAccountForm.vipChtName.value)">
				</td>
			</tr>
			<tr>
				<th align="right">英文姓名:</th>
				<td>
					<html:text property="vipEngName"/>
					<input type="button" value="檢查重複" 
						onclick="window.open('/sms/manager/manageVipAction.do?type=checkVipEngName&id=' + document.vipAccountForm.vipEngName.value)">
				</td>
			</tr>
			<tr>
				<th align="right">身分證號:</th>
				<td>
					<html:text property="sid"/>
					<font color="red">* (請填寫VIP之身分證號)</font>
					<input type="button" value="檢查重複" 
						onclick="window.open('/sms/manager/manageVipAction.do?type=checkSid&id=' + document.vipAccountForm.sid.value)">
				</td>
			</tr>
			<tr>
				<th align="right">地址:</th>
				<td>
					<table style="width:230pt">
						<tr>
							<td valign="middle">
								<html:text property="address" size="50"/></td>
							<td valign="middle">
								<img 
									src="<c:out value="${WEB }"/>/images/icon-address.gif" 
									width="20" alt="(點選我來選取縣市與區域)"
									onclick="window.open('<c:out value="${WEB }"/>/utils/zipcode.jsp','地址選擇','toolbar=no,scrollbars=no,directories=no,alwaysRaised=yes,titlebar=no,width=500,height=300,status=no');"/>
							</td>
							<td>
								<input type="button" value="檢查重複" 
									onclick="window.open('/sms/manager/manageVipAction.do?type=checkAddress&id=' + document.vipAccountForm.address.value)">
							</td>
						</tr>
					</table>
					</td>
			</tr>
			<tr>
				<th align="right">生日:</th>
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
					<td>(範例: 2007年6月10號 23點46分 = 10-06-2007 23:46:34)</td>
					</tr></table>
					-->
				</td>
			</tr>
			<!-- 
			<tr>
				<th align="right">血型:</th>
				<td>
					<html:select property="blood">
						<html:option value="A">A型</html:option>
						<html:option value="B">B型</html:option>
						<html:option value="AB">AB型</html:option>
						<html:option value="O">O型</html:option>
					</html:select>
				</td>
			</tr>
			<tr>
				<th align="right" valign="top">嗜好:</th>
				<td>
					<html:textarea property="fovarite" cols="50" rows="2"/>
				</td>
			</tr>
			 -->
			<tr>
				<th align="right">職業:</th>
				<td>
					<html:text property="job"/>
				</td>
			</tr>
			<tr>
				<th align="right">電子郵件:</th>
				<td>
					<html:text property="mailAddr" size="30"/>
					<input type="button" value="檢查重複" 
						onclick="window.open('/sms/manager/manageVipAction.do?type=checkMailAddr&id=' + document.vipAccountForm.mailAddr.value)">
				</td>
			</tr>
			<!-- 
			<tr>
				<th align="right">結婚:</th>
				<td>
					<html:select property="marrage">
						<html:option value="Y">已婚</html:option>
						<html:option value="N">未婚</html:option>
					</html:select>
				</td>
			</tr>
			 -->
			<tr>
				<th align="right">電話:</th>
				<td>
					<html:text property="phone"/>
				</td>
			</tr>
			<tr>
				<th align="right">行動電話:</th>
				<td>
					<html:text property="mobile"/>
				</td>
			</tr>
			<tr>
				<th align="right">性別:</th>
				<td>
					<html:select property="sex">
						<html:option value="M">男性</html:option>
						<html:option value="F">女性</html:option>
					</html:select>
				</td>
			</tr>
			<tr>
				<th align="right">購買總金額:</th>
				<td>
					<html:text property="buySum"/>
				</td>
			</tr>
			<tr>
				<th align="right">帳號狀態:</th>
				<td>
					<html:select property="isAccountActive">
						<html:option value="Y">可用</html:option>
						<html:option value="N">停用</html:option>
					</html:select>
				</td>
			</tr>
			<tr>
				<th align="right">VIP狀態:</th>
				<td>
					<html:select property="isValidVip">
						<html:option value="N">非VIP用戶</html:option>
						<html:option value="Y">VIP用戶</html:option>
					</html:select>
				</td>
			</tr>
			<tr>
				<th align="right">錯誤次數:</th>
				<td>
					0<html:hidden property="errorCnt"/>
				</td>
			</tr>
			<tr>
				<th align="right">建立日期:</th>
				<td>
					<%=com.shenming.sms.util.DateUtil.convertDateToString(new java.util.Date(), "yyyy-MM-dd HH:mm:ss") %>
					<html:hidden property="crDate"/><font color="red">(yyyy-MM-dd HH:mm:ss)</font>
				</td>
			</tr>
			<tr>
				<th align="right">帳號隸屬(門市):</th>
				<td><html:select property="owner" onchange="vipAccountForm.store.value=this.value">
						<html:option value=""></html:option>
						<html:optionsCollection 
							property="vipMap" value="value" label="key"/>	
					</html:select>
					<font color="red">*</font>
					&nbsp;門市代號:<html:text property="store" style="border:none;" readonly="true"/>
				</td>
			</tr>
			<tr>
				<th align="right">帳號型別:</th>
				<td>
					<html:select property="accountType">
						<html:option value="VIP">會員</html:option>
						<html:option value="MANAGER">管理者</html:option>
						<html:option value="ADMIN">系統管理者</html:option>
					</html:select>
					<font color="red">*</font>
				</td>
			</tr>
			
			<tr>
				<th align="right">專櫃人員:</th>
				<td>
					<html:text property="storeEmployeeName"/>
				</td>
			</tr>
			<tr>
				<th align="right">客戶等級:</th>
				<td>
					<html:select property="vipLevel" >
						<html:option value="C">C</html:option>
						<html:option value="B">B</html:option>
						<html:option value="A">A</html:option>
					</html:select>
				</td>
			</tr>
			<tr>
				<th align="right">建檔說明:</th>
				<td>
					<html:textarea property="description" cols="50" rows="2" />
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center" style="text-align:center;">
				<c:if test="${vipAccountForm.formType == 'create'}">
					<html:submit value="建立會員"/>
				</c:if>
				<c:if test="${vipAccountForm.formType == 'update'}">
					<html:submit value="修改會員"/>
				</c:if>
				</td>
			</tr>
		</table>
		<br/>
		<p align="center" style="color:red">(*註記者為必填欄位)</p>
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
		    <display:column media="html" title="帳號名稱" sortable="true" style="text-align:center;">
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
			<display:column media="html csv excel xml rtf pdf" title="地址">
				${item.address}
			</display:column>
			<display:column media="html" title="信箱">
				<a href=mailto:${item.mailAddr }>
					<c:if test="${item.mailAddr !=null && item.mailAddr != ''}">
						<img border=0 src="${WEB }/images/icon-mail.gif">
					</c:if>
				</a>
			</display:column>
			<display:column media="csv excel xml rtf pdf" title="信箱">
				${item.mailAddr}
			</display:column>
			<display:column media="html" title="MSG" style="color:red">
				${item.username == vipAccountForm.username ? "[username重複]":""}
				${item.mobile == vipAccountForm.mobile ? "[行動電話重複]":""}
				${item.userId == vipAccountForm.userId ? "[帳號重複]":""}
			</display:column>
	</display:table>
	</c:if>
	</c:if>
	
	<table style="width:100px">
	<tr>
		<td>
		<c:if test="${isShowClose}">
			<input type="button" value="關閉" onclick="window.close();"/>
		</c:if>
		<c:if test="${!isShowClose}">
			<input type="button" value="回上一頁" onclick="javasctipt:history.go(-1);"/>
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
			<html:submit value="嘗試建立"/>
		</html:form>	
		</td>
		</c:if>
	</tr>
	</table>
</div>
</body>
</html>