package com.shenming.sms.module.hibernateOrm;
import java.io.Serializable;
import java.util.Iterator;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.shenming.sms.dc.manager.OrderManager;
import com.shenming.sms.dc.manager.ProductStatusManager;

/**
 * The persistent class for the sm_tb_sale_record database table.
 * 
 * @author BEA Workshop Studio
 */
public class SmTbSaleRecord extends com.shenming.sms.base.bean.BaseBean implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private Integer saleSeq;
	private java.sql.Timestamp saleDate;
	private Long saleTotal;
	private java.util.Set<SmTbSaleItem> smTbSaleItems;
	private SmTbVipAccount smTbVipAccount1;
	private SmTbVipAccount smTbVipAccount2;
	
	// Extra informations
	private int smTbSaleItemsSize ;
	private boolean isAllClose;
	
    public SmTbSaleRecord() {
    }

	public Integer getSaleSeq() {
		return this.saleSeq;
	}
	public void setSaleSeq(Integer saleSeq) {
		this.saleSeq = saleSeq;
	}

	public java.sql.Timestamp getSaleDate() {
		return this.saleDate;
	}
	public void setSaleDate(java.sql.Timestamp saleDate) {
		this.saleDate = saleDate;
	}

	public Long getSaleTotal() {
		return this.saleTotal;
	}
	public void setSaleTotal(Long saleTotal) {
		this.saleTotal = saleTotal;
	}

	//bi-directional many-to-one association to SmTbSaleItem
	public java.util.Set<SmTbSaleItem> getSmTbSaleItems() {
		return this.smTbSaleItems;
	}
	public void setSmTbSaleItems(java.util.Set<SmTbSaleItem> smTbSaleItems) {
		this.smTbSaleItems = smTbSaleItems;
	}

	//bi-directional many-to-one association to SmTbVipAccount
	public SmTbVipAccount getSmTbVipAccount1() {
		return this.smTbVipAccount1;
	}
	public void setSmTbVipAccount1(SmTbVipAccount smTbVipAccount1) {
		this.smTbVipAccount1 = smTbVipAccount1;
	}

	//bi-directional many-to-one association to SmTbVipAccount
	public SmTbVipAccount getSmTbVipAccount2() {
		return this.smTbVipAccount2;
	}
	public void setSmTbVipAccount2(SmTbVipAccount smTbVipAccount2) {
		this.smTbVipAccount2 = smTbVipAccount2;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("saleSeq", getSaleSeq())
			.toString();
	}

	public int getSmTbSaleItemsSize() {
		return smTbSaleItems.size();
	}
	
//	public boolean isAllClose(java.util.Set<SmTbSaleItem> smTbSaleItems){
//		Iterator iter = smTbSaleItems.iterator();
//		while(iter.hasNext()){
//			SmTbSaleItem vo = (SmTbSaleItem)iter.next();
//			if(OrderManager.ORDER_STATUS_NOT_CLOSE.equalsIgnoreCase(vo.getIsClose())){
//				return false;
//			}
//		}
//		return true;
//	}

	public boolean isAllClose() {
		Iterator iter = smTbSaleItems.iterator();
		while(iter.hasNext()){
			SmTbSaleItem vo = (SmTbSaleItem)iter.next();
			if(OrderManager.ORDER_STATUS_NOT_CLOSE.equalsIgnoreCase(vo.getIsClose()) ||
					OrderManager.ORDER_STATUS_SUSPEND.equalsIgnoreCase(vo.getIsClose())){
				return false;
			}
		}
		return true;
	}

}