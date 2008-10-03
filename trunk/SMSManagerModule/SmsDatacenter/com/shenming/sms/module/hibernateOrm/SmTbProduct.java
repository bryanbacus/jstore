package com.shenming.sms.module.hibernateOrm;
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * The persistent class for the sm_tb_product database table.
 * 
 * @author BEA Workshop Studio
 */
public class SmTbProduct extends com.shenming.sms.base.bean.BaseBean implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private Integer prdId;
	private String detailDesc;
	private String formatDesc;
	private String name;
	private String prdPicFile;
	private Long price;
	private Long priceVip;
	private String sendArea;
	private String sendDesc;
	private String suplyStatus;
	private SmTbVipAccount smTbVipAccount;
	private SmTbProductGroup smTbProductGroup;
	private java.util.Set<SmTbSaleItem> smTbSaleItems;
	private java.util.Set<SmTbWeekDiscount> smTbWeekDiscounts;

    public SmTbProduct() {
    }

	public Integer getPrdId() {
		return this.prdId;
	}
	public void setPrdId(Integer prdId) {
		this.prdId = prdId;
	}

	public String getDetailDesc() {
		return this.detailDesc;
	}
	public void setDetailDesc(String detailDesc) {
		this.detailDesc = detailDesc;
	}

	public String getFormatDesc() {
		return this.formatDesc;
	}
	public void setFormatDesc(String formatDesc) {
		this.formatDesc = formatDesc;
	}

	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getPrdPicFile() {
		return this.prdPicFile;
	}
	public void setPrdPicFile(String prdPicFile) {
		this.prdPicFile = prdPicFile;
	}

	public Long getPrice() {
		return this.price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}

	public Long getPriceVip() {
		return this.priceVip;
	}
	public void setPriceVip(Long priceVip) {
		this.priceVip = priceVip;
	}

	public String getSendArea() {
		return this.sendArea;
	}
	public void setSendArea(String sendArea) {
		this.sendArea = sendArea;
	}

	public String getSendDesc() {
		return this.sendDesc;
	}
	public void setSendDesc(String sendDesc) {
		this.sendDesc = sendDesc;
	}

	public String getSuplyStatus() {
		return this.suplyStatus;
	}
	public void setSuplyStatus(String suplyStatus) {
		this.suplyStatus = suplyStatus;
	}

	//bi-directional many-to-one association to SmTbVipAccount
	public SmTbVipAccount getSmTbVipAccount() {
		return this.smTbVipAccount;
	}
	public void setSmTbVipAccount(SmTbVipAccount smTbVipAccount) {
		this.smTbVipAccount = smTbVipAccount;
	}

	//bi-directional many-to-one association to SmTbProductGroup
	public SmTbProductGroup getSmTbProductGroup() {
		return this.smTbProductGroup;
	}
	public void setSmTbProductGroup(SmTbProductGroup smTbProductGroup) {
		this.smTbProductGroup = smTbProductGroup;
	}

	//bi-directional many-to-one association to SmTbSaleItem
	public java.util.Set<SmTbSaleItem> getSmTbSaleItems() {
		return this.smTbSaleItems;
	}
	public void setSmTbSaleItems(java.util.Set<SmTbSaleItem> smTbSaleItems) {
		this.smTbSaleItems = smTbSaleItems;
	}

	//bi-directional many-to-one association to SmTbWeekDiscount
	public java.util.Set<SmTbWeekDiscount> getSmTbWeekDiscounts() {
		return this.smTbWeekDiscounts;
	}
	public void setSmTbWeekDiscounts(java.util.Set<SmTbWeekDiscount> smTbWeekDiscounts) {
		this.smTbWeekDiscounts = smTbWeekDiscounts;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("prdId", getPrdId())
			.toString();
	}
}