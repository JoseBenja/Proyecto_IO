$(document).ready(function() {
    verificarToken();
});

function verificarToken() {
    if (localStorage.token == null) {
        window.location.href = '401.html'
    } else {
        busquedaSolicitud();
    }
}

async function busquedaSolicitud() {
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
        let resultadoHtml = '<tr><td>' + resultado.nitClientePedido
            + '</td><td>' + resultado.idPedido
            + '</td><td> <a class="btn btn-info btn-lg" href="rutaPedido.html" onclick="localIdPed(`' + resultado.idPedido + '`)">Ver Ruta</a>'
            + '</td><td>' + resultado.estadoPedido;
        resultadoBusquedaHtml += resultadoHtml;
    }

    document.querySelector("#entregasTable tbody").outerHTML = resultadoBusquedaHtml;
}


async function localIdPed(idPed) {
    localStorage.idPedido = idPed;
}


