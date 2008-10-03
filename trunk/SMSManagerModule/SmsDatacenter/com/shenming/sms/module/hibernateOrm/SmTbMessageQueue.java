package com.shenming.sms.module.hibernateOrm;
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * The persistent class for the sm_tb_message_queue database table.
 * 
 * @author BEA Workshop Studio
 */
public class SmTbMessageQueue extends com.shenming.sms.base.bean.BaseBean implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private Integer idx;
	private java.sql.Timestamp createDate;
	private Integer createUserId;
	private String mobile;
	private Integer recipientId;
	private java.sql.Timestamp sendDate;
	private String status;
	private java.util.Set<SmTbMessageLog> smTbMessageLogs;
	private SmTbMessageContext smTbMessageContext;

    public SmTbMessageQueue() {
    }

	public Integer getIdx() {
		return this.idx;
	}
	public void setIdx(Integer idx) {
		this.idx = idx;
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

	public String getMobile() {
		return this.mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Integer getRecipientId() {
		return this.recipientId;
	}
	public void setRecipientId(Integer recipientId) {
		this.recipientId = recipientId;
	}

	public java.sql.Timestamp getSendDate() {
		return this.sendDate;
	}
	public void setSendDate(java.sql.Timestamp sendDate) {
		this.sendDate = sendDate;
	}

	public String getStatus() {
		return this.status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	//bi-directional many-to-one association to SmTbMessageLog
	public java.util.Set<SmTbMessageLog> getSmTbMessageLogs() {
		return this.smTbMessageLogs;
	}
	public void setSmTbMessageLogs(java.util.Set<SmTbMessageLog> smTbMessageLogs) {
		this.smTbMessageLogs = smTbMessageLogs;
	}

	//bi-directional many-to-one association to SmTbMessageContext
	public SmTbMessageContext getSmTbMessageContext() {
		return this.smTbMessageContext;
	}
	public void setSmTbMessageContext(SmTbMessageContext smTbMessageContext) {
		this.smTbMessageContext = smTbMessageContext;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("idx", getIdx())
			.toString();
	}
}