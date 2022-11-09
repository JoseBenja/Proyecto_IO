package umg.proyectoio.dao;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import umg.proyectoio.models.Repartidor;
import umg.proyectoio.models.Usuario;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class UsuarioDaoImp implements UsuarioDao{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void registar(Usuario usuario) {
        entityManager.merge(usuario);
    }

    @Override
    public void agregarRepartidor(Repartidor repartidor) {
        entityManager.merge(repartidor);
    }

    @Override
    public Usuario obtenerUsuarioPorCredencial(Usuario usuario) {
        String query = "FROM Usuario WHERE nom_user= :nombreUsuario AND estado_user=true ";
        List<Usuario> lista = entityManager.createQuery(query)
                .setParameter("nombreUsuario", usuario.getNombreUsuario())
                .getResultList();

        if(lista.isEmpty()) {
            return null;
        }

        String passwordHashed = lista.get(0).getPassword();

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);

        if(argon2.verify(passwordHashed, usuario.getPassword())){
            return lista.get(0);
        }
        return null;
    }
}
