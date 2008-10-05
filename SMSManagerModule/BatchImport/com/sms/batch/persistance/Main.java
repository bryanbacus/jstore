package com.sms.batch.persistance;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Timestamp;
import java.util.Date;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.exception.ConstraintViolationException;

import com.shenming.sms.dc.manager.SmsManager;
import com.shenming.sms.dc.manager.SmsVipManager;
import com.shenming.sms.module.hibernateOrm.SmTbAccountGroup;
import com.shenming.sms.module.hibernateOrm.SmTbVipAccount;
import com.shenming.sms.module.hibernateOrm.SmTbVipAccountDetail;
import com.shenming.sms.util.DateUtil;

public class Main extends SmsManager{
	public static String path = "C:/Documents and Settings/simon/桌面/sms problems/20080118-Import";
	public static String filename = path + "/002.csv";
	public static String filenameOfChild = path + "/002-child.csv";
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		initialize();
//		autoCloseSession = false;
		log("Main start ...........................");
		saveVip(args);
		saveChild(filenameOfChild);
		log("Main end ...........................");
	}
	
	public static SmTbVipAccount retrieveUserById(Session session, Integer userId){
		try{
			Criteria criteria = session.createCriteria(SmTbVipAccount.class);
			criteria.add(Restrictions.eq("userId", userId));
			SmTbVipAccount vo = (SmTbVipAccount)criteria.uniqueResult();
			return vo;
		} catch (Exception e) {
			System.out.println("Cannot retrieve userId: "+ userId);
			e.printStackTrace();
			return null;
		} finally {
			closeHibernateSession();
		}
	}
	
	public static void generateChildInsertSQL(String file) {
//		SmsVipManager.initialize();
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(file)));
			String line = "";
			Integer owner = null;
			int lineNum = 0;
			try {
				inner:while((line = br.readLine())!= null){
					lineNum ++;
					log("Parsing line..."+ lineNum);
					try{
						String str[] = line.split(",");
						owner = (str.length == 4) ? new Integer(str[0]) : owner;
						
					} catch (Exception e){
						catchException(e, "*******Unhandled exception! When parsing: [" + line + "]");
						rollbackTransaction();
					} finally {
						closeHibernateSession();
					}
					
				}
			} catch (IOException e) {
				catchException(e, "IO Exception!");
			} catch (Exception e){
				catchException(e, "*******Unhandled exception! When parsing: [" + line + "]");
			}
			
		} catch (FileNotFoundException e) {
			catchException(e, "File not found!");
		}
	}
	
	public static void saveChild(String file) {
		SmsVipManager.initialize();
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(file)));
			String line = "";
			SmTbVipAccount owner = null;
			int lineNum = 0;
			try {
				inner:while((line = br.readLine())!= null){
					session = currentSession();
					setAutoCloseSession(false);
					lineNum ++;
					log("Parsing line..."+ lineNum);
					try{
						beginTransaction();
						String str[] = line.split(",");
						owner = (str.length == 4)?SmsVipManager.retrieveUserById(new Integer(str[0])):owner;
						
						if(str.length < 4 || str[1] ==null || "".equalsIgnoreCase(str[1]) || 
								str[2] ==null || "".equalsIgnoreCase(str[2]) || 
								str[3] ==null || "".equalsIgnoreCase(str[3]))
							continue inner;
						
						SmTbVipAccountDetail detail = new SmTbVipAccountDetail();
						detail.setSmTbVipAccount(owner);
						detail.setVipChildName(str[1]);
						String tmpDate = str[2];
	//					System.out.println("tmpDate-->" + tmpDate);
						String dateColumn[] = tmpDate.split("/");
						String newDate = (new Integer(dateColumn[0]) + 1911)+ "-" + dateColumn[1] +"-" + dateColumn[2];
	//					System.out.println("newDate-->" + newDate);
						try{
							detail.setVipChildBirthday(DateUtil.getSqlDateFromString(newDate,DateUtil.DATE_FORMAT_YEAR_MONTH_DAY_DASH));
						} catch (Exception e){
							detail.setVipChildBirthday(DateUtil.getSqlDateFromString("1911-01-01",DateUtil.DATE_FORMAT_YEAR_MONTH_DAY_DASH));
						}
						detail.setVipChildSex("男".equalsIgnoreCase(str[3])?"M":"F");
						try{
							boolean isSuccess = SmsVipManager.doCreateOrUpdate(detail);
							endTransaction();
							System.out.println("Save child ["+ line + "] " + isSuccess);
						} catch (Exception e){
							catchException(e, "*******Unhandled exception! When parsing: [" + line + "]");
						} 

//						setAutoCloseSession(true);
					} catch (Exception e){
						catchException(e, "*******Unhandled exception! When parsing: [" + line + "]");
						rollbackTransaction();
					} finally {
						closeHibernateSession();
					}
					setAutoCloseSession(true);
				}
			} catch (IOException e) {
				catchException(e, "IO Exception!");
			} catch (Exception e){
				catchException(e, "*******Unhandled exception! When parsing: [" + line + "]");
			}
			
		} catch (FileNotFoundException e) {
			catchException(e, "File not found!");
		}
	}
	
	public static void saveVip(String[] args) {
		SmsVipManager.initialize();
//		SmsVipManager.setAutoCloseSession(false);
		SmTbVipAccount owner = SmsVipManager.retrieveUserById(2102);
		int i = 0;
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File(filename)));
			String line = "";
			try {
				
				inner:while((line = br.readLine())!= null){
					i++;
					log("Parsing line [" + i + "]");
					try{
//						session = currentSession();
//						beginTransaction();
						String str[] = line.split(",");
						if(str.length < 10)
							continue inner;
							
						SmTbVipAccount vo = new SmTbVipAccount();
						vo.setUserId(new Integer(str[0]));
						vo.setUsername(str[0]);
						vo.setPassword(str[0]);
						vo.setVipChtName(str[1]);
						vo.setSid(str[2]);
						vo.setAddress(str[3]);
						vo.setPhone(str[4]);
						vo.setMobile(str[5]);
						vo.setSex("男".equalsIgnoreCase(str[6])?"M":"F");
						vo.setIsValidVip("非VIP用戶".equalsIgnoreCase(str[7])?"N":"Y");
						vo.setSmTbVipAccount(owner);
						vo.setVipLevel(str[9]);
						
						vo.setCrDate(new Timestamp(new Date().getTime()));
						vo.setBuySum(0);
						vo.setIsAccountActive("Y");
						vo.setVipEngName(str[0]);
						vo.setMailAddr("");
						
//						session.saveOrUpdate(vo);
						doCreateOrUpdate(vo);
						log("Insert user: "+ vo.getUserId() + " success!");
						
						SmTbAccountGroup grp = new SmTbAccountGroup();
						grp.setRoleType("VIP");
						grp.setSmTbVipAccount(vo);
						grp.setDescription("batch insert");

//						session.saveOrUpdate(grp);
						doCreateOrUpdate(grp);
						log("Insert user group: "+ vo.getUserId() + " success!");

//						endTransaction();
					}catch (Exception e){
						catchException(e, "Unhandled Exception! When parsing line "+ i + ": " + line);
					}
				}
//				SmsVipManager.setAutoCloseSession(true);
			} catch (IOException e) {
				rollbackTransaction();
				catchException(e, "IO Exception!");
			}
			
		} catch (FileNotFoundException e) {
			catchException(e, " File not found!");
		}
	}

	@Override
	public void commonObjInit() {
		// TODO Auto-generated method stub
		
	}
	
	public static void catchException(Exception e, String msg){
//		e.printStackTrace();
		System.err.println("["+e.getMessage()+"] " + msg);
//		System.exit(1);		
	}

}
