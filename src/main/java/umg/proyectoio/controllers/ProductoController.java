package umg.proyectoio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import umg.proyectoio.dao.ProductoDao;
import umg.proyectoio.models.Producto;
import umg.proyectoio.models.ShopList;

import java.util.List;

@RestController
public class ProductoController {

    @Autowired
    private ProductoDao productoDao;

    @RequestMapping(value = "api/agregarProducto", method = RequestMethod.POST)
    public void agregarProducto(@RequestBody Producto producto){
        productoDao.agregarProducto(producto);
    }

    //Consume el API de menuTienda.js que se encarga de listar los productos activos existentes
    @RequestMapping(value = "api/listarProducto", method = RequestMethod.POST)
    public List<Producto> listaProducto(@RequestBody Producto producto){
        return productoDao.obtenerBusqueda(producto);
    }

    //Consume el API de menuTienda.js que se encarga de agregar nuevos productos a la shoplist
    @RequestMapping(value = "api/agregarShopList", method = RequestMethod.POST)
    public void agregarShopList(@RequestBody ShopList shopList){
        productoDao.agregarShopList(shopList);
    }

    //Consume el API de shoplist.js que se encarga de devolver una lista de los productos agregados en la shoplist
    @RequestMapping(value = "api/listarShopList", method = RequestMethod.POST)
    public List<ShopList> listarShopList(@RequestBody ShopList shopList){
        return productoDao.obtenerShopList(shopList);
    }

    @RequestMapping(value = "api/eliminarShopList", method = RequestMethod.POST)
    public void eliminarShopList(@RequestBody ShopList shopList){
        productoDao.eliminarShopList(shopList);
    }
}
