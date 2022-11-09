$(document).ready(function() {
    verificarToken();
});

function verificarToken() {
    if (localStorage.token == null && localStorage.rol !== 'Administrador') {
        window.location.href = '401.html'
    }
}