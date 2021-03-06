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

import java.util.Comparator;
// imports+ 

// imports- 

/**
 * Comparator class is used to sort the SmTbSaleItemBean objects.
 */
public class SmTbSaleItemComparator implements Comparator
// extends+ 

// extends- 
{
    /**
     * Holds the field on which the comparison is performed.
     */
    private int iType;
    /**
     * Value that will contain the information about the order of the sort: normal or reversal.
     */
    private boolean bReverse;

    /**
     * Constructor class for SmTbSaleItemComparator.
     * <br>
     * Example:
     * <br>
     * <code>Arrays.sort(pArray, new SmTbSaleItemComparator(SmTbSaleItemManager.ITEM_SEQ, bReverse));<code>
     *
     * @param iType the field from which you want to sort
     * <br>
     * Possible values are:
     * <ul>
     *   <li>SmTbSaleItemManager.ID_ITEM_SEQ
     *   <li>SmTbSaleItemManager.ID_PRD_ID
     *   <li>SmTbSaleItemManager.ID_COUNT
     *   <li>SmTbSaleItemManager.ID_PRD_UNIT_PRICE
     *   <li>SmTbSaleItemManager.ID_PRD_DISCOUNT_PRICE
     *   <li>SmTbSaleItemManager.ID_VIP_ID
     *   <li>SmTbSaleItemManager.ID_SALE_ID
     *   <li>SmTbSaleItemManager.ID_CR_DATE
     *   <li>SmTbSaleItemManager.ID_SALE_SEQ
     *   <li>SmTbSaleItemManager.ID_IS_CLOSE
     *   <li>SmTbSaleItemManager.ID_UPD_DATE
     * </ul>
     */
    public SmTbSaleItemComparator(int iType)
    {
        this(iType, false);
    }

    /**
     * Constructor class for SmTbSaleItemComparator.
     * <br>
     * Example:
     * <br>
     * <code>Arrays.sort(pArray, new SmTbSaleItemComparator(SmTbSaleItemManager.ITEM_SEQ, bReverse));<code>
     *
     * @param iType the field from which you want to sort.
     * <br>
     * Possible values are:
     * <ul>
     *   <li>SmTbSaleItemManager.ID_ITEM_SEQ
     *   <li>SmTbSaleItemManager.ID_PRD_ID
     *   <li>SmTbSaleItemManager.ID_COUNT
     *   <li>SmTbSaleItemManager.ID_PRD_UNIT_PRICE
     *   <li>SmTbSaleItemManager.ID_PRD_DISCOUNT_PRICE
     *   <li>SmTbSaleItemManager.ID_VIP_ID
     *   <li>SmTbSaleItemManager.ID_SALE_ID
     *   <li>SmTbSaleItemManager.ID_CR_DATE
     *   <li>SmTbSaleItemManager.ID_SALE_SEQ
     *   <li>SmTbSaleItemManager.ID_IS_CLOSE
     *   <li>SmTbSaleItemManager.ID_UPD_DATE
     * </ul>
     *
     * @param bReverse set this value to true, if you want to reverse the sorting results
     */
    public SmTbSaleItemComparator(int iType, boolean bReverse)
    {
        this.iType = iType;
        this.bReverse = bReverse;
    }

    /**
     * Implementation of the compare method.
     */
    public int compare(Object pObj1, Object pObj2)
    {
        SmTbSaleItemBean b1 = (SmTbSaleItemBean)pObj1;
        SmTbSaleItemBean b2 = (SmTbSaleItemBean)pObj2;
        int iReturn = 0;
        switch(iType)
        {
            case SmTbSaleItemManager.ID_ITEM_SEQ:
                if (b1.getItemSeq() == null && b2.getItemSeq() != null) {
                    iReturn = -1;
                } else if (b1.getItemSeq() == null && b2.getItemSeq() == null) {
                    iReturn = 0;
                } else if (b1.getItemSeq() != null && b2.getItemSeq() == null) {
                    iReturn = 1;
                } else {
                    iReturn = b1.getItemSeq().compareTo(b2.getItemSeq());
                }
                break;
            case SmTbSaleItemManager.ID_PRD_ID:
                if (b1.getPrdId() == null && b2.getPrdId() != null) {
                    iReturn = -1;
                } else if (b1.getPrdId() == null && b2.getPrdId() == null) {
                    iReturn = 0;
                } else if (b1.getPrdId() != null && b2.getPrdId() == null) {
                    iReturn = 1;
                } else {
                    iReturn = b1.getPrdId().compareTo(b2.getPrdId());
                }
                break;
            case SmTbSaleItemManager.ID_COUNT:
                if (b1.getCount() == null && b2.getCount() != null) {
                    iReturn = -1;
                } else if (b1.getCount() == null && b2.getCount() == null) {
                    iReturn = 0;
                } else if (b1.getCount() != null && b2.getCount() == null) {
                    iReturn = 1;
                } else {
                    iReturn = b1.getCount().compareTo(b2.getCount());
                }
                break;
            case SmTbSaleItemManager.ID_PRD_UNIT_PRICE:
                if (b1.getPrdUnitPrice() == null && b2.getPrdUnitPrice() != null) {
                    iReturn = -1;
                } else if (b1.getPrdUnitPrice() == null && b2.getPrdUnitPrice() == null) {
                    iReturn = 0;
                } else if (b1.getPrdUnitPrice() != null && b2.getPrdUnitPrice() == null) {
                    iReturn = 1;
                } else {
                    iReturn = b1.getPrdUnitPrice().compareTo(b2.getPrdUnitPrice());
                }
                break;
            case SmTbSaleItemManager.ID_PRD_DISCOUNT_PRICE:
                if (b1.getPrdDiscountPrice() == null && b2.getPrdDiscountPrice() != null) {
                    iReturn = -1;
                } else if (b1.getPrdDiscountPrice() == null && b2.getPrdDiscountPrice() == null) {
                    iReturn = 0;
                } else if (b1.getPrdDiscountPrice() != null && b2.getPrdDiscountPrice() == null) {
                    iReturn = 1;
                } else {
                    iReturn = b1.getPrdDiscountPrice().compareTo(b2.getPrdDiscountPrice());
                }
                break;
            case SmTbSaleItemManager.ID_VIP_ID:
                if (b1.getVipId() == null && b2.getVipId() != null) {
                    iReturn = -1;
                } else if (b1.getVipId() == null && b2.getVipId() == null) {
                    iReturn = 0;
                } else if (b1.getVipId() != null && b2.getVipId() == null) {
                    iReturn = 1;
                } else {
                    iReturn = b1.getVipId().compareTo(b2.getVipId());
                }
                break;
            case SmTbSaleItemManager.ID_SALE_ID:
                if (b1.getSaleId() == null && b2.getSaleId() != null) {
                    iReturn = -1;
                } else if (b1.getSaleId() == null && b2.getSaleId() == null) {
                    iReturn = 0;
                } else if (b1.getSaleId() != null && b2.getSaleId() == null) {
                    iReturn = 1;
                } else {
                    iReturn = b1.getSaleId().compareTo(b2.getSaleId());
                }
                break;
            case SmTbSaleItemManager.ID_CR_DATE:
                if (b1.getCrDate() == null && b2.getCrDate() != null) {
                    iReturn = -1;
                } else if (b1.getCrDate() == null && b2.getCrDate() == null) {
                    iReturn = 0;
                } else if (b1.getCrDate() != null && b2.getCrDate() == null) {
                    iReturn = 1;
                } else {
                    iReturn = b1.getCrDate().compareTo(b2.getCrDate());
                }
                break;
            case SmTbSaleItemManager.ID_SALE_SEQ:
                if (b1.getSaleSeq() == null && b2.getSaleSeq() != null) {
                    iReturn = -1;
                } else if (b1.getSaleSeq() == null && b2.getSaleSeq() == null) {
                    iReturn = 0;
                } else if (b1.getSaleSeq() != null && b2.getSaleSeq() == null) {
                    iReturn = 1;
                } else {
                    iReturn = b1.getSaleSeq().compareTo(b2.getSaleSeq());
                }
                break;
            case SmTbSaleItemManager.ID_IS_CLOSE:
                if (b1.getIsClose() == null && b2.getIsClose() != null) {
                    iReturn = -1;
                } else if (b1.getIsClose() == null && b2.getIsClose() == null) {
                    iReturn = 0;
                } else if (b1.getIsClose() != null && b2.getIsClose() == null) {
                    iReturn = 1;
                } else {
                    iReturn = b1.getIsClose().compareTo(b2.getIsClose());
                }
                break;
            case SmTbSaleItemManager.ID_UPD_DATE:
                if (b1.getUpdDate() == null && b2.getUpdDate() != null) {
                    iReturn = -1;
                } else if (b1.getUpdDate() == null && b2.getUpdDate() == null) {
                    iReturn = 0;
                } else if (b1.getUpdDate() != null && b2.getUpdDate() == null) {
                    iReturn = 1;
                } else {
                    iReturn = b1.getUpdDate().compareTo(b2.getUpdDate());
                }
                break;
            default:
                throw new IllegalArgumentException("Type passed for the field is not supported");
        }

        return bReverse ? (-1 * iReturn) : iReturn;
    }
// class+ 

// class- 
}
