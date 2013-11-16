/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.34
 * Generated at: 2013-11-16 09:02:23 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<link type=\"text/css\" rel=\"stylesheet\" href=\"/stylesheets/reset.css\" />\n");
      out.write("<link type=\"text/css\" rel=\"stylesheet\" href=\"/stylesheets/index.css\" />\n");
      out.write("<title>CozyHome</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\t<div class=\"bgImg\"></div>\n");
      out.write("\t<div class=\"interactBox\">\n");
      out.write("\t\t<h1 class=\"title\">\n");
      out.write("\t\t\t<strong>Welcome.</strong> Please login.\n");
      out.write("\t\t</h1>\n");
      out.write("\t\t<p>\n");
      out.write("\t\t\t<span>Cozy Home</span> is waiting for you.\n");
      out.write("\t\t</p>\n");
      out.write("\n");
      out.write("\t\t<div class=\"choiceBlock\">\n");
      out.write("\t\t\t<a href=\"#\" class=\"choice c_login\">LOGIN</a>\n");
      out.write("\t\t\t<a href=\"#\" class=\"choice c_join\">JOIN</a>\n");
      out.write("\t\t\t<span class=\"devider\">OR</span>\n");
      out.write("\t\t</div>\n");
      out.write("\n");
      out.write("\t\t<div class=\"loginArea\">\n");
      out.write("\t\t\t<form action=\"/login\" method=\"post\">\n");
      out.write("\t\t\t\t<p>\n");
      out.write("\t\t\t\t\t<input type=\"text\" name=\"id\" id=\"id\" size=\"10\" placeholder=\"Email\" />\n");
      out.write("\t\t\t\t</p>\n");
      out.write("\t\t\t\t<p>\n");
      out.write("\t\t\t\t\t<input type=\"password\" name=\"pw\" id=\"pw\" size=\"10\"\n");
      out.write("\t\t\t\t\t\tplaceholder=\"Password\" />\n");
      out.write("\t\t\t\t</p>\n");
      out.write("\t\t\t\t<p>\n");
      out.write("\t\t\t\t\t<input type=\"submit\" value=\"Enter House\" />\n");
      out.write("\t\t\t\t</p>\n");
      out.write("\t\t\t</form>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t\n");
      out.write("\t\t<div class=\"joinArea\">\n");
      out.write("\t\t\t<form action=\"/join\" method=\"post\">\n");
      out.write("\t\t\t\t<p>\n");
      out.write("\t\t\t\t\t<input type=\"text\" name=\"rid\" id=\"rid\" size=\"10\" placeholder=\"Email\" />\n");
      out.write("\t\t\t\t</p>\n");
      out.write("\t\t\t\t<p>\n");
      out.write("\t\t\t\t\t<input type=\"text\" name=\"nickname\" size=\"10\" placeholder=\"Nickname\" />\n");
      out.write("\t\t\t\t</p>\n");
      out.write("\t\t\t\t<p>\n");
      out.write("\t\t\t\t\t<input type=\"password\" name=\"rpw\" size=\"10\"\n");
      out.write("\t\t\t\t\t\tplaceholder=\"Password\" />\n");
      out.write("\t\t\t\t</p>\n");
      out.write("\t\t\t\t<p>\n");
      out.write("\t\t\t\t\t<input type=\"password\" name=\"rpwRe\" id=\"rpwRe\" size=\"10\"\n");
      out.write("\t\t\t\t\t\tplaceholder=\"Password Confirm\" />\n");
      out.write("\t\t\t\t</p>\n");
      out.write("\t\t\t\t<p>\n");
      out.write("\t\t\t\t\t<input type=\"submit\" value=\"Create own Home\" />\n");
      out.write("\t\t\t\t</p>\n");
      out.write("\t\t\t</form>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t\n");
      out.write("\t</div>\n");
      out.write("\t<script src=\"/javascripts/index.js\"></script>\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
