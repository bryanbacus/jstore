package com.shenming.sms.struts.form;

import java.util.List;
import java.util.Map;

import org.apache.struts.validator.ValidatorForm;

import com.shenming.sms.dc.manager.SmsVipManager;
import com.shenming.sms.module.hibernateOrm.SmTbSaleRecord;

public class QueryOrderForm extends ValidatorForm {
	
	public static final String QUERY_ALL = "queryAll";
	public static final String QUERY = "query";
	public static final String QUERY_DETAIL = "queryDetail";	
	
	public QueryOrderForm() {
		// TODO Auto-generated constructor stub
	}
	private String formType;
	private int vipId;
	private int saleId;
	private String saleDateStart;
	private String saleDateEnd;
	private long saleTotalMin;
	private long saleTotalMax;
	
	private SmTbSaleRecord saleRecord;
	private List<SmTbSaleRecord> saleRecords;
	
	private Map vipMap = SmsVipManager.retrieveAllUserMap();
	
	public String getSaleDateEnd() {
		return saleDateEnd;
	}
	public void setSaleDateEnd(String saleDateEnd) {
		this.saleDateEnd = saleDateEnd;
	}
	public String getSaleDateStart() {
		return saleDateStart;
	}
	public void setSaleDateStart(String saleDateStart) {
		this.saleDateStart = saleDateStart;
	}
	public int getSaleId() {
		return saleId;
	}
	public void setSaleId(int saleId) {
		this.saleId = saleId;
	}
	public List<SmTbSaleRecord> getSaleRecords() {
		return saleRecords;
	}
	public void setSaleRecords(List<SmTbSaleRecord> saleRecords) {
		this.saleRecords = saleRecords;
	}
	public long getSaleTotalMax() {
		return saleTotalMax;
	}
	public void setSaleTotalMax(long saleTotalMax) {
		this.saleTotalMax = saleTotalMax;
	}
	public long getSaleTotalMin() {
		return saleTotalMin;
	}
	public void setSaleTotalMin(long saleTotalMin) {
		this.saleTotalMin = saleTotalMin;
	}
	public int getVipId() {
		return vipId;
	}
	public void setVipId(int vipId) {
		this.vipId = vipId;
	}
	public String getFormType() {
		return formType;
	}
	public void setFormType(String formType) {
		this.formType = formType;
	}
	public Map getVipMap() {
		return vipMap;
	}
	public void setVipMap(Map vipMap) {
		this.vipMap = vipMap;
	}
	public SmTbSaleRecord getSaleRecord() {
		return saleRecord;
	}
	public void setSaleRecord(SmTbSaleRecord saleRecord) {
		this.saleRecord = saleRecord;
	}
	

}
