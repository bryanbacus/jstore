package com.shenming.sms.dc.manager;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.beanutils.BeanUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.ConstraintViolationException;

import com.shenming.sms.module.hibernateOrm.SmTbProduct;
import com.shenming.sms.module.hibernateOrm.SmTbProductGroup;
import com.shenming.sms.struts.form.ManageProductGrpForm;
import com.shenming.sms.util.PrintUtil;

public class ProductManager extends SmsManager {
	static{
		SmsManager.initialize();
	}
	@Override
	public void commonObjInit() {
	}
	
	/*************************************************** Product Group Related Method ******************************************************/
	/**
	 * Create product group
	 */
	public static boolean createProductGroup(SmTbProductGroup productGroup){
		try{
			session = currentSession();
			beginTransaction();
			session.save(productGroup);
			endTransaction();
		} catch(ConstraintViolationException e ){
			System.err.println("[ERROR]"+ProductManager.class+": Hibernate ConstraintViolationException, Please check the duplicate prdId!");
			rollbackTransaction();
			return false;
		} catch (Exception e){
			rollbackTransaction();
			e.printStackTrace();
			return false;
		} finally {
			closeHibernateSession();
		}
		return true;
		
	}
	
	/**
	 * Update product group
	 * @param productGroup
	 * @return
	 */
	public static boolean updateProductGroup(SmTbProductGroup productGroup){
		try{
			session = currentSession();
			beginTransaction();
			session.update(productGroup);
			endTransaction();
		} catch(ConstraintViolationException e ){
			System.err.println("[ERROR]"+ProductManager.class+": Hibernate ConstraintViolationException, Please check the duplicate prdId!");
			rollbackTransaction();
			return false;
		} catch (Exception e){
			rollbackTransaction();
			e.printStackTrace();
			return false;
		} finally {
			closeHibernateSession();
		}
		return true;
		
	}
	
	/**
	 * get product group by group_id
	 * @param prdGroupId
	 * @return
	 */
	public static SmTbProductGroup retrieveProductGroupByGroupId(int prdGroupId){
		try{
			session = currentSession();
			Criteria criteria = session.createCriteria(SmTbProductGroup.class);
			criteria.add(Restrictions.eq("prdGroupId",prdGroupId));
			SmTbProductGroup vo = (SmTbProductGroup)criteria.uniqueResult();
			return vo;
		} finally{
			closeHibernateSession();
		}
	}
	
	/**
	 * get all the product groups
	 * @return
	 */
	public static List<SmTbProductGroup> retrieveAllProductGroups(){
		try{
			session = currentSession();
			Criteria criteria = session.createCriteria(SmTbProductGroup.class);
			return (List<SmTbProductGroup>)criteria.list();
		} finally{
			closeHibernateSession();
		}
	}
	
	public static List<SmTbProductGroup> retrieveAllProductGroupsByForm(ManageProductGrpForm form){

		SmTbProductGroup vo =  form.formToBean(form);
		try{
			log("Query condition:");
			
			session = currentSession();
			Criteria criteria = session.createCriteria(SmTbProductGroup.class);
			
			if(vo.getPrdGroupDiscount() == 0)
				vo.setPrdGroupDiscount(null);
			if(vo.getPrdGroupId() == 0)
				vo.setPrdGroupId(null);
			if(vo.getPrdGroupName() == null || "".equalsIgnoreCase(vo.getPrdGroupName()))
				vo.setPrdGroupName(null);
			if(vo.getTypeStatus() == null || "".equalsIgnoreCase(vo.getTypeStatus()))
				vo.setTypeStatus(null);
			
			PrintUtil.printObject(vo);
			criteria.add(Example.create(vo));
			return (List<SmTbProductGroup>)criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			closeHibernateSession();
		}
		
		return null;
	}
	
	/**
	 * get all the product group to tree map
	 * @return
	 */
	public static Map<Integer, String> retrievePrdGrpMap(){
		List<SmTbProductGroup> groups = retrieveAllProductGroups();
		Iterator iter = groups.iterator();
		TreeMap<Integer, String> tm = new TreeMap<Integer, String>();
		while(iter.hasNext()){
			SmTbProductGroup vo = (SmTbProductGroup)iter.next();
			tm.put(vo.getPrdGroupId(), vo.getPrdGroupName());
		}
		
		return tm;
	}
	
	/*************************************************** Product Related Method ******************************************************/
	public static boolean createProduct(SmTbProduct product){
		try{
			session = currentSession();
			beginTransaction();
			session.save(product);
			endTransaction();
		} catch(ConstraintViolationException e ){
			System.err.println("[ERROR]"+ProductManager.class+": Hibernate ConstraintViolationException, Please check the duplicate prdId!");
			rollbackTransaction();
			return false;
		} catch (Exception e){
			rollbackTransaction();
			e.printStackTrace();
			return false;
		} finally {
			closeHibernateSession();
		}
		return true;
		
	}
	
	public static boolean updateProduct(SmTbProduct product){
		try{
			session = currentSession();
			
			beginTransaction();
			session.update(product);
			endTransaction();
		} catch(ConstraintViolationException e ){
			System.err.println("[ERROR]"+ProductManager.class+": Hibernate ConstraintViolationException, Please check the duplicate prdId!");
			rollbackTransaction();
			return false;
		} catch (Exception e){
			rollbackTransaction();
			e.printStackTrace();
			return false;
		} finally {
			closeHibernateSession();
		}
		return true;
		
	}
	
