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

    @RequestMapping(value = "api/listaPedidos", method = RequestMethod.POST)
    public List<Pedido> buscarPedidoLista(@RequestBody Pedido pedido){
        return pedidoDao.obtenerBusqueda(pedido);
    }

    @RequestMapping(value = "api/pedidoEspecificoRuta", method = RequestMethod.POST)
    public List<Pedido> pedidoEspecificoRuta(@RequestBody Pedido pedido){
        return pedidoDao.obtenerpedidoEspecificoRuta(pedido);
    }

    /*public void Solver(String[] args) {
        double a = Double.parseDouble(args[0]);
        double b = Double.parseDouble(args[1]);
        double c = Double.parseDouble(args[2]);
        double d = Double.parseDouble(args[3]);

        // solution metodo 1
        double y1 = (d - c/a) / (b - 1/a);
        double x1 = (c - y1) / a;
        StdOut.println(x1 + ", " + y1);

        // solution metodo 2
        double y2 = (c - a*d) / (1 - a*b);
        double x2 = d - b*y2;
        StdOut.println(x2 + ", " + y2);
    }*/
}
