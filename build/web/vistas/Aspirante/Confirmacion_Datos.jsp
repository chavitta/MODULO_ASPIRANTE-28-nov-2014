<%-- 
    Document   : confirmaciion_datos
    Created on : 9/07/2014, 11:30:23 AM
    Author     : ElyyzZ BaRruEtA
--%>
<head>
   
</head>
<body>
<link rel="stylesheet" href="Estilos/PAES_css.css" media="all" type="text/css">
    <%--<jsp:useBean id="datos" scope="session"  class="beans.Bdatos_aspirante">--%>
        <div id="div_fondomarco" style="display: none" ></div>

        <div id="divmarco"  name="divmarco" class="demo ui-tabs ui-widget ui-widget-content ui-corner-all"  style="display: none"   >
            <div id="contenedor_texto">
                <label id="aviso_label"> <img src="Imagenes/aler.png" width="40px">Aviso Importante</label><!-- icono -->                     
                <p><label id="label_confirmacion">Confirma que tus Datos sean Correctos</label></p>
                <section id="area_de_texto">
                    <fieldset><p>
                            <br>
                            <label class="etiquetas_derecha">Nombre Completo: </label>
                            <label id="confirmanombre" class="etiquetas_izquierda"></label><br><br>
                            <label class="etiquetas_derecha">CURP:</label>
                            <label id="confirmacurp" class="etiquetas_izquierda"></label><br><br>
                            <label class="etiquetas_derecha">Correo:</label>
                            <label id="confirmacorreo"class="etiquetas_izquierda"></label><br><br>
                            <label class="etiquetas_derecha">Carrera Seleccionada en 1ra Opcion:</label>
                            <label id="confirmacarrera"class="etiquetas_izquierda"></label>
                        </p></fieldset>
                </section>
                <br>

                <a href="#InicioPag"> <input type="button" value="Confirmar" id="confirmar" name="confirmar"   style="cursor: pointer"></a>
                <input  type="button" value="Cancelar" id="cancelar" name="cancelar" style="cursor: pointer" >
            </div>       
        </div>

    <%--</jsp:useBean>--%>
</body>