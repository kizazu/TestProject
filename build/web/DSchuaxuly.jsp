<%-- 
    Document   : DSchuaxuly
    Created on : Sep 4, 2018, 6:58:29 PM
    Author     : Bui Thanh Tung
--%>

<%@page import="java.util.Vector"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    
    <body>
        <%
            Vector<enity.EnityHoaDon> vector=(Vector<enity.EnityHoaDon>) request.getAttribute("dschuaxuly");
            int dem=0;
            %>
        
        <form action="ControllerAdmin" method="post">
            <table border="1">
                <thead>
                <td>STT</td>
                <td>Mã HD</td>    
                <td>Tên Khách Hàng</td>
                <td>Ngày mua</td>
                <td>Trạng thái</td>
                <td>Xóa</td>
                </thead>
                <tbody>
             <% for(enity.EnityHoaDon hoadon:vector){ 
                 dem++;
             %>      
                    <tr>
                        <td><%= dem %></td>
                        <td><a href="ControllerAdmin?service=HoaDonChiTiet&&hid=<%= hoadon.getHoadon() %>"><%= hoadon.getHoadon() %></a></td>
                        <td><%=  hoadon.getHoten()   %></td>
                        <td><%=  hoadon.getDate()    %></td>
                        <td><%=  hoadon.getStatus()   %></td>
                        <td>Xoa</td>
                    
                    </tr>
                    
                    
                 <%}%>
                </tbody>
            </table>
        </form>
    </body>
</html>
