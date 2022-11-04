var coords = '4A Avenida 12-59, Zona 10, Ciudad de Guatemala, Guatemala';
var mapOptions = {
    center: coords,
    zoom: zoom,
    mapyTypeId: google.maps.MapTypeId.ROADMAP
};

var map = new google.maps.Map(document.getElementById("googleMap"), mapOptions);

var coordDestino;

var directionsService = new google.maps.DirectionsService();

var directionsDisplay = new google.maps.DirectionsRenderer();

directionsDisplay.setMap(map);

function calcularRuta() {
    var request = {
        origin: coords,
        destination: resultado.dirPedido,
        travelMode: google.maps.TravelMode.DRIVING,
        unitSystem: google.maps.UnitSystem.IMPERIAL
    }

    directionsService.route(request, (result, status) => {
        if (status == google.maps.DirectionsStatus.OK) {
            const output = document.querySelector("#output");
            output.innerHTML = "<div class='aler-info'> De: " + document.getElementById(coords).value +
                "<br /> A: " + coordDestino;

            directionsDisplay.setDirections(result);
        }
    });
}