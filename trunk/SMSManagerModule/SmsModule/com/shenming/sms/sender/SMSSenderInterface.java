package com.shenming.sms.sender;

import java.util.Map;

public interface SMSSenderInterface {
//	"http://61.30.48.133:18994/send.cgi?username=VCST000400&password=7968766752&rateplan=A&srcaddr=8708174&dstaddr=0912584257&encoding=BIG5&smbody=親愛的，愛你喔";
	public static String url = 
		"http://%HOST%:%PORT%/send.cgi?username=%USERNAME%&password=%PASSWORD%" +
		"&rateplan=A&srcaddr=%SRCADDR%%SEQ%&dstaddr=%DSTADDR%&encoding=BIG5&smbody=%MSG%!";
	public void initial();
	public String sendMessage(String dstNumber, String msg);
	public String sendMessage(Map smsInfo);
	public String initialUrl(String host, int port, String username, String password, String srcaddr) ;
	public String completeUrl(String seq, String dstaddr, String msg);
	public boolean isCompleteUrl(String url);
}
