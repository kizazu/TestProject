package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Vector;
import enity.EnitySanPham;
import java.sql.ResultSet;
import model.DBConnection;

public final class Addtocart_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            String sid=request.getParameter("sid");  // lay key
            Object value = session.getAttribute(sid); //get key id
            
            if(value==null){
		//put name-value pair into session object (see HttpSession)
		DBConnection dbcon=new DBConnection();
                String sql="select *from SanPham where sid='"+sid+"'";
                ResultSet rs=dbcon.getData(sql);
                 Vector<EnitySanPham> vector=new Vector<>();
                while(rs.next())
                {
                    EnitySanPham sanPham=new EnitySanPham(rs.getString("sid"), rs.getString("sname"),rs.getInt("quantity"), rs.getInt("price"), rs.getString("picture"),rs.getString("description"),rs.getInt("status"),rs.getInt("hid"));
                    //vector.add(sanPham); 
                    session.setAttribute(sid,sanPham);
                    
                }
	}
	//the second/third... time the product is selected
	else{
		DBConnection dbcon=new DBConnection();
                String sql="select *from SanPham where sid='"+sid+"'";
                ResultSet rs=dbcon.getData(sql);
                 Vector<EnitySanPham> vector=new Vector<>();
                while(rs.next())
                {
                    EnitySanPham sanPham=new EnitySanPham(rs.getString("sid"), rs.getString("sname"),rs.getInt("quantity"), rs.getInt("price"), rs.getString("picture"),rs.getString("description"),rs.getInt("status"),rs.getInt("hid"));
                    //vector.add(sanPham); 
                    session.setAttribute(sid,sanPham);
                    
                }
                 
		//put name-value pair into session object (see HttpSession)
		
		
	}	
            
      out.write("\n");
      out.write("       <h1>Item with sid=");
      out.print(sid);
      out.write(" was added to the Shopping Cart</h1>\n");
      out.write("        <h2><a href=\"ControllerBanHang?service=QuanLySanPham\"> List Item</h2>     \n");
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
