package com.shenming.sms.bean;
/**
 * @author simon
 *
 */
public class Message {
	
	/**
	 * @param msgName
	 * @param cause
	 * @param message
	 * @param time
	 */
	public Message(String msgName, String cause, String message) {
		super();
		this.msgName = msgName;
		this.cause = cause;
		this.message = message;
		this.time = new java.util.Date().toString();
	}
	
	public String msgName;
	public String cause;
	public String message;
	public String time;
	public String getCause() {
		return cause;
	}
	public void setCause(String cause) {
		this.cause = cause;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMsgName() {
		return msgName;
	}
	public void setMsgName(String msgName) {
		this.msgName = msgName;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	public String toString(){
		return "["+time+"]" + msgName + "-" + cause + "-" + message;
	}

}
