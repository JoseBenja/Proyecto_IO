$(document).ready(function() {
    verificarToken();
});

function verificarToken() {
    if (localStorage.token == null) {
        window.location.href = '401.html'
    }
}

async function registrarRepartidor() {
    let datosRepartidor = {};
    let datosCuenta = {};

    let nombreRepartidor = document.getElementById('txtNombre').value;
    let apellidoRepartidor = document.getElementById('txtApellido').value;
    datosRepartidor.nombreRep = nombreRepartidor + ' ' + apellidoRepartidor;
    datosRepartidor.disponibleRep = true;
    datosRepartidor.estadoRep = true;
    datosRepartidor.capacidadRep = 20;
    datosRepartidor.nombreUsuarioRep = document.getElementById('txtNomUser').value;

    datosCuenta.nombreUsuario = document.getElementById('txtNomUser').value;
    datosCuenta.rol = 'Repartidor';
    datosCuenta.password = document.getElementById('txtPassword').value;
    datosCuenta.estado = true;

    await fetch('api/agregarRepartidor', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datosRepartidor)
    });

    await fetch('api/registrar', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datosCuenta)
    });

    alert('Repartidor agregado');
    window.location.href = "menuAdmin.html";
}