<%-- 
    Document   : DSdangxuly
    Created on : Sep 4, 2018, 8:57:55 PM
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
            ResultSet rs=(ResultSet) request.getAttribute("danhsach");
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
             <% while(rs.next()){ 
                 dem++;
             %>      
                    <tr>
                        <td><%= dem %></td>
                        <td><a href="ControllerAdmin?service=HoaDonChiTiet&&hid=<%= rs.getString("hid") %>"><%= rs.getString("hid") %></a></td>
                        <td><%=  rs.getString("Rcname")  %></td>
                        <td><%=  rs.getDate("date")    %></td>
                        <td><%=  rs.getInt("status")  %></td>
                        <td>Xoa</td>
                    
                    </tr>
                    
                    
                 <%}%>
                </tbody>
            </table>
        </form>
    </body>
</html>
