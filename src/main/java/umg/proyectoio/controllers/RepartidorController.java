package umg.proyectoio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
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
        List<Repartidor> repDisponible = repartidorDao.agregarPedidoRepartidor();
        return repDisponible.get(0);
    }
}
