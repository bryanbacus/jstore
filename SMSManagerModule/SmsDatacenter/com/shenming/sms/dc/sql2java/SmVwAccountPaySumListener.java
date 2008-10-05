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
 * Listener that is notified of sm_vw_account_pay_sum table changes.
 */
public interface SmVwAccountPaySumListener
// extends+ 

// extends- 
{
    /**
     * Invoked just before inserting a SmVwAccountPaySumBean record into the database.
     *
     * @param pObject the SmVwAccountPaySumBean that is about to be inserted
     */
    public void beforeInsert(SmVwAccountPaySumBean pObject) throws SQLException;


    /**
     * Invoked just after a SmVwAccountPaySumBean record is inserted in the database.
     *
     * @param pObject the SmVwAccountPaySumBean that was just inserted
     */
    public void afterInsert(SmVwAccountPaySumBean pObject) throws SQLException;


    /**
     * Invoked just before updating a SmVwAccountPaySumBean record in the database.
     *
     * @param pObject the SmVwAccountPaySumBean that is about to be updated
     */
    public void beforeUpdate(SmVwAccountPaySumBean pObject) throws SQLException;


    /**
     * Invoked just after updating a SmVwAccountPaySumBean record in the database.
     *
     * @param pObject the SmVwAccountPaySumBean that was just updated
     */
    public void afterUpdate(SmVwAccountPaySumBean pObject) throws SQLException;


// class+ 

// class- 
}
