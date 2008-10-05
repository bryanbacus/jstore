package com.shenming.sms.module.hibernateOrm;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * The persistent class for the sm_tb_vip_account_detail_his database table.
 * 
 * @author BEA Workshop
 */
public class SmTbVipAccountDetailHi extends com.shenming.sms.base.bean.BaseBean implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private Integer idx;
	private int userId;
	private java.sql.Date vipChildBirthday;
	private String vipChildName;
	private String vipChildSex;

    public SmTbVipAccountDetailHi() {
    }

	public Integer getIdx() {
		return this.idx;
	}
	public void setIdx(Integer idx) {
		this.idx = idx;
	}

	public int getUserId() {
		return this.userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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

	public String getVipChildSex() {
		return this.vipChildSex;
	}
	public void setVipChildSex(String vipChildSex) {
		this.vipChildSex = vipChildSex;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SmTbVipAccountDetailHi)) {
			return false;
		}
		SmTbVipAccountDetailHi castOther = (SmTbVipAccountDetailHi)other;
		return new EqualsBuilder()
			.append(this.getIdx(), castOther.getIdx())
			.isEquals();
    }
    
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getIdx())
			.toHashCode();
    }   

	public String toString() {
		return new ToStringBuilder(this)
			.append("idx", getIdx())
			.toString();
	}
}