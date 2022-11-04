$(document).ready(function() {
});

async function registrarRepartidor() {
    let datosRepartidor = {};
    let datosCuenta = {};

    let nombreRepartidor = document.getElementById('txtNombre').value;
    let apellidoRepartidor = document.getElementById('txtApellido').value;
    let nombreApellidoRepartidor = nombreRepartidor + ' ' + apellidoRepartidor;

    datosRepartidor.nombreRep = nombreApellidoRepartidor;
    datosRepartidor.disponibleRep = true;
    datosRepartidor.estadoRep = true;

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
}