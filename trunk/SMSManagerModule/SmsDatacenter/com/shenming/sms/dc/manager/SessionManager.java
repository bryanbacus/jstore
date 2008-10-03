/**
 * 
 */
package com.shenming.sms.dc.manager;

import com.shenming.sms.dc.util.HibernateUtilEntity;


/**
 * @author simon
 *
 */
public class SessionManager {
	public static HibernateUtilEntity hibernateUtil;
	
	public synchronized static void initialize(){
		hibernateUtil = new HibernateUtilEntity("hibernate.cfg.xml");
	}
	
	public synchronized static void initialize(String configPath){
		hibernateUtil = new HibernateUtilEntity(configPath);
	}

	/**
	 * @return the hibernateUtil
	 */
	public synchronized static HibernateUtilEntity getHibernateUtil() {
		return hibernateUtil;
	}

	/**
	 * @param hibernateUtil the hibernateUtil to set
	 */
	public static void setHibernateUtil(HibernateUtilEntity hibernateUtil) {
		SessionManager.hibernateUtil = hibernateUtil;
	}
}
