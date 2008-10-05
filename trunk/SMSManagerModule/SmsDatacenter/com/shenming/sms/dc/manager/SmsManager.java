package com.shenming.sms.dc.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.ConstraintViolationException;

import com.shenming.sms.dc.util.HibernateUtilEntity;
import com.shenming.sms.util.Tool;

public abstract class SmsManager extends Object{
	protected static Session session;
	protected static HibernateUtilEntity hibernateUtil;
	protected static boolean autoCloseSession = true;
	protected static String configPath = "hibernate.cfg.xml";
	
	public static void initialize(){
		if(SessionManager.getHibernateUtil() == null){
			log("[SmsManager] hibernateUtil is null! use new session");
			SessionManager.initialize();
			hibernateUtil = SessionManager.getHibernateUtil();
		}else {
			log("[SmsManager] Configpath: "+ SessionManager.getHibernateUtil().getConfigPath());
			log("[SmsManager] hibernateUtil is not null! use current session");
			if(configPath.equalsIgnoreCase(SessionManager.getHibernateUtil().getConfigPath())){
				log("[SmsManager] Config path is the same!");
				hibernateUtil = SessionManager.getHibernateUtil();
			}else{
				log("[SmsManager] Config path is different!");
				SessionManager.initialize();
				hibernateUtil = SessionManager.getHibernateUtil();
			}
		}
		
		//Initial common objects for query
		
	}
	
	public abstract void commonObjInit();
	
	public static Criteria getCriteria(Class c){
		session = hibernateUtil.currentSession();
		return session.createCriteria(c);
	}
	
	public static Session currentSession(){
		return  hibernateUtil.currentSession();
	}
	
	protected static void closeHibernateSession(){
		if(autoCloseSession) {
			log("[SmsManager] will close session!");
			hibernateUtil.closeSession();
			hibernateUtil.currentSession().getSessionFactory().close();
		}
	}

	/**
	 * @return the autoCloseSession
	 */
	public static boolean isAutoCloseSession() {
		return autoCloseSession;
	}

	/**
	 * @param autoCloseSession the autoCloseSession to set
	 */
	public static void setAutoCloseSession(boolean autoCloseSession) {
		SmsManager.autoCloseSession = autoCloseSession;
	}
	
	protected static void log(String msg){
		Tool.logDebug(msg,3);
	}
	
	public static synchronized void beginTransaction(){
		setAutoCloseSession(false);
		hibernateUtil.beginTransaction();
	}
	
	public static synchronized void rollbackTransaction() {
		setAutoCloseSession(true);
		log("[SmsManager] Rolling back the transaction!");
		hibernateUtil.rollbackTransaction();
	}
	
	public static synchronized void rollbackTransactionNotCloseSession(){
		log("[SmsManager] Rolling back the transaction!");
		hibernateUtil.rollbackTransaction();
	}
	
	public static synchronized void endTransaction() {
		setAutoCloseSession(true);
		hibernateUtil.commitTransaction();
	}
	
	public static synchronized void endTransactionNotCloseSession() {
		hibernateUtil.commitTransaction();
	}
	
	public static boolean isSqlKeyValidate(String sqlKey){
		if(sqlKey.indexOf(";") > 0 || sqlKey.indexOf("") > 0 ||
				sqlKey.indexOf("'") > 0 || sqlKey.indexOf("\"") > 0)
			return false;
		return true;
	}
	
	protected static Criteria addEqualCriteria(Criteria criteria, String key, Object value){
		if(Tool.isNotEmpty(value))
			criteria.add(Restrictions.eq(key, value));
		return criteria;
	}
	
	protected static Criteria addNotEqualCriteria(Criteria criteria, String key, Object value){
		if(Tool.isNotEmpty(value))
			criteria.add(Restrictions.ne(key, value));
		return criteria;
	}
	
	protected static Criteria addLtCriteria(Criteria criteria, String key, Object value){
		if(Tool.isNotEmpty(value))
			criteria.add(Restrictions.lt(key, value));
		return criteria;
	}
	
	protected static Criteria addLeCriteria(Criteria criteria, String key, Object value){
		if(Tool.isNotEmpty(value))
			criteria.add(Restrictions.le(key, value));
		return criteria;
	}
	
	protected static Criteria addGtCriteria(Criteria criteria, String key, Object value){
		if(Tool.isNotEmpty(value))
			criteria.add(Restrictions.gt(key, value));
		return criteria;
	}
	
	protected static Criteria addGeCriteria(Criteria criteria, String key, Object value){
		if(Tool.isNotEmpty(value))
			criteria.add(Restrictions.ge(key, value));
		return criteria;
	}
	
	protected static Criteria orderDesc(Criteria criteria, String key){
		return criteria.addOrder(Order.desc(key));
	}
	
	protected static Criteria orderAsc(Criteria criteria, String key){
		return criteria.addOrder(Order.asc(key));
	}
	
	public static boolean doCreate(Object object){
		try{
			session = currentSession();
			beginTransaction();
			session.save(object);
			endTransaction();
			return true;
		} catch(ConstraintViolationException e ){
			rollbackTransaction();
			return false;
		} catch (Exception e){
			rollbackTransaction();
			e.printStackTrace();
			return false;
		} finally {
			closeHibernateSession();
		}
	}
	
	public static boolean doCreateOrUpdate(Object object){
		try{
			session = currentSession();
			beginTransaction();
			session.saveOrUpdate(object);
			endTransaction();
		} catch(ConstraintViolationException e ){
			rollbackTransaction();
			return false;
		} catch (Exception e){
			rollbackTransaction();
			e.printStackTrace();
			return false;
		} finally {
			closeHibernateSession();
		}
		return true;
	}
	
	public static boolean doUpdate(Object object){
		try{
			session = currentSession();
			beginTransaction();
			session.update(object);
			endTransaction();
		} catch(ConstraintViolationException e ){
			rollbackTransaction();
			return false;
		} catch (Exception e){
			rollbackTransaction();
			e.printStackTrace();
			return false;
		} finally {
			closeHibernateSession();
		}
		return true;
	}
	
	public static boolean doDelete(Object object){
		try{
			session = currentSession();
			beginTransaction();
			session.delete(object);
			endTransaction();
		} catch(ConstraintViolationException e ){
			rollbackTransaction();
			return false;
		} catch (Exception e){
			rollbackTransaction();
			e.printStackTrace();
			return false;
		} finally {
			closeHibernateSession();
		}
		return true;
	}
	
	public static boolean doExecuteSQL(String sql){
		session = currentSession();
		Connection conn = session.connection();
		PreparedStatement ps = null;
		try {
			conn.setAutoCommit(false);
			log("[SmsManager] sql:" + sql);
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();

			conn.commit();
			conn.setAutoCommit(true);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			return false;
		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			closeHibernateSession();
		}
	}
	
	public static boolean doExecuteBatchSQL(List<String> sql){
		session = currentSession();
		Connection conn = session.connection();
		PreparedStatement ps = null;
		try {
			conn.setAutoCommit(false);
			Iterator iter = sql.iterator();
			while(iter.hasNext()){
				String sqlstr = (String)iter.next();
				log("[SmsManager] doing sql:" + sqlstr);
				ps = conn.prepareStatement(sqlstr);
				ps.executeUpdate();
			}
			conn.commit();
			conn.setAutoCommit(true);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			return false;
		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			closeHibernateSession();
		}
	}
	
}
