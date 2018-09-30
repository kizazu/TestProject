<%-- 
    Document   : HoaDonChiTiet
    Created on : Sep 4, 2018, 7:35:36 PM
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
          ResultSet rs=(ResultSet) request.getAttribute("hoadon");
          ResultSet rs1=(ResultSet) request.getAttribute("hoadonchitiet");
          if(rs.next()){
            %> 
            <form action="ControllerAdmin" method="post">
            <input type="text" name="hid" value="<%= rs.getString("hid")  %>"/>
            Tên Khách Hàng: <input type="text" value="<%= rs.getString("cname")  %>"/><br>
            Tên Người Nhận: <input type="text" value="<%= rs.getString("Rcname")  %>"/><br>
            Trạng thái: <select name="status">
                <option value="0" <%= rs.getInt("status")==0?"selected":""  %>>Chưa Xử Lý</option>
                <option value="1" <%= rs.getInt("status")==1?"selected":""  %>>Đang Xử Lý</option>
                <option value="2" <%= rs.getInt("status")==2?"selected":""  %>>Đã Xử Lý</option>
                <option value="3" <%= rs.getInt("status")==3?"selected":""  %>>Khách Không Nhận</option>
            </select>
                
                <%}%>
                <table border="1">
                    <thead>
                        <tr>
                            <td>Tên sản phẩm</td>
                            <td>Số lượng</td>
                            <td>Giá</td>
                        </tr>
                    </thead>
                    <tbody>
                   <%while(rs1.next()){%>     
                   <tr>
                       <td><%=  rs1.getString("sname")  %></td>
                       <td><%=  rs1.getInt("quantity")  %></td>
                       <td><%=  rs1.getInt("price") %></td>
                   </tr>
                   <%}%>
                    </tbody>
                </table>
                <input type="submit" value="Update"/><input type="reset" value="Reset"/>
                <input type="hidden" name="service" value="UpdateHoaDon"/>
            </form>
    </body>
</html>
