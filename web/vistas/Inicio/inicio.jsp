
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <!--<script src="JQueryClases/aparece.js" type="text/javascript"></script>-->
        <!--<script src="JQueryClases/CargarFoto.js" type="text/javascript"></script>-->
        <script src="JQueryClases/PAES_js.js" type="text/javascript"></script>
        <script src="JQueryClases/jquery-1.11.1.min.js" type="text/javascript"></script>
        <script src="JQueryClases/bootstrap.min.js" type="text/javascript"></script>
        <script src="JQueryClases/jquery.validate.min.js" type="text/javascript"></script>
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
                    <li>Clave CURP<a href="http://consultas.curp.gob.mx/CurpSP/"target="_blank"><div id="aqui">consultar aquí</div></a></li>
                    <li>Clave de la escuela de procedencia<a href="http://www.snie.sep.gob.mx/SNIESC/" target="_blank"><div id="aqui_escuela">consultar aquí</div></a></li>
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
                <a> <label><input id="heleido" type="button" class="btn btn-info" value="Aceptar" style="display: none"></label></a>

            </div>
            <div id="cargando">
                <div class="spinner-wave">
                    <div></div>
                    <div></div>
                    <div></div>
                    <div></div>
                    <div></div>
                </div>

            </div>
        </div>
    </body>
</html>