package umg.proyectoio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import umg.proyectoio.dao.UsuarioDao;
import umg.proyectoio.models.Usuario;
import umg.proyectoio.utils.JWTUtil;

@RestController
public class AuthController {
    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/login", method = RequestMethod.POST)
    public String login(@RequestBody Usuario usuario) {

        Usuario usuarioLogged = usuarioDao.obtenerUsuarioPorCredencial(usuario);
        if (usuarioLogged != null) {
            return jwtUtil.create(String.valueOf(usuarioLogged.getIdUsuario()), usuarioLogged.getNombreUsuario());
        }

        return "Fail";
    }

    @RequestMapping(value = "api/verificarRol", method = RequestMethod.POST)
    public String verificarRol(@RequestBody Usuario usuario) {

        Usuario usuarioLogged = usuarioDao.obtenerUsuarioPorCredencial(usuario);
        if (usuarioLogged != null) {
            return usuarioLogged.getRol();
        }

        return "Fail";
    }

    @RequestMapping(value = "api/validacion", method = RequestMethod.GET)
    public String validacion(@RequestBody String tokenJWT) {
        if (tokenJWT != null) {
            return "Autorizado";
        }
        return "Rechazado";
    }
}

