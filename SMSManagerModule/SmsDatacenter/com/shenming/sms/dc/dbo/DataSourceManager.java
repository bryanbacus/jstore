package com.shenming.sms.dc.dbo;

import java.sql.Connection;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.shenming.sms.util.Tool;

/**
 * @author Simon Su
 *
 */
public class DataSourceManager {
  private static Context initContext = null;
  private static DataSource ds = null;

  static {
    try {
      Context initContext = new InitialContext();
      ds = (DataSource) initContext.lookup(Tool.getStringProperty("DATA_SOURCE"));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static DataSource getDataSource() {
    return ds;
  }

  public static boolean testDataSource() {
    Connection conn = null;
    try {
      conn = ds.getConnection();
      if (conn != null) {
        return true;
      }
      return false;
    } catch (Exception e) {
        e.printStackTrace();
        return false;
    } finally {
      try {
        conn.close();
      } catch (Exception e) {}
    }
  }
}

