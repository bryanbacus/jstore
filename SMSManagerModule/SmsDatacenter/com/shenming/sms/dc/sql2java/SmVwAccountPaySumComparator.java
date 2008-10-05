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
 * Comparator class is used to sort the SmVwAccountPaySumBean objects.
 */
public class SmVwAccountPaySumComparator implements Comparator
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
     * Constructor class for SmVwAccountPaySumComparator.
     * <br>
     * Example:
     * <br>
     * <code>Arrays.sort(pArray, new SmVwAccountPaySumComparator(SmVwAccountPaySumManager.PAY_SUM, bReverse));<code>
     *
     * @param iType the field from which you want to sort
     * <br>
     * Possible values are:
     * <ul>
     *   <li>SmVwAccountPaySumManager.ID_PAY_SUM
     *   <li>SmVwAccountPaySumManager.ID_USER_ID
     * </ul>
     */
    public SmVwAccountPaySumComparator(int iType)
    {
        this(iType, false);
    }

    /**
     * Constructor class for SmVwAccountPaySumComparator.
     * <br>
     * Example:
     * <br>
     * <code>Arrays.sort(pArray, new SmVwAccountPaySumComparator(SmVwAccountPaySumManager.PAY_SUM, bReverse));<code>
     *
     * @param iType the field from which you want to sort.
     * <br>
     * Possible values are:
     * <ul>
     *   <li>SmVwAccountPaySumManager.ID_PAY_SUM
     *   <li>SmVwAccountPaySumManager.ID_USER_ID
     * </ul>
     *
     * @param bReverse set this value to true, if you want to reverse the sorting results
     */
    public SmVwAccountPaySumComparator(int iType, boolean bReverse)
    {
        this.iType = iType;
        this.bReverse = bReverse;
    }

    /**
     * Implementation of the compare method.
     */
    public int compare(Object pObj1, Object pObj2)
    {
        SmVwAccountPaySumBean b1 = (SmVwAccountPaySumBean)pObj1;
        SmVwAccountPaySumBean b2 = (SmVwAccountPaySumBean)pObj2;
        int iReturn = 0;
        switch(iType)
        {
            case SmVwAccountPaySumManager.ID_PAY_SUM:
                if (b1.getPaySum() == null && b2.getPaySum() != null) {
                    iReturn = -1;
                } else if (b1.getPaySum() == null && b2.getPaySum() == null) {
                    iReturn = 0;
                } else if (b1.getPaySum() != null && b2.getPaySum() == null) {
                    iReturn = 1;
                } else {
                    iReturn = b1.getPaySum().compareTo(b2.getPaySum());
                }
                break;
            case SmVwAccountPaySumManager.ID_USER_ID:
                if (b1.getUserId() == null && b2.getUserId() != null) {
                    iReturn = -1;
                } else if (b1.getUserId() == null && b2.getUserId() == null) {
                    iReturn = 0;
                } else if (b1.getUserId() != null && b2.getUserId() == null) {
                    iReturn = 1;
                } else {
                    iReturn = b1.getUserId().compareTo(b2.getUserId());
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