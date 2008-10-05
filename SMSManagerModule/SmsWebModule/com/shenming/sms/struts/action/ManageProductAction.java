package com.shenming.sms.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.shenming.sms.dc.manager.ProductManager;
import com.shenming.sms.dc.manager.SmsVipManager;
import com.shenming.sms.module.hibernateOrm.SmTbProduct;
import com.shenming.sms.struts.form.ProductForm;
import com.shenming.sms.struts.form.VipAccountForm;
import com.shenming.sms.util.Tool;

public class ManageProductAction extends Action {
	ProductForm prdForm ;
	/* forward name="success" path="/manager/createProductSuccess.jsp" */
	private final static String SUCCESS = "success";
	private final static String MESSAGE = "message";

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		prdForm = (ProductForm)form;
		Tool.logDebug("Product: "+prdForm.getName()+";"+prdForm.getOwnerName());
		if(ProductForm.CREATE.equalsIgnoreCase(prdForm.getFormType())){
			return doCreate(mapping, form, request, response);
		} else if(ProductForm.UPDATE.equalsIgnoreCase(prdForm.getFormType())){
			return doUpdate(mapping, form, request, response);
		} else if(ProductForm.DELETE.equalsIgnoreCase(prdForm.getFormType())){
			return doDelete(mapping, form, request, response);
		} else {
			request.setAttribute("message", "系統參數錯誤，請回報系統管理人員。錯誤類別："+this.getClass());
			return mapping.findForward(MESSAGE);
		}
	}

	private ActionForward doDelete(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
//		int owner = prdForm.getOwner();
//		int prdGrpId = prdForm.getPrdGroupId();
//		SmTbProduct product = ProductForm.formToBean(prdForm);
//		product.setSmTbProductGroup(ProductManager.retrieveProductGroupByGroupId(prdGrpId));
//		product.setSmTbVipAccount(SmsVipManager.retrieveUserById(owner));
//		ProductManager.updateProduct(product);
		return mapping.findForward(SUCCESS);
	}

	private ActionForward doCreate(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		Tool.logDebug("Product: "+prdForm.getName()+";"+prdForm.getOwnerName());
		int owner = prdForm.getOwner()!=null?prdForm.getOwner().intValue():0;
		int prdGrpId = prdForm.getPrdGroupId()!=null?prdForm.getPrdGroupId().intValue():0;
		SmTbProduct product = ProductForm.formToBean(prdForm);
		product.setSmTbProductGroup(ProductManager.retrieveProductGroupByGroupId(prdGrpId));
		product.setSmTbVipAccount(SmsVipManager.retrieveUserById(owner));
		ProductManager.createProduct(product);
		
		prdForm.setProduct(product);
		request.setAttribute("productForm", prdForm);
		return mapping.findForward(SUCCESS);
	}

	private ActionForward doUpdate(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		int owner = prdForm.getOwner();
		int prdGrpId = prdForm.getPrdGroupId();
		SmTbProduct product = ProductForm.formToBean(prdForm);
		product.setSmTbProductGroup(ProductManager.retrieveProductGroupByGroupId(prdGrpId));
		product.setSmTbVipAccount(SmsVipManager.retrieveUserById(owner));
		ProductManager.updateProduct(product);
		return mapping.findForward(SUCCESS);
	}

}
