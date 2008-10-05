package com.shenming.sms.module.hibernateOrm;
import java.io.Serializable;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * The persistent class for the sm_tb_sql_rule database table.
 * 
 * @author BEA Workshop
 */
public class SmTbSqlRule extends com.shenming.sms.base.bean.BaseBean implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;
	private Integer idx;
	private Boolean isTransaction;
	private Integer nextRuleIdx;
	private String ruleDescription;
	private int ruleIdx;
	private String ruleModule;
	private String ruleName;
	private String ruleSql;

    public SmTbSqlRule() {
    }

	public Integer getIdx() {
		return this.idx;
	}
	public void setIdx(Integer idx) {
		this.idx = idx;
	}

	public Boolean getIsTransaction() {
		return this.isTransaction;
	}
	public void setIsTransaction(Boolean isTransaction) {
		this.isTransaction = isTransaction;
	}

	public Integer getNextRuleIdx() {
		return this.nextRuleIdx;
	}
	public void setNextRuleIdx(Integer nextRuleIdx) {
		this.nextRuleIdx = nextRuleIdx;
	}

	public String getRuleDescription() {
		return this.ruleDescription;
	}
	public void setRuleDescription(String ruleDescription) {
		this.ruleDescription = ruleDescription;
	}

	public int getRuleIdx() {
		return this.ruleIdx;
	}
	public void setRuleIdx(int ruleIdx) {
		this.ruleIdx = ruleIdx;
	}

	public String getRuleModule() {
		return this.ruleModule;
	}
	public void setRuleModule(String ruleModule) {
		this.ruleModule = ruleModule;
	}

	public String getRuleName() {
		return this.ruleName;
	}
	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}

	public String getRuleSql() {
		return this.ruleSql;
	}
	public void setRuleSql(String ruleSql) {
		this.ruleSql = ruleSql;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SmTbSqlRule)) {
			return false;
		}
		SmTbSqlRule castOther = (SmTbSqlRule)other;
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