$(document).ready(function() {
    verificarToken();
});

function verificarToken() {
    if (localStorage.token == null && localStorage.usuario !== 'Administrador') {
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
            + '</td><td>' + resultado.estadoPedido
            + '</td><td> <a class="btn btn-lg btn-block btn btn-danger" onclick="eliminarPedidoAdmin(`' + resultado.idPedido + '`)">Eliminar</a>'
            + '<a class="btn btn-lg btn-block btn btn-success" onclick="habilitarPedido(`' + resultado.idPedido + '`)">Habilitar</a>';


        resultadoBusquedaHtml += resultadoHtml;
    }

    document.querySelector("#ventasTable tbody").outerHTML = resultadoBusquedaHtml;
}

async function habilitarPedido(idPed) {
    let datos = {};

    datos.idPedido = idPed;

    await fetch('api/habilitarPedido', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    });

    alert('Pedido habilitado')
    window.location.href = "menuVentasAdmin.html";
}

async function eliminarPedidoAdmin(idPed) {
    let datos = {};

    datos.idPedido = idPed;

    await fetch('api/eliminarPedido', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    });

    alert('Pedido eliminado')
    window.location.href = "menuVentasAdmin.html";
}


