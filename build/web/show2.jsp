<%-- 
    Document   : show2
    Created on : Aug 22, 2018, 7:31:32 AM
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
        <%
            Object a=request.getAttribute("soluong123");
        int[]arr=(int[])a;
            for(int i=0;i<arr.length;i++)
            {
              %>
              
              <input type="text" value="<%= arr[i] %>"/>
              
              
              
              <%}%>
    </body>
    
    
    
    
    
</html>
