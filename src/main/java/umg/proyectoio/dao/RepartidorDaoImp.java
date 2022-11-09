package umg.proyectoio.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import umg.proyectoio.models.Pedido;
import umg.proyectoio.models.Repartidor;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class RepartidorDaoImp implements RepartidorDao{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Repartidor> agregarPedidoRepartidor() {
        String query = "FROM Repartidor WHERE estado_rep=true";

        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<Pedido> cantidadPedPep(String nombreRep) {
        String query = "FROM Pedido WHERE nom_rep='" + nombreRep + "' AND estado_ped=true";

        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<Repartidor> filtroUsuarioLista(Repartidor repartidor) {
        String query = "FROM Repartidor WHERE nombre_usuario='" + repartidor.getNombreUsuarioRep() + "' AND estado_rep=true";

        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<Repartidor> listarRepartidores(Repartidor repartidor) {
        String query = "FROM Repartidor WHERE estado_rep=true";

        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void eliminarRepartidor(Repartidor repartidor) {
        //Elimina en la tabla repartidor
        Query query = entityManager.createQuery("update Repartidor set estado_rep=false where nombre_usuario='" + repartidor.getNombreUsuarioRep() + "'");
        query.executeUpdate();

        //Elimina en la tabla usuario
        Query query2 = entityManager.createQuery("update Usuario set estado_user=false where nom_user='" + repartidor.getNombreUsuarioRep() + "'");
        query2.executeUpdate();
    }
}
