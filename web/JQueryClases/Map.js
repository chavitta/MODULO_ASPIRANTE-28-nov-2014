/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//$(document).ready(function () {
//    $(".tooltip-examples a").tooltip({
//        placement: 'top'
//    });
//});

function iniciar() {
    var mapOptions = {
        center: new google.maps.LatLng(19.2563906, -99.5780875),
        zoom: 15,
        mapTypeId: google.maps.MapTypeId.ROADMAP};
    var map = new google.maps.Map(document.getElementById("map"), mapOptions);
}
