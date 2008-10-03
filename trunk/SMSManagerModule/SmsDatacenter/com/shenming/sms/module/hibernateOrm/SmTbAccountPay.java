package com.shenming.sms.module.hibernateOrm;
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * The persistent class for the sm_tb_account_pay database table.
 * 
 * @author BEA Workshop Studio
 */
public class SmTbAccountPay extends com.shenming.sms.base.bean.BaseBean implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private Integer index;
	private java.sql.Timestamp createDate;
	private java.sql.Timestamp modifyDate;
	private int payed;
	private SmTbVipAccount smTbVipAccount1;
	private SmTbVipAccount smTbVipAccount2;
	private SmTbVipAccount smTbVipAccount3;

    public SmTbAccountPay() {
    }

	public Integer getIndex() {
		return this.index;
	}
	public void setIndex(Integer index) {
		this.index = index;
	}

	public java.sql.Timestamp getCreateDate() {
		return this.createDate;
	}
	public void setCreateDate(java.sql.Timestamp createDate) {
		this.createDate = createDate;
	}

	public java.sql.Timestamp getModifyDate() {
		return this.modifyDate;
	}
	public void setModifyDate(java.sql.Timestamp modifyDate) {
		this.modifyDate = modifyDate;
	}

	public int getPayed() {
		return this.payed;
	}
	public void setPayed(int payed) {
		this.payed = payed;
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

	//bi-directional many-to-one association to SmTbVipAccount
	public SmTbVipAccount getSmTbVipAccount3() {
		return this.smTbVipAccount3;
	}
	public void setSmTbVipAccount3(SmTbVipAccount smTbVipAccount3) {
		this.smTbVipAccount3 = smTbVipAccount3;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("index", getIndex())
			.toString();
	}
}