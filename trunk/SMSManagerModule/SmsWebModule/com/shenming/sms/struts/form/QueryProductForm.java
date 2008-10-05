package com.shenming.sms.struts.form;

import java.util.List;
import java.util.TreeMap;

import org.apache.struts.validator.ValidatorForm;

import com.shenming.sms.dc.manager.ProductManager;
import com.shenming.sms.module.hibernateOrm.SmTbProduct;

public class QueryProductForm extends ValidatorForm {

	public static final String QUERY_ALL = "queryAll";
	public static final String QUERY = "query";
	public static final String QUERY_GRP_PRD = "queryGrpPrd";
	public QueryProductForm() {
		// TODO Auto-generated constructor stub
	}
	
	private String formType = QUERY;
	private int prdGroupId;
	private String prdGroupName;
	private TreeMap<Integer, String> prdGroupMap = (TreeMap<Integer, String>)ProductManager.retrievePrdGrpMap();
	private TreeMap<Integer, String> prdMap = new TreeMap();
	private String name;
	private Long price;
	private Long priceMin;
	private Long priceMax;
	private String suplyStatus;
	private List<SmTbProduct> products;
	public List<SmTbProduct> getProducts() {
		return products;
	}
	public void setProducts(List<SmTbProduct> products) {
		this.products = products;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrdGroupName() {
		return prdGroupName;
	}
	public void setPrdGroupName(String prdGroupName) {
		this.prdGroupName = prdGroupName;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public Long getPriceMax() {
		return priceMax;
	}
	public void setPriceMax(Long priceMax) {
		this.priceMax = priceMax;
	}
	public Long getPriceMin() {
		return priceMin;
	}
	public void setPriceMin(Long priceMin) {
		this.priceMin = priceMin;
	}
	public String getSuplyStatus() {
		return suplyStatus;
	}
	public void setSuplyStatus(String suplyStatus) {
		this.suplyStatus = suplyStatus;
	}
	public TreeMap<Integer, String> getPrdGroupMap() {
		return prdGroupMap;
	}
	public void setPrdGroupMap(TreeMap<Integer, String> prdGroupMap) {
		this.prdGroupMap = prdGroupMap;
	}
	public int getPrdGroupId() {
		return prdGroupId;
	}
	public void setPrdGroupId(int prdGroupId) {
		this.prdGroupId = prdGroupId;
	}
	public String getFormType() {
		return formType;
	}
	public void setFormType(String formType) {
		this.formType = formType;
	}
	public TreeMap<Integer, String> getPrdMap() {
		return prdMap;
	}
	public void setPrdMap(TreeMap<Integer, String> prdMap) {
		this.prdMap = prdMap;
	}
	
}
