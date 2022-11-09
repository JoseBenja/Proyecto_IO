package umg.proyectoio.dao;

import umg.proyectoio.models.Pedido;
import umg.proyectoio.models.Repartidor;

import java.util.List;

public interface RepartidorDao {

    void eliminarRepartidor(Repartidor repartidor);

    List<Repartidor> agregarPedidoRepartidor();

    List<Pedido> cantidadPedPep(String nombreRep);

    List<Repartidor> filtroUsuarioLista(Repartidor repartidor);

    List<Repartidor> listarRepartidores(Repartidor repartidor);
}
