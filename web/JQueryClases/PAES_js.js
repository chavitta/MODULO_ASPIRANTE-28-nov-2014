/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function Pais() {



}

//****************
$('#crp').submit(function(event) {
    var cur = document.getElementById("curp").value;
    if (!cur.match(/^([a-z]{4})([0-9]{6})([a-z]{6})([0-9]{2})$/i)) {//AAAA######AAAAAA##
        alert('Por favor revise su curp!');
        event.preventDefault();
    }
});
//****************

function EnviaCorreoInicio() {
    var correo = $('#InCorreoE').val();
    $.get('EnviaEmailInicio',
            {correo: correo},
    function(retorno) {
        //agregar  al div  la leyenda que retorna el servlet
        $('#cargando').hide();
        $('#contenedor_inCorreo').hide();
        $("#RespuestaServlet").show();
        $('#RetornoServlet').text(retorno);
    }
    );

}


function ValidaPeriodo() {
    $('#anio_fin').change(function() {
        var inicio = "01/" + $('#mes_inicio option:selected').html() + "/" + $('#anio_inicio option:selected').html();
        inicio = new Date(inicio);
        var fin = "01/" + $('#mes_fin option:selected').html() + "/" + $('#anio_fin option:selected').html();
        fin = new Date(fin);
        $('#mes_inicio').css("border", "");
        $('#anio_inicio').css("border", "");
        if (inicio >= fin) {
            alert('La fecha de inicio puede ser mayor que la fecha fin');
            $('#mes_inicio').css("border", "1px solid red");
            $('#anio_inicio').css("border", "1px solid red");

        }
    });

}
function ConfirmaDatos() {
    var correo = $('#caja_texto_email').val();
    var nombre = $('#inputnombre').val();
    var paterno = $('#inputpaterno').val();
    var materno = $('#inputmaterno').val();
    var curp = $('#inputcurp').val();
    var carrera = $('#carreraopcion1 option:selected').html();
    $('#confirmanombre').text(nombre + " " + paterno + " " + materno);
//            prop("value", nombre + " " + paterno + " " + materno);
    $('#confirmacurp').text(curp);
    $('#confirmacorreo').text(correo);
    $('#confirmacarrera ').text(carrera);
    $.get('/MODULO_ASPIRANTE/GuardaCorreo',
            {correo: correo},
    function(retorno) {
    }
    );
}

function Filtros(id, data) {
    $(id).html("");
    $.each(data, function(index, item) {
        var txt = item.Clave;
        var t = item.Nombre;
        $(id).append("<option value='" + txt + "'>" + t + "</option>");
    });
}

