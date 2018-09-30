/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bui Thanh Tung
 */
public class DBConnection {
            Connection conn=null;
         
            public DBConnection(String url,String username,String password)
            {
 
                try {
                    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                    conn=DriverManager.getConnection(url, username, password);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
                }

                } 
           public Connection getConnection()
           {
               return conn;
           }
           
           public ResultSet getData(String sql)
           {
               ResultSet rs=null;
                try {
                    Statement sta=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                     rs=sta.executeQuery(sql);
                } catch (SQLException ex) {
                    Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
                }
                return rs;
           }
            // ResultSet nhận kết quả sql với đối tượng là select
           // Statement thực hiện câu lệnh sql
 }
            

