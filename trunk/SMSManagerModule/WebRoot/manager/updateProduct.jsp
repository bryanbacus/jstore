<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@ page import="com.shenming.sms.module.hibernateOrm.*,
		com.shenming.sms.dc.manager.*,
		com.shenming.sms.util.*,
		com.shenming.sms.struts.form.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>Update Product</title>
</head>
<body>
<%
	String type = (String)request.getParameter("type");
	int idx = new Integer(request.getParameter("idx")).intValue();
	SmTbProduct prd = ProductManager.retrieveProductById(idx);
	if(prd == null || "".equalsIgnoreCase(prd.getName())){
		request.setAttribute("message","無產品序號:"+idx+"之資料，請重新確認");
%>
<jsp:forward page="/main.jsp?page=message"/>
<%
	}
	//Prepare account information
	ProductForm productForm = ProductForm.beanToForm(prd);
	//if("show".equalsIgnoreCase(type))
	productForm.setProduct(prd);
	
	if(ProductForm.UPDATE.equalsIgnoreCase(type)){						//Do update
		productForm.setFormType(ProductForm.UPDATE);
		request.setAttribute("productForm", productForm);
%>
<jsp:forward page="/main.jsp?fo=manager&page=createProduct"/>
<%	} else if(ProductForm.UPDATE.equalsIgnoreCase(type)){				//Do delete
	productForm.setFormType(ProductForm.UPDATE);
	request.setAttribute("productForm", productForm);
%>
<jsp:forward page="/main.jsp?fo=manager&page=createProduct"/>
<%	} else { 															//Do show detail
		request.setAttribute("productForm", productForm);
%>
<jsp:forward page="/main.jsp?fo=manager&page=createProductSuccess"/>
<%	} %>

</body>
</html>