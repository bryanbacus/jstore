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
 * SmTbSaleItemBean is a mapping of sm_tb_sale_item Table.
*/
public class SmTbSaleItemBean
// extends+ 

// extends- 
{

    private Long itemSeq;
    private boolean itemSeq_is_modified = false;
    private boolean itemSeq_is_initialized = false;


    private Long prdId;
    private boolean prdId_is_modified = false;
    private boolean prdId_is_initialized = false;


    private Long count;
    private boolean count_is_modified = false;
    private boolean count_is_initialized = false;


    private Long prdUnitPrice;
    private boolean prdUnitPrice_is_modified = false;
    private boolean prdUnitPrice_is_initialized = false;


    private Long prdDiscountPrice;
    private boolean prdDiscountPrice_is_modified = false;
    private boolean prdDiscountPrice_is_initialized = false;


    private Long vipId;
    private boolean vipId_is_modified = false;
    private boolean vipId_is_initialized = false;


    private Long saleId;
    private boolean saleId_is_modified = false;
    private boolean saleId_is_initialized = false;


    private java.util.Date crDate;
    private boolean crDate_is_modified = false;
    private boolean crDate_is_initialized = false;


    private Long saleSeq;
    private boolean saleSeq_is_modified = false;
    private boolean saleSeq_is_initialized = false;


    private String isClose;
    private boolean isClose_is_modified = false;
    private boolean isClose_is_initialized = false;


    private java.util.Date updDate;
    private boolean updDate_is_modified = false;
    private boolean updDate_is_initialized = false;

    private boolean _isNew = true;

    /**
     * Do not use this constructor directly, please use the factory method
     * available in the associated manager.
     */
    SmTbSaleItemBean()
    {
    }

    /**
     * Getter method for itemSeq.
     * <br>
     * PRIMARY KEY.<br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: sm_tb_sale_item.item_seq
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
     * Getter method for prdId.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: sm_tb_sale_item.prd_id
     * <li>column size: 22
     * <li>jdbc type returned by the driver: Types.DECIMAL
     * </ul>
     *
     * @return the value of prdId
     */
    public Long getPrdId()
    {
        return prdId;
    }

    /**
     * Setter method for prdId.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value to be assigned to prdId
     */
    public void setPrdId(Long newVal) {
        if ((newVal != null && this.prdId != null && (newVal.compareTo(this.prdId) == 0)) ||
            (newVal == null && this.prdId == null && prdId_is_initialized)) {
            return;
        }
        this.prdId = newVal;
        prdId_is_modified = true;
        prdId_is_initialized = true;
    }

    /**
     * Setter method for prdId.
     * <br>
     * Convenient for those who do not want to deal with Objects for primary types.
     *
     * @param newVal the new value to be assigned to prdId
     */
    public void setPrdId(long newVal) {
        setPrdId(new Long(newVal));
    }

    /**
     * Determines if the prdId has been modified.
     *
     * @return true if the field has been modified, false if the field has not been modified
     */
    public boolean isPrdIdModified() {
        return prdId_is_modified;
    }

    /**
     * Determines if the prdId has been initialized.
     * <br>
     * It is useful to determine if a field is null on purpose or just because it has not been initialized.
     *
     * @return true if the field has been initialized, false otherwise
     */
    public boolean isPrdIdInitialized() {
        return prdId_is_initialized;
    }

    /**
     * Getter method for count.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: sm_tb_sale_item.count
     * <li>column size: 22
     * <li>jdbc type returned by the driver: Types.DECIMAL
     * </ul>
     *
     * @return the value of count
     */
    public Long getCount()
    {
        return count;
    }

    /**
     * Setter method for count.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value to be assigned to count
     */
    public void setCount(Long newVal) {
        if ((newVal != null && this.count != null && (newVal.compareTo(this.count) == 0)) ||
            (newVal == null && this.count == null && count_is_initialized)) {
            return;
        }
        this.count = newVal;
        count_is_modified = true;
        count_is_initialized = true;
    }

    /**
     * Setter method for count.
     * <br>
     * Convenient for those who do not want to deal with Objects for primary types.
     *
     * @param newVal the new value to be assigned to count
     */
    public void setCount(long newVal) {
        setCount(new Long(newVal));
    }

    /**
     * Determines if the count has been modified.
     *
     * @return true if the field has been modified, false if the field has not been modified
     */
    public boolean isCountModified() {
        return count_is_modified;
    }

    /**
     * Determines if the count has been initialized.
     * <br>
     * It is useful to determine if a field is null on purpose or just because it has not been initialized.
     *
     * @return true if the field has been initialized, false otherwise
     */
    public boolean isCountInitialized() {
        return count_is_initialized;
    }

    /**
     * Getter method for prdUnitPrice.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: sm_tb_sale_item.prd_unit_price
     * <li>column size: 22
     * <li>jdbc type returned by the driver: Types.DECIMAL
     * </ul>
     *
     * @return the value of prdUnitPrice
     */
    public Long getPrdUnitPrice()
    {
        return prdUnitPrice;
    }

    /**
     * Setter method for prdUnitPrice.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value to be assigned to prdUnitPrice
     */
    public void setPrdUnitPrice(Long newVal) {
        if ((newVal != null && this.prdUnitPrice != null && (newVal.compareTo(this.prdUnitPrice) == 0)) ||
            (newVal == null && this.prdUnitPrice == null && prdUnitPrice_is_initialized)) {
            return;
        }
        this.prdUnitPrice = newVal;
        prdUnitPrice_is_modified = true;
        prdUnitPrice_is_initialized = true;
    }

    /**
     * Setter method for prdUnitPrice.
     * <br>
     * Convenient for those who do not want to deal with Objects for primary types.
     *
     * @param newVal the new value to be assigned to prdUnitPrice
     */
    public void setPrdUnitPrice(long newVal) {
        setPrdUnitPrice(new Long(newVal));
    }

    /**
     * Determines if the prdUnitPrice has been modified.
     *
     * @return true if the field has been modified, false if the field has not been modified
     */
    public boolean isPrdUnitPriceModified() {
        return prdUnitPrice_is_modified;
    }

    /**
     * Determines if the prdUnitPrice has been initialized.
     * <br>
     * It is useful to determine if a field is null on purpose or just because it has not been initialized.
     *
     * @return true if the field has been initialized, false otherwise
     */
    public boolean isPrdUnitPriceInitialized() {
        return prdUnitPrice_is_initialized;
    }

    /**
     * Getter method for prdDiscountPrice.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: sm_tb_sale_item.prd_discount_price
     * <li>column size: 22
     * <li>jdbc type returned by the driver: Types.DECIMAL
     * </ul>
     *
     * @return the value of prdDiscountPrice
     */
    public Long getPrdDiscountPrice()
    {
        return prdDiscountPrice;
    }

    /**
     * Setter method for prdDiscountPrice.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value to be assigned to prdDiscountPrice
     */
    public void setPrdDiscountPrice(Long newVal) {
        if ((newVal != null && this.prdDiscountPrice != null && (newVal.compareTo(this.prdDiscountPrice) == 0)) ||
            (newVal == null && this.prdDiscountPrice == null && prdDiscountPrice_is_initialized)) {
            return;
        }
        this.prdDiscountPrice = newVal;
        prdDiscountPrice_is_modified = true;
        prdDiscountPrice_is_initialized = true;
    }

    /**
     * Setter method for prdDiscountPrice.
     * <br>
     * Convenient for those who do not want to deal with Objects for primary types.
     *
     * @param newVal the new value to be assigned to prdDiscountPrice
     */
    public void setPrdDiscountPrice(long newVal) {
        setPrdDiscountPrice(new Long(newVal));
    }

    /**
     * Determines if the prdDiscountPrice has been modified.
     *
     * @return true if the field has been modified, false if the field has not been modified
     */
    public boolean isPrdDiscountPriceModified() {
        return prdDiscountPrice_is_modified;
    }

    /**
     * Determines if the prdDiscountPrice has been initialized.
     * <br>
     * It is useful to determine if a field is null on purpose or just because it has not been initialized.
     *
     * @return true if the field has been initialized, false otherwise
     */
    public boolean isPrdDiscountPriceInitialized() {
        return prdDiscountPrice_is_initialized;
    }

    /**
     * Getter method for vipId.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: sm_tb_sale_item.vip_id
     * <li>column size: 22
     * <li>jdbc type returned by the driver: Types.DECIMAL
     * </ul>
     *
     * @return the value of vipId
     */
    public Long getVipId()
    {
        return vipId;
    }

    /**
     * Setter method for vipId.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value to be assigned to vipId
     */
    public void setVipId(Long newVal) {
        if ((newVal != null && this.vipId != null && (newVal.compareTo(this.vipId) == 0)) ||
            (newVal == null && this.vipId == null && vipId_is_initialized)) {
            return;
        }
        this.vipId = newVal;
        vipId_is_modified = true;
        vipId_is_initialized = true;
    }

    /**
     * Setter method for vipId.
     * <br>
     * Convenient for those who do not want to deal with Objects for primary types.
     *
     * @param newVal the new value to be assigned to vipId
     */
    public void setVipId(long newVal) {
        setVipId(new Long(newVal));
    }

    /**
     * Determines if the vipId has been modified.
     *
     * @return true if the field has been modified, false if the field has not been modified
     */
    public boolean isVipIdModified() {
        return vipId_is_modified;
    }

    /**
     * Determines if the vipId has been initialized.
     * <br>
     * It is useful to determine if a field is null on purpose or just because it has not been initialized.
     *
     * @return true if the field has been initialized, false otherwise
     */
    public boolean isVipIdInitialized() {
        return vipId_is_initialized;
    }

    /**
     * Getter method for saleId.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: sm_tb_sale_item.sale_id
     * <li>column size: 22
     * <li>jdbc type returned by the driver: Types.DECIMAL
     * </ul>
     *
     * @return the value of saleId
     */
    public Long getSaleId()
    {
        return saleId;
    }

    /**
     * Setter method for saleId.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value to be assigned to saleId
     */
    public void setSaleId(Long newVal) {
        if ((newVal != null && this.saleId != null && (newVal.compareTo(this.saleId) == 0)) ||
            (newVal == null && this.saleId == null && saleId_is_initialized)) {
            return;
        }
        this.saleId = newVal;
        saleId_is_modified = true;
        saleId_is_initialized = true;
    }

    /**
     * Setter method for saleId.
     * <br>
     * Convenient for those who do not want to deal with Objects for primary types.
     *
     * @param newVal the new value to be assigned to saleId
     */
    public void setSaleId(long newVal) {
        setSaleId(new Long(newVal));
    }

    /**
     * Determines if the saleId has been modified.
     *
     * @return true if the field has been modified, false if the field has not been modified
     */
    public boolean isSaleIdModified() {
        return saleId_is_modified;
    }

    /**
     * Determines if the saleId has been initialized.
     * <br>
     * It is useful to determine if a field is null on purpose or just because it has not been initialized.
     *
     * @return true if the field has been initialized, false otherwise
     */
    public boolean isSaleIdInitialized() {
        return saleId_is_initialized;
    }

    /**
     * Getter method for crDate.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: sm_tb_sale_item.cr_date
     * <li>column size: 0
     * <li>jdbc type returned by the driver: Types.TIMESTAMP
     * </ul>
     *
     * @return the value of crDate
     */
    public java.util.Date getCrDate()
    {
        return crDate;
    }

    /**
     * Setter method for crDate.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value to be assigned to crDate
     */
    public void setCrDate(java.util.Date newVal) {
        if ((newVal != null && this.crDate != null && (newVal.compareTo(this.crDate) == 0)) ||
            (newVal == null && this.crDate == null && crDate_is_initialized)) {
            return;
        }
        this.crDate = newVal;
        crDate_is_modified = true;
        crDate_is_initialized = true;
    }

    /**
     * Setter method for crDate.
     * <br>
     * Convenient for those who do not want to deal with Objects for primary types.
     *
     * @param newVal the new value to be assigned to crDate
     */
    public void setCrDate(long newVal) {
        setCrDate(new java.util.Date(newVal));
    }

    /**
     * Determines if the crDate has been modified.
     *
     * @return true if the field has been modified, false if the field has not been modified
     */
    public boolean isCrDateModified() {
        return crDate_is_modified;
    }

    /**
     * Determines if the crDate has been initialized.
     * <br>
     * It is useful to determine if a field is null on purpose or just because it has not been initialized.
     *
     * @return true if the field has been initialized, false otherwise
     */
    public boolean isCrDateInitialized() {
        return crDate_is_initialized;
    }

    /**
     * Getter method for saleSeq.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: sm_tb_sale_item.sale_seq
     * <li>column size: 22
     * <li>jdbc type returned by the driver: Types.DECIMAL
     * </ul>
     *
     * @return the value of saleSeq
     */
    public Long getSaleSeq()
    {
        return saleSeq;
    }

    /**
     * Setter method for saleSeq.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value to be assigned to saleSeq
     */
    public void setSaleSeq(Long newVal) {
        if ((newVal != null && this.saleSeq != null && (newVal.compareTo(this.saleSeq) == 0)) ||
            (newVal == null && this.saleSeq == null && saleSeq_is_initialized)) {
            return;
        }
        this.saleSeq = newVal;
        saleSeq_is_modified = true;
        saleSeq_is_initialized = true;
    }

    /**
     * Setter method for saleSeq.
     * <br>
     * Convenient for those who do not want to deal with Objects for primary types.
     *
     * @param newVal the new value to be assigned to saleSeq
     */
    public void setSaleSeq(long newVal) {
        setSaleSeq(new Long(newVal));
    }

    /**
     * Determines if the saleSeq has been modified.
     *
     * @return true if the field has been modified, false if the field has not been modified
     */
    public boolean isSaleSeqModified() {
        return saleSeq_is_modified;
    }

    /**
     * Determines if the saleSeq has been initialized.
     * <br>
     * It is useful to determine if a field is null on purpose or just because it has not been initialized.
     *
     * @return true if the field has been initialized, false otherwise
     */
    public boolean isSaleSeqInitialized() {
        return saleSeq_is_initialized;
    }

    /**
     * Getter method for isClose.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: sm_tb_sale_item.is_close
     * <li>column size: 2
     * <li>jdbc type returned by the driver: Types.CHAR
     * </ul>
     *
     * @return the value of isClose
     */
    public String getIsClose()
    {
        return isClose;
    }

    /**
     * Setter method for isClose.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value to be assigned to isClose
     */
    public void setIsClose(String newVal) {
        if ((newVal != null && this.isClose != null && (newVal.compareTo(this.isClose) == 0)) ||
            (newVal == null && this.isClose == null && isClose_is_initialized)) {
            return;
        }
        this.isClose = newVal;
        isClose_is_modified = true;
        isClose_is_initialized = true;
    }

    /**
     * Determines if the isClose has been modified.
     *
     * @return true if the field has been modified, false if the field has not been modified
     */
    public boolean isIsCloseModified() {
        return isClose_is_modified;
    }

    /**
     * Determines if the isClose has been initialized.
     * <br>
     * It is useful to determine if a field is null on purpose or just because it has not been initialized.
     *
     * @return true if the field has been initialized, false otherwise
     */
    public boolean isIsCloseInitialized() {
        return isClose_is_initialized;
    }

    /**
     * Getter method for updDate.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: sm_tb_sale_item.upd_date
     * <li>column size: 0
     * <li>jdbc type returned by the driver: Types.TIMESTAMP
     * </ul>
     *
     * @return the value of updDate
     */
    public java.util.Date getUpdDate()
    {
        return updDate;
    }

    /**
     * Setter method for updDate.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value to be assigned to updDate
     */
    public void setUpdDate(java.util.Date newVal) {
        if ((newVal != null && this.updDate != null && (newVal.compareTo(this.updDate) == 0)) ||
            (newVal == null && this.updDate == null && updDate_is_initialized)) {
            return;
        }
        this.updDate = newVal;
        updDate_is_modified = true;
        updDate_is_initialized = true;
    }

    /**
     * Setter method for updDate.
     * <br>
     * Convenient for those who do not want to deal with Objects for primary types.
     *
     * @param newVal the new value to be assigned to updDate
     */
    public void setUpdDate(long newVal) {
        setUpdDate(new java.util.Date(newVal));
    }

    /**
     * Determines if the updDate has been modified.
     *
     * @return true if the field has been modified, false if the field has not been modified
     */
    public boolean isUpdDateModified() {
        return updDate_is_modified;
    }

    /**
     * Determines if the updDate has been initialized.
     * <br>
     * It is useful to determine if a field is null on purpose or just because it has not been initialized.
     *
     * @return true if the field has been initialized, false otherwise
     */
    public boolean isUpdDateInitialized() {
        return updDate_is_initialized;
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
        return itemSeq_is_modified ||
		prdId_is_modified ||
		count_is_modified ||
		prdUnitPrice_is_modified ||
		prdDiscountPrice_is_modified ||
		vipId_is_modified ||
		saleId_is_modified ||
		crDate_is_modified ||
		saleSeq_is_modified ||
		isClose_is_modified ||
		updDate_is_modified;
    }

    /**
     * Resets the object modification status to 'not modified'.
     */
    public void resetIsModified() {
        itemSeq_is_modified = false;
        prdId_is_modified = false;
        count_is_modified = false;
        prdUnitPrice_is_modified = false;
        prdDiscountPrice_is_modified = false;
        vipId_is_modified = false;
        saleId_is_modified = false;
        crDate_is_modified = false;
        saleSeq_is_modified = false;
        isClose_is_modified = false;
        updDate_is_modified = false;
    }

    /**
     * Copies the passed bean into the current bean.
     *
     * @param bean the bean to copy into the current bean
     */
    public void copy(SmTbSaleItemBean bean) {
        setItemSeq(bean.getItemSeq());
        setPrdId(bean.getPrdId());
        setCount(bean.getCount());
        setPrdUnitPrice(bean.getPrdUnitPrice());
        setPrdDiscountPrice(bean.getPrdDiscountPrice());
        setVipId(bean.getVipId());
        setSaleId(bean.getSaleId());
        setCrDate(bean.getCrDate());
        setSaleSeq(bean.getSaleSeq());
        setIsClose(bean.getIsClose());
        setUpdDate(bean.getUpdDate());
    }

    /**
     * Returns the object string representation.
     *
     * @return the object as a string
     */
    public String toString() {
        return   "\n[sm_tb_sale_item] "
                 + "\n - sm_tb_sale_item.item_seq = " + (itemSeq_is_initialized ? ("[" + (itemSeq == null ? null : itemSeq.toString()) + "]") : "not initialized") + ""
                 + "\n - sm_tb_sale_item.prd_id = " + (prdId_is_initialized ? ("[" + (prdId == null ? null : prdId.toString()) + "]") : "not initialized") + ""
                 + "\n - sm_tb_sale_item.count = " + (count_is_initialized ? ("[" + (count == null ? null : count.toString()) + "]") : "not initialized") + ""
                 + "\n - sm_tb_sale_item.prd_unit_price = " + (prdUnitPrice_is_initialized ? ("[" + (prdUnitPrice == null ? null : prdUnitPrice.toString()) + "]") : "not initialized") + ""
                 + "\n - sm_tb_sale_item.prd_discount_price = " + (prdDiscountPrice_is_initialized ? ("[" + (prdDiscountPrice == null ? null : prdDiscountPrice.toString()) + "]") : "not initialized") + ""
                 + "\n - sm_tb_sale_item.vip_id = " + (vipId_is_initialized ? ("[" + (vipId == null ? null : vipId.toString()) + "]") : "not initialized") + ""
                 + "\n - sm_tb_sale_item.sale_id = " + (saleId_is_initialized ? ("[" + (saleId == null ? null : saleId.toString()) + "]") : "not initialized") + ""
                 + "\n - sm_tb_sale_item.cr_date = " + (crDate_is_initialized ? ("[" + (crDate == null ? null : crDate.toString()) + "]") : "not initialized") + ""
                 + "\n - sm_tb_sale_item.sale_seq = " + (saleSeq_is_initialized ? ("[" + (saleSeq == null ? null : saleSeq.toString()) + "]") : "not initialized") + ""
                 + "\n - sm_tb_sale_item.is_close = " + (isClose_is_initialized ? ("[" + (isClose == null ? null : isClose.toString()) + "]") : "not initialized") + ""
                 + "\n - sm_tb_sale_item.upd_date = " + (updDate_is_initialized ? ("[" + (updDate == null ? null : updDate.toString()) + "]") : "not initialized") + ""
            ;
    }

// class+ 

// class- 
}
