/**
 * 
 */
package com.shenming.sms.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.SimpleTimeZone;
import java.util.TimeZone;
import java.math.*;


/**
 * @author justin
 *
 */
public class DateUtil {
	public static final String DATE_FORMAT_YEAR = "yyyy";
	
	//Format for Year/Month/Day
	public static final String DATE_FORMAT_YEAR_MONTH_DAY_TIME_DASH = "yyyy-MM-dd HH:mm:ss";
	public static final String DATE_FORMAT_YEAR_MONTH_DAY_DASH = "yyyy-MM-dd";
	public static final String DATE_FORMAT_YEAR_MONTH_DASH = "yyyy-MM";
	
	public static final String DATE_FORMAT_YEAR_MONTH_DAY_TIME_SLASH = "yyyy/MM/dd HH:mm:ss";
	public static final String DATE_FORMAT_YEAR_MONTH_DAY_SLASH = "yyyy/MM/dd";
	public static final String DATE_FORMAT_YEAR_MONTH_SLASH = "yyyy/MM";
	
	public static final String DATE_FORMAT_YEAR_MONTH_DAY_TIME_UNDERLINE = "yyyy_MM_dd HH:mm:ss";
	public static final String DATE_FORMAT_YEAR_MONTH_DAY_UNDERLINE = "yyyy_MM_dd";
	public static final String DATE_FORMAT_YEAR_MONTH_UNDERLINE = "yyyy_MM";
	
	//Format for Day/Month/Year
	/**
	 * dd-MM-yyyy HH:mm:ss
	 */
	public static final String DATE_FORMAT_DAY_MONTH_YEAR_TIME_DASH = "dd-MM-yyyy HH:mm:ss";
	/**
	 * dd-MM-yyyy
	 */
	public static final String DATE_FORMAT_DAY_MONTH_YEAR_DASH = "dd-MM-yyyy";
	/**
	 * MM-yyyy
	 */
	public static final String DATE_FORMAT_MONTH_YEAR_DASH = "MM-yyyy";
	
	public static final String DATE_FORMAT_DAY_MONTH_YEAR_TIME_SLASH = "dd/MM/yyyy HH:mm:ss";
	public static final String DATE_FORMAT_DAY_MONTH_YEAR_SLASH = "dd/MM/yyyy";
	public static final String DATE_FORMAT_MONTH_YEAR_SLASH = "MM/yyyy";
	
	public static final String DATE_FORMAT_DAY_MONTH_YEAR_TIME_UNDERLINE = "dd_MM_yyyy HH:mm:ss";
	public static final String DATE_FORMAT_DAY_MONTH_YEAR_UNDERLINE = "dd_MM_yyyy";
	public static final String DATE_FORMAT_MONTH_YEAR_UNDERLINE = "MM_yyyy";
	
	public static final String DATE_FORMAT_MONTH_DAY_YEAR_TIME_DASH = "MM-dd-yyyy HH:mm:ss";
	
	/**
	 * 
	 */
	public DateUtil() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public boolean isInPeriod(Date beginDate, Date endDate, Date inputDate) {
	
		Calendar cal1 = new GregorianCalendar();
		Calendar cal2 = new GregorianCalendar();
		Calendar cal3 = new GregorianCalendar();
		
		cal1.setTime(beginDate);
		cal2.setTime(endDate);
		cal3.setTime(inputDate);
		
		Calendar maxCalendar;
		boolean theSame = false;
		
		//Date order 
		if ( cal1.getTimeInMillis() > cal2.getTimeInMillis() ) {
			maxCalendar = cal1;
			cal1 = cal2;
			cal2 = maxCalendar;
		}else if ( cal1.getTimeInMillis() == cal2.getTimeInMillis() ) {
			theSame = true;
		}else {
			//Do not thing, without change
		}
		
		//Date Compare
		if ( theSame ) {
			if ( cal1.getTimeInMillis() == cal3.getTimeInMillis() ) {
				return true;
			}
		}else {
			if ( (cal1.getTimeInMillis() < cal3.getTimeInMillis()) 
				&& (cal3.getTimeInMillis() < cal2.getTimeInMillis()) ) {
				return true;
			}
		}
		
		return false;
	}
	
	public String getSystemDate(String psFormat) {
		String sDate = "";
		Calendar cal = Calendar.getInstance();
		Date currentDate = cal.getTime();
		
		//Set Date Format
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat(psFormat);
			sDate = dateFormat.format(currentDate);
		}catch (Exception ex) {
			//IF Error Return year-month-day format
			SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT_YEAR_MONTH_DAY_DASH);
			sDate = dateFormat.format(currentDate);
		}
		
		return sDate;
	}
	