$(document).ready(function() {
    ValidaTipos();
    ValidaPeriodo();

    periodo(true);

    $('#captcha_btn').click(function() {
        recarga();
    });


    $('#formulario_inicio').submit(function(event) {
        var captcha = document.getElementById("txtCaptcha").value;

        alert("El captcha es " + captcha);
        $.ajax({
            type: "POST",
            async: false,
            url: "ValidaCap",
            data: {code: captcha},
            success: function(data) {
                if (data === "si")
                {

                } else
                {
                    event.preventDefault();

                    recarga();
                }
            }
        });
    });

    $('#selectedonacimiento').change(function() {

        var pk = $('#selectedonacimiento option:selected').val();
        var opcion = "Mun";

        $.getJSON("/MODULO_ASPIRANTE/CargaEstado",
                {pk: pk, opcion: opcion},
        function(data) {
            //limpiar el option value
            Filtros("#combompnacimiento", data);
        });
    });
    $('#input_estado').change(function() {
        var pk = $('#input_estado option:selected').val();
        var opcion = "Mun";
        $.getJSON("/MODULO_ASPIRANTE/CargaEstado",
                {pk: pk, opcion: opcion},
        function(data) {
            //limpiar el option value
            Filtros("#dirmunicipio", data);
        });
    });
    $('#inputestado').change(function() {
        var pk = $('#inputestado option:selected').val();
        var opcion = "Mun";
        $.getJSON("/MODULO_ASPIRANTE/CargaEstado",
                {pk: pk, opcion: opcion},
        function(data) {
            //limpiar el option value
            Filtros("#municipio", data);
        });
    });
    $('#estado').change(function() {
        var pk = $('#estado option:selected').val();
        var opcion = "Mun";
        $.getJSON("/MODULO_ASPIRANTE/CargaEstado",
                {pk: pk, opcion: opcion},
        function(data) {
            //limpiar el option value
            Filtros("#ciudad", data);
        });
    });
//    $('#combompnacimiento').change(function() {
//        var pk = $('#combompnacimiento option:selected').val();
//        $('#combocdnacimiento').prop("disabled", false);
//        var opcion = "Loc";
//        $.getJSON("/MODULO_ASPIRANTE/CargaEstado",
//                {pk: pk, opcion: opcion},
//        function(data) {
//            //limpiar el option value
//            Filtros("#combocdnacimiento", data);
//
//        });
//    });
//    $('#dirmunicipio').change(function() {
//        var pk = $('#dirmunicipio option:selected').val();
//
//        var opcion = "Loc";
//        $.getJSON("/MODULO_ASPIRANTE/CargaEstado",
//                {pk: pk, opcion: opcion},
//        function(data) {
//            //limpiar el option value
//            Filtros("#dirciudad", data);
//
//        });
//    });

//llama servlet  
    $('#heleido').click(function() {
        var $valor = $("input #heleido").val();

        $('#FondoEnvCorreo').show();
        $('#divmarcoEnvCorreo').show();
        $('#contenedor_inCorreo').show();
    });
    $('#CorreoCancel').click(function() {
        $('#RetornoServlet').text("  ");
        $('#InCorreoE').val("");
        $('#FondoEnvCorreo').hide();
        $('#divmarcoEnvCorreo').hide();
        $('#heleido').hide();
        $('#RespuestaServlet').hide();
        $("#cargandoDivAnimacion").hide();
        $("#comprobar").removeAttr("checked");
    });
    $('#CorreoAcep').click(function() {
        $('#RespuestaServlet').hide();
        validaCorreoElectronico('#InCorreoE');
        var Email = $('#InCorreoE').val();
        if ((Email === "" || Email === undefined || Email === null)) {
            alert("Por  favor  introdusca  una  dirección de  correo");
            $('#InCorreoE').css("border", "1px solid red");
        } else {
            $('#InCorreoE').css("border", "");
            $("#cargandoDivAnimacion").show();
            EnviaCorreoInicio();
        }
    });
    $('#AceptarRspuesta').click(function() {
        $('#RetornoServlet').text("");
        $('#InCorreoE').val("");
        $('#FondoEnvCorreo').hide();
        $('#divmarcoEnvCorreo').hide();
        $('#RespuestaServlet').hide();
        $("#cargandoDivAnimacion").hide();
        $('#heleido').hide();
        $("#comprobar").removeAttr("checked");
    });
// MostrarManual();
    $('#subirfoto').change(function(e) {
        addImage(e);
        ValidaImagen();
    });
    function addImage(e) {
        var file = e.target.files[0];
        var imageType = /image.*/;
        if (!file.type.match(imageType)) {
            return;
        }
        var reader = new FileReader();
        reader.onload = fileOnload;
        reader.readAsDataURL(file);
    }
    function fileOnload(e) {
        var result = e.target.result;
        $('#fotografia').attr("src", result);
    }
    $('input.cargafoto').click(function() {
//validar  al subir el archivo
        $('#divmarco').hide();
        $('#div_fondomarco').hide();
        $("#contenido").load("vistas/Aspirante/CargarFoto.jsp");
//        validaImagen();
    });
    $('#subirdespues , #confirmarcarga').click(function() {
        $('#div_marco').hide();
        $('#div_fondomarco').hide();
        $("#contenido").load("/MODULO_ASPIRANTES/vistas/Aspirante/Datos_Socioeconomicos.jsp");
    });
    $('#continuar_socioeconomicos').click(function() {

        if (nonulos_socioeconomicos() === false || nonulos_socioeconomicos() === '') {
//            alert('Complete sus  datos');
        } else {
            $('#fondofinalizado').show();
            $('#finalizado').show();
        }
    });
//    ver  proceso   y ayuda
//    $('#ver_proceso').click( function () {
//       MostrarManual ();
//    });
//     cargar confirmar Datos
    $('#continuar_datos').click(function() {

//Validaciones  de  no  nulos  listas  no  borrar estas  lineas comentadas :D
//        if (nonulos() === false || nonulos() === '' || nonulos === 0) {
////            alert("Aun no han sido completados  todos  sus datos");
//        } else {
        ConfirmaDatos();
        $('#div_fondomarco').show();
        $('#divmarco').show();
//        }
    });
    $('#cancelar').on('click', function() {
        $('#divmarco').hide();
        $('#div_fondomarco').hide();
    });
    $('#confirmar').on('click', function() {
        $('#divmarco').hide();
        $('#div_fondomarco').hide();
        $.get('/MODULO_ASPIRANTE/Socioeconomicos',
                {},
                function(retorno) {
                    $("#contenido").load("/MODULO_ASPIRANTE/vistas/Aspirante/Datos_Socioeconomicos.jsp");
                }
        );
//        $("#contenido").load("vistas/Aspirante/CargarFoto.jsp");
    });
    //carga correcta
    $('#cerrar').on('click', function() {
        $('#content').hide();
    });
    //clic en inicio 
    $('#iniciobtn').on('click', function() {
//        var r = confirm("Seguro?. Los  datos no han sido guardados ");
        var r = true;
        if (r === true) {

        }
    });
    $('#ayudabtn').on('click', function() {
        $('#contenedor').show();
    });
    $('#buscar_clave').on('click', function() {
        $("#cargandoCCT").show();
        var municipio = $('#municipio option:selected').val();
        $("buscar_clave").prop("disabled", true);
        $.get('/MODULO_ASPIRANTE/Servlet_ClaveCCT',
                {municipio: municipio},
        function(retorno) {
            var $ul = $('<tbody id="ListaClave"></tbody>').appendTo($('#tablaCCT'));
            $.each(retorno, function(index, item) {
                var txt = item.Clave;
                var t = item.Nombre;
                var c = txt + "-" + t;
                $('#ListaClave').append("<tr><td><input  type='checkbox' class='CCTs' value='" + item.Clave + "'/></td><td>" + c + "</td></tr><br>");
            });
            $('#FondoSeleccionaClave').show();
            $('#SelecionaClave').show();
            $("#cargandoCCT").hide();
        });
    });
    $('#FondoSeleccionaClave').on('click', function() {
        $('#FondoSeleccionaClave').hide();
        $('#SelecionaClave').hide();
    });
    $('#aceptarCCT').on('click', function() {
        $('#SelecionaClave').hide();
        $('#FondoSeleccionaClave').hide();
        ObtineneCCT();
        $("#cargandoCCT").hide();
    });
    $('#cancelarCCT').on('click', function() {
        $('#SelecionaClave').hide();
        $('#FondoSeleccionaClave').hide();
        $("#cargandoCCT").hide();
    });
    //validar  fecha
    $('#sexo').change(function() {
        evaluar();
    });
    $('#cancelarfinalizado').click(function() {
        $('#fondofinalizado').hide();
        $('#finalizado').hide();
    });
    //solo numeros
//    $("#tel1 , #lada1, #tel2, #lada2, #cp, #tel_fijo, #tel_cel, #tel_trabajo, #numcelular ").keydown(function(event) {
//        if (event.shiftKey)
//        {
//            event.preventDefault();
//        }
//
//        if (event.keyCode === 46 || event.keyCode === 8) {
//        }
//        else {
//            if (event.keyCode < 95) {
//                if (event.keyCode < 48 || event.keyCode > 57) {
//                    event.preventDefault();
//                }
//            }
//            else {
//                if (event.keyCode < 96 || event.keyCode > 105) {
//                    event.preventDefault();
//                }
//            }
//        }
//    });
//otra escuela
    $('#combo_tipoescuela').change(function() {
        var tipo_otra = ObtenerValor('#combo_tipoescuela');
        if (tipo_otra === "20") {
            $('#opcion_otraescuela_aparece').show();
        } else {
            $('#opcion_otraescuela_aparece').hide();
        }

    });
    //tipo beca
    $('#beca').change(function() {
        var beca = $('#beca').val();
        if (beca === 'Si') {
            $('#beca_cual').show();
            ValidaOtraOpcion('#beca_tipo');
        } else {
            $('#beca_cual').hide();
        }
    });
    //otro depende economicamente 
    $('#quiendepende').change(function() {
        var depende = $('#quiendepende').val();
        if (depende === '7') {
            $('#datosbeca').css("height", "430px");
            $('#otroeconomicamente').show();
            $('#otroquiendepende').show();
            ValidaOtraOpcion('#otroquiendepende');
        } else {
            $('#datosbeca').css("height", "");
            $('#otroeconomicamente').hide();
            $('#otroquiendepende').hide();
        }
    });
    //otro vive
    $('#input_habitantes').change(function() {
        var depende = $('#input_habitantes').val();
        if (depende === 'Otro') {
            $('#datosbeca').css("height", "430px");
            $('#socioeconomicos_inferior').css("height", "335px");
            $('#otrovive').show();
            $('#otroviveinput').show();
            ValidaOtraOpcion('#otroviveinput');
        } else {
            $('#datosbeca').css("height", "");
            $('#socioeconomicos_inferior').css("height", "");
            $('#otrovive').hide();
            $('#otroviveinput').hide();
        }
    });
    $('#carreraopcion1').change(function() {
        $('#carreraopcion2').prop("disabled", false);
        Carreras('#carreraopcio1', 1);
    });
    $('#carreraopcion2').change(function() {
        $('#carreraopcion3').prop("disabled", false);
        Carreras('#carreraopcion2', 2);
    });
    $('#carreraopcion3').change(function() {
        Carreras('#carreraopcion3', 3);
    });
    //funcion menu desplegable 

    $("#Menu_desplegable h3").click(function() {
        $("#Menu_desplegable ul ul").slideUp();
        if (!$(this).next().is(":visible"))
        {
            $(this).next().slideDown();
        }
    });
//    $(".tooltip-examples a").tooltip({
//        placement: 'top'
//    });
    //load  de sub-modulo  INICIO

    $('#inicio').click(function() {
        $("#Contenedor_Bienvenido").load("vistas/Inicio/inicio.jsp", function(responseTxt, statusTxt, xhr) {
            $('#grande').css("height", "820px");
        });
    });
    $('#recuperar').click(function() {
        $("#Contenedor_Bienvenido").load("vistas/Inicio/recuperarPreficha.jsp", function(responseTxt, statusTxt, xhr) {
            $('#grande').css("height", "780px");
        });
    });
    $('#seguimiento').click(function() {
        $("#Contenedor_Bienvenido").load("vistas/Inicio/Seguimiento.jsp", function(responseTxt, statusTxt, xhr) {
            $('#grande').css("height", "780px");
        });
    });
    $('#preguntas').click(function() {
        $("#Contenedor_Bienvenido").load("vistas/Inicio/preguntas.jsp", function(responseTxt, statusTxt, xhr) {
            $('#grande').css("height", "1150px");
        });
    });
    $('#ayuda').click(function() {
        $("#Contenedor_Bienvenido").load("vistas/Inicio/ayuda_1.jsp", function(responseTxt, statusTxt, xhr) {
            $('#grande').css("height", "785px");
        });
    });
    $('#contacto').click(function() {
        $("#Contenedor_Bienvenido").load("vistas/Inicio/contacto.jsp", function(responseTxt, statusTxt, xhr) {
            $('#grande').css("height", "780px");
        });
    });
//    $('#sendMail').click(function () {
//        var nombre = $('#txtNombre').val();
////        var nombre = document.getElementById("txtNombre").value;//cambiar  por  $(id).val();
//        var correo = $('#txtEmail').val().index("@");
////        var correo = document.getElementById("txtEmail").value.indexOf("@");
//        var descripcion = $('#txtDescripcion').val();
////        var descripcion = document.getElementById("txtDescripcion").value;
//
//        if (nombre.length == 0) {
//            alert("Es obligatorio indicar un nombre");
//            return false;
//        }
//
//        if (correo == -1) {
//            alert("Dirección de correo electrónico no válida");
//            return false;
//        }
//        if (descripcion.lenght == 0) {
//            alert("Por favor introduzca un mensaje para el administrador");
//            return false;
//        }
//        if (nombre.lenght !== 0 && correo !== -1 && descripcion.lenght !== 0)
//        {
//            $("#Contenedor_Bienvenido").load("contacto.jsp", function (responseTxt, statusTxt, xhr) {
//                //cambiar  por  $(id).val()
////                var frame = document.getElementById('grande')
//                var frame = $('#grande').val();
//                frame.style.height = "100%";
//            });
//        }
//    });
    $("#comprobar").click(function()
    {
        if ($("#comprobar").is(':checked')) {
            $('#heleido').css("display", "block");
        }
        else {
            $('#heleido').css("display", "none");
        }
    });
//    validarMail();
//    curpvalida('#crp');
});
//function validarMail() {
//    var nombre_1 = $('#txtNombre').val();
//    var correo_1 = $('#txtEmail').val().index("@");
//    var descripcion_1 = $('#txtDescripcion').val();
//
//    if (nombre_1.length == 0) {
//        alert("Es obligatorio indicar un nombre");
//        return false;
//    }
//
//    if (correo_1 == -1) {
//        alert("Dirección de correo electrónico no válida");
//        return false;
//    }
//    if (descripcion_1.lenght == 0) {
//        alert("Por favor introduzca un mensaje para el administrador");
//        return false;
//    }
//    if (nombre_1.lenght !== 0 && correo_1 !== -1 && descripcion_1.lenght !== 0)
//    {
//        $("#Contenedor_Bienvenido").load("contacto.jsp", function (responseTxt, statusTxt, xhr) {
//            var frame = document.getElementById('grande')
//            frame.style.height = "100%";
//        });
//    }
//}







