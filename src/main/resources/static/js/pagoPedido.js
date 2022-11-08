// Call the dataTables jQuery plugin
$(document).ready(function() {
});

async function pagoPedido() {
    let datos = {};

    const request = await fetch('api/buscarRepartidorDisponible', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
    });

    let resultadoBusqueda = await request.json()

    datos.dirPedido = document.getElementById('txtDireccion').value;
    datos.nombreRepartidor = resultadoBusqueda.nombreRep;
    datos.nitClientePedido = document.getElementById('txtNIT').value;
    datos.dirPedidoEspecifico = document.getElementById("txtDirEspecifica").value;
    datos.correoClientePedido = document.getElementById('txtEmail').value;
    datos.estadoPedido = true;
    datos.cantidadPedido = parseInt(localStorage.prodComprados);

    await fetch('api/pedido', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(datos)
    });

    alert('Compra realizada con exito')
    window.location.href = 'shoplist.html';
}