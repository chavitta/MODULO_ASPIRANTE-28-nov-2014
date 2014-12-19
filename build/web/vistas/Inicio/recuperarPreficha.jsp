
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
                        <a class="ui-tabs-anchor" tabindex="-1">Recuperar Preficha</a>
                    </li>
                </ul>
                <div id="panel_consultas_recupera">
                    <br>
                    <div>
                        <div id="text_recupera_recupera">
                            <h1>
                                Introduce correctamente tu <u>CURP</u> y da clic en el bot&oacute;n 'Preficha' para ver tu solicitud de registro del aspirante.
                            </h1>
                        </div>
                        <br>
                        <br>
                        <div id="elem_recupera" >
                            <form name="crp" id="crp" action="servlet/PrefichaPDF" >
                                <input type="text" size="24" name="curp" id="curp" maxlength="18" onkeyup="this.value = this.value.toUpperCase()" placeholder="Introduce tu CURP"/>
                                <button id="btn_crp" type=submit value=enviar class="btn btn-default">Preficha</button>
                            </form>
                        </div>
                    </div>

                    <div id="text_seguimiento_recupera">
                        <br>
                        <h1>
                            <b>IMPORTANTE</b>
                            <br>
                            Es importante tener la preficha a la mano para cualquier tr&aacute;mite previo a tu examen de admisi&oacute;n, ya que la preficha es la identificaci&oacute;n oficial que te acredita como aspirante preinscrito.
                        </h1>
                        <br>
                    </div>
                </div>
            </div>
            <br>
        </div>

        <div id="fade">

        </div>
        <div id="light">
            <h3><img alt="alerta" src="Imagenes/aler.png" width="90px" height="90px">¡Aviso importante!</h3>
            <div id="pop_blanco">
                <h5>Esta es para recuperar la preficha</h5>
            </div>

            <div id="pop_botones">
                <button type="button" class="btn btn-default" onClick="lightbox_close();"><a href="se-llamaba-emiliano.pdf" target="_blank">Cargar foto</a></button>
                <button type="button" class="btn btn-default" onClick="lightbox_close();">Cancelar</button>
            </div>
        </div>
    </body>
</html>