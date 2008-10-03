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

import java.sql.SQLException;
// imports+ 

// imports- 


/**
 * Listener that is notified of sm_tb_week_discount table changes.
 */
public interface SmTbWeekDiscountListener
// extends+ 

// extends- 
{
    /**
     * Invoked just before inserting a SmTbWeekDiscountBean record into the database.
     *
     * @param pObject the SmTbWeekDiscountBean that is about to be inserted
     */
    public void beforeInsert(SmTbWeekDiscountBean pObject) throws SQLException;


    /**
     * Invoked just after a SmTbWeekDiscountBean record is inserted in the database.
     *
     * @param pObject the SmTbWeekDiscountBean that was just inserted
     */
    public void afterInsert(SmTbWeekDiscountBean pObject) throws SQLException;


    /**
     * Invoked just before updating a SmTbWeekDiscountBean record in the database.
     *
     * @param pObject the SmTbWeekDiscountBean that is about to be updated
     */
    public void beforeUpdate(SmTbWeekDiscountBean pObject) throws SQLException;


    /**
     * Invoked just after updating a SmTbWeekDiscountBean record in the database.
     *
     * @param pObject the SmTbWeekDiscountBean that was just updated
     */
    public void afterUpdate(SmTbWeekDiscountBean pObject) throws SQLException;


// class+ 

// class- 
}