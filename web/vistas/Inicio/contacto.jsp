<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--<%@ page language="java" import="CAPTCHA.Captcha" %>--%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>--%>

<%@ page import="net.tanesha.recaptcha.ReCaptcha" %>
<%@ page import="net.tanesha.recaptcha.ReCaptchaFactory" %>

<html>
    <head>
        <script src="JQueryClases/PAES_js.js" type="text/javascript"></script>
        <script src="JQueryClases/Map.js" type="text/javascript"></script>
        <script src="JQueryClases/reCaptcha.js" type="text/javascript"></script>

        <link href="Estilos/css/bootstrap1.css" rel="stylesheet">
        <link href="Estilos/css/style.css" rel="stylesheet">
        <link href="styles.css" type="text/css" rel="stylesheet"/>

        <script src="JQueryClases/jquery-1.11.1.min.js" type="text/javascript"></script>
        <script src="JQueryClases/bootstrap.min.js" type="text/javascript"></script>
        <!--<script src="JQueryClases/jquery.validate.min.js" type="text/javascript"></script>-->

        <script src="JQueryClases/jquery-1.9.1.min.js"></script>      
        <script src="JQueryClases/jquery.validate.min.js"></script>        
        <script src="JQueryClases/formulario.js"></script>
        <script src="JQueryClases/ValidaMail.js" type="text/javascript"></script>

        <style type="text/css" media="screen">
            html,body{
                height:120%;
                margin:0%;
                padding:0%;
            }
            #map{
                height:80%;
            }
            #paraMapa{
                position: relative;
            }
        </style>

        <script type="text/javascript">
            $(document).ready(function() {
                $(".tooltip-examples a").tooltip({
                    placement: 'top'
                });
            });
        </script>
    </head>

    <body>
        <br>
        <div id="carrera" class="demo ui-tabs ui-widget ui-corner-all">
            <div id="pestana_carrera">
                <ul id="ul_carrera" class="ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header ui-corner-all" role="tablist">
                    <li id="li_carrera" class="ui-state-default ui-corner-top ui-tabs-selected ui-state-active">
                        <a class="ui-tabs-anchor" tabindex="-1">Contacto</a>
                    </li>
                </ul>
                <div id="mapa">
                    <h5><b>Direcci&oacute;n: Av. Tecnol&oacute;gico S/N, Fraccionamiento la Virgen, Metepec, Edo, De M&eacute;xico, C.P. 52149</b></h5>

                    <script type="text/javascript" src="http://maps.google.com/maps/api/js?sensor=false&language=es&callback=iniciar">

                    </script>

                    <div id="map">
                        <div id="paraMapa">
                            <img src="Imagenes/mapaImagen.PNG" alt="ico_Correo" width="100%" height="102%">
                        </div>
                    </div>
                </div>
                <div id="telefono">
                    <div id="panelizquierda"><h4><b>Tel&eacute;fono:</b><br>01 (722) 208 7200 ext. 3051</h4></div>
                    <div id="panelderecha"><img src="Imagenes/Phone-icon.png" alt="Tel?fono" width="50" height="50"></div> 
                </div>
                <div id="mail" class="ui-corner-all tooltip-examples">
                    <div id="panelizquierda"><h4><b>Email:</b><br><a data-toggle="tooltip" data-original-title="Envianos tus dudas y comentarios. Nosotros te responderemos"  href="#" onclick="lightbox_open_correo();">aspirantes@ittoluca.edu.mx</a></h4></div>
                    <div id="panelderecha">
                        <a data-toggle="tooltip" data-original-title="Envíanos tus dudas y comentarios. Nosotros te responderemos" href="#" onclick="lightbox_open_correo();">
                            <img src="Imagenes/email.jpg" alt="Correo" width="50" height="50">
                        </a>
                    </div> 
                </div>
            </div>

            <div id="light_correo">
                <!--<form action="servlet/SendMail" class="form-horizontal" id="formulario_inicio" onsubmit="return validar()">-->
                <!--<form method="get" class="form-horizontal" id="formulario_inicio" onsubmit="return validar()" action="captchasubmit.jsp">-->
                <!--<form method="get" class="form-horizontal" id="formulario_inicio" action="captchasubmit.jsp">-->
                <!--<form method="get" class="form-horizontal" id="formulario_inicio" action="captchasubmit.jsp">-->
                <form action="servlet/SendMail" class="form-horizontal" id="formulario_inicio" onsubmit="return validar()">
                    <div class="control-group">
                        <label class="control-label" for="inputNombre">Nombre :</label>
                        <div class="controls">
                            <input type="text" name="txtNombre" id="txtNombre"  size="32" placeholder="Nombre">
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="inputEmail">Email :</label>
                        <div class="controls">
                            <input type="text" name="txtEmail" id="txtEmail" size="32" placeholder="Email">
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="inputDescripcion">Descripci&oacute;n :</label>
                        <div class="controls">
                            <textarea name="txtDescripcion" id="txtDescripcion" style="overflow:auto; resize:none" rows="10" cols="30" placeholder="Inserte aquí el cuerpo de su mensaje."></textarea>
                        </div>
                    </div>
                    <div class="control-group">
                        <div class="controls">
                            <div class="captchaSizeDivLarge">
                                <img id="si_image_com" class="si-captcha" src="http://www.colordeu.es/BLOG/wp-content/plugins/si-captcha-for-wordpress/captcha/securimage_show.php?si_form_id=com&amp;prefix=vXbpWge13GNhnkNg" width="175" height="60" alt="Imagen CAPTCHA" title="Imagen CAPTCHA" />

                                <input id="si_code_com" name="si_code_com" type="hidden"  value="vXbpWge13GNhnkNg" />

                                <div id="si_refresh_com">
                                    <a href="#" rel="nofollow" title="Refrescar imagen" onclick="si_captcha_refresh('si_image_com', 'com', '/BLOG/wp-content/plugins/si-captcha-for-wordpress/captcha', 'http://www.colordeu.es/BLOG/wp-content/plugins/si-captcha-for-wordpress/captcha/securimage_show.php?si_form_id=com&amp;prefix=');
                                            return false;">
                                        <img class="captchaImgRefresh" src="http://www.colordeu.es/BLOG/wp-content/plugins/si-captcha-for-wordpress/captcha/images/refresh.png" width="22" height="20" alt="Refrescar imagen" onclick="this.blur();" /></a>
                                </div>
                            </div>
                            <div id="captchaInputDiv">
                                <input id="captcha_code" name="captcha_code" type="text" value="" tabindex="4"  placeholder="Introduce el código"/>
                                <!--<label id="captcha_code_label" for="captcha_code">Código CAPTCHA</label><span class="required"> *</span>-->
                            </div>
                            <button type="submit"class="btn btn-default">Enviar</button>
                            <button type="button" class="btn btn-default" onClick="lightbox_close_correo();">Cancelar</button>
                        </div>
                    </div>
                    <div class="img_correo_pop">
                        <img src="Imagenes/ico_correo.gif" alt="ico_Correo" width="110" height="110">
                    </div>
                </form>
            </div>
            <div id="fade_correo" onClick="lightbox_close();"></div>  
        </div>
    </body>
</form>
</html>
