$(document).ready(function() {
    busquedaProducto();
});

async function busquedaProducto() {
    let datos = {};
    let sumaTotal = 0;

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
        let resultadoHtml = `<tr><td>` + resultado.nombreProducto
            + `</td><td> Q ` + resultado.precioProducto
            + `</td><td> <a class="btn btn-lg btn-block btn btn-danger" onclick="eliminarShopList('` + resultado.idProdShopList + `')">Eliminar al carrito</a>`;

        resultadoBusquedaHtml += resultadoHtml;

        sumaTotal += resultado.precioProducto;
    }

    document.querySelector('#cantidadTotalPagar').outerHTML = 'Total a pagar: Q ' +sumaTotal.toString();

    document.querySelector("#shoplistTable tbody").outerHTML = resultadoBusquedaHtml;
}

async function eliminarShopList(idProd) {
    let datos2 = {};

    datos2.idProdShopList = idProd;

    console.log('Datos ', datos2);

    await fetch('api/eliminarShopList', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos2)
    });
    alert('El producto se elimino su ShopList');
    window.location.href = "shoplist.html";
}