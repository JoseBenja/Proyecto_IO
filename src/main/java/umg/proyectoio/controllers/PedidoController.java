package umg.proyectoio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import umg.proyectoio.dao.PedidoDao;
import umg.proyectoio.models.Pedido;

import java.util.List;

@RestController
public class PedidoController {

    @Autowired
    private PedidoDao pedidoDao;

    @RequestMapping(value = "api/pedido", method = RequestMethod.POST)
    public void agregarPedido(@RequestBody Pedido pedido) {
        pedidoDao.agregarPedido(pedido);
    }

    @RequestMapping(value = "api/listaPedidosRepartidorEsp", method = RequestMethod.POST)
    public List<Pedido> buscarPedidoListaRepEsp(@RequestBody Pedido pedido){
        return pedidoDao.obtenerBusqueda(pedido);
    }

    @RequestMapping(value = "api/pedidoEspecificoRuta", method = RequestMethod.POST)
    public List<Pedido> pedidoEspecificoRuta(@RequestBody Pedido pedido){
        return pedidoDao.obtenerpedidoEspecificoRuta(pedido);
    }

    @RequestMapping(value = "api/listaPedidos", method = RequestMethod.POST)
    public List<Pedido> buscarPedidoLista(@RequestBody Pedido pedido){
        return pedidoDao.listaPedidos(pedido);
    }
}
