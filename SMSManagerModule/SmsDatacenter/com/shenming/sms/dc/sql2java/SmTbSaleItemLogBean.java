// --------------------------------------------------------
// Generated by sql2java - http://sql2java.sourceforge.net/
// jdbc driver used at code generation time: com.mysql.jdbc.Driver
//
// Please help us improve this tool by reporting:
//    problems,
//    suggestions,
//    feedbacks,
//    ideas,
//  to http://sourceforge.net/projects/sql2java/
// --------------------------------------------------------

package com.shenming.sms.dc.sql2java;

// imports+ 

// imports- 

/**
 * SmTbSaleItemLogBean is a mapping of sm_tb_sale_item_log Table.
*/
public class SmTbSaleItemLogBean
// extends+ 

// extends- 
{

    private Integer idx;
    private boolean idx_is_modified = false;
    private boolean idx_is_initialized = false;


    private Long itemSeq;
    private boolean itemSeq_is_modified = false;
    private boolean itemSeq_is_initialized = false;


    private String itemLog;
    private boolean itemLog_is_modified = false;
    private boolean itemLog_is_initialized = false;


    private Long createUser;
    private boolean createUser_is_modified = false;
    private boolean createUser_is_initialized = false;


    private java.util.Date createDate;
    private boolean createDate_is_modified = false;
    private boolean createDate_is_initialized = false;

    private boolean _isNew = true;

    /**
     * Do not use this constructor directly, please use the factory method
     * available in the associated manager.
     */
    SmTbSaleItemLogBean()
    {
    }

    /**
     * Getter method for idx.
     * <br>
     * PRIMARY KEY.<br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: sm_tb_sale_item_log.idx
     * <li>column size: 10
     * <li>jdbc type returned by the driver: Types.INTEGER
     * </ul>
     *
     * @return the value of idx
     */
    public Integer getIdx()
    {
        return idx;
    }

    /**
     * Setter method for idx.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value to be assigned to idx
     */
    public void setIdx(Integer newVal) {
        if ((newVal != null && this.idx != null && (newVal.compareTo(this.idx) == 0)) ||
            (newVal == null && this.idx == null && idx_is_initialized)) {
            return;
        }
        this.idx = newVal;
        idx_is_modified = true;
        idx_is_initialized = true;
    }

    /**
     * Setter method for idx.
     * <br>
     * Convenient for those who do not want to deal with Objects for primary types.
     *
     * @param newVal the new value to be assigned to idx
     */
    public void setIdx(int newVal) {
        setIdx(new Integer(newVal));
    }

    /**
     * Determines if the idx has been modified.
     *
     * @return true if the field has been modified, false if the field has not been modified
     */
    public boolean isIdxModified() {
        return idx_is_modified;
    }

    /**
     * Determines if the idx has been initialized.
     * <br>
     * It is useful to determine if a field is null on purpose or just because it has not been initialized.
     *
     * @return true if the field has been initialized, false otherwise
     */
    public boolean isIdxInitialized() {
        return idx_is_initialized;
    }

    /**
     * Getter method for itemSeq.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: sm_tb_sale_item_log.item_seq
     * <li>column size: 22
     * <li>jdbc type returned by the driver: Types.DECIMAL
     * </ul>
     *
     * @return the value of itemSeq
     */
    public Long getItemSeq()
    {
        return itemSeq;
    }

    /**
     * Setter method for itemSeq.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value to be assigned to itemSeq
     */
    public void setItemSeq(Long newVal) {
        if ((newVal != null && this.itemSeq != null && (newVal.compareTo(this.itemSeq) == 0)) ||
            (newVal == null && this.itemSeq == null && itemSeq_is_initialized)) {
            return;
        }
        this.itemSeq = newVal;
        itemSeq_is_modified = true;
        itemSeq_is_initialized = true;
    }

    /**
     * Setter method for itemSeq.
     * <br>
     * Convenient for those who do not want to deal with Objects for primary types.
     *
     * @param newVal the new value to be assigned to itemSeq
     */
    public void setItemSeq(long newVal) {
        setItemSeq(new Long(newVal));
    }

    /**
     * Determines if the itemSeq has been modified.
     *
     * @return true if the field has been modified, false if the field has not been modified
     */
    public boolean isItemSeqModified() {
        return itemSeq_is_modified;
    }

    /**
     * Determines if the itemSeq has been initialized.
     * <br>
     * It is useful to determine if a field is null on purpose or just because it has not been initialized.
     *
     * @return true if the field has been initialized, false otherwise
     */
    public boolean isItemSeqInitialized() {
        return itemSeq_is_initialized;
    }

    /**
     * Getter method for itemLog.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: sm_tb_sale_item_log.item_log
     * <li>column size: 200
     * <li>jdbc type returned by the driver: Types.VARCHAR
     * </ul>
     *
     * @return the value of itemLog
     */
    public String getItemLog()
    {
        return itemLog;
    }

    /**
     * Setter method for itemLog.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value to be assigned to itemLog
     */
    public void setItemLog(String newVal) {
        if ((newVal != null && this.itemLog != null && (newVal.compareTo(this.itemLog) == 0)) ||
            (newVal == null && this.itemLog == null && itemLog_is_initialized)) {
            return;
        }
        this.itemLog = newVal;
        itemLog_is_modified = true;
        itemLog_is_initialized = true;
    }

    /**
     * Determines if the itemLog has been modified.
     *
     * @return true if the field has been modified, false if the field has not been modified
     */
    public boolean isItemLogModified() {
        return itemLog_is_modified;
    }

    /**
     * Determines if the itemLog has been initialized.
     * <br>
     * It is useful to determine if a field is null on purpose or just because it has not been initialized.
     *
     * @return true if the field has been initialized, false otherwise
     */
    public boolean isItemLogInitialized() {
        return itemLog_is_initialized;
    }

    /**
     * Getter method for createUser.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: sm_tb_sale_item_log.create_user
     * <li>column size: 22
     * <li>jdbc type returned by the driver: Types.DECIMAL
     * </ul>
     *
     * @return the value of createUser
     */
    public Long getCreateUser()
    {
        return createUser;
    }

    /**
     * Setter method for createUser.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value to be assigned to createUser
     */
    public void setCreateUser(Long newVal) {
        if ((newVal != null && this.createUser != null && (newVal.compareTo(this.createUser) == 0)) ||
            (newVal == null && this.createUser == null && createUser_is_initialized)) {
            return;
        }
        this.createUser = newVal;
        createUser_is_modified = true;
        createUser_is_initialized = true;
    }

    /**
     * Setter method for createUser.
     * <br>
     * Convenient for those who do not want to deal with Objects for primary types.
     *
     * @param newVal the new value to be assigned to createUser
     */
    public void setCreateUser(long newVal) {
        setCreateUser(new Long(newVal));
    }

    /**
     * Determines if the createUser has been modified.
     *
     * @return true if the field has been modified, false if the field has not been modified
     */
    public boolean isCreateUserModified() {
        return createUser_is_modified;
    }

    /**
     * Determines if the createUser has been initialized.
     * <br>
     * It is useful to determine if a field is null on purpose or just because it has not been initialized.
     *
     * @return true if the field has been initialized, false otherwise
     */
    public boolean isCreateUserInitialized() {
        return createUser_is_initialized;
    }

    /**
     * Getter method for createDate.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: sm_tb_sale_item_log.create_date
     * <li>column size: 0
     * <li>jdbc type returned by the driver: Types.DATE
     * </ul>
     *
     * @return the value of createDate
     */
    public java.util.Date getCreateDate()
    {
        return createDate;
    }

    /**
     * Setter method for createDate.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value to be assigned to createDate
     */
    public void setCreateDate(java.util.Date newVal) {
        if ((newVal != null && this.createDate != null && (newVal.compareTo(this.createDate) == 0)) ||
            (newVal == null && this.createDate == null && createDate_is_initialized)) {
            return;
        }
        this.createDate = newVal;
        createDate_is_modified = true;
        createDate_is_initialized = true;
    }

    /**
     * Setter method for createDate.
     * <br>
     * Convenient for those who do not want to deal with Objects for primary types.
     *
     * @param newVal the new value to be assigned to createDate
     */
    public void setCreateDate(long newVal) {
        setCreateDate(new java.util.Date(newVal));
    }

    /**
     * Determines if the createDate has been modified.
     *
     * @return true if the field has been modified, false if the field has not been modified
     */
    public boolean isCreateDateModified() {
        return createDate_is_modified;
    }

    /**
     * Determines if the createDate has been initialized.
     * <br>
     * It is useful to determine if a field is null on purpose or just because it has not been initialized.
     *
     * @return true if the field has been initialized, false otherwise
     */
    public boolean isCreateDateInitialized() {
        return createDate_is_initialized;
    }

    /**
     * Determines if the current object is new.
     *
     * @return true if the current object is new, false if the object is not new
     */
    public boolean isNew() {
        return _isNew;
    }

    /**
     * Specifies to the object if it has been set as new.
     *
     * @param isNew the boolean value to be assigned to the isNew field
     */
    public void isNew(boolean isNew) {
        this._isNew = isNew;
    }

    /**
     * Determines if the object has been modified since the last time this method was called.
     * <br>
     * We can also determine if this object has ever been modified since its creation.
     *
     * @return true if the object has been modified, false if the object has not been modified
     */
    public boolean isModified() {
        return idx_is_modified ||
		itemSeq_is_modified ||
		itemLog_is_modified ||
		createUser_is_modified ||
		createDate_is_modified;
    }

    /**
     * Resets the object modification status to 'not modified'.
     */
    public void resetIsModified() {
        idx_is_modified = false;
        itemSeq_is_modified = false;
        itemLog_is_modified = false;
        createUser_is_modified = false;
        createDate_is_modified = false;
    }

    /**
     * Copies the passed bean into the current bean.
     *
     * @param bean the bean to copy into the current bean
     */
    public void copy(SmTbSaleItemLogBean bean) {
        setIdx(bean.getIdx());
        setItemSeq(bean.getItemSeq());
        setItemLog(bean.getItemLog());
        setCreateUser(bean.getCreateUser());
        setCreateDate(bean.getCreateDate());
    }

    /**
     * Returns the object string representation.
     *
     * @return the object as a string
     */
    public String toString() {
        return   "\n[sm_tb_sale_item_log] "
                 + "\n - sm_tb_sale_item_log.idx = " + (idx_is_initialized ? ("[" + (idx == null ? null : idx.toString()) + "]") : "not initialized") + ""
                 + "\n - sm_tb_sale_item_log.item_seq = " + (itemSeq_is_initialized ? ("[" + (itemSeq == null ? null : itemSeq.toString()) + "]") : "not initialized") + ""
                 + "\n - sm_tb_sale_item_log.item_log = " + (itemLog_is_initialized ? ("[" + (itemLog == null ? null : itemLog.toString()) + "]") : "not initialized") + ""
                 + "\n - sm_tb_sale_item_log.create_user = " + (createUser_is_initialized ? ("[" + (createUser == null ? null : createUser.toString()) + "]") : "not initialized") + ""
                 + "\n - sm_tb_sale_item_log.create_date = " + (createDate_is_initialized ? ("[" + (createDate == null ? null : createDate.toString()) + "]") : "not initialized") + ""
            ;
    }

// class+ 

// class- 
}
