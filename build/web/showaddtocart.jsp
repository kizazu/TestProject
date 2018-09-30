<%-- 
    Document   : showaddtocart
    Created on : Aug 9, 2018, 7:13:23 PM
    Author     : Bui Thanh Tung
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="enity.EnitySanPham"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="model.DBConnection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>  
        

<%
           
       java.util.Enumeration em = session.getAttributeNames();
       int tong=0;
        
 %>
       <form action="ControllerBanHang" method="post"/>
        <table border="1">
                <thead>
                    <tr>
                
                    <th>Tên Sản Phẩm</th> 
                    <th>Số lượng</th>
                    <th>Giá</th>
                    <th>Ảnh</th>
                    <th>Mô tả</th>
                    <th>Tình trạng</th>
                    <tr/>
                </thead>
                <tbody>
                    <%
                       
                        
                 while(em.hasMoreElements()){
		String id= em.nextElement().toString();
                    if(id!="username"&&id!="rstongtien"&&id!="somathang"&&id!="mahd")
                    {
		
		//get value from session object (see HttpSession)
		EnitySanPham sp=(EnitySanPham) session.getAttribute(id);
                     
                        %>
                        <tr>
                            <td><%=  sp.getSname()  %>   </td> 
                            <td><input type="number" name="quantity"  value="<%= sp.getSoluong() %>">   </td> 
                            <td><%=  sp.getGia()  %>   </td> 
                            <td> <img width="30" height="50" src="<%=  sp.getPicture() %>"/>   </td> 
                            <td><%=  sp.getDacta()  %>   </td> 
                            <td><%= (sp.getStatus()==1?"Active":"Disactive") %>  </td> 
                            <% tong=tong+sp.getGia()*sp.getSoluong();  %>
                        </tr>            
        <%}}%>  
              </table> 
              <input id="update" type="submit" value="Update"/>
              <input type="hidden" name="service" value="UpdatePro123"/>
              <a href="ControllerBanHang?service=CreateHoaDon&&tongtien=<%= tong %>">Thanh Toán</a>
    </form>
</body>

</html>
