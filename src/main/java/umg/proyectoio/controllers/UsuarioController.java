package umg.proyectoio.controllers;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import umg.proyectoio.dao.UsuarioDao;
import umg.proyectoio.models.Repartidor;
import umg.proyectoio.models.Usuario;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioDao usuarioDao;

    @RequestMapping(value = "api/registrar", method = RequestMethod.POST)
    public void registar(@RequestBody Usuario usuario) {

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1, 1024, 1, usuario.getPassword());
        usuario.setPassword(hash);

        usuarioDao.registar(usuario);
    }

    @RequestMapping(value = "api/agregarRepartidor", method = RequestMethod.POST)
    public void agregarRepartidor(@RequestBody Repartidor repartidor) {
        usuarioDao.agregarRepartidor(repartidor);
    }
}
