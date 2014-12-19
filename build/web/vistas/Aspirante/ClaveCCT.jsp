<%-- 
    Document   : ClaveCCT
    Created on : 27/10/2014, 11:24:08 AM
    Author     : ElyyzZ BaRruEtA
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <!--<script src="JQueryClases/CargarFoto.js" type="text/javascript"></script>-->
<!--        <script src="JQueryClases/jquery-1.11.1.min.js" type="text/javascript"></script>
        <script src="JQueryClases/PAES_js.js" type="text/javascript"></script>-->

        <!--        <link rel="stylesheet" href="../Estilos/diseño_datos_aspirante.css" type="text/css">
                <link rel="stylesheet" href="../Estilos/Marcos.css" type="text/css">-->
        <link rel="stylesheet" href="../../Estilos/PAES_css.css" media="all" type="text/css">
        <script src="JQueryClases/bootstrap.min.js" type="text/javascript"></script>
        <link rel="stylesheet" href="Estilos/css/bootstrap.min.css.css" type="text/css">
        <title>JSP Page</title>
    </head>
    <body>
        <div  id="FondoSeleccionaClave" style="display: none"></div>
        <div id="SelecionaClave" class="demo ui-tabs ui-widget ui-widget-content ui-corner-all" style="display: none">
            <div id="contenidoCCT">
                <h3><label>Elige clave de la escuela</label></h3>
                <div id="listaCCT">
                    <table class=" table-bordered" id="tablaCCT">
                        <thead> <th>Clave</th>
                        <th>Nombre de la Escuela</th></thead>

                    </table>
                </div>
                <div>
                    <input id="aceptarCCT" type="button" value="Aceptar">
                    <input id="cancelarCCT" type="button" value="Cancelar">
                </div>
            </div>
        </div>
    </body>
</html>
