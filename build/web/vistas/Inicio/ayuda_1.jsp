<%-- 
    Document   : ayuda
    Created on : 6/08/2014, 08:29:26 PM
    Author     : Chavitta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <!--<script src="JQueryClases/pop/pop_js_imagen_ayuda.js" type="text/javascript"></script>-->
        <script src="JQueryClases/jquery-1.11.1.min.js" type="text/javascript"></script>
        <!--<script src="JQueryClases/CargarFoto.js" type="text/javascript"></script>-->
        <script src="JQueryClases/jquery.guillotine.js" type="text/javascript"></script>
        <script src="JQueryClases/jquery.guillotine.min.js" type="text/javascript"></script>
        <link href='Estilos/css/jquery.guillotine.css' media='all' rel='stylesheet'>
        <script src="JQueryClases/PAES_js.js" type="text/javascript"></script>

        <link href='Estilos/zoom.css' media='all' rel='stylesheet'>
    </head>
    <body>
        <br>
        <div id="carrera" class="demo ui-tabs ui-widget ui-corner-all">
            <div id="pestana_carrera">
                <ul id="ul_carrera" class="ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header ui-corner-all" role="tablist">
                    <li id="li_carrera" class="ui-state-default ui-corner-top ui-tabs-selected ui-state-active">
                        <a class="ui-tabs-anchor" tabindex="-1">Ayuda</a>
                    </li>
                </ul>
            </div>

            <div id="contenedor_1" class="Texto_centro">
                <h4>Manual del proceso de registro del aspirante</h4>
                <br>
                <a href="#" onclick="lightbox_open_ayuda();">
                    <img alt="ayuda" width="600px" height="310px" src="Imagenes/imagen_pop.png" title="footer">                
                </a>
            </div>

            <div id="contenedor_2" class="Texto_centro">
                <h4>Manual para el uso de esta aplicaci&oacute;n</h4>
            </div>

            <div id="light_imagen_pop">
                <img alt="ayuda" width="900px" height="600px" alt="la imagen" src="Imagenes/imagen_pop.png" title="footer"> 
                <div id='controls'>
                    <button id='zoom_out'    type='button' title='Zoom out'> - </button>
                    <button id='fit'          type='button' title='Fit image'> [ ]  </button>
                    <button id='zoom_in'      type='button' title='Zoom in'> + </button>
                </div>
            </div>

            <div id="fade_im_pop" onClick="lightbox_close_adyuda();"></div> 

        </div>
    </body>
</html>