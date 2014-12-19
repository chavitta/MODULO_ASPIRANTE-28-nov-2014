<%-- 
    Document   : RegistroFinalizado
    Created on : 10/08/2014, 04:57:40 PM
    Author     : ElyyzZ BaRruEtA
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="JQueryClases/PAES_js.js" type="text/javascript"></script>
        <link rel="stylesheet" href="Estilos/PAES_css.css" media="all" type="text/css">
        <title>JSP Page</title>
    </head>
    <body>

        <div id="fondofinalizado"  style="display: none">  </div>
        <div id="finalizado" class="demo ui-tabs ui-widget ui-widget-content ui-corner-all" style="display: none" >
            <div id="finalizadodiv" >
                <section id="textofin">
                    <p id="Labelfinalizado"><h2><img src="Imagenes/aler.png" id="imagenfinalizado"> 
                        <label id="importantefinalizado">Aviso Importante</label></h2></p> 
                    <section id="textofinalizado"> 

                        <blockquote>
                            <h3><label>Tu registro a finalizado con éxito</label></h3>
                            <p>En un  momento será enviada tu solicitud junto con el Boucher de pago al correo  </p>
                            <label id="correoFinalizado">${aspirante.getEmail()} </label>
                            <p>Si no logras visualizar el correo en tu "Bandeja de entrada" debes verificar en la bandeja de "Correo no deseado". Las
                                instrucciones para darle seguimiento a  tu registro están anexas en el correo que te fué enviado,  por ello es  
                                importante que lo leas atentamente.</p>
                        </blockquote>
                    </section>
                </section>
                <section id="botonesfinalizado">
                    <a href="/MODULO_ASPIRANTE/Index.jsp"><input  id="aceptarfinalizado" type="button" value="Aceptar"></a>
                    <input  id="cancelarfinalizado" type="button" value="Cancelar">

                </section>
            </div>

        </div>


    </body>
</html>
