package umg.proyectoio.dao;

import umg.proyectoio.models.Pedido;

import java.util.List;

public interface PedidoDao {
    List<Pedido> obtenerBusqueda(Pedido pedido);

    List<Pedido> obtenerpedidoEspecificoRuta(Pedido pedido);

    void agregarPedido(Pedido pedido);
}
