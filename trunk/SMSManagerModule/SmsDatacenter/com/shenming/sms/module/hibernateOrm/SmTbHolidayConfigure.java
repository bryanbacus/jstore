package com.shenming.sms.module.hibernateOrm;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * The persistent class for the sm_tb_holiday_configure database table.
 * 
 * @author BEA Workshop
 */
public class SmTbHolidayConfigure extends com.shenming.sms.base.bean.BaseBean implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private Integer idx;
	private String holidayChtName;
	private java.sql.Date holidayDate;
	private String holidayDescription;
	private String holidayName;
	private Boolean isEnable;

    public SmTbHolidayConfigure() {
    }

	public Integer getIdx() {
		return this.idx;
	}
	public void setIdx(Integer idx) {
		this.idx = idx;
	}

	public String getHolidayChtName() {
		return this.holidayChtName;
	}
	public void setHolidayChtName(String holidayChtName) {
		this.holidayChtName = holidayChtName;
	}

	public java.sql.Date getHolidayDate() {
		return this.holidayDate;
	}
	public void setHolidayDate(java.sql.Date holidayDate) {
		this.holidayDate = holidayDate;
	}

	public String getHolidayDescription() {
		return this.holidayDescription;
	}
	public void setHolidayDescription(String holidayDescription) {
		this.holidayDescription = holidayDescription;
	}

	public String getHolidayName() {
		return this.holidayName;
	}
	public void setHolidayName(String holidayName) {
		this.holidayName = holidayName;
	}

	public Boolean getIsEnable() {
		return this.isEnable;
	}
	public void setIsEnable(Boolean isEnable) {
		this.isEnable = isEnable;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SmTbHolidayConfigure)) {
			return false;
		}
		SmTbHolidayConfigure castOther = (SmTbHolidayConfigure)other;
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