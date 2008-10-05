<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@ page import="com.shenming.sms.dc.manager.*,
	com.shenming.sms.struts.form.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- Accept parameters: name as username of SmTbVipAccount -->
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ page import="com.shenming.sms.struts.form.*,com.shenming.sms.util.*,java.util.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Create VIP Child</title>
<script language="JavaScript1.3" src="<c:out value="${WEB}"/>/js/datetimepicker.js"></script>
<%
VipChildForm form = (VipChildForm)request.getAttribute("vipChildForm"); 
String dt[] = null;
String year = null;
String month = null;
String day = null;
String childSex = null;

if(form != null){
	/* Pattern: day-month-year ==> dd-MM-yyyy */
	if(form.getVipChildBirthday()!=null){
	dt = form.getVipChildBirthday().split("-");
	//System.out.println("1-------->"+dt[0]+","+dt[1]+","+dt[2]);
	day = dt[0];
	month = dt[1];
	year = new Integer(Integer.parseInt(dt[2].split(" ")[0]) - 1911).toString();
	childSex = form.getVipChildSex();
	//System.out.println("-------->" + childSex);
	//System.out.println("2-------->" + form.getVipChildBirthday());
	//System.out.println("3-------->" + year + "-" + month + "-" + day);
	}
	
	//out.println(form.g);
}
%>
<script language="JavaScript">
function compileBirthday(){
	vipChildForm.vipChildBirthday.value = 
		vipChildForm.day.value + "-" +
		vipChildForm.month.value + "-" +
		(parseInt(vipChildForm.year.value) + 1911);
	/*alert("---->"+vipChildForm.vipChildBirthday.value);*/
	return true;
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

</script>
</head>
<body>

<jsp:include page="${web}/common/page-title.jsp?title=建立VIP孩童資料"/>


<%
	String username = request.getParameter("name");
	if(username == null || "".equalsIgnoreCase(username))
		username = (request.getAttribute("username")!=null?(String)request.getAttribute("username"):"");
%>

<html:form action="/manager/manageVipChildAction" 
	focus="username" onsubmit="return compileBirthday();">
	<table align="center" style="width:550pt">
		<html:hidden property="formType"/>
		<tr><html:hidden property="idx"/>
			<th align="right">VIP姓名:</th>
			<td>
				<html:text property="username" size="10" value="<%=request.getParameter("name") %>"/>
			</td>
			<th align="right">孩童姓名:</th>
			<td>
				<html:text property="vipChildName" size="15"/>
			</td>
			<th align="right">孩童生日:</th>
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
				
				<html:hidden property="vipChildBirthday"/>
				</td>
				<td>
				<!-- 
				<img src="<c:out value="${WEB }"/>/images/icon-calendar.gif" width="28" 
					onclick="javascript:NewCal('vipChildBirthday','ddmmyyyy',true,24)"/> -->
				</td>
				</tr></table>
			</td>
			<th align="right">孩童性別:</th>
			<td>
				<html:select property="vipChildSex"> 
					<html:option value="M">男生</html:option>
					<html:option value="F">女生</html:option>
				</html:select>
			</td>
			<td>
			<c:choose>
				<c:when test="${vipChildForm.formType == 'update'}">
					<html:submit value="修改"/>
				</c:when>
				<c:otherwise>
					<html:submit value="新增"/>
				</c:otherwise>
			</c:choose>
			</td>
		</tr>
	</table>
</html:form>

<% 
SmsVipManager.initialize();
java.util.List childList = SmsVipManager.retrieveChildByUserName(username);
request.setAttribute("childList", childList);
%>

<table width="500" border="1" align="center"
		style="border: thin inset black; border-collapse: collapse"
		cellpadding="3" cellspacing="0">
	<tr>
		<th align="center">序號</th>
		<th align="center">孩童姓名</th>
		<th align="center">孩童生日</th>
		<th align="center">孩童性別</th>
		<th align="center">修改</th>
		<th align="center">刪除</th>
	</tr>
<c:forEach items="<%= childList %>" var="child">
<%-- nitrox:varType="com.shenming.sms.module.hibernateOrm.SmTbVipAccountDetail" --%>
		<tr onmouseover="this.style.background='#CCCCCC'" onmouseout="this.style.background=''">
			<td align="center"><c:out value="${child.idx}"/></td>
			<td align="center"><c:out value="${child.vipChildName}"/></td>
			<td align="center"><c:out value="${child.vipChildBirthday}"/></td>
			<td align="center">
				<c:if test="${child.vipChildSex == 'M'}">男生</c:if>
				<c:if test="${child.vipChildSex == 'F'}">女生</c:if>
			</td>
			<td align="center">
				<input type="image" border=0 alt="修改本筆孩童資料"
					onclick="document.location='<c:out value="${WEB}"/>/manager/updateVipChild.jsp?name=<%=username %>&idx=<bean:write name="child" property="idx"/>'" 
					src="<c:out value="${WEB}"/>/images/icon-edit.gif">
			</td>
			<td align="center">
				<input type="image" border=0 alt="刪除本筆孩童資料"
					onclick="document.location='<c:out value="${WEB}"/>/manager/updateVipChild.jsp?type=<%=VipAccountForm.DELETE %>&name=<%=username %>&idx=<bean:write name="child" property="idx"/>'" 
					src="<c:out value="${WEB}"/>/images/icon-trash-can.gif">
			</td>
		</tr>
</c:forEach>
</table>

<p align="center">
	<input type="image" alt="新增下一位VIP" src="<c:out value="${WEB}"/>/images/icon-create-vip.gif"
		onclick="document.location='<c:out value="${WEB}"/>/main.jsp?fo=manager&page=createVipUser'"/>
	<input type="image" alt="新增下一位孩童資訊" src="<c:out value="${WEB}"/>/images/icon-create-child.gif"
		onclick="document.location='<c:out value="${WEB}"/>/main.jsp?fo=manager&page=createVipChild&name=<%=username %>'" />
</p>
</body>
</html>