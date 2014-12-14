<%-- 
    Document   : InicioEnviaCorreo
    Created on : 12/11/2014, 11:13:17 AM
    Author     : Desarrollo de sistem
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="JQueryClases/jquery-1.11.1.min.js" type="text/javascript"></script>
        <!--<script src="JQueryClases/PAES_js.js" type="text/javascript"></script>-->
        <link rel="stylesheet" href="Estilos/DivCargando.css" media="all" type="text/css">
        <!--<link rel="stylesheet" href="Estilos/lookandfeel_tec.css" media="all" type="text/css">-->
        <script src="../../JQueryClases/PAES_js.js" type="text/javascript"></script>
    </head>
    <body>
        <div>
            <div id="FondoEnvCorreo"  style="display: none"></div>
            <div id="divmarcoEnvCorreo"  name="marcoiniciocorreo" class="demo ui-tabs ui-widget ui-widget-content ui-corner-all" style="display: none">
                <div id="contenedor_inCorreo" style="display: none">                                  
                    <fieldset><p>
                            <br>
                            <label id="etq_CorreoI">Ingresa tu Correo Electronico: </label>
                            <input id="InCorreoE" placeholder="ejemplo@smtp.com" type="text">
                            <input id="CorreoAcep"  value="Enviar" type="button">
                            <input id="CorreoCancel"  value="Cancelar" type="button">
                       
                        <div id="cargandoDivAnimacion">
                            <div class="spinner-wave">
                                <div></div>
                                <div></div>
                                <div></div>
                                <div></div>
                                <div></div>
                            </div>
                        </div>
                        </p></fieldset>                    
                    <br>
                </div> 
                <!--Respuesta del servlet al  enviar correo-->
                <div id="RespuestaServlet" style="display: none">                   
                        <label id="RetornoServlet"></label>                       
                        <input id="AceptarRspuesta" type="button" value="Aceptar">
                </div>
            </div>
        </div>
    </body>



</html>
