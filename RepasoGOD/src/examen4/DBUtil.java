/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package examen4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author alpasa
 */
public class DBUtil {
    
    public static DBUtil db = new DBUtil();
    Connection conn;
    
    String databaseName = "world2";
    String databaseUserName = "2DAM";
    String databasePassword = "2DAM2022";
    String host = "localhost";
    String port = "3306";
    String error="";
   
    
    public synchronized static DBUtil getDBUtil() {
        if (db == null) {
            db = new DBUtil();
        }
        return db;
    }
    
    public Connection connectToDB() {
      String resultado = "";
      Connection conn = null;
      try {
            String MySQLURL = "jdbc:mysql://" + DBUtil.getDBUtil().host + ":" + DBUtil.getDBUtil().port + "/" + DBUtil.getDBUtil().databaseName;
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            this.conn = DriverManager.getConnection(MySQLURL, DBUtil.getDBUtil().databaseUserName, DBUtil.getDBUtil().databasePassword);
            return this.conn;
        } catch (SQLException e) {
            DBUtil.getDBUtil().error = e.toString();
            return null;
        }
   }
   
   public void cerrarConn() {
        try {
            this.conn.close();
        } catch (SQLException e) {
            DBUtil.getDBUtil().error = e.toString();
        }
    }
    
}
