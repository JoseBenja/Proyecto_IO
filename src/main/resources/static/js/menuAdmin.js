$(document).ready(function() {
    verificarToken();
});

function verificarToken() {
    if (localStorage.token == null) {
        window.location.href = '401.html'
    }
}