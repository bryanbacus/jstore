package com.shenming.sms.dc.manager;

import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.ConstraintViolationException;

import com.shenming.sms.module.hibernateOrm.SmTbProduct;
import com.shenming.sms.module.hibernateOrm.SmTbSaleItem;
import com.shenming.sms.module.hibernateOrm.SmTbSaleItemLog;
import com.shenming.sms.module.hibernateOrm.SmTbSaleRecord;
import com.shenming.sms.module.hibernateOrm.SmTbVipAccount;

public class OrderManager extends SmsManager {
	
	public static String ORDER_STATUS_NOT_CLOSE = "N";
	public static String ORDER_STATUS_CLOSE = "Y";
	public static String ORDER_STATUS_SUSPEND = "S";
	public static String ORDER_STATUS_CANCEL = "C";

	static{
		SmsManager.initialize();
	}
	
	@Override
	public void commonObjInit() {
		// TODO Auto-generated method stub

	}
	
	public static List<SmTbSaleItem> retrieveAllSaleItem(){
		try{
			session = currentSession();
			Criteria criteria = session.createCriteria(SmTbSaleItem.class);
			return (List<SmTbSaleItem>)criteria.list();
		} finally{
			closeHibernateSession();
		}
	}
	
	public static SmTbSaleItem retrieveSaleItemById(int itemSeq){
		try{
			session = currentSession();
			Criteria criteria = session.createCriteria(SmTbSaleItem.class);
			criteria.add(Restrictions.eq("itemSeq",itemSeq));
			return (SmTbSaleItem)criteria.uniqueResult();
		} finally{
			closeHibernateSession();
		}
	}
	
	public static List<SmTbSaleItem> retrieveSaleItemBySaleSeq(int saleSeq){
		try{
			session = currentSession();
			Criteria criteria = session.createCriteria(SmTbSaleItem.class);
			criteria.createCriteria("smTbSaleRecord").add(Restrictions.eq("saleSeq",saleSeq));
			return (List<SmTbSaleItem>)criteria.list();
		} finally{
			closeHibernateSession();
		}
	}
	
	public static List<SmTbSaleRecord> retrieveSaleRecordAll(){
		try{
			session = currentSession();
			Criteria criteria = session.createCriteria(SmTbSaleRecord.class);
			return (List<SmTbSaleRecord>)criteria.list();
		} finally{
			closeHibernateSession();
		}
	}
	
	public static SmTbSaleRecord retrieveSaleRecordById(int saleSeq){
		try{
			session = currentSession();
			Criteria criteria = session.createCriteria(SmTbSaleRecord.class);
			criteria.add(Restrictions.eq("saleSeq",saleSeq));
			return (SmTbSaleRecord)criteria.uniqueResult();
		} finally{
			closeHibernateSession();
		}
	}
	
	public static List<SmTbSaleRecord> retrieveSaleRecord(int vipId, int saleId, 
			long saleTotalMin, long saleTotalMax,
			java.sql.Date saleDateStart, java.sql.Date saleDateEnd){
		
		try{
			session = currentSession();
			Criteria criteria = session.createCriteria(SmTbSaleRecord.class);
			if(vipId > 0)
				criteria.createCriteria("smTbVipAccount2").add(Restrictions.eq("userId", vipId));
			if(saleId > 0)
				criteria.createCriteria("smTbVipAccount1").add(Restrictions.eq("userId", saleId));
			if(saleTotalMin > 0)
				addGeCriteria(criteria,"saleTotal",saleTotalMin);
			if(saleTotalMax > 0)
				addLeCriteria(criteria,"saleTotal",saleTotalMax);
			if(saleDateStart != null)
				addGeCriteria(criteria, "saleDate", saleDateStart);
			if(saleDateEnd != null)
				addLeCriteria(criteria, "saleDate", saleDateEnd);
			return (List<SmTbSaleRecord>)criteria.list();
		} finally{
			closeHibernateSession();
		}
	}
	
