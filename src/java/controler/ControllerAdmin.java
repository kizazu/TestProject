/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import dao.DAOKHACHHang;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DBConnection;

/**
 *
 * @author Bui Thanh Tung
 */
public class ControllerAdmin extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String service=request.getParameter("service");
            ServletContext context=this.getServletContext();
            /* TODO output your page here. You may use following sample code. */
            DBConnection dBCon=new DBConnection(context.getInitParameter("url"),context.getInitParameter("user"),context.getInitParameter("pass"));
            dao.DAOKHACHHang dao=new DAOKHACHHang(dBCon);
  
            if(service.equals(""))
            {
                service="";
            }
            if(service.equals("loginAdmin"))
            {
                String username=request.getParameter("username");
                String pass=request.getParameter("pass");
                out.print(username+" "+pass);
                int n=dao.loginadmin(username, pass);
                if(n==1)
                {
                    disparth(request, response, "/menu.jsp");
                }
                else
                {
                    disparth(request, response, "/loginAdmin.jsp");
                }
            }
            if(service.equals("DSHoaDonChuaXuLy"))
            {
                String sql="select *from HoaDon where status=0";
                ResultSet rs=dBCon.getData(sql);
                Vector<enity.EnityHoaDon> vector=new Vector<enity.EnityHoaDon>();
                while(rs.next())
                {
                  enity.EnityHoaDon hoadon=new enity.EnityHoaDon(rs.getString("hid"), rs.getString("date"),rs.getInt("cid"), rs.getString("Rcname"), rs.getString("Raddress"), rs.getString("Rphone"), rs.getInt("total"), rs.getInt("status"));   
                  vector.add(hoadon);
                }
                request.setAttribute("dschuaxuly", vector);
                disparth(request, response, "/DSchuaxuly.jsp");
            }
            if(service.equals("HoaDonChiTiet"))
            {
                String hid=request.getParameter("hid");
                String sql="select hid,Rcname,cname,HoaDon.status from HoaDon inner join KhachHang on HoaDon.cid=KhachHang.cid where hid='"+hid+"'";
                ResultSet rs=dBCon.getData(sql);
                request.setAttribute("hoadon", rs);
                String sql1="select sname,HoaDonChiTiet.quantity,HoaDonChiTiet.price from HoaDonChiTiet inner join SanPham on HoaDonChiTiet.sid=SanPham.sid where HoaDonChiTiet.hid='"+hid+"'";
                ResultSet rs1=dBCon.getData(sql1);
                request.setAttribute("hoadonchitiet", rs1);
                disparth(request, response, "/HoaDonChiTiet.jsp");
            }
            
            
            
            
            
            
            if(service.equals("UpdateHoaDon"))
            {
               
                int dem=0;
                String hid=request.getParameter("hid");
                int status =Integer.parseInt(request.getParameter("status"));
                if(status==1){
                ResultSet rs=dBCon.getData("select *from HoaDonChiTiet where hid='"+hid+"'");
                while(rs.next())
                {
                    int quantitySP=0;
                    int quantity=0;
                    quantity=rs.getInt("quantity");
                    String sid=rs.getString("sid");
                    ResultSet rs1=dBCon.getData("select quantity from SanPham where sid='"+sid+"'");
                    if(rs1.next())
                    {
                        quantitySP=rs1.getInt("quantity");
                    }
                    if(quantity>quantitySP)
                    {
                        dem++;
                    }
                    
                }
               
                if(dem==0)
                {
                    
                   ResultSet rs1=dBCon.getData("select *from HoaDonChiTiet where hid='"+hid+"'");
                   while(rs1.next())
                   {
                      int quantity=0;int quantitySP=0;
                         quantity =rs1.getInt("quantity");
                      String sid=rs1.getString("sid");
                       ResultSet rs2=dBCon.getData("select quantity from SanPham where sid='"+sid+"'");
                            if(rs2.next())
                            {       
                            quantitySP=rs2.getInt("quantity");
                            }
                        int soluong=quantitySP-quantity;
                        int n=dao.updateSL(soluong, sid);
                   }
                }
                 int n1=dao.updatehoadon(hid, status);
                       out.print("update thành công");
                  /*if(dem==0)
                  {
                      ResultSet rs1=dBCon.getData("select *from HoaDonChiTiet where hid='"+hid+"'");
                      while(rs1.next())
                      {
                          int quantitySP=0;
                          int quantity=0;
                             quantity=rs.getInt("quantity");
                             String sid=rs.getString("sid");
                            out.print(quantity+" "+sid);
                            
                           /* ResultSet rs1=dBCon.getData("select quantity from SanPham where sid='"+sid+"'");
                            if(rs1.next())
                            {       
                            quantitySP=rs1.getInt("quantity");
                            }
                            int soluong=quantitySP-quantity;
                         out.print(soluong);
                             
                      }
                  }
                
           */     
                }
        
            }
            
            if(service.equals("DSHoaDonDangXuLy"))
            {
               String sql="select *from HoaDon where status=1";
                ResultSet rs=dBCon.getData(sql);
                request.setAttribute("danhsach", rs);
                disparth(request, response, "/DSdangxuly.jsp");
            }
            if(service.equals("HoaDon"))
            {
                String sql="select *from HoaDon";
                ResultSet rs=dBCon.getData(sql);
                request.setAttribute("danhsach", rs);
                disparth(request, response, "/danhsach.jsp");
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControllerAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    protected void disparth(HttpServletRequest request, HttpServletResponse response,String url)
            throws ServletException, IOException {
                RequestDispatcher rd=request.getRequestDispatcher(url);
                rd.forward(request, response);
        
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
