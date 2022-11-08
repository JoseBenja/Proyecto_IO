package umg.proyectoio.dao;

import umg.proyectoio.models.Pedido;
import umg.proyectoio.models.Repartidor;

import java.util.List;

public interface RepartidorDao {
    List<Repartidor> agregarPedidoRepartidor();

    List<Pedido> cantidadPedPep(String nombreRep);
}
