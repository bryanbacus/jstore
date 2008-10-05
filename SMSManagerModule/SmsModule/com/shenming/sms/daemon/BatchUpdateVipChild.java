package com.shenming.sms.daemon;

import com.shenming.sms.dc.manager.SmsVipManager;

public class BatchUpdateVipChild {
	public static void main(String args[]) {
		SmsVipManager.initialize();
		SmsVipManager.queryVipChildOverOld(10);
		boolean isSuccess = SmsVipManager.updateVipChildOverOld(10);
		log("Update result: " + isSuccess);
	}
	
	public static void log(String msg){
		System.out.println(msg);
	}
}
