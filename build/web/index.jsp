<%-- 
    Document   : index
    Created on : Jul 27, 2018, 9:18:56 PM
    Author     : Bui Thanh Tung
--%>

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
           DBConnection dbcon=new DBConnection();
           String hsx=request.getParameter("hsx");
           String ten=request.getParameter("ten");
           String giabe1=request.getParameter("giabe");
           
           String gialon1=request.getParameter("gialon");

            String sql="";
            String sql1="";
              if(hsx==null||hsx.isEmpty())
              {
                  hsx="-1";
              }
              if(hsx.equals("-1"))
              {
                sql="select *from HangSanXuat";
                sql1="select *from SanPham inner join HangSanXuat on SanPham.hid=HangSanXuat.hid";
              }
              else
              {
                  sql="select *from HangSanXuat";
                  sql1="select *from SanPham inner join HangSanXuat on SanPham.hid=HangSanXuat.hid where SanPham.sname='"+ten+"' and"
                  + " SanPham.hid="+Integer.parseInt(hsx)+" and SanPham.price between "+Double.parseDouble(giabe1)+" and "+Double.parseDouble(gialon1)+"";
              }
            
                ResultSet rs=dbcon.getData(sql);
                ResultSet rs1=dbcon.getData(sql1);
           %>
        
        
        
        
        <h1> Thanh Tung Store </h1>
        
        
     
        <form action="#" method="post">
            <h1> Welcome <%= request.getAttribute("username")  %> </h1> 
                <select name="hsx" >
                <option value="-1"> All </option>
                <% while(rs.next()){ %>
                <option value="<%= rs.getInt("hid") %>"<%=rs.getString("hid").equalsIgnoreCase(hsx)?"selected":""%>>
                    <%=rs.getString("hname") %>
                </option>
                <% }%>
            </select>
                <p> Tên Sản Phẩm <input type="text" name="ten"/>

                <p> Giá từ: <input type="number"  name="giabe"/>
               <p> Giá đến: <input type="number"  name="gialon"/>
                   
                   <input  type="submit" value="ok">
        </form>
            <table border="1">
                <thead>
                    <tr>
                    <th>Tên Hãng</th>
                    <th>Tên Sản Phẩm</th> 
                    <th>Ảnh</th>
                    <th>Số Lượng</th>
                    <th>Giá</th>
                    <th>Mô Tả</th>
                    <th>Trạng Thái</th>
                    <tr/>
                </thead>
                <tbody>
                <% while(rs1.next()){ %>
                <tr>
                    <td> <%= rs1.getString("hname") %>   </td>
                    <td> <%= rs1.getString("sname") %>   </td>
                    <td> <img width="50px" src="<%= rs1.getString("picture") %>"/>   </td>
                    <td> <%= rs1.getInt("quantity") %>   </td>
                    <td> <%= rs1.getInt("price") %>   </td>
                    <td> <%= rs1.getString("description") %>   </td>
                    <td> <%= (rs1.getInt("status")==1?"Đang bán":"Ngừng Bán") %>   </td>
                
                </tr>
                <%}%>
                </tbody>
            </table>
    </body>
    
</html>
