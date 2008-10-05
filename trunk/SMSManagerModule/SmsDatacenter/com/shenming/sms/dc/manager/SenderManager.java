package com.shenming.sms.dc.manager;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import com.shenming.sms.module.hibernateOrm.SmTbMessageContext;
import com.shenming.sms.module.hibernateOrm.SmTbMessageLog;
import com.shenming.sms.module.hibernateOrm.SmTbMessageQueue;
import com.shenming.sms.module.hibernateOrm.SmTbVipAccount;
import com.shenming.sms.module.hibernateOrm.SmTbVipAccountDetail;
import com.shenming.sms.util.DateUtil;
import com.shenming.sms.util.Tool;

public class SenderManager extends SmsManager{

	static{
		SmsManager.initialize();
	}
	
	@Override
	public void commonObjInit() {
		// TODO Auto-generated method stub
		
	}
	
	/***** Message Context *****/
	public static boolean doCreateMessageContext(String smsTitle, String smsContext, 
			java.sql.Date createDate, int createUserId, java.util.List<SmTbMessageQueue> smTbMessageQueues){
		SmTbMessageContext context = new SmTbMessageContext();
		context.setSmsId(1); //This column will auto generate by MySQL
		context.setSmsTitle(smsTitle);
		context.setSmsContext(smsContext);
		context.setCreateUserId(createUserId);
		context.setCreateDate(new Timestamp(createDate.getTime()));
		try{
			session = currentSession();
			beginTransaction();
			session.save(context);
			Iterator iter = smTbMessageQueues.iterator();
			while(iter.hasNext()){
				SmTbMessageQueue vo = (SmTbMessageQueue)iter.next();
				vo.setSmTbMessageContext(context);
				session.save(vo);
				
				SmTbMessageLog log = new SmTbMessageLog();
				log.setIdx(1); //Index will auto generate by MySQL
				log.setCreateDate(DateUtil.getSystemSqlTimestamp());
				log.setCreateUserId(createUserId);
				log.setCreateUserName("SMS WEB");
				log.setLog("Create SMS message context of vip: "+ vo.getRecipientId()+" by user:" + createUserId);
				log.setSmTbMessageQueue(vo);
				session.save(log);
			}
			
			endTransaction();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			rollbackTransaction();
		} finally {
			closeHibernateSession();
		}
		
		return false;
	}
	
	/***** Message Queue *****/
	public static List<SmTbMessageQueue> retrieveAllMessageQueue(){
		try{
			session = currentSession();
			Criteria criteria = session.createCriteria(SmTbMessageQueue.class);
			return (List<SmTbMessageQueue>)criteria.list();
		} finally {
			closeHibernateSession();
		}
	}
	
	public static List<SmTbMessageQueue> retrieveMessageQueue(String status){
		try{
			session = currentSession();
			Criteria criteria = session.createCriteria(SmTbMessageQueue.class);
			addEqualCriteria(criteria, "status", status);
			
			return (List<SmTbMessageQueue>)criteria.list();
		} finally {
			closeHibernateSession();
		}
	}
	
	public static List<SmTbMessageQueue> retrieveMessageQueueToProcess(String status){
		try{
			session = currentSession();
			Criteria criteria = session.createCriteria(SmTbMessageQueue.class);
			addEqualCriteria(criteria, "status", status);
			List<SmTbMessageQueue> list = (List<SmTbMessageQueue>)criteria.list();
			Iterator iter = list.iterator();
			List<SmTbMessageQueue> newlist = new ArrayList();
			while(iter.hasNext()){
				SmTbMessageQueue queue= (SmTbMessageQueue)iter.next();
				if(queue.getSendDate().getTime() < new java.util.Date().getTime()){
					queue.setStatus("P");
					doUpdate(queue);
					newlist.add(queue);
				}
			}
			return newlist;
		} finally {
			closeHibernateSession();
		}
	}
	
	public static SmTbMessageQueue retrieveMessageQueueById(int idx){
		try{
			session = currentSession();
			Criteria criteria = session.createCriteria(SmTbMessageQueue.class);
			addEqualCriteria(criteria, "idx",idx);
			return (SmTbMessageQueue)criteria.uniqueResult();
		} finally {
			closeHibernateSession();
		}
	}
	
	public static List<SmTbMessageQueue> retrieveMessageQueueByCreateUserId(int userId){
		try{
			session = currentSession();
			Criteria criteria = session.createCriteria(SmTbMessageQueue.class);
			addEqualCriteria(criteria, "createUserId",userId);
			return (List<SmTbMessageQueue>)criteria.list();
		} finally {
			closeHibernateSession();
		}
	}
	
	public static List<SmTbMessageQueue> retrieveMessageQueue(
			int createUserId, int recipientId, String status,
			Timestamp createDateStart, Timestamp createDateEnd, 
			Timestamp sendDateStart, Timestamp sendDateEnd){
		try{
			session = currentSession();
			Criteria criteria = session.createCriteria(SmTbMessageQueue.class);
			if(createUserId > 0)
				addEqualCriteria(criteria, "createUserId",createUserId);
			if(recipientId > 0)
				addEqualCriteria(criteria, "recipientId",recipientId);
			if(Tool.isNotEmpty(status))
				addEqualCriteria(criteria, "status",status);
			if(createDateStart != null)
				addGeCriteria(criteria, "createDate", createDateStart);
			if(createDateEnd != null)
				addLeCriteria(criteria, "createDate", createDateEnd);
			if(createDateStart != null)
				addGeCriteria(criteria, "sendDate", sendDateStart);
			if(createDateEnd != null)
				addLeCriteria(criteria, "sendDate", sendDateEnd);
			
			return (List<SmTbMessageQueue>)criteria.list();
		} finally {
			closeHibernateSession();
		}
	}

