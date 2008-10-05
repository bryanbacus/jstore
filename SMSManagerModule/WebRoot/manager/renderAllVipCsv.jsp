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
%>郵遞區號,地址,姓名,VIP代號
<%
	for(SmTbVipAccount vip:allVip){
		String addr = "";
		String subStr = "";
		try{
			addr = vip!=null?(((SmTbVipAccount)vip).getAddress()):null;
			subStr = addr!=null?(addr.length()>3?addr.substring(0,3):""):"";
			if(subStr != null && !"".equalsIgnoreCase(subStr)){
				new Integer(subStr);
				out.print(subStr + ","); //郵遞區號
				out.print((addr!=null?
						(addr.length()>3?addr.substring(3):"" + ","):"") + ","); //地址
				out.print(((SmTbVipAccount)vip).getVipChtName() + ","); //
				out.println(((SmTbVipAccount)vip).getUserId() + "");
			}
		} catch(Exception e){
			out.print("帳號:"+((SmTbVipAccount)vip).getUsername()+"]地址格式錯誤，請檢查郵遞區號,,");
		}
	}
} else {
	request.setAttribute("message", "列舉VIP錯誤，請確認系統中已經有VIP帳號!");
%>
<jsp:forward page="/main.jsp?page=message"/>
<%
}
%>
