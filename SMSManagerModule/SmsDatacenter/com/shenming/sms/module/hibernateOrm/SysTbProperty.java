package com.shenming.sms.module.hibernateOrm;
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * The persistent class for the sys_tb_properties database table.
 * 
 * @author BEA Workshop Studio
 */
public class SysTbProperty extends com.shenming.sms.base.bean.BaseBean implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private Integer idx;
	private String description;
	private String keyGroup;
	private String keyName;
	private String keyValue;
	private java.sql.Date modifyDate;

    public SysTbProperty() {
    }

	public Integer getIdx() {
		return this.idx;
	}
	public void setIdx(Integer idx) {
		this.idx = idx;
	}

	public String getDescription() {
		return this.description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String getKeyGroup() {
		return this.keyGroup;
	}
	public void setKeyGroup(String keyGroup) {
		this.keyGroup = keyGroup;
	}

	public String getKeyName() {
		return this.keyName;
	}
	public void setKeyName(String keyName) {
		this.keyName = keyName;
	}

	public String getKeyValue() {
		return this.keyValue;
	}
	public void setKeyValue(String keyValue) {
		this.keyValue = keyValue;
	}

	public java.sql.Date getModifyDate() {
		return this.modifyDate;
	}
	public void setModifyDate(java.sql.Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("idx", getIdx())
			.toString();
	}
}