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
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.DBConnection;
import enity.EnityKhachHang;
/**
 *
 * @author Bui Thanh Tung
 */
public class DAOKHACHHang {
    Connection conn = null;
    //Statement gửi câu lênh SQL cho server và nhận lại kết quả
    Statement state = null;
    //  ResultSet nhận lại kết quả câu lênh Select
    ResultSet rs = null;
    //ResultSetMetaData: siêu dữ liệu từ ResultSet
    ResultSetMetaData rsmd = null;
    DBConnection dbConn = null;

    public DAOKHACHHang(DBConnection dbConn) {
        this.dbConn = dbConn;
        conn = dbConn.getConnection();
    }
    //insert/update/delete/select
//     insert/update/delete trả về số lượng bản ghi mà nó thao tác
    public int login(String username,String password)
    {
        String sql="select *from KhachHang where username='"+username+"' and password='"+password+"'";
        ResultSet rs=dbConn.getData(sql);
        try {
            if(rs.next())
            {
                return 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOKHACHHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    public int loginadmin(String username,String password)
    {
        String sql="select *from Admin where username='"+username+"' and password='"+password+"'";
        ResultSet rs=dbConn.getData(sql);
        try {
            if(rs.next())
            {
                return 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOKHACHHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    public int addKhachHang(EnityKhachHang obj) {
        int n = 0;
        //sql
//        String sql = "insert into KhachHang(cname,address,phone,username,password,status)"
//                + " values('" + obj.getcName() + "','" + obj.getAddress() + "','"
//                + obj.getPhone() + "','" + obj.getUserName() + "','"
//                + obj.getPassword() + "'," + obj.getStatus() + ")";
        String sqlPre = "insert into KhachHang(cname,address,phone,username,password,status) "
                + " values(?,?,?,?,?,?)";
        try {
            PreparedStatement pre = conn.prepareStatement(sqlPre);
            //set value for parameter
//            pre.setDataType(index of ?,value);
            pre.setString(1, obj.getcName());
            pre.setString(2, obj.getAddress());
            pre.setString(3, obj.getPhone());
            pre.setString(4, obj.getUserName());
            pre.setString(5, obj.getPassword());
            pre.setInt(6, obj.getStatus());
            //
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
//        
//        try {
//            //statement
//            state = conn.createStatement();
//            n = state.executeUpdate(sql);
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
        return n;
    }

    public int updateKhachHang(EnityKhachHang obj) {
        int n = 0;
        String sql = "update KhachHang set cname=?,address=?,"
                + "phone=?,status=? where cid=?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1, obj.getcName());
            pre.setString(2, obj.getAddress());
            pre.setString(3, obj.getPhone());
           // pre.setString(5, obj.getPassword());
            pre.setInt(4, obj.getStatus());
            pre.setInt(5, obj.getcID());
            n=pre.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }
    public int changePassword(String userName,String oldPass,String newPass){
        int n=0;
        //check 
        String sql="select * from KhachHang where userName=? and password=? "
                + " and status=1";
        try {
            PreparedStatement pre=conn.prepareStatement(sql);
            pre.setString(1,userName);
            pre.setString(2,oldPass);
            ResultSet rs=pre.executeQuery();
            if(rs.next()){ // user ton tai va hoat dong
                String SQLupdate="update KhachHang set password='"+newPass+"' "
                        + "where username='"+userName+"'";
                state=conn.createStatement();
                n=state.executeUpdate(SQLupdate);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOKHACHHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return n;
    }
    
    public void displayAllKhachHang(){
        String sql="select * from khachHang";
        ResultSet rs=dbConn.getData(sql);
        try {
            while(rs.next()){
                EnityKhachHang obj=new EnityKhachHang();
                obj.setcID(rs.getInt("cid"));
                obj.setcName(rs.getString(2));
                obj.setAddress(rs.getString(3));
                obj.setPhone(rs.getString(4));
                obj.setUserName(rs.getString(5));
                obj.setPassword(rs.getString(6));
                obj.setStatus(rs.getInt(7));
                System.out.println(obj);        
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOKHACHHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Vector getKhachHang(String sql){
        Vector<EnityKhachHang> vector=new Vector<EnityKhachHang>();
        // String sql="select * from khachHang";
        ResultSet rs=dbConn.getData(sql);
        try {
            while(rs.next()){
                EnityKhachHang obj=new EnityKhachHang();
                obj.setcID(rs.getInt("cid"));
                obj.setcName(rs.getString(2));
                obj.setAddress(rs.getString(3));
                obj.setPhone(rs.getString(4));
                obj.setUserName(rs.getString(5));
                obj.setPassword(rs.getString(6));
                obj.setStatus(rs.getInt(7));
                vector.add(obj)      ;
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOKHACHHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        return vector;
    }
    
    
    

    //  
    public int removeKhachHang(int id) {
        int n = 0;
        String sql = "delete KhachHang where cid=" + id;
        //check constrain foreign key
        String sqlcheck = "select * from KhachHang as a inner join HoaDon as b"
                + " on a.cid=b.cid where a.cid=" + id;
        try {
            state = conn.createStatement();
            ResultSet rs = state.executeQuery(sqlcheck);
            //neu co ban ghi nghĩa là khách hàng đã mua hàng và không xóa được
            if (rs.next()) {
                System.out.println("khong xoa duoc");
                //change status
                return n;
            }
            //else

            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return n;
    }
public int changeNewPassword(String userName,String newPass){
        int n=0;
        //check 
        String sql="update KhachHang set password=? where username=?";
        try {
            PreparedStatement pre=conn.prepareStatement(sql);
            pre.setString(1,newPass);
            pre.setString(2,userName);
            n=pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOKHACHHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return n;
    }
public int themhoadon(enity.EnityHoaDon hoadon)
{
    int n=0;
    String sql="insert into HoaDon(hid,date,cid,Rcname,Raddress,Rphone,total) values(?,?,?,?,?,?,?)";
        try {
            PreparedStatement pre=conn.prepareCall(sql);
            pre.setString(1, hoadon.getHoadon());
            pre.setString(2, hoadon.getDate());
            pre.setInt(3,hoadon.getMakh());
            pre.setString(4,hoadon.getHoten());
            pre.setString(5,hoadon.getDiachi());
            pre.setString(6,hoadon.getPhone());
            pre.setInt(7,hoadon.getTongtien());
            n=pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOKHACHHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    return n;
}
public int themchitietHD(enity.EnityHopDong cthd)
{
    int n=0;
        String sql="insert into HoaDonChiTiet values(?,?,?,?)";
        try {
            PreparedStatement pre=conn.prepareCall(sql);
            pre.setString(1, cthd.getHid());
            pre.setString(2, cthd.getSid());
            pre.setInt(3, cthd.getQuantity());
            pre.setInt(4, cthd.getGia());
            n=pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOKHACHHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    return n;
}
public int updatehoadon(String hid,int status)
{
    int n=0;
     String sql="update HoaDon set status=? where hid=?";
    
        try {
            PreparedStatement pre=conn.prepareCall(sql);
            pre.setInt(1, status);
            pre.setString(2,hid);
            n=pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOKHACHHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    return n;
}
public int updateSL(int soluong,String sid)
{
    int n=0;
    String sql="update SanPham set quantity=? where sid=?";
    
        try {
            PreparedStatement pre=conn.prepareCall(sql);
            pre.setInt(1, soluong);
            pre.setString(2, sid);
            n=pre.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DAOKHACHHang.class.getName()).log(Level.SEVERE, null, ex);
        }
    return n;
}
}

