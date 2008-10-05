package com.shenming.sms.module.hibernateOrm;
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * The persistent class for the sm_tb_message_context database table.
 * 
 * @author BEA Workshop Studio
 */
public class SmTbMessageContext extends com.shenming.sms.base.bean.BaseBean implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private Integer smsId;
	private java.sql.Timestamp createDate;
	private Integer createUserId;
	private String smsContext;
	private String smsTitle;
	private java.util.Set<SmTbMessageQueue> smTbMessageQueues;

    public SmTbMessageContext() {
    }

	public Integer getSmsId() {
		return this.smsId;
	}
	public void setSmsId(Integer smsId) {
		this.smsId = smsId;
	}

	public java.sql.Timestamp getCreateDate() {
		return this.createDate;
	}
	public void setCreateDate(java.sql.Timestamp createDate) {
		this.createDate = createDate;
	}

	public Integer getCreateUserId() {
		return this.createUserId;
	}
	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}

	public String getSmsContext() {
		return this.smsContext;
	}
	public void setSmsContext(String smsContext) {
		this.smsContext = smsContext;
	}

	public String getSmsTitle() {
		return this.smsTitle;
	}
	public void setSmsTitle(String smsTitle) {
		this.smsTitle = smsTitle;
	}

	//bi-directional many-to-one association to SmTbMessageQueue
	public java.util.Set<SmTbMessageQueue> getSmTbMessageQueues() {
		return this.smTbMessageQueues;
	}
	public void setSmTbMessageQueues(java.util.Set<SmTbMessageQueue> smTbMessageQueues) {
		this.smTbMessageQueues = smTbMessageQueues;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("smsId", getSmsId())
			.toString();
	}
}