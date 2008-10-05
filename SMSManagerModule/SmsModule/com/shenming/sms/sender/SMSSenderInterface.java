package com.shenming.sms.sender;

import java.util.Map;

import com.shenming.sms.util.Tool;

public interface SMSSenderInterface {
	
	/**
	 * http://bizsms.taiwanmobile.com:18994/send.cgi?username=VCSN029100&password=8563747553&rateplan=A&srcaddr=8702910&dstaddr=09xxxxxxxx&encoding=BIG5&smbody=smbody
	 * Example: 
	 * http://61.30.48.133:18994/send.cgi?username=VCST000400&password=7968766752&rateplan=A&srcaddr=8708174&dstaddr=09xxxxxxxx&encoding=BIG5&smbody=¶Ç°e¦r¦ê
	 * 
	 */
	public static String url = //Tool.getStringProperty("SMS_URL");
		"http://%HOST%:%PORT%/send.cgi?username=%USERNAME%&password=%PASSWORD%&rateplan=A&srcaddr=%SRCADDR%%SEQ%&dstaddr=%DSTADDR%&encoding=BIG5&smbody=%MSG%";
	public void initial();
	public String sendMessage(String dstNumber, String msg);
	public String sendMessage(Map smsInfo);
	public String initialUrl(String host, int port, String username, String password, String srcaddr) ;
	public String completeUrl(String seq, String dstaddr, String msg);
	public boolean isCompleteUrl(String url);
}
