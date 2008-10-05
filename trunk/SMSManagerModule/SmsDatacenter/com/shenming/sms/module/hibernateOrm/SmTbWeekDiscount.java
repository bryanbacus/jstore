package com.shenming.sms.module.hibernateOrm;
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * The persistent class for the sm_tb_week_discount database table.
 * 
 * @author BEA Workshop Studio
 */
public class SmTbWeekDiscount extends com.shenming.sms.base.bean.BaseBean implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private Integer disSeq;
	private Long disPrice;
	private java.sql.Timestamp endDate;
	private Long prdCurrentTotal;
	private Long prdTotal;
	private java.sql.Timestamp startDate;
	private SmTbProduct smTbProduct;

    public SmTbWeekDiscount() {
    }

	public Integer getDisSeq() {
		return this.disSeq;
	}
	public void setDisSeq(Integer disSeq) {
		this.disSeq = disSeq;
	}

	public Long getDisPrice() {
		return this.disPrice;
	}
	public void setDisPrice(Long disPrice) {
		this.disPrice = disPrice;
	}

	public java.sql.Timestamp getEndDate() {
		return this.endDate;
	}
	public void setEndDate(java.sql.Timestamp endDate) {
		this.endDate = endDate;
	}

	public Long getPrdCurrentTotal() {
		return this.prdCurrentTotal;
	}
	public void setPrdCurrentTotal(Long prdCurrentTotal) {
		this.prdCurrentTotal = prdCurrentTotal;
	}

	public Long getPrdTotal() {
		return this.prdTotal;
	}
	public void setPrdTotal(Long prdTotal) {
		this.prdTotal = prdTotal;
	}

	public java.sql.Timestamp getStartDate() {
		return this.startDate;
	}
	public void setStartDate(java.sql.Timestamp startDate) {
		this.startDate = startDate;
	}

	//bi-directional many-to-one association to SmTbProduct
	public SmTbProduct getSmTbProduct() {
		return this.smTbProduct;
	}
	public void setSmTbProduct(SmTbProduct smTbProduct) {
		this.smTbProduct = smTbProduct;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("disSeq", getDisSeq())
			.toString();
	}
}