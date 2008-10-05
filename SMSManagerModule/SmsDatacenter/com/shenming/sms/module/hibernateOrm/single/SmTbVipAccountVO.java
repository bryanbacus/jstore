package com.shenming.sms.module.hibernateOrm.single;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * The persistent class for the sm_tb_vip_account database table.
 * 
 * @author BEA Workshop
 */
public class SmTbVipAccountVO extends com.shenming.sms.base.bean.BaseBean implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private Integer userId;
	private String address;
	private java.sql.Timestamp birthday;
	private String blood;
	private long buySum;
	private java.sql.Timestamp crDate;
	private Integer errorCnt;
	private String fovarite;
	private String isAccountActive;
	private String isValidVip;
	private String job;
	private String mailAddr;
	private String marrage;
	private String mobile;
	private Integer owner;
	private String password;
	private String phone;
	private String sex;
	private String sid;
	private String store;
	private String storeEmployeeName;
	private String username;
	private String vipChtName;
	private String vipEngName;
	private String vipLevel;

    public SmTbVipAccountVO() {
    }

	public Integer getUserId() {
		return this.userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getAddress() {
		return this.address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public java.sql.Timestamp getBirthday() {
		return this.birthday;
	}
	public void setBirthday(java.sql.Timestamp birthday) {
		this.birthday = birthday;
	}

	public String getBlood() {
		return this.blood;
	}
	public void setBlood(String blood) {
		this.blood = blood;
	}

	public long getBuySum() {
		return this.buySum;
	}
	public void setBuySum(long buySum) {
		this.buySum = buySum;
	}

	public java.sql.Timestamp getCrDate() {
		return this.crDate;
	}
	public void setCrDate(java.sql.Timestamp crDate) {
		this.crDate = crDate;
	}

	public Integer getErrorCnt() {
		return this.errorCnt;
	}
	public void setErrorCnt(Integer errorCnt) {
		this.errorCnt = errorCnt;
	}

	public String getFovarite() {
		return this.fovarite;
	}
	public void setFovarite(String fovarite) {
		this.fovarite = fovarite;
	}

	public String getIsAccountActive() {
		return this.isAccountActive;
	}
	public void setIsAccountActive(String isAccountActive) {
		this.isAccountActive = isAccountActive;
	}

	public String getIsValidVip() {
		return this.isValidVip;
	}
	public void setIsValidVip(String isValidVip) {
		this.isValidVip = isValidVip;
	}

	public String getJob() {
		return this.job;
	}
	public void setJob(String job) {
		this.job = job;
	}

	public String getMailAddr() {
		return this.mailAddr;
	}
	public void setMailAddr(String mailAddr) {
		this.mailAddr = mailAddr;
	}

	public String getMarrage() {
		return this.marrage;
	}
	public void setMarrage(String marrage) {
		this.marrage = marrage;
	}

	public String getMobile() {
		return this.mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Integer getOwner() {
		return this.owner;
	}
	public void setOwner(Integer owner) {
		this.owner = owner;
	}

	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return this.phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getSex() {
		return this.sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getSid() {
		return this.sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getStore() {
		return this.store;
	}
	public void setStore(String store) {
		this.store = store;
	}

	public String getStoreEmployeeName() {
		return this.storeEmployeeName;
	}
	public void setStoreEmployeeName(String storeEmployeeName) {
		this.storeEmployeeName = storeEmployeeName;
	}

	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getVipChtName() {
		return this.vipChtName;
	}
	public void setVipChtName(String vipChtName) {
		this.vipChtName = vipChtName;
	}

	public String getVipEngName() {
		return this.vipEngName;
	}
	public void setVipEngName(String vipEngName) {
		this.vipEngName = vipEngName;
	}

	public String getVipLevel() {
		return this.vipLevel;
	}
	public void setVipLevel(String vipLevel) {
		this.vipLevel = vipLevel;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SmTbVipAccountVO)) {
			return false;
		}
		SmTbVipAccountVO castOther = (SmTbVipAccountVO)other;
		return new EqualsBuilder()
			.append(this.getUserId(), castOther.getUserId())
			.isEquals();
    }
    
	public int hashCode() {
		return new HashCodeBuilder()
			.append(getUserId())
			.toHashCode();
    }   

	public String toString() {
		return new ToStringBuilder(this)
			.append("userId", getUserId())
			.toString();
	}
}