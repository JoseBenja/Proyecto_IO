package umg.proyectoio.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import umg.proyectoio.models.Pedido;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class PedidoDaoImp implements PedidoDao{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Pedido> obtenerBusqueda(Pedido pedido) {
        String query = "FROM Pedido WHERE nom_rep='" + pedido.getNombreRepartidor() + "' AND estado_ped=" + pedido.isEstadoPedido() + " AND cantidad_ped > 0";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<Pedido> obtenerpedidoEspecificoRuta(Pedido pedido) {
        String query = "FROM Pedido WHERE id_ped=" + pedido.getIdPedido() + " AND estado_ped=" + pedido.isEstadoPedido();
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void agregarPedido(Pedido pedido) {
        entityManager.merge(pedido);
    }

    @Override
    public List<Pedido> listaPedidos(Pedido pedido) {
        String query = "FROM Pedido WHERE cantidad_ped > 0";
        return entityManager.createQuery(query).getResultList();
    }
}
