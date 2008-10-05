<%@ page contentType="text/html; charset=big5" %>
<%@ page language="java"%>
<%@ page import="com.shenming.sms.dc.manager.SmsVipManager"%>

<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>


<%@ page import="com.shenming.sms.struts.form.*,
	com.shenming.sms.util.*,
	java.util.*,
	com.shenming.sms.util.*" %>

<html>
<head>
<title>會員資料建檔</title>
<script language="JavaScript1.3" src="<c:out value="${WEB}"/>/js/datetimepicker.js"></script>
<%
VipAccountForm form = (VipAccountForm)request.getAttribute("vipAccountForm"); 
String dt[] = null;
String year = null;
String month = null;
String day = null;

if(form != null){
	/* Pattern: day-month-year ==> dd-MM-yyyy */
	if(form.getBirthday() != null && !"".equalsIgnoreCase(form.getBirthday())){
		dt = form.getBirthday().split("-");
	
		System.out.println("1-------->"+dt[0]+","+dt[1]+","+dt[2]);
	
		day = dt[2].split(" ")[0];
		month = dt[1];
		year = new Integer(Integer.parseInt(dt[0]) - 1911).toString();
	
		//System.out.println("-------->" + childSex);
		System.out.println("2-------->" + form.getBirthday());
		System.out.println("3-------->" + year + "-" + month + "-" + day);
	}
} 
%>
<script language="JavaScript">
function compileBirthday(){
	<!-- convert to dd-MM-yyyy HH:mm:ss -->
	document.vipAccountForm.birthday.value = 
		document.vipAccountForm.day.value + "-" +
		document.vipAccountForm.month.value + "-" +
		(parseInt(document.vipAccountForm.year.value) + 1911) + " 00:00:00.0";
	if(document.vipAccountForm.day.value > 0 &&
		document.vipAccountForm.month.value > 0 &&
		document.vipAccountForm.year.value > 0){
		return true;
	} else {
		return false;
	}
}

function getSelectItem(start, end, selectedValue, type){
	for(var i=start;i<=end;i++){
		if(i != selectedValue)
			document.write("<option value=\"" + i + "\">" + i + " " + type + "</option>");
		else
			document.write("<option value=\"" + i + "\" selected>" + i + " " + type + "</option>");
	}
}

function getYear(){
	getSelectItem(00, 99, <%=year!=null?year:"70"%>, '年次');
}

function getMonth(){
	getSelectItem(01, 12, <%=month!=null?month:"1"%>, '月');
}

function getDay(){
	getSelectItem(01, 31, <%=day!=null?day:"1"%>, '日');
}

function checkForm(){
	var isError = 0; //0:true; 1:false
	var msg = '錯誤：';

	if(checkEmpty(document.vipAccountForm.userId.value)){
		msg += ' 會員序號不可為空 ';
		isError = 1;
	}
	if(checkEmpty(document.vipAccountForm.username.value)){
		msg += ' 帳號不可為空 ';
		isError = 1;
	}
	/*
	if(checkEmpty(document.vipAccountForm.mailAddr.value)){
		msg += ' 電子郵件不可為空 ';
		isError = 1;
	}
	*/
	
	if(isError == 1){
		alert(msg);
		return false;
	}

	return true;
}

function checkEmpty(v){
	if(v == null || v == '')
		return true;
	return false;
}

</script>

</head>
<body>
<jsp:include page="${web}/common/page-title.jsp?title=會員資料建檔"/>
<!-- 
<input type="button" value="TEST" onclick="return compileBirthday();">
 -->
<html:form action="/manager/manageVipAction" focus="userId"
	 onsubmit="compileBirthday();return checkForm();">
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
</body>
</html>