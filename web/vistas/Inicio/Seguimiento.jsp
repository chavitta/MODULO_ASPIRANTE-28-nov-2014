<%--
    Document   : Seguimiento
    Created on : 6/08/2014, 06:07:25 PM
    Author     : Chavitta
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <!--<script src="JQueryClases/pop/pop_js.js" type="text/javascript"></script>-->  
        <!--<script src="JQueryClases/valida/ValidaCURP.js" type="text/javascript"></script>-->
        <script src="JQueryClases/PAES_js.js" type="text/javascript"></script>
    </head>
    <body>
        <br>
        <div id="carrera" class="demo ui-tabs ui-widget ui-corner-all">
            <div id="pestana_carrera">
                <ul id="ul_carrera" class="ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header ui-corner-all" role="tablist">
                    <li id="li_carrera" class="ui-state-default ui-corner-top ui-tabs-selected ui-state-active">
                        <a class="ui-tabs-anchor" tabindex="-1">Seguimiento</a>
                    </li>
                </ul>

                <div id="text_seguimiento_s">
                    <br>
                    <h1>
                        Si ya elaboraste tu solicitud de registro como aspirante, asegurate de introducir correctamente tu <u>CURP</u> y da clic en 'Seguimiento' para ver el estado de tu registro.
                    </h1>
                    <br>
                </div>

                <div id="panel_consultas">
                    <br>
                    <div id="elem_seguimiento">
                        <form name="crp" id="crp" action="servlet/ConsultaCurp" onsubmit="curpvalida()">
                            <input  size="24" type="text" name="curp" id="curp" maxlength="18" onkeyup="this.value = this.value.toUpperCase()" placeholder="Introduce tu CURP"/>
                            <button type="submit" value=enviar class="btn btn-default">Preficha</button>
                            <!--<button type=submit onclick="curpvalida()"value=enviar class="btn btn-default">Preficha</button>-->
                        </form>
                    </div>
                </div>
                <div id = "visualiza_barra">
                    <h4>
                        Visualizaci&oacute;n de la barra de seguimiento
                    </h4>
                </div>
                <div id="visualiza_barra_img">
                    <img alt="alerta" src="Imagenes/barra_avance.PNG" width="148%" height="90px">
                </div>
            </div>
            <br>
        </div>

        <div id="fade">

        </div>
        <div id="light">
            <h3><img alt="alerta" src="Imagenes/aler.png" width="90px" height="90px">¡Aviso importante!</h3>
            <div id="pop_blanco">
                <h5>Para poder visualizar e imprimir tu solicitud debes agregar la foto que servira para tu identificacion el dia que presentes tu examen de admision. <br>Este requisito es fundamental para seguir con el proceso de registro.</h5>
            </div>

            <div id="pop_botones">
                <button type="button" class="btn btn-default" onClick="lightbox_close();"><a href="se-llamaba-emiliano.pdf" target="_blank">Cargar foto</a></button>
                <button type="button" class="btn btn-default" onClick="lightbox_close();">Cancelar</button>
            </div>
        </div>
    </body>
</html>