	/**
	 * 001: Add sale record
	 * 002: Add sale items
	 * 003: Add sale log
	 * @param saleTotal
	 * @param saleDate
	 * @param saleItems
	 * @param saleId
	 * @param vipId
	 * @param prdId
	 * @param unitPrice
	 * @param isClosed
	 * @param count
	 * @return
	 */
	public static boolean createSaleRecord(
			Long saleTotal, Timestamp saleDate,	Set saleItems, int saleId, int vipId){//, //sale record parameters 
			//int prdId, Long discountPrice, String isClosed, int count, String logString){
		try{
			long time = new java.util.Date().getTime();
			session = currentSession();
			beginTransaction();
			SmTbSaleRecord saleRecord = new SmTbSaleRecord();
			saleRecord.setSaleSeq(1); //Set as default and MySQL will auto create id
			saleRecord.setSaleTotal(saleTotal);
			saleRecord.setSaleDate(saleDate);
			saleRecord.setSmTbSaleItems(saleItems);
			SmTbVipAccount sales = SmsVipManager.retrieveUserById(saleId);
			if(sales == null){
				System.err.println("[ERROR]Cannot creat order cause the sales id: " + saleId + " is not a user!");
				return false;
			}
			saleRecord.setSmTbVipAccount1(sales);
			SmTbVipAccount vip = SmsVipManager.retrieveUserById(vipId);
			if(vip == null){
				System.err.println("[ERROR]Cannot creat order cause the vip id: " + vipId + " is not a user!");
				return false;
			}
			saleRecord.setSmTbVipAccount2(vip);
			session.save(saleRecord);
			
			Iterator iter = saleItems.iterator();
			while(iter.hasNext()){
				SmTbSaleItem item = (SmTbSaleItem)iter.next();//new SmTbSaleItem();
				item.setSmTbSaleRecord(saleRecord);
//				SmTbProduct product = ProductManager.retrieveProductById(prdId);
//				item.setItemSeq(1); //Set as default and MySQL will auto create id
//				item.setSmTbProduct(product);
//				item.setPrdUnitPrice(product.getPrice());
//				item.setPrdDiscountPrice(discountPrice);
//				item.setIsClose(isClosed);
//				item.setCount(count);
//				item.setSmTbSaleRecord(saleRecord);
				item.setSmTbVipAccount1(sales);
				item.setSmTbVipAccount2(vip);
				item.setCrDate(new java.sql.Timestamp(time));
				item.setUpdDate(new java.sql.Timestamp(time));
//				item.setLog(logString);
				session.save(item);
			}
			endTransaction();
			return true;
		} catch (Exception e){
			rollbackTransaction();
			System.err.println("[ERROR] Create Sale Record Error!");
			e.printStackTrace();
			return false;
		} finally {
			closeHibernateSession();
		}
		
	}
	
	public static boolean updateSaleItemStatusBySaleSeq(int saleSeq, String status){
		
		try {
			session = currentSession();
			beginTransaction();
			List<SmTbSaleItem> items = retrieveSaleItemBySaleSeq(saleSeq);
			Iterator iter = items.iterator();
			while(iter.hasNext()){
				SmTbSaleItem vo = (SmTbSaleItem)iter.next();
				vo.setIsClose(status);
				session.save(vo);
			}
			endTransaction();
		} catch (Exception e) {
			e.printStackTrace();
			rollbackTransaction();
		} finally {
			closeHibernateSession();
		}
		return false;
	}
	
	public static boolean updateSaleItemStatusByItemSeq(int itemSeq, String status){
		try{
			session = currentSession();
			beginTransaction();
			SmTbSaleItem item = retrieveSaleItemById(itemSeq);
			item.setIsClose(status);
			session.save(item);
			endTransaction();
		} catch (Exception e) {
			e.printStackTrace();
			rollbackTransaction();
		} finally {
			closeHibernateSession();
		}
		return false;
	}
	
	
	/**************************************Retrieve from SmTbSaleRecord*********************************************/
//	public static List<SmTbSaleRecord> retrieveSaleRecord{
//		
//	}
}
