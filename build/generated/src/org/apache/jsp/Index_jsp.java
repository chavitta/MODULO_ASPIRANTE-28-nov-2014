package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/vistas/Aspirante/InicioEnviaCorreo.jsp");
  }

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
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("\r\n");
      out.write("        <script type=\"text/javascript\">\r\n");
      out.write("            $(\".tooltip-examples a\").tooltip({\r\n");
      out.write("                placement: 'top'\r\n");
      out.write("            });\r\n");
      out.write("        </script>\r\n");
      out.write("\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <script src=\"JQueryClases/jquery-1.11.1.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("        <script src=\"JQueryClases/bootstrap.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("        <script src=\"JQueryClases/jquery.validate.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("        <script src=\"JQueryClases/PAES_js.js\" type=\"text/javascript\"></script>\r\n");
      out.write("        <script src=\"JQueryClases/shadowbox.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"Estilos/PAES_css.css\" media=\"all\" type=\"text/css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"Estilos/css/shadowbox.css\" type=\"text/css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"Estilos/lookandfeel_tec.css\" type=\"text/css\">\r\n");
      out.write("        \r\n");
      out.write("        <link rel=\"stylesheet\" href=\"Estilos/css/bootstrap-theme.min.css.css\" type=\"text/css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"Estilos/css/bootstrap.min.css.css\" type=\"text/css\">     \r\n");
      out.write("        <link rel=\"stylesheet\" href=\"Estilos/css/bootstrap-theme.min.css #2.css\" type=\"text/css\">     \r\n");
      out.write("        <link rel=\"stylesheet\" href=\"Estilos/css/bootstrap1.css\" type=\"text/css\">     \r\n");
      out.write("<!--        <link rel=\"stylesheet\" href=\"Estilos/css/bootstrap-theme.css\" type=\"text/css\">     \r\n");
      out.write("        <link rel=\"stylesheet\" href=\"Estilos/css/bootstrap-theme.min.css\" type=\"text/css\">     \r\n");
      out.write("        <link rel=\"stylesheet\" href=\"Estilos/css/bootstrap.css\" type=\"text/css\">     \r\n");
      out.write("        <link rel=\"stylesheet\" href=\"Estilos/css/bootstrap.min.css\" type=\"text/css\">     -->\r\n");
      out.write("        <title>--M&Oacute;DULO ASPIRANTE--</title>\r\n");
      out.write("\r\n");
      out.write("<!--\r\n");
      out.write("         Latest compiled and minified CSS \r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css\">\r\n");
      out.write("\r\n");
      out.write("         Optional theme \r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap-theme.min.css\">\r\n");
      out.write("\r\n");
      out.write("         Latest compiled and minified JavaScript \r\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js\"></script>-->\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>         \r\n");
      out.write("        <a name=\"InicioPag\"></a>\r\n");
      out.write("        <header>\r\n");
      out.write("            <div class=\"encabezado\">\r\n");
      out.write("                <img alt=\"la imagen\" src=\"Imagenes/header_ittoluca.png\" title=\"footer\">                \r\n");
      out.write("            </div>\r\n");
      out.write("            <h1>M&oacute;dulo del registro de aspirantes</h1><br><br>\r\n");
      out.write("        </header>        \r\n");
      out.write("\r\n");
      out.write("        <div class=\"Contenido_menu\" id=\"grande\">\r\n");
      out.write("            <div id=\"Contenedor_Bienvenido\">\r\n");
      out.write("                <br>\r\n");
      out.write("                <!--llenar aqui-->\r\n");
      out.write("                <div id=\"carrera\" class=\"demo ui-tabs ui-widget ui-corner-all tooltip-examples\">\r\n");
      out.write("                    <div id=\"pestana_carrera\">\r\n");
      out.write("                        <ul id=\"ul_carrera\" class=\"ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header ui-corner-all\" role=\"tablist\">\r\n");
      out.write("                            <li id=\"li_carrera\" class=\"ui-state-default ui-corner-top ui-tabs-selected ui-state-active\">\r\n");
      out.write("                                <a class=\"ui-tabs-anchor\" role=\"presentation\" tabindex=\"-1\">Registro del aspirante</a>\r\n");
      out.write("                            </li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                        <label id=\"centrar_inf\"><h4>Para realizar su solicitud de registro como aspirante, asegurate de contar con los siguientes datos y documentos.</h4></label>\r\n");
      out.write("                        <ul id=\"sangria\">                            \r\n");
      out.write("                            <li>Clave CURP<a href=\"http://consultas.curp.gob.mx/CurpSP/\"target=\"_blank\"><div id=\"aqui\">consultar aquí</div></a></li>\r\n");
      out.write("                            <li>Clave de la escuela de procedencia<a href=\"http://www.snie.sep.gob.mx/SNIESC/\" target=\"_blank\"><div id=\"aqui_escuela\">consultar aquí</div></a></li>\r\n");
      out.write("                            <li><div id=\"link_toolt\"><a data-toggle=\"tooltip\" data-original-title=\"Federal, Estatal, Privada\"  >Tipo de la escuela de procedencia</a></div></li>\r\n");
      out.write("                            <li>Tipo de sangre</li>\r\n");
      out.write("                            <li>Acta de nacimiento</li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                        <label id=\"centrar\">\r\n");
      out.write("                            <h4>\r\n");
      out.write("                                Es responsabilidad del aspirante, una vez que haya sido aceptado, entregar todos los requisitos solicitados por servicios escolares en su inscripci&oacute;n, entre ellos el certificado de bachillerato o constancia de haber concluido el bachillerato, especificando que el certificado se encuentra en tr&aacute;mite, de lo contrario <u>NO PROCEDER&Aacute; SU INSCRIPCI&Oacute;N.</u>\r\n");
      out.write("                            </h4>\r\n");
      out.write("                        </label>\r\n");
      out.write("\r\n");
      out.write("                        <br>\r\n");
      out.write("                        <div id=\"Contenido_atencion\">\r\n");
      out.write("                            <h2>ATENCI&Oacute;N</h2> \r\n");
      out.write("                            <label>\r\n");
      out.write("                                <h4>Es responsabilidad del aspirante ver que los datos de su registro sean ver&iacute;dicos <br></h4>\r\n");
      out.write("                            </label>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <label id=\"centrar\"><h4>Para ver el seguimiento de su proceso de registro como aspirante entre a la opci&oacute;n de \"Seguimiento\"</h4></label>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <br>\r\n");
      out.write("                    <div id=\"Contenedor_radioButton\">\r\n");
      out.write("                        <label>\r\n");
      out.write("                            <h5><input id=\"comprobar\" type=\"checkbox\">He le&iacute;do esta informaci&oacute;n. <br></h5>\r\n");
      out.write("                        </label>\r\n");
      out.write("                        <br>\r\n");
      out.write("                        <a> <label><input id=\"heleido\" type=\"button\" class=\"btn btn-info\" value=\"Aceptar\" style=\"display: none\"></label></a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div id=\"contiene_opciones\">\r\n");
      out.write("                <h4>Opciones</h4>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div id=\"Menu_desplegable\" class=\"Texto_centro\">\r\n");
      out.write("                <ul>\r\n");
      out.write("                    <br>\r\n");
      out.write("                    <li id=\"inicio\">\r\n");
      out.write("                        <h3><span></span>Inicio</h3>\r\n");
      out.write("                    </li>\r\n");
      out.write("                    <li id=\"recuperar\">\r\n");
      out.write("                        <h3><span></span>Recuperar Preficha</h3>\r\n");
      out.write("                    </li>\r\n");
      out.write("\r\n");
      out.write("                    <li id=\"seguimiento\">\r\n");
      out.write("                        <h3><span></span>Seguimiento</h3>\r\n");
      out.write("                    </li>\r\n");
      out.write("\r\n");
      out.write("                    <li id=\"preguntas\">\r\n");
      out.write("                        <h3><span></span>Preguntas frecuentes</h3>\r\n");
      out.write("                    </li>\r\n");
      out.write("\r\n");
      out.write("                    <li id=\"ayuda\">\r\n");
      out.write("                        <h3><span></span>Ayuda</h3>\r\n");
      out.write("                    </li>\r\n");
      out.write("\r\n");
      out.write("                    <li id=\"contacto\">\r\n");
      out.write("                        <h3><span></span>Contacto</h3>\r\n");
      out.write("                    </li>\r\n");
      out.write("                </ul>\r\n");
      out.write("                <br>\r\n");
      out.write("                <img width=\"90%\" height=\"20%\" alt=\"la imagen\" src=\"Imagenes/imagen_itt_1.jpg\" title=\"footer\">                \r\n");
      out.write("                <img width=\"90%\" height=\"18%\" alt=\"la imagen\" src=\"Imagenes/imagen_itt_2.jpg\" title=\"footer\">                \r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <br>\r\n");
      out.write("\r\n");
      out.write("        <footer>\r\n");
      out.write("            <div class=\"pieDePagina\"><br><br>\r\n");
      out.write("                <label class=\"texto_inferior\">\r\n");
      out.write("                    Instituto Tecnol&oacute;gico de Toluca | www.ittoluca.edu.mx\r\n");
      out.write("                    <br>\r\n");
      out.write("                    Instituto Tecnol&oacute;gico de Toluca - Algunos derechos reservados ? 2014\r\n");
      out.write("                    <br>\r\n");
      out.write("                </label>\r\n");
      out.write("                <br>\r\n");
      out.write("                <img width=\"940\" height=\"88\" alt=\"\" src=\"Imagenes/footer_ittoluca.png\" title=\"footer\">\r\n");
      out.write("                <br>\r\n");
      out.write("                <label class=\"texto_inferior\">\r\n");
      out.write("                    Av. Tecnol&oacute;gico s/n. Fraccionamiento La Virgen\r\n");
      out.write("                    <br>\r\n");
      out.write("                    Metepec, Edo. De M&eacute;xico, M&eacute;xico C.P. 52149\r\n");
      out.write("                    <br>\r\n");
      out.write("                    tel. (52) (722) 2 08 72 00\r\n");
      out.write("                </label>\r\n");
      out.write("            </div>\r\n");
      out.write("        </footer>\r\n");
      out.write("\r\n");
      out.write("        <div id=\"content\">\r\n");
      out.write("            <div id=\"overlay\" class=\"overlay\">\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("            <div id=\"popup\" class=\"popup\">\r\n");
      out.write("                <div>\r\n");
      out.write("                    <center><h2>Aviso al usuario</h2></center>\r\n");
      out.write("                    <div id=\"msgPeriodo\">\r\n");
      out.write("                        Por el momento la p&aacute;gina del preregistro de aspirantes se encuentra indispuesta debido a que no estamos en un periodo h&aacute;bil para expedir prefichas.\r\n");
      out.write("                        Le recomendamos intentarlo en otra ocasi&oacute;n\r\n");
      out.write("                        Gracias.\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("<!--        <button type=\"button\" class=\"btn btn-default\" aria-label=\"Left Align\">\r\n");
      out.write("            <span class=\"glyphicon glyphicon-align-left\" aria-hidden=\"true\"></span>\r\n");
      out.write("        </button>\r\n");
      out.write("\r\n");
      out.write("        <button type=\"button\" class=\"btn btn-default btn-lg\">\r\n");
      out.write("            <span class=\"glyphicon glyphicon-star\" aria-hidden=\"true\"></span> Star\r\n");
      out.write("        </button>-->\r\n");
      out.write("\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <script src=\"JQueryClases/jquery-1.11.1.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("        <!--<script src=\"JQueryClases/PAES_js.js\" type=\"text/javascript\"></script>-->\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"Estilos/DivCargando.css\" media=\"all\" type=\"text/css\">\r\n");
      out.write("        <!--<link rel=\"stylesheet\" href=\"Estilos/lookandfeel_tec.css\" media=\"all\" type=\"text/css\">-->\r\n");
      out.write("        <script src=\"../../JQueryClases/PAES_js.js\" type=\"text/javascript\"></script>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <div>\r\n");
      out.write("            <div id=\"FondoEnvCorreo\"  style=\"display: none\"></div>\r\n");
      out.write("            <div id=\"divmarcoEnvCorreo\"  name=\"marcoiniciocorreo\" class=\"demo ui-tabs ui-widget ui-widget-content ui-corner-all\" style=\"display: none\">\r\n");
      out.write("                <div id=\"contenedor_inCorreo\" style=\"display: none\">                                  \r\n");
      out.write("                    <fieldset><p>\r\n");
      out.write("                            <br>\r\n");
      out.write("                            <label id=\"etq_CorreoI\">Ingresa tu Correo Electronico: </label>\r\n");
      out.write("                            <input id=\"InCorreoE\" placeholder=\"ejemplo@smtp.com\" type=\"text\">\r\n");
      out.write("                            <input id=\"CorreoAcep\"  value=\"Enviar\" type=\"button\">\r\n");
      out.write("                            <input id=\"CorreoCancel\"  value=\"Cancelar\" type=\"button\">\r\n");
      out.write("                       \r\n");
      out.write("                        <div id=\"cargandoDivAnimacion\">\r\n");
      out.write("                            <div class=\"spinner-wave\">\r\n");
      out.write("                                <div></div>\r\n");
      out.write("                                <div></div>\r\n");
      out.write("                                <div></div>\r\n");
      out.write("                                <div></div>\r\n");
      out.write("                                <div></div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        </p></fieldset>                    \r\n");
      out.write("                    <br>\r\n");
      out.write("                </div> \r\n");
      out.write("                <!--Respuesta del servlet al  enviar correo-->\r\n");
      out.write("                <div id=\"RespuestaServlet\" style=\"display: none\">                   \r\n");
      out.write("                        <label id=\"RetornoServlet\"></label>                       \r\n");
      out.write("                        <input id=\"AceptarRspuesta\" type=\"button\" value=\"Aceptar\">\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</html>\r\n");
      out.write('\r');
      out.write('\n');
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
