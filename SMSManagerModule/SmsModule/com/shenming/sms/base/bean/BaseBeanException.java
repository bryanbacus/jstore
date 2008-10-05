package com.shenming.sms.base.bean;

import com.shenming.sms.base.exception.BaseSystemException;

/**
 *
 * <p>Data Bean exception</p>
 * <p>所有extends BaseDataBean之DataBean都有可能throw此一Excception.
* 主要是因為DataBean轉換為map物件或map轉換為DataBean時產生的Exception.</p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: pandastudio</p>
 * @author Wayne Huang
 * @version 1.0
* @see BaseBean
 */
public class BaseBeanException extends BaseSystemException {
    public BaseBeanException() {
        super();
    }
    public BaseBeanException(String message) {
        super(message);

    }
    public BaseBeanException(Throwable cause) {
        super(cause);

    }
    public BaseBeanException(String message,Throwable cause) {
        super(message,cause);
        
    }
    

}
