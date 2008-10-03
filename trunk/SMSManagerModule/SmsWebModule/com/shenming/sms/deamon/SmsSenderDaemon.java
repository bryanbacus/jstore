package com.shenming.sms.deamon;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

import com.shenming.sms.dc.manager.SenderManager;
import com.shenming.sms.dc.manager.SmsManager;
import com.shenming.sms.module.hibernateOrm.SmTbMessageLog;
import com.shenming.sms.module.hibernateOrm.SmTbMessageQueue;
import com.shenming.sms.sender.impl.SMSSocketSender;
import com.shenming.sms.util.DateUtil;

public class SmsSenderDaemon {
	public static void main(String args[]){
		log("=====================================================================");
		log("Daemon Start at " + new Date());
		SmsSenderDaemon daemon = new SmsSenderDaemon();
		List<SmTbMessageQueue> sendList = SenderManager.retrieveMessageQueueToProcess("I");
		Iterator iter = sendList.iterator();
		boolean isWorking = false;;
		while(iter.hasNext()){
			SmTbMessageQueue vo = (SmTbMessageQueue)iter.next();
			if(vo.getSendDate().getTime() < new java.util.Date().getTime()){
				isWorking = true;
				log("Will sent message mobile:" + vo.getMobile() + ";msg:"+ vo.getSmTbMessageContext().getSmsContext());
				log("Do sent result: "+doSentMessage(vo));
			}
		}
		
		if(!isWorking)
			log("This turn has no message to send... Process finished at "+ new Date());
		else
			log("This turn's message is already sent done! Process finished at "+ new Date());
	}
	
	public static void log(String msg){
		System.out.println(msg);
	}

	public static boolean doSentMessage(SmTbMessageQueue vo){
		SMSSocketSender sender = new SMSSocketSender();
		sender.initial();
//		log("doSentMessage(): " + vo.getMobile()+"->"+vo.getSmTbMessageContext().getSmsContext());
		String result = sender.sendMessage(vo.getMobile(), vo.getSmTbMessageContext().getSmsContext());
		if(result.indexOf("ParseOK") > 0){
			doUpdateMessageQueueAndLogSuccess(vo.getIdx());
			return true;
		} else {
			doUpdateMessageQueueAndLogFail(vo.getIdx());
			return false;
		}
	}

	private static boolean doUpdateMessageQueueAndLog(int idx, String status) {
		try{
			SmTbMessageQueue queue = SenderManager.retrieveMessageQueueById(idx);
			queue.setStatus(status);
			Session session = SenderManager.currentSession();
			SenderManager.beginTransaction();
			session.update(queue);
			SmTbMessageLog log = new SmTbMessageLog();
			log.setIdx(1);
			log.setCreateUserName("Sms Sender Daemon");
			log.setLog("Send message success !");
			log.setSmTbMessageQueue(queue);
			log.setCreateDate(DateUtil.getSystemSqlTimestamp());
			log.setCreateUserId(0);
			session.save(log);
			SenderManager.endTransaction();
//			SenderManager.saveMessageOperationLog(0, "Sms Sender Daemon", "Send message success !");
			
			return true;
		} catch (Exception e){
			SenderManager.rollbackTransaction();
			e.printStackTrace();
			return false;
		}
	}
	
	private static boolean doUpdateMessageQueueAndLogSuccess(int idx) {
		return doUpdateMessageQueueAndLog(idx, "S");
	}
	
	private static boolean doUpdateMessageQueueAndLogFail(int idx) {
		return doUpdateMessageQueueAndLog(idx, "F");
	}
	
}
