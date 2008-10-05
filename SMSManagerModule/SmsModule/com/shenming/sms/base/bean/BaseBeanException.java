package com.shenming.sms.base.bean;

import com.shenming.sms.base.exception.BaseSystemException;

/**
 *
 * <p>Data Bean exception</p>
 * <p>�Ҧ�extends BaseDataBean��DataBean�����i��throw���@Excception.
* �D�n�O�]��DataBean�ഫ��map�����map�ഫ��DataBean�ɲ��ͪ�Exception.</p>
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
