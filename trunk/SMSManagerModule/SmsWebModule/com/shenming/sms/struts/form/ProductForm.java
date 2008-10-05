package com.shenming.sms.struts.form;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.validator.ValidatorForm;

import com.shenming.sms.dc.manager.ProductManager;
import com.shenming.sms.dc.manager.SmsVipManager;
import com.shenming.sms.module.hibernateOrm.SmTbProduct;
import com.shenming.sms.module.hibernateOrm.SmTbProductGroup;
import com.shenming.sms.module.hibernateOrm.SmTbVipAccount;
import com.shenming.sms.util.PrintUtil;
import com.shenming.sms.util.Tool;

public class ProductForm extends ValidatorForm{

	public static final String CREATE = "create";
	public static final String UPDATE = "update";
	public static final String DELETE = "delete";
	public ProductForm() {
		// TODO Auto-generated constructor stub
	}
	private String formType = CREATE;
	private Integer prdId;
	private Integer prdGroupId;
	private String prdGroupName;
	private String detailDesc;
	private String formatDesc;
	private String name;
	private String prdPicFile;
	private Long price;
	private Long priceVip;
	private String sendArea;
	private String sendDesc;
	private String suplyStatus;
	private Integer owner;
	private String ownerName ;
	private SmTbProduct product;
	private TreeMap<Integer, String> prdGrpMap = (TreeMap<Integer, String>)ProductManager.retrievePrdGrpMap();
	private TreeMap<String, Integer> ownerMap = SmsVipManager.retrieveManagerUserMap();
	
	
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getPrdGroupName() {
		return prdGroupName;
	}
	public void setPrdGroupName(String prdGroupName) {
		this.prdGroupName = prdGroupName;
	}
	public String getDetailDesc() {
		return detailDesc;
	}
	public void setDetailDesc(String detailDesc) {
		this.detailDesc = detailDesc;
	}
	public String getFormatDesc() {
		return formatDesc;
	}
	public void setFormatDesc(String formatDesc) {
		this.formatDesc = formatDesc;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getOwner() {
		return owner;
	}
	public void setOwner(Integer owner) {
		this.owner = owner;
	}
	public Integer getPrdGroupId() {
		return prdGroupId;
	}
	public void setPrdGroupId(Integer prdGroupId) {
		this.prdGroupId = prdGroupId;
	}
	public Integer getPrdId() {
		return prdId;
	}
	public void setPrdId(Integer prdId) {
		this.prdId = prdId;
	}
	public String getPrdPicFile() {
		return prdPicFile;
	}
	public void setPrdPicFile(String prdPicFile) {
		this.prdPicFile = prdPicFile;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public Long getPriceVip() {
		return priceVip;
	}
	public void setPriceVip(Long priceVip) {
		this.priceVip = priceVip;
	}
	public String getSendArea() {
		return sendArea;
	}
	public void setSendArea(String sendArea) {
		this.sendArea = sendArea;
	}
	public String getSendDesc() {
		return sendDesc;
	}
	public void setSendDesc(String sendDesc) {
		this.sendDesc = sendDesc;
	}
	public String getSuplyStatus() {
		return suplyStatus;
	}
	public void setSuplyStatus(String suplyStatus) {
		this.suplyStatus = suplyStatus;
	}
	public String getFormType() {
		return formType;
	}
	public void setFormType(String formType) {
		this.formType = formType;
	}
	public TreeMap<Integer, String> getPrdGrpMap() {
		return prdGrpMap;
	}
	public void setPrdGrpMap(TreeMap<Integer, String> prdGrpMap) {
		this.prdGrpMap = prdGrpMap;
	}
	public TreeMap<String, Integer> getOwnerMap() {
		return ownerMap;
	}
	public void setOwnerMap(TreeMap<String, Integer> ownerMap) {
		this.ownerMap = ownerMap;
	}

	public static SmTbProduct formToBean(ProductForm form){
		try {
			HashMap formMap = (HashMap) BeanUtils.describe(form);
			SmTbProduct product = new SmTbProduct();
			BeanUtils.populate(product, Tool.encodeMapISO88591ToBig5(formMap));
			PrintUtil.printObject(product);
			SmTbVipAccount smTbVipAccount = SmsVipManager.retrieveUserById(form.getOwner());
			product.setSmTbVipAccount(smTbVipAccount);
			SmTbProductGroup smTbProductGroup = ProductManager.retrieveProductGroupByGroupId(form.getPrdGroupId());
			product.setSmTbProductGroup(smTbProductGroup);
			return product;
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
	
	public static ProductForm beanToForm(SmTbProduct obj){
		try {
			HashMap objMap = (HashMap) BeanUtils.describe(obj);
			ProductForm product = new ProductForm();
			BeanUtils.populate(product, objMap);
			product.setOwner(obj.getSmTbVipAccount()!=null?obj.getSmTbVipAccount().getUserId():0);
			product.setOwnerName(obj.getSmTbVipAccount()!=null?obj.getSmTbVipAccount().getVipChtName():"");
			product.setPrdGroupId(obj.getSmTbProductGroup()!=null?obj.getSmTbProductGroup().getPrdGroupId():0);
			product.setPrdGroupName(obj.getSmTbProductGroup()!=null?obj.getSmTbProductGroup().getPrdGroupName():"");
			return product;
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
	public SmTbProduct getProduct() {
		return product;
	}
	public void setProduct(SmTbProduct product) {
		this.product = product;
	}
	
}
