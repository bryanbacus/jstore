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
 * Listener that is notified of sm_tb_product table changes.
 */
public interface SmTbProductListener
// extends+ 

// extends- 
{
    /**
     * Invoked just before inserting a SmTbProductBean record into the database.
     *
     * @param pObject the SmTbProductBean that is about to be inserted
     */
    public void beforeInsert(SmTbProductBean pObject) throws SQLException;


    /**
     * Invoked just after a SmTbProductBean record is inserted in the database.
     *
     * @param pObject the SmTbProductBean that was just inserted
     */
    public void afterInsert(SmTbProductBean pObject) throws SQLException;


    /**
     * Invoked just before updating a SmTbProductBean record in the database.
     *
     * @param pObject the SmTbProductBean that is about to be updated
     */
    public void beforeUpdate(SmTbProductBean pObject) throws SQLException;


    /**
     * Invoked just after updating a SmTbProductBean record in the database.
     *
     * @param pObject the SmTbProductBean that was just updated
     */
    public void afterUpdate(SmTbProductBean pObject) throws SQLException;


// class+ 

// class- 
}
