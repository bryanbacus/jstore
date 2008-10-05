package com.shenming.sms.struts.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.shenming.sms.dc.manager.SmsVipManager;
import com.shenming.sms.manager.AccountManager;
import com.shenming.sms.struts.form.VipChildForm;
import com.shenming.sms.util.DateUtil;
import com.shenming.sms.util.Tool;

public class ManageVipChildAction extends Action {

	/* forward name="success" path="/manager/createVipChild.jsp" */
	private final static String SUCCESS = "success";

	/* forward name="message" path="/message.jsp" */
	private final static String MESSAGE = "message";
	private final static String pattern = DateUtil.DATE_FORMAT_DAY_MONTH_YEAR_DASH;
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		VipChildForm vipChildForm = (VipChildForm)form;
		SmsVipManager.initialize();
		if(VipChildForm.CREATE.equalsIgnoreCase(vipChildForm.getFormType())){
			return doCreateVipChild(mapping, form, request, response);
		} else if(VipChildForm.UPDATE.equalsIgnoreCase(vipChildForm.getFormType())){
			return doUpdateVipChild(mapping, form, request, response);
		} else {
			request.setAttribute("message", "�t�ΰѼƿ��~�A�Ц^���t�κ޲z�H���C���~���O�G"+this.getClass());
			return mapping.findForward(MESSAGE);
		}
	}

	private ActionForward doUpdateVipChild(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		VipChildForm vipChildForm = (VipChildForm)form;
		boolean isUpdateSuccess = false;
		try{
			SmsVipManager.initialize();
			SmsVipManager.beginTransaction();
			int id = SmsVipManager.retrieveUserIdByName(vipChildForm.getUsername());
			if(id == 0){
				request.setAttribute("message", "�L�k�j�M��ϥΪ̦W�٬��G "+vipChildForm.getUsername()+" ���ϥΪ�! �H�P�L�k����������ƫ���");
				return mapping.findForward(MESSAGE);
			}
			vipChildForm.setVipChildName(Tool.encodeISO88591ToBig5(vipChildForm.getVipChildName()));
			isUpdateSuccess = SmsVipManager.updateChildByUserIdAndChildName(
					vipChildForm.getUsername(), vipChildForm.getIdx(), 
					vipChildForm.getVipChildName(),  
					DateUtil.getSqlDateFromString(vipChildForm.getVipChildBirthday(), pattern),
					vipChildForm.getVipChildSex());
			System.out.println(AccountManager.currentUser(request)+" update vip child " + vipChildForm.getVipChildName() + "; result: "+ isUpdateSuccess);
			SmsVipManager.endTransaction();
		}catch (Exception e){
			e.printStackTrace();
			isUpdateSuccess = false;
			SmsVipManager.rollbackTransaction();
			request.setAttribute("message", "Un-catched Exception!");
		}
		
		/**
		 * let jsp page can submit form with an id
		 * */
		request.setAttribute("username", vipChildForm.getUsername());
		if(isUpdateSuccess){
			String path = mapping.findForward(SUCCESS).getPath()+ "&name="+vipChildForm.getUsername();
			ActionForward af = new ActionForward(path);
			return af;
		}else{
			request.setAttribute("message", "�L�k�s�W�ĵ���ơA�m�W�G" + vipChildForm.getVipChildName() + 
					"�ͤ�G"+vipChildForm.getVipChildBirthday()+"�A�нT�{����r'�m�W'�L���ơA���¡I");
			return mapping.findForward(MESSAGE);
		}
	}

	private ActionForward doCreateVipChild(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		VipChildForm vipChildForm = (VipChildForm)form;
		boolean isCreateSuccess = false;
		try{
//			SmsVipManager.initialize();
//			SmsVipManager.beginTransaction();
//			SmsVipManager.setAutoCloseSession(false);
			int id = SmsVipManager.retrieveUserIdByName(vipChildForm.getUsername());
			if(id == 0){
				request.setAttribute("message", "�L�k�j�M��ϥΪ̦W�٬��G "+vipChildForm.getUsername()+" ���ϥΪ�! �H�P�L�k����������ƫ���");
				return mapping.findForward(MESSAGE);
			}
			vipChildForm.setVipChildName(Tool.encodeISO88591ToBig5(vipChildForm.getVipChildName()));
			
			isCreateSuccess = SmsVipManager.createChildByUserId(
					id, 
					vipChildForm.getVipChildName(), 
					DateUtil.getSqlDateFromString(vipChildForm.getVipChildBirthday(), pattern),
					vipChildForm.getVipChildSex());
			log(AccountManager.currentUser(request)+" update vip child " + vipChildForm.getVipChildName()+"; result: "+ isCreateSuccess);
//			SmsVipManager.endTransaction();
		} catch (Exception e){
			e.printStackTrace();
			isCreateSuccess = false;
//			SmsVipManager.rollbackTransaction();
			request.setAttribute("message", "���~�N�X�G" + e.getMessage());
		} finally {
			
		}
		
		/**
		 * let jsp page can submit form with an id
		 * */
		request.setAttribute("username", vipChildForm.getUsername());
		if(isCreateSuccess)
			return mapping.findForward(SUCCESS);
		else{
			request.setAttribute("message", "�L�k�s�W�ĵ���ơA�m�W�G" + vipChildForm.getVipChildName() + 
					"�ͤ�G"+vipChildForm.getVipChildBirthday()+"�A�нT�{����r'�m�W'�L���ơA���¡I" + 
					(request.getAttribute("message")!=null?request.getAttribute("message"):""));
			return mapping.findForward(MESSAGE);
		}
	}
	
	private void log(String msg){
		System.out.println(msg);
	}

}
