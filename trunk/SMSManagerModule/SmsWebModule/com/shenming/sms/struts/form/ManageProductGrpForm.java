package com.shenming.sms.struts.form;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.ValidatorForm;

import com.shenming.sms.dc.manager.SmsVipManager;
import com.shenming.sms.module.hibernateOrm.SmTbProductGroup;
import com.shenming.sms.util.Tool;

public class ManageProductGrpForm extends ValidatorForm {

	private String formType;
	public static final String CREATE = "CREATE";
	public static final String UPDATE = "UPDATE";
	public static final String DELETE = "DELETE";
	public static final String QUERY = "QUERY";
	public static final String RENDER = "RENDER";
	private String prdGroupId;
	private String prdGroupDesc;
	private String prdGroupDiscount;
	private String prdGroupName;
	private String typeStatus;
	private String ownerId;
	private String productId; 
	
	//»²§UÄÝ©Ê
	private TreeMap<String, Integer> vipMap = SmsVipManager.retrieveManagerUserMap();
	
	public String getFormType() {
		return formType;
	}

	public void setFormType(String string) {
		formType = string;
	}

	public ManageProductGrpForm() {
		// TODO Auto-generated constructor stub
	}

	public String getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}

	public String getPrdGroupDesc() {
		return prdGroupDesc;
	}

	public void setPrdGroupDesc(String prdGroupDesc) {
		this.prdGroupDesc = prdGroupDesc;
	}

	public String getPrdGroupDiscount() {
		return prdGroupDiscount;
	}

	public void setPrdGroupDiscount(String prdGroupDiscount) {
		this.prdGroupDiscount = prdGroupDiscount;
	}

	public String getPrdGroupId() {
		return prdGroupId;
	}

	public void setPrdGroupId(String prdGroupId) {
		this.prdGroupId = prdGroupId;
	}

	public String getPrdGroupName() {
		return prdGroupName;
	}

	public void setPrdGroupName(String prdGroupName) {
		this.prdGroupName = prdGroupName;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getTypeStatus() {
		return typeStatus;
	}

	public void setTypeStatus(String typeStatus) {
		this.typeStatus = typeStatus;
	}
	
	public SmTbProductGroup formToBean(ManageProductGrpForm form){
		try {
			Map objMap = BeanUtils.describe(form);
			System.out.println(">>>>"+objMap);
			SmTbProductGroup bean = new SmTbProductGroup();
			BeanUtils.populate(bean,  Tool.encodeMapISO88591ToBig5(objMap));
			return bean;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ManageProductGrpForm beanToForm(SmTbProductGroup bean){
		try {
			Map objMap = BeanUtils.describe(bean);
			System.out.println(">>>>"+objMap);
			ManageProductGrpForm form = new ManageProductGrpForm();
			BeanUtils.populate(form,  objMap);
			return form;
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	public TreeMap<String, Integer> getVipMap() {
		return vipMap;
	}

}
