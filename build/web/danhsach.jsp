<%-- 
    Document   : danhsach
    Created on : Sep 5, 2018, 10:11:37 AM
    Author     : Bui Thanh Tung
--%>

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
                        <td>
                            <select name="status">
                                <option value="0" <%= rs.getInt("status")==0?"selected":""  %>>Chưa xử lý</option>
                                <option value="1" <%= rs.getInt("status")==1?"selected":""  %>>Đang xử lý</option>
                                <option value="2" <%= rs.getInt("status")==2?"selected":""  %>>Đã xử lý</option>
                                <option value="3" <%= rs.getInt("status")==3?"selected":""  %>>Khách Không Nhận</option>
                            </select>
                        </td>
                        <% if(rs.getInt("status")==0||rs.getInt("status")==3){ %> 
                        <td><a href="ControllerAdmin?service=XoaHoaDon&&hid=<%= rs.getString("hid")  %>">Xóa</a></td>
                        <% }else{%>
                        <td></td>
                        <% }%>
                    </tr>
                 <%}%>
                </tbody>
</html>
