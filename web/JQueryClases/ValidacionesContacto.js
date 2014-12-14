function iniciar() {
    var mapOptions = {
        center: new google.maps.LatLng(19.2563906, -99.5780875),
        zoom: 15,
        mapTypeId: google.maps.MapTypeId.ROADMAP};
    var map = new google.maps.Map(document.getElementById("map"), mapOptions);
}