	public static boolean updateProductPictureName(int idx, String pictureName){
		SmTbProduct product = retrieveProductById(idx);
		product.setPrdPicFile(pictureName);
		return updateProduct(product);
	}
	
	public static List<SmTbProduct> retrieveAllProducts(){
		return retrieveProducts(0,0,null,0,0,0,0,null,null,null,null,0);
	}
	
	public static SmTbProduct retrieveProductById(int prdId){
		try{
			session = currentSession();
			Criteria criteria = session.createCriteria(SmTbProduct.class);
			criteria.add(Restrictions.eq("prdId",prdId));
			SmTbProduct vo = (SmTbProduct)criteria.uniqueResult();
			return vo;
		} finally{
			closeHibernateSession();
		}
	}
	
	public static List<SmTbProduct> retrieveProductsByGrpId(int prdGroupId){
		return retrieveProducts(0,prdGroupId,null,0,0,0,0,null,null,null,null,0);
	}
	
	public static TreeMap<Integer, String> retrieveProductsMapByGrpId(int prdGroupId){
		List<SmTbProduct> products = retrieveProducts(0,prdGroupId,null,0,0,0,0,null,null,null,null,0);
		TreeMap<Integer, String> tm = new TreeMap<Integer, String>();
		Iterator iter = products.iterator();
		while(iter.hasNext()){
			SmTbProduct vo = (SmTbProduct)iter.next();
			tm.put(vo.getPrdId(), vo.getName());
		}
		return tm;
	}
	
	public static TreeMap<Integer, String> retrieveAvaliableProductsMapByGrpId(int prdGroupId){
		List<SmTbProduct> products = retrieveProducts(0,prdGroupId,null,0,0,0,0,null,null,null,null,0);
		TreeMap<Integer, String> tm = new TreeMap<Integer, String>();
		Iterator iter = products.iterator();
		while(iter.hasNext()){
			SmTbProduct vo = (SmTbProduct)iter.next();
			if(ProductStatusManager.SUPPLY_ENOUGH.equalsIgnoreCase(vo.getSuplyStatus()))
				tm.put(vo.getPrdId(), vo.getName());
		}
		return tm;
	}
	
	public static TreeMap<Integer, String> retrieveProductsMap(){
		List<SmTbProduct> products = retrieveProducts(0,0,null,0,0,0,0,null,null,null,null,0);
		TreeMap<Integer, String> tm = new TreeMap<Integer, String>();
		Iterator iter = products.iterator();
		while(iter.hasNext()){
			SmTbProduct vo = (SmTbProduct)iter.next();
			tm.put(vo.getPrdId(), vo.getName());
		}
		return tm;
	}
	
	public static TreeMap<Integer, String> retrieveAvaliableProductsMap(){
		List<SmTbProduct> products = retrieveProducts(0,0,null,0,0,0,0,null,null,null,null,0);
		TreeMap<Integer, String> tm = new TreeMap<Integer, String>();
		Iterator iter = products.iterator();
		while(iter.hasNext()){
			SmTbProduct vo = (SmTbProduct)iter.next();
			if(ProductStatusManager.SUPPLY_ENOUGH.equalsIgnoreCase(vo.getSuplyStatus()))
				tm.put(vo.getPrdId(), vo.getName());
		}
		return tm;
	}
	
	/**
	 * To list all for using:
	 * return retrieveProducts(0,0,null,0,0,null,null,null,null,0);
	 */
	public static List<SmTbProduct> retrieveProducts(int prdId, int prdGroupId, String name,
			long priceMin, long priceMax, long priceVipMin, long priceVipMax, String supplyStatus, String formatDesc, 
			String sendArea, String sendDesc, int owner){
		try{
			session = currentSession();
			Criteria criteria = session.createCriteria(SmTbProduct.class);
			if(prdGroupId > 0)
				criteria.createCriteria("smTbProductGroup").add(Restrictions.eq("prdGroupId",prdGroupId));
			if(prdId > 0)
				criteria.add(Restrictions.eq("prdId",new Integer(prdId)));
			if(name != null && !"".equalsIgnoreCase(name))
				criteria.add(Restrictions.eq("name",name));
			if(priceMin > 0)
				criteria.add(Restrictions.ge("price",new Long(priceMin)));
			if(priceMax > 0)
				criteria.add(Restrictions.le("price",new Long(priceMax)));
			if(priceVipMin > 0)
				criteria.add(Restrictions.ge("priceVip",new Long(priceVipMin)));
			if(priceVipMax > 0)
				criteria.add(Restrictions.le("priceVip",new Long(priceVipMax)));
			if(supplyStatus != null && !"".equalsIgnoreCase(supplyStatus))
				criteria.add(Restrictions.eq("supplyStatus",supplyStatus));
			if(formatDesc != null && !"".equalsIgnoreCase(formatDesc))
				criteria.add(Restrictions.eq("formatDesc",formatDesc));
			if(sendArea != null && !"".equalsIgnoreCase(sendArea))
				criteria.add(Restrictions.eq("sendArea",sendArea));
			if(sendDesc != null && !"".equalsIgnoreCase(sendDesc))
				criteria.add(Restrictions.eq("sendDesc",sendDesc));
			if(owner > 0)
				criteria.createCriteria("smTbVipAccount").add(Restrictions.eq("owner",new Integer(owner)));
			
			List<SmTbProduct> products = criteria.list();
			return products;
		} finally{
			closeHibernateSession();
		}
	}

}
