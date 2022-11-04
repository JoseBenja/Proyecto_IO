$(document).ready(function() {
});

async function iniciarSesion() {
    let datos = {};
    datos.nombreUsuario = document.getElementById('txtUser').value;
    datos.password = document.getElementById('txtPassword').value;

    const request = await fetch('api/login', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    });
    const respuesta = await request.text()

    const requestRol = await fetch('api/verificarRol', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    });
    const respuestaRol = await requestRol.text()

    if(respuesta != 'Fail') {
        localStorage.token = respuesta;
        localStorage.usuario = datos.nombreUsuario;

        if(respuestaRol == 'Administrador') {
            window.location.href = 'menuAdmin.html'
        } else if(respuestaRol == 'Repartidor'){
            window.location.href = 'menuRepartidor.html'
            busquedaSolicitud();
        } else {
            alert("El usuario ingresado no tiene acceso a una cuenta")
        }
    } else {
        alert("El nombre de usuario o contraseña es incorrecto")
    }
}