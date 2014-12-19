package org.apache.jsp.vistas.Inicio;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import net.tanesha.recaptcha.ReCaptcha;
import net.tanesha.recaptcha.ReCaptchaFactory;

public final class contacto_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\r');
      out.write('\n');
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <script src=\"JQueryClases/PAES_js.js\" type=\"text/javascript\"></script>\r\n");
      out.write("        <script src=\"JQueryClases/Map.js\" type=\"text/javascript\"></script>\r\n");
      out.write("        <script src=\"JQueryClases/reCaptcha.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\r\n");
      out.write("        <link href=\"Estilos/css/bootstrap1.css\" rel=\"stylesheet\">\r\n");
      out.write("        <link href=\"Estilos/css/style.css\" rel=\"stylesheet\">\r\n");
      out.write("        <link href=\"styles.css\" type=\"text/css\" rel=\"stylesheet\"/>\r\n");
      out.write("\r\n");
      out.write("        <script src=\"JQueryClases/jquery-1.11.1.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("        <script src=\"JQueryClases/bootstrap.min.js\" type=\"text/javascript\"></script>\r\n");
      out.write("        <!--<script src=\"JQueryClases/jquery.validate.min.js\" type=\"text/javascript\"></script>-->\r\n");
      out.write("\r\n");
      out.write("        <script src=\"JQueryClases/jquery-1.9.1.min.js\"></script>      \r\n");
      out.write("        <script src=\"JQueryClases/jquery.validate.min.js\"></script>        \r\n");
      out.write("        <script src=\"JQueryClases/formulario.js\"></script>\r\n");
      out.write("        <script src=\"JQueryClases/ValidaMail.js\" type=\"text/javascript\"></script>\r\n");
      out.write("\r\n");
      out.write("        <style type=\"text/css\" media=\"screen\">\r\n");
      out.write("            html,body{\r\n");
      out.write("                height:120%;\r\n");
      out.write("                margin:0%;\r\n");
      out.write("                padding:0%;\r\n");
      out.write("            }\r\n");
      out.write("            #map{\r\n");
      out.write("                height:80%;\r\n");
      out.write("            }\r\n");
      out.write("            #paraMapa{\r\n");
      out.write("                position: relative;\r\n");
      out.write("            }\r\n");
      out.write("        </style>\r\n");
      out.write("\r\n");
      out.write("        <script type=\"text/javascript\">\r\n");
      out.write("            $(document).ready(function() {\r\n");
      out.write("                $(\".tooltip-examples a\").tooltip({\r\n");
      out.write("                    placement: 'top'\r\n");
      out.write("                });\r\n");
      out.write("            });\r\n");
      out.write("        </script>\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    <body>\r\n");
      out.write("        <br>\r\n");
      out.write("        <div id=\"carrera\" class=\"demo ui-tabs ui-widget ui-corner-all\">\r\n");
      out.write("            <div id=\"pestana_carrera\">\r\n");
      out.write("                <ul id=\"ul_carrera\" class=\"ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header ui-corner-all\" role=\"tablist\">\r\n");
      out.write("                    <li id=\"li_carrera\" class=\"ui-state-default ui-corner-top ui-tabs-selected ui-state-active\">\r\n");
      out.write("                        <a class=\"ui-tabs-anchor\" tabindex=\"-1\">Contacto</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                </ul>\r\n");
      out.write("                <div id=\"mapa\">\r\n");
      out.write("                    <h5><b>Direcci&oacute;n: Av. Tecnol&oacute;gico S/N, Fraccionamiento la Virgen, Metepec, Edo, De M&eacute;xico, C.P. 52149</b></h5>\r\n");
      out.write("\r\n");
      out.write("                    <script type=\"text/javascript\" src=\"http://maps.google.com/maps/api/js?sensor=false&language=es&callback=iniciar\">\r\n");
      out.write("\r\n");
      out.write("                    </script>\r\n");
      out.write("\r\n");
      out.write("                    <div id=\"map\">\r\n");
      out.write("                        <div id=\"paraMapa\">\r\n");
      out.write("                            <img src=\"Imagenes/mapaImagen.PNG\" alt=\"ico_Correo\" width=\"100%\" height=\"102%\">\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div id=\"telefono\">\r\n");
      out.write("                    <div id=\"panelizquierda\"><h4><b>Tel&eacute;fono:</b><br>01 (722) 208 7200 ext. 3051</h4></div>\r\n");
      out.write("                    <div id=\"panelderecha\"><img src=\"Imagenes/Phone-icon.png\" alt=\"Tel?fono\" width=\"50\" height=\"50\"></div> \r\n");
      out.write("                </div>\r\n");
      out.write("                <div id=\"mail\" class=\"ui-corner-all tooltip-examples\">\r\n");
      out.write("                    <div id=\"panelizquierda\"><h4><b>Email:</b><br><a data-toggle=\"tooltip\" data-original-title=\"Envianos tus dudas y comentarios. Nosotros te responderemos\"  href=\"#\" onclick=\"lightbox_open_correo();\">aspirantes@ittoluca.edu.mx</a></h4></div>\r\n");
      out.write("                    <div id=\"panelderecha\">\r\n");
      out.write("                        <a data-toggle=\"tooltip\" data-original-title=\"Envíanos tus dudas y comentarios. Nosotros te responderemos\" href=\"#\" onclick=\"lightbox_open_correo();\">\r\n");
      out.write("                            <img src=\"Imagenes/email.jpg\" alt=\"Correo\" width=\"50\" height=\"50\">\r\n");
      out.write("                        </a>\r\n");
      out.write("                    </div> \r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\r\n");
      out.write("            <div id=\"light_correo\">\r\n");
      out.write("                <!--<form action=\"servlet/SendMail\" class=\"form-horizontal\" id=\"formulario_inicio\" onsubmit=\"return validar()\">-->\r\n");
      out.write("                <!--<form method=\"get\" class=\"form-horizontal\" id=\"formulario_inicio\" onsubmit=\"return validar()\" action=\"captchasubmit.jsp\">-->\r\n");
      out.write("                <!--<form method=\"get\" class=\"form-horizontal\" id=\"formulario_inicio\" action=\"captchasubmit.jsp\">-->\r\n");
      out.write("                <!--<form method=\"get\" class=\"form-horizontal\" id=\"formulario_inicio\" action=\"captchasubmit.jsp\">-->\r\n");
      out.write("                <form action=\"servlet/SendMail\" name=\"formulario_inicio\" class=\"form-horizontal\" id=\"formulario_inicio\" onsubmit=\"return validar()\">\r\n");
      out.write("                    <div class=\"control-group\">\r\n");
      out.write("                        <label class=\"control-label\" for=\"inputNombre\">Nombre :</label>\r\n");
      out.write("                        <div class=\"controls\">\r\n");
      out.write("                            <input type=\"text\" name=\"txtNombre\" id=\"txtNombre\"  size=\"32\" placeholder=\"Nombre\">\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"control-group\">\r\n");
      out.write("                        <label class=\"control-label\" for=\"inputEmail\">Email :</label>\r\n");
      out.write("                        <div class=\"controls\">\r\n");
      out.write("                            <input type=\"text\" name=\"txtEmail\" id=\"txtEmail\" size=\"32\" placeholder=\"Email\">\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"control-group\">\r\n");
      out.write("                        <label class=\"control-label\" for=\"inputDescripcion\">Descripci&oacute;n :</label>\r\n");
      out.write("                        <div class=\"controls\">\r\n");
      out.write("                            <textarea name=\"txtDescripcion\" id=\"txtDescripcion\" style=\"overflow:auto; resize:none\" rows=\"10\" cols=\"30\" placeholder=\"Inserte aquí el cuerpo de su mensaje.\"></textarea>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"control-group\">\r\n");
      out.write("                        <img id=\"captcha\" class=\"captcha\" src=\"imgCaptcha.png\" width=\"175\" height=\"60\" alt=\"Imagen CAPTCHA\" title=\"Imagen CAPTCHA\" />\r\n");
      out.write("                        <div class=\"controls\">\r\n");
      out.write("                            <input type=\"text\" name=\"txtCaptcha\" id=\"txtCaptcha\" size=\"32\" placeholder=\"Captcha\">\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <br>\r\n");
      out.write("                        <button type=\"submit\"class=\"btn btn-default\">Enviar</button>\r\n");
      out.write("                        <button type=\"button\" class=\"btn btn-default\" onClick=\"lightbox_close_correo();\">Cancelar</button>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </form>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div id=\"fade_correo\" onClick=\"lightbox_close();\"></div>  \r\n");
      out.write("        </div>\r\n");
      out.write("    </body>\r\n");
      out.write("</form>\r\n");
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
