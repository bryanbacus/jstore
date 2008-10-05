import com.shenming.sms.dc.manager.SmsVipManager;


public class BatchUpdateTest {
	
	public static void main(String args[]){
		SmsVipManager.initialize();
		boolean isSuccess = SmsVipManager.updateVipChildOverOld(10);
		
		System.out.println("Update result: "+ isSuccess);
	}
}
