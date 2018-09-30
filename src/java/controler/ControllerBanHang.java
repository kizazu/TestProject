/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DBConnection;
import dao.DAOKHACHHang;
import enity.EnityKhachHang;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import enity.EnitySanPham;
import java.util.ArrayList;
import javax.servlet.ServletContext;
/**
 *
 * @author Bui Thanh Tung
 */
public class ControllerBanHang extends HttpServlet {

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
            ServletContext context=this.getServletContext();
            /* TODO output your page here. You may use following sample code. */
            DBConnection dbcon=new DBConnection(context.getInitParameter("url"),context.getInitParameter("user"),context.getInitParameter("pass"));
            HttpSession session=request.getSession();
            String servlet=request.getParameter("service");
            RequestDispatcher rd = null;
            DAOKHACHHang dao=new DAOKHACHHang(dbcon);
            if(servlet==null)
            {
                servlet="";
            }
            if(servlet.equals("logout"))
            {
              
                disparth(request, response, "login.jsp");
            }
            if(servlet.equals("QuanLyKhachHang"))
            {
                String sql="select *from KhachHang";
                ResultSet rs=dbcon.getData(sql);
                Vector<EnityKhachHang> vector=new Vector<>();
                while(rs.next())
                {
                    EnityKhachHang khachHang=new EnityKhachHang(rs.getInt("cid"), rs.getString("cname"),rs.getString("address"), rs.getString("phone"), rs.getString("username"),rs.getInt("status"));
                    vector.add(khachHang);
                    
                }
                request.setAttribute("vector", vector);
                disparth(request, response, "/QuanLyKhachHang.jsp");
            }
            if(servlet.equals("login"))
            {
                String username=request.getParameter("username");
                String pass=request.getParameter("pass");
                int n=dao.login(username,pass);
                if(n==1)
                {
                    session.setAttribute("username", username);
                    rd = request.getRequestDispatcher("/Sessionindex.jsp");
                }
                else
                {
                    
                    rd = request.getRequestDispatcher("/login.jsp");
                    
                }
                rd.forward(request, response);
            }
            if(servlet.equals("preUpdate"))
            {
                String id=request.getParameter("cid");
                int cid=Integer.parseInt(id);
                String sql="select *from KhachHang where cid="+cid;
                ResultSet rs=dbcon.getData(sql);
                request.setAttribute("rs", rs);
                disparth(request, response, "/preUpdate.jsp");
            }
            if(servlet.equals("Update"))
            {
                String id=request.getParameter("cid");
                int cid=Integer.parseInt(id);
                String username=request.getParameter("name");
                String diachi=request.getParameter("diachi");
                String phone=request.getParameter("phone");
                String status=request.getParameter("status");
                int d=Integer.parseInt(status);
                enity.EnityKhachHang khachHang=new enity.EnityKhachHang(cid,username,diachi,phone,d);
                dao.updateKhachHang(khachHang);
                response.sendRedirect("ControllerBanHang?service=QuanLyKhachHang");
            }
            if(servlet.equals("delete"))
            {
                int cid=Integer.parseInt(request.getParameter("cid"));
                dao.removeKhachHang(cid);
                response.sendRedirect("ControllerBanHang?service=QuanLyKhachHang");
            }
            if(servlet.equals("QuanLySanPham"))
            {
                String sql="select *from SanPham";
                ResultSet rs=dbcon.getData(sql);
                Vector<EnitySanPham> vector=new Vector<>();
                while(rs.next())
                {
                    EnitySanPham sanPham=new EnitySanPham(rs.getString("sid"), rs.getString("sname"),rs.getInt("quantity"), rs.getInt("price"), rs.getString("picture"),rs.getString("description"),rs.getInt("status"),rs.getInt("hid"));
                    vector.add(sanPham);
                    
                }
                request.setAttribute("vector", vector);
                disparth(request, response, "/QuanLySanPham.jsp");
            }
            if(servlet.equals("preUpdateProduct"))
            {
                String sid=request.getParameter("sid");
            
                String sl=request.getParameter("soluong");
                int soluong=Integer.parseInt(sl);
                String sql="select *from SanPham where sid='"+sid+"'";
                   ResultSet rs=dbcon.getData(sql);
                       request.setAttribute("rs", rs);
                       request.setAttribute("soluong", soluong);
                     disparth(request, response, "/preUpdateProduct.jsp");
            }   
            if(servlet.equals("UpdatePro123"))
            {
                
                int dem=1;
           
                String[] array=request.getParameterValues("quantity");
                session.setAttribute("somathang", array);
                java.util.Enumeration em = session.getAttributeNames();
                
                    while(em.hasMoreElements()){
                    
                    //get value from session object (see HttpSession)
                     for(int i=0;i<array.length;i++)
                        {
                            String id= em.nextElement().toString();
                            if(id!="username"&&id!="rstongtien"&&id!="somathang"&&id!="mahd")
                            {
                            EnitySanPham sp=(EnitySanPham) session.getAttribute(id);
                                sp.setSoluong(Integer.parseInt(array[i]));
                              
                            }
                        } 
                     }
              
                   disparth(request, response, "/showaddtocart.jsp");
               
            }
            if(servlet.equals("Addtocart"))
            {
                String sid=request.getParameter("sid");
                request.setAttribute(sid, sid);
                 EnitySanPham value =(EnitySanPham) session.getAttribute(sid);
                 if(value==null){
		//put name-value pair into session object (see HttpSession)
                String sql="select * from SanPham where sid='"+sid+"'";
                    ResultSet rs=dbcon.getData(sql);
                    while(rs.next())
                        {
                    
                EnitySanPham sanPham = new EnitySanPham(rs.getString("sid"), rs.getString("sname"),1, rs.getInt("price"), rs.getString("picture"),rs.getString("description"),rs.getInt("status"),rs.getInt("hid"));
                        session.setAttribute(sid, sanPham);
                        }
                }
            else
            {
                int soLuong= value.getSoluong()+1;
                  String sql="select * from SanPham where sid='"+sid+"'";
                    ResultSet rs=dbcon.getData(sql);
                    while(rs.next())
                        {
                    
                EnitySanPham sanPham = new EnitySanPham(rs.getString("sid"), rs.getString("sname"),soLuong, rs.getInt("price"), rs.getString("picture"),rs.getString("description"),rs.getInt("status"),rs.getInt("hid"));
                        session.setAttribute(sid, sanPham);
                        }
                    
            }
                
                disparth(request, response, "/showaddtocart.jsp");
                
                
            }
            if(servlet.equals("CreateHoaDon"))
            {
                int tongtien=Integer.parseInt(request.getParameter("tongtien"));
                String username=(String)session.getAttribute("username");
                String sql="select *from KhachHang where username='"+username+"'";
                ResultSet rs=dbcon.getData(sql);
                request.setAttribute("rshoadon", rs);
                request.setAttribute("tongtien", tongtien);
                disparth(request, response, "/createhoadon.jsp");
                
            }
            if(servlet.equals("createhoadon123"))
            {
                int dem=0;
                String sql="select count(*) as N'Tong' from HoaDon";
                ResultSet rs=dbcon.getData(sql);
                if(rs.next())
                {
                    dem=rs.getInt("Tong")+1;
                }
                int makh=Integer.parseInt(request.getParameter("makh"));
                String mahd="H"+dem;
                session.setAttribute("mahd", mahd);
                String ngaythang=request.getParameter("date");
                String tenkh=request.getParameter("ten");
                String diachi=request.getParameter("diachi");
                String phone=request.getParameter("phone");
                int tongtien=Integer.parseInt(request.getParameter("tongtien"));
               enity.EnityHoaDon hoadon=new enity.EnityHoaDon(mahd, ngaythang, makh, tenkh, diachi, phone, tongtien);
                    int n=dao.themhoadon(hoadon);
                    if(n==1)
                    {
                         response.sendRedirect("ControllerBanHang?service=ThemChiTiet");
                    }
                else
                    {
                        out.print("chưa thêm");
                    }
               
                
            }
            if(servlet.equals("ThemChiTiet"))
            {
                String mahd=(String)session.getAttribute("mahd");
                
                java.util.Enumeration em=session.getAttributeNames();
                while(em.hasMoreElements())
                {
                    String id= em.nextElement().toString();
                    if(id!="username"&&id!="rstongtien"&&id!="somathang"&&id!="mahd")
                    {
		
                   EnitySanPham sp=(EnitySanPham) session.getAttribute(id);
                      String masp=sp.getSid();
                      int soluong=sp.getSoluong();
                      int price=sp.getGia();
                      enity.EnityHopDong cthd=new enity.EnityHopDong(mahd,masp, soluong, price);
                      int check=dao.themchitietHD(cthd);
                        
                }
                }
                out.print("bạn đã mua thành công");
            }
            if(servlet.equals("logout"))
            {
                session.invalidate();
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(ControllerBanHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    protected void disparth(HttpServletRequest request, HttpServletResponse response,String url)
            throws ServletException, IOException {
                RequestDispatcher rd=getServletContext().getRequestDispatcher(url);
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
