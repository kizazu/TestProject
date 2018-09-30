<%-- 
    Document   : QuanLyAdmin
    Created on : Aug 2, 2018, 8:34:09 PM
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
           ResultSet rs=(ResultSet) request.getAttribute("rs");
           
       %>
       <form>
           <table border="1">
               <caption>List Admin </caption>
               <thead>
                   <tr>
                       <th>UserName</th>
                       <th>Status</th>
                       <th>Update</th>
                       <th>Delete</th>
                   </tr>                  
               </thead>
               <tbody>
                   <% while(rs.next()){  %>
                   <tr>
                       <td><%= rs.getString("username") %> </td>
                       <td><%= rs.getString("password") %> </td>
                       <td><a href="ControllerAdmin?service=preUpdate&username=<%= rs.getString("username") %>">Update </a></td>
                       <td><a href="ControllerAdmin?service=delete&username=<%= rs.getString("username") %>">Delete </a></td>
                   </tr>
                   <%}%>
               </tbody>
           </table>
       </form>
    </body>
</html>
