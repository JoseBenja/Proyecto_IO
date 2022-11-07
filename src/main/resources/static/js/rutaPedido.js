//javascript.js
$(document).ready(function() {
    verificarToken();
});

function verificarToken() {
    if (localStorage.token == null) {
        window.location.href = '401.html'
    } else {
        let idPed = localStorage.idPedido;
        datosRuta(idPed);
    }
}

//set map options
var myLatLng = { lat: 14.599894343427946, lng: -90.51207648770625 };
var mapOptions = {
    center: myLatLng,
    zoom: 8,
    mapTypeId: google.maps.MapTypeId.ROADMAP
};

//create map
var map = new google.maps.Map(document.getElementById('googleMap'), mapOptions);

//create a DirectionsService object to use the route method and get a result for our request
var directionsService = new google.maps.DirectionsService();

//create a DirectionsRenderer object which we will use to display the route
var directionsDisplay = new google.maps.DirectionsRenderer();

//bind the DirectionsRenderer to the map
directionsDisplay.setMap(map);

var destino;
var dirEspecifica;

//define calcRoute function
function calcRoute() {
    //create request
    var request = {
        origin: myLatLng,
        destination: destino,
        travelMode: google.maps.TravelMode.DRIVING, //WALKING, BYCYCLING, TRANSIT
        unitSystem: google.maps.UnitSystem.IMPERIAL
    }

    //pass the request to the route method
    directionsService.route(request, function (result, status) {
        if (status == google.maps.DirectionsStatus.OK) {

            //Get distance and time
            const output = document.querySelector('#output');
            output.innerHTML = "<div class='alert-info'>Desde: Plaza Fontabella.<br />Hasta: " + destino + ".<br /> Distancia a manejar <i class='fas fa-road'></i> : " + result.routes[0].legs[0].distance.text + ".<br />Duracion del viaje <i class='fas fa-hourglass-start'></i> : " + result.routes[0].legs[0].duration.text + ".</div>";

            //display route
            directionsDisplay.setDirections(result);
        } else {
            //delete route from map
            directionsDisplay.setDirections({ routes: [] });
            //center map in London
            map.setCenter(myLatLng);

            //show error message
            output.innerHTML = "<div class='alert-danger'><i class='fas fa-exclamation-triangle'></i> No se pudo calcular la ruta.</div>";
        }
    });
}

async function datosRuta(idPedido) {
    let datos = {};

    datos.idPedido = idPedido;
    datos.estadoPedido = true;

    const request = await fetch('api/pedidoEspecificoRuta', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    });
    const resultadoBusqueda = await request.json()

    console.log(resultadoBusqueda);
    destino = resultadoBusqueda[0].dirPedido;
    dirEspecifica = resultadoBusqueda[0].dirPedidoEspecifico;

    console.log('Destino: ' + resultadoBusqueda[0].dirPedido + ' Especifica: ' + resultadoBusqueda[0].dirPedidoEspecifico);

    calcRoute();
}