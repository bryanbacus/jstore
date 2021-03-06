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
 * Comparator class is used to sort the SmTbLeaveAttchementBean objects.
 */
public class SmTbLeaveAttchementComparator implements Comparator
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
     * Constructor class for SmTbLeaveAttchementComparator.
     * <br>
     * Example:
     * <br>
     * <code>Arrays.sort(pArray, new SmTbLeaveAttchementComparator(SmTbLeaveAttchementManager.APPLY_ID, bReverse));<code>
     *
     * @param iType the field from which you want to sort
     * <br>
     * Possible values are:
     * <ul>
     *   <li>SmTbLeaveAttchementManager.ID_APPLY_ID
     *   <li>SmTbLeaveAttchementManager.ID_FILE_PATH
     *   <li>SmTbLeaveAttchementManager.ID_FILE_NAME
     *   <li>SmTbLeaveAttchementManager.ID_DESCRIPTION
     *   <li>SmTbLeaveAttchementManager.ID_CREATE_DATE
     * </ul>
     */
    public SmTbLeaveAttchementComparator(int iType)
    {
        this(iType, false);
    }

    /**
     * Constructor class for SmTbLeaveAttchementComparator.
     * <br>
     * Example:
     * <br>
     * <code>Arrays.sort(pArray, new SmTbLeaveAttchementComparator(SmTbLeaveAttchementManager.APPLY_ID, bReverse));<code>
     *
     * @param iType the field from which you want to sort.
     * <br>
     * Possible values are:
     * <ul>
     *   <li>SmTbLeaveAttchementManager.ID_APPLY_ID
     *   <li>SmTbLeaveAttchementManager.ID_FILE_PATH
     *   <li>SmTbLeaveAttchementManager.ID_FILE_NAME
     *   <li>SmTbLeaveAttchementManager.ID_DESCRIPTION
     *   <li>SmTbLeaveAttchementManager.ID_CREATE_DATE
     * </ul>
     *
     * @param bReverse set this value to true, if you want to reverse the sorting results
     */
    public SmTbLeaveAttchementComparator(int iType, boolean bReverse)
    {
        this.iType = iType;
        this.bReverse = bReverse;
    }

    /**
     * Implementation of the compare method.
     */
    public int compare(Object pObj1, Object pObj2)
    {
        SmTbLeaveAttchementBean b1 = (SmTbLeaveAttchementBean)pObj1;
        SmTbLeaveAttchementBean b2 = (SmTbLeaveAttchementBean)pObj2;
        int iReturn = 0;
        switch(iType)
        {
            case SmTbLeaveAttchementManager.ID_APPLY_ID:
                if (b1.getApplyId() == null && b2.getApplyId() != null) {
                    iReturn = -1;
                } else if (b1.getApplyId() == null && b2.getApplyId() == null) {
                    iReturn = 0;
                } else if (b1.getApplyId() != null && b2.getApplyId() == null) {
                    iReturn = 1;
                } else {
                    iReturn = b1.getApplyId().compareTo(b2.getApplyId());
                }
                break;
            case SmTbLeaveAttchementManager.ID_FILE_PATH:
                if (b1.getFilePath() == null && b2.getFilePath() != null) {
                    iReturn = -1;
                } else if (b1.getFilePath() == null && b2.getFilePath() == null) {
                    iReturn = 0;
                } else if (b1.getFilePath() != null && b2.getFilePath() == null) {
                    iReturn = 1;
                } else {
                    iReturn = b1.getFilePath().compareTo(b2.getFilePath());
                }
                break;
            case SmTbLeaveAttchementManager.ID_FILE_NAME:
                if (b1.getFileName() == null && b2.getFileName() != null) {
                    iReturn = -1;
                } else if (b1.getFileName() == null && b2.getFileName() == null) {
                    iReturn = 0;
                } else if (b1.getFileName() != null && b2.getFileName() == null) {
                    iReturn = 1;
                } else {
                    iReturn = b1.getFileName().compareTo(b2.getFileName());
                }
                break;
            case SmTbLeaveAttchementManager.ID_DESCRIPTION:
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
            case SmTbLeaveAttchementManager.ID_CREATE_DATE:
                if (b1.getCreateDate() == null && b2.getCreateDate() != null) {
                    iReturn = -1;
                } else if (b1.getCreateDate() == null && b2.getCreateDate() == null) {
                    iReturn = 0;
                } else if (b1.getCreateDate() != null && b2.getCreateDate() == null) {
                    iReturn = 1;
                } else {
                    iReturn = b1.getCreateDate().compareTo(b2.getCreateDate());
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
