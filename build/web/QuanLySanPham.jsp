<%-- 
    Document   : QuanLyKhachHang
    Created on : Jul 31, 2018, 8:22:38 PM
    Author     : Bui Thanh Tung
--%>

<%@page import="enity.EnitySanPham"%>
<%@page import="enity.EnityKhachHang"%>
<%@page import="java.util.Vector"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="model.DBConnection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <% 
            Vector<enity.EnitySanPham> vector=(Vector<EnitySanPham>)  request.getAttribute("vector");
        %>
        <h1> Quản Lý Khách Hàng </h1>
        <form action="ControllerBanHang" method="post">
        <table border="1">
                <thead>
                    <tr>
                
                    <th>Tên Sản Phẩm</th> 
                    <th>Số lượng</th>
                    <th>Giá</th>
                    <th>Ảnh</th>
                    <th>Mô tả</th>
                    <th>Tình trạng</th>
         
                    <tr/>
                </thead>
                <tbody>
                    <% for(EnitySanPham sp:vector){ %>
                <tr>
                    <td> <%= sp.getSname() %>   </td>
                    <td> <%= sp.getSoluong() %>   </td>
                    <td> <%= sp.getGia() %>   </td>
                    <td> <img width="30" height="50" src="<%= sp.getPicture()  %>" >   </td>
                    <td> <%= sp.getDacta() %>   </td>
                    <td> <%= (sp.getStatus()==1?"Active":"Disactive") %>  </td>
                    <td> <a href="ControllerBanHang?service=Addtocart&sid=<%= sp.getSid()%>">Mua Hang</a>   </td>
                  
                
                </tr>
                <%}%>
                </tbody>
       
            </table>
                <a href="showaddtocart.jsp"> Show add cart </a>
               
         </form>
        
        
        
        
    </body>
</html>
