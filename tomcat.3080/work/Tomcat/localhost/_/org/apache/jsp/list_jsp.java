/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.34
 * Generated at: 2014-01-07 17:51:54 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class list_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;
  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fif_0026_005ftest;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.release();
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("<title>Photo</title>\n");
      out.write("<link type=\"text/css\" rel=\"stylesheet\" href=\"/stylesheets/reset.css\" />\n");
      out.write("<link type=\"text/css\" rel=\"stylesheet\" href=\"/stylesheets/list.css\" />\n");
      out.write("\n");
      out.write("<script src=\"http://www.google.com/jsapi\"></script>\n");
      out.write("<script>\n");
      out.write("\tgoogle.load(\"webfont\", \"1\");\n");
      out.write("\tgoogle.setOnLoadCallback(function() {\n");
      out.write("\t\tWebFont.load({\n");
      out.write("\t\t\tcustom : {\n");
      out.write("\t\t\t\tfamilies : [ \"NanumGothic\" ],\n");
      out.write("\t\t\t\turls : [ \"http://fontface.kr/NanumGothic/css\" ]\n");
      out.write("\t\t\t}\n");
      out.write("\t\t});\n");
      out.write("\t});\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\t<div id=\"fixedTop\">\n");
      out.write("\t\t<div class=\"formWrapper\">\n");
      out.write("\t\t\t<div class=\"formArea\">\n");
      out.write("\t\t\t\t<form action=\"/board\" method=\"post\" enctype=\"multipart/form-data\">\n");
      out.write("\t\t\t\t\t<div class=\"inputArea\">\n");
      out.write("\t\t\t\t\t\t<input type=\"text\" name=\"title\" id=\"title\" placeholder=\"제목\" /> <br />\n");
      out.write("\t\t\t\t\t\t<textarea name=\"contents\" rows=\"4\" cols=\"30\" placeholder=\"내용\"></textarea>\n");
      out.write("\t\t\t\t\t\t<input type=\"hidden\" name=\"writer\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.nickname}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("\"/>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<br /> <input type=\"file\" name=\"file\" id=\"file\"> <br /> <input\n");
      out.write("\t\t\t\t\t\ttype=\"reset\" value=\"초기화\"> <br />\n");
      out.write("\t\t\t\t\t<div id=\"submitArea\">\n");
      out.write("\t\t\t\t\t\t<input type=\"submit\" value=\"SUBMIT\" />\n");
      out.write("\t\t\t\t\t\t<div id=\"divTransition2\"></div>\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t</form>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\n");
      out.write("\t\t<div class=\"rightMenu\">\n");
      out.write("\t\t\t<ul>\n");
      out.write("\t\t\t\t<li><p class=\"m_nickname\">");
      out.print(session.getAttribute("nickname"));
      out.write("</p></li> ");
      out.write("\n");
      out.write("\t\t\t\t<li><a href=\"/logout\" class=\"m_btnLogout\">logout</a></li>\n");
      out.write("\t\t\t</ul>\n");
      out.write("\t\t</div>\n");
      out.write("\n");
      out.write("\t</div>\n");
      out.write("\t<div class=\"wrap\">\n");
      out.write("\t\t<div class=\"bgImg\"></div>\n");
      out.write("\t\t");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("\t</div>\n");
      out.write("\t<script src=\"/javascripts/list.js\"></script>\n");
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

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f0.setParent(null);
    // /list.jsp(56,2) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setVar("data");
    // /list.jsp(56,2) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/list.jsp(56,2) '${boardAllData}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${boardAllData}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
      if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("\t\t\t<div class=\"upload\">\n");
          out.write("\n");
          out.write("\t\t\t\t<div id=\"showTitle\">\n");
          out.write("\t\t\t\t\t<h2>");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${data.title}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</h2>\n");
          out.write("\t\t\t\t</div>\n");
          out.write("\n");
          out.write("\t\t\t\t<div>\n");
          out.write("\t\t\t\t\t<button onclick=\"location.href='/board/modify/");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${data.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("'\" class=\"postModify\">글수정</button>\n");
          out.write("\t\t\t\t\t<button onclick=\"location.href='/board/delete/");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${data.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("'\" class=\"postDel\">글삭제</button>\n");
          out.write("\t\t\t\t</div>\n");
          out.write("\n");
          out.write("\t\t\t\t");
          if (_jspx_meth_c_005fif_005f0(_jspx_th_c_005fforEach_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
            return true;
          out.write("\n");
          out.write("\t\t\t\t<div class=\"showNickname\">");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${data.writer}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</div>\n");
          out.write("\t\t\t\t<div class=\"showContents\">작성자 : ");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${data.contents}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("</div>\n");
          out.write("\t\t\t\t<br /> <br />\n");
          out.write("\n");
          out.write("\t\t\t\t");
          out.write("\n");
          out.write("\t\t\t\t\t<div id=\"commentBox\">\n");
          out.write("\t\t\t\t\t\t<div class=\"commentTitle\">\n");
          out.write("\t\t\t\t\t\t\t<p>댓글</p>\n");
          out.write("\t\t\t\t\t\t\t<p class=\"commentNum\">0</p>\n");
          out.write("\t\t\t\t\t\t\t<a class=\"commentControl\" href=\"#\">댓글 보여줘</a>\n");
          out.write("\t\t\t\t\t\t</div>\n");
          out.write("\t\t\t\t\t\t<div class=\"commentBody\">\n");
          out.write("\t\t\t\t\t\t\t");
          if (_jspx_meth_c_005fforEach_005f1(_jspx_th_c_005fforEach_005f0, _jspx_page_context, _jspx_push_body_count_c_005fforEach_005f0))
            return true;
          out.write("\n");
          out.write("\t\t\t\t\t\t</div>\n");
          out.write("\t\t\t\t\t</div>\n");
          out.write("\t\t\t\t");
          out.write("\n");
          out.write("\n");
          out.write("\t\t\t\t<div class=\"commentWrite\">\n");
          out.write("\t\t\t\t\t<label for=\"comment\">의견더하기</label><br />\n");
          out.write("\t\t\t\t\t<form action=\"/board/comment/");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${data.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("\" method=\"post\">\n");
          out.write("\t\t\t\t\t\t<textarea name=\"comment\" class=\"comment\"></textarea>\n");
          out.write("\t\t\t\t\t\t<input type=\"hidden\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${data.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("\" /> \n");
          out.write("\t\t\t\t\t\t<input type=\"submit\" value=\"댓글입력\" />\n");
          out.write("\t\t\t\t\t\t<input type=\"hidden\" name =\"writter\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${sessionScope.userId}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("\" />\n");
          out.write("\t\t\t\t\t</form>\n");
          out.write("\t\t\t\t</div>\n");
          out.write("\t\t\t</div>\n");
          out.write("\t\t\t<br />\n");
          out.write("\t\t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f0.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
    }
    return false;
  }

  private boolean _jspx_meth_c_005fif_005f0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f0, javax.servlet.jsp.PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_005fif_005f0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_005fif_005f0.setPageContext(_jspx_page_context);
    _jspx_th_c_005fif_005f0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f0);
    // /list.jsp(68,4) name = test type = boolean reqTime = true required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fif_005f0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${not empty data.fileName }", java.lang.Boolean.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false)).booleanValue());
    int _jspx_eval_c_005fif_005f0 = _jspx_th_c_005fif_005f0.doStartTag();
    if (_jspx_eval_c_005fif_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("\t\t\t\t\t<img src=\"/images/");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${data.fileName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
        out.write("\" />\n");
        out.write("\t\t\t\t");
        int evalDoAfterBody = _jspx_th_c_005fif_005f0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_005fif_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
      return true;
    }
    _005fjspx_005ftagPool_005fc_005fif_0026_005ftest.reuse(_jspx_th_c_005fif_005f0);
    return false;
  }

  private boolean _jspx_meth_c_005fforEach_005f1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_005fforEach_005f0, javax.servlet.jsp.PageContext _jspx_page_context, int[] _jspx_push_body_count_c_005fforEach_005f0)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f1 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_005fforEach_005f1.setPageContext(_jspx_page_context);
    _jspx_th_c_005fforEach_005f1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_005fforEach_005f0);
    // /list.jsp(83,7) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f1.setVar("data2");
    // /list.jsp(83,7) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
    _jspx_th_c_005fforEach_005f1.setItems(new org.apache.jasper.el.JspValueExpression("/list.jsp(83,7) '${data.comments}'",_el_expressionfactory.createValueExpression(_jspx_page_context.getELContext(),"${data.comments}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
    int[] _jspx_push_body_count_c_005fforEach_005f1 = new int[] { 0 };
    try {
      int _jspx_eval_c_005fforEach_005f1 = _jspx_th_c_005fforEach_005f1.doStartTag();
      if (_jspx_eval_c_005fforEach_005f1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("\t\t\t\t\t\t\t\t<div class=\"showComment\">\n");
          out.write("\t\t\t\t\t\t\t\t\t");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${data2.comment}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write(" <input type=\"hidden\" value=\"");
          out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${data2.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
          out.write("\" /> <input\n");
          out.write("\t\t\t\t\t\t\t\t\t\ttype=\"button\" class=\"cmtDel\" value=\"삭제\" /> <input\n");
          out.write("\t\t\t\t\t\t\t\t\t\ttype=\"button\" class=\"cmtModify\" value=\"수정\" />\n");
          out.write("\t\t\t\t\t\t\t\t</div>\n");
          out.write("\t\t\t\t\t\t\t");
          int evalDoAfterBody = _jspx_th_c_005fforEach_005f1.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_005fforEach_005f1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (java.lang.Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_005fforEach_005f1[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_005fforEach_005f1.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_005fforEach_005f1.doFinally();
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f1);
    }
    return false;
  }
}
