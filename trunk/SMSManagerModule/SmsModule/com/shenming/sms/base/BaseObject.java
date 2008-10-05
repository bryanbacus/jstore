package com.shenming.sms.base;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 *
 * <p>Title: 物件基礎類別</p>
 *
 * <p>Description: 利用Commons.lang.builder實作物件基本的幾個method</p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class BaseObject {
    public BaseObject() {
    }


    public boolean equals(Object obj) {
        return EqualsBuilder.reflectionEquals(this, obj);
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this,ToStringStyle.MULTI_LINE_STYLE);
    }

//    public int hashCode() {
//        return HashCodeBuilder.reflectionHashCode(this);
//    }

    public boolean hasValueOf(String key) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException{
		HashMap me = (HashMap) BeanUtils.describe(this);
		if(me != null && 
				key != null && !"".equalsIgnoreCase(key)){
			me.containsValue(key);
		}
		return false;
	}
    
    public boolean hasValueIgnoreCaseOf(String key) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException{
		HashMap me = (HashMap) BeanUtils.describe(this);
		if(me != null && 
				key != null && !"".equalsIgnoreCase(key)){
			Iterator iter = me.keySet().iterator();
			while(iter.hasNext()){
				String thekey = iter.next().toString();
				if(me.get(thekey) != null && me.get(thekey).toString().toLowerCase().equalsIgnoreCase(key.toLowerCase()))
					return true;
			}
		}
		return false;
	}
    
    public boolean hasPartValueOf(String key) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException{
		HashMap me = (HashMap) BeanUtils.describe(this);
		if(me != null && 
				key != null && !"".equalsIgnoreCase(key)){
			Iterator iter = me.keySet().iterator();
			while(iter.hasNext()){
				String thekey = iter.next().toString();
				if(me.get(thekey) != null && me.get(thekey).toString().indexOf(key) >= 0)
					return true;
			}
		}
		return false;
	}
    
    public boolean hasPartValueIgnoreCaseOf(String key) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException{
		HashMap me = (HashMap) BeanUtils.describe(this);
		if(me != null && 
				key != null && !"".equalsIgnoreCase(key)){
			Iterator iter = me.keySet().iterator();
			while(iter.hasNext()){
				String thekey = iter.next().toString();
				if(me.get(thekey) != null && me.get(thekey).toString().toLowerCase().indexOf(key.toLowerCase()) >= 0)
					return true;
			}
		}
		return false;
	}
    
    

//    public static void main(String[] args) {
//        BaseObject baseobject = new BaseObject();
//    }
}
