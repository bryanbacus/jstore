package com.shenming.sms.sender.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.shenming.sms.sender.SMSSenderInterface;
import com.shenming.sms.util.Tool;

import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.*;
import org.apache.commons.httpclient.util.EncodingUtil;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class SMSSocketSender implements SMSSenderInterface {
//	static{
//		Tool.initialize();
//		url = Tool.getStringProperty("");
//	}
	public static String smsUrl = url;
	private static final int BASE_SEQ = 10;
	/**
	 * @param args
	 * http://61.30.48.133:18994/send.cgi?username=VCST001700&password=8695266846&rateplan=A&srcaddr=8708189'$1'&dstaddr='$2'&encoding=BIG5&smbody='"$3"
	 */
	public static void main(String[] args) {
		HttpClient client = new HttpClient();
		
		String url =
			"http://bizsms.taiwanmobile.com:18994/send.cgi?username=VCSN029100&password=b24ff43t&rateplan=A&srcaddr=870291000001&dstaddr=0953609275&encoding=BIG5&smbody=中文測試";
//			"http://61.30.48.133:18994/send.cgi?username=VCST000400&password=7968766752&rateplan=A&srcaddr=87081749&dstaddr=0953609275&encoding=BIG5&smbody=中文簡訊^3^!";
		
		HttpMethod method = new GetMethod(url);
		int statusCode = -1;
		// We will retry up to 3 times.
		for (int attempt = 0; statusCode == -1 && attempt < 3; attempt++) {
			try {
				// execute the method.
				statusCode = client.executeMethod(method);
			} catch (HttpRecoverableException e) {
				System.err.println("A recoverable exception occurred, retrying. " +
				e.getMessage());
			} catch (IOException e) {
				System.err.println("Failed to download file.");
				e.printStackTrace();
				System.exit(-1);
			}
		}
		// Check that we didn't run out of retries.
		if (statusCode == -1) {
			System.err.println("Failed to recover from exception.");
			System.exit(-2);
		}
		// Read the Response
		//byte[] responseBody = method.getResponseBody();
		try {
			System.out.println(method.getResponseBodyAsString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Release the Connection
		method.releaseConnection();
	}
	
	/**
	 * @param args
	 * The url string: http://61.30.48.133:18994/send.cgi?username=VCST001700&password=8695266846&rateplan=A&srcaddr=8708189'$1'&dstaddr='$2'&encoding=BIG5&smbody='"$3"
	 * Or using method "this.initialUrl("61.30.48.133",18994, "VCST000400", "7968766752", "8708174")" to initialize the url
	 */
	public void initial() {
		String host = Tool.getStringProperty("SMS_SERVER_HOST");
		String port = Tool.getStringProperty("SMS_SERVER_PORT");
		String account = Tool.getStringProperty("SMS_ACCOUNT");
		String password = Tool.getStringProperty("SMS_PASSWORD");
		String defaultPass = Tool.getStringProperty("SMS_DEFAULT_PASS");		
		this.initialUrl(host, new Integer(port), account, password, defaultPass);
	}

	public String sendMessage(String dstaddr, String msg) {
		HttpClient client = new HttpClient();
		Tool.logDebug("sendMessage get attribute: "+ dstaddr+"::"+ msg,3);
		String completeUrl = this.completeUrl(new Long(new Date().getTime()%BASE_SEQ).toString(), dstaddr, msg);
		if(isCompleteUrl(completeUrl)){
			Tool.logDebug("SMS URL: "+completeUrl,3);
			return doSendMsgGetResponse(completeUrl);
		}else
			return "[ERROR]smsUrl is not complete! smsUrl:" + smsUrl;
	}

	public String sendMessage(Map smsInfo) {
		Set keySet = smsInfo.keySet();
		Iterator iter = keySet.iterator();
		while(iter.hasNext()){
			String key = (String)iter.next();
			sendMessage(key, (String)smsInfo.get(key));
			System.out.println("Sent message:"+ smsInfo.get(key)+ " to "+ key +" success!");
		}
		return null;
	}
	
	public String doSendMsgGetResponse(String url){
		HttpClient client = new HttpClient();
		
		HttpMethod method = new GetMethod(url);
		
		int statusCode = -1;
		// We will retry up to 3 times.
		for (int attempt = 0; statusCode == -1 && attempt < 3; attempt++) {
			try {
				// execute the method.
				statusCode = client.executeMethod(method);
			} catch (HttpRecoverableException e) {
				System.err.println("A recoverable exception occurred, retrying. " +
				e.getMessage());
				return null;
			} catch (IOException e) {
				System.err.println("Failed to download file.");
				e.printStackTrace();
//				System.exit(-1);
				return null;
			}
		}
		// Check that we didn't run out of retries.
		if (statusCode == -1) {
			System.err.println("Failed to recover from exception.");
//			System.exit(-2);
			return null;
		}
		// Read the Response
		//byte[] responseBody = method.getResponseBody();
		String response = "";
		try {
			response = method.getResponseBodyAsString();
			System.out.println(response);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		// Release the Connection
		method.releaseConnection();
		
		return response;
	}

	public String initialUrl(String host, int port, String username, String password, String srcaddr) {
		smsUrl = smsUrl.replaceAll("%HOST%", host);
		smsUrl = smsUrl.replaceAll("%PORT%", new Integer(port).toString());
		smsUrl = smsUrl.replaceAll("%USERNAME%", username);
		smsUrl = smsUrl.replaceAll("%PASSWORD%", password);
		smsUrl = smsUrl.replaceAll("%SRCADDR%", srcaddr);
		return smsUrl;
	}

	public String completeUrl(String seq, String dstaddr, String msg) {
		String completeUrl = smsUrl;
		if(Tool.isNotEmpty(seq))
			completeUrl = completeUrl.replaceAll("%SEQ%", seq);
		if(Tool.isNotEmpty(dstaddr))
			completeUrl = completeUrl.replaceAll("%DSTADDR%", dstaddr);
		if(Tool.isNotEmpty(msg)){
			NameValuePair message = new NameValuePair("msg", msg);
			msg = EncodingUtil.formUrlEncode(new NameValuePair[] {message},"Big5").replaceAll("msg=", "");
			
			completeUrl = completeUrl.replaceAll("%MSG%", msg);
			
			Tool.logDebug("Complete URL: "+completeUrl, 3);
		}
		return completeUrl;
	}
	
	public boolean isCompleteUrl(String url){
//		if(url.indexOf("%") >= 0)
//			return false;
		return true;
	}

	public static String encodedUrl(String urlString) {
		URL url = null;
		try {
			url = new URL(
					"http://61.30.48.133:18994/send.cgi?username=VCST000400&password=7968766752&rateplan=A&srcaddr=87081749&dstaddr=0953609275&encoding=BIG5&smbody=中文簡訊^3^!");
		} catch (MalformedURLException mue) {
			System.err.println(mue);
		}
		Tool.logDebug("Original URL: "+url + "\n");
		try {
			String encodedurl = URLEncoder.encode(url.toString(), "BIG5");
			Tool.logDebug("Encoded URL: "+encodedurl);
			return encodedurl;
		} catch (UnsupportedEncodingException uee) {
			System.err.println(uee);
			return null;
		}
	}
	
	public static String encodeBig5ToISO88591(String string){
		try {
			return new String(string.getBytes("BIG5"), "iso-8859-1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static String encodeISO88591ToBig5(String string){
		try {
			return new String(string.getBytes("iso-8859-1"),"BIG5" );
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}
}
