package com.shenming.sms.dc.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * 在程式中可以這麼使用HibernateUtil：
 * Session session = HibernateUtil.currentSession();
 * User user = (User) session.load(User.class, new Integer(1));
 * System.out.println(user.getName());
 * HibernateUtil.closeSession();
 */

public class HibernateUtil {

    private static Log log = LogFactory.getLog(HibernateUtil.class);
    private static String configPath;
    private static SessionFactory sessionFactory;
    public static final ThreadLocal session = new ThreadLocal();
    public static final ThreadLocal sessionTransaction = new ThreadLocal();
    
    public static void initialize() {
        try {
        	if(configPath == null){
        		System.out.println("Using default config path hibernate.cfg.xml");
	            // Create the SessionFactory
	            sessionFactory = new Configuration().configure().buildSessionFactory();
        	}else{
        		//Create the SessionFactory from configPath
        		System.out.println("Using specific config path " + configPath);
	            sessionFactory = new Configuration().configure(configPath).buildSessionFactory();
        	}
        } catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            log.error("Initial SessionFactory creation failed.", ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static void initialize(String configPath){
    	HibernateUtil.configPath = configPath;
    	HibernateUtil.initialize();
    }

    public static Session currentSession() {
        Session s = (Session) session.get();
        // Open a new Session, if this Thread has none yet
        if (s == null) {
            s = sessionFactory.openSession();
            session.set(s);
        }
        return s;
    }

    public static void closeSession() {
        Session s = (Session) session.get();
        if (s != null && s.isOpen())
            s.close();
        session.set(null);
    }

    /*
     * begin the transaction
     */
    public static void beginTransaction(){
        Transaction tx = (Transaction) sessionTransaction.get();
        try{
            if (tx == null){
                tx = currentSession().beginTransaction();
                sessionTransaction.set(tx);
            }
        }catch (HibernateException e){
        	e.printStackTrace();
        }
    }


    /*
     * close the transaction
     */
    public static void commitTransaction(){
        Transaction tx = (Transaction) sessionTransaction.get();
        try{
            if (tx != null && !tx.wasCommitted() && !tx.wasRolledBack())
                tx.commit();
            sessionTransaction.set(null);
        }catch (HibernateException e){
            e.printStackTrace();
        }
    }

    /*
     * for rollbacking
     */
    public static void rollbackTransaction(){
        Transaction tx = (Transaction) sessionTransaction.get();
        try{
        	sessionTransaction.set(null);
            if (tx != null && !tx.wasCommitted() && !tx.wasRolledBack()){
                tx.rollback();
            }
        }catch (HibernateException e){
            e.printStackTrace();
        }
    }

	/**
	 * @return the configPath
	 */
	public static String getConfigPath() {
		return configPath;
	}

	/**
	 * @param configPath the configPath to set
	 */
	public static void setConfigPath(String configPath) {
		HibernateUtil.configPath = configPath;
	}

    
    

}


