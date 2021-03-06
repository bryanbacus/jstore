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
 * Comparator class is used to sort the SmTbFlowerIntorBean objects.
 */
public class SmTbFlowerIntorComparator implements Comparator
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
     * Constructor class for SmTbFlowerIntorComparator.
     * <br>
     * Example:
     * <br>
     * <code>Arrays.sort(pArray, new SmTbFlowerIntorComparator(SmTbFlowerIntorManager.ITEM_SEQ, bReverse));<code>
     *
     * @param iType the field from which you want to sort
     * <br>
     * Possible values are:
     * <ul>
     *   <li>SmTbFlowerIntorManager.ID_ITEM_SEQ
     *   <li>SmTbFlowerIntorManager.ID_TITLE
     *   <li>SmTbFlowerIntorManager.ID_ITEM_CHARACTER
     *   <li>SmTbFlowerIntorManager.ID_USAGES
     *   <li>SmTbFlowerIntorManager.ID_DESCRIPTION
     *   <li>SmTbFlowerIntorManager.ID_ITEM_PICS
     *   <li>SmTbFlowerIntorManager.ID_IS_SHOW
     * </ul>
     */
    public SmTbFlowerIntorComparator(int iType)
    {
        this(iType, false);
    }

    /**
     * Constructor class for SmTbFlowerIntorComparator.
     * <br>
     * Example:
     * <br>
     * <code>Arrays.sort(pArray, new SmTbFlowerIntorComparator(SmTbFlowerIntorManager.ITEM_SEQ, bReverse));<code>
     *
     * @param iType the field from which you want to sort.
     * <br>
     * Possible values are:
     * <ul>
     *   <li>SmTbFlowerIntorManager.ID_ITEM_SEQ
     *   <li>SmTbFlowerIntorManager.ID_TITLE
     *   <li>SmTbFlowerIntorManager.ID_ITEM_CHARACTER
     *   <li>SmTbFlowerIntorManager.ID_USAGES
     *   <li>SmTbFlowerIntorManager.ID_DESCRIPTION
     *   <li>SmTbFlowerIntorManager.ID_ITEM_PICS
     *   <li>SmTbFlowerIntorManager.ID_IS_SHOW
     * </ul>
     *
     * @param bReverse set this value to true, if you want to reverse the sorting results
     */
    public SmTbFlowerIntorComparator(int iType, boolean bReverse)
    {
        this.iType = iType;
        this.bReverse = bReverse;
    }

    /**
     * Implementation of the compare method.
     */
    public int compare(Object pObj1, Object pObj2)
    {
        SmTbFlowerIntorBean b1 = (SmTbFlowerIntorBean)pObj1;
        SmTbFlowerIntorBean b2 = (SmTbFlowerIntorBean)pObj2;
        int iReturn = 0;
        switch(iType)
        {
            case SmTbFlowerIntorManager.ID_ITEM_SEQ:
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
            case SmTbFlowerIntorManager.ID_TITLE:
                if (b1.getTitle() == null && b2.getTitle() != null) {
                    iReturn = -1;
                } else if (b1.getTitle() == null && b2.getTitle() == null) {
                    iReturn = 0;
                } else if (b1.getTitle() != null && b2.getTitle() == null) {
                    iReturn = 1;
                } else {
                    iReturn = b1.getTitle().compareTo(b2.getTitle());
                }
                break;
            case SmTbFlowerIntorManager.ID_ITEM_CHARACTER:
                if (b1.getItemCharacter() == null && b2.getItemCharacter() != null) {
                    iReturn = -1;
                } else if (b1.getItemCharacter() == null && b2.getItemCharacter() == null) {
                    iReturn = 0;
                } else if (b1.getItemCharacter() != null && b2.getItemCharacter() == null) {
                    iReturn = 1;
                } else {
                    iReturn = b1.getItemCharacter().compareTo(b2.getItemCharacter());
                }
                break;
            case SmTbFlowerIntorManager.ID_USAGES:
                if (b1.getUsages() == null && b2.getUsages() != null) {
                    iReturn = -1;
                } else if (b1.getUsages() == null && b2.getUsages() == null) {
                    iReturn = 0;
                } else if (b1.getUsages() != null && b2.getUsages() == null) {
                    iReturn = 1;
                } else {
                    iReturn = b1.getUsages().compareTo(b2.getUsages());
                }
                break;
            case SmTbFlowerIntorManager.ID_DESCRIPTION:
                if (b1.getDescription() == null && b2.getDescription() != null) {
                    iReturn = -1;
                } else if (b1.getDescription() == null && b2.getDescription() == null) {
                    iReturn = 0;
                } else if (b1.getDescription() != null && b2.getDescription() == null) {
                    iReturn = 1;
                } else {
                    iReturn = b1.getDescription().compareTo(b2.getDescription());
                }
                break;
            case SmTbFlowerIntorManager.ID_ITEM_PICS:
                if (b1.getItemPics() == null && b2.getItemPics() != null) {
                    iReturn = -1;
                } else if (b1.getItemPics() == null && b2.getItemPics() == null) {
                    iReturn = 0;
                } else if (b1.getItemPics() != null && b2.getItemPics() == null) {
                    iReturn = 1;
                } else {
                    iReturn = b1.getItemPics().compareTo(b2.getItemPics());
                }
                break;
            case SmTbFlowerIntorManager.ID_IS_SHOW:
                if (b1.getIsShow() == null && b2.getIsShow() != null) {
                    iReturn = -1;
                } else if (b1.getIsShow() == null && b2.getIsShow() == null) {
                    iReturn = 0;
                } else if (b1.getIsShow() != null && b2.getIsShow() == null) {
                    iReturn = 1;
                } else {
                    iReturn = b1.getIsShow().compareTo(b2.getIsShow());
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
