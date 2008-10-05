import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.*;
import org.apache.commons.httpclient.util.EncodingUtil;

import java.io.*;

public class SendSMSGet {
	public static void main(String[] args) throws Exception {
		HttpClient client = new HttpClient();
		String url = "http://61.30.48.133:18994/send.cgi?username=VCST000400&password=7968766752&rateplan=A&srcaddr=87081749&dstaddr=0953609275&encoding=BIG5&smbody=";
		NameValuePair login = new NameValuePair("msg", "中文簡訊測試!!");
		
		url = url + EncodingUtil.formUrlEncode(new NameValuePair[] {login},"Big5").replaceAll("msg=", "");
		System.out.println("-->"+EncodingUtil.formUrlEncode(new NameValuePair[] {login},"Big5"));
		
		HttpMethod method = new GetMethod(url);
		
		int statusCode = -1;
		// We will retry up to 3 times.
		for (int attempt = 0; statusCode == -1 && attempt < 3; attempt++) {
			try {
				// execute the method.
				statusCode = client.executeMethod(method);
			} catch (HttpRecoverableException e) {
				System.err
						.println("A recoverable exception occurred, retrying. "
								+ e.getMessage());
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
		// byte[] responseBody = method.getResponseBody();
		System.out.println(method.getResponseBodyAsString());
		// Release the Connection
		method.releaseConnection();
	}
}