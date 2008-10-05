package com.shenming.sms.module.hibernateOrm;
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * The persistent class for the sm_tb_product_group database table.
 * 
 * @author BEA Workshop Studio
 */
public class SmTbProductGroup extends com.shenming.sms.base.bean.BaseBean implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private Integer prdGroupId;
	private String prdGroupDesc;
	private Float prdGroupDiscount;
	private String prdGroupName;
	private String typeStatus;
	private java.util.Set<SmTbProduct> smTbProducts;
	private SmTbVipAccount smTbVipAccount;

    public SmTbProductGroup() {
    }

	public Integer getPrdGroupId() {
		return this.prdGroupId;
	}
	public void setPrdGroupId(Integer prdGroupId) {
		this.prdGroupId = prdGroupId;
	}

	public String getPrdGroupDesc() {
		return this.prdGroupDesc;
	}
	public void setPrdGroupDesc(String prdGroupDesc) {
		this.prdGroupDesc = prdGroupDesc;
	}

	public Float getPrdGroupDiscount() {
		return this.prdGroupDiscount;
	}
	public void setPrdGroupDiscount(Float prdGroupDiscount) {
		this.prdGroupDiscount = prdGroupDiscount;
	}

	public String getPrdGroupName() {
		return this.prdGroupName;
	}
	public void setPrdGroupName(String prdGroupName) {
		this.prdGroupName = prdGroupName;
	}

	public String getTypeStatus() {
		return this.typeStatus;
	}
	public void setTypeStatus(String typeStatus) {
		this.typeStatus = typeStatus;
	}

	//bi-directional many-to-one association to SmTbProduct
	public java.util.Set<SmTbProduct> getSmTbProducts() {
		return this.smTbProducts;
	}
	public void setSmTbProducts(java.util.Set<SmTbProduct> smTbProducts) {
		this.smTbProducts = smTbProducts;
	}

	//bi-directional many-to-one association to SmTbVipAccount
	public SmTbVipAccount getSmTbVipAccount() {
		return this.smTbVipAccount;
	}
	public void setSmTbVipAccount(SmTbVipAccount smTbVipAccount) {
		this.smTbVipAccount = smTbVipAccount;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("prdGroupId", getPrdGroupId())
			.toString();
	}
}