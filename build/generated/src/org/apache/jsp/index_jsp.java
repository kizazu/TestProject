package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import model.DBConnection;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
  
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
           
      out.write("\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        <h1> Thanh Tung Store </h1>\n");
      out.write("        \n");
      out.write("        \n");
      out.write("     \n");
      out.write("        <form action=\"#\" method=\"post\">\n");
      out.write("            <h1> Welcome ");
      out.print( request.getAttribute("username")  );
      out.write(" </h1> \n");
      out.write("                <select name=\"hsx\" >\n");
      out.write("                <option value=\"-1\"> All </option>\n");
      out.write("                ");
 while(rs.next()){ 
      out.write("\n");
      out.write("                <option value=\"");
      out.print( rs.getInt("hid") );
      out.write('"');
      out.print(rs.getString("hid").equalsIgnoreCase(hsx)?"selected":"");
      out.write(">\n");
      out.write("                    ");
      out.print(rs.getString("hname") );
      out.write("\n");
      out.write("                </option>\n");
      out.write("                ");
 }
      out.write("\n");
      out.write("            </select>\n");
      out.write("                <p> Tên Sản Phẩm <input type=\"text\" name=\"ten\"/>\n");
      out.write("\n");
      out.write("                <p> Giá từ: <input type=\"number\"  name=\"giabe\"/>\n");
      out.write("               <p> Giá đến: <input type=\"number\"  name=\"gialon\"/>\n");
      out.write("                   \n");
      out.write("                   <input  type=\"submit\" value=\"ok\">\n");
      out.write("        </form>\n");
      out.write("            <table border=\"1\">\n");
      out.write("                <thead>\n");
      out.write("                    <tr>\n");
      out.write("                    <th>Tên Hãng</th>\n");
      out.write("                    <th>Tên Sản Phẩm</th> \n");
      out.write("                    <th>Ảnh</th>\n");
      out.write("                    <th>Số Lượng</th>\n");
      out.write("                    <th>Giá</th>\n");
      out.write("                    <th>Mô Tả</th>\n");
      out.write("                    <th>Trạng Thái</th>\n");
      out.write("                    <tr/>\n");
      out.write("                </thead>\n");
      out.write("                <tbody>\n");
      out.write("                ");
 while(rs1.next()){ 
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td> ");
      out.print( rs1.getString("hname") );
      out.write("   </td>\n");
      out.write("                    <td> ");
      out.print( rs1.getString("sname") );
      out.write("   </td>\n");
      out.write("                    <td> <img width=\"50px\" src=\"");
      out.print( rs1.getString("picture") );
      out.write("\"/>   </td>\n");
      out.write("                    <td> ");
      out.print( rs1.getInt("quantity") );
      out.write("   </td>\n");
      out.write("                    <td> ");
      out.print( rs1.getInt("price") );
      out.write("   </td>\n");
      out.write("                    <td> ");
      out.print( rs1.getString("description") );
      out.write("   </td>\n");
      out.write("                    <td> ");
      out.print( (rs1.getInt("status")==1?"Đang bán":"Ngừng Bán") );
      out.write("   </td>\n");
      out.write("                \n");
      out.write("                </tr>\n");
      out.write("                ");
}
      out.write("\n");
      out.write("                </tbody>\n");
      out.write("            </table>\n");
      out.write("    </body>\n");
      out.write("    \n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
