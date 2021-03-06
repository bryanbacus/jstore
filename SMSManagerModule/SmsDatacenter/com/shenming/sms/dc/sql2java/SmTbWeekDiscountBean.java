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
 * SmTbWeekDiscountBean is a mapping of sm_tb_week_discount Table.
*/
public class SmTbWeekDiscountBean
// extends+ 

// extends- 
{

    private Long disSeq;
    private boolean disSeq_is_modified = false;
    private boolean disSeq_is_initialized = false;


    private Long prdId;
    private boolean prdId_is_modified = false;
    private boolean prdId_is_initialized = false;


    private Long disPrice;
    private boolean disPrice_is_modified = false;
    private boolean disPrice_is_initialized = false;


    private Long prdTotal;
    private boolean prdTotal_is_modified = false;
    private boolean prdTotal_is_initialized = false;


    private Long prdCurrentTotal;
    private boolean prdCurrentTotal_is_modified = false;
    private boolean prdCurrentTotal_is_initialized = false;


    private java.util.Date startDate;
    private boolean startDate_is_modified = false;
    private boolean startDate_is_initialized = false;


    private java.util.Date endDate;
    private boolean endDate_is_modified = false;
    private boolean endDate_is_initialized = false;

    private boolean _isNew = true;

    /**
     * Do not use this constructor directly, please use the factory method
     * available in the associated manager.
     */
    SmTbWeekDiscountBean()
    {
    }

    /**
     * Getter method for disSeq.
     * <br>
     * PRIMARY KEY.<br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: sm_tb_week_discount.dis_seq
     * <li>column size: 22
     * <li>jdbc type returned by the driver: Types.DECIMAL
     * </ul>
     *
     * @return the value of disSeq
     */
    public Long getDisSeq()
    {
        return disSeq;
    }

    /**
     * Setter method for disSeq.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value to be assigned to disSeq
     */
    public void setDisSeq(Long newVal) {
        if ((newVal != null && this.disSeq != null && (newVal.compareTo(this.disSeq) == 0)) ||
            (newVal == null && this.disSeq == null && disSeq_is_initialized)) {
            return;
        }
        this.disSeq = newVal;
        disSeq_is_modified = true;
        disSeq_is_initialized = true;
    }

    /**
     * Setter method for disSeq.
     * <br>
     * Convenient for those who do not want to deal with Objects for primary types.
     *
     * @param newVal the new value to be assigned to disSeq
     */
    public void setDisSeq(long newVal) {
        setDisSeq(new Long(newVal));
    }

    /**
     * Determines if the disSeq has been modified.
     *
     * @return true if the field has been modified, false if the field has not been modified
     */
    public boolean isDisSeqModified() {
        return disSeq_is_modified;
    }

    /**
     * Determines if the disSeq has been initialized.
     * <br>
     * It is useful to determine if a field is null on purpose or just because it has not been initialized.
     *
     * @return true if the field has been initialized, false otherwise
     */
    public boolean isDisSeqInitialized() {
        return disSeq_is_initialized;
    }

    /**
     * Getter method for prdId.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: sm_tb_week_discount.prd_id
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
     * Getter method for disPrice.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: sm_tb_week_discount.dis_price
     * <li>column size: 22
     * <li>jdbc type returned by the driver: Types.DECIMAL
     * </ul>
     *
     * @return the value of disPrice
     */
    public Long getDisPrice()
    {
        return disPrice;
    }

    /**
     * Setter method for disPrice.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value to be assigned to disPrice
     */
    public void setDisPrice(Long newVal) {
        if ((newVal != null && this.disPrice != null && (newVal.compareTo(this.disPrice) == 0)) ||
            (newVal == null && this.disPrice == null && disPrice_is_initialized)) {
            return;
        }
        this.disPrice = newVal;
        disPrice_is_modified = true;
        disPrice_is_initialized = true;
    }

    /**
     * Setter method for disPrice.
     * <br>
     * Convenient for those who do not want to deal with Objects for primary types.
     *
     * @param newVal the new value to be assigned to disPrice
     */
    public void setDisPrice(long newVal) {
        setDisPrice(new Long(newVal));
    }

    /**
     * Determines if the disPrice has been modified.
     *
     * @return true if the field has been modified, false if the field has not been modified
     */
    public boolean isDisPriceModified() {
        return disPrice_is_modified;
    }

    /**
     * Determines if the disPrice has been initialized.
     * <br>
     * It is useful to determine if a field is null on purpose or just because it has not been initialized.
     *
     * @return true if the field has been initialized, false otherwise
     */
    public boolean isDisPriceInitialized() {
        return disPrice_is_initialized;
    }

    /**
     * Getter method for prdTotal.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: sm_tb_week_discount.prd_total
     * <li>column size: 22
     * <li>jdbc type returned by the driver: Types.DECIMAL
     * </ul>
     *
     * @return the value of prdTotal
     */
    public Long getPrdTotal()
    {
        return prdTotal;
    }

    /**
     * Setter method for prdTotal.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value to be assigned to prdTotal
     */
    public void setPrdTotal(Long newVal) {
        if ((newVal != null && this.prdTotal != null && (newVal.compareTo(this.prdTotal) == 0)) ||
            (newVal == null && this.prdTotal == null && prdTotal_is_initialized)) {
            return;
        }
        this.prdTotal = newVal;
        prdTotal_is_modified = true;
        prdTotal_is_initialized = true;
    }

    /**
     * Setter method for prdTotal.
     * <br>
     * Convenient for those who do not want to deal with Objects for primary types.
     *
     * @param newVal the new value to be assigned to prdTotal
     */
    public void setPrdTotal(long newVal) {
        setPrdTotal(new Long(newVal));
    }

    /**
     * Determines if the prdTotal has been modified.
     *
     * @return true if the field has been modified, false if the field has not been modified
     */
    public boolean isPrdTotalModified() {
        return prdTotal_is_modified;
    }

    /**
     * Determines if the prdTotal has been initialized.
     * <br>
     * It is useful to determine if a field is null on purpose or just because it has not been initialized.
     *
     * @return true if the field has been initialized, false otherwise
     */
    public boolean isPrdTotalInitialized() {
        return prdTotal_is_initialized;
    }

    /**
     * Getter method for prdCurrentTotal.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: sm_tb_week_discount.prd_current_total
     * <li>column size: 22
     * <li>jdbc type returned by the driver: Types.DECIMAL
     * </ul>
     *
     * @return the value of prdCurrentTotal
     */
    public Long getPrdCurrentTotal()
    {
        return prdCurrentTotal;
    }

    /**
     * Setter method for prdCurrentTotal.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value to be assigned to prdCurrentTotal
     */
    public void setPrdCurrentTotal(Long newVal) {
        if ((newVal != null && this.prdCurrentTotal != null && (newVal.compareTo(this.prdCurrentTotal) == 0)) ||
            (newVal == null && this.prdCurrentTotal == null && prdCurrentTotal_is_initialized)) {
            return;
        }
        this.prdCurrentTotal = newVal;
        prdCurrentTotal_is_modified = true;
        prdCurrentTotal_is_initialized = true;
    }

    /**
     * Setter method for prdCurrentTotal.
     * <br>
     * Convenient for those who do not want to deal with Objects for primary types.
     *
     * @param newVal the new value to be assigned to prdCurrentTotal
     */
    public void setPrdCurrentTotal(long newVal) {
        setPrdCurrentTotal(new Long(newVal));
    }

    /**
     * Determines if the prdCurrentTotal has been modified.
     *
     * @return true if the field has been modified, false if the field has not been modified
     */
    public boolean isPrdCurrentTotalModified() {
        return prdCurrentTotal_is_modified;
    }

    /**
     * Determines if the prdCurrentTotal has been initialized.
     * <br>
     * It is useful to determine if a field is null on purpose or just because it has not been initialized.
     *
     * @return true if the field has been initialized, false otherwise
     */
    public boolean isPrdCurrentTotalInitialized() {
        return prdCurrentTotal_is_initialized;
    }

    /**
     * Getter method for startDate.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: sm_tb_week_discount.start_date
     * <li>column size: 0
     * <li>jdbc type returned by the driver: Types.TIMESTAMP
     * </ul>
     *
     * @return the value of startDate
     */
    public java.util.Date getStartDate()
    {
        return startDate;
    }

    /**
     * Setter method for startDate.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value to be assigned to startDate
     */
    public void setStartDate(java.util.Date newVal) {
        if ((newVal != null && this.startDate != null && (newVal.compareTo(this.startDate) == 0)) ||
            (newVal == null && this.startDate == null && startDate_is_initialized)) {
            return;
        }
        this.startDate = newVal;
        startDate_is_modified = true;
        startDate_is_initialized = true;
    }

    /**
     * Setter method for startDate.
     * <br>
     * Convenient for those who do not want to deal with Objects for primary types.
     *
     * @param newVal the new value to be assigned to startDate
     */
    public void setStartDate(long newVal) {
        setStartDate(new java.util.Date(newVal));
    }

    /**
     * Determines if the startDate has been modified.
     *
     * @return true if the field has been modified, false if the field has not been modified
     */
    public boolean isStartDateModified() {
        return startDate_is_modified;
    }

    /**
     * Determines if the startDate has been initialized.
     * <br>
     * It is useful to determine if a field is null on purpose or just because it has not been initialized.
     *
     * @return true if the field has been initialized, false otherwise
     */
    public boolean isStartDateInitialized() {
        return startDate_is_initialized;
    }

    /**
     * Getter method for endDate.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: sm_tb_week_discount.end_date
     * <li>column size: 0
     * <li>jdbc type returned by the driver: Types.TIMESTAMP
     * </ul>
     *
     * @return the value of endDate
     */
    public java.util.Date getEndDate()
    {
        return endDate;
    }

    /**
     * Setter method for endDate.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value to be assigned to endDate
     */
    public void setEndDate(java.util.Date newVal) {
        if ((newVal != null && this.endDate != null && (newVal.compareTo(this.endDate) == 0)) ||
            (newVal == null && this.endDate == null && endDate_is_initialized)) {
            return;
        }
        this.endDate = newVal;
        endDate_is_modified = true;
        endDate_is_initialized = true;
    }

    /**
     * Setter method for endDate.
     * <br>
     * Convenient for those who do not want to deal with Objects for primary types.
     *
     * @param newVal the new value to be assigned to endDate
     */
    public void setEndDate(long newVal) {
        setEndDate(new java.util.Date(newVal));
    }

    /**
     * Determines if the endDate has been modified.
     *
     * @return true if the field has been modified, false if the field has not been modified
     */
    public boolean isEndDateModified() {
        return endDate_is_modified;
    }

    /**
     * Determines if the endDate has been initialized.
     * <br>
     * It is useful to determine if a field is null on purpose or just because it has not been initialized.
     *
     * @return true if the field has been initialized, false otherwise
     */
    public boolean isEndDateInitialized() {
        return endDate_is_initialized;
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
        return disSeq_is_modified ||
		prdId_is_modified ||
		disPrice_is_modified ||
		prdTotal_is_modified ||
		prdCurrentTotal_is_modified ||
		startDate_is_modified ||
		endDate_is_modified;
    }

    /**
     * Resets the object modification status to 'not modified'.
     */
    public void resetIsModified() {
        disSeq_is_modified = false;
        prdId_is_modified = false;
        disPrice_is_modified = false;
        prdTotal_is_modified = false;
        prdCurrentTotal_is_modified = false;
        startDate_is_modified = false;
        endDate_is_modified = false;
    }

    /**
     * Copies the passed bean into the current bean.
     *
     * @param bean the bean to copy into the current bean
     */
    public void copy(SmTbWeekDiscountBean bean) {
        setDisSeq(bean.getDisSeq());
        setPrdId(bean.getPrdId());
        setDisPrice(bean.getDisPrice());
        setPrdTotal(bean.getPrdTotal());
        setPrdCurrentTotal(bean.getPrdCurrentTotal());
        setStartDate(bean.getStartDate());
        setEndDate(bean.getEndDate());
    }

    /**
     * Returns the object string representation.
     *
     * @return the object as a string
     */
    public String toString() {
        return   "\n[sm_tb_week_discount] "
                 + "\n - sm_tb_week_discount.dis_seq = " + (disSeq_is_initialized ? ("[" + (disSeq == null ? null : disSeq.toString()) + "]") : "not initialized") + ""
                 + "\n - sm_tb_week_discount.prd_id = " + (prdId_is_initialized ? ("[" + (prdId == null ? null : prdId.toString()) + "]") : "not initialized") + ""
                 + "\n - sm_tb_week_discount.dis_price = " + (disPrice_is_initialized ? ("[" + (disPrice == null ? null : disPrice.toString()) + "]") : "not initialized") + ""
                 + "\n - sm_tb_week_discount.prd_total = " + (prdTotal_is_initialized ? ("[" + (prdTotal == null ? null : prdTotal.toString()) + "]") : "not initialized") + ""
                 + "\n - sm_tb_week_discount.prd_current_total = " + (prdCurrentTotal_is_initialized ? ("[" + (prdCurrentTotal == null ? null : prdCurrentTotal.toString()) + "]") : "not initialized") + ""
                 + "\n - sm_tb_week_discount.start_date = " + (startDate_is_initialized ? ("[" + (startDate == null ? null : startDate.toString()) + "]") : "not initialized") + ""
                 + "\n - sm_tb_week_discount.end_date = " + (endDate_is_initialized ? ("[" + (endDate == null ? null : endDate.toString()) + "]") : "not initialized") + ""
            ;
    }

// class+ 

// class- 
}
