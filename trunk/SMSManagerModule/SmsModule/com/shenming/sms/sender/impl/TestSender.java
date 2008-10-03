package com.shenming.sms.sender.impl;

public class TestSender {
	public static void main(String args[]){
		SMSSocketSender sender = new SMSSocketSender();
		sender.initial();
//		sender.completeUrl(seq, dstaddr, msg)
		log("Result: "+sender.sendMessage("0953609275", "ด๚ธี"));
		
	}
	
	private static void log(String msg){
		System.out.println(msg);
	}
}
