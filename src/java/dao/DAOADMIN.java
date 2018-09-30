/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Admin;
import model.DBConnection;

/**
 *
 * @author Bui Thanh Tung
 */
public class DAOADMIN {
    Connection conn = null;
    //Statement gửi câu lênh SQL cho server và nhận lại kết quả
    Statement state = null;
    //  ResultSet nhận lại kết quả câu lênh Select
    ResultSet rs = null;
    //ResultSetMetaData: siêu dữ liệu từ ResultSet
    ResultSetMetaData rsmd = null;
    DBConnection dbConn = null;
     public DAOADMIN(DBConnection dbConn) {
        this.dbConn = dbConn;
        conn = dbConn.getConnection();
    }

    
    public int addAdmin(Admin obj)
    {
        int n=0;
        String sqlPre="insert into admin (username,password,status) values (?,?,?)";
        try {
            PreparedStatement pre=conn.prepareStatement(sqlPre);
            pre.setString(1, obj.getUsername());
            pre.setString(2, obj.getPassword());
            pre.setInt(3, obj.getStatus());
            n=pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOADMIN.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
    public int updateAdmin(Admin obj) {
        int n = 0;
        String sql = "update admin set status=? where username=?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, obj.getStatus());
            pre.setString(2, obj.getUsername());
           // pre.setString(5, obj.getPassword());
            n=pre.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }
    public int deleteAdmin(String username) {
        int n = 0;
        String sql = "delete admin where username='"+username+"'";
        try {
            state=conn.createStatement();
            n=state.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DAOADMIN.class.getName()).log(Level.SEVERE, null, ex);
        }
        return n;
    }
}
