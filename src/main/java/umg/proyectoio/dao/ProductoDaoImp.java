package umg.proyectoio.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import umg.proyectoio.models.Producto;
import umg.proyectoio.models.ShopList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class ProductoDaoImp implements ProductoDao{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void agregarProducto(Producto producto) {
        entityManager.merge(producto);
    }

    @Override
    public void agregarShopList(ShopList shopList) {
        entityManager.merge(shopList);
    }

    @Override
    public List<Producto> obtenerBusqueda(Producto producto) {
        String query = "FROM Producto WHERE estado_prod=" + producto.isEstadoProducto();
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<ShopList> obtenerShopList(ShopList shopList) {
        String query = "FROM ShopList WHERE estado_shoplist=" + shopList.isEstadoShoplist();
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void eliminarShopList(ShopList shopList) {
        entityManager.remove(entityManager.contains(shopList) ? shopList: entityManager.merge(shopList));
    }
}
