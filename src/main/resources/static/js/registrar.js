$(document).ready(function() {
});

async function registrarUsuario() {
    let datos = {};

    datos.nombreUsuario = document.getElementById('txtNomUser').value;
    datos.rol = document.getElementById('txtRol').value;
    datos.password = document.getElementById('txtPassword').value;
    datos.estado = true;

    console.log(datos);

    await fetch('api/registrar', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    });

    alert("La cuenta fue creada con exito");
    window.location.href = 'index.html';
}