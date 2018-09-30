<%-- 
    Document   : Sessionindex
    Created on : Aug 9, 2018, 6:45:14 PM
    Author     : Bui Thanh Tung
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        Wellcome <%= session.getAttribute("username") %> <p>
        <a href="ControllerBanHang?service=QuanLySanPham"> List Hang </a><p>
            <a href="ControllerBanHang?service=logout">Log out</a>
    </body>
</html>
