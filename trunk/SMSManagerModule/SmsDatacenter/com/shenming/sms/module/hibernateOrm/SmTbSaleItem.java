package com.shenming.sms.module.hibernateOrm;
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * The persistent class for the sm_tb_sale_item database table.
 * 
 * @author BEA Workshop Studio
 */
public class SmTbSaleItem extends com.shenming.sms.base.bean.BaseBean implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private Integer itemSeq;
	private long count;
	private java.sql.Timestamp crDate;
	private String isClose;
	private String log;
	private Long prdDiscountPrice;
	private Long prdUnitPrice;
	private java.sql.Timestamp updDate;
	private SmTbVipAccount smTbVipAccount1;
	private SmTbProduct smTbProduct;
	private SmTbSaleRecord smTbSaleRecord;
	private SmTbVipAccount smTbVipAccount2;

    public SmTbSaleItem() {
    }

	public Integer getItemSeq() {
		return this.itemSeq;
	}
	public void setItemSeq(Integer itemSeq) {
		this.itemSeq = itemSeq;
	}

	public long getCount() {
		return this.count;
	}
	public void setCount(long count) {
		this.count = count;
	}

	public java.sql.Timestamp getCrDate() {
		return this.crDate;
	}
	public void setCrDate(java.sql.Timestamp crDate) {
		this.crDate = crDate;
	}

	public String getIsClose() {
		return this.isClose;
	}
	public void setIsClose(String isClose) {
		this.isClose = isClose;
	}

	public String getLog() {
		return this.log;
	}
	public void setLog(String log) {
		this.log = log;
	}

	public Long getPrdDiscountPrice() {
		return this.prdDiscountPrice;
	}
	public void setPrdDiscountPrice(Long prdDiscountPrice) {
		this.prdDiscountPrice = prdDiscountPrice;
	}

	public Long getPrdUnitPrice() {
		return this.prdUnitPrice;
	}
	public void setPrdUnitPrice(Long prdUnitPrice) {
		this.prdUnitPrice = prdUnitPrice;
	}

	public java.sql.Timestamp getUpdDate() {
		return this.updDate;
	}
	public void setUpdDate(java.sql.Timestamp updDate) {
		this.updDate = updDate;
	}

	//bi-directional many-to-one association to SmTbVipAccount
	public SmTbVipAccount getSmTbVipAccount1() {
		return this.smTbVipAccount1;
	}
	public void setSmTbVipAccount1(SmTbVipAccount smTbVipAccount1) {
		this.smTbVipAccount1 = smTbVipAccount1;
	}

	//bi-directional many-to-one association to SmTbProduct
	public SmTbProduct getSmTbProduct() {
		return this.smTbProduct;
	}
	public void setSmTbProduct(SmTbProduct smTbProduct) {
		this.smTbProduct = smTbProduct;
	}

	//bi-directional many-to-one association to SmTbSaleRecord
	public SmTbSaleRecord getSmTbSaleRecord() {
		return this.smTbSaleRecord;
	}
	public void setSmTbSaleRecord(SmTbSaleRecord smTbSaleRecord) {
		this.smTbSaleRecord = smTbSaleRecord;
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
			.append("itemSeq", getItemSeq())
			.toString();
	}
}