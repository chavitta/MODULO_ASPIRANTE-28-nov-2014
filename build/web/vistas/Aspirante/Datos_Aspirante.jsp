<%-- 
    Document   : Dato_Aspirantes
    Created on : 6/12/2014, 12:16:02 AM
    Author     : ElyyzZ BaRruEtA
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="JQueryClases/jquery-1.11.1.min.js" type="text/javascript"></script>
        <script src="JQueryClases/shadowbox.js" type="text/javascript"></script>
        <link rel="stylesheet" href="Estilos/css/shadowbox.css" type="text/css">
        <script src="JQueryClases/Zoom.js" type="text/javascript"></script>
        <!--<script src="JQueryClases/Aspirante.js" type="text/javascript"></script>-->

        <link rel="stylesheet" href="Estilos/PAES_css.css" media="all" type="text/css">
        <link rel="stylesheet" href="Estilos/DivCargando.css" media="all" type="text/css">
        <script src="JQueryClases/PAES_js.js" type="text/javascript"></script>
        <link rel="stylesheet" href="Estilos/css/shadowbox.css" type="text/css">
        <link rel="stylesheet" href="Estilos/lookandfeel_tec.css" type="text/css">
        <link rel="stylesheet" href="Estilos/css/bootstrap-theme.min.css.css" type="text/css">
        <link rel="stylesheet" href="Estilos/css/bootstrap.min.css.css" type="text/css">   
        <script src="JQueryClases/shadowbox.js" type="text/javascript"></script>
        <script src="JQueryClases/bootstrap.min.js" type="text/javascript"></script>
        <script src="Estilos/css/bootstrap.min.css.css" type="text/javascript"></script>
        <script type="text/javascript">
            Shadowbox.init({
                language: "es",
                players: ['html']
            });
            function AlertMessage()
            {
                Shadowbox.open({
                    player: 'iframe',
                    content: 'video.html',
                    height: 500,
                    width: 600
                });
            }
        </script>
        <title>JSP Page</title>
    </head>
    <a name="InicioPag"></a>
    <form>
        <body>
            <header>
                <div class="encabezado">
                    <img alt="la imagen" src="Imagenes/header_ittoluca.png" title="footer">                
                </div>
                <h1>M&oacute;dulo del registro de aspirantes</h1><br><br>
            </header> 
            <div id="modulo">
                <div  id="avance">
                    <section id="letrero_pasos"><label>Pasos del proceso para el registro del aspirante</label>
                        <a  rel="shadowbox;" href="/MODULO_ASPIRANTE/vistas/Aspirante/Ver.jsp" class="shadows"> <label id="ver_proceso" style="cursor: pointer" >Ver</label></a></section>
                    <label id="labelenproceso">En proceso</label>
                    <section id="botones_pasos">
                        <label  id="paso1" class="avances_botones" >1</label>
                        <label id="paso2" class="avances_botones" >2</label>
                        <label id="paso3" class="avances_botones" >3</label>
                        <label  id="paso4" class="avances_botones">4</label>
                        <label id="paso5" class="avances_botones" >5</label>
                        <label id="paso6" class="avances_botones" >6</label>
                        <label  id="paso7" class="avances_botones">7</label>
                    </section>
                </div>
                <br>
                <div id="divatencion">
                    <section id="atencion" class="demo ui-tabs ui-widget ui-widget-content ui-corner-all">
                        <label>ATENCIÓN: Es responsabilidad del aspirante que los datos de su registro sean verídicos</label>
                    </section>
                    <section  id="ayudaAsp" >
                        <img  id="ayudabtn" src="Imagenes/ayuda.jpg" style="cursor: pointer"> 
                        <a href="/MODULO_ASPIRANTE/Index.jsp"><img  id="iniciobtn" src="Imagenes/home.png" style="cursor: pointer"> </a>                       
                    </section>
                </div>
            </div>
            <div id="contenido">


                <div id="DatosAspirante">
                    <!--Datos  personales aspirante-->  
                    <div id="informacionpersonal" class="demo ui-tabs ui-widget ui-widget-content ui-corner-all"> 
                        <div id="pestana_informacion_personal" >
                            <ul id="ul_informacion_personal" class=" ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header ui-corner-all">
                                <li id="li_informacion_personal" class="ui-state-default ui-corner-top ui-tabs-selected ui-state-active ">
                                    <a id="a_informacion_personal" class="ui-tabs-anchor" tabindex="-1">Datos Personales</a>
                                </li>
                            </ul>
                            <section id="personales_izquierdo">
                                <fieldset id="labels_personales">
                                    <p><label id="etiqueta_curp_izq" class="labels" >CURP:</label>
                                        <input type="text" id="inputcurp" name="curp" class="tamano_cajas_texto" maxlength="18" onkeyup="this.value = this.value.toUpperCase()"
                                               required>  
                                        <label id="etiqueta_apaterno_izq" class="labels" >Apellido Paterno:</label>
                                        <input type="text" id="inputpaterno" name="Apaterno" value="${paterno}" class="tamano_cajas_texto" maxlength="30" >
                                        <label id="etiqueta_fecha_izq" class="labels" name="Amaterno"> Fecha de Nacimiento:</label>

                                        <select name="combo_anio" id="combo_anio" >
                                            <c:forEach items="${anio}"  var="anio" >
                                                <option value="${anio.getClave()}" ><c:out value="${anio.getDma()}"/></option>      
                                            </c:forEach>
                                        </select> 
                                        <select name="combo_mes" id="combo_mes" >
                                            <c:forEach items="${mes}" var="mes">                                     
                                                <option value="${mes.getClave()}"><c:out value="${mes.getDma()}"/></option>                                                                           
                                            </c:forEach>
                                        </select> 
                                        <select name="combo_dia" id="combo_dia"  >
                                            <c:forEach  items="${dia}" var="dia" >
                                                <option value="${dia.getClave()}" ><c:out value="${dia.getDma()}"/></option>                                         
                                            </c:forEach>
                                        </select>
                                        <label id="etiqueta_sexo_izq" class="labels" name="etqsexo">Sexo:</label>
                                        <select id="sexo" name="sexo" class="Selects">
                                            <option value="--" >--Seleccione--</option> 
                                            <option value="F" >Femenino</option>                                         
                                            <option value="M" >Masculino</option>                                         


                                        </select>                           
                                        <label id="etiqueta_edocivil_izq" class="labels">Estado Civil:</label>
                                        <select id="combo_edo_civil" name="combo_edo_civil" class="Selects" >
                                            <c:forEach  items="${EdoCivil}" var="EdoCivil" >
                                                <option value="${EdoCivil.getClave()}" ><c:out value="${EdoCivil.getNombre()}"/></option>                                         
                                            </c:forEach>
                                        </select>
                                        <label id="etiqueta_capacidad_central" class="labels">Capacidad Diferente:</label>  
                                        <select id="capacidad_dif" name="combo_capacidadiferente"  class="Selects" >
                                            <option value="--">--Seleccione--</option>
                                            <option value="visual">Discapacidad visual</option>
                                            <option value="motriz">Discapacidad Motriz</option>
                                            <option value="auditiva">Discapacidad auditiva</option>
                                            <option value="ninguna">Ninguna</option>

                                        </select>
                                        <label id="etiqueta_correo_central" class="labels"  >Correo Electrónico:</label>
                                        <input type="text" id="caja_texto_email" name="email" class="tamano_cajas_texto"  value="${Email}" maxlength="150" disabled />
                                    </p>
                                </fieldset> 
                            </section>
                            <section id="seccion_botoncurp">
                                <fieldset id="buscar_curp">
                                    <p>
                                        <a href="http://consultas.curp.gob.mx/CurpSP/" target="_blank"><input type="button" id="boton_curp" name="buscar_curp"  class="tamano_cajas_texto" style="cursor: pointer" value="Buscar" ></a></p>                               
                                </fieldset>
                            </section>
                            <section id="seccion_central">
                                <fieldset id="personales_central">                          
                                    <br>
                                    <p><label id="etiqueta_amaterno_central" class="labels" name="Amaterno" >Apellido Materno:</label>
                                        <input type="text" id="inputmaterno"  value="${materno}"class="tamano_cajas_texto" required  maxlength="30">
                                        <label id="etiquetapaisnacimiento" class="labels">País de Nacimiento:</label>
                                        <select id="combopaisnacimiento" name="combo_edo_civil" class="Selects" >
                                            <c:forEach items="${pais}" var="pais">                                     
                                                <option value="${pais.getClave()}"><c:out value="${pais.getNombre()}"/></option>                                                                           
                                            </c:forEach>
                                        </select>
                                        <label id="etiqueta_edonac_central" class="labels">Estado de Nacimiento:</label> 
                                        <select id="selectedonacimiento" class="Selects" disabled>
                                            <c:forEach items="${estado}" var="estado">                                     
                                                <option value="${estado.getClave()}"><c:out value="${estado.getNombre()}"/></option>                                                                           
                                            </c:forEach>
                                        </select>
                                        <label id="etiquetaedonacimiento" class="labels">Municipio de Nacimiento:</label>
                                        <select id="combompnacimiento" name="combo_edo_nac" class="Selects" disabled>
                                            <option value="--">--Seleccione--</option>
                                        </select>
                                        <label id="etiquetacdnacimiento" class="labels">Localidad de Nacimiento:</label>
                                        <select id="combocdnacimiento" name="combo_cdnac" class="Selects" disabled >
                                            <option value="--">--Seleccione--</option>
                                            <option value="1">Maxteleca</option>
                                            <option value="2">San  Martín</option>
                                            <option value="3">San Geronimo</option>
                                        </select>
                                        <label id="etiqueta_tiposangre_central" class="labels" >Tipo de Sangre:</label>
                                        <select id="combo_tipo_sangre" name="combo_tiposangre" class="Selects" >
                                            <c:forEach items="${sangre}" var="sangre">                                     
                                                <option value="${sangre.getClave()}"><c:out value="${sangre.getNombre()}"/></option>                                                                           
                                            </c:forEach>
                                        </select></p>
                                </fieldset> 
                            </section>
                            <section id="seccion_derecha">
                                <fieldset id="personales_derecho">
                                    <br>                      
                                    <p><label name="etiqueta_nombre">Nombre(s):</label>
                                        <input id="inputnombre" value="${nombre}" type="text" required class="tamano_caja_nombre" maxlength="30">
                                        <br><br><br><br><br>
                                        <label id="sangre_aviso">Tu tipo de sangre es de vital importancia en caso de accidentes</label></p>                       
                                </fieldset>
                            </section>
                        </div>
                    </div>
                    <br>
                    <!--Datos de direccion aspirante --> 
                    <div id="direccionaspirante" class="demo ui-tabs ui-widget ui-widget-content ui-corner-all">
                        <div id="pestana_direccion">
                            <ul id="ul_direccion" class="ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header ui-corner-all" role="tablist">
                                <li id="li_direccion" class="ui-state-default ui-corner-top ui-tabs-selected ui-state-active">
                                    <a id="ui-direccion" class="ui-tabs-anchor" role="presentation" tabindex="-1">Dirección</a>
                                </li>
                            </ul>
                            <section id="direccion_izquierdo">
                                <fieldset>
                                    <p><label name="etiqueta_estado" class="labels">Estado:</label>
                                        <select name="input_estado" id="input_estado" class="Selects" >
                                            <c:forEach items="${estado}" var="estado">                                     
                                                <option value="${estado.getClave()}"><c:out value="${estado.getNombre()}"/></option>                                                                           
                                            </c:forEach>
                                        </select>                

                                        <label name="etiqueta_municipio" class="labels">Municipio:</label>
                                        <select  id="dirmunicipio"type="text"name="input_municipio" class="tamano_cajas_texto" maxlength="20">
                                            <c:forEach items="${municipio}" var="municipio">                                     
                                                <option value="${municipio.getClave()}"><c:out value="${municipio.getNombre()}"/></option>                                                                           
                                            </c:forEach></select>
                                        <label name="etiqueta_ciudad" class="labels">Localidad:</label>
                                        <select  id="dirciudad"type="text"name="input_ciudad" class="tamano_cajas_texto" maxlength="20">
                                            <option value="--">--Seleccione--</option>
                                            <option value="1">Maxteleca</option>
                                            <option value="2">San  Martín</option>
                                            <option value="3">San Geronimo</option>

                                        </select>

                                        <label name="etiqueta_colonia" class="labels">Colonia:</label>
                                        <input type="text" id="dircolonia" name="input_colonia" class="tamano_cajas_texto" maxlength="150">
                                        <label name="etiqueta_calle" class="labels">Calle:</label>
                                        <input  id="dircalle" type="text"  name="input_calle" class="tamano_cajas_texto" maxlength="150">
                                </fieldset>
                            </section>
                            <section id="direccion_centro">
                                <fieldset>
                                    <p>
                                        <label name="etiqueta_numext" class="labels_derecha">Núm. Exterior:</label>
                                        <input type="text" id="dirnumext" name="input_numExt" class="inputs_derecha" maxlength="5">
                                        <label name="etiqueta_numInt" class="labels_derecha">Núm. Interior:</label>
                                        <input type="text" id="dirnumInt" name="input_numInt" class="inputs_derecha" maxlength="5">
                                        <label name="etiqueta_Cp" class="labels_derecha">Código Postal:</label>
                                        <input  type="text" id="cp" name="input_cp" class="inputs_derecha"  maxlength="7">
                                        <label  name="etiqueta_celular" class="labels_derecha" >Teléfono Celular:</label>
                                        <input type="tel" id="numcelular" name="numero_celular" placeholder="(044)-7225586956" class="inputs_derecha" id="tel2" maxlength="13" required>
                                        <label  name="etiqueta_telfijo" class="labels_derecha" >Teléfono Fijo:</label>
                                        <input type="tel"  name="input_telfijo" id="tel2"class="inputs_derecha" placeholder="(01-714)-1438193" required  maxlength="12"></p>
                                    </p> </fieldset>
                            </section>               
                            <section id="direccion_derecho">                    
                            </section>       
                        </div>
                    </div>
                    <br>
                    <!--Datos de  escuela de procedencia --> 
                    <div id="escuelapro" class="demo ui-tabs ui-widget ui-widget-content ui-corner-all">
                        <div id="pestana_escuela">
                            <ul id="ul_escuela" class="ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header ui-corner-all" role="tablist">
                                <li id="li_escuela" class="ui-state-default ui-corner-top ui-tabs-selected ui-state-active">
                                    <a id="ui_escuela" class="ui-tabs-anchor" role="presentation" tabindex="-1">Escuela de procedencia</a>
                                </li>
                            </ul>
                            <section id="izquierdo_escuela">
                                <fieldset>
                                    <br>
                                    <label name="etiqueta_estado" class="labels">Estado:</label>
                                    <select  id="inputestado" name="input_estado" class="Selects" >
                                        <c:forEach items="${estado}" var="estado">                                     
                                            <option value="${estado.getClave()}"><c:out value="${estado.getNombre()}"/></option>                                                                           
                                        </c:forEach>
                                    </select>
                                    <label name="etiqueta_minicipio" class="labels">Municipio:</label>
                                    <select name="input_municipioEsc" class="Selects" id="municipio">

                                    </select>
                                    <label name="etiqueta_tipoescuela" class="labels">Tipo Escuela:</label>
                                    <select name="input_tipoescuela" id="combo_tipoescuela" class="Selects" >
                                        <option value="--">--Seleccione--</option>
                                        <option value="Federal">Federal</option>
                                        <option value="Estatal">Estatal</option>
                                        <option value="Privada">Privada</option>
                                        <option value="Otra">Otra</option>                                      
                                    </select>
                                    <div  id="opcion_otraescuela_aparece" style="display: none"> 
                                        <label name="otra_escuela" class="labels">Especifique que Tipo:</label>
                                        <select id="otraescuela" name="input_otraescuela" class="Selects" ><!-- -->
                                            <option value="0">--Seleccione--</option>
                                            <option value="Re">Revalidación</option>
                                            <option value="Ac">Acuerdo 286</option>
                                        </select>
                                    </div>
                                    <label name="etiqueta_escuela" class="labels">Escuela:</label>
                                    <select  name="input_escuela"  id="escuelaprocedencia" class="Selects">
                                        <c:forEach items="${Escuela}" var="Escuela">                                     
                                            <option value="${Escuela.getClave()}"><c:out value="${Escuela.getNombre()}"/></option>                                                                           
                                        </c:forEach>
                                    </select>
                                </fieldset>                
                            </section>
                            <section id="centro_escuela">                    
                                <fieldset>
                                    <p><label name="etiqueta_clave" class="labels_derecha">Clave de la Escuela:</label>

                                        <input type="text" class="inputs_derecha" id="clavesc"  onkeyup="this.value = this.value.toUpperCase()" maxlength="12">
                                        <label name="etiqueta_periodoInicio" class="labels_derecha">Periodo inicio:</label>

                                        <select name="combo_anioinicio" id="anio_inicio">
                                            <c:forEach items="${anio}" var="anio">                                     
                                                <option value="${anio.getClave()}"><c:out value="${anio.getDma()}"/></option>                                                                           
                                            </c:forEach>
                                        </select>
                                        <select id="mes_inicio" name="combo_mesinicio"  >
                                            <c:forEach items="${mes}" var="mes">                                     
                                                <option value="${mes.getClave()}"><c:out value="${mes.getDma()}"/></option>                                                                           
                                            </c:forEach>
                                        </select> 
                                        <label name="etiqueta_periodoFin" class="labels_derecha">Periodo Fin:</label>
                                        <select name="combo_aniofin" id="anio_fin" >
                                            <c:forEach items="${anio}" var="anio">                                     
                                                <option value="${anio.getClave()}"><c:out value="${anio.getDma()}"/></option>                                                                           
                                            </c:forEach>
                                        </select>
                                        <select name="combo_mesfin" id="mes_fin">
                                            <c:forEach items="${mes}" var="mes">                                     
                                                <option value="${mes.getClave()}"><c:out value="${mes.getDma()}"/></option>                                                                           
                                            </c:forEach>
                                        </select> 
                                        <label name="etiqueta_promedio " class="labels_derecha">Promedio del Bachillerato:</label>
                                        <select name="input_promedio" id="inputpromedio" class="inputs_derecha" >
                                            <c:forEach items="${promedio}" var="promedio">                                     
                                                <option value="${promedio.getClave()}"><c:out value="${promedio.getNombre()}"/></option>                                                                           
                                            </c:forEach>
                                        </select></p>                             
                                </fieldset>                                     
                            </section>
                            <section id="derecho_escuela">
                                <p>  <input type="button" id="buscar_clave"  value="Buscar clave" style="cursor: pointer"> 
                                <div id="cargandoCCT">
                                    <div class="spinner-wave">
                                        <div></div>
                                        <div></div>
                                        <div></div>
                                        <div></div>
                                        <div></div>
                                    </div>

                                </div>
                                </p>                      
                            </section>
                        </div>
                    </div>
                    <br>
                    <!--Datos Carrera -->    
                    <div id="carreradeseada" class="demo ui-tabs ui-widget ui-widget-content ui-corner-all">
                        <div id="pestana_carrera">
                            <ul id="ul_carrera" class="ui-tabs-nav ui-helper-reset ui-helper-clearfix ui-widget-header ui-corner-all" role="tablist">
                                <li id="li_carrera" class="ui-state-default ui-corner-top ui-tabs-selected ui-state-active">
                                    <a id="ui_carrera" class="ui-tabs-anchor" role="presentation" tabindex="-1">Carrera Deseada</a>
                                </li>
                            </ul>
                            <section id="carrera_opcion1">    
                                <fieldset>
                                    <select id="carreraopcion" name="inputOpcion" class="Selects_carrera" style="display: none"  >
                                        <c:forEach items="${opciones1}" var="opciones1">                                     
                                            <option value="${opciones1.getClave()}"><c:out value="${opciones1.getNombre()}"/></option>                                                                           
                                        </c:forEach>
                                    </select>
                                    <p><label name="Opcion1carrera" class="labels_carrera">Opcion 1:</label>                                        
                                        <select id="carreraopcion1" name="inputOpcion1" class="Selects_carrera"  >
                                            <c:forEach items="${opciones1}" var="opciones1">                                     
                                                <option value="${opciones1.getClave()}"><c:out value="${opciones1.getNombre()}"/></option>                                                                           
                                            </c:forEach>
                                        </select>

                                    </p>
                                </fieldset>
                            </section>
                            <section id="carrera_opcion2">    
                                <fieldset>
                                    <p><label name="Opcion2carrera" class="labels_carrera">Opcion 2:</label>                                        
                                        <select id="carreraopcion2" name="InputOpcion2" class="Selects_carrera" disabled>
                                            <c:forEach items="${opciones2}" var="opciones2">                                     
                                                <option value="${opciones2.getClave()}"><c:out value="${opciones2.getNombre()}"/></option>                                                                           
                                            </c:forEach>
                                        </select></p>
                                </fieldset>
                            </section>
                            <section id="carrera_opcion3">    
                                <fieldset>
                                    <p><label name="Opcion3carrera" class="labels_carrera">Opcion 3:</label>                                        
                                        <select  name="InputOpcion3" class="Selects_carrera" id="carreraopcion3"  disabled >
                                            <c:forEach items="${opciones3}" var="opciones3">                                     
                                                <option value="${opciones3.getClave()}"><c:out value="${opciones3.getNombre()}"/></option>                                                                           
                                            </c:forEach>
                                        </select></p>
                                </fieldset>
                            </section>
                            <section id="carrera_curso">
                                <fieldset> 
                                    <p><label name="cursopropedeutico" id="cursopropedeutico_label" class="labels_carrera">Tomaste Curso <br> Propedeutico en  la Institucion:</label>
                                        <select name="curso_sino" id="propedeuticoSelect" id="curso_sino"  >
                                            <option value="--">--</option>
                                            <option value="si">Si</option>
                                            <option value="no">No</option>
                                        </select></p>
                                </fieldset>
                            </section>               
                        </div>
                    </div>
                    <div>
                        <fieldset id="botones_continuar">

                            <a href="#InicioPag"><input type="button" id="continuar_datos" value="Continuar" style="cursor: pointer"></a>
                            <input type="reset" id="borrar_datos" title="borrar" value="Borrar Datos" style="cursor: pointer"  >
                        </fieldset>
                    </div> 
                </div>
            </div>
            <footer>
                <div class="pieDePagina"><br><br>
                    <label class="texto_inferior">
                        Instituto Tecnol&oacute;gico de Toluca | www.ittoluca.edu.mx
                        <br>
                        Instituto Tecnol&oacute;gico de Toluca - Algunos derechos reservados © 2014
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
        </body>
    </form>


</html>
<%@include file="ClaveCCT.jsp"%>
<%@include file="Confirmacion_Datos.jsp"%>