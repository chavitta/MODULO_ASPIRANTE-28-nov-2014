/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function getUrlParameter(sParam)
{
    var sPageURL = window.location.search.substring(1);
    var sURLVariables = sPageURL.split('&');
    for (var i = 0; i < sURLVariables.length; i++) 
    {
        var sParameterName = sURLVariables[i].split('=');
        if (sParameterName[0] === sParam) 
        {
            return sParameterName[1];
        }
    }
};
$(document).ready(function (){
    
    
    var correo = getUrlParameter('correo');
   $.get('DesencriptaCorreo',
            {correo: correo},
    function(data) {
        //agregar  al div  la leyenda que retorna el servlet
        $('#caja_texto_email').val(data);
        
    }
    );
});

