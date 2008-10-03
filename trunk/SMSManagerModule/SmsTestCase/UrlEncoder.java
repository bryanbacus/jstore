import java.net.URL;
import java.net.URLEncoder;
import java.net.MalformedURLException;
import java.io.UnsupportedEncodingException;

public class UrlEncoder {

	public static void main(String[] args) {
		URL url = null;
		try {
			url = new URL(
					"http://61.30.48.133:18994/send.cgi?username=VCST000400&password=7968766752&rateplan=A&srcaddr=87081749&dstaddr=0953609275&encoding=BIG5&smbody=¤¤¤åÂ²°T^3^!");
		} catch (MalformedURLException mue) {
			System.err.println(mue);
		}
		System.out.println(url + "\n");
		try {
			String encodedurl = URLEncoder.encode(url.toString(), "BIG5");
			System.out.println(encodedurl);
		} catch (UnsupportedEncodingException uee) {
			System.err.println(uee);
		}
	}
}
