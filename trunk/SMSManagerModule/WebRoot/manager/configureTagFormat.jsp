<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Insert title here</title>
<script type="text/javascript">
function go(act){
<!--alert("tagForm got width="+ tagForm.width.value);-->
var addr = act + "?width=" + tagForm.width.value + 
	"&height=" + tagForm.height.value + 
	"&interval=" + tagForm.interval.value + 
	"&top=" + tagForm.top.value + 
	"&left=" + tagForm.left.value + 
	"&border=" + tagForm.border.value + 
	"&startIdx=" + tagForm.startIdx.value + 
	"&endIdx=" + tagForm.endIdx.value ;


window.open("/sms/manager/"+addr);
}
</script>
</head>
<body>

<jsp:include page="${web}/common/page-title.jsp?title=�|�����ҦC��"/>

<form id="tagForm">
	<!-- manager/renderAllVipTag.jsp?top=5&interval=50&left=0.5&width=8.8&height=3&border=show -->
	<table align="center" cellpadding="5" cellspacing="5"
		style="width: 230pt; border:thin; border-collapse: collapse;" >
		<tr>
			<th>�|����ư϶��G</th>
			<td><input id="startIdx" type="text" value="0" size="8"/> to <input id="endIdx" type="text" value="0" size="8"/></td>
		</tr>
		<tr>
			<th>�K�ȼe��(cm)�G</th>
			<td><input id="width" type="text" value="8.8"/> </td>
		</tr>
		<tr>
			<th>�K�Ȱ���(cm)�G</th>
			<td><input id="height" type="text" value="3.6"/> </td>
		</tr>
		<tr>
			<th>�����䶡�Z(cm)�G</th>
			<td><input id="left" type="text" value="0"/> </td>
		</tr>
		<tr>
			<th>���W�趡�Z(cm)�G</th>
			<td><input id="top" type="text" value="0"/> </td>
		</tr>
		<tr>
			<th>�O�_�C�L�K����ءG</th>
			<td>
				<select id="border">
					<option selected="selected" value="true">�C�L</option>
					<option value="false">���C�L</option>
				</select> 
			</td>
		</tr>
		<tr>
			<th>�K�ȶ��Z(cm)�G</th>
			<td><input id="interval" type="text" value="3"/> </td>
		</tr>
		<tr>
			<td colspan="2" style="text-align: center">
				<input type="button" value="���ҦC��" onclick="go('renderAllVipTag.jsp');"> 
				<input type="button" value="CSV�C��" onclick="go('renderAllVipCsv.jsp');"> 
			</td>
		</tr>
	</table>
</form>	
<hr/>
<div style="text-align: center;">
	<p style="text-align: center;font-size: large;font-weight: bold;">�]�w����</p>
	<img src="images/tag-intro.jpg"/>
</div>
</body>
</html>