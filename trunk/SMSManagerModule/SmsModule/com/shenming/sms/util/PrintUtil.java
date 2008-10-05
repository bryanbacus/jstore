package com.shenming.sms.util;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;

public class PrintUtil {
	
	public static void printArray(String[] str){
		System.out.println(PrintUtil.printArrayToString(str));
	}
	
	public static String printArrayToString(String[] str){
		String strOut = "";
		for(int i = 0;i< str.length; i++){
			strOut = strOut + str[i] + "\r\n";
		}
		
		return strOut;
	}
	
	public static void printObjectArray(Object[] obj){
		for(int i = 0;i< obj.length; i++){
			printObject(obj[i]);
			System.out.println("");
		}
	}

	public static void printObject(Object obj, String interval){
		try {
			HashMap hm = 
				(HashMap) BeanUtils.describe(obj);
			Set keySet = hm.keySet();
			Iterator iter = keySet.iterator();
			String columnName = "";
			while(iter.hasNext()){
				columnName = iter.next().toString();
				System.out.print("  ["+columnName+"]="+ BeanUtils.getProperty(obj, columnName)+" ");
				System.out.print(interval);
			}
			System.out.print("\r\n");
//			System.out.println(hm);
			
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void printObject(Object obj){
		printObject(obj, "\r\n");
	}
	
	public static void printObjectOneLine(Object obj){
		printObject(obj, "");
	}
	
	public static String printObjectToString(Object obj, String interval){
		try {
			HashMap hm = 
				(HashMap) BeanUtils.describe(obj);
			Set keySet = hm.keySet();
			Iterator iter = keySet.iterator();
			String columnName = "";
			StringBuffer stringBuffer = new StringBuffer();
			while(iter.hasNext()){
				columnName = iter.next().toString();
				stringBuffer.append("  ["+columnName+"]="+ BeanUtils.getProperty(obj, columnName)+" ");
				stringBuffer.append(interval);
			}
			stringBuffer.append("\r\n");
			return stringBuffer.toString();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String printObjectToString(Object obj){
		return printObjectToString(obj, "\r\n");
	}
	
	public static String formatMapOutput(HashMap hm){
		return hm.toString().replace("{", "").replace("}", "").replace(", ", "\r\n");
	}
}
