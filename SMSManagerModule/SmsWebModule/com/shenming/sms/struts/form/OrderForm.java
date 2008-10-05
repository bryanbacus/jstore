package com.shenming.sms.struts.form;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.struts.validator.ValidatorForm;

import com.shenming.sms.dc.manager.OrderManager;
import com.shenming.sms.dc.manager.ProductManager;
import com.shenming.sms.module.hibernateOrm.SmTbSaleItem;
import com.shenming.sms.module.hibernateOrm.SmTbSaleRecord;

public class OrderForm extends ValidatorForm {

	public static final String QUERY = "query";
	public static final String CREATE = "create";
	public static final String UPDATE = "update";
	public static final String DELETE = "delete";
	public static final String UPDATE_STATUS = "updateStatus";
	public static final String KEEP_SESSION = "keep_session";
	public static final String DELETE_SESSION = "delete_session";
	public static final String DELETE_SESSION_ALL = "delete_session_all";
	public OrderForm() {
		// TODO Auto-generated constructor stub
	}
	
	private String formType = QUERY;
	
//	sale record parameters 
	private Long saleTotal;
	private Timestamp saleDate;
	private Set<SmTbSaleItem> saleItems;
	private int saleId;
	private int vipId; 
	
//	sale items and logs
	private int prdId;
	private Long unitPrice;
	private Long discountPrice;
	private String isClosed;
	private int count;
	private String logString;
	
	private int prdGrpId;
	private Map prdGrpMap = ProductManager.retrievePrdGrpMap();
	private Map prdMap = ProductManager.retrieveAvaliableProductsMap();
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Long getDiscountPrice() {
		return discountPrice;
	}
	public void setDiscountPrice(Long discountPrice) {
		this.discountPrice = discountPrice;
	}
	public String getIsClosed() {
		return isClosed;
	}
	public void setIsClosed(String isClosed) {
		this.isClosed = isClosed;
	}
	public String getLogString() {
		return logString;
	}
	public void setLogString(String logString) {
		this.logString = logString;
	}
	public int getPrdId() {
		return prdId;
	}
	public void setPrdId(int prdId) {
		this.prdId = prdId;
	}
	public Timestamp getSaleDate() {
		return saleDate;
	}
	public void setSaleDate(Timestamp saleDate) {
		this.saleDate = saleDate;
	}
	public int getSaleId() {
		return saleId;
	}
	public void setSaleId(int saleId) {
		this.saleId = saleId;
	}
	public Set<SmTbSaleItem> getSaleItems() {
		return saleItems;
	}
	public void setSaleItems(Set<SmTbSaleItem> saleItems) {
		this.saleItems = saleItems;
	}
	public Long getSaleTotal() {
		return saleTotal;
	}
	public void setSaleTotal(Long saleTotal) {
		this.saleTotal = saleTotal;
	}
	public int getVipId() {
		return vipId;
	}
	public void setVipId(int vipId) {
		this.vipId = vipId;
	}
	public Map getPrdGrpMap() {
		return prdGrpMap;
	}
	public void setPrdGrpMap(Map prdGrpMap) {
		this.prdGrpMap = prdGrpMap;
	}
	public Map getPrdMap() {
		return prdMap;
	}
	public void setPrdMap(Map prdMap) {
		this.prdMap = prdMap;
	}
	public int getPrdGrpId() {
		return prdGrpId;
	}
	public void setPrdGrpId(int prdGrpId) {
		this.prdGrpId = prdGrpId;
	}
	public String getFormType() {
		return formType;
	}
	public void setFormType(String formType) {
		this.formType = formType;
	}
	public Long getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(Long unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	

}
