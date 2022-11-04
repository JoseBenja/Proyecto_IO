$(document).ready(function() {
    busquedaProducto();
});

async function busquedaProducto() {
    let datos = {};

    datos.estadoProducto = true;

    const request = await fetch('api/listarProducto', {
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
        let resultadoHtml = '<tr><td>' + resultado.nombreProducto
            + '</td><td>' + resultado.descProducto
            + '</td><td> Q ' + resultado.precioProducto
            + '</td><td> <a class="btn btn-lg btn-block btn btn-success" onclick="agregarShopList()">Agregar al carrito</a>';

        resultadoBusquedaHtml += resultadoHtml;
    }

    document.querySelector("#tiendaTable tbody").outerHTML = resultadoBusquedaHtml;
}


async function agregarShopList(nombreProd, precioProd) {
    let datos2 = {};

    datos2.nombreProducto = nombreProd;
    datos2.precioProducto = precioProd;
    datos2.estadoShoplist = true;

    console.log('datos ', datos2);
    await fetch('api/agregarShopList', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos2)
    });
    alert('Producto agregado a la ShopList');
}



