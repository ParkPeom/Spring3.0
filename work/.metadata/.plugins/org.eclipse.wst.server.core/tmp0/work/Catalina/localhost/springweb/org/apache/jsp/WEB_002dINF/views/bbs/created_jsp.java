/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.75
 * Generated at: 2022-03-28 06:58:14 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.bbs;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class created_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
      return;
    }

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

      out.write('\r');
      out.write('\n');

	request.setCharacterEncoding("UTF-8");
	String cp = request.getContextPath(); 

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("<title>게 시 판</title>\r\n");
      out.write("\r\n");
      out.write("<!--  cp 못적음 외부사람은 못들어옴 그래서 /springweb 자기스프링을 적어줌 -->\r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/springweb/resources/css/style.css\"/>  \r\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\" href=\"/springweb/resources/css/created.css\"/>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"/springweb/resources/js/util.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("	function sendIt(){\r\n");
      out.write("		\r\n");
      out.write("		var f = document.myForm;\r\n");
      out.write("		\r\n");
      out.write("		str = f.subject.value;\r\n");
      out.write("		str = str.trim();\r\n");
      out.write("		if(!str){\r\n");
      out.write("			alert(\"\\n제목을 입력하세요.\");\r\n");
      out.write("			f.subject.focus();\r\n");
      out.write("			return;\r\n");
      out.write("		}\r\n");
      out.write("		f.subject.value = str;\r\n");
      out.write("		str = f.name.value;\r\n");
      out.write("		str = str.trim();\r\n");
      out.write("		if(!str){\r\n");
      out.write("			alert(\"\\n이름을 입력하세요.\");\r\n");
      out.write("			f.name.focus();\r\n");
      out.write("			return;\r\n");
      out.write("		}		\r\n");
      out.write("		\r\n");
      out.write("		// 한글을 입력해야하기때문에 주석처리함 \r\n");
      out.write("		/* if(!isValidKorean(str)){\r\n");
      out.write("			alert(\"\\n이름을 정확히 입력하세요.\");\r\n");
      out.write("			f.name.focus()\r\n");
      out.write("			return;\r\n");
      out.write("		}*/\r\n");
      out.write("		f.name.value = str;\r\n");
      out.write("		if(f.email.value){\r\n");
      out.write("			if(!isValidEmail(f.email.value)){\r\n");
      out.write("				alert(\"\\n정상적인 E-Mail을 입력하세요.\");\r\n");
      out.write("				f.email.focus();\r\n");
      out.write("				return;\r\n");
      out.write("			}\r\n");
      out.write("		}\r\n");
      out.write("\r\n");
      out.write("		str = f.content.value;\r\n");
      out.write("		str = str.trim();\r\n");
      out.write("		if(!str){\r\n");
      out.write("			alert(\"\\n내용을 입력하세요.\");\r\n");
      out.write("			f.content.focus();\r\n");
      out.write("			return;\r\n");
      out.write("		}\r\n");
      out.write("		f.content.value = str;\r\n");
      out.write("		\r\n");
      out.write("		str = f.pwd.value;\r\n");
      out.write("		str = str.trim();\r\n");
      out.write("		if(!str){\r\n");
      out.write("			alert(\"\\n패스워드를 입력하세요.\");\r\n");
      out.write("			f.pwd.focus();\r\n");
      out.write("			return;\r\n");
      out.write("		}\r\n");
      out.write("		f.pwd.value = str;\r\n");
      out.write("		\r\n");
      out.write("	\r\n");
      out.write("		//등록하기하면 created_ok 로 넘어가게 한다.\r\n");
      out.write("		// 포워딩할때만 진짜주소 \r\n");
      out.write("		// 나머지는 가상주소\r\n");
      out.write("		\r\n");
      out.write("		// sboard/* -> BoardServlet 으로 간다\r\n");
      out.write("		f.action = \"");
      out.print(cp);
      out.write("/created_ok.action\";\r\n");
      out.write("		f.submit();\r\n");
      out.write("	}\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<div id=\"bbs\">\r\n");
      out.write("	<div id=\"bbs_title\">\r\n");
      out.write("		게 시 판 (Servlet)\r\n");
      out.write("	</div>\r\n");
      out.write("	\r\n");
      out.write("	<form action=\"\" method=\"post\" name=\"myForm\">\r\n");
      out.write("	<div id=\"bbsCreated\">\r\n");
      out.write("		\r\n");
      out.write("		<div class=\"bbsCreated_bottomLine\">\r\n");
      out.write("			<dl>\r\n");
      out.write("				<dt>제&nbsp;&nbsp;&nbsp;&nbsp;목</dt>\r\n");
      out.write("				<dd>\r\n");
      out.write("				<input type=\"text\" name=\"subject\" size=\"60\" \r\n");
      out.write("				maxlength=\"100\" class=\"boxTF\"/>\r\n");
      out.write("				</dd>\r\n");
      out.write("			</dl>		\r\n");
      out.write("		</div>\r\n");
      out.write("		\r\n");
      out.write("		\r\n");
      out.write("		\r\n");
      out.write("		<!-- 작성자 ------------로그인햇으면 세션스코프 정보 불러오기  -->\r\n");
      out.write("		\r\n");
      out.write("		<div class=\"bbsCreated_bottomLine\">\r\n");
      out.write("			<dl>\r\n");
      out.write("				<dt>작성자</dt>\r\n");
      out.write("				<dd>\r\n");
      out.write("				<input type=\"text\" name=\"name\" size=\"35\" \r\n");
      out.write("				maxlength=\"20\" class=\"boxTF\"/>\r\n");
      out.write("				</dd>\r\n");
      out.write("			</dl>		\r\n");
      out.write("		</div>\r\n");
      out.write("		\r\n");
      out.write("		<!-----------------------------------------------------------  -->\r\n");
      out.write("		\r\n");
      out.write("		\r\n");
      out.write("		<div class=\"bbsCreated_bottomLine\">\r\n");
      out.write("			<dl>\r\n");
      out.write("				<dt>E-Mail</dt>\r\n");
      out.write("				<dd>\r\n");
      out.write("				<input type=\"text\" name=\"email\" size=\"35\" \r\n");
      out.write("				maxlength=\"50\" class=\"boxTF\"/>\r\n");
      out.write("				</dd>\r\n");
      out.write("			</dl>		\r\n");
      out.write("		</div>\r\n");
      out.write("		\r\n");
      out.write("		<div id=\"bbsCreated_content\">\r\n");
      out.write("			<dl>\r\n");
      out.write("				<dt>내&nbsp;&nbsp;&nbsp;&nbsp;용</dt>\r\n");
      out.write("				<dd>\r\n");
      out.write("				<textarea rows=\"12\" cols=\"63\" name=\"content\"\r\n");
      out.write("				class=\"boxTA\"></textarea>\r\n");
      out.write("				</dd>\r\n");
      out.write("			</dl>\r\n");
      out.write("		</div>\r\n");
      out.write("		\r\n");
      out.write("		<div class=\"bbsCreated_noLine\">\r\n");
      out.write("			<dl>\r\n");
      out.write("				<dt>패스워드</dt>\r\n");
      out.write("				<dd>\r\n");
      out.write("				<input type=\"password\" name=\"pwd\" size=\"35\" \r\n");
      out.write("				maxlength=\"7\" class=\"boxTF\"/>\r\n");
      out.write("				&nbsp;(게시물 수정 및 삭제시 필요!!)\r\n");
      out.write("				</dd>\r\n");
      out.write("			</dl>		\r\n");
      out.write("		</div>	\r\n");
      out.write("	\r\n");
      out.write("	</div>\r\n");
      out.write("	\r\n");
      out.write("	<div id=\"bbsCreated_footer\">\r\n");
      out.write("		<input type=\"button\" value=\" 등록하기 \" class=\"btn2\" onclick=\"sendIt();\"/>\r\n");
      out.write("		<input type=\"reset\" value=\" 다시입력 \" class=\"btn2\" \r\n");
      out.write("		onclick=\"document.myForm.subject.focus();\"/>\r\n");
      out.write("		<input type=\"button\" value=\" 작성취소 \" class=\"btn2\" onclick=\"javascript:location.href='");
      out.print(cp );
      out.write("/list.action';\"/> <!-- 루트경로가져올시 안에 작은따옴표; 에 큰따옴표로 묶어줌 -->\r\n");
      out.write("	</div>\r\n");
      out.write("	\r\n");
      out.write("	</form>\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
