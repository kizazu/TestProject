<%-- 
    Document   : loginAdmin
    Created on : Sep 4, 2018, 10:03:28 AM
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
        <form action="ControllerAdmin" method="post"/>
        <h1>Quản lý Admin</h1><br>
        Username: <input type="text" name="username"/><br>
        Pass: <input type="password" name="pass"/></br>
        <input type="submit" value="Login"/><input type="reset" value="Reset"/>
        <input type="hidden" name="service" value="loginAdmin"/>
    </form>
    </body>
</html>
