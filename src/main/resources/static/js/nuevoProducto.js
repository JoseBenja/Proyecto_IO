$(document).ready(function() {
    verificarToken()
});

function verificarToken() {
    if (localStorage.token == null) {
        window.location.href = '401.html'
    }
}

async function agregarProducto() {
    let datos = {};

    datos.nombreProducto = document.getElementById('txtNombre').value;
    datos.descProducto = document.getElementById('txtDescripcion').value;
    datos.precioProducto = document.getElementById('txtPrecio').value;
    datos.estadoProducto = true;

    await fetch('api/agregarProducto', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    });

    alert('Producto agregado')
    window.location.href = 'menuAdmin.html';
}