function curpvalida() {
    var curp = document.forms['crp'].elements['curp'].value;
    if (curp.match(/^([a-z]{4})([0-9]{6})([a-z]{6})([0-9]{2})$/i)) {//AAAA######AAAAAA##
        alert('curp válida!');
        return false;
    } else {
        alert('curp incorrecta!');
        return false;
    }
}


//
//function curpvalida() {
//    var curp = document.forms['crp'].elements['curp'].value;
//
//    if (curp.match(/^([a-z]{4})([0-9]{6})([a-z]{6})([0-9]{2})$/i)) {//AAAA######AAAAAA##
//        alert('curp válida!');
//        return false;
//    } else {
//        alert('curp incorrecta!');
//        return false;
//    }
//}
//function validaPreficha(field) {
//    var valid = "0123456789-";
//    var hyphencount = 0;
//
//    if (field.length == 10) {
//        lightbox_open();
//        return false;
//    }
//
//    if (field.length != 5 && field.length != 10) {
//        alert("Por favor, inserte un número de 10 dígitos");
//        return false;
//    }
//    for (var i = 0; i < field.length; i++) {
//        temp = "" + field.substring(i, i + 1);
//        if (temp == "-")
//            hyphencount++;
//        if (valid.indexOf(temp) == "-1") {
//            alert("Número no válido.  Por favor, insertelo nuevamente");
//            return false;
//        }
//    }
//}




