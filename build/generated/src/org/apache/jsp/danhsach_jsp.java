package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;

public final class danhsach_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("           ");

            ResultSet rs=(ResultSet) request.getAttribute("danhsach");
            int dem=0;
            
      out.write("\n");
      out.write("        \n");
      out.write("        <form action=\"ControllerAdmin\" method=\"post\">\n");
      out.write("            <table border=\"1\">\n");
      out.write("                <thead>\n");
      out.write("                <td>STT</td>\n");
      out.write("                <td>Mã HD</td>    \n");
      out.write("                <td>Tên Khách Hàng</td>\n");
      out.write("                <td>Ngày mua</td>\n");
      out.write("                <td>Trạng thái</td>\n");
      out.write("                <td>Xóa</td>\n");
      out.write("                </thead>\n");
      out.write("                <tbody>\n");
      out.write("             ");
 while(rs.next()){ 
                 dem++;
                 if(rs.getInt("status")==0 || rs.getInt("status")==3)
                 {
             
      out.write("      \n");
      out.write("                    <tr>\n");
      out.write("                        <td>");
      out.print( dem );
      out.write("</td>\n");
      out.write("                        <td><a href=\"ControllerAdmin?service=HoaDonChiTiet&&hid=");
      out.print( rs.getString("hid") );
      out.write('"');
      out.write('>');
      out.print( rs.getString("hid") );
      out.write("</a></td>\n");
      out.write("                        <td>");
      out.print(  rs.getString("Rcname")  );
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(  rs.getDate("date")    );
      out.write("</td>\n");
      out.write("                        <td>\n");
      out.write("                            <select name=\"status\">\n");
      out.write("                                <option value=\"0\" ");
      out.print( rs.getInt("status")==0?"selected":"");
      out.write(">1</option>\n");
      out.write("                                <option value=\"1\" ");
      out.print( rs.getInt("status")==1?"selected":"");
      out.write(">2</option>\n");
      out.write("                                <option value=\"2\" ");
      out.print( rs.getInt("status")==2?"selected":"");
      out.write(">3</option>\n");
      out.write("                                <option value=\"3\" ");
      out.print( rs.getInt("status")==3?"selected":"");
      out.write(">4</option>\n");
      out.write("                            </select>\n");
      out.write("                            \n");
      out.write("                        </td>\n");
      out.write("                        <td><a href=\"ControllerAdmin?service=XoaHoaDon&&hid=");
      out.print( rs.getString("hid")  );
      out.write("\">Xóa</a></td>\n");
      out.write("                    \n");
      out.write("                    </tr>\n");
      out.write("                 ");
}else{
      out.write("\n");
      out.write("                 <tr>\n");
      out.write("                        <td>");
      out.print( dem );
      out.write("</td>\n");
      out.write("                        <td><a href=\"ControllerAdmin?service=HoaDonChiTiet&&hid=");
      out.print( rs.getString("hid") );
      out.write('"');
      out.write('>');
      out.print( rs.getString("hid") );
      out.write("</a></td>\n");
      out.write("                        <td>");
      out.print(  rs.getString("Rcname")  );
      out.write("</td>\n");
      out.write("                        <td>");
      out.print(  rs.getDate("date")    );
      out.write("</td>\n");
      out.write("                        <td>\n");
      out.write("                             <select name=\"status\">\n");
      out.write("                                <option value=\"0\" ");
      out.print( rs.getInt("status")==0?"selected":"");
      out.write(">1</option>\n");
      out.write("                                <option value=\"1\" ");
      out.print( rs.getInt("status")==0?"selected":"");
      out.write(">2</option>\n");
      out.write("                                <option value=\"2\" ");
      out.print( rs.getInt("status")==0?"selected":"");
      out.write(">3</option>\n");
      out.write("                                <option value=\"3\" ");
      out.print( rs.getInt("status")==0?"selected":"");
      out.write(">4</option>\n");
      out.write("                            </select>\n");
      out.write("                        </td>\n");
      out.write("                        <td></td>\n");
      out.write("                    \n");
      out.write("                    </tr>\n");
      out.write("                 ");
}}
      out.write("\n");
      out.write("                </tbody>\n");
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
