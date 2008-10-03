import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import com.shenming.sms.dc.manager.OrderManager;
import com.shenming.sms.dc.manager.ProductManager;
import com.shenming.sms.dc.manager.SmsVipManager;
import com.shenming.sms.dc.util.HibernateUtil;
import com.shenming.sms.module.hibernateOrm.SmTbSaleItem;
import com.shenming.sms.module.hibernateOrm.SmTbSaleItemLog;
import com.shenming.sms.module.hibernateOrm.SmTbSaleRecord;


public class TestOrderManager {
	public static void main(String args[]){
		log("Result: "+OrderManager.retrieveSaleItemById(100));
//		OrderManager.initialize();
//		System.out.println(OrderManager.retrieveAll());
//		SmTbSaleItem item = new SmTbSaleItem();
//		item.setItemSeq(1);
//		item.setSmTbProduct(ProductManager.retrieveProductById(4));
//		item.setPrdUnitPrice(new Long(2000));
//		item.setIsClose("N");
//		item.setCount(1);
////		
//		Set items = new HashSet();
//		items.add(item);
//		item.setSmTbSaleRecord(OrderManager.retrieveSaleRecordById(3));
//		SmTbSaleItemLog log = new SmTbSaleItemLog();
//		log.setItemLog("TEST");
//		log.setSmTbSaleItem(item);
//		log.setSmTbVipAccount(SmsVipManager.retrieveUserById(22));
//		Set s = (Set) new HashSet();
//		s.add(log);
//		item.setSmTbSaleItemLogs(s);
//		
//		item.setSmTbProduct(ProductManager.retrieveProductById(4));
//		HibernateUtil.initialize();
//		Session session = HibernateUtil.currentSession();
//		SmTbSaleRecord saleRecord = new SmTbSaleRecord();
//		saleRecord.setSaleSeq(1);
//		saleRecord.setSaleTotal(new Long(100));
//		saleRecord.setSaleDate(new java.sql.Timestamp(new java.util.Date().getTime()));
//		saleRecord.setSmTbSaleItems(items);
//		saleRecord.setSmTbVipAccount1(SmsVipManager.retrieveUserById(22));
//		saleRecord.setSmTbVipAccount2(SmsVipManager.retrieveUserById(22));
		
//		HibernateUtil.beginTransaction();
//		session.save(saleRecord);
//		HibernateUtil.commitTransaction();
//		log("Result:"+OrderManager.doCreate(item));
//		log("Result:"+OrderManager.createSaleRecord(new Long(100), new java.sql.Timestamp(new java.util.Date().getTime()), 
//				items, 22, 22, 4, new Long(2000), "N", 2, "Sales create a sale record!"));
	}
	
	public static void log(String msg){
		System.out.println(msg);
	}
}
