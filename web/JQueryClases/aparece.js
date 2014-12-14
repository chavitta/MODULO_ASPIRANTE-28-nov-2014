/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function(){
    $("#comprobar").click(function ()
    {
        if($("#comprobar").is(':checked')){
            document.getElementById('heleido').style.display='block';
        }
        else {
                document.getElementById('heleido').style.display='none';
        }
    });
});
