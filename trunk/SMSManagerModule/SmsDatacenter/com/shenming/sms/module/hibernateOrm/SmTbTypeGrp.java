package com.shenming.sms.module.hibernateOrm;
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * The persistent class for the sm_tb_type_grp database table.
 * 
 * @author BEA Workshop Studio
 */
public class SmTbTypeGrp extends com.shenming.sms.base.bean.BaseBean implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private Integer prdTypeId;
	private String prdTypeDesc;
	private Long prdTypeDiscount;
	private String prdTypeName;
	private java.util.Set<SmTbProduct> smTbProducts;
	private SmTbVipAccount smTbVipAccount;

    public SmTbTypeGrp() {
    }

	public Integer getPrdTypeId() {
		return this.prdTypeId;
	}
	public void setPrdTypeId(Integer prdTypeId) {
		this.prdTypeId = prdTypeId;
	}

	public String getPrdTypeDesc() {
		return this.prdTypeDesc;
	}
	public void setPrdTypeDesc(String prdTypeDesc) {
		this.prdTypeDesc = prdTypeDesc;
	}

	public Long getPrdTypeDiscount() {
		return this.prdTypeDiscount;
	}
	public void setPrdTypeDiscount(Long prdTypeDiscount) {
		this.prdTypeDiscount = prdTypeDiscount;
	}

	public String getPrdTypeName() {
		return this.prdTypeName;
	}
	public void setPrdTypeName(String prdTypeName) {
		this.prdTypeName = prdTypeName;
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
			.append("prdTypeId", getPrdTypeId())
			.toString();
	}
}