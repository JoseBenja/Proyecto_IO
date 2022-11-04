package umg.proyectoio.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import umg.proyectoio.models.Repartidor;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class RepartidorDaoImp implements RepartidorDao{

    @PersistenceContext
    EntityManager entityManager;

    public List<Repartidor> agregarPedidoRepartidor() {
        String query = "FROM Repartidor WHERE disponible=true AND estado_rep=true";

        return entityManager.createQuery(query).getResultList();
    }
}
