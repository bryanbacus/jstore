package com.shenming.sms.module.hibernateOrm;
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * The persistent class for the sm_tb_vip_account database table.
 * 
 * @author BEA Workshop Studio
 */
public class SmTbVipAccount extends com.shenming.sms.base.bean.BaseBean implements Serializable {
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
	private String password;
	private String phone;
	private String sex;
	private String username;
	private String vipChtName;
	private String vipEngName;
	private String sid;
	private String store;
	private String storeEmployeeName;
	private String vipLevel;
	private java.util.Set<SmTbAccountGroup> smTbAccountGroups;
	private java.util.Set<SmTbAccountPrepay> smTbAccountPrepays1;
	private java.util.Set<SmTbAccountPrepay> smTbAccountPrepays2;
	private java.util.Set<SmTbAccountPrepay> smTbAccountPrepays3;
	private java.util.Set<SmTbProduct> smTbProducts;
	private java.util.Set<SmTbProductGroup> smTbProductGroups;
	private java.util.Set<SmTbSaleItem> smTbSaleItems1;
	private java.util.Set<SmTbSaleItem> smTbSaleItems2;
	private java.util.Set<SmTbSaleRecord> smTbSaleRecords1;
	private java.util.Set<SmTbSaleRecord> smTbSaleRecords2;
	private SmTbVipAccount smTbVipAccount;
	private java.util.Set<SmTbVipAccount> smTbVipAccounts;
	private java.util.Set<SmTbVipAccountDetail> smTbVipAccountDetails;

    public SmTbVipAccount() {
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

	//bi-directional many-to-one association to SmTbAccountGroup
	public java.util.Set<SmTbAccountGroup> getSmTbAccountGroups() {
		return this.smTbAccountGroups;
	}
	public void setSmTbAccountGroups(java.util.Set<SmTbAccountGroup> smTbAccountGroups) {
		this.smTbAccountGroups = smTbAccountGroups;
	}

	//bi-directional many-to-one association to SmTbAccountPrepay
	public java.util.Set<SmTbAccountPrepay> getSmTbAccountPrepays1() {
		return this.smTbAccountPrepays1;
	}
	public void setSmTbAccountPrepays1(java.util.Set<SmTbAccountPrepay> smTbAccountPrepays1) {
		this.smTbAccountPrepays1 = smTbAccountPrepays1;
	}

	//bi-directional many-to-one association to SmTbAccountPrepay
	public java.util.Set<SmTbAccountPrepay> getSmTbAccountPrepays2() {
		return this.smTbAccountPrepays2;
	}
	public void setSmTbAccountPrepays2(java.util.Set<SmTbAccountPrepay> smTbAccountPrepays2) {
		this.smTbAccountPrepays2 = smTbAccountPrepays2;
	}

	//bi-directional many-to-one association to SmTbAccountPrepay
	public java.util.Set<SmTbAccountPrepay> getSmTbAccountPrepays3() {
		return this.smTbAccountPrepays3;
	}
	public void setSmTbAccountPrepays3(java.util.Set<SmTbAccountPrepay> smTbAccountPrepays3) {
		this.smTbAccountPrepays3 = smTbAccountPrepays3;
	}

	//bi-directional many-to-one association to SmTbProduct
	public java.util.Set<SmTbProduct> getSmTbProducts() {
		return this.smTbProducts;
	}
	public void setSmTbProducts(java.util.Set<SmTbProduct> smTbProducts) {
		this.smTbProducts = smTbProducts;
	}

	//bi-directional many-to-one association to SmTbProductGroup
	public java.util.Set<SmTbProductGroup> getSmTbProductGroups() {
		return this.smTbProductGroups;
	}
	public void setSmTbProductGroups(java.util.Set<SmTbProductGroup> smTbProductGroups) {
		this.smTbProductGroups = smTbProductGroups;
	}

	//bi-directional many-to-one association to SmTbSaleItem
	public java.util.Set<SmTbSaleItem> getSmTbSaleItems1() {
		return this.smTbSaleItems1;
	}
	public void setSmTbSaleItems1(java.util.Set<SmTbSaleItem> smTbSaleItems1) {
		this.smTbSaleItems1 = smTbSaleItems1;
	}

	//bi-directional many-to-one association to SmTbSaleItem
	public java.util.Set<SmTbSaleItem> getSmTbSaleItems2() {
		return this.smTbSaleItems2;
	}
	public void setSmTbSaleItems2(java.util.Set<SmTbSaleItem> smTbSaleItems2) {
		this.smTbSaleItems2 = smTbSaleItems2;
	}

	//bi-directional many-to-one association to SmTbSaleRecord
	public java.util.Set<SmTbSaleRecord> getSmTbSaleRecords1() {
		return this.smTbSaleRecords1;
	}
	public void setSmTbSaleRecords1(java.util.Set<SmTbSaleRecord> smTbSaleRecords1) {
		this.smTbSaleRecords1 = smTbSaleRecords1;
	}

	//bi-directional many-to-one association to SmTbSaleRecord
	public java.util.Set<SmTbSaleRecord> getSmTbSaleRecords2() {
		return this.smTbSaleRecords2;
	}
	public void setSmTbSaleRecords2(java.util.Set<SmTbSaleRecord> smTbSaleRecords2) {
		this.smTbSaleRecords2 = smTbSaleRecords2;
	}

	//bi-directional many-to-one association to SmTbVipAccount
	public SmTbVipAccount getSmTbVipAccount() {
		return this.smTbVipAccount;
	}
	public void setSmTbVipAccount(SmTbVipAccount smTbVipAccount) {
		this.smTbVipAccount = smTbVipAccount;
	}

	//bi-directional many-to-one association to SmTbVipAccount
	public java.util.Set<SmTbVipAccount> getSmTbVipAccounts() {
		return this.smTbVipAccounts;
	}
	public void setSmTbVipAccounts(java.util.Set<SmTbVipAccount> smTbVipAccounts) {
		this.smTbVipAccounts = smTbVipAccounts;
	}

	//bi-directional many-to-one association to SmTbVipAccountDetail
	public java.util.Set<SmTbVipAccountDetail> getSmTbVipAccountDetails() {
		return this.smTbVipAccountDetails;
	}
	public void setSmTbVipAccountDetails(java.util.Set<SmTbVipAccountDetail> smTbVipAccountDetails) {
		this.smTbVipAccountDetails = smTbVipAccountDetails;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("userId", getUserId())
			.toString();
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

	public String getStoreEmployeeName() {
		return storeEmployeeName;
	}

	public void setStoreEmployeeName(String storeEmployeeName) {
		this.storeEmployeeName = storeEmployeeName;
	}

	public String getVipLevel() {
		return vipLevel;
	}

	public void setVipLevel(String vipLevel) {
		this.vipLevel = vipLevel;
	}
}