//EJEMPLO DE  SELECT
function Limpiar(id, c1, c2, c3) {
    $("#carreraopcion option").each(function() {
        $(id).children('option[value=' + $(this).attr('value') + ']').css("display", "block");
    });
    if (c1 !== '--') {
        $('#carreraopcion2').children('option[value=' + c1 + ']').css("display", "none");
        $('#carreraopcion3').children('option[value=' + c1 + ']').css("display", "none");
    }
    if (c2 !== '--') {
        $('#carreraopcion1').children('option[value=' + c2 + ']').css("display", "none");
        $('#carreraopcion3').children('option[value=' + c2 + ']').css("display", "none");
    }
    if (c3 !== '--') {
        $('#carreraopcion1').children('option[value=' + c3 + ']').css("display", "none");
        $('#carreraopcion2').children('option[value=' + c3 + ']').css("display", "none");
    }
}

//metodo  jala  3 valores  y lo quita  en  los  
function Carreras(id, opcion) {
    var carrera1 = $('#carreraopcion1').val();
    var carrera2 = $('#carreraopcion2').val();
    var carrera3 = $('#carreraopcion3').val();
    if (opcion === 1 && carrera1 !== '--') {
        Limpiar("#carreraopcion2", carrera1, carrera2, carrera3);
        Limpiar("#carreraopcion3", carrera1, carrera2, carrera3);
        $("#carreraopcion2").children('option[value=' + carrera1 + ']').css("display", "none");
        $("#carreraopcion3").children('option[value=' + carrera1 + ']').css("display", "none");
    }
    if (opcion === 2 && carrera2 !== '--') {
        Limpiar("#carreraopcion1", carrera1, carrera2, carrera3);
        Limpiar("#carreraopcion3", carrera1, carrera2, carrera3);
        $('#carreraopcion1').children('option[value=' + carrera2 + ']').css("display", "none");
        $('#carreraopcion3').children('option[value=' + carrera2 + ']').css("display", "none");
    }
    if (opcion === 3 && carrera3 !== '--') {
        Limpiar("#carreraopcion1", carrera1, carrera2, carrera3);
        Limpiar("#carreraopcion2", carrera1, carrera2, carrera3);
        $('#carreraopcion1').children('option[value=' + carrera3 + ']').css("display", "none");
        $('#carreraopcion2').children('option[value=' + carrera3 + ']').css("display", "none");
    }


}


