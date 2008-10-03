package com.shenming.sms.dc.manager;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.shenming.sms.module.hibernateOrm.SmTbAccountGroup;
import com.shenming.sms.module.hibernateOrm.SmTbSqlRule;
import com.shenming.sms.util.Tool;

public class SqlRuleManager extends SmsManager {

	static{
		SmsManager.initialize();
	}
	
	@Override
	public void commonObjInit() {
		// TODO Auto-generated method stub

	}
	
	public static SmTbSqlRule getSmTbSqlRule(Integer idx){
		try{
			session = currentSession();
			Criteria criteria = session.createCriteria(SmTbSqlRule.class);
			criteria.add(Restrictions.eq("idx", idx));
			return (SmTbSqlRule)criteria.uniqueResult();
		} finally {
			closeHibernateSession();
		}
	}
	
	public static List<SmTbSqlRule> getSmTbSqlRule(SmTbSqlRule smTbSqlRule){
		try{
			session = currentSession();
			Criteria criteria = session.createCriteria(SmTbSqlRule.class);
			
			addEqualCriteria(criteria, "idx", smTbSqlRule.getIdx());
			addEqualCriteria(criteria, "ruleModule", smTbSqlRule.getRuleModule());
			addEqualCriteria(criteria, "ruleName", smTbSqlRule.getRuleName());
			addEqualCriteria(criteria, "ruleIdx", smTbSqlRule.getRuleIdx());
			addEqualCriteria(criteria, "isTransaction", smTbSqlRule.getIsTransaction());
			addEqualCriteria(criteria, "nextRuleIdx", smTbSqlRule.getNextRuleIdx());
			
			return (List<SmTbSqlRule>)criteria.list();
		} finally {
			closeHibernateSession();
		}
	}

}
