<%-- 
    Document   : login
    Created on : Jul 31, 2018, 7:06:27 PM
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
        <form action="ControllerBanHang" method="post"> 
        <h1> Thanh Tung Store  </h1>
        <p> UserName: <input type="text" name="username" />
        <p> Password: <input type="password" name="pass" />
        <p> <input type="submit" value="OK"/>   <input type="reset" value="Reset"/>
            <input type="hidden" name="service" value="login" />
        </form>
    </body>
</html>
