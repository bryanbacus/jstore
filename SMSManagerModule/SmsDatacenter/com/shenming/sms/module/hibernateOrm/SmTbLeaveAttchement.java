package com.shenming.sms.module.hibernateOrm;
import java.io.Serializable;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * The persistent class for the sm_tb_leave_attchement database table.
 * 
 * @author BEA Workshop Studio
 */
public class SmTbLeaveAttchement extends com.shenming.sms.base.bean.BaseBean implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private Integer applyId;
	private java.sql.Date createDate;
	private String description;
	private String fileName;
	private String filePath;

    public SmTbLeaveAttchement() {
    }

	public Integer getApplyId() {
		return this.applyId;
	}
	public void setApplyId(Integer applyId) {
		this.applyId = applyId;
	}

	public java.sql.Date getCreateDate() {
		return this.createDate;
	}
	public void setCreateDate(java.sql.Date createDate) {
		this.createDate = createDate;
	}

	public String getDescription() {
		return this.description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String getFileName() {
		return this.fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return this.filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String toString() {
		return new ToStringBuilder(this)
			.append("applyId", getApplyId())
			.toString();
	}
}