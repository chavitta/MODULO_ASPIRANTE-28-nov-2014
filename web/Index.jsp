<%--<%@page contentType="text/html" pageEncoding="UTF-8"%>--%>

<%--<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>--%>
<%@ page import="net.tanesha.recaptcha.ReCaptcha" %>
<%@ page import="net.tanesha.recaptcha.ReCaptchaFactory" %>



<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="JQueryClases/jquery-1.11.1.min.js" type="text/javascript"></script>
        <script src="JQueryClases/bootstrap.min.js" type="text/javascript"></script>
        <script src="JQueryClases/jquery.validate.min.js" type="text/javascript"></script>
        <script src="JQueryClases/PAES_js.js" type="text/javascript"></script>
        <script src="JQueryClases/shadowbox.js" type="text/javascript"></script>
        <link rel="stylesheet" href="Estilos/PAES_css.css" media="all" type="text/css">
        <link rel="stylesheet" href="Estilos/css/shadowbox.css" type="text/css">
        <link rel="stylesheet" href="Estilos/lookandfeel_tec.css" type="text/css">
        <link rel="stylesheet" href="Estilos/css/bootstrap-theme.min.css.css" type="text/css">
        <link rel="stylesheet" href="Estilos/css/bootstrap.min.css.css" type="text/css">     

        <title>--M&Oacute;DULO ASPIRANTE--</title>
    </head>
    
    <!--Valida si la fecha de consulta esta dentro del periodo habilitado-->
    <body>         
        <a name="InicioPag"></a>
        <header>
            <div class="encabezado">
                <img alt="la imagen" src="Imagenes/header_ittoluca.png" title="footer">                
            </div>
            <h1>M&oacute;dulo del registro de aspirantes</h1><br><br>
        </header>        

        <div class="Contenido_menu" id="grande">
            <div id="Contenedor_Bienvenido">
                <br>
                <!--llenar aqui-->
                <div id="carrera" class="demo ui-tabs ui-widget ui-corner-all tooltip-examples">
                    <div id="pestana_carrera">
                        <ul id="ul_carrera" class="ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header ui-corner-all" role="tablist">
                            <li id="li_carrera" class="ui-state-default ui-corner-top ui-tabs-selected ui-state-active">
                                <a class="ui-tabs-anchor" role="presentation" tabindex="-1">Registro del aspirante</a>
                            </li>
                        </ul>
                        <label id="centrar_inf"><h4>Para realizar su solicitud de registro como aspirante, asegurate de contar con los siguientes datos y documentos.</h4></label>
                        <ul id="sangria">
                            <li>Clave CURP<a href="http://consultas.curp.gob.mx/CurpSP/"target="_blank"><div id="aqui">consultar aqu&iacute;</div></a></li>
                            <li>Clave de la escuela de procedencia<a href="http://www.snie.sep.gob.mx/SNIESC/" target="_blank"><div id="aqui_escuela">consultar aqu&iacute;</div></a></li>
                            <li><div id="link_toolt"><a data-toggle="tooltip" data-original-title="Federal, Estatal, Privada"  >Tipo de la escuela de procedencia</a></div></li>
                            <li>Tipo de sangre</li>
                            <li>Acta de nacimiento</li>
                        </ul>
                        <label id="centrar">
                            <h4>
                                Es responsabilidad del aspirante, una vez que haya sido aceptado, entregar todos los requisitos solicitados por servicios escolares en su inscripci&oacute;n, entre ellos el certificado de bachillerato o constancia de haber concluido el bachillerato, especificando que el certificado se encuentra en tr&aacute;mite, de lo contrario <u>NO PROCEDER&Aacute; SU INSCRIPCI&Oacute;N.</u>
                            </h4>
                        </label>

                        <br>
                        <div id="Contenido_atencion">
                            <h2>ATENCI&Oacute;N</h2> 
                            <label>
                                <h4>Es responsabilidad del aspirante ver que los datos de su registro sean ver&iacute;dicos <br></h4>
                            </label>
                        </div>
                        <label id="centrar"><h4>Para ver el seguimiento de su proceso de registro como aspirante entre a la opci&oacute;n de "Seguimiento"</h4></label>
                    </div>
                    <br>
                    <div id="Contenedor_radioButton">
                        <label>
                            <h5><input id="comprobar" type="checkbox">He le&iacute;do esta informaci&oacute;n. <br></h5>
                        </label>
                        <br>
                        <a href="#"> <label><input id="heleido" type="button" class="btn btn-info" value="Aceptar" style="display: none"></label></a>

                    </div>
<!--                    <div id="cargando">
                        <div class="spinner-wave">
                            <div></div>
                            <div></div>
                            <div></div>
                            <div></div>
                            <div></div>
                        </div>

                    </div>-->
                </div>
            </div>

            <div id="contiene_opciones">
                <h4>Opciones</h4>
            </div>

            <div id="Menu_desplegable" class="Texto_centro">
                <ul>
                    <br>
                    <li id="inicio">
                        <h3><span></span>Inicio</h3>
                    </li>
                    <li id="recuperar">
                        <h3><span></span>Recuperar Preficha</h3>
                    </li>

                    <li id="seguimiento">
                        <h3><span></span>Seguimiento</h3>
                    </li>

                    <li id="preguntas">
                        <h3><span></span>Preguntas frecuentes</h3>
                    </li>

                    <li id="ayuda">
                        <h3><span></span>Ayuda</h3>
                    </li>

                    <li id="contacto">
                        <h3><span></span>Contacto</h3>
                    </li>
                </ul>
                <br>
                <img width="90%" height="20%" alt="la imagen" src="Imagenes/imagen_itt_1.jpg" title="footer">                
                <img width="90%" height="18%" alt="la imagen" src="Imagenes/imagen_itt_2.jpg" title="footer">                
            </div>
        </div>
        <br>

        <footer>
            <div class="pieDePagina"><br><br>
                <label class="texto_inferior">
                    Instituto Tecnol&oacute;gico de Toluca | www.ittoluca.edu.mx
                    <br>
                    Instituto Tecnol&oacute;gico de Toluca - Algunos derechos reservados ? 2014
                    <br>
                </label>
                <br>
                <img width="940" height="88" alt="" src="Imagenes/footer_ittoluca.png" title="footer">
                <br>
                <label class="texto_inferior">
                    Av. Tecnol&oacute;gico s/n. Fraccionamiento La Virgen
                    <br>
                    Metepec, Edo. De M&eacute;xico, M&eacute;xico C.P. 52149
                    <br>
                    tel. (52) (722) 2 08 72 00
                </label>
            </div>
        </footer>

        <div id="content">
            <div id="overlay" class="overlay">
                
            </div>
            <div id="popup" class="popup">
                <div>
                    <center><h2>Aviso al usuario</h2></center>
                    <div id="msgPeriodo">
                        Por el momento la p&aacute;gina del preregistro de aspirantes se encuentra indispuesta debido a que no estamos en un periodo h&aacute;bil para expedir prefichas.
                    Le recomendamos intentarlo en otra ocasi&oacute;n
                    Gracias.
                    </div>
                </div>
            </div>
        </div>

    </body>
</html>

<%@include file="vistas/Aspirante/InicioEnviaCorreo.jsp" %>
