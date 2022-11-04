package umg.proyectoio.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="detalle_producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    @Column(name = "id_prod")
    private int idProducto;

    @Getter @Setter @Column(name = "nom_prod")
    private String nombreProducto;

    @Getter @Setter @Column(name = "desc_prod")
    private String descProducto;

    @Getter @Setter @Column(name = "precio_prod")
    private float precioProducto;

    @Getter @Setter @Column(name = "estado_prod")
    private boolean estadoProducto;

}