function curpvalida(id) {
    $(id).change(function() {
        var curp = $(id).val();
        if (curp.match(/^([a-z]{4})([0-9]{6})([a-z]{6})([0-9]{2})$/i)) {//AAAA######AAAAAA##
            $(id).css("border", "");
            return false;
        } else {
            $(id).css("border", "1px solid red");
            alert('curp incorrecta!');
            return false;
        }
    });
}

function ObtineneCCT() {
    var clave = $('.CCTs:checked').val();
    $('#clavesc').val(clave);
}

function ValidaOtraOpcion(id) {
    $(id).change(function() {
        var valor = $(id).val();
        if (valor === '--Seleccione--' || valor === '--' || valor === 0 || valor === '0' || valor === '') {
            $(id).css("border", "1px solid red");
            alert("Seleccione una opcion");
        } else {
            $(id).css("border", "");
        }
    });
}

//alerta al cerrar  actualizar  la pagina 
window.onbeforeunload = function() {
    return "Los datos no ha sido guardados.";
};
//VALIDACIONES TIEMPO REAL
//valida  numeros
function validar_numeros(id) {
    $(id).change(function() {
        var valor = $(id).val();
        patron_numeros = /^[0-9]+$/;
        if (!patron_numeros.test(valor)) {
            $(id).css("border", "1px solid red");
            alert("Sólo números");
        } else {
            $(id).css("border", "");
        }
    });
}
//validar solo letras 
function validar_letras(id) {
    $(id).change(function() {
        var letras = $("#" + id).val();
        patron_letra = /^[A-Za-z-ñäöüßÄÖÜáéíóúÁÉÍÓÚ ]+$/;
        if (!patron_letra.test(letras)) {
            $(id).css("border", "1px solid red");
            alert("solo texto");
        } else {
            $(id).css("border", "");
        }
    });
}

function validaCorreoElectronico(id) {
    $(id).change(function() {
        var patron = /^([A-z]+[A-z1-9._-]*)@{1}([a-z1-9\.]{2,})\.([a-z]{2,3})$/;
        var email = $(id).val();
        if (!patron.test(email)) {
            $(id).css("border", "1px solid red");
            alert("El correo " + email + " no  tiene el formato especificado"
                    + " ejemplo@smtp.com");
            $(id).val("");
            return false;
        }
        else {
            $(id).css("border", "");
            return true;
        }
    });
}
function validaAlfaNum(id) {
    $(id).change(function() {
        var patron = /^[0-9A-Za-z\s]+$/;
        var txtcurp = $(id).val();
        if (!patron.test(txtcurp)) {
            $(id).css("border", "1px solid red");
            alert("Símbolos no aceptados");
        } else {
            $(id).css("border", "");
        }
    });
}
//AL Continuar
function validaLada(id) {
    $(id).change(function() {
        var lada = ObtenerValor(id);
        if (lada.length < 3) {
            alert("Lada no valida");
            $(id).css("border", "1px solid red");
        } else {
            $(id).css("border", "");
            return true;
        }
    });
}
function ValidaTel(id) {
    $().change(function() {
        var tel = ObtenerValor(id);
        if (tel.length < 7) {
            alert("Telefono no valido");
            $(id).css("border", "1px solid red");
        } else {
            $(id).css("border", "");
            return true;
        }
    });
}
function validaTelfijo(id) {
    $(id).change(function() {
        var lada = ObtenerValor(id);
        if (lada.length < 12) {
            alert("Telefono  fijo no válido");
            $(id).css("border", "1px solid red");
        } else {
            $(id).css("border", "");
            return true;
        }
    });
}
function validaCelLada(id) {
    $(id).change(function() {
        var lada = ObtenerValor(id);
        if (lada.length < 13) {
            alert("Telefono no válido");
            $(id).css("border", "1px solid red");
        } else {
            $(id).css("border", "");
            return true;
        }
    });
}
function Pais(id) {
    $(id).change(function() {
        var pais = $(id).val();
        if (pais === 'MEX') {
            $('#selectedonacimiento').prop("disabled", false);
            $('#combompnacimiento').prop("disabled", false);
            $('#combocdnacimiento').prop("disabled", false);
        } else {
            $('#selectedonacimiento').prop("disabled", true);
            $('#combompnacimiento').prop("disabled", true);
            $('#combocdnacimiento').prop("disabled", true);
        }
    });
}

function ValidaTipos() {
//datos personales
    validaAlfaNum('#inputcurp');
    curpvalida('#inputcurp');
    validar_letras('inputpaterno');
    validar_letras('inputmaterno');
    validaCorreoElectronico('#caja_texto_email');
    validar_letras('inputnombre');
    Pais('#combopaisnacimiento');
    //direccion
//    validar_letras('#dirciudad');
    validaAlfaNum('#dircalle');
    validar_numeros('#cp');
    validar_numeros('#numcelular');
    ValidaTel('#numcelular');
    validar_numeros('#tel2');
    ValidaTel('#tel2');
    validar_numeros('#dirnumext');
    validar_numeros('#dirnumInt');
    //escuela de  procedencia
    validaAlfaNum('#clavesc');
    //datos socieconomicos
    validar_letras('nom_padre');
    validar_letras('nom_madre');
    validar_letras('contacto_emergencia');
    validaAlfaNum('#colonia');
    validaAlfaNum('#calle');
    validaAlfaNum('#ciudad');
    validar_numeros('#tel_fijo');
    validaTelfijo('#tel_fijo');
    validar_numeros('#tel_cel');
    validaCelLada('#tel_cel');
    validaAlfaNum('#cent_trabajo');
    validaAlfaNum('#tel_trabajo');
    validar_letras('beca_tipo');
    validar_letras('otroquiendepende');
    validar_letras('otroviveinput');
}


//validaciones no nulos  continuar
//no nulos  inputs
function  ObtenerValor(id) {
    var novalido = false;
    var valor = $(id).val();
    if (valor === '' || valor === null || valor === undefined || valor === '--Selecione--' || valor === '--' || valor === 0 || valor === '0') {
        $(id).css("border", "1px solid red");
//        alert("retorna: " + novalido);
        return novalido;
    } else {
        $(id).css("border", "");
        return  valor;
    }

}

function personales() {
    var paterno = ObtenerValor('#inputpaterno');
    var materno = ObtenerValor('#inputmaterno');
    var nombre = ObtenerValor('#inputnombre');
    var curp = ObtenerValor("#inputcurp");
    var correo = ObtenerValor('#caja_texto_email');
    var sexo = ObtenerValor('#sexo');
    var edocivil = ObtenerValor('#combo_edo_civil');
    var pais = ObtenerValor('#combopaisnacimiento');
    var capacidad = ObtenerValor('#capacidad_dif');
    var sangre = ObtenerValor('#combo_tipo_sangre');
    var fecha = evaluar();
    if (pais === 'MEX') {
        var municipio = ObtenerValor('#combompnacimiento');
        var ciudad = ObtenerValor('#combocdnacimiento');
        var estado = ObtenerValor('#selectedonacimiento');
        if (nombre !== false && paterno !== false &&
                materno !== false && curp !== false &&
                correo !== false &&
                sexo !== false &&
                edocivil !== false &&
                ciudad !== false &&
                pais !== false && municipio !== false
                && estado !== false &&
                capacidad !== false &&
                sangre !== false && fecha !== false) {
            return  true;
        }
        else {
            alert("complete sus datos personales ya que son importantes para realizar su registro");
            return  false;
        }
    } else {
        if (nombre !== false && paterno !== false &&
                materno !== false && curp !== false &&
                correo !== false &&
                sexo !== false &&
                edocivil !== false &&
                pais !== false &&
                capacidad !== false &&
                sangre !== false && fecha !== false) {
            return  true;
        }
        else {

            alert("complete sus datos personales ya que son importantes para realizar su registro");
            return  false;
        }
    }

}


function direccion() {

    var estado = ObtenerValor('#input_estado');
    var municipio = ObtenerValor('#dirmunicipio');
    var numExt = ObtenerValor('#dirnumext');
//    var numInt = ObtenerValor('#dirnumInt');
    var dirciudad = ObtenerValor('#dirciudad');
    var dcalle = ObtenerValor('#dircalle');
    var dcolonia = ObtenerValor('#dircolonia');
    var codigopostal = ObtenerValor('#cp');
//    var celular = ObtenerValor('#numcelular');
    var fijo = ObtenerValor('#tel2');
    if (estado !== false && dirciudad !== false && dcalle !== false && dcolonia !== false &&
            numExt !== false && municipio !== false && codigopostal !== false
            && fijo !== false) {
        return true;
    } else {
        alert("Es necesario que complete su dirección");
        return false;
    }
}


function escprocedencia() {
    var estado = ObtenerValor('#inputestado');
    var municipio = ObtenerValor('#municipio');
    var tipoescuela = ObtenerValor('#combo_tipoescuela');
    var otraescuela = ObtenerValor('#otraescuela');
    var escuela = ObtenerValor('#escuelaprocedencia');
    var clavescuela = ObtenerValor('#clavesc');
    var mesinicio = ObtenerValor('#mes_inicio');
    var anioinicio = ObtenerValor('#anio_inicio');
    var mesfin = ObtenerValor('#mes_fin');
    var aniofin = ObtenerValor('#anio_fin');
    var promedio = ObtenerValor('#inputpromedio');
    if (tipoescuela === 'Otra') {
        if (estado !== false && municipio !== false && tipoescuela !== false &&
                otraescuela !== false &&
                escuela !== false
                && clavescuela !== false && mesinicio !== false && anioinicio !== false && mesfin !== false && aniofin !== false
                && promedio !== false) {
            return true;
        } else {
            alert("Complete datos de escuela de procedencia");
            return false;
        }
    } else {
        if (estado !== false && municipio !== false && tipoescuela !== false &&
                escuela !== false
                && clavescuela !== false && mesinicio !== false && anioinicio !== false && mesfin !== false && aniofin !== false
                && promedio !== false) {
            return true;
        } else {
            alert("Complete datos de escuela de procedencia");
            return false;
        }
    }
}


function carreradeseada() {
    var carrera1 = ObtenerValor('#carreraopcion1');
    var carrera2 = ObtenerValor('#carreraopcion2');
    var carrera3 = ObtenerValor('#carreraopcion3');
    var curso = ObtenerValor('#propedeuticoSelect');
    if (carrera1 !== false && carrera2 !== false && carrera3 !== false && curso !== false) {
        return true;
    } else {
        alert("Complete las opciones de carrera");
        return false;
    }
}
function nonulos() {

    if (personales() !== false && direccion() !== false
            && escprocedencia() !== false && carreradeseada() !== false
            ) {
        ConfirmaDatos();
        return true;
    } else {
        return false;
    }
}



function checaSelect(id) {
// obtener  cuando se detecte  cambio del valor  
    var valor;
    $(id).change(function() {
        valor = ObtenerValor(id);
    });
    return valor;
}


//Validar  fecha  
function evaluar() {

//obtener  fecha 
    var bandera = true;
    var anio = $("#combo_anio").val();
    var mes = $("#combo_mes").val();
    var dia = $("#combo_dia").val();
    if (anio === '--' || mes === '--' || dia === '--') {

        $('#combo_anio').css("border", "1px solid red");
        $('#combo_mes').css("border", "1px solid red");
        $('#combo_dia').css("border", "1px solid red");
    } else {
//validar  
        if (anio !== false || mes !== false || dia !== false) {
            bandera = true;
            //es distinto  a 0 
            if (dia < 32 && (mes === '1' || mes === '3' || mes === '5' || mes === '7'
                    || mes === '8' || mes === '10' || mes === '12')) {

                bandera = true; //si es mes dia  valido de 31 dias 
            } else {
                if (dia < 31 && (mes === '4' || mes === '6' || mes === '9' || mes === '11')) {
                    bandera = true;
                }// si es mes dia valido
                else {
                    var modulo = anio % 4;
                    //febrero y bisiesto
                    if (dia < 30 && mes === '2' && modulo === 0) {
                        bandera = true;
                    } else {
                        if (dia < 29 && mes === '2') {
                            bandera = true;
                        } else {
                            bandera = false;
                        }
                    }

                }
            }
        }
        else {
            bandera = false;
        }
        if (bandera === false) {
//            alert("La fecha no es valida");
            $('#combo_anio').css("border", "1px solid red");
            $('#combo_mes').css("border", "1px solid red");
            $('#combo_dia').css("border", "1px solid red");
            return  false;
        } else {
            if (bandera === true) {
                $('#combo_anio').css("border", "");
                $('#combo_mes').css("border", "");
                $('#combo_dia').css("border", "");
                return true;
            }
        }
    }

}

function Datos_vive() {
    if ($("#padre_viveSi").is(':checked')) {
        if ($("#madre_viveSi").is(':checked')) {
            if (datos_tutor()) {
                return true;
            } else {
                alert("Complete los datos del tutor, ya que son necesarios para  su registro");
                return false;

            }
        }
        if ($("#madre_viveNo").is(':checked')) {
            if (datos_tutor()) {
                return true;
            } else {
                alert("Complete los datos del tutor, ya que son necesarios para  su registro");
                return false;
            }
        }
    } else {
        if ($("#padre_viveNo").is(':checked')) {
            if ($("#madre_viveSi").is(':checked')) {
                if (datos_tutor()) {
                    return true;
                } else {
                    alert("Complete los datos del tutor, ya que son necesarios para  su registro");
                    return false;
                }
            }
            if ($("#madre_viveNo").is(':checked')) {
                if (datos_tutor()) {
                    return true;
                } else {
                    alert("Complete los datos del tutor, ya que son necesarios para  su registro");
                    return false;
                }
            }
        }
    }
}
function datos_tutor() {
    var padre = ObtenerValor('#nom_padre');
    var madre = ObtenerValor('#nom_madre');
    var contacto_emergencia = ObtenerValor('#contacto_emergencia');
    var ciudad = ObtenerValor('#ciudad');
    var estado = ObtenerValor('#estado');
    var colonia = ObtenerValor('#colonia');
    var calle = ObtenerValor('#calle');
    var tel_fijo = ObtenerValor('#tel_fijo');
    var tel_cel = ObtenerValor('#tel_cel');
    var cent_trabajo = ObtenerValor('#cent_trabajo');
    var tel_trabajo = ObtenerValor('#tel_trabajo');
    var numExt = ObtenerValor('#socionumext');

    if (padre !== false && madre !== false
            && contacto_emergencia !== false && ciudad !== false && estado !== false && colonia !== false
            && calle !== false && tel_fijo !== false && tel_cel !== false && cent_trabajo !== false
            && tel_trabajo !== false && numExt !== false) {
        return  true;
    } else {
        alert("Complete los datos del tutor, ya que son necesarios para  su registro");
        return false;
    }
}

function datos_socioeconomicos() {

    var beca = ObtenerValor('#beca');
    var tipo = ValidaBeca();
//    var beca_tipo = ObtenerValor('#beca_tipo');
    var zona = ObtenerValor('#zona');
    var estudios_padre = ObtenerValor('#estudios_padre');
    var estudios_madre = ObtenerValor('#estudios_madre');
    var ingresos = ObtenerValor('#input_ingresos');
    var ocupacionpadre = ObtenerValor('#input_ocpadre');
    var ocupacionmadre = ObtenerValor('#input_ocmadre');
    var quiendepende = ObtenerValor('#quiendepende');
    var otroquien = ValidaDepende();
//    var otroquien=ObtenerValor('#otroquiendepende'); checar al mostrar :D
    var vivienda = ObtenerValor('#input_vivienda');
    var nopersonas = ObtenerValor('#input_nopersonas');
    var cuartos = ObtenerValor('#input_cuartos');
    var oportunidades = ObtenerValor('#input_oportunidades');
    var habitantes = ObtenerValor('#input_habitantes');
    var otrovive = ValidaOtroVive();
//    var otrovive = ObtenerValor('#otroviveinput');
    var dependientes_sustento = ObtenerValor('#dependientes_sustento');
    if (beca !== false && tipo !== false && zona !== false && estudios_padre !== false && estudios_madre !== false
            && ingresos !== false && ValidaDepende() !== false && ocupacionpadre !== false && ocupacionmadre !== false && quiendepende !== false
            && vivienda !== false && otrovive !== false && nopersonas !== false && cuartos !== false && oportunidades !== false && habitantes !== false
            && dependientes_sustento !== false) {

        return true;
    } else {
        alert("Complete sus datos socieconomicos ya que son importantes para su registro");
        return false;
    }
}

