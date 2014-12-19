/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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


