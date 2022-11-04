package umg.proyectoio.dao;

import umg.proyectoio.models.Producto;
import umg.proyectoio.models.ShopList;

import java.util.List;

public interface ProductoDao {

    void agregarShopList(ShopList shopList);

    List<Producto> obtenerBusqueda(Producto producto);

    List<ShopList> obtenerShopList(ShopList shopList);
}
