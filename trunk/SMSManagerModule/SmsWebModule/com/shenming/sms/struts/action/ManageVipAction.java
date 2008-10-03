package com.shenming.sms.struts.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.shenming.sms.bean.Message;
import com.shenming.sms.dc.manager.SmsVipManager;
import com.shenming.sms.manager.AccountManager;
import com.shenming.sms.module.hibernateOrm.SmTbVipAccount;
import com.shenming.sms.module.hibernateOrm.single.SmTbVipAccountVO;
import com.shenming.sms.struts.form.VipAccountForm;
import com.shenming.sms.util.PrintUtil;

public class ManageVipAction extends Action {

	/* forward name="success" path="/manager/createVipSuccess.jsp" */
	private final static String SUCCESS = "success";

	/* forward name="message" path="/message.jsp" */
	private final static String MESSAGE = "message";
	
	/* forward name="message" path="/message.jsp" */
	private final static String QUERY_RESULT = "queryResult";

	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		VipAccountForm vipForm = (VipAccountForm)form;
		
		//Replace for type to accept parameter scope first
		if(request.getParameter("type") != null){
			vipForm.setFormType(request.getParameter("type"));
		}
		
		System.out.println("Get formType:" + vipForm.getFormType());
		
		if(VipAccountForm.CREATE.equalsIgnoreCase(vipForm.getFormType())){
			return doCreateVip(mapping, form, request, response);
		} else if(VipAccountForm.UPDATE.equalsIgnoreCase(vipForm.getFormType())){
			return doUpdateVip(mapping, form, request, response);
		} else if(VipAccountForm.DELETE.equalsIgnoreCase(vipForm.getFormType())){
			return doDeleteVip(mapping, form, request, response);
		} else if(VipAccountForm.CHECK_VIP_CHT_NAME.equalsIgnoreCase(vipForm.getFormType())){
			request.setAttribute("isShowClose", true);
			request.setAttribute("isShowDuplicateList", true);
			return doCheckVipChtName(mapping, form, request, response);
		} else if(VipAccountForm.CHECK_VIP_ENG_NAME.equalsIgnoreCase(vipForm.getFormType())){
			request.setAttribute("isShowClose", true);
			request.setAttribute("isShowDuplicateList", true);
			return doCheckVipEngName(mapping, form, request, response);
		} else if(VipAccountForm.CHECK_VIP_MAI��_ADDR.equalsIgnoreCase(vipForm.getFormType())){
			request.setAttribute("isShowClose", true);
			request.setAttribute("isShowDuplicateList", true);
			return doCheckVipMailAddr(mapping, form, request, response);
		} else if(VipAccountForm.CHECK_VIP_ADDRESS.equalsIgnoreCase(vipForm.getFormType())){
			request.setAttribute("isShowClose", true);
			request.setAttribute("isShowDuplicateList", true);
			return doCheckVipAddress(mapping, form, request, response);
		} else if(VipAccountForm.CHECK_SID.equalsIgnoreCase(vipForm.getFormType())){
			request.setAttribute("isShowClose", true);
			request.setAttribute("isShowDuplicateList", true);
			return doCheckSid(mapping, form, request, response);
		} else {
			request.setAttribute("message", "�t�ΰѼƿ��~�A�Ц^���t�κ޲z�H���C���~���O�G"+this.getClass() + "�F�L�k�������ѼơG" + vipForm.getFormType());
			return mapping.findForward(MESSAGE);
		}
	}
	
	private ActionForward doDeleteVip(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		try{
			VipAccountForm vipForm = (VipAccountForm)form;
//			PrintUtil.printObject(vipForm);
//			SmTbVipAccount vo = new SmTbVipAccount();
//			vo = VipAccountForm.formToSmTbVipAccount(vipForm);
			
//			if(vipForm.getOwner() != null && vipForm.getOwner() != 0){
//				SmTbVipAccount owner = SmsVipManager.retrieveUserById(vipForm.getOwner());
//				vo.setSmTbVipAccount(owner);
//			}
						
			boolean isSuccess = false;
			
			String idx = request.getParameter("idx");
			if(idx == null){
				request.setAttribute("message", "�L�k�R���A���w��Vip�N�����~!");
				return mapping.findForward(MESSAGE);
			}
			
			if(SmsVipManager.ADMIN_ID.equalsIgnoreCase(AccountManager.accountType(request)))
				isSuccess = SmsVipManager.deleteVipUser(new Integer(idx));

			if(isSuccess){
				request.setAttribute("link", "/sms/main.jsp?fo=manager&page=createVipChild");
				request.setAttribute("deletedVip", idx);
				request.setAttribute("message", "���\�R����VIP(ID:"+idx+")�b��!");
				return mapping.findForward(MESSAGE);
			}else{
				request.setAttribute("message", "�L�k�R����VIP�b��!");
				return mapping.findForward(MESSAGE);
			}
		} catch(Exception e){
			e.printStackTrace();
			request.setAttribute("message", "�L�k�R��VIP�b��A�o�͵L�k�w�������~!���~�N�X�G"+ e.getMessage());
			return mapping.findForward(MESSAGE);
		}
	}

	private ActionForward doCheckSid(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		SmTbVipAccount vo = new SmTbVipAccount();
		vo.setSid(request.getParameter("id"));
		
		List<SmTbVipAccountVO> duplicateList = SmsVipManager.retrieveUserByPossibleDuplicate("sid", vo.getSid());
		if(duplicateList.size() > 0){
			request.setAttribute("message", "�����Ҹ��P�w�s�bVIP�b�᭫�ơA�H�U���i�୫�Ƹ�ơA�нT�{!");
			request.getSession().setAttribute("duplicateList", duplicateList);
			return mapping.findForward(QUERY_RESULT);
		} else {
			request.setAttribute("message", "��J������ҥ��T�I");
			request.getSession().setAttribute("duplicateList", duplicateList);
			return mapping.findForward(QUERY_RESULT);
		}
	}

	private ActionForward doCheckVipAddress(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		SmTbVipAccount vo = new SmTbVipAccount();
		vo.setAddress(request.getParameter("id"));
		
		List<SmTbVipAccountVO> duplicateList = SmsVipManager.retrieveUserByPossibleDuplicate("address", vo.getAddress());
		if(duplicateList.size() > 0){
			request.setAttribute("message", "�a�}�P�w�s�bVIP�b�᭫�ơA�H�U���i�୫�Ƹ�ơA�нT�{!");
			request.getSession().setAttribute("duplicateList", duplicateList);
			return mapping.findForward(QUERY_RESULT);
		} else {
			request.setAttribute("message", "��J������ҥ��T�I");
			request.getSession().setAttribute("duplicateList", duplicateList);
			return mapping.findForward(QUERY_RESULT);
		}
	}

	private ActionForward doCheckVipMailAddr(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		SmTbVipAccount vo = new SmTbVipAccount();
		vo.setMailAddr(request.getParameter("id"));
		
		List<SmTbVipAccountVO> duplicateList = SmsVipManager.retrieveUserByPossibleDuplicate("mail_addr", vo.getMailAddr());
		if(duplicateList.size() > 0){
			request.setAttribute("message", "�q�l�l��P�w�s�bVIP�b�᭫�ơA�H�U���i�୫�Ƹ�ơA�нT�{!");
			request.getSession().setAttribute("duplicateList", duplicateList);
			return mapping.findForward(QUERY_RESULT);
		} else {
			request.setAttribute("message", "��J������ҥ��T�I");
			request.getSession().setAttribute("duplicateList", duplicateList);
			return mapping.findForward(QUERY_RESULT);
		}
	}

	private ActionForward doCheckVipEngName(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		SmTbVipAccount vo = new SmTbVipAccount();
		vo.setVipEngName(request.getParameter("id"));
		
		List<SmTbVipAccountVO> duplicateList = SmsVipManager.retrieveUserByPossibleDuplicate("vip_eng_name", vo.getVipEngName());
		if(duplicateList.size() > 0){
			request.setAttribute("message", "�^��W�ٻP�w�s�bVIP�b�᭫�ơA�H�U���i�୫�Ƹ�ơA�нT�{!");
			request.getSession().setAttribute("duplicateList", duplicateList);
			return mapping.findForward(QUERY_RESULT);
		} else {
			request.setAttribute("message", "��J������ҥ��T�I");
			request.getSession().setAttribute("duplicateList", duplicateList);
			return mapping.findForward(QUERY_RESULT);
		}
	}

	private ActionForward doCheckVipChtName(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		SmTbVipAccount vo = new SmTbVipAccount();
		vo.setVipChtName(request.getParameter("id"));
		
		List<SmTbVipAccountVO> duplicateList = SmsVipManager.retrieveUserByPossibleDuplicate("vip_cht_name", vo.getVipChtName());
		if(duplicateList.size() > 0){
			request.setAttribute("message", "����W�ٻP�w�s�bVIP�b�᭫�ơA�H�U���i�୫�Ƹ�ơA�нT�{!");
			request.getSession().setAttribute("duplicateList", duplicateList);
			return mapping.findForward(QUERY_RESULT);
		} else {
			request.setAttribute("message", "��J������ҥ��T�I");
			request.getSession().setAttribute("duplicateList", duplicateList);
			return mapping.findForward(QUERY_RESULT);
		}
	}

	/**
	 * For /manager/updateVipAction
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	private ActionForward doUpdateVip(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
		try{
			VipAccountForm vipForm = (VipAccountForm)form;
//			PrintUtil.printObject(vipForm);
			SmTbVipAccount vo = new SmTbVipAccount();
			vo = VipAccountForm.formToSmTbVipAccount(vipForm);
			
			if(vipForm.getOwner() != null && vipForm.getOwner() != 0){
				SmTbVipAccount owner = SmsVipManager.retrieveUserById(vipForm.getOwner());
				vo.setSmTbVipAccount(owner);
			}
						
			boolean isSuccess = false;
			
			if(SmsVipManager.ADMIN_ID.equalsIgnoreCase(vipForm.getAccountType()))
				isSuccess = SmsVipManager.updateVipUser(vo, SmsVipManager.ADMIN_ID, vipForm.getDescription());
			else if(SmsVipManager.MANAGER_ID.equalsIgnoreCase(vipForm.getAccountType()))
				isSuccess = SmsVipManager.updateVipUser(vo, SmsVipManager.MANAGER_ID, vipForm.getDescription());
			else if(SmsVipManager.VIP_ID.equalsIgnoreCase(vipForm.getAccountType()))
				isSuccess = SmsVipManager.updateVipUser(vo, SmsVipManager.VIP_ID, vipForm.getDescription());
			
			request.setAttribute("createdVip", vo);
			if(isSuccess){
				request.setAttribute("link", "/sms/main.jsp?fo=manager&page=createVipChild");
				request.setAttribute("createdVip", vo);
				return mapping.findForward(SUCCESS);
			}else{
				request.setAttribute("message", "�L�k��sVIP�b��A�нT�{�O�_Username�Ψ�L����r����!");
				return mapping.findForward(MESSAGE);
			}
		} catch(Exception e){
			e.printStackTrace();
			request.setAttribute("message", "�L�k��sVIP�b��A�o�͵L�k�w�������~!���~�N�X�G"+ e.getMessage());
			return mapping.findForward(MESSAGE);
		}
	}

	/**
	 * For /manager/createVipAction
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	private ActionForward doCreateVip(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response){
		try{
			VipAccountForm vipForm = (VipAccountForm)form;
			SmTbVipAccount vo = new SmTbVipAccount();
			vo = VipAccountForm.formToSmTbVipAccount(vipForm);
			
			boolean isForceCreate = "true".equalsIgnoreCase(request.getParameter("forceCreate"))?true:false;
			
			/*Retrieve the owner object*/
			if(vipForm.getOwner() != null && vipForm.getOwner() != 0){
				SmTbVipAccount owner = SmsVipManager.retrieveUserById(vipForm.getOwner());
				vo.setSmTbVipAccount(owner);
			}
			
			List<SmTbVipAccountVO> duplicateList = SmsVipManager.retrieveUserByPossibleDuplicate(vo);
			if(!isForceCreate && duplicateList!=null && duplicateList.size() > 0){
				request.setAttribute("message", "�L�k�إ�VIP�b��A�H�U���i�୫�Ƹ�ơA�нT�{!");
				request.setAttribute("isShowDuplicateList", true);
				request.setAttribute("isShowTryCreate", true);
				request.getSession().setAttribute("duplicateList", duplicateList);
				return mapping.findForward(MESSAGE);
			}
			
			boolean isSuccess = false;
			
			/*Only accept the value of 'MANAGER' and 'VIP'*/
			if(SmsVipManager.ADMIN_ID.equalsIgnoreCase(vipForm.getAccountType()))
				isSuccess = SmsVipManager.createVipUser(vo, SmsVipManager.ADMIN_ID, vipForm.getDescription());
			else if(SmsVipManager.MANAGER_ID.equalsIgnoreCase(vipForm.getAccountType()))
				isSuccess = SmsVipManager.createVipUser(vo, SmsVipManager.MANAGER_ID, vipForm.getDescription());
			else if(SmsVipManager.VIP_ID.equalsIgnoreCase(vipForm.getAccountType()))
				isSuccess = SmsVipManager.createVipUser(vo, SmsVipManager.VIP_ID, vipForm.getDescription());
			else
				isSuccess = false;
			
			request.setAttribute("createdVip", vo);
			if(isSuccess){
				request.setAttribute("link", "/sms/main.jsp?fo=manager&page=createVipChild");
				request.setAttribute("createdVip", vo);
				return mapping.findForward(SUCCESS);
			}else{
				List<Message> messageList = SmsVipManager.checkConflictOfVipAccount(vo.getUserId().toString());
				request.getSession().setAttribute("messageList", messageList);
				request.setAttribute("message", "�L�k�إ�VIP�b��A�нT�{�O�_Username�Ψ�L����r����!");
				return mapping.findForward(MESSAGE);
			}
		} catch(Exception e){
			e.printStackTrace();
			request.setAttribute("message", "�L�k��sVIP�b��A�o�͵L�k�w�������~!���~�N�X�G"+ e.getMessage());
			return mapping.findForward(MESSAGE);
		}
	}

}
