import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.shenming.sms.dc.manager.OrderManager;
import com.shenming.sms.dc.manager.ProductManager;
import com.shenming.sms.dc.manager.SmsVipManager;
import com.shenming.sms.module.hibernateOrm.SmTbSaleItem;
import com.shenming.sms.module.hibernateOrm.SmTbSaleItemLog;
import com.shenming.sms.module.hibernateOrm.SmTbSaleRecord;

import junit.framework.TestCase;


public class OrderTestCase extends TestCase {
	
	public static void main(String args[]){
//		OrderManager.initialize();
//		System.out.println(OrderManager.retrieveAll());
		SmTbSaleItem item = new SmTbSaleItem();
//		item.setSmTbProduct(smTbProduct);
		item.setPrdUnitPrice(new Long(2000));
		item.setIsClose("N");
		item.setCount(1);
		
//		SmTbSaleItemLog log = new SmTbSaleItemLog();
//		log.setItemLog("TEST");
//		log.setSmTbSaleItem(item);
//		log.setSmTbVipAccount(SmsVipManager.retrieveUserById(22));
//		Set s = (Set) new HashSet();
//		s.add(log);
//		item.setSmTbSaleItemLogs(s);
		
		item.setSmTbProduct(ProductManager.retrieveProductById(4));
		
		SmTbSaleRecord saleRecord = new SmTbSaleRecord();
		saleRecord.setSaleTotal(new Long(100));
		saleRecord.setSaleDate(new java.sql.Timestamp(new java.util.Date().getTime()));
		saleRecord.setSmTbVipAccount1(SmsVipManager.retrieveUserById(22));
		saleRecord.setSmTbVipAccount2(SmsVipManager.retrieveUserById(22));
		item.setSmTbSaleRecord(saleRecord);
		
		OrderManager.doCreate(item);
	}
	
	public static void log(String msg){
		System.out.println(msg);
	}
}
