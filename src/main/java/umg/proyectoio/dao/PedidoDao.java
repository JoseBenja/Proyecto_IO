package umg.proyectoio.dao;

import org.springframework.web.bind.annotation.RequestBody;
import umg.proyectoio.models.Pedido;

import java.util.List;

public interface PedidoDao {
    List<Pedido> obtenerBusqueda(Pedido pedido);

    List<Pedido> obtenerpedidoEspecificoRuta(Pedido pedido);

    List<Pedido> listaPedidos(Pedido pedido);

    void agregarPedido(Pedido pedido);

    void eliminarPedido(Pedido pedido);

    void habilitarPedido(Pedido pedido);

}
