package org.apache.jsp.vistas.Inicio;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Seguimiento_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <!--<script src=\"JQueryClases/pop/pop_js.js\" type=\"text/javascript\"></script>-->  \r\n");
      out.write("        <!--<script src=\"JQueryClases/valida/ValidaCURP.js\" type=\"text/javascript\"></script>-->\r\n");
      out.write("        <script src=\"JQueryClases/PAES_js.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("<!--        <br>\r\n");
      out.write("        <div id=\"carrera\" class=\"demo ui-tabs ui-widget ui-corner-all\">\r\n");
      out.write("            <div id=\"pestana_carrera\">\r\n");
      out.write("                <ul id=\"ul_carrera\" class=\"ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header ui-corner-all\" role=\"tablist\">\r\n");
      out.write("                    <li id=\"li_carrera\" class=\"ui-state-default ui-corner-top ui-tabs-selected ui-state-active\">\r\n");
      out.write("                        <a class=\"ui-tabs-anchor\" tabindex=\"-1\">Seguimiento</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                </ul>\r\n");
      out.write("\r\n");
      out.write("                <div id=\"text_seguimiento_s\">\r\n");
      out.write("                    <br>\r\n");
      out.write("                    <h1>\r\n");
      out.write("                        Si ya elaboraste tu solicitud de registro como aspirante, asegurate de introducir correctamente tu <u>CURP</u> y da clic en 'Seguimiento' para ver el estado de tu registro.\r\n");
      out.write("                    </h1>\r\n");
      out.write("                    <br>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <div id=\"panel_consultas\">\r\n");
      out.write("                    <br>\r\n");
      out.write("                    <div id=\"elem_seguimiento\">\r\n");
      out.write("                        <form name=\"crp\" id=\"crp\" action=\"servlet/ConsultaCurp\" onsubmit=\"curpvalida()\">\r\n");
      out.write("                            <input  size=\"24\" type=\"text\" name=\"curp\" id=\"curp\" maxlength=\"18\" onkeyup=\"this.value = this.value.toUpperCase()\" placeholder=\"Introduce tu CURP\"/>\r\n");
      out.write("                            <button type=\"submit\" value=enviar class=\"btn btn-default\">Preficha</button>\r\n");
      out.write("                            <button type=submit onclick=\"curpvalida()\"value=enviar class=\"btn btn-default\">Preficha</button>\r\n");
      out.write("                        </form>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div id = \"visualiza_barra\">\r\n");
      out.write("                    <h4>\r\n");
      out.write("                        Visualizaci&oacute;n de la barra de seguimiento\r\n");
      out.write("                    </h4>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div id=\"visualiza_barra_img\">\r\n");
      out.write("                    <img alt=\"alerta\" src=\"Imagenes/barra_avance.PNG\" width=\"148%\" height=\"90px\">\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <br>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <div id=\"fade\">\r\n");
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        <div id=\"light\">\r\n");
      out.write("            <h3><img alt=\"alerta\" src=\"Imagenes/aler.png\" width=\"90px\" height=\"90px\">¡Aviso importante!</h3>\r\n");
      out.write("            <div id=\"pop_blanco\">\r\n");
      out.write("                <h5>Para poder visualizar e imprimir tu solicitud debes agregar la foto que servira para tu identificacion el dia que presentes tu examen de admision. <br>Este requisito es fundamental para seguir con el proceso de registro.</h5>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div id=\"pop_botones\">\r\n");
      out.write("                <button type=\"button\" class=\"btn btn-default\" onClick=\"lightbox_close();\"><a href=\"se-llamaba-emiliano.pdf\" target=\"_blank\">Cargar foto</a></button>\r\n");
      out.write("                <button type=\"button\" class=\"btn btn-default\" onClick=\"lightbox_close();\">Cancelar</button>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>-->\r\n");
      out.write("\r\n");
      out.write("<div>\r\n");
      out.write("    <img alt=\"alerta\" src=\"Imagenes/construyendo_web.gif\" width=\"90px\" height=\"90px\">\r\n");
      out.write("</div>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>");
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
