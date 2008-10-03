package com.shenming.sms.module.hibernateOrm;
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * The persistent class for the sm_tb_vip_account_detail database table.
 * 
 * @author BEA Workshop Studio
 */
public class SmTbVipAccountDetail extends com.shenming.sms.base.bean.BaseBean implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private Integer idx;
	private java.sql.Date vipChildBirthday;
	private String vipChildName;
	private SmTbVipAccount smTbVipAccount;
	private String vipChildSex;

    public SmTbVipAccountDetail() {
    }

	public Integer getIdx() {
		return this.idx;
	}
	public void setIdx(Integer idx) {
		this.idx = idx;
	}

	public java.sql.Date getVipChildBirthday() {
		return this.vipChildBirthday;
	}
	public void setVipChildBirthday(java.sql.Date vipChildBirthday) {
		this.vipChildBirthday = vipChildBirthday;
	}

	public String getVipChildName() {
		return this.vipChildName;
	}
	public void setVipChildName(String vipChildName) {
		this.vipChildName = vipChildName;
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
			.append("idx", getIdx())
			.toString();
	}

	public String getVipChildSex() {
		return vipChildSex;
	}

	public void setVipChildSex(String vipChildSex) {
		this.vipChildSex = vipChildSex;
	}
}