//	/**
//	 * Usage: String dateString = DateUtil.convertDateToString(new Date(), "MM-dd-yyyy HH:mm:ss");
//	 * @param date
//	 * @param pattern
//	 * @return
//	 */
//	public static String convertDateToLunarString(Date date, String pattern){
//		String result = "";
//		try {
//			SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
//			result = dateFormat.format(date);
//			return result;
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
	
	/**
	 * Usage: String dateString = DateUtil.convertDateToString(new Date(), "MM-dd-yyyy HH:mm:ss");
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String convertDateToString(Date date, String pattern){
		String result = "";
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
			result = dateFormat.format(date);
			return result;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Date getSystemDate() {
		Calendar cal = Calendar.getInstance();
		Date currentDate = cal.getTime();
		
		return currentDate;
	}
	
	public static java.sql.Date getSystemSqlDate() {
		return new java.sql.Date(new java.util.Date().getTime());
	}
	
	public static java.sql.Timestamp getSystemSqlTimestamp() {
		return new java.sql.Timestamp(new java.util.Date().getTime());
	}
	
	/**
	 * Usage: DateUtil.isValiedDate("05-01-2007 16:31:26", "MM-dd-yyyy HH:mm:ss")
	 * Result: If result true for the date is validated, vice versa.
	 * Note: The "0" of each column cannot be ignore. 
	 * For example:
	 * "05-01-2007 16:31:26" != "5-1-2007 16:31:26"
	 * @param dateTimeString
	 * @param pattern
	 * @return
	 */
	public static boolean isValiedDate(String dateTimeString, String pattern){
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		try {
			Timestamp ts = new java.sql.Timestamp(df.parse(dateTimeString).getTime());
			
			String converted = Tool.convertDate(new Date(ts.getTime()), pattern);
			System.out.println(converted);
			if(converted.equalsIgnoreCase(dateTimeString)){
				System.out.println("Time is right!!");
				return true;
			}else
				System.out.println("Time is wrong!!");
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * Return the date interval of double type
	 * @param dateTimeString1
	 * @param dateTimeString2
	 * @param pattern
	 * @return
	 */
	public static double getDateInterval(String dateTimeString1, String dateTimeString2, String pattern){
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		try {
			Timestamp ts1 = new java.sql.Timestamp(df.parse(dateTimeString1).getTime());
			Timestamp ts2 = new java.sql.Timestamp(df.parse(dateTimeString2).getTime());
			double i = ts2.getTime() - ts1.getTime();
//			System.out.println(i);
			return i;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * Return the date interval with divide to 86400000 (one date)
	 * @param dateTimeString1
	 * @param dateTimeString2
	 * @param pattern
	 * @return
	 */
	public static double getDateIntervalOfDate(String dateTimeString1, String dateTimeString2, String pattern){
		return DateUtil.getDateInterval(dateTimeString1, dateTimeString2, pattern)/86400000;
	}
	
	/**
	 * Return the date interval with divide to 3600000 (one hour)
	 * @param dateTimeString1
	 * @param dateTimeString2
	 * @param pattern
	 * @return
	 */
	public static double getDateIntervalOfHour(String dateTimeString1, String dateTimeString2, String pattern){
		return DateUtil.getDateInterval(dateTimeString1, dateTimeString2, pattern)/3600000;
	}
	
	/**
	 * Get the given days ago Dats String
	 * @param i how many days ago.
	 * @return 
	 */
	public static String getDateDaysAgo(int days, String pattern) {
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		long dateTimeM = Calendar.getInstance().getTimeInMillis() / 60000
				- (long) (days * 24 * 60);
		return df.format(new Date(dateTimeM * 60000));
	}

	/**
	 * Get date String of the given days after
	 * @param i how many days after.
	 * @return
	 */
	public static String getDateDaysAfter(int days, String pattern) {
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		long dateTimeM = Calendar.getInstance().getTimeInMillis() / 60000
				+ (long) (days * 24 * 60);
		return df.format(new Date(dateTimeM * 60000));
	}
	
	/**
	 * Get the given days ago Dats String
	 * @param i how many days ago.
	 * @return 
	 */
	public static String getDateHoursAgo(int hours, String pattern) {
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		long dateTimeM = Calendar.getInstance().getTimeInMillis() / 60000
				- (long) (hours * 60);
		return df.format(new Date(dateTimeM * 60000));
	}

	/**
	 * Get date String of the given days after
	 * @param i how many days after.
	 * @return
	 */
	public static String getDateHoursAfter(int hours, String pattern) {
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		long dateTimeM = Calendar.getInstance().getTimeInMillis() / 60000
				+ (long) (hours * 60);
		return df.format(new Date(dateTimeM * 60000));
	}
	
	public static String getDateHoursAfterFromString(String dateTimeString, int hours, String pattern) {
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		try {
			Timestamp ts1 = new java.sql.Timestamp(df.parse(dateTimeString).getTime());
			long dateTimeHoursAfter = ts1.getTime() + (hours * 3600000);
			return df.format(new Date(dateTimeHoursAfter));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static long getOfficeDateInterval(String dateTimeString1, String dateTimeString2, String pattern){
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		long oneHour = 3600000;
		long oneDate = 3600000 * 24 ;
		long totalHours = 0;
		try {
			Timestamp ts1 = new java.sql.Timestamp(df.parse(dateTimeString1).getTime());
			long t1 = ts1.getTime();
			//無條件捨去小於一各小時的時間
			if(ts1.getTime() % 3600000 > 0)
				t1 = t1 - ts1.getTime() % oneHour;
			Timestamp ts2 = new java.sql.Timestamp(df.parse(dateTimeString2).getTime());
			long t2 = ts2.getTime();
			if(ts2.getTime() % 3600000 > 0)
				t2 = t2 - ts2.getTime() % oneHour;
			
			while(t2-t1 > 0){
//				還沒上班
				while(new Date(t1).getHours() < 9){
					log("==>need shift: "+new Date(t1));
					t1 = t1 + 1* oneHour;
					log("==>after shift: "+new Date(t1));
				}
				log("t1:"+new Date(t1)+"==t2:"+new Date(t2)+"==total:"+totalHours);
				t1 = t1 + oneHour;
				totalHours++;
				log("currentTotal: "+totalHours);
				
				//中午休息
				if(new Date(t1).getHours() == 12 ){
					t1 = t1 + 1*oneHour;
				}
				
				//下班時間
				if(new Date(t1).getHours() >= 18){
					log("==>need shift: "+new Date(t1));
					t1 = t1 + 15 * oneHour ;
					log("==>after shift: "+new Date(t1));
				}
					
//				log("Iterator times: "+(t2-t1)/oneHour);
				
				//假日時間
				if(isHoliday(t1)){
					log(">>>a holiday: "+ new Date(t1));
					t1 = t1 + 24 * oneHour;
					log(">>>after shift: "+ new Date(t1));
				}
			}
			log("total: " + totalHours);
			return totalHours;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static int getDayOfWeek(long dayTime){
		String[] ids = TimeZone.getAvailableIDs(+8 * 60 * 60 * 1000);
		SimpleTimeZone pdt = new SimpleTimeZone(+8 * 60 * 60 * 1000, ids[0]);
		Calendar calendar = new GregorianCalendar(pdt);
		Date trialTime = new Date(dayTime);
		calendar.setTime(trialTime);
		return calendar.get(Calendar.DAY_OF_WEEK);
	}
	
	public static boolean isHoliday(long dayTime){
		boolean isHoliday = false;
		int dayOfWeek = getDayOfWeek(dayTime);
		log("day of week: "+dayOfWeek);
		if(dayOfWeek == 1 || dayOfWeek == 7)
			isHoliday = true;
		else
			isHoliday = false;
		return isHoliday;
	}
	
	public static long getDateLongFromString(String dayTime, String pattern){
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		Timestamp ts1 = null;
		try {
			ts1 = new java.sql.Timestamp(df.parse(dayTime).getTime());
			return ts1.getTime();
		} catch (ParseException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	/**
	 * pattern is string like: yyyy/MM/dd HH:mm:ss
	 * @param dayTime
	 * @param pattern
	 * @return
	 */
	public static Date getDateFromString(String dayTime, String pattern){
		try {
			return new Date(DateUtil.getDateLongFromString(dayTime, pattern));
		}
		catch (Exception ex_date) {
//			ex_date.printStackTrace();
			System.err.println("Date string \"" + dayTime + "\" not compatible with the pattern!");
			return null;
		}
	}
	
	public static java.sql.Date getSqlDateFromString(String dayTime, String pattern){
		return new java.sql.Date(DateUtil.getDateFromString(dayTime, pattern).getTime());
	}
	
	public static java.sql.Timestamp getSqlTimestampFromString(String dayTime, String pattern){
		return new java.sql.Timestamp(DateUtil.getDateFromString(dayTime, pattern).getTime());
	}
	
	public static void log(String msg){
//		System.out.println(msg);
		
	}
}
