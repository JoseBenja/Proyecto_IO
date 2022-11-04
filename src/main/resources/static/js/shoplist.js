$(document).ready(function() {
    busquedaProducto();
});

async function busquedaProducto() {
    let datos = {};
    let totalPagar = document.getElementById("cantidadTotalPagar");
    let sumaTotal = 0;
    let pagar;

    datos.estadoShoplist = true;

    const request = await fetch('api/listarShopList', {
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
        let resultadoHtml = '<tr><td>' + resultado.nombreProducto
            + '</td><td> Q ' + resultado.precioProducto;

        resultadoBusquedaHtml += resultadoHtml;

        sumaTotal += resultado.precioProducto;
    }

    document.querySelector('#cantidadTotalPagar').outerHTML = 'Total a pagar: Q ' +sumaTotal.toString();

    document.querySelector("#shoplistTable tbody").outerHTML = resultadoBusquedaHtml;
}