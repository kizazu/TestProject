package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;

public final class createhoadon_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    ");

        ResultSet rs=(ResultSet)request.getAttribute("rshoadon");
        int tong=(int) request.getAttribute("rstongtien");
    
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("       \n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <form action=\"ControllerBanHang\" method=\"post\">\n");
      out.write("        ");
 while(rs.next()){ 
      out.write("\n");
      out.write("        Ngày/ tháng/ năm: <input type=\"date\" name=\"date\"/><br>\n");
      out.write("        Tên khách hàng: <input type=\"text\" name=\"ten\"/><br>\n");
      out.write("        Địa chỉ khách hàng: <input type=\"text\" name=\"diachi\"/><br>\n");
      out.write("        Điện thoại khách hàng: <input type=\"number\" name=\"phone\" /><br>\n");
      out.write("        Tổng tiền: <input type=\"number\" name=\"tongtien\" value=\"");
      out.print( tong );
      out.write("\" readonly/><br>\n");
      out.write("        <input type=\"submit\" value=\"OK\"/>  <input type=\"Reset\" value=\"Reset\"/>\n");
      out.write("        <input type=\"hidden\" name=\"service\" value=\"createhoadon123\"/>\n");
      out.write("        ");
}
      out.write("\n");
      out.write("        </form>\n");
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
