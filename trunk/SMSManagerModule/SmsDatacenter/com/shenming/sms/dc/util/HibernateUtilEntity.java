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

public class HibernateUtilEntity {
	
	public HibernateUtilEntity currentInstance;
    private Log log = LogFactory.getLog(HibernateUtilEntity.class);
    private String configPath;
    private SessionFactory sessionFactory;
    public final ThreadLocal session = new ThreadLocal();
    public final ThreadLocal sessionTransaction = new ThreadLocal();
    
    private HibernateUtilEntity(){
    	
    }
    
    public HibernateUtilEntity(String configPath){
    	this.configPath = configPath;
    	this.initialize();
    }
    
    public void initialize() {
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
    
    public void initialze(String configPath){
    	this.configPath = configPath;
    	initialize();
    }

    public Session currentSession() {
        Session s = (Session) session.get();
        // Open a new Session, if this Thread has none yet
        if (s == null) {
            s = sessionFactory.openSession();
            session.set(s);
        }
        return s;
    }

    public void closeSession() {
        Session s = (Session) session.get();
        if (s != null && s.isOpen())
            s.close();
        session.set(null);
        session.remove();
    }

    /*
     * begin the transaction
     */
    public void beginTransaction(){
        Transaction tx = (Transaction) sessionTransaction.get();
//        try{
            if (tx == null){
                tx = currentSession().beginTransaction();
                sessionTransaction.set(tx);
            }
//        }catch (HibernateException e){
//        	e.printStackTrace();
//        }
    }


    /*
     * close the transaction
     */
    public void commitTransaction(){
        Transaction tx = (Transaction) sessionTransaction.get();
//        try{
            if (tx != null && !tx.wasCommitted() && !tx.wasRolledBack())
                tx.commit();
            sessionTransaction.set(null);
//        }catch (HibernateException e){
//            e.printStackTrace();
//        }
    }

    /*
     * for rollbacking
     */
    public void rollbackTransaction(){
        Transaction tx = (Transaction) sessionTransaction.get();
//        try{
        	sessionTransaction.set(null);
            if (tx != null && !tx.wasCommitted() && !tx.wasRolledBack()){
                tx.rollback();
            }
//        }catch (HibernateException e){
//            e.printStackTrace();
//        }
    }

	/**
	 * @return the configPath
	 */
	public String getConfigPath() {
		return configPath;
	}

	/**
	 * @param configPath the configPath to set
	 */
	public void setConfigPath(String configPath) {
		configPath = configPath;
	}

	/**
	 * @return the currentInstance
	 */
	public HibernateUtilEntity getCurrentInstance() {
		return currentInstance;
	}

	/**
	 * @param currentInstance the currentInstance to set
	 */
	public void setCurrentInstance(HibernateUtilEntity currentInstance) {
		this.currentInstance = currentInstance;
	}

    
    

}


