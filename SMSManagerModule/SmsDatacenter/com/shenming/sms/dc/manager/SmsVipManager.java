package com.shenming.sms.dc.manager;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.ConstraintViolationException;

import com.shenming.sms.bean.Message;
import com.shenming.sms.manager.MessageManager;
import com.shenming.sms.module.hibernateOrm.SmTbAccountGroup;
import com.shenming.sms.module.hibernateOrm.SmTbVipAccount;
import com.shenming.sms.module.hibernateOrm.SmTbVipAccountDetail;
import com.shenming.sms.module.hibernateOrm.single.SmTbVipAccountVO;
import com.shenming.sms.struts.form.QueryVipForm;
import com.shenming.sms.util.DateUtil;
import com.shenming.sms.util.PrintUtil;
import com.shenming.sms.util.Tool;


public class SmsVipManager extends SmsManager{
	public static final String ADMIN_ID = Tool.getStringProperty("ADMIN_ID");
	public static final String MANAGER_ID = Tool.getStringProperty("MANAGER_ID");
	public static final String VIP_ID = Tool.getStringProperty("VIP_ID");
	
	static{
		SmsManager.initialize();
	}
	
	/***********************************************Vip User Management********************************************/
	public static synchronized boolean createVipUser(SmTbVipAccount account, String roleType, String description){
		try{
			session = currentSession();
			beginTransaction();
			//Update account info
			session.save(account);
			//Update group info
			SmTbAccountGroup group = new SmTbAccountGroup();
			group.setRoleType(roleType);
			group.setDescription(description);
			group.setSmTbVipAccount(account);
			session.save(group);
			
			endTransaction();
		} catch(ConstraintViolationException e ){
			System.err.println("[ERROR]"+SmsVipManager.class+": Hibernate ConstraintViolationException, Please check the duplicate userId!");
			e.printStackTrace();
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
	
	public static synchronized boolean updateVipUser(SmTbVipAccount account, String roleType, String description){
		try{
			session = currentSession();
			beginTransaction();
			//Update account info
			session.update(account);
			//Update group info
			SmTbAccountGroup group = retrieveAccountGroupByUserId(account.getUserId());
			group.setRoleType(roleType);
			group.setDescription(description);
			group.setSmTbVipAccount(account);
			session.update(group);
			endTransaction();
			
		} catch (Exception e){
			rollbackTransaction();
			e.printStackTrace();
			return false;
		} finally {
			closeHibernateSession();
		}
		return true;
	}
	
	public static List<SmTbVipAccount> retrieveUserByPossibleKey(String key){
		try{
			session = currentSession();
			Criteria criteria = session.createCriteria("SmTbVipAccount");
			enableFetchMode2Join(criteria, getMainFetchModeColumns());
			
			String sql = "select * from sm_tb_vip_account account where user_id = '" + key + "' or username = '" + key + "'";
			log(sql);
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity("account", SmTbVipAccount.class);
			return (List<SmTbVipAccount>)query.list();
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			closeHibernateSession();
		}
		return null;
	}
	
	/**
	 * New Request:20080822
	 * 在建檔時.於身份証.姓名(中英文).地址.電話.中任一項有重覆,即出現警告之語,讓我們可查出核對
	 * @param account
	 * @return
	 */
	public static List<SmTbVipAccountVO> retrieveUserByPossibleDuplicate(SmTbVipAccount account){
		try{
			session = currentSession();
			Criteria criteria = session.createCriteria("SmTbVipAccount");
//			enableFetchMode2Join(criteria, getMainFetchModeColumns());
			
			StringBuffer buf = new StringBuffer();
			buf.append("select * from sm_tb_vip_account account where 1=1 ");
			buf.append(" and (");
			boolean isOr = false;
			
//			if(account!=null){
//				if(Tool.isNotEmpty(account.getVipChtName())){
//					buf.append(" vip_cht_name = '" + account.getVipChtName() + "' ");
//					isOr = true;
//				}
//				
//				if(Tool.isNotEmpty(account.getVipChtName())){
//					if(isOr){
//						buf.append(" or ");
//					}
//					buf.append(" vip_eng_name = '" + account.getVipEngName() + "' ");
//					isOr = true;
//				}
//				
//				if(Tool.isNotEmpty(account.getVipChtName())){
//					if(isOr){
//						buf.append(" or ");
//					}
//					buf.append(" mobile = '" + account.getMobile() + "' )");
//					isOr = true;
//				}
//			}
			
//			buf.append(" vip_cht_name = '" + account.getVipChtName() + "' ");
//			buf.append(" or vip_eng_name = '" + account.getVipEngName() + "' ");
			buf.append(" mobile = '" + account.getMobile() + "' ");
			buf.append(" or username = '" + account.getUsername() + "' ");
			buf.append(" or user_id = '" + account.getUserId() + "' ");
//			buf.append(" or address = '" + account.getAddress() + "' ");
//			buf.append(" or phone = '" + account.getPhone() + "' ");
//			buf.append(" or mail_addr = '" + account.getMailAddr()')");
			buf.append(" )");
			log(buf.toString());
			SQLQuery query = session.createSQLQuery(buf.toString());
			query.addEntity("account", SmTbVipAccountVO.class);
			List<SmTbVipAccountVO> list = query.list();
			log("Find Records: " + list.size());
			return list;
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			closeHibernateSession();
		}
		return null;
	}
	
	/**
	 * New Request:20080822
	 * 在建檔時.於身份証.姓名.地址.電話.中任一項有重覆,即出現警告之語,讓我們可查出核對
	 * @param account
	 * @return
	 */
	public static List<SmTbVipAccountVO> retrieveUserByPossibleDuplicate(String columnName, String columnValue){
		try{
			session = currentSession();
			Criteria criteria = session.createCriteria("SmTbVipAccount");
//			enableFetchMode2Join(criteria, getMainFetchModeColumns());
			
			StringBuffer buf = new StringBuffer();
			buf.append("select * from sm_tb_vip_account account where 1=1 ");
			buf.append(" and " + columnName + " = '" + columnValue + "'");
			log(buf.toString());
			SQLQuery query = session.createSQLQuery(buf.toString());
			query.addEntity("account", SmTbVipAccountVO.class);
			List<SmTbVipAccountVO> list = query.list();
			log("Find Records: " + list.size());
			return list;
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			closeHibernateSession();
		}
		return null;
	}
	
	public static List<Message> checkConflictOfVipAccount(String key){
		if(key == null)
			return null;
		MessageManager messageManager = MessageManager.getInstance();
		List<SmTbVipAccount> accountList = retrieveUserByPossibleKey(key);
		
		//To prevent the session clean the instance
		if(messageManager == null){
			messageManager = MessageManager.regetInstance();
		}
		
		messageManager.flushMessageList();
		
		for(SmTbVipAccount account : accountList){
			if(key.equalsIgnoreCase(account.getUserId().toString()))
				messageManager.putMessage("msg", "user_id conflict", "Checked key:" + key + 
						" is conflict with user_id:" + account.getUserId() + 
						" and username: " + account.getUsername());
//				messageManager.putMessage("msg", "user_id conflict", "Checked key:" + key + 
//						" is conflict with record:" + PrintUtil.printObjectToString(account));
			if(key.equalsIgnoreCase(account.getUsername()))
				messageManager.putMessage("msg", "username conflict", "Checked key:" + key + 
						" is conflict with user_id:" + account.getUserId() + 
						" and username: " + account.getUsername());
//				messageManager.putMessage("msg", "username conflict", "Checked key:" + key + 
//						" is conflict with record:" + PrintUtil.printObjectToString(account));
			
		}
		return messageManager.getMessageList();
	}
	
	public static SmTbAccountGroup retrieveAccountGroupByUserId(Integer userId) {
		try{
			session = currentSession();
			Criteria criteria = session.createCriteria(SmTbAccountGroup.class);
			criteria.createCriteria("smTbVipAccount").add(Restrictions.eq("userId", userId));
			return (SmTbAccountGroup)criteria.uniqueResult();
		} catch(Exception e){
			e.printStackTrace();
			return null;
		} finally {
			closeHibernateSession();
		}
	}

	public static synchronized boolean deleteVipUser(int userId){
		return deleteVipUser(new Integer(userId));
	}
	
	public static synchronized boolean deleteVipUser(Integer userId){
		try{
			session = currentSession();
			beginTransaction();
			//Delete group info
			try{
				Criteria criteria = getCriteria(SmTbAccountGroup.class);
				SmTbAccountGroup grpVO = (SmTbAccountGroup)criteria.createCriteria("smTbVipAccount").add(Restrictions.eq("userId", userId)).uniqueResult();
				if(grpVO != null){
					session.delete(grpVO);
					Tool.logDebug("Delete group info of VIP:"+ userId +" success!", 1);
				}
			} catch (IllegalArgumentException e){
				System.err.println("[WARM]Delete VIP user with ERROR of cannot delete group info: "+e.getMessage());
			}
			
			//Delete detail info
			try{
				Query query = session.createQuery("delete SmTbVipAccountDetail where smTbVipAccount.userId = '" + userId + "'");
				Tool.logDebug("Delete detail info of VIP:"+ userId + ", total deletes:" +query.executeUpdate()+" record(s)!",1);
			} catch (Exception e){
				System.err.println("[WARM]Delete VIP user with ERROR of cannot delete detail info: "+e.getMessage());
			}
			
			//Delete user main record
			session.delete(retrieveUserById(userId));
			endTransaction();
		} catch (Exception e){
			rollbackTransaction();
			e.printStackTrace();
			return false;
		} finally {
			closeHibernateSession();
		}
		return true;
	}
	
	public static boolean isValiedUser(String username, String password){
		try{
			Criteria criteria = getCriteria(SmTbVipAccount.class);
			criteria.add(Restrictions.eq("username",username));
			criteria.add(Restrictions.eq("password",password));
			if(criteria.list().size() > 0)
				return true;
			else
				return false;
		} catch(Exception e){
			e.printStackTrace();
			return false;
		} finally {
			closeHibernateSession();
		}
	}
	
	/**
	 * Check the user is manager or not
	 * @param username
	 * @param password
	 * @return
	 */
	public static boolean isManager(String username, String password){
		return isInRole(username, password, MANAGER_ID);
	}
	
	/**
	 * Check the user is admin or not
	 * @param username
	 * @param password
	 * @return
	 */
	public static boolean isAdmin(String username, String password){
		return isInRole(username, password, ADMIN_ID);
	}
	
	/**
	 * Check the user is the role of roleName
	 * @param username
	 * @param password
	 * @param roleName
	 * @return
	 */
	public static boolean isInRole(String username, String password, String roleName){
		try{
			Criteria criteria = getCriteria(SmTbVipAccount.class);
			criteria.add(Restrictions.eq("username",username));
			criteria.add(Restrictions.eq("password",password));
			if(criteria.list().size() > 0){
				Set set = ((SmTbVipAccount)criteria.list().get(0)).getSmTbAccountGroups();
				Iterator iter = set.iterator();
				while(iter.hasNext()){
					SmTbAccountGroup vo = (SmTbAccountGroup)iter.next();
					if(roleName.equalsIgnoreCase(vo.getRoleType()))
						return true;
				}
			}
			return false;
		} catch(Exception e){
			e.printStackTrace();
			return false;
		} finally {
			closeHibernateSession();
		}
	}
	
	public static List<SmTbVipAccount> retrieveAllUser(){
		try{
			Criteria criteria = getCriteria(SmTbVipAccount.class);
			orderDesc(criteria,"crDate");
			return (List<SmTbVipAccount>)criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			closeHibernateSession();
		}
	}
	
	public static List<SmTbVipAccount> retrieveUserBetween(Integer startIdx, Integer endIdx, String sortColumnName, boolean isDesc){
		try{
			Criteria criteria = getCriteria(SmTbVipAccount.class);
			criteria.add(Restrictions.between("userId", startIdx, endIdx));
			if(sortColumnName!=null && !"".equalsIgnoreCase(sortColumnName)){
				if(isDesc)
					orderDesc(criteria,sortColumnName);
				else
					orderAsc(criteria,sortColumnName);
			}
			return (List<SmTbVipAccount>)criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			closeHibernateSession();
		}
	}
	
	public static TreeMap<String, Integer> retrieveAllUserMap(){
		List<SmTbVipAccount> all = retrieveAllUser();
		Iterator iter = all.iterator();
		TreeMap<String, Integer> hm = new TreeMap<String, Integer>();
		while(iter.hasNext()){
			SmTbVipAccount vo = (SmTbVipAccount)iter.next();
			hm.put(vo.getUsername(), vo.getUserId());
		}
		return hm;
	}
	
	public static TreeMap<Integer,String> retrieveAllUserMapIdNamePair(){
		List<SmTbVipAccount> all = retrieveAllUser();
		Iterator iter = all.iterator();
		TreeMap<Integer,String> hm = new TreeMap<Integer,String>();
		while(iter.hasNext()){
			SmTbVipAccount vo = (SmTbVipAccount)iter.next();
			hm.put(vo.getUserId(),vo.getUsername());
		}
		return hm;
	}
	
	public static TreeMap<String, Integer> retrieveManagerUserMap(){
		List<SmTbVipAccount> all = retrieveAllUser();
		if(all == null)
			return null;
		
		Iterator iter = all.iterator();
		TreeMap<String, Integer> hm = new TreeMap<String, Integer>();
		while(iter.hasNext()){
			SmTbVipAccount vo = (SmTbVipAccount)iter.next();
			Iterator giter = vo.getSmTbAccountGroups().iterator();
			inner:while(giter.hasNext()){
				if(SmsVipManager.MANAGER_ID.equalsIgnoreCase(((SmTbAccountGroup)giter.next()).getRoleType())){
					hm.put(vo.getVipChtName(), vo.getUserId());
					break inner;
				}
			} 
		}
		return hm;
	}
	
	/**
	 * #檢查有生過男生的VIP:
	 * select count(distinct(d.user_id)) from sms.sm_tb_vip_account_detail d where d.vip_child_sex = 'M';
	 * @param form
	 * @return
	 */
	public static List<SmTbVipAccount> retrieveUserByQueryForm(QueryVipForm form){
		if(form == null)
			return null;
		
		try{
			Criteria criteria = getCriteria(SmTbVipAccount.class);
//			enableFetchMode2Join(criteria, getMainFetchModeColumns()); //因為join,可能會有依筆資料出現兩次的情況
			
			//Use for filter the same object
			boolean isNeedFilter = false;
			
			log("Query: ");
			PrintUtil.printObject(form);
			/*
			 * 使用VIP名稱查詢
			 */
			addEqualCriteria(criteria, "username", form.getUsername());
			/*
			 * 使用VIP中文名稱查詢 
			 */
			addEqualCriteria(criteria, "vipChtName", form.getVipChtName());
			/*
			 * 使用VIP英文名稱查詢
			 */
			addEqualCriteria(criteria, "vipEngName", form.getVipEngName());
			/*
			 * 使用職稱查詢
			 */
			addEqualCriteria(criteria, "job", form.getJob());
			/*
			 * 使用購買總金額"大於"查詢
			 */
			addGeCriteria(criteria, "buySum", form.getBuySum());
			/*
			 * 使用是否為VIP查詢
			 */
			addEqualCriteria(criteria, "isValidVip", form.getIsValidVip());
			/*
			 * 使用VIP等級查詢
			 */
			addEqualCriteria(criteria, "vipLevel", form.getVipLevel());
			/*
			 * 使用SID等級查詢
			 */
			addEqualCriteria(criteria, "sid", form.getSid());
			/*
			 * 使用USER ID等級查詢
			 */
			if(form.getUserId()!= null && !"".equalsIgnoreCase(form.getUserId()) && new Integer(form.getUserId()) > 0)
				addEqualCriteria(criteria, "userId", new Integer(form.getUserId()));
			/*
			 * 使用OWNER查詢
			 */
			if(Tool.isNotEmpty(form.getOwner()) && form.getOwner() > 0){
				criteria.createCriteria("smTbVipAccount").add(Restrictions.eq("userId", form.getOwner()));
				isNeedFilter = true;
			}
			/*
			 * 使用孩童性別查詢
			 */
			if(Tool.isNotEmpty(form.getChildSex()) || Tool.isNotEmpty(form.getChildBirthday())){
				criteria.setFetchMode("smTbVipAccountDetails", FetchMode.JOIN);
				
				if(Tool.isNotEmpty(form.getChildSex())){
					criteria.createCriteria("smTbVipAccountDetails").add(Restrictions.eq("vipChildSex", form.getChildSex()));
					isNeedFilter = true;
				}
			}
			
			/*
			 * 依創造日期反向排序
			 */
			orderDesc(criteria, "crDate");
			
			List<SmTbVipAccount> accounts = (List<SmTbVipAccount>)criteria.list();
			log("acounts size: " + accounts.size());
			
			//Filter of specify birthday of vips and childs
			if(Tool.isNotEmpty(form.getBirthday()) || Tool.isNotEmpty(form.getChildBirthday())){
				int vipQueryMonth = Tool.isNotEmpty(form.getBirthday()) ? new Integer(form.getBirthday()).intValue(): 0;
				int childQueryMonth = Tool.isNotEmpty(form.getChildBirthday()) ? new Integer(form.getChildBirthday()).intValue(): 0;
				log("要查詢的月份為:" + vipQueryMonth + ";孩童生日月份:" + childQueryMonth + "; accounts size:" + accounts.size());
				HashMap hm = new HashMap();
				List<SmTbVipAccount> newAccounts = new ArrayList<SmTbVipAccount>();
				
				for(SmTbVipAccount vo : accounts){
					
					boolean isRmvVO1 = false; //查詢VIP生日
					boolean isRmvVO2 = true; //查詢VIP孩童生日
//					boolean isRmvVO3 = true; //查詢VIP孩童性別
					//查詢VIP生日月份欄位
					//如生日欄位為空，且生日不在指定月份，則註記移除此筆資料
					if (vo.getBirthday() == null || 
							!isDateInMonth(vo.getBirthday().getTime(), vipQueryMonth)){
						isRmvVO1 = true;
					}
					
					//查詢孩童生日月份欄位
					//如孩童生日月份欄位為空，且有任一位孩童生日在指定月份，則註記留住該孩童資料
					if (vo.getSmTbVipAccountDetails() != null ){
						check2:for(SmTbVipAccountDetail vipDetail : vo.getSmTbVipAccountDetails()){
							if(form.getChildBirthday() != null &&
								isDateInMonth(vipDetail.getVipChildBirthday(), childQueryMonth)){
								isRmvVO2 = false;
								break check2;
							}
//							
//							if(form.getChildSex() != null && 
//									form.getChildSex().equalsIgnoreCase(vipDetail.getVipChildSex())){
//								isRmvVO3 = false;
//								break check2;
//							}
						}
					}
					
					
					
//					log("isRmvVO1:"+ isRmvVO1 +";isRmvVO2:" + isRmvVO2 + ";isRmvVO3:" + isRmvVO3 + ";hm: " + hm.get(vo.getUserId()));
					
					//如VIP及孩童生日註記有一為true時，且該VIP不與list中資料重複，新list中增加此筆資料
					if((!isRmvVO1 || !isRmvVO2) && 
							(hm.get(vo.getUserId()) == null)){
							hm.put(vo.getUserId(), vo.getUserId());
							newAccounts.add(vo);
					}
				}
				
				log("newAccounts size:"+ newAccounts.size() + 
						";flag:" + (Tool.isNotEmpty(form.getChildSex()) || Tool.isNotEmpty(form.getChildBirthday())));
				
//				Why....??必須重新再filter一次!
				int sum = 0;
				int sum2 = 0;
				List<SmTbVipAccount> newAccounts2 = new ArrayList<SmTbVipAccount>();
				for(SmTbVipAccount vo : newAccounts){
					boolean b = false;
					for(SmTbVipAccountDetail detail : vo.getSmTbVipAccountDetails()){
						if(isDateInMonth(detail.getVipChildBirthday().getTime(), childQueryMonth) && 
								(Tool.isNotEmpty(form.getChildSex())?
										form.getChildSex().equalsIgnoreCase(detail.getVipChildSex()):true)){
							sum ++;
							b = true;
						} 
					}
					if(b){
						sum2 ++;
						newAccounts2.add(vo);
					}
				}
				log("------------>sum:"+sum + ";sum2:"+ sum2);
				
				return newAccounts2;
			}
			
			if(isNeedFilter){
				HashMap hm = new HashMap();
				List<SmTbVipAccount> newAccounts = new ArrayList<SmTbVipAccount>();
				
				for(SmTbVipAccount vo : accounts){
					if(hm.get(vo.getUserId()) == null){
						hm.put(vo.getUserId(), vo.getUserId());
						newAccounts.add(vo);
					}
				}
				
				return newAccounts;
			}
			
			return accounts;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			closeHibernateSession();
		}
		
	}
	
	private static boolean isDateInMonth(String date, String pattern, int month){
		return isDateInMonth(DateUtil.getDateFromString(date, pattern), month);
	}
	
	public static boolean isDateInMonth(long date, int month){
		return isDateInMonth(new Date(date), month);
	}
	
	public static boolean isDateInMonth(java.util.Date date, int month){
		if(date.getMonth() + 1 == month)
			return true;
		return false;
	}
	
	public static SmTbVipAccount retrieveUserById(int userId){
		return retrieveUserById(new Integer(userId));
	}
	
	public static SmTbVipAccount retrieveUserById(Integer userId){
		try{
			Criteria criteria = getCriteria(SmTbVipAccount.class);
			criteria.add(Restrictions.eq("userId", userId));
			enableFetchMode2Join(criteria, getMainFetchModeColumns());
			SmTbVipAccount vo = (SmTbVipAccount)criteria.uniqueResult();
			
			return vo;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			closeHibernateSession();
		}
	}
	
	public static List<SmTbVipAccount> retrieveUserByOwnerId(Integer ownerId){
		try{
			Criteria criteria = getCriteria(SmTbVipAccount.class);
			criteria.createCriteria("smTbVipAccount").add(Restrictions.eq("userId", ownerId));
			orderDesc(criteria,"crDate");
			return (List<SmTbVipAccount>)criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			closeHibernateSession();
		}
	}
	
	public static SmTbVipAccount retrieveUserByName(String username){
		try{
			Criteria criteria = getCriteria(SmTbVipAccount.class);
			criteria.add(Restrictions.eq("username", username));
			SmTbVipAccount vo = (SmTbVipAccount)criteria.uniqueResult();
			return vo;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			closeHibernateSession();
		}
	}
	
	public static int retrieveUserIdByName(String username){
		SmTbVipAccount vo = retrieveUserByName(username);
		return vo!=null?vo.getUserId():0;
	}
	
	/**
	 * Retrieve user by example
	 * @param vo
	 * @return
	 */
	public static List<SmTbVipAccount> retrieveUserByExample(SmTbVipAccount vo){
		try{
			Criteria criteria = getCriteria(SmTbVipAccount.class);
			criteria.add(Example.create(vo));
			enableFetchMode2Join(criteria, getMainFetchModeColumns());
			return (List<SmTbVipAccount>)criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeHibernateSession();
		}
		return null;
	}
	
	/**
	 * To enable the fetch mode to join of the specific columns
	 * @param criteria
	 * @param columns
	 * @return
	 */
	private static Criteria enableFetchMode2Join(Criteria criteria, String[] columns){
		
		for(String column: columns){
			criteria.setFetchMode(column, FetchMode.JOIN);
		}
		
		return criteria;
	}
	
	private static String[] getMainFetchModeColumns(){
		String[] result = {
				"smTbAccountPrepays1",
				"smTbAccountPrepays2",
				"smTbAccountPrepays3",
				"smTbProductGroups",
				"smTbProducts",
				"smTbSaleItems1",
				"smTbSaleItems2",
				"smTbSaleRecords1",
				"smTbSaleRecords2",
				"smTbVipAccountDetails",
				"smTbVipAccounts",
				"smTbAccountGroups",
				"smTbVipAccount"
		};
		return result;
	}
	/********************************************Vip Children Management***********************************************/
	public static List<SmTbVipAccountDetail> retrieveChildByUserName(String username){
		int id = retrieveUserIdByName(username);
		return retrieveChildByUserId(id);
	}
	
	public static List<SmTbVipAccountDetail> retrieveChildByUserId(int userId){
		try{
			Criteria criteria = getCriteria(SmTbVipAccountDetail.class);
//			criteria.setFetchMode("smTbVipAccount", FetchMode.DEFAULT);
			
			criteria.createCriteria("smTbVipAccount").add(Restrictions.eq("userId", new Integer(userId)));
			
			return (List<SmTbVipAccountDetail>)criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			closeHibernateSession();
		}
	}
	
	public static SmTbVipAccountDetail retrieveChildByUserIdAndChildName(int userId, String childName){
		try{
			Criteria criteria = getCriteria(SmTbVipAccountDetail.class);
			criteria.createCriteria("smTbVipAccount").add(Restrictions.eq("userId", userId));
			criteria.add(Restrictions.eq("vipChildName", childName));
			return (SmTbVipAccountDetail)criteria.list().get(0);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			closeHibernateSession();
		}
	}
	
	/**
	 * For prevent the web present only idx to update data
	 * @param username
	 * @param childIdx
	 * @return
	 */
	public static SmTbVipAccountDetail retrieveChildByUsernameAndChildIdx(String username, int childIdx){
		try{
			Criteria criteria = getCriteria(SmTbVipAccountDetail.class);
			criteria.createCriteria("smTbVipAccount").add(Restrictions.eq("username", username));
			criteria.add(Restrictions.eq("idx", childIdx));
			return (SmTbVipAccountDetail)criteria.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			closeHibernateSession();
		}
	}
	
	public static SmTbVipAccountDetail retrieveChildByChildIdx(int childIdx){
		try{
			Criteria criteria = getCriteria(SmTbVipAccountDetail.class);
			criteria.add(Restrictions.eq("idx", childIdx));
			return (SmTbVipAccountDetail)criteria.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			closeHibernateSession();
		}
	}
	
	/**
	 * Get all the child from sex arguement, it may happen people has more then one child will has more then one record.
	 * @param vipChildSex
	 * @return
	 */
	public static List<SmTbVipAccountDetail> retrieveChildByChildSex(String vipChildSex){
		try{
			Criteria criteria = getCriteria(SmTbVipAccountDetail.class);
			criteria.add(Restrictions.eq("vipChildSex", vipChildSex));
			return (List<SmTbVipAccountDetail>)criteria.list();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			closeHibernateSession();
		}
	}
	
	public static boolean createChildByUserId(int userId, 
			String vipChildName, java.sql.Date vipChildBirthday, String vipChildSex){
		try{
			session = currentSession();
			beginTransaction();
			SmTbVipAccount account = SmsVipManager.retrieveUserById(userId);
			
			SmTbVipAccountDetail vo = new SmTbVipAccountDetail();
			vo.setSmTbVipAccount(account);
			vo.setVipChildName(vipChildName);
			vo.setVipChildBirthday(vipChildBirthday);
			vo.setVipChildSex(vipChildSex);
			session.save(vo);
			
			endTransaction();
		} catch(ConstraintViolationException e ){
			rollbackTransaction();
			System.err.println("[ERROR]"+SmsVipManager.class+": Hibernate ConstraintViolationException, Please check the duplicate userId!");
			return false;
		} catch (Exception e){
			e.printStackTrace();
			return false;
		} finally {
			closeHibernateSession();
		}
		return true;
	}
	
//	public static boolean createChildByUserId(int userId, Map<String, Long> child){
//		try{
//			session = currentSession();
//			beginTransaction();
//			SmTbVipAccount account = SmsVipManager.retrieveUserById(userId);
//			Iterator iter = child.keySet().iterator();
//			while(iter.hasNext()){
//				String key = (String)iter.next();
//				SmTbVipAccountDetail vo = new SmTbVipAccountDetail();
//				vo.setSmTbVipAccount(account);
//				vo.setVipChildName(key);
//				vo.setVipChildBirthday(new Date((Long)child.get(key)));
//				session.save(vo);
//			}
//			
//			endTransaction();
//		} catch(ConstraintViolationException e ){
//			rollbackTransaction();
//			System.err.println("[ERROR]"+SmsVipManager.class+": Hibernate ConstraintViolationException, Please check the duplicate userId!");
//			return false;
//		} catch (Exception e){
//			e.printStackTrace();
//			return false;
//		} finally {
//			closeHibernateSession();
//		}
//		return true;
//	}
	
	/**
	 * Delete all children records of this userId
	 * @param userId
	 * @return
	 */
	public static boolean deleteAllChildByUserId(int userId){	
		session = currentSession();
		
		try{
			beginTransaction();
			Query query = session.createQuery("delete SmTbVipAccountDetail where smTbVipAccount.userId = '" + userId + "'");
			log("Delete result: "+query.executeUpdate());
			endTransaction();
		} catch (Exception e){
			rollbackTransaction();
			e.printStackTrace();
			return false;
		} finally{
			closeHibernateSession();
		}
		
		
		return true;
	}
	
	/**
	 * Delete by condition of userId and childName
	 * @param userId
	 * @param childName
	 * @return
	 */
	public static boolean deleteChildByUserIdAndChildName(int userId, String childName){
		if(!isSqlKeyValidate(childName))
			return false;
		
		session = currentSession();
		try{
			beginTransaction();
			Query query = session.createQuery(
					"delete SmTbVipAccountDetail where smTbVipAccount.userId = '" + 
					userId + "' and vipChildName = '"+ childName + "'");
			log("Delete result: "+query.executeUpdate());
			
			endTransaction();
		} catch (Exception e) {
			rollbackTransaction();
			e.printStackTrace();
			return false;
		} finally {
			closeHibernateSession();
		}
		return true;
	}
	
	/**
	 * Double confirm to delete with userId
	 * @param userId
	 * @param childIdx
	 * @return
	 */
	public static boolean deleteChildByUserIdAndChildIdx(int userId, int childIdx){
		session = currentSession();
		try{
			beginTransaction();
			Query query = session.createQuery(
					"delete SmTbVipAccountDetail where smTbVipAccount.userId = '" + 
					userId + "' and idx = '"+ childIdx + "'");
			log("Delete result: "+query.executeUpdate());
			
			endTransaction();
		} catch (Exception e) {
			rollbackTransaction();
			e.printStackTrace();
			return false;
		} finally {
			closeHibernateSession();
		}
		return true;
	}
	
	/**
	 * Should be pay attention to using on web parameter scope.
	 * @param childIdx
	 * @return
	 */
	public static boolean deleteChildByChildIdx(int childIdx){
		session = currentSession();
		try{
			beginTransaction();
			Query query = session.createQuery(
					"delete SmTbVipAccountDetail where idx = '"+ childIdx + "'");
			log("Delete result: "+query.executeUpdate());
			
			endTransaction();
		} catch (Exception e) {
			rollbackTransaction();
			e.printStackTrace();
			return false;
		} finally {
			closeHibernateSession();
		}
		return true;
	}
	
	public static boolean updateChildByUserIdAndChildName(String username, int childIdx, String childName, java.util.Date birthday, String childSex){
		try{
			beginTransaction();
			int id = retrieveUserIdByName(username);
			boolean b = SmsVipManager.updateChildByUserIdAndChildName(id, childIdx, 
					childName, new java.sql.Date(birthday.getTime()), childSex);
			endTransaction();
			return b;
		} catch (Exception e) {
			rollbackTransaction();
			e.printStackTrace();
			return false;
		} finally {
			closeHibernateSession();
		}
		
	}
	
	public static boolean updateChildByUserIdAndChildName(int userId, int childIdx, String childName, java.sql.Date birthday, String childSex){
		session = currentSession();
		try{
			beginTransaction();
			String sql = "update SmTbVipAccountDetail " +
			"set vip_child_name = '" + childName + "', vip_child_birthday ='"+ birthday +"', vip_child_sex ='"+ childSex + "' "+
			"where smTbVipAccount.userId = '" + 
			userId + "' and idx = '"+ childIdx + "'";
			Query query = session.createQuery(sql);
			log("Update SQL: " + sql);
			log("Update result: "+query.executeUpdate());
			endTransaction();
		} catch (Exception e) {
			rollbackTransaction();
			e.printStackTrace();
			return false;
		} finally {
			closeHibernateSession();
		}
		return true;
	}
	
	public static boolean updateChildByUserId(int userId, List<SmTbVipAccountDetail> children){
		try{
			session = currentSession();
			beginTransaction();
			Iterator childIter = children.iterator();
			HashMap nameMap = new HashMap();
			HashMap birthMap = new HashMap();
			while(childIter.hasNext()){
				SmTbVipAccountDetail vo = (SmTbVipAccountDetail)childIter.next();
				nameMap.put(vo.getIdx(), vo.getVipChildName());
				birthMap.put(vo.getIdx(), vo.getVipChildBirthday());
			}
			
			List<SmTbVipAccountDetail> childList = SmsVipManager.retrieveChildByUserId(userId);
			Iterator iter = childList.iterator();
			while(iter.hasNext()){
				SmTbVipAccountDetail vo = (SmTbVipAccountDetail)iter.next();
				vo.setVipChildName((String)nameMap.get(vo.getIdx()));
				vo.setVipChildBirthday((Date)birthMap.get(vo.getIdx()));
				session.save(vo);
			}
			
			endTransaction();
		} catch(ConstraintViolationException e ){
			rollbackTransaction();
			System.err.println("[ERROR]"+SmsVipManager.class+": Hibernate ConstraintViolationException, Please check the duplicate userId!");
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
	
	/******************************* Daemon Action *******************************/
	public static boolean updateVipChildOverOld(int yearsOld){
		List<String> sqlList = new ArrayList<String>();
		String sql = "insert into sm_tb_vip_account_detail_his " +
				"(select * from sm_tb_vip_account_detail o " +
				"where CURRENT_DATE > DATE_ADD(o.vip_child_birthday, INTERVAL "+ yearsOld+" YEAR)) ";
		sqlList.add(sql);
		String sql2 = "delete from sm_tb_vip_account_detail " +
				"where CURRENT_DATE > DATE_ADD(vip_child_birthday, INTERVAL "+ yearsOld+" YEAR) ";
		sqlList.add(sql2);
		return doExecuteBatchSQL(sqlList);
	}
	
	public static boolean queryVipChildOverOld(int yearOld){
		String sql = "select * from sm_tb_vip_account_detail o where CURRENT_DATE > DATE_ADD(o.vip_child_birthday, INTERVAL "+yearOld+" YEAR)";
		session = currentSession();
		Connection conn = session.connection();
		PreparedStatement ps = null;
		try {
			conn.setAutoCommit(false);
			log("query sql:" + sql);
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				log("Will update idx: " + rs.getString("idx"));
			}
			conn.commit();
			conn.setAutoCommit(true);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			return false;
		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			closeHibernateSession();
		}
	}
	
	
	/*******************************************************************************************/
	
	@Override
	public void commonObjInit() {
		// TODO Auto-generated method stub
		
	}

	private void log(String msg, int level){
		Tool.logDebug("[SmsVipManager] "+msg, level);
	}
}
