/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


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