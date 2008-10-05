<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@ page import="javax.servlet.http.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Insert title here</title>
</head>
<body>
<% Cookie[] cks = request.getCookies();
	if(cks != null)
		for(int i=0;i<cks.length-1;i++){
			out.println(i+": Name:"+cks[i].getName()+"; Value:"+cks[i].getValue()+
					"; Maz Age:"+cks[i].getMaxAge()+"; Path:"+cks[i].getPath()+"<br/>");
			out.println("BIG5:"+new String(cks[i].getValue().getBytes("8859_1"),"BIG5")+"<br/>");
			
		}
	else
		out.println("No cookie!!");
%>
</body>
</html>