<%@ page language="java" contentType="text/html; charset=BIG5" pageEncoding="BIG5"%>
<%@ page import="com.shenming.sms.module.hibernateOrm.*,com.shenming.sms.dc.manager.*,com.shenming.sms.struts.form.VipAccountForm,java.util.*" %>
<%
response.setHeader("Content-type", "application/vnd.ms-excel");
response.setHeader("Content-disposition", "attachment; filename=vips.csv");
double top = new Double(request.getParameter("top")!=null?request.getParameter("top"):"0").doubleValue();
double interval = new Double(request.getParameter("interval")!=null?request.getParameter("interval"):"0").doubleValue();
double left = new Double(request.getParameter("left")!=null?request.getParameter("left"):"0").doubleValue();
double right = new Double(request.getParameter("right")!=null?request.getParameter("right"):"0").doubleValue();
double width = new Double(request.getParameter("width")!=null?request.getParameter("width"):"8.8").doubleValue();
double height = new Double(request.getParameter("height")!=null?request.getParameter("height"):"3.6").doubleValue();
Integer startIdx = new Integer(request.getParameter("startIdx")!=null?request.getParameter("startIdx"):"0");
Integer endIdx = new Integer(request.getParameter("endIdx")!=null?request.getParameter("endIdx"):"0");
String border = "true".equalsIgnoreCase(request.getParameter("border"))?"border: thin inset black;":"";
List<SmTbVipAccount> allVip = 
	(endIdx.intValue() - startIdx.intValue() < 0)?
			SmsVipManager.retrieveAllUser():SmsVipManager.retrieveUserBetween(startIdx, endIdx, "userId", false);
if(allVip != null){
%>�l���ϸ�,�a�},�m�W,VIP�N��
<%
	for(SmTbVipAccount vip:allVip){
		String addr = "";
		String subStr = "";
		try{
			addr = vip!=null?(((SmTbVipAccount)vip).getAddress()):null;
			subStr = addr!=null?(addr.length()>3?addr.substring(0,3):""):"";
			if(subStr != null && !"".equalsIgnoreCase(subStr)){
				new Integer(subStr);
				out.print(subStr + ","); //�l���ϸ�
				out.print((addr!=null?
						(addr.length()>3?addr.substring(3):"" + ","):"") + ","); //�a�}
				out.print(((SmTbVipAccount)vip).getVipChtName() + ","); //
				out.println(((SmTbVipAccount)vip).getUserId() + "");
			}
		} catch(Exception e){
			out.print("�b��:"+((SmTbVipAccount)vip).getUsername()+"]�a�}�榡���~�A���ˬd�l���ϸ�,,");
		}
	}
} else {
	request.setAttribute("message", "�C�|VIP���~�A�нT�{�t�Τ��w�g��VIP�b��!");
%>
<jsp:forward page="/main.jsp?page=message"/>
<%
}
%>
