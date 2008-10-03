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

import java.sql.*;
// imports+ 

// imports- 

/**
 * Handles database calls for the sm_tb_sale_record table.
 */
public class SmTbSaleRecordManager
// extends+ 

// extends- 
{

    /**
     * Column sale_seq of type Types.DECIMAL mapped to Long.
     */
    public static final int ID_SALE_SEQ = 0;
    public static final int TYPE_SALE_SEQ = Types.DECIMAL;
    public static final String NAME_SALE_SEQ = "sale_seq";

    /**
     * Column sale_total of type Types.DECIMAL mapped to Long.
     */
    public static final int ID_SALE_TOTAL = 1;
    public static final int TYPE_SALE_TOTAL = Types.DECIMAL;
    public static final String NAME_SALE_TOTAL = "sale_total";

    /**
     * Column sale_date of type Types.TIMESTAMP mapped to java.util.Date.
     */
    public static final int ID_SALE_DATE = 2;
    public static final int TYPE_SALE_DATE = Types.TIMESTAMP;
    public static final String NAME_SALE_DATE = "sale_date";

    /**
     * Column vip_id of type Types.DECIMAL mapped to Long.
     */
    public static final int ID_VIP_ID = 3;
    public static final int TYPE_VIP_ID = Types.DECIMAL;
    public static final String NAME_VIP_ID = "vip_id";

    /**
     * Column sales_id of type Types.DECIMAL mapped to Long.
     */
    public static final int ID_SALES_ID = 4;
    public static final int TYPE_SALES_ID = Types.DECIMAL;
    public static final String NAME_SALES_ID = "sales_id";


    private static final String TABLE_NAME = "sm_tb_sale_record";

    /**
     * Create an array of type string containing all the fields of the sm_tb_sale_record table.
     */
    private static final String[] FIELD_NAMES =
    {
        "sm_tb_sale_record.sale_seq"
        ,"sm_tb_sale_record.sale_total"
        ,"sm_tb_sale_record.sale_date"
        ,"sm_tb_sale_record.vip_id"
        ,"sm_tb_sale_record.sales_id"
    };

    /**
     * Field that contains the comma separated fields of the sm_tb_sale_record table.
     */
    private static final String ALL_FIELDS = "sm_tb_sale_record.sale_seq"
                            + ",sm_tb_sale_record.sale_total"
                            + ",sm_tb_sale_record.sale_date"
                            + ",sm_tb_sale_record.vip_id"
                            + ",sm_tb_sale_record.sales_id";

    private static SmTbSaleRecordManager singleton = new SmTbSaleRecordManager();

    /**
     * Get the SmTbSaleRecordManager singleton.
     *
     * @return SmTbSaleRecordManager
     */
    synchronized public static SmTbSaleRecordManager getInstance()
    {
        return singleton;
    }

    /**
     * Sets your own SmTbSaleRecordManager instance.
     <br>
     * This is optional, by default we provide it for you.
     */
    synchronized public static void setInstance(SmTbSaleRecordManager instance)
    {
        singleton = instance;
    }


    /**
     * Creates a new SmTbSaleRecordBean instance.
     *
     * @return the new SmTbSaleRecordBean
     */
    public SmTbSaleRecordBean createSmTbSaleRecordBean()
    {
        return new SmTbSaleRecordBean();
    }

    //////////////////////////////////////
    // PRIMARY KEY METHODS
    //////////////////////////////////////

    /**
     * Loads a SmTbSaleRecordBean from the sm_tb_sale_record using its key fields.
     *
     * @return a unique SmTbSaleRecordBean
     */
    //12
    public SmTbSaleRecordBean loadByPrimaryKey(Long saleSeq) throws SQLException
    {
        Connection c = null;
        PreparedStatement ps = null;
        try
        {
            c = getConnection();
            ps = c.prepareStatement("SELECT " + ALL_FIELDS + " FROM sm_tb_sale_record WHERE sm_tb_sale_record.sale_seq=?",ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            Manager.setLong(ps, 1, saleSeq);
            SmTbSaleRecordBean pReturn[] = loadByPreparedStatement(ps);
            if (pReturn.length < 1)
                return null;
            else
                return pReturn[0];
        }
        finally
        {
            getManager().close(ps);
            freeConnection(c);
        }
    }

    /**
     * Deletes rows according to its keys.
     *
     * @return the number of deleted rows
     */
    //60
    public int deleteByPrimaryKey(Long saleSeq) throws SQLException
    {
        Connection c = null;
        PreparedStatement ps = null;
        try
        {
            c = getConnection();
            ps = c.prepareStatement("DELETE from sm_tb_sale_record WHERE sm_tb_sale_record.sale_seq=?",ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            Manager.setLong(ps, 1, saleSeq);
            return ps.executeUpdate();
        }
        finally
        {
            getManager().close(ps);
            freeConnection(c);
        }
    }


    //////////////////////////////////////
    // LOAD ALL
    //////////////////////////////////////

    /**
     * Loads all the rows from sm_tb_sale_record.
     *
     * @return an array of SmTbSaleRecordManager pObject
     */
    //38
    public SmTbSaleRecordBean[] loadAll() throws SQLException
    {
        return loadAll(1, -1);
    }


    /**
     * Loads the given number of rows from sm_tb_sale_record, given the start row.
     *
     * @param startRow the start row to be used (first row = 1, last row = -1)
     * @param numRows the number of rows to be retrieved (all rows = a negative number)
     * @return an array of SmTbSaleRecordManager pObject
     */
    //38.5
    public SmTbSaleRecordBean[] loadAll(int startRow, int numRows) throws SQLException
    {
        Connection c = null;
        PreparedStatement ps = null;
        try
        {
            c = getConnection();
            ps = c.prepareStatement("SELECT " + ALL_FIELDS + " FROM sm_tb_sale_record",ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            return loadByPreparedStatement(ps, null, startRow, numRows);
        }
        finally
        {
            getManager().close(ps);
            freeConnection(c);
        }
    }

    //////////////////////////////////////
    // SQL 'WHERE' METHOD
    //////////////////////////////////////
    /**
     * Retrieves an array of SmTbSaleRecordBean given a sql 'where' clause.
     *
     * @param where the sql 'where' clause
     * @return the resulting SmTbSaleRecordBean table
     */
    //49
    public SmTbSaleRecordBean[] loadByWhere(String where) throws SQLException
    {
        return loadByWhere(where, null);
    }

    /**
     * Retrieves an array of SmTbSaleRecordBean given a sql where clause, and a list of fields.
     * It is up to you to pass the 'WHERE' in your where clausis.
     *
     * @param where the sql 'where' clause
     * @param fieldList table of the field's associated constants
     * @return the resulting SmTbSaleRecordBean table
     */
    //51
    public SmTbSaleRecordBean[] loadByWhere(String where, int[] fieldList) throws SQLException
    {
        return loadByWhere(where, null, 1, -1);
    }

    /**
     * Retrieves an array of SmTbSaleRecordBean given a sql where clause and a list of fields, and startRow and numRows.
     * It is up to you to pass the 'WHERE' in your where clausis.
     *
     * @param where the sql 'where' clause
     * @param startRow the start row to be used (first row = 1, last row = -1)
     * @param numRows the number of rows to be retrieved (all rows = a negative number)
     * @param fieldList table of the field's associated constants
     * @return the resulting SmTbSaleRecordBean table
     */
    //51.5
    public SmTbSaleRecordBean[] loadByWhere(String where, int[] fieldList, int startRow, int numRows) throws SQLException
    {
        String sql = null;
        if(fieldList == null)
            sql = "select " + ALL_FIELDS + " from sm_tb_sale_record " + where;
        else
        {
            StringBuffer buff = new StringBuffer(128);
            buff.append("select ");
            for(int i = 0; i < fieldList.length; i++)
            {
                if(i != 0)
                    buff.append(",");
                buff.append(FIELD_NAMES[fieldList[i]]);
            }
            buff.append(" from sm_tb_sale_record ");
            buff.append(where);
            sql = buff.toString();
            buff = null;
        }
        Connection c = null;
        Statement pStatement = null;
        ResultSet rs =  null;
        java.util.ArrayList v = null;
        try
        {
            c = getConnection();
            pStatement = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs =  pStatement.executeQuery(sql);
            v = new java.util.ArrayList();
            int count = 0;
            if (rs.absolute(startRow) && numRows!=0) {
                do
                {
                    if(fieldList == null)
                        v.add(decodeRow(rs));
                    else
                        v.add(decodeRow(rs, fieldList));
                    count++;
                } while ( (count<numRows||numRows<0) && rs.next() );
            }

            return (SmTbSaleRecordBean[])v.toArray(new SmTbSaleRecordBean[0]);
        }
        finally
        {
            if (v != null) { v.clear(); }
            getManager().close(pStatement, rs);
            freeConnection(c);
        }
    }


    /**
     * Deletes all rows from sm_tb_sale_record table.
     * @return the number of deleted rows.
     */
    public int deleteAll() throws SQLException
    {
        return deleteByWhere("");
    }


    /**
     * Deletes rows from the sm_tb_sale_record table using a 'where' clause.
     * It is up to you to pass the 'WHERE' in your where clausis.
     * <br>Attention, if 'WHERE' is omitted it will delete all records.
     *
     * @param where the sql 'where' clause
     * @return the number of deleted rows
     */
    public int deleteByWhere(String where) throws SQLException
    {
        Connection c = null;
        PreparedStatement ps = null;

        try
        {
            c = getConnection();
            String delByWhereSQL = "DELETE FROM sm_tb_sale_record " + where;
            ps = c.prepareStatement(delByWhereSQL);
            return ps.executeUpdate();
        }
        finally
        {
            getManager().close(ps);
            freeConnection(c);
        }
    }



    ///////////////////////////////////////////////////////////////////////
    // SAVE
    ///////////////////////////////////////////////////////////////////////
    /**
     * Saves the SmTbSaleRecordBean pObject into the database.
     *
     * @param pObject the SmTbSaleRecordBean pObject to be saved
     */
    //100
    public SmTbSaleRecordBean save(SmTbSaleRecordBean pObject) throws SQLException
    {
        if (!pObject.isModified()) {
            return pObject; // should not we log something ?
        }

        Connection c = null;
        PreparedStatement ps = null;
        StringBuffer _sql = null;

        try
        {
            c = getConnection();
            if (pObject.isNew())
            { // SAVE
                beforeInsert(pObject); // listener callback
                int _dirtyCount = 0;
                _sql = new StringBuffer("INSERT into sm_tb_sale_record (");

                if (pObject.isSaleSeqModified()) {
                    if (_dirtyCount>0) {
                        _sql.append(",");
                    }
                    _sql.append("sale_seq");
                    _dirtyCount++;
                }

                if (pObject.isSaleTotalModified()) {
                    if (_dirtyCount>0) {
                        _sql.append(",");
                    }
                    _sql.append("sale_total");
                    _dirtyCount++;
                }

                if (pObject.isSaleDateModified()) {
                    if (_dirtyCount>0) {
                        _sql.append(",");
                    }
                    _sql.append("sale_date");
                    _dirtyCount++;
                }

                if (pObject.isVipIdModified()) {
                    if (_dirtyCount>0) {
                        _sql.append(",");
                    }
                    _sql.append("vip_id");
                    _dirtyCount++;
                }

                if (pObject.isSalesIdModified()) {
                    if (_dirtyCount>0) {
                        _sql.append(",");
                    }
                    _sql.append("sales_id");
                    _dirtyCount++;
                }

                _sql.append(") values (");
                if(_dirtyCount > 0) {
                    _sql.append("?");
                    for(int i = 1; i < _dirtyCount; i++) {
                        _sql.append(",?");
                    }
                }
                _sql.append(")");

                ps = c.prepareStatement(_sql.toString(), ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                _dirtyCount = 0;

                if (pObject.isSaleSeqModified()) {
                    Manager.setLong(ps, ++_dirtyCount, pObject.getSaleSeq());
                }

                if (pObject.isSaleTotalModified()) {
                    Manager.setLong(ps, ++_dirtyCount, pObject.getSaleTotal());
                }

                if (pObject.isSaleDateModified()) {
                    if (pObject.getSaleDate() == null) ps.setNull(++_dirtyCount, Types.TIMESTAMP); else ps.setTimestamp(++_dirtyCount, new java.sql.Timestamp(pObject.getSaleDate().getTime()));
                }

                if (pObject.isVipIdModified()) {
                    Manager.setLong(ps, ++_dirtyCount, pObject.getVipId());
                }

                if (pObject.isSalesIdModified()) {
                    Manager.setLong(ps, ++_dirtyCount, pObject.getSalesId());
                }

                ps.executeUpdate();

                if (!pObject.isSaleSeqModified())
                {
                    PreparedStatement ps2 = null;
                    ResultSet rs = null;
                    try {
                        ps2 = c.prepareStatement("SELECT last_insert_id()");
                        rs = ps2.executeQuery();
                        if(rs.next()) {
                            pObject.setSaleSeq(Manager.getLong(rs, 1));
                        } else {
                            getManager().log("ATTENTION: Could not retrieve generated key!");
                        }
                    } finally {
                        getManager().close(ps2, rs);
                    }
                }

                pObject.isNew(false);
                pObject.resetIsModified();
                afterInsert(pObject); // listener callback
            }
            else
            { // UPDATE
                beforeUpdate(pObject); // listener callback
                _sql = new StringBuffer("UPDATE sm_tb_sale_record SET ");
                boolean useComma=false;

                if (pObject.isSaleSeqModified()) {
                    if (useComma) {
                        _sql.append(",");
                    } else {
                        useComma=true;
                    }
                    _sql.append("sale_seq").append("=?");
                }

                if (pObject.isSaleTotalModified()) {
                    if (useComma) {
                        _sql.append(",");
                    } else {
                        useComma=true;
                    }
                    _sql.append("sale_total").append("=?");
                }

                if (pObject.isSaleDateModified()) {
                    if (useComma) {
                        _sql.append(",");
                    } else {
                        useComma=true;
                    }
                    _sql.append("sale_date").append("=?");
                }

                if (pObject.isVipIdModified()) {
                    if (useComma) {
                        _sql.append(",");
                    } else {
                        useComma=true;
                    }
                    _sql.append("vip_id").append("=?");
                }

                if (pObject.isSalesIdModified()) {
                    if (useComma) {
                        _sql.append(",");
                    } else {
                        useComma=true;
                    }
                    _sql.append("sales_id").append("=?");
                }
                _sql.append(" WHERE ");
                _sql.append("sm_tb_sale_record.sale_seq=?");
                ps = c.prepareStatement(_sql.toString(),ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                int _dirtyCount = 0;

                if (pObject.isSaleSeqModified()) {
                      Manager.setLong(ps, ++_dirtyCount, pObject.getSaleSeq());
                }

                if (pObject.isSaleTotalModified()) {
                      Manager.setLong(ps, ++_dirtyCount, pObject.getSaleTotal());
                }

                if (pObject.isSaleDateModified()) {
                      if (pObject.getSaleDate() == null) ps.setNull(++_dirtyCount, Types.TIMESTAMP); else ps.setTimestamp(++_dirtyCount, new java.sql.Timestamp(pObject.getSaleDate().getTime()));
                }

                if (pObject.isVipIdModified()) {
                      Manager.setLong(ps, ++_dirtyCount, pObject.getVipId());
                }

                if (pObject.isSalesIdModified()) {
                      Manager.setLong(ps, ++_dirtyCount, pObject.getSalesId());
                }

                if (_dirtyCount == 0) {
                     return pObject;
                }

                Manager.setLong(ps, ++_dirtyCount, pObject.getSaleSeq());
                ps.executeUpdate();
                pObject.resetIsModified();
                afterUpdate(pObject); // listener callback
            }

            return pObject;
        }
        finally
        {
            getManager().close(ps);
            freeConnection(c);
        }
    }



    /**
     * Saves an array of SmTbSaleRecordBean pObjects into the database.
     *
     * @param pObjects the SmTbSaleRecordBean pObject table to be saved
     * @return the saved SmTbSaleRecordBean array.
     */
    //65
    public SmTbSaleRecordBean[] save(SmTbSaleRecordBean[] pObjects) throws SQLException
    {
        for (int iIndex = 0; iIndex < pObjects.length; iIndex ++){
            save(pObjects[iIndex]);
        }
        return pObjects;
    }



    ///////////////////////////////////////////////////////////////////////
    // USING TEMPLATE
    ///////////////////////////////////////////////////////////////////////
    /**
     * Loads a unique SmTbSaleRecordBean pObject from a template one giving a c
     *
     * @param pObject the SmTbSaleRecordBean pObject to look for
     * @return the pObject matching the template
     */
    //85
    public SmTbSaleRecordBean loadUniqueUsingTemplate(SmTbSaleRecordBean pObject) throws SQLException
    {
         SmTbSaleRecordBean[] pReturn = loadUsingTemplate(pObject);
         if (pReturn.length == 0)
             return null;
         if (pReturn.length > 1)
             throw new SQLException("More than one element !!");
         return pReturn[0];
     }

    /**
     * Loads an array of SmTbSaleRecordBean from a template one.
     *
     * @param pObject the SmTbSaleRecordBean template to look for
     * @return all the SmTbSaleRecordBean matching the template
     */
    //88
    public SmTbSaleRecordBean[] loadUsingTemplate(SmTbSaleRecordBean pObject) throws SQLException
    {
        return loadUsingTemplate(pObject, 1, -1);
    }
    /**
     * Loads an array of SmTbSaleRecordBean from a template one, given the start row and number of rows.
     *
     * @param pObject the SmTbSaleRecordBean template to look for
     * @param startRow the start row to be used (first row = 1, last row=-1)
     * @param numRows the number of rows to be retrieved (all rows = a negative number)
     * @return all the SmTbSaleRecordBean matching the template
     */
    //88.5
    public SmTbSaleRecordBean[] loadUsingTemplate(SmTbSaleRecordBean pObject, int startRow, int numRows) throws SQLException
    {
        Connection c = null;
        PreparedStatement ps = null;
        StringBuffer where = new StringBuffer("");
        StringBuffer _sql = new StringBuffer("SELECT " + ALL_FIELDS + " from sm_tb_sale_record WHERE ");
        StringBuffer _sqlWhere = new StringBuffer("");
        try
        {
            int _dirtyCount = 0;

             if (pObject.isSaleSeqModified()) {
                 _dirtyCount ++;
                 _sqlWhere.append((_sqlWhere.length() == 0) ? " " : " AND ").append("sale_seq= ?");
             }

             if (pObject.isSaleTotalModified()) {
                 _dirtyCount ++;
                 _sqlWhere.append((_sqlWhere.length() == 0) ? " " : " AND ").append("sale_total= ?");
             }

             if (pObject.isSaleDateModified()) {
                 _dirtyCount ++;
                 _sqlWhere.append((_sqlWhere.length() == 0) ? " " : " AND ").append("sale_date= ?");
             }

             if (pObject.isVipIdModified()) {
                 _dirtyCount ++;
                 _sqlWhere.append((_sqlWhere.length() == 0) ? " " : " AND ").append("vip_id= ?");
             }

             if (pObject.isSalesIdModified()) {
                 _dirtyCount ++;
                 _sqlWhere.append((_sqlWhere.length() == 0) ? " " : " AND ").append("sales_id= ?");
             }

             if (_dirtyCount == 0) {
                 throw new SQLException ("The pObject to look for is invalid : not initialized !");
             }
             _sql.append(_sqlWhere);
             c = getConnection();
             ps = c.prepareStatement(_sql.toString(),ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
             _dirtyCount = 0;

             if (pObject.isSaleSeqModified()) {
                 Manager.setLong(ps, ++_dirtyCount, pObject.getSaleSeq());
             }

             if (pObject.isSaleTotalModified()) {
                 Manager.setLong(ps, ++_dirtyCount, pObject.getSaleTotal());
             }

             if (pObject.isSaleDateModified()) {
                 if (pObject.getSaleDate() == null) ps.setNull(++_dirtyCount, Types.TIMESTAMP); else ps.setTimestamp(++_dirtyCount, new java.sql.Timestamp(pObject.getSaleDate().getTime()));
             }

             if (pObject.isVipIdModified()) {
                 Manager.setLong(ps, ++_dirtyCount, pObject.getVipId());
             }

             if (pObject.isSalesIdModified()) {
                 Manager.setLong(ps, ++_dirtyCount, pObject.getSalesId());
             }

             ps.executeQuery();
             return loadByPreparedStatement(ps, null, startRow, numRows);
        }
        finally
        {
            getManager().close(ps);
            freeConnection(c);
        }
    }
    /**
     * Deletes rows using a SmTbSaleRecordBean template.
     *
     * @param pObject the SmTbSaleRecordBean object(s) to be deleted
     * @return the number of deleted objects
     */
    //63
    public int deleteUsingTemplate(SmTbSaleRecordBean pObject) throws SQLException
    {
        if (pObject.isSaleSeqInitialized())
            return deleteByPrimaryKey(pObject.getSaleSeq());

        Connection c = null;
        PreparedStatement ps = null;
        StringBuffer sql = null;

        try
        {
            sql = new StringBuffer("DELETE FROM sm_tb_sale_record WHERE ");
            int _dirtyAnd = 0;
            if (pObject.isSaleSeqInitialized()) {
                if (_dirtyAnd > 0)
                    sql.append(" AND ");
                sql.append("sale_seq").append("=?");
                _dirtyAnd ++;
            }

            if (pObject.isSaleTotalInitialized()) {
                if (_dirtyAnd > 0)
                    sql.append(" AND ");
                sql.append("sale_total").append("=?");
                _dirtyAnd ++;
            }

            if (pObject.isSaleDateInitialized()) {
                if (_dirtyAnd > 0)
                    sql.append(" AND ");
                sql.append("sale_date").append("=?");
                _dirtyAnd ++;
            }

            if (pObject.isVipIdInitialized()) {
                if (_dirtyAnd > 0)
                    sql.append(" AND ");
                sql.append("vip_id").append("=?");
                _dirtyAnd ++;
            }

            if (pObject.isSalesIdInitialized()) {
                if (_dirtyAnd > 0)
                    sql.append(" AND ");
                sql.append("sales_id").append("=?");
                _dirtyAnd ++;
            }

            c = getConnection();
            ps = c.prepareStatement(sql.toString(),ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            int _dirtyCount = 0;

            if (pObject.isSaleSeqInitialized()) {
                Manager.setLong(ps, ++_dirtyCount, pObject.getSaleSeq());
            }

            if (pObject.isSaleTotalInitialized()) {
                Manager.setLong(ps, ++_dirtyCount, pObject.getSaleTotal());
            }

            if (pObject.isSaleDateInitialized()) {
                if (pObject.getSaleDate() == null) ps.setNull(++_dirtyCount, Types.TIMESTAMP); else ps.setTimestamp(++_dirtyCount, new java.sql.Timestamp(pObject.getSaleDate().getTime()));
            }

            if (pObject.isVipIdInitialized()) {
                Manager.setLong(ps, ++_dirtyCount, pObject.getVipId());
            }

            if (pObject.isSalesIdInitialized()) {
                Manager.setLong(ps, ++_dirtyCount, pObject.getSalesId());
            }

            int _rows = ps.executeUpdate();
            return _rows;
        }
        finally
        {
            getManager().close(ps);
            freeConnection(c);
        }
    }



    ///////////////////////////////////////////////////////////////////////
    // COUNT
    ///////////////////////////////////////////////////////////////////////

    /**
     * Retrieves the number of rows of the table sm_tb_sale_record.
     *
     * @return the number of rows returned
     */
    //78
    public int countAll() throws SQLException
    {
        return countWhere("");
    }



    /**
     * Retrieves the number of rows of the table sm_tb_sale_record with a 'where' clause.
     * It is up to you to pass the 'WHERE' in your where clausis.
     *
     * @param where the restriction clause
     * @return the number of rows returned
     */
    public int countWhere(String where) throws SQLException
    {
        String sql = "select count(*) as MCOUNT from sm_tb_sale_record " + where;
        Connection c = null;
        Statement pStatement = null;
        ResultSet rs =  null;
        try
        {
            int iReturn = -1;
            c = getConnection();
            pStatement = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs =  pStatement.executeQuery(sql);
            if (rs.next())
            {
                iReturn = rs.getInt("MCOUNT");
            }
            if (iReturn != -1)
                return iReturn;
        }
        finally
        {
            getManager().close(pStatement, rs);
            freeConnection(c);
        }
       throw new SQLException("Error in countWhere");
    }

    /**
     * Retrieves the number of rows of the table sm_tb_sale_record with a prepared statement.
     *
     * @param ps the PreparedStatement to be used
     * @return the number of rows returned
     */
    //82
    int countByPreparedStatement(PreparedStatement ps) throws SQLException
    {
        ResultSet rs =  null;
        try
        {
            int iReturn = -1;
            rs = ps.executeQuery();
            if (rs.next())
                iReturn = rs.getInt("MCOUNT");
            if (iReturn != -1)
                return iReturn;
        }
        finally
        {
            getManager().close(rs);
        }
       throw new SQLException("Error in countByPreparedStatement");
    }

    /**
     * Looks for the number of elements of a specific SmTbSaleRecordBean pObject given a c
     *
     * @param pObject the SmTbSaleRecordBean pObject to look for
     * @return the number of rows returned
     */
    //83
    public int countUsingTemplate(SmTbSaleRecordBean pObject) throws SQLException
    {
        StringBuffer where = new StringBuffer("");
        Connection c = null;
        PreparedStatement ps = null;
        StringBuffer _sql = null;
        StringBuffer _sqlWhere = null;

        try
        {
                _sql = new StringBuffer("SELECT count(*) as MCOUNT  from sm_tb_sale_record WHERE ");
                _sqlWhere = new StringBuffer("");
                int _dirtyCount = 0;

                if (pObject.isSaleSeqModified()) {
                    _dirtyCount++;
                    _sqlWhere.append((_sqlWhere.length() == 0) ? " " : " AND ").append("sale_seq= ?");
                }

                if (pObject.isSaleTotalModified()) {
                    _dirtyCount++;
                    _sqlWhere.append((_sqlWhere.length() == 0) ? " " : " AND ").append("sale_total= ?");
                }

                if (pObject.isSaleDateModified()) {
                    _dirtyCount++;
                    _sqlWhere.append((_sqlWhere.length() == 0) ? " " : " AND ").append("sale_date= ?");
                }

                if (pObject.isVipIdModified()) {
                    _dirtyCount++;
                    _sqlWhere.append((_sqlWhere.length() == 0) ? " " : " AND ").append("vip_id= ?");
                }

                if (pObject.isSalesIdModified()) {
                    _dirtyCount++;
                    _sqlWhere.append((_sqlWhere.length() == 0) ? " " : " AND ").append("sales_id= ?");
                }

                if (_dirtyCount == 0)
                   throw new SQLException ("The pObject to look is unvalid : not initialized !");

                _sql.append(_sqlWhere);
                c = getConnection();
                ps = c.prepareStatement(_sql.toString(),ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

                _dirtyCount = 0;

                if (pObject.isSaleSeqModified()) {
                    Manager.setLong(ps, ++_dirtyCount, pObject.getSaleSeq());
                }

                if (pObject.isSaleTotalModified()) {
                    Manager.setLong(ps, ++_dirtyCount, pObject.getSaleTotal());
                }

                if (pObject.isSaleDateModified()) {
                    if (pObject.getSaleDate() == null) ps.setNull(++_dirtyCount, Types.TIMESTAMP); else ps.setTimestamp(++_dirtyCount, new java.sql.Timestamp(pObject.getSaleDate().getTime()));
                }

                if (pObject.isVipIdModified()) {
                    Manager.setLong(ps, ++_dirtyCount, pObject.getVipId());
                }

                if (pObject.isSalesIdModified()) {
                    Manager.setLong(ps, ++_dirtyCount, pObject.getSalesId());
                }

                return countByPreparedStatement(ps);
        }
        finally
        {
            getManager().close(ps);
            freeConnection(c);
        }
    }



    ///////////////////////////////////////////////////////////////////////
    // DECODE RESULT SET
    ///////////////////////////////////////////////////////////////////////
    /**
     * Transforms a ResultSet iterating on the sm_tb_sale_record on a SmTbSaleRecordBean pObject.
     *
     * @param rs the ResultSet to be transformed
     * @return pObject resulting SmTbSaleRecordBean pObject
     */
    //72
    public SmTbSaleRecordBean decodeRow(ResultSet rs) throws SQLException
    {
        SmTbSaleRecordBean pObject = createSmTbSaleRecordBean();
        pObject.setSaleSeq(Manager.getLong(rs, 1));
        pObject.setSaleTotal(Manager.getLong(rs, 2));
        pObject.setSaleDate(rs.getTimestamp(3));
        pObject.setVipId(Manager.getLong(rs, 4));
        pObject.setSalesId(Manager.getLong(rs, 5));

        pObject.isNew(false);
        pObject.resetIsModified();

        return pObject;
    }

    /**
     * Transforms a ResultSet iterating on the sm_tb_sale_record table on a SmTbSaleRecordBean pObject according to a list of fields.
     *
     * @param rs the ResultSet to be transformed
     * @param fieldList table of the field's associated constants
     * @return pObject resulting SmTbSaleRecordBean pObject
     */
    //73
    public SmTbSaleRecordBean decodeRow(ResultSet rs, int[] fieldList) throws SQLException
    {
        SmTbSaleRecordBean pObject = createSmTbSaleRecordBean();
        int pos = 0;
        for(int i = 0; i < fieldList.length; i++)
        {
            switch(fieldList[i]) {
                case ID_SALE_SEQ:
                    ++pos;
                    pObject.setSaleSeq(Manager.getLong(rs, pos));
                    break;
                case ID_SALE_TOTAL:
                    ++pos;
                    pObject.setSaleTotal(Manager.getLong(rs, pos));
                    break;
                case ID_SALE_DATE:
                    ++pos;
                    pObject.setSaleDate(rs.getTimestamp(pos));
                    break;
                case ID_VIP_ID:
                    ++pos;
                    pObject.setVipId(Manager.getLong(rs, pos));
                    break;
                case ID_SALES_ID:
                    ++pos;
                    pObject.setSalesId(Manager.getLong(rs, pos));
                    break;
            }
        }
        pObject.isNew(false);
        pObject.resetIsModified();

        return pObject;
    }

    //////////////////////////////////////
    // PREPARED STATEMENT LOADER
    //////////////////////////////////////

    /**
     * Loads all the elements using a prepared statement.
     *
     * @param ps the PreparedStatement to be used
     * @return an array of SmTbSaleRecordBean
     */
    //41
    public SmTbSaleRecordBean[] loadByPreparedStatement(PreparedStatement ps) throws SQLException
    {
        return loadByPreparedStatement(ps, null);
    }

    /**
     * Loads all the elements using a prepared statement specifying a list of fields to be retrieved.
     *
     * @param ps the PreparedStatement to be used
     * @param fieldList table of the field's associated constants
     * @return an array of SmTbSaleRecordBean
     */
    public SmTbSaleRecordBean[] loadByPreparedStatement(PreparedStatement ps, int[] fieldList) throws SQLException
    {
        return loadByPreparedStatement(ps, fieldList, 1, -1);
    }

    /**
     * Loads all the elements using a prepared statement specifying a list of fields to be retrieved,
     * and specifying the start row and the number of rows.
     *
     * @param ps the PreparedStatement to be used
     * @param startRow the start row to be used (first row = 1, last row = -1)
     * @param numRows the number of rows to be retrieved (all rows = a negative number)
     * @param fieldList table of the field's associated constants
     * @return an array of SmTbSaleRecordBean
     */
    //41.5
    public SmTbSaleRecordBean[] loadByPreparedStatement(PreparedStatement ps, int[] fieldList, int startRow, int numRows) throws SQLException
    {
        ResultSet rs =  null;
        java.util.ArrayList v =  null;
        try
        {
            rs =  ps.executeQuery();
            v = new java.util.ArrayList();
            int count = 0;
            if (rs.absolute(startRow) && numRows!=0) {
                do
                {
                    if(fieldList == null)
                        v.add(decodeRow(rs));
                    else
                        v.add(decodeRow(rs, fieldList));
                    count++;
                } while ( (count<numRows||numRows<0) && rs.next() );
            }
            return (SmTbSaleRecordBean[])v.toArray(new SmTbSaleRecordBean[0]);
        }
        finally
        {
            if (v != null) { v.clear(); v = null;}
            getManager().close(rs);
        }
    }

    ///////////////////////////////////////////////////////////////////////
    // LISTENER
    ///////////////////////////////////////////////////////////////////////
    private SmTbSaleRecordListener listener = null;

    /**
     * Registers a unique SmTbSaleRecordListener listener.
     */
    //66.5
    public void registerListener(SmTbSaleRecordListener listener) {
        this.listener = listener;
    }

    /**
     * Before the save of the SmTbSaleRecordBean pObject.
     *
     * @param pObject the SmTbSaleRecordBean pObject to be saved
     */
    //67
    void beforeInsert(SmTbSaleRecordBean pObject) throws SQLException {
        if (listener != null)
            listener.beforeInsert(pObject);
    }

    /**
     * After the save of the SmTbSaleRecordBean pObject.
     *
     * @param pObject the SmTbSaleRecordBean pObject to be saved
     */
    //68
    void afterInsert(SmTbSaleRecordBean pObject) throws SQLException {
        if (listener != null)
            listener.afterInsert(pObject);
    }

    /**
     * Before the update of the SmTbSaleRecordBean pObject.
     *
     * @param pObject the SmTbSaleRecordBean pObject to be updated
     */
    //69
    void beforeUpdate(SmTbSaleRecordBean pObject) throws SQLException {
        if (listener != null)
            listener.beforeUpdate(pObject);
    }

    /**
     * After the update of the SmTbSaleRecordBean pObject.
     *
     * @param pObject the SmTbSaleRecordBean pObject to be updated
     */
    //70
    void afterUpdate(SmTbSaleRecordBean pObject) throws SQLException {
        if (listener != null)
            listener.afterUpdate(pObject);
    }

    ///////////////////////////////////////////////////////////////////////
    // UTILS
    ///////////////////////////////////////////////////////////////////////

    /**
     * Retrieves the manager object used to get connections.
     *
     * @return the manager used
     */
    //2
    Manager getManager() {
        return Manager.getInstance();
    }

    /**
     * Frees the connection.
     *
     * @param c the connection to release
     */
    void freeConnection(Connection c) {
        getManager().releaseConnection(c); // back to pool
    }
    /**
     * Gets the connection.
     */
    Connection getConnection() throws SQLException {
        return getManager().getConnection();
    }

// class+ 

// class- 
}
