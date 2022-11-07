$(document).ready(function() {
    verificarToken();
});

function verificarToken() {
    if (localStorage.token == null) {
        window.location.href = '401.html'
    } else {
        busquedaVentas();
    }
}

async function busquedaVentas() {
    let datos = {};

    datos.estadoPedido = true;

    const request = await fetch('api/listaPedidos', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    });
    const resultadoBusqueda = await request.json()

    let resultadoBusquedaHtml = '';

    for (let resultado of resultadoBusqueda) {
        //Tabla
        let resultadoHtml = '<tr><td>' + resultado.nombreRepartidor
            + '</td><td>' + resultado.nitClientePedido
            + '</td><td>' + resultado.idPedido
            + '</td><td>' + resultado.dirPedido
            + '</td><td>' + resultado.estadoPedido;

        resultadoBusquedaHtml += resultadoHtml;
    }

    document.querySelector("#ventasTable tbody").outerHTML = resultadoBusquedaHtml;
}



