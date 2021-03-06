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
 * SmTbTypeGrpBean is a mapping of sm_tb_type_grp Table.
*/
public class SmTbTypeGrpBean
// extends+ 

// extends- 
{

    private Long prdTypeId;
    private boolean prdTypeId_is_modified = false;
    private boolean prdTypeId_is_initialized = false;


    private String prdTypeName;
    private boolean prdTypeName_is_modified = false;
    private boolean prdTypeName_is_initialized = false;


    private String prdTypeDesc;
    private boolean prdTypeDesc_is_modified = false;
    private boolean prdTypeDesc_is_initialized = false;


    private Long prdTypeDiscount;
    private boolean prdTypeDiscount_is_modified = false;
    private boolean prdTypeDiscount_is_initialized = false;


    private Long owner;
    private boolean owner_is_modified = false;
    private boolean owner_is_initialized = false;

    private boolean _isNew = true;

    /**
     * Do not use this constructor directly, please use the factory method
     * available in the associated manager.
     */
    SmTbTypeGrpBean()
    {
    }

    /**
     * Getter method for prdTypeId.
     * <br>
     * PRIMARY KEY.<br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: sm_tb_type_grp.prd_type_id
     * <li>column size: 22
     * <li>jdbc type returned by the driver: Types.DECIMAL
     * </ul>
     *
     * @return the value of prdTypeId
     */
    public Long getPrdTypeId()
    {
        return prdTypeId;
    }

    /**
     * Setter method for prdTypeId.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value to be assigned to prdTypeId
     */
    public void setPrdTypeId(Long newVal) {
        if ((newVal != null && this.prdTypeId != null && (newVal.compareTo(this.prdTypeId) == 0)) ||
            (newVal == null && this.prdTypeId == null && prdTypeId_is_initialized)) {
            return;
        }
        this.prdTypeId = newVal;
        prdTypeId_is_modified = true;
        prdTypeId_is_initialized = true;
    }

    /**
     * Setter method for prdTypeId.
     * <br>
     * Convenient for those who do not want to deal with Objects for primary types.
     *
     * @param newVal the new value to be assigned to prdTypeId
     */
    public void setPrdTypeId(long newVal) {
        setPrdTypeId(new Long(newVal));
    }

    /**
     * Determines if the prdTypeId has been modified.
     *
     * @return true if the field has been modified, false if the field has not been modified
     */
    public boolean isPrdTypeIdModified() {
        return prdTypeId_is_modified;
    }

    /**
     * Determines if the prdTypeId has been initialized.
     * <br>
     * It is useful to determine if a field is null on purpose or just because it has not been initialized.
     *
     * @return true if the field has been initialized, false otherwise
     */
    public boolean isPrdTypeIdInitialized() {
        return prdTypeId_is_initialized;
    }

    /**
     * Getter method for prdTypeName.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: sm_tb_type_grp.prd_type_name
     * <li>column size: 50
     * <li>jdbc type returned by the driver: Types.VARCHAR
     * </ul>
     *
     * @return the value of prdTypeName
     */
    public String getPrdTypeName()
    {
        return prdTypeName;
    }

    /**
     * Setter method for prdTypeName.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value to be assigned to prdTypeName
     */
    public void setPrdTypeName(String newVal) {
        if ((newVal != null && this.prdTypeName != null && (newVal.compareTo(this.prdTypeName) == 0)) ||
            (newVal == null && this.prdTypeName == null && prdTypeName_is_initialized)) {
            return;
        }
        this.prdTypeName = newVal;
        prdTypeName_is_modified = true;
        prdTypeName_is_initialized = true;
    }

    /**
     * Determines if the prdTypeName has been modified.
     *
     * @return true if the field has been modified, false if the field has not been modified
     */
    public boolean isPrdTypeNameModified() {
        return prdTypeName_is_modified;
    }

    /**
     * Determines if the prdTypeName has been initialized.
     * <br>
     * It is useful to determine if a field is null on purpose or just because it has not been initialized.
     *
     * @return true if the field has been initialized, false otherwise
     */
    public boolean isPrdTypeNameInitialized() {
        return prdTypeName_is_initialized;
    }

    /**
     * Getter method for prdTypeDesc.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: sm_tb_type_grp.prd_type_desc
     * <li>column size: 150
     * <li>jdbc type returned by the driver: Types.VARCHAR
     * </ul>
     *
     * @return the value of prdTypeDesc
     */
    public String getPrdTypeDesc()
    {
        return prdTypeDesc;
    }

    /**
     * Setter method for prdTypeDesc.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value to be assigned to prdTypeDesc
     */
    public void setPrdTypeDesc(String newVal) {
        if ((newVal != null && this.prdTypeDesc != null && (newVal.compareTo(this.prdTypeDesc) == 0)) ||
            (newVal == null && this.prdTypeDesc == null && prdTypeDesc_is_initialized)) {
            return;
        }
        this.prdTypeDesc = newVal;
        prdTypeDesc_is_modified = true;
        prdTypeDesc_is_initialized = true;
    }

    /**
     * Determines if the prdTypeDesc has been modified.
     *
     * @return true if the field has been modified, false if the field has not been modified
     */
    public boolean isPrdTypeDescModified() {
        return prdTypeDesc_is_modified;
    }

    /**
     * Determines if the prdTypeDesc has been initialized.
     * <br>
     * It is useful to determine if a field is null on purpose or just because it has not been initialized.
     *
     * @return true if the field has been initialized, false otherwise
     */
    public boolean isPrdTypeDescInitialized() {
        return prdTypeDesc_is_initialized;
    }

    /**
     * Getter method for prdTypeDiscount.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: sm_tb_type_grp.prd_type_discount
     * <li>column size: 22
     * <li>jdbc type returned by the driver: Types.DECIMAL
     * </ul>
     *
     * @return the value of prdTypeDiscount
     */
    public Long getPrdTypeDiscount()
    {
        return prdTypeDiscount;
    }

    /**
     * Setter method for prdTypeDiscount.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value to be assigned to prdTypeDiscount
     */
    public void setPrdTypeDiscount(Long newVal) {
        if ((newVal != null && this.prdTypeDiscount != null && (newVal.compareTo(this.prdTypeDiscount) == 0)) ||
            (newVal == null && this.prdTypeDiscount == null && prdTypeDiscount_is_initialized)) {
            return;
        }
        this.prdTypeDiscount = newVal;
        prdTypeDiscount_is_modified = true;
        prdTypeDiscount_is_initialized = true;
    }

    /**
     * Setter method for prdTypeDiscount.
     * <br>
     * Convenient for those who do not want to deal with Objects for primary types.
     *
     * @param newVal the new value to be assigned to prdTypeDiscount
     */
    public void setPrdTypeDiscount(long newVal) {
        setPrdTypeDiscount(new Long(newVal));
    }

    /**
     * Determines if the prdTypeDiscount has been modified.
     *
     * @return true if the field has been modified, false if the field has not been modified
     */
    public boolean isPrdTypeDiscountModified() {
        return prdTypeDiscount_is_modified;
    }

    /**
     * Determines if the prdTypeDiscount has been initialized.
     * <br>
     * It is useful to determine if a field is null on purpose or just because it has not been initialized.
     *
     * @return true if the field has been initialized, false otherwise
     */
    public boolean isPrdTypeDiscountInitialized() {
        return prdTypeDiscount_is_initialized;
    }

    /**
     * Getter method for owner.
     * <br>
     * Meta Data Information (in progress):
     * <ul>
     * <li>full name: sm_tb_type_grp.owner
     * <li>comments: For group by manager
     * <li>column size: 22
     * <li>jdbc type returned by the driver: Types.DECIMAL
     * </ul>
     *
     * @return the value of owner
     */
    public Long getOwner()
    {
        return owner;
    }

    /**
     * Setter method for owner.
     * <br>
     * The new value is set only if compareTo() says it is different,
     * or if one of either the new value or the current value is null.
     * In case the new value is different, it is set and the field is marked as 'modified'.
     *
     * @param newVal the new value to be assigned to owner
     */
    public void setOwner(Long newVal) {
        if ((newVal != null && this.owner != null && (newVal.compareTo(this.owner) == 0)) ||
            (newVal == null && this.owner == null && owner_is_initialized)) {
            return;
        }
        this.owner = newVal;
        owner_is_modified = true;
        owner_is_initialized = true;
    }

    /**
     * Setter method for owner.
     * <br>
     * Convenient for those who do not want to deal with Objects for primary types.
     *
     * @param newVal the new value to be assigned to owner
     */
    public void setOwner(long newVal) {
        setOwner(new Long(newVal));
    }

    /**
     * Determines if the owner has been modified.
     *
     * @return true if the field has been modified, false if the field has not been modified
     */
    public boolean isOwnerModified() {
        return owner_is_modified;
    }

    /**
     * Determines if the owner has been initialized.
     * <br>
     * It is useful to determine if a field is null on purpose or just because it has not been initialized.
     *
     * @return true if the field has been initialized, false otherwise
     */
    public boolean isOwnerInitialized() {
        return owner_is_initialized;
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
        return prdTypeId_is_modified ||
		prdTypeName_is_modified ||
		prdTypeDesc_is_modified ||
		prdTypeDiscount_is_modified ||
		owner_is_modified;
    }

    /**
     * Resets the object modification status to 'not modified'.
     */
    public void resetIsModified() {
        prdTypeId_is_modified = false;
        prdTypeName_is_modified = false;
        prdTypeDesc_is_modified = false;
        prdTypeDiscount_is_modified = false;
        owner_is_modified = false;
    }

    /**
     * Copies the passed bean into the current bean.
     *
     * @param bean the bean to copy into the current bean
     */
    public void copy(SmTbTypeGrpBean bean) {
        setPrdTypeId(bean.getPrdTypeId());
        setPrdTypeName(bean.getPrdTypeName());
        setPrdTypeDesc(bean.getPrdTypeDesc());
        setPrdTypeDiscount(bean.getPrdTypeDiscount());
        setOwner(bean.getOwner());
    }

    /**
     * Returns the object string representation.
     *
     * @return the object as a string
     */
    public String toString() {
        return   "\n[sm_tb_type_grp] "
                 + "\n - sm_tb_type_grp.prd_type_id = " + (prdTypeId_is_initialized ? ("[" + (prdTypeId == null ? null : prdTypeId.toString()) + "]") : "not initialized") + ""
                 + "\n - sm_tb_type_grp.prd_type_name = " + (prdTypeName_is_initialized ? ("[" + (prdTypeName == null ? null : prdTypeName.toString()) + "]") : "not initialized") + ""
                 + "\n - sm_tb_type_grp.prd_type_desc = " + (prdTypeDesc_is_initialized ? ("[" + (prdTypeDesc == null ? null : prdTypeDesc.toString()) + "]") : "not initialized") + ""
                 + "\n - sm_tb_type_grp.prd_type_discount = " + (prdTypeDiscount_is_initialized ? ("[" + (prdTypeDiscount == null ? null : prdTypeDiscount.toString()) + "]") : "not initialized") + ""
                 + "\n - sm_tb_type_grp.owner = " + (owner_is_initialized ? ("[" + (owner == null ? null : owner.toString()) + "]") : "not initialized") + ""
            ;
    }

// class+ 

// class- 
}
