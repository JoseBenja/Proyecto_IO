package umg.proyectoio.dao;

import umg.proyectoio.models.Producto;
import umg.proyectoio.models.ShopList;

import java.util.List;

public interface ProductoDao {

    void agregarProducto(Producto producto);

    void agregarShopList(ShopList shopList);

    void eliminarShopList(ShopList shopList);

    void eliminarShopListCompleta();

    void eliminarProducto(Producto producto);

    List<Producto> obtenerBusqueda(Producto producto);

    List<ShopList> obtenerShopList(ShopList shopList);
}
