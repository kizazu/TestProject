package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index2_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("     <style>\n");
      out.write("           #menu ul\n");
      out.write("           {\n");
      out.write("               list-style-type: none;\n");
      out.write("               text-align: center;\n");
      out.write("               background-color: blue;\n");
      out.write("              \n");
      out.write("           }\n");
      out.write("           #menu li\n");
      out.write("           {\n");
      out.write("              display: inline-block;\n");
      out.write("              width: 120px;\n");
      out.write("              height: 40px;\n");
      out.write("              line-height: 40px;\n");
      out.write("              margin-left: 50px;\n");
      out.write(" \n");
      out.write("           }\n");
      out.write("           #menu a\n");
      out.write("           {\n");
      out.write("               text-decoration: none;\n");
      out.write("               display: block;\n");
      out.write("               color:white;\n");
      out.write("           }\n");
      out.write("           #menu a:hover\n");
      out.write("           {\n");
      out.write("               background:yellow;\n");
      out.write("           }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    \n");
      out.write("    <body>\n");
      out.write("       \n");
      out.write("                <div id=\"menu\" >\n");
      out.write("                    <ul>\n");
      out.write("                        <li><a href=\"ControllerBanHang?service=QuanLyKhachHang\"> Khách Hàng </a> </li>\n");
      out.write("                        <li><a href=\"ControllerAdmin?service=Admin\"> Admin </a> </li>\n");
      out.write("                        <li><a href=\"NewServlet?service=HangSanXuat\"> Hãng Sản Xuất </a> </li>\n");
      out.write("                        <li><a href=\"NewServlet?service=SanPham\"> Sản Phẩm </a> </li>\n");
      out.write("                        <li><a href=\"NewServlet?service=HoaDon\"> Hóa Đơn </a> </li>\n");
      out.write("                        <li><a href=\"NewServlet?service=HoaDonChiTiet\"> Hóa Đơn Chi Tiết </a> </li>\n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("            <div style=\"width: 100%;height: 500px; background-color: red;margin-top: -16px\">\n");
      out.write("                <img style=\"width:100%; height: 500px\" src=\"file:///E|/HocTap/Javasript/123.jpg\"/>\n");
      out.write("            </div>\n");
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
