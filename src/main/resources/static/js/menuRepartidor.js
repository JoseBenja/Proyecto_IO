$(document).ready(function() {
    busquedaSolicitud();
});

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
            + '</td><td>' + resultado.dirPedido
            + '</td><td>' + resultado.estadoPedido;

        resultadoBusquedaHtml += resultadoHtml;
    }

    document.querySelector("#entregasTable tbody").outerHTML = resultadoBusquedaHtml;
}



