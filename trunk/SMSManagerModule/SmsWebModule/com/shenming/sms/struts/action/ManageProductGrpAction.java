package com.shenming.sms.struts.action;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.shenming.sms.dc.manager.ProductManager;
import com.shenming.sms.dc.manager.SmsVipManager;
import com.shenming.sms.module.hibernateOrm.SmTbProductGroup;
import com.shenming.sms.struts.form.ManageProductGrpForm;
import com.shenming.sms.util.PrintUtil;
import com.shenming.sms.util.Tool;

public class ManageProductGrpAction extends AbsSmsAction {

	/* forward name="success" path="/message.jsp" */
	private final static String SUCCESS = "success";

	/* forward name="error" path="/manager/queryProductGroup.jsp" */
	private final static String QUERY = "query";
	
	/* forward name="error" path="/message.jsp" */
	private final static String ERROR = "error";
	
	/* forward name="error" path="/manager/manageProductGroup.jsp" */
	private final static String UPDATE = "update";
	
	private ManageProductGrpForm grpForm ;
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		grpForm = (ManageProductGrpForm)form;
		if(ManageProductGrpForm.CREATE.equalsIgnoreCase(grpForm.getFormType())){
			return doCreate(mapping, form,request, response);
		}else if(ManageProductGrpForm.UPDATE.equalsIgnoreCase(grpForm.getFormType())){
			return doUpdate(mapping, form,request, response);
		}else if(ManageProductGrpForm.DELETE.equalsIgnoreCase(grpForm.getFormType())){
			return doDelete(mapping, form,request, response);
		}else if(ManageProductGrpForm.QUERY.equalsIgnoreCase(grpForm.getFormType())){
			return doQuery(mapping, form,request, response);
		}else if(ManageProductGrpForm.RENDER.equalsIgnoreCase(request.getParameter("formType"))){
			return doRender(mapping, form,request, response);
		}
		
		request.setAttribute("message", "formType is not valid!");
		return mapping.findForward(ERROR);
	}

	private ActionForward doRender(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		Integer grpIdx = null;
		try{
			grpIdx = request.getParameter("idx")!=null?new Integer(request.getParameter("idx")):null;
		} catch (NumberFormatException e){
			e.printStackTrace();
			return doForward(mapping, request, "ERROR", "�L�k�B�z�z��ܪ����O�N��!");
		}
		
		ProductManager.initialize();
		SmTbProductGroup vo = ProductManager.retrieveProductGroupByGroupId(grpIdx);
		request.setAttribute("manageProductGrpForm", grpForm.beanToForm(vo));
		return mapping.findForward(UPDATE);
	}

	private ActionForward doDelete(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		
		Integer grpIdx = null;
		try{
			grpIdx = new Integer(grpForm.getPrdGroupId());
		} catch (Exception e){
			e.printStackTrace();
			return doForward(mapping, request, "ERROR", "�L�k�B�z�z��ܪ����O�N��!");
		}
		ProductManager.initialize();
		SmTbProductGroup vo = ProductManager.retrieveProductGroupByGroupId(grpIdx);
		boolean isSuccess = false;
		if(vo != null){
			isSuccess = ProductManager.doDelete(vo);
			return doForward(mapping, request, ERROR, "�R�����O�G" + vo.getPrdGroupName() + "[" + vo.getPrdGroupId() + "] "+ (isSuccess?"���\":"����") + "!");
		} else {
			return doForward(mapping, request, ERROR, "�L�k�B�z�z��ܪ����O�N��!");
		}
	}

	private ActionForward doQuery(
			ActionMapping mapping, 
			ActionForm form, 
			HttpServletRequest request, 
			HttpServletResponse response) {
//		grpForm
		ProductManager.initialize();
		
		request.getSession().setAttribute("prdGrpsList",
				ProductManager.retrieveAllProductGroupsByForm(grpForm));
		grpForm.setPrdGroupName(Tool.encodeISO88591ToBig5(grpForm.getPrdGroupName()));
		
		return mapping.findForward(QUERY);
		
//		return mapping.findForward(ERROR);
	}

	private ActionForward doUpdate(
			ActionMapping mapping, 
			ActionForm form, 
			HttpServletRequest request, 
			HttpServletResponse response) {
		ProductManager.initialize();
		try{
			SmTbProductGroup vo = grpForm.formToBean(grpForm);
			PrintUtil.printObject(vo);
			Integer ownerId = grpForm.getOwnerId()!=null?new Integer(grpForm.getOwnerId()):null;
			if(ownerId != null)
				vo.setSmTbVipAccount(SmsVipManager.retrieveUserById(ownerId));
			
			boolean isSuccess = ProductManager.doUpdate(vo);

			if(isSuccess){
				request.setAttribute("message", "��s���~���O�G" + vo.getPrdGroupName() + "[" + vo.getPrdGroupId() + "] ���\!");
				return mapping.findForward(SUCCESS);
			} else{
				request.setAttribute("message", "�L�k��s���~���O��T�A�нT�{���榡�L�~!");
				return mapping.findForward(ERROR);
			}
		} catch(Exception e){
			request.setAttribute("message", "�L�k��s���~���O��T�A�нT�{���榡�L�~! ���~�T���G" + e.getMessage());
		}
		return mapping.findForward(ERROR);
	}

	private ActionForward doCreate(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		ProductManager.initialize();
		try{
			SmTbProductGroup vo = grpForm.formToBean(grpForm);
			Integer ownerId = grpForm.getOwnerId()!=null?new Integer(grpForm.getOwnerId()):null;
			if(ownerId != null)
				vo.setSmTbVipAccount(SmsVipManager.retrieveUserById(ownerId));
			
			boolean isSuccess = ProductManager.doCreate(vo);

			if(isSuccess){
				request.setAttribute("message", "�s�W�[���~���O�G" + vo.getPrdGroupName() + "[" + vo.getPrdGroupId() + "] ���\!");
				return mapping.findForward(SUCCESS);
			} else{
				request.setAttribute("message", "�L�k�s�W���~���O��T�A�нT�{���榡�L�~!");
				return mapping.findForward(ERROR);
			}
		} catch(Exception e){
			request.setAttribute("message", "�L�k�s�W���~���O��T�A�нT�{���榡�L�~! ���~�T���G" + e.getMessage());
		}
		return mapping.findForward(ERROR);
	}

}
