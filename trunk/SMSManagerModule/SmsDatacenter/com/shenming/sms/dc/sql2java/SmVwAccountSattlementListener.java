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
 * Listener that is notified of sm_vw_account_sattlement table changes.
 */
public interface SmVwAccountSattlementListener
// extends+ 

// extends- 
{
    /**
     * Invoked just before inserting a SmVwAccountSattlementBean record into the database.
     *
     * @param pObject the SmVwAccountSattlementBean that is about to be inserted
     */
    public void beforeInsert(SmVwAccountSattlementBean pObject) throws SQLException;


    /**
     * Invoked just after a SmVwAccountSattlementBean record is inserted in the database.
     *
     * @param pObject the SmVwAccountSattlementBean that was just inserted
     */
    public void afterInsert(SmVwAccountSattlementBean pObject) throws SQLException;


    /**
     * Invoked just before updating a SmVwAccountSattlementBean record in the database.
     *
     * @param pObject the SmVwAccountSattlementBean that is about to be updated
     */
    public void beforeUpdate(SmVwAccountSattlementBean pObject) throws SQLException;


    /**
     * Invoked just after updating a SmVwAccountSattlementBean record in the database.
     *
     * @param pObject the SmVwAccountSattlementBean that was just updated
     */
    public void afterUpdate(SmVwAccountSattlementBean pObject) throws SQLException;


// class+ 

// class- 
}