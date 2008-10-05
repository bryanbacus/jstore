package com.shenming.sms.manager;

import java.util.ArrayList;
import java.util.List;

import com.shenming.sms.bean.Message;

/**
 * @author alchip
 *
 */
public class MessageManager {
	public static MessageManager messageManager;
	public static List<Message> messageList;
	
	public static MessageManager getInstance(){
		if(messageList == null)
			return new MessageManager();
		else
			return messageManager;
	}
	
	public static MessageManager regetInstance(){
		messageManager = new MessageManager();
		return messageManager;
	}
	/**
	 * To put/add a message to static context 
	 * @param msgName
	 * @param cause
	 * @param message
	 * @return
	 */
	public boolean putMessage(String msgName, String cause, String message){
		if(messageList == null){
			messageList = new ArrayList();
		}
		
		return messageList.add(new Message(msgName, cause, message));
	}
	
	/**
	 * To clean the message list from static context
	 * @return
	 */
	public boolean flushMessageList(){
		try{
			if(messageList == null)
				System.out.println("messageList is already empty.");
			messageList.clear();
			return true;
		} catch (Exception e){
			return false;
		}
	}
	
	/**
	 * To get the static context message list
	 * @return
	 */
	public List<Message> getMessageList() {
		return messageList;
	}

	/**
	 * To set the message to static context
	 * @param messageList
	 */
	public void setMessageList(List<Message> messageList) {
		MessageManager.messageList = messageList;
	}
}

