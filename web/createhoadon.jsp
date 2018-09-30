<%-- 
    Document   : createhoadon
    Created on : Aug 28, 2018, 8:41:44 PM
    Author     : Bui Thanh Tung
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.sql.ResultSet"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
       
    </head>
    <body>
     <%
        ResultSet rs=(ResultSet)request.getAttribute("rshoadon");
        Date date=new Date();
        SimpleDateFormat ft = new SimpleDateFormat ("MM/dd/yyyy");
        String date1=ft.format(date);
    %>
        <form action="ControllerBanHang" method="post">
           
        <% if(rs.next()){ %>
        Ngày/ tháng/ năm: <input type="date" name="date" value="<%= date1 %>"/><br>
        Tên khách hàng: <input type="text" name="ten" value="<%= rs.getString("cname")   %>"/><br>
        Địa chỉ khách hàng: <input type="text" name="diachi" value="<%= rs.getString("address") %>"/><br>
        Điện thoại khách hàng: <input type="number" name="phone" value="<%=rs.getString("phone") %>" /><br>
        Tổng tiền: <input type="text" name="tongtien" value="<%= (int)request.getAttribute("tongtien") %>" readonly/><br>
        <input type="hidden" name="makh" value="<%= rs.getInt("cid")  %>"/>
        <%}%>
        <input type="submit" value="OK"/>  <input type="Reset" value="Reset"/>
        <input type="hidden" name="service" value="createhoadon123"/>
        </form>
    </body>
</html>
