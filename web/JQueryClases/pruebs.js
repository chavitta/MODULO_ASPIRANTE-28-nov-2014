/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function() {
    var usuario = "desarrollo";
    var pass = "d3s4rr0ll0";
    $.ajax({
        type: 'POST',
        async: true,
        url: '/MODULO_ASPIRANTE/ServletCatalogos',
        data: {usuario: usuario, pass: pass},
        success: function(data) {
            alert("Success"+data);

        }
    });
});