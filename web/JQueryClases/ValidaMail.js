function validarMail() {
    var nombre = document.getElementById("txtNombre").value;
    var correo = document.getElementById("txtEmail").value.indexOf("@");
    var descripcion = document.getElementById("txtDescripcion").value;

    if (nombre.length == 0) {
        alert("Es obligatorio indicar un nombre");
        return false;
    }

    if (correo == -1) {
        alert("Dirección de correo electrónico no válida");
        return false;
    }
    if (descripcion.lenght == 0) {
        alert("Por favor introduzca un mensaje para el administrador");
        return false;
    }
    if (nombre.lenght !== 0 && correo !== -1 && descripcion.lenght !== 0)
    {
        $("#Contenedor_Bienvenido").load("contacto.jsp", function(responseTxt, statusTxt, xhr) {
            var frame = document.getElementById('grande')
            frame.style.height = "100%";
        });
    }
}