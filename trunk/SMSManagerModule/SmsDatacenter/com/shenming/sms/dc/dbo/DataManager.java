package com.shenming.sms.dc.dbo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;
public class DataManager
{
	DataSource myPool = DataSourceManager.getDataSource();
	private Connection conn;
	Statement stmt = null;
	
	public void doConnect(){
		try {
			conn = myPool.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ResultSet getData(String mysql)
	{
	    try {
			stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(mysql);
			return rset;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return null;
	} //getData
	public ResultSet getScrollData(String mysql)
	{
		try {
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		    ResultSet rset = stmt.executeQuery(mysql);
		    return rset;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("ImergeQuery.getScrollData Error!!");
			e.printStackTrace();
		}
	    return null;
	} //getScrollData
	public int setData(String mysql)
	{	
		int mycount=0;
	    try {
			conn.setAutoCommit(false);
		    mycount = 0;
		    stmt = conn.createStatement();
	        mycount = stmt.executeUpdate(mysql);
	    } catch(Exception e) {
	        mycount = -1;
	    } finally {
		    if (mycount>0){
		        try {
					conn.commit();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
		    } else {
		        try {
					conn.rollback();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }//if (mycount>0)
	    }  //try
	    return mycount;  
	} //setData
	public void settingConn()
	{
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} //settingConn()
	public int settingData(String mysql)
	{
	    int mycount = 0;
	    try {
			stmt = conn.createStatement();
			mycount = stmt.executeUpdate(mysql);
		} catch(Exception e) {
			mycount = -1;
		}
	    return mycount;	        	
	} //settingData
	
	public void commitData(int setcount)
		throws SQLException,IOException	
	{	
	    if (setcount>0){
	        conn.commit();	
	    } else {
	    	conn.rollback();
	    }//if (mycount>0)
		
	} //commitData
		
	public void closeConn() throws SQLException,IOException
	{
		if(conn != null)
			conn.close();
		if(stmt != null)
			stmt.close();
	} //closeConn
	
}
