package com.shenming.sms.util;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailUtil {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Send mail start!");
		MailUtil mu = new MailUtil();
//		mu.send("Hello!!\r\nhttp://oaps2.ncic.com.tw:8080/oaps");
		mu.send("<font color=\"red\">Hello!!</font><br/>" +
				"http://oaps2.ncic.com.tw:8080/oaps");
		System.out.println("Send mail finish!");
	}
	
	public void send(String msgBody)throws Exception
	{
		String to="simonsu@ncic.com.tw";//System.getProperty("com.acme.mail.recipient");
		String subject="JMail Test!";
		String from="simonsu@ncic.com.tw";//System.getProperty("com.acme.mail.sender");
		String mailhost="tphqms3.ncic.corp";//System.getProperty("com.acme.mail.server");
		String mailer="JMail Mailler";
		Properties props=new Properties();
		props=System.getProperties();
		props.put("mail.smtp.host",mailhost);
		
		//存取session物件
		Session session=Session.getDefaultInstance(props, null);
		
		//建構一個信息
		Message msg=new MimeMessage(session);
		msg.setFrom(new InternetAddress(from));
		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to,false));
		msg.setSubject(subject);
//		msg.setText(msgBody);
		msg.setContent(msgBody, "text/html");
		msg.setSentDate(new Date());
		
		//傳送信息
		Transport.send(msg);
	}

}