	public static List<SmTbMessageQueue> querySmsHistory(
			int vipId, String mobileNbr, String msgTitle, String status,
			String createDateStart, String createDateEnd,
			String sendDateStart, String sendDateEnd) {
		return null;
	}
	
	/**** Message Log ****/
	public static boolean saveMessageOperationLog(int createUserId, String createUserName, String msg){
		SmTbMessageLog log = new SmTbMessageLog();
		log.setIdx(1); //Index will auto generate by MySQL
		log.setCreateDate(DateUtil.getSystemSqlTimestamp());
		log.setCreateUserId(createUserId);
		log.setCreateUserName(createUserName);
		log.setLog(msg);
		
		return doCreate(log);
		
	}
	
	/********* Batch Insert SMS *********/
	
	/**
	 * 
	 */
	public static List<SmTbMessageQueue> convertSmTbMessageQueueByVipChildSex(String vipChildSex, int userId, String context, 
			Date sendDate){//, List<SmTbMessageQueue> smTbMessageQueues){
		SmsVipManager.initialize();
		List<SmTbVipAccountDetail> children = SmsVipManager.retrieveChildByChildSex(vipChildSex);
		List<SmTbMessageQueue> msgQueue = new ArrayList<SmTbMessageQueue>();
		Iterator iter = children.iterator();
		while(iter.hasNext()){
			SmTbVipAccountDetail child = (SmTbVipAccountDetail)iter.next();
			SmTbMessageQueue vo = new SmTbMessageQueue();
			vo.setIdx(1);
			vo.setCreateUserId(userId);
			vo.setMobile(child.getSmTbVipAccount().getMobile());
			vo.setRecipientId(child.getSmTbVipAccount().getUserId());
			vo.setSendDate(new Timestamp(sendDate.getTime()));
			vo.setStatus("I");
			vo.setCreateDate(new Timestamp(new java.util.Date().getTime()));
			msgQueue.add(vo);
		}
		
		return msgQueue;
	}
	
	public static List<SmTbMessageQueue> convertSmTbMessageQueueByVipGroup(
			int optionVipId, int userId, String context, Date sendDate){
		SmsVipManager.initialize();
		List<SmTbVipAccount> vips = SmsVipManager.retrieveUserByOwnerId(optionVipId);
		List<SmTbMessageQueue> msgQueue = new ArrayList<SmTbMessageQueue>();
		Iterator iter = vips.iterator();
		while(iter.hasNext()){
			SmTbVipAccount vip = (SmTbVipAccount)iter.next();
			SmTbMessageQueue vo = new SmTbMessageQueue();
			vo.setIdx(1);
			vo.setCreateUserId(userId);
			vo.setMobile(vip.getMobile());
			vo.setRecipientId(vip.getUserId());
			vo.setSendDate(new Timestamp(sendDate.getTime()));
			vo.setStatus("I");
			vo.setCreateDate(new Timestamp(new java.util.Date().getTime()));
			msgQueue.add(vo);
		}
		
		return msgQueue;
	}
	
	public static List<SmTbMessageQueue> convertSmTbMessageQueueByAllVip(
			int userId, String context, Date sendDate){
		SmsVipManager.initialize();
		List<SmTbVipAccount> vips = SmsVipManager.retrieveAllUser();
		List<SmTbMessageQueue> msgQueue = new ArrayList<SmTbMessageQueue>();
		Iterator iter = vips.iterator();
		while(iter.hasNext()){
			SmTbVipAccount vip = (SmTbVipAccount)iter.next();
			SmTbMessageQueue vo = new SmTbMessageQueue();
			vo.setIdx(1);
			vo.setCreateUserId(userId);
			vo.setMobile(vip.getMobile());
			vo.setRecipientId(vip.getUserId());
			vo.setSendDate(new Timestamp(sendDate.getTime()));
			vo.setStatus("I");
			vo.setCreateDate(new Timestamp(new java.util.Date().getTime()));
			msgQueue.add(vo);
		}
		
		return msgQueue;
	}
	
	/**
	 * Batch insert order by child's sex
	 * @param vipChildSex
	 * @param userId
	 * @param context
	 * @param smTbMessageQueues
	 * @return
	 */
	public static boolean insertMessageByVipChildSex(String vipChildSex, int userId, String context, 
			Date sendDate, List<SmTbMessageQueue> smTbMessageQueues){
		SmsVipManager.initialize();
//		List<SmTbVipAccountDetail> children = SmsVipManager.retrieveChildByChildSex(vipChildSex);
//		List<SmTbMessageQueue> msgQueue = new ArrayList<SmTbMessageQueue>();
//		Iterator iter = children.iterator();
//		while(iter.hasNext()){
//			SmTbVipAccountDetail child = (SmTbVipAccountDetail)iter.next();
//			SmTbMessageQueue vo = new SmTbMessageQueue();
//			vo.setIdx(1);
//			vo.setCreateUserId(userId);
//			vo.setMobile(child.getSmTbVipAccount().getMobile());
//			vo.setRecipientId(child.getSmTbVipAccount().getUserId());
//			vo.setSendDate(new Timestamp(sendDate.getTime()));
//			vo.setStatus("I");
//			vo.setCreateDate(new Timestamp(new java.util.Date().getTime()));
//			msgQueue.add(vo);
//		}
		boolean isSuccess = doCreateMessageContext("Batch insert order for sex:"+ vipChildSex, 
				context, DateUtil.getSystemSqlDate(), userId, smTbMessageQueues);
		if(isSuccess)
			return true;
		else
			return false;
	}
}
