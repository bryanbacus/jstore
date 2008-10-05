package com.shenming.sms.base.bean;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.BeanMap;

/**
 *
 * <p>base data bean abstract class</p>
 * <p>Provider some method
 * to conver dataBean to other format date set like Map or Set</p>
 * 
 * @version 1.0
* @see BaseBeanException
 */
public abstract class BaseBean extends com.shenming.sms.base.BaseObject implements java.io.Serializable {

    public BaseBean() {
    }

    /**
     * Convert data bean to data map(key/value set).
     * @throws BaseBeanException if DataBean transfer error
     * @return Map
     * @see BaseBeanException
     */
    public Map toMap() throws BaseBeanException {
        try {
            return BeanUtils.describe(this);
        }
        catch (NoSuchMethodException ex) {
            throw new BaseBeanException(ex);
        }
        catch (InvocationTargetException ex) {
            throw new BaseBeanException(ex);
        }
        catch (IllegalAccessException ex) {
            throw new BaseBeanException(ex);
        }
    }

    /**
     * Fill data bean with object than argument Map object of dataMap.
     * @param dataMap Map
     * @throws BaseBeanException if DataBean transfer error
     * @see BaseBeanException
     */
    public void fillWith(Map dataMap) throws BaseBeanException {
        try {
            BeanUtils.populate(this, dataMap);
        }
        catch (InvocationTargetException ex) {
            throw new BaseBeanException(ex);
        }
        catch (IllegalAccessException ex) {
            throw new BaseBeanException(ex);
        }
    }
    
    public void fillWith(Object obj) throws BaseBeanException {
    	Map dataMap;
		try {
			dataMap = BeanUtils.describe(obj);
			
			try {
	            BeanUtils.populate(this, dataMap);
	        }
	        catch (InvocationTargetException ex) {
	            throw new BaseBeanException(ex);
	        }
	        catch (IllegalAccessException ex) {
	            throw new BaseBeanException(ex);
	        }
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

    /**
     * return a org.apache.commons.collections.BeanMap .
     * @return BeanMap
     */
    public BeanMap toBeanMap(){
        BeanMap bm= new BeanMap(this);

        return bm;
    }

    public String toString(){
    	try {
			return this.toMap().toString();
		} catch (BaseBeanException e) {
			e.printStackTrace();
			return "Cannot convert to String object!";
		}
    }

}
