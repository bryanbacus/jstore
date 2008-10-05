package com.shenming.sms.module.hibernateOrm;
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * The persistent class for the sm_tb_message_log database table.
 * 
 * @author BEA Workshop Studio
 */
public class SmTbMessageLog extends com.shenming.sms.base.bean.BaseBean implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private Integer idx;
	private java.sql.Timestamp createDate;
	private Integer createUserId;
	private String createUserName;
	private String log;
	private SmTbMessageQueue smTbMessageQueue;

    public SmTbMessageLog() {
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

	public String getCreateUserName() {
		return this.createUserName;
	}
	public void setCreateUserName(String createUserName) {
		this.createUserName = createUserName;
	}

	public String getLog() {
		return this.log;
	}
	public void setLog(String log) {
		this.log = log;
	}

	//bi-directional many-to-one association to SmTbMessageQueue
	public SmTbMessageQueue getSmTbMessageQueue() {
		return this.smTbMessageQueue;
	}
	public void setSmTbMessageQueue(SmTbMessageQueue smTbMessageQueue) {
		this.smTbMessageQueue = smTbMessageQueue;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("idx", getIdx())
			.toString();
	}
}