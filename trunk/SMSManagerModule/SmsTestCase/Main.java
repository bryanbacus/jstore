import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.shenming.sms.bean.Message;
import com.shenming.sms.dc.manager.ProductManager;
import com.shenming.sms.dc.manager.SmsVipManager;
import com.shenming.sms.module.hibernateOrm.SmTbVipAccount;
import com.shenming.sms.module.hibernateOrm.SmTbVipAccountDetail;
import com.shenming.sms.util.DateUtil;
import com.shenming.sms.util.PrintUtil;
import com.shenming.sms.util.Tool;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		log("Main Start...........");
		
//		ProductManager.updateProductPictureName(4, "4.gif");
		
//		log(ProductManager.retrieveProductsByGrpId(1));
		
//		new Main().printClass();
//		new Main().testVipAccountTable();
//		new Main().testVipChildTable();
//		log("Is Manager: "+SmsVipManager.isManager("jelly", "12345qwert"));
//		long date = new Date().getTime();
//		log("SQL Date: " + new java.sql.Date(date));
//		log("Util Date: " + new java.util.Date(date));
		
//		log(DateUtil.convertDateToString(new Date(), "yyyy-MM-dd HH:mm:ss"));
//		SmsVipManager.initialize();
//		log("Result: "+SmsVipManager.retrieveAccountGroupByUserId(21));
//		String str = ",1,,,,,";
//		log(str.split(",").length);
//		log("---------------------------------");
//		PrintUtil.printArray(str.split(","));
//		log("---------------------------------");
//		SmsVipManager.initialize();
//		log("size: "+SmsVipManager.retrieveChildByUserName("1003031").size());
		
//		new Main().testRetrieveUserByByPossibleKey("1005551");
		
		SmTbVipAccount acc = new SmTbVipAccount();
		acc.setUserId(new Integer(1234));
		PrintUtil.printObject(acc);
		update(acc);
		PrintUtil.printObject(acc);
		log("Main End...........");
		
	}
	
	public static void update(SmTbVipAccount acc){
		acc.setUserId(new Integer(4567));
	}
	
	public void testRetrieveUserByByPossibleKey(String key){
		SmsVipManager.initialize();
		List<SmTbVipAccount> list = SmsVipManager.retrieveUserByPossibleKey(key);
		for(SmTbVipAccount account: list){
			log(account.getUsername());
		}
		
		List<Message> messageList = SmsVipManager.checkConflictOfVipAccount(key);
		for(Message message: messageList){
			log(message);
		}
	}
	
	public void printClass(){
		Main.log("Result: "+this.getClass());
	}
	
	public static void log(String msg){
		System.out.println(msg);
	}
	
	public static void log(Object msg){
		System.out.println(msg);
	}
	
	private void testVipChildTable(){
		String username = "jelly";
		int userId = SmsVipManager.retrieveUserIdByName(username);
		log("User Id:" + userId);
		//Create children
//		HashMap hm = new HashMap();
//		hm.put("child01", new java.util.Date().getTime());
//		hm.put("child02", new java.util.Date().getTime());
//		hm.put("child03", new java.util.Date().getTime());
//		log("Save children: "+SmsVipManager.createChildByUserId(userId, hm));
		
		//Get children
		List list = SmsVipManager.retrieveChildByUserId(userId);
		log("Original Child list: "+list);

		
		//Modify child
//		log("Update children: "+SmsVipManager.updateChildByUserIdAndChildName(userId, 10, "Test", new java.sql.Date(new Date().getTime())));
		
		//Get a specific child
		log("Get the child 'Test':"+SmsVipManager.retrieveChildByUserIdAndChildName(userId, "Test"));
		log("Get the child id = 11:"+SmsVipManager.retrieveChildByUsernameAndChildIdx(username, 11));
//		list = SmsVipManager.retrieveChildByUserId(userId);
//		log("After update Child list: "+list);
		
		//Delete all children
//		log("Delete children:" + SmsVipManager.deleteAllChildByUserId(userId));
		
		//Delete child by user id and child name
//		log("Delete children:" + SmsVipManager.deleteChildByUserIdAndChildName(userId, "child02"));
	}
	
	private void testVipAccountTable(){
//		SmsVipManager.initialize();
		String username = "test2";
		
		//Create User
//		SmTbVipAccount account = new SmTbVipAccount();
//		account.setUserId(new Integer(23));
//		account.setVipChtName("ด๚ธี123");
//		account.setVipEngName("Test");
//		account.setMailAddr("test@test.test");
//		account.setCrDate(new java.sql.Timestamp(new Date().getTime()));
//		account.setBuySum(0);
//		account.setIsValidVip("N");
//		account.setIsAccountActive("Y");
//		account.setUsername(username);
//		account.setPassword("12345qwert");
//		account.setErrorCnt(0);
		
//		
//		SmsVipManager.createVipUser(account, "manager", "test");
		
		//Get User by Name
//		log("Get user by name: " + SmsVipManager.retrieveUserByName(username).getVipChtName());
//		int id = SmsVipManager.retrieveUserIdByName(username);
//		log("User Id is: "+ id);
		
//		account.setVipChtName("ด๚ธี456");
//		SmsVipManager.updateVipUser(account, "manager", "test");
		
		//Get User again
//		log("Get user by name: " + SmsVipManager.retrieveUserByName(username));
//		id = SmsVipManager.retrieveUserIdByName(username);
//		log("User Id is: "+ id);
		
//		
//		//Get User by Id
//		log("Getuser by Id:"+SmsVipManager.retrieveUserById(id).getVipChtName());
//		
//		//Test Account Password
//		log("Is valied user:"+SmsVipManager.isValiedUser(username, "12345qwert"));
//		
//		//Delete User
		log("Delete user:"+ SmsVipManager.deleteVipUser(23));
	}

}
