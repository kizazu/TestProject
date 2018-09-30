package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Vector;
import java.util.Vector;
import enity.EnityKhachHang;

public final class Sessionindex_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        Wellcome:  ");
      out.print( request.getAttribute("username") );
      out.write("\n");
      out.write("        Logout: \n");
      out.write("         ");
 
            Vector<enity.EnityKhachHang> vector=(Vector<EnityKhachHang>)  request.getAttribute("vector");
        
      out.write("\n");
      out.write("        <h1> Quản Lý Khách Hàng </h1>\n");
      out.write("        <form action=\"ControllerBanHang\" method=\"post\"/>\n");
      out.write("        <table border=\"1\">\n");
      out.write("                <thead>\n");
      out.write("                    <tr>\n");
      out.write("                    <th>Mã Khách Hàng</th>\n");
      out.write("                    <th>Tên Khách Hàng</th> \n");
      out.write("                    <th>Địa Chỉ</th>\n");
      out.write("                    <th>Số Điện Thoại</th>\n");
      out.write("                    <th>UserName</th>\n");
      out.write("                    <th>Status</th>\n");
      out.write("                    <th>Update</th>\n");
      out.write("                    <th>Delete</th>\n");
      out.write("                    <tr/>\n");
      out.write("                </thead>\n");
      out.write("                <tbody>\n");
      out.write("                    ");
 for(EnityKhachHang kh:vector){ 
      out.write("\n");
      out.write("                <tr>\n");
      out.write("                    <td> ");
      out.print( kh.getcID() );
      out.write("   </td>\n");
      out.write("                    <td> ");
      out.print( kh.getcName() );
      out.write("   </td>\n");
      out.write("                    <td> ");
      out.print( kh.getAddress() );
      out.write("   </td>\n");
      out.write("                    <td> ");
      out.print( kh.getPhone() );
      out.write("   </td>\n");
      out.write("                    <td> ");
      out.print( kh.getUserName() );
      out.write("   </td>\n");
      out.write("                    <td> ");
      out.print( (kh.getStatus()==1?"Active":"Disactive") );
      out.write("  </td>\n");
      out.write("                    <td> <a href=\"ControllerBanHang?service=preUpdate&cid=");
      out.print( kh.getcID());
      out.write("\">update</a>   </td>\n");
      out.write("                    <td> <a href=\"ControllerBanHang?service=delete&cid=");
      out.print( kh.getcID() );
      out.write("\"onclick=\"return confirm('Ban co chac chan xoa khong')\">delete</a>  </td>\n");
      out.write("                \n");
      out.write("                </tr>\n");
      out.write("                ");
}
      out.write("\n");
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
