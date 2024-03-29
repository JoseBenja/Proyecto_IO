package umg.proyectoio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import umg.proyectoio.dao.RepartidorDao;
import umg.proyectoio.models.Pedido;
import umg.proyectoio.models.Repartidor;

import java.util.List;

@RestController
public class RepartidorController {

    @Autowired
    private RepartidorDao repartidorDao;

    @RequestMapping(value = "api/buscarRepartidorDisponible", method = RequestMethod.POST)
    public Repartidor agregarPedidoRepartidor(){
        List<Repartidor> repartidoresLista = repartidorDao.agregarPedidoRepartidor();

        for (int i = 0; i < repartidoresLista.size(); i++) {
            List<Pedido> listaPedidos = repartidorDao.cantidadPedPep(repartidoresLista.get(i).getNombreRep());
            if (listaPedidos.size() < 7 ) {
                return repartidoresLista.get(i);
            }
        }
        return null;
    }

    @RequestMapping(value = "api/filtroUsuarioLista", method = RequestMethod.POST)
    public Repartidor filtroUsuarioLista(@RequestBody Repartidor repartidor) {
        List<Repartidor> repartidorList = repartidorDao.filtroUsuarioLista(repartidor);
        return repartidorList.get(0);
    }

    @RequestMapping(value = "api/eliminarRepartidor", method = RequestMethod.POST)
    public void eliminarRepartidor(@RequestBody Repartidor repartidor) {
        repartidorDao.eliminarRepartidor(repartidor);
    }

    @RequestMapping(value = "api/listarRepartidores", method = RequestMethod.POST)
    public List<Repartidor> listarRepartidores(Repartidor repartidor) {
        return repartidorDao.listarRepartidores(repartidor);
    }
}
