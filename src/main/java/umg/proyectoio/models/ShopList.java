package umg.proyectoio.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="producto_shoplist")
public class ShopList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id_prod_shoplist")
    private int idProdShopList;

    @Getter @Setter @Column(name = "nom_prod")
    private String nombreProducto;

    @Getter @Setter @Column(name = "precio_prod")
    private float precioProducto;

    @Getter @Setter @Column(name = "estado_shoplist")
    private boolean estadoShoplist;
}
