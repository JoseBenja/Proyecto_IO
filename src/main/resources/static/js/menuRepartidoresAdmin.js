$(document).ready(function() {
    verificarToken();
});

function verificarToken() {
    if (localStorage.token == null && localStorage.usuario !== 'Administrador') {
        window.location.href = '401.html'
    } else {
        busquedaRepartidorAdmin();
    }
}

async function busquedaRepartidorAdmin() {
    let datos = {};

    datos.estadoRep = true;

    const request = await fetch('api/listarRepartidores', {
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
        let resultadoHtml = `<tr><td>` + resultado.nombreRep
            + `</td><td>` + resultado.nombreUsuarioRep
            + `</td><td>` + resultado.estadoRep
            + `</td><td> <a class="btn btn-lg btn-block btn btn-danger" onclick="eliminarRepartidor('` + resultado.nombreUsuarioRep + `')">Eliminar</a>`;

        resultadoBusquedaHtml += resultadoHtml;
    }

    document.querySelector("#repartidorTable tbody").outerHTML = resultadoBusquedaHtml;
}

async function eliminarRepartidor(usuarioRep) {
    let datos = {};

    datos.nombreUsuarioRep = usuarioRep;

    await fetch('api/eliminarRepartidor', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    });

    alert('Repartidor eliminado')
    window.location.href = "menuRepartidoresAdmin.html";
}