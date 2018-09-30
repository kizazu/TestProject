package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import model.DBConnection;

public final class preUpdate_jsp extends org.apache.jasper.runtime.HttpJspBase
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

          ResultSet rs=(ResultSet)request.getAttribute("rs");
          if(rs.next()){
        
      out.write("\n");
      out.write("        <form action=\"ControllerBanHang\" method=\"post\">\n");
      out.write("            \n");
      out.write("            <table style=\"border: 1px solid black;margin: auto\">\n");
      out.write("                 <tr>\n");
      out.write("                    <td>  Mã Khách Hàng </td>\n");
      out.write("                    <td>  <input type=\"text\" name=\"cid\" value=\"");
      out.print(rs.getInt("cid") );
      out.write("\" readonly/> </td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>  Tên khách hàng </td>\n");
      out.write("                    <td>  <input type=\"text\" name=\"name\" value=\"");
      out.print(rs.getString("cname") );
      out.write("\"/> </td>\n");
      out.write("                </tr>\n");
      out.write("               <tr> \n");
      out.write("                   <td> Địa chỉ </td>\n");
      out.write("                   <td> <input type=\"text\" name=\"diachi\" value=\"");
      out.print( rs.getString("address")  );
      out.write("\"/> </td>\n");
      out.write("               </tr>\n");
      out.write("               <tr> \n");
      out.write("                   <td>Phone</td>\n");
      out.write("                   <td> <input type=\"text\" name=\"phone\" value=\"");
      out.print( rs.getString("phone")  );
      out.write("\"/></td>\n");
      out.write("               </tr>\n");
      out.write("               <tr>\n");
      out.write("                   <td> Username </td>\n");
      out.write("                   <td><input type=\"text\" name=\"username\" value=\"");
      out.print( rs.getString("username")  );
      out.write(" \"readonly/></td>\n");
      out.write("               </tr>\n");
      out.write("               <tr>\n");
      out.write("                   <td>Status </td>\n");
      out.write("                   <td><input type=\"radio\" name=\"status\" value=\"1\" ");
      out.print( rs.getInt("status")==1?"checked":""  );
      out.write(" />Active\n");
      out.write("                   <input type=\"radio\" name=\"status\" value=\"0\" ");
      out.print( rs.getInt("status")==0?"checked":""  );
      out.write("/>Disactive </td>\n");
      out.write("               </tr>\n");
      out.write("               <tr>\n");
      out.write("                   <td> <input type=\"submit\" value=\"Update\"/>   <input style=\"margin-left: 30px\" type=\"reset\" value=\"Reset\"/><tr></td>\n");
      out.write("                   </tr>\n");
      out.write("               <input type=\"hidden\" name=\"service\" value=\"Update\"/>\n");
      out.write("            </table>\n");
      out.write("                 \n");
      out.write("        </form>\n");
      out.write("        ");
}
      out.write("\n");
      out.write("        \n");
      out.write("    </body>\n");
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