function  ValidaBeca() {
    if ($('#beca').val() === 'Si') {
        if (ObtenerValor('#beca_tipo')) {
            return true;
        } else {
            return false;
        }
    }
    return true;
}
function  ValidaDepende() {
    if ($('#quiendepende').val() === '7') {
        if (ObtenerValor('#otroquiendepende')) {
            return true;
        } else {
            return false;
        }
    }
    return true;
}

function ValidaOtroVive() {
    if ($('#input_habitantes').val() === 'Otro') {
        if (ObtenerValor('#otroviveinput')) {
            return true;
        } else
            return false;
    }
    return  true;
}
function nonulos_socioeconomicos() {

    if (Datos_vive() !== false && datos_socioeconomicos() !== false && datos_tutor() !== false) {

        return true;
    } else {
        return false;
    }
}

function MostrarManual() {
    $(function() {
        var picture = $('#manual_aspirante');
        alert("obtuvo  imagen");
        picture.on('load', function() {
            alert("Funcion  guillotin");
            picture.guillotine({eventOnChange: 'guillotinechange'});
            var data = picture.guillotine('getData');
            for (var key in data) {
                $('#' + key).html(data[key]);
            }
            picture.guillotine('fit');
            $('#fit').click(function() {
                picture.guillotine('fit');
            });
            $('#zoom_in').click(function() {
                alert("btn zoom in ");
                picture.guillotine('zoomIn');
            });
            $('#zoom_out').click(function() {
                picture.guillotine('zoomOut');
            });
            picture.on('guillotinechange', function(ev, data, action) {
                data.scale = parseFloat(data.scale.toFixed(4));
                for (var k in data) {
                    $('#' + k).html(data[k]);
                }
            });
        });
    });
}
//
function ValidaImagen() {

    jQuery.validator.setDefaults({
        debug: true,
        success: "valid"
    });
    $("#formulario").validate({
        rules: {
            field: {
                accept: "image/jpg, image/png",
                maxSize: '1.5m',
                resolution: '3ppp'
            }
        }
    });
    $('#fondocarga').show();
    $('#carga').show();
}

//function  ValidaImage() {
//    var imagen = $('#subirfoto');
//    var foto = imagen.val();
//    var ext = foto.substr(-4, 4);
//    var img = document.createElement("IMG");
//    img.src = $('#subirfoto').val();
//    img.id = "final";
//    setTimeout(1000000000);
//    var tam = $('#final').fileSize;
//    alert(tam);
//    document.appendChild(img);
//    setTimeout("alert(Math.round((document.getElementById('final').fileSize / 1024)*Math.pow(10,2)) / Math.pow(10,2)); ", 1000);
//    alert(img);
//    alert(img.ATTRIBUTE_NODE);
//    var tam = $("#final").fileSize;
//    alert(tam);
//    alert(imagen.fileSize);
//    if(ext!=='.png' || ext!== '.jpg'){
////        if(){}
//       
//    }
//}



function lightbox_open() {
    window.scrollTo(0, 0);
    $('#light').fadeIn(1000);
    $('#fade').fadeIn(1000);
}
function lightbox_close() {
    $('#light').fadeOut(1000);
    $('#fade').fadeOut(1000);
}


window.document.onkeydown = function(e)
{
    if (!e) {
        e = event;
    }
    if (e.keyCode == 27) {
        lightbox_close();
    }
}
function lightbox_open_correo() {
    window.scrollTo(0, 0);
    $('#light_correo').fadeIn(1000);
    $('#fade_correo').fadeIn(1000);
}
function lightbox_close_correo() {
    $('#light_correo').fadeOut(1000);
    $('#fade_correo').fadeOut(1000);
}


window.document.onkeydown = function(e)
{
    if (!e) {
        e = event;
    }
    if (e.keyCode == 27) {
        lightbox_close();
    }
}
function lightbox_open_ayuda() {
    window.scrollTo(0, 0);
    document.getElementById('light_imagen_pop').style.display = 'block';
    document.getElementById('fade_im_pop').style.display = 'block';
}
function lightbox_close_adyuda() {
    document.getElementById('light_imagen_pop').style.display = 'none';
    document.getElementById('fade_im_pop').style.display = 'none';
}
//function iniciar() {
//    var mapOptions = {
//        center: new google.maps.LatLng(19.2563906, -99.5780875),
//        zoom: 15,
//        mapTypeId: google.maps.MapTypeId.ROADMAP};
//    var map = new google.maps.Map(document.getElementById("map"), mapOptions);
//}


function periodo(per) {
    if (per === true)
    {
        closeDialog('popup');
    }
    if (per === false)
    {
        $('#overlay').fadeIn(1000);
        $('#popup').fadeIn(1000);
        if (per === true) {
        }
        if (per === false) {
            $('#popup').animate({'left': '30%'}, 500);
        }
    }
}
function closeDialog(id) {
    $('#overlay').fadeOut(1000);
    $('#popup').fadeOut(1000);
}

function recarga() {
//    document.getElementById('txtCaptcha').value="";
    $('#txtCaptcha').val("");
    
    $('#captcha').attr('src', 'imgCaptcha.png?' + new Date().getTime());
}