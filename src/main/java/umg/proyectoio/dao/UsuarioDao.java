package umg.proyectoio.dao;

import umg.proyectoio.models.Repartidor;
import umg.proyectoio.models.Usuario;

public interface UsuarioDao {
    void registar(Usuario usuario);

    void agregarRepartidor(Repartidor repartidor);

    Usuario obtenerUsuarioPorCredencial(Usuario usuario);
}
