package com.shenming.sms.module.hibernateOrm;
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * The persistent class for the sm_tb_sale_item_log database table.
 * 
 * @author BEA Workshop Studio
 */
public class SmTbSaleItemLog extends com.shenming.sms.base.bean.BaseBean implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private Integer idx;
	private java.sql.Date createDate;
	private String itemLog;
	private SmTbVipAccount smTbVipAccount;
	private SmTbSaleItem smTbSaleItem;

    public SmTbSaleItemLog() {
    }

	public Integer getIdx() {
		return this.idx;
	}
	public void setIdx(Integer idx) {
		this.idx = idx;
	}

	public java.sql.Date getCreateDate() {
		return this.createDate;
	}
	public void setCreateDate(java.sql.Date createDate) {
		this.createDate = createDate;
	}

	public String getItemLog() {
		return this.itemLog;
	}
	public void setItemLog(String itemLog) {
		this.itemLog = itemLog;
	}

	//bi-directional many-to-one association to SmTbVipAccount
	public SmTbVipAccount getSmTbVipAccount() {
		return this.smTbVipAccount;
	}
	public void setSmTbVipAccount(SmTbVipAccount smTbVipAccount) {
		this.smTbVipAccount = smTbVipAccount;
	}

	//bi-directional many-to-one association to SmTbSaleItem
	public SmTbSaleItem getSmTbSaleItem() {
		return this.smTbSaleItem;
	}
	public void setSmTbSaleItem(SmTbSaleItem smTbSaleItem) {
		this.smTbSaleItem = smTbSaleItem;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("idx", getIdx())
			.toString();
	}
}