$(document).ready(function() {
    verificarToken();
});

function verificarToken() {
    if (localStorage.token == null && localStorage.usuario !== 'Administrador') {
        window.location.href = '401.html'
    } else {
        busquedaProductoAdmin();
    }
}

async function busquedaProductoAdmin() {
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
        let resultadoHtml = `<tr><td>` + resultado.nombreProducto
            + `</td><td>` + resultado.descProducto
            + `</td><td> Q ` + resultado.precioProducto
            + `</td><td> <a class="btn btn-lg btn-block btn btn-danger" onclick="eliminarProducto('` + resultado.idProducto + `')">Eliminar</a>`;

        resultadoBusquedaHtml += resultadoHtml;
    }

    document.querySelector("#productoTable tbody").outerHTML = resultadoBusquedaHtml;
}

async function eliminarProducto(idProd) {
    let datos = {};

    datos.idProducto = idProd;

    await fetch('api/eliminarProducto', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    });

    alert('Producto eliminado')
    window.location.href = "menuProductoAdmin.